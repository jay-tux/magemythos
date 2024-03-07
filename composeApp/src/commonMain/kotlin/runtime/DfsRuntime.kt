package runtime

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import runtime.ast.DeclarationType
import runtime.ast.Expression
import runtime.ast.ObjectValue
import runtime.ast.Pos
import runtime.ast.Statement
import runtime.ast.Value
import runtime.ast.Variable
import runtime.ast.VoidValue

class DfsRuntime private constructor(thisObj: ObjectValue?, invocationTarget: String, args: List<Value>, val at: Pos) {
    interface IStatementScope {
        fun onExpr(e: Expression)
        fun onMkBlock(body: List<Statement>, at: Pos)
        fun onMkLoop(body: List<Statement>, header: Map<String, Value>, at: Pos)
        fun onBreak(at: Pos)
        fun onReturn(v: Value)
        fun onAssign(type: DeclarationType, name: String, v: Value, at: Pos)
    }

    interface IStatementState {
        fun isFinished(): Boolean
        fun step(scope: IStatementScope)
        fun onValue(v: Value)
    }

    sealed class StackEntry(val pos: Pos)
    inner class ExprEntry(val expr: Expression, val progress: MutableList<Value>, pos: Pos) : StackEntry(pos)
    inner class StmtEntry(val state: IStatementState, pos: Pos) : StackEntry(pos)
    sealed class ScopeEntry(val context: MutableMap<String, Variable>, pos: Pos) : StackEntry(pos)
    inner class FrameEntry(context: MutableMap<String, Variable>, pos: Pos) : ScopeEntry(context, pos)
    inner class LoopEntry(context: MutableMap<String, Variable>, pos: Pos) : ScopeEntry(context, pos)
    inner class BlockEntry(context: MutableMap<String, Variable>, pos: Pos) : ScopeEntry(context, pos)

    private object Stack {
        private val stack = mutableListOf<StackEntry>()
        private val frames = mutableListOf<Int>()

        fun isEmpty() = stack.isEmpty()
        fun peek() = stack.last()

        fun push(entry: StackEntry) {
            when(entry) {
                is ScopeEntry -> {
                    frames.add(stack.size)
                    stack.add(entry)
                }
                else -> stack.add(entry)
            }
        }

        fun pop() {
            if(stack.removeLast() is ScopeEntry) {
                frames.removeLast()
            }
        }

        fun lookup(name: String): Variable? {
            val it = frames.reversed()
            for(i in it) {
                val frame = stack[i]
                if(frame is FrameEntry) {
                    val v = frame.context[name]
                    if(v != null) return v
                }
            }
            return null
        }

        fun performBreak() {
            val it = frames.reversed()
            for(i in it) {
                val frame = stack[i]
                if(frame is FrameEntry) {
                    throw BreakError(frame.pos)
                }
                if(frame is LoopEntry) {
                    val actual = stack.filterIndexed { idx, _ -> idx < i }
                    stack.clear()
                    stack.addAll(actual)
                    return
                }
            }
        }

        fun performReturn() {
            val it = frames.reversed()
            for(i in it) {
                val frame = stack[i]
                if (frame is FrameEntry) {
                    val actual = stack.filterIndexed { idx, _ -> idx < i }
                    stack.clear()
                    stack.addAll(actual)
                    return
                }
            }
        }

        fun closestScope() = stack[frames.last()] as ScopeEntry
    }

    private var exprResult: Value = VoidValue(at)
    private var choice: ChoiceDesc? = null

    private inner class StatementScope : IStatementScope {
        override fun onExpr(e: Expression) = Stack.push(ExprEntry(e, mutableListOf(), e.pos))

        override fun onMkBlock(body: List<Statement>, at: Pos) {
            Stack.push(BlockEntry(mutableMapOf(), at))
            body.reversed().forEach { Stack.push(StmtEntry(it.mkState(), it.pos)) }
        }

        override fun onMkLoop(body: List<Statement>, header: Map<String, Value>, at: Pos) {
            Stack.push(LoopEntry(header.map { (k, v) -> k to Variable(k, v, false, at) }.toMap().toMutableMap(), at))
            body.reversed().forEach { Stack.push(StmtEntry(it.mkState(), it.pos)) }
        }

        override fun onBreak(at: Pos) = Stack.performBreak()

        override fun onReturn(v: Value) {
            exprResult = v
            Stack.performReturn()
        }

        override fun onAssign(type: DeclarationType, name: String, v: Value, at: Pos) {
            when(type) {
                DeclarationType.ASSIGN -> {
                    Stack.lookup(name)?.let{
                        if(!it.mutable) throw ImmutableError(name, at)
                        it.value = v
                    } ?: throw VariableError(name, at)
                }
                else -> {
                    val scope = Stack.closestScope()
                    if(scope.context.containsKey(name)) {
                        throw RedeclarationError(name, scope.context[name]!!.pos, at)
                    }
                    else {
                        scope.context[name] = Variable(name, v, type == DeclarationType.VAR, at)
                    }
                }
            }
        }
    }

    init {
        if(maybePushFrame(thisObj, invocationTarget, args, at)) {
            Library.choice = object : ChoiceScope {
                override fun invoke(what: ChoiceDesc) {
                    choice = what
                }
            }
        }
    }

    private fun maybePushFrame(thisObj: ObjectValue?, invocationTarget: String, args: List<Value>, at: Pos): Boolean {
        val entry = FrameEntry(mutableMapOf(), at)
        val target = if(thisObj != null) {
            thisObj.type.members.find{ it.name == invocationTarget }?.also {
                entry.context["this"] = Variable("this", thisObj, false, at)
                thisObj.value.forEach { (k, v) -> entry.context[k] = v }
            }
        } else {
            Runtime.getCache().getFunction(invocationTarget)
        }

        if(target != null) {
            val argExpect = target.params
            if(argExpect.size != args.size) {
                throw ArgumentCountError(invocationTarget, args.size, argExpect.size, at)
            }
            argExpect.forEachIndexed { i, name ->
                entry.context[name] = Variable(name, args[i], false, at)
            }

            Stack.push(entry)
            target.body.reversed().forEach { Stack.push(StmtEntry(it.mkState(), it.pos)) }
        }

        return target != null
    }

    private fun onValue(v: Value) {
        when(val top = Stack.peek()) {
            is ExprEntry -> top.progress.add(v)
            is StmtEntry -> top.state.onValue(v)
            else -> exprResult = v
        }
    }

    private fun onCall(thisObj: ObjectValue?, name: String, args: List<Value>, at: Pos) {
        if(!maybePushFrame(thisObj, name, args, at)) {
            if(thisObj != null) {
                throw MemberError(name, thisObj.type.name, at)
            }

            Library.invokeFunction(name, args, at)?.let {
                onValue(it)
            } ?: Library.invokeChoice(name, args, at) ?: throw NoFunctionError(name, at)
        }
    }

    private fun stepExpr(e: ExprEntry) {
        if(e.progress.size < e.expr.argCount()) {
            Stack.push(ExprEntry(e.expr[e.progress.size, e.progress], mutableListOf(), e.pos))
        }
        else {
            Stack.pop()
            e.expr.mergeValues(e.progress, { Stack.lookup(it)?.value }, { onValue(it) }, { thisObj, name, args, at -> onCall(thisObj, name, args, at) }, e.expr.pos)
        }
    }

    private fun stepStmt(s: StmtEntry) {
        if(!s.state.isFinished()) {
            s.state.step(StatementScope())
        }
        else {
            Stack.pop()
        }
    }

    private fun stepFrame(f: FrameEntry) {
        Stack.pop()
        val next = Stack.peek()
        if(next is ExprEntry) {
            next.progress.add(exprResult)
            exprResult = VoidValue(at)
        }
    }

    fun provideChoice(result: Value) {
        onValue(result)
    }

    suspend fun runUntilChoice(): Either<ChoiceDesc, Value> {
        while(!Stack.isEmpty() && choice == null) {
            when(val top = Stack.peek()) {
                is ExprEntry -> stepExpr(top)
                is StmtEntry -> stepStmt(top)
                is FrameEntry -> stepFrame(top)
                is BlockEntry -> Stack.pop()
                is LoopEntry -> Stack.pop()
            }
        }

        return choice?.left() ?: run {
            Library.choice = null
            instance = null
            exprResult.right()
        }
    }

    companion object {
        private var instance: DfsRuntime? = null

        fun isRunning() = instance != null

        fun getInstance(): DfsRuntime = instance ?: throw IllegalStateException("No runtime available")

        fun ready(thisObj: ObjectValue? = null, invocationTarget: String, args: List<Value> = listOf(), at: Pos) {
            if(instance != null) throw IllegalStateException("Runtime already started")
            instance = DfsRuntime(thisObj, invocationTarget, args, at)
        }
    }
}