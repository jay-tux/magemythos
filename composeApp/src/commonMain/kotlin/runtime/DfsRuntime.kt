package runtime

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import runtime.ast.AstError
import runtime.ast.DeclarationType
import runtime.ast.Expression
import runtime.ast.ObjectValue
import runtime.ast.Pos
import runtime.ast.ReturnStmt
import runtime.ast.Statement
import runtime.ast.Value
import runtime.ast.Variable
import runtime.ast.VoidValue

class DfsRuntime private constructor(val at: Pos) {
    class ExecutionFailure(cause: Exception) : Exception(cause)

    private constructor(thisObj: ObjectValue?, invocationTarget: String, args: List<Value>, at: Pos, getChoice: (String) -> Value?, makeChoice: (String, Value) -> Unit) : this(at) {
        if(maybePushFrame(thisObj, invocationTarget, args, at)) {
            Library.choice = object : ChoiceScope {
                override fun getChoice(name: String): Value? = getChoice(name)
                override fun choiceMade(name: String, result: Value) = makeChoice(name, result)
                override fun invoke(what: ChoiceDesc) {
                    choice = what
                }
            }
        }
    }

    private constructor(expr: Expression, at: Pos) : this(at) {
        Stack.push(FrameEntry(mutableMapOf(), at))
        val stmt = ReturnStmt(expr, at)
        Stack.push(StmtEntry(stmt.mkState(), at))
        Library.choice = object : ChoiceScope {
            override fun getChoice(name: String): Value? = null
            override fun choiceMade(name: String, result: Value) = Unit
            override fun invoke(what: ChoiceDesc) {
                throw ChoiceDisabledException(what.requiredAt)
            }
        }
    }

    interface IStatementScope {
        fun onExpr(e: Expression)
        fun onMkBlock(body: List<Statement>, at: Pos)
        fun onMkLoop(body: List<Statement>, header: Map<String, Value>, at: Pos)
        fun onBreak(at: Pos)
        fun onReturn(v: Value)
        fun onAssign(type: DeclarationType, name: String, v: Value, at: Pos)
    }

    interface IStatementState {
        val stmt: Statement
        fun isFinished(): Boolean
        fun step(scope: IStatementScope)
        fun onValue(v: Value)
    }

    interface IExpressionScope {
        fun lookup(name: String, at: Pos): Value?
        fun onValue(v: Value)
        fun onCall(thisObj: ObjectValue?, target: String, args: List<Value>, at: Pos)
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
            frames.reversed().forEach { idx ->
                val scope = stack[idx] as ScopeEntry
                val v = scope.context[name]
                if(v != null) return v
            }

            return Runtime.getCache().getGlobal(name)
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
            while(stack.isNotEmpty() && stack.last() !is FrameEntry) {
                pop()
            }
            pop()
        }

        fun closestScope() = stack[frames.last()] as ScopeEntry

        fun buildTrace(): String {
            val trace = mutableListOf<Pos>()
            if(stack.isNotEmpty()) {
                trace.add(stack.last().pos)
                frames.asReversed().forEach { if (it != stack.size - 1) trace.add(stack[it].pos) }
            }
            return trace.joinToString("\n") { "\tat $it" }
        }

        fun dump() {
            Runtime.getLogger().logMessage("----------")
            stack.forEach {
                when(it) {
                    is ExprEntry -> Runtime.getLogger().logMessage("[STACK_DUMP]: Expression: ${it.expr}@${it.pos} (progress: ${it.progress.size}/${it.expr.argCount()})")
                    is BlockEntry -> Runtime.getLogger().logMessage("[STACK_DUMP]: Block: ${it.context.size} locals @${it.pos}")
                    is FrameEntry -> Runtime.getLogger().logMessage("[STACK_DUMP]: Frame: ${it.context.size} locals @${it.pos}")
                    is LoopEntry -> Runtime.getLogger().logMessage("[STACK_DUMP]: Loop: ${it.context.size} locals @${it.pos}")
                    is StmtEntry -> Runtime.getLogger().logMessage("[STACK_DUMP]: Statement: ${it.state::class.simpleName}@${it.pos} (finished? ${it.state.isFinished()})")
                }
            }
            Runtime.getLogger().logMessage("----------")
        }
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

    private inner class ExpressionScope : IExpressionScope {
        override fun lookup(name: String, at: Pos): Value? = Stack.lookup(name)?.value ?: Runtime.getCache().getType(name)?.construct(at)

        override fun onValue(v: Value) = this@DfsRuntime.onValue(v)

        override fun onCall(thisObj: ObjectValue?, target: String, args: List<Value>, at: Pos) {
            if(!maybePushFrame(thisObj, target, args, at)) {
                if(thisObj != null) {
                    throw MemberError(target, thisObj.type.name, at)
                }

                Library.invokeFunction(target, args, at)?.let {
                    onValue(it)
                } ?: Library.invokeChoice(target, args, at)?.let {
                    it.fold({ v -> choice = null; onValue(v) }) {}
                } ?: throw NoFunctionError(target, at)
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
            is ExprEntry -> {
//                Runtime.getLogger().logMessage("[RT_VALUE]: Value provided ($v); expression (${top.expr}@${top.pos}) at top")
                top.progress.add(v)
            }
            is StmtEntry -> {
//                Runtime.getLogger().logMessage("[RT_VALUE]: Value provided ($v); statement at top")
                top.state.onValue(v)
            }
            else -> {
//                Runtime.getLogger().logMessage("[RT_VALUE]: Value provided ($v); other at top")
                exprResult = v
            }
        }
    }

    private fun stepExpr(e: ExprEntry) {
//        Runtime.getLogger().logMessage("Stepping into expression: ${e.expr::class.simpleName}@${e.pos} (progress: ${e.progress.size}/${e.expr.argCount()})")
        if(e.progress.size < e.expr.argCount()) {
            Stack.push(ExprEntry(e.expr[e.progress.size, e.progress], mutableListOf(), e.pos))
        }
        else {
            Stack.pop()
            e.expr.mergeValues(e.progress, ExpressionScope(), e.expr.pos)
        }
    }

    private fun stepStmt(s: StmtEntry) {
//        Runtime.getLogger().logMessage("Stepping into statement: ${s.state::class.simpleName}@${s.pos} (finished? ${s.state.isFinished()})")
        if(!s.state.isFinished()) {
            s.state.step(StatementScope())
        }
        else {
            Stack.pop()
        }
    }

    private fun stepFrame(f: FrameEntry) {
//        Runtime.getLogger().logMessage("Stepping into frame@${f.pos} (#locals: ${f.context.size})")
        Stack.pop()
        if(!Stack.isEmpty()) {
            val next = Stack.peek()
            if (next is ExprEntry) {
                next.progress.add(exprResult)
                exprResult = VoidValue(at)
            }
        }
    }

    fun provideChoice(result: Value) {
        onValue(result)
        choice = null
    }

    private suspend fun <T> stackTraced(block: suspend () -> T): T {
        try {
            return block()
        }
        catch(e: RuntimeError) {
            Runtime.getLogger().logError("${e.message ?: "Unknown runtime error"}\n${Stack.buildTrace()}")
            throw ExecutionFailure(e)
        }
        catch(e: AstError) {
            Runtime.getLogger().logError("Unexpected AST error during runtime:\n${e.message ?: "Unknown AST error"}\n${Stack.buildTrace()}")
            throw ExecutionFailure(e)
        }
        catch(e: Exception) {
             Runtime.getLogger().logError("Unexpected JVM error during runtime:\n${e.message ?: "Unknown JVM error"}\n${Stack.buildTrace()}\n\n${e.stackTrace.joinToString("\n")}")
            throw ExecutionFailure(e)
        }
    }

    suspend fun runUntilChoice(): Either<ChoiceDesc, Value> = stackTraced {
        while(!Stack.isEmpty() && choice == null) {
            when(val top = Stack.peek()) {
                is ExprEntry -> {
                    stepExpr(top)
                }
                is StmtEntry -> {
                    stepStmt(top)
                }
                is FrameEntry -> {
                    stepFrame(top)
                }
                is BlockEntry -> {
                    Stack.pop()
                }
                is LoopEntry -> {
                    Stack.pop()
                }
            }
        }

        choice?.left() ?: run {
            Library.choice = null
            Library.character = null
            instance = null
            exprResult.right()
        }
    }

    suspend fun run(): Value = stackTraced {
        var res = runUntilChoice()
        while(res.isLeft()) {
            if(choice != null) throw RuntimeInternalError("Run-until-choice hit a choice it couldn't resolve")
            res = runUntilChoice()
        }
        res.getOrNull() ?: throw RuntimeInternalError("Run-until-choice failed to provide a value")
    }

    companion object {
        private var instance: DfsRuntime? = null

        fun isRunning() = instance != null

        fun getInstance(): DfsRuntime = instance ?: throw IllegalStateException("No runtime available")

        sealed class CharacterOrHelpers {
            data class UsingCharacter(val c: Character) : CharacterOrHelpers()
            data class UsingHelpers(val getChoice: (String) -> Value?, val makeChoice: (String, Value) -> Unit) : CharacterOrHelpers()

            companion object {
                fun Character.prepare(): CharacterOrHelpers = UsingCharacter(this)
                fun fromFunctions(getChoice: (String) -> Value?, makeChoice: (String, Value) -> Unit): CharacterOrHelpers = UsingHelpers(getChoice, makeChoice)
            }
        }

        fun ready(thisObj: ObjectValue? = null, invocationTarget: String, args: List<Value> = listOf(), at: Pos, helpers: CharacterOrHelpers) {
            if(instance != null) throw IllegalStateException("Runtime already started")
            Runtime.getLogger().logMessage("[DFSRUNTIME]: Runtime started with this=${thisObj}; invocationTarget=$invocationTarget; args=$args")
            when(helpers) {
                is CharacterOrHelpers.UsingCharacter -> {
                    Library.character = helpers.c
                    instance = DfsRuntime(thisObj, invocationTarget, args, at, { helpers.c.retrieveChoice(it) }) { n, v -> helpers.c.registerChoice(n, v) }
                }
                is CharacterOrHelpers.UsingHelpers -> {
                    instance = DfsRuntime(thisObj, invocationTarget, args, at, helpers.getChoice, helpers.makeChoice)
                }
            }
        }

        suspend fun evaluate(e: Expression, at: Pos): Value {
            return DfsRuntime(e, at).run()
        }
    }
}