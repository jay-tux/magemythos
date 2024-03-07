package runtime

import ILogger
import Ref
import Ref.Companion.makeRef
import runtime.ast.AssignmentStmt
import runtime.ast.BinaryExpression
import runtime.ast.BoolValue
import runtime.ast.BreakStmt
import runtime.ast.CallExpression
import runtime.ast.DeclarationType
import runtime.ast.ExprStmt
import runtime.ast.Expression
import runtime.ast.ForStmt
import runtime.ast.FunDeclaration
import runtime.ast.GlobalDeclaration
import runtime.ast.IfStmt
import runtime.ast.IndexExpression
import runtime.ast.IntValue
import runtime.ast.ListExpression
import runtime.ast.ListValue
import runtime.ast.LiteralExpression
import runtime.ast.MappedIntExpression
import runtime.ast.MemberCallExpression
import runtime.ast.MemberExpression
import runtime.ast.ObjectValue
import runtime.ast.Pos
import runtime.ast.RangeExpression
import runtime.ast.RangeValue
import runtime.ast.ReturnStmt
import runtime.ast.Statement
import runtime.ast.StringValue
import runtime.ast.TernaryExpression
import runtime.ast.TypeDeclaration
import runtime.ast.UnaryExpression
import runtime.ast.Value
import runtime.ast.VariableExpression
import runtime.ast.VoidValue
import runtime.ast.WhileStmt
import java.util.Queue
import java.util.ArrayDeque

sealed class ExecutionIterator {
    abstract fun hasFinished(): Boolean
    abstract fun step()
    abstract fun finalValue(): Value

    fun runUntilCompletion(): Value {
        while(!hasFinished()) step()
        return finalValue()
    }
}

sealed class ExprExecutionIterator : ExecutionIterator() {
    abstract val parent: ExecutionIterator
    abstract fun currentlyExecuting(): ExecutionIterator
    fun update(): ExecutionIterator {
        if(!hasFinished()) step()
        return currentlyExecuting()
    }
}

sealed class StmtExecutionIterator : ExecutionIterator() {
    abstract val context: Context
    var stopped: Boolean = false
        private set

    protected abstract fun internalFinished(): Boolean

    override fun hasFinished(): Boolean = stopped || internalFinished()

    fun interrupt() {
        stopped = true
    }
}

class ExpressionContext(private val parent: Context, private val e: Expression, private val onCall: (Invocation) -> ExecutionIterator) {
    private fun getEvaluator(
        par: ExecutionIterator,
        subExpr: Expression,
        onFinish: (Value) -> Unit,
        onRecurse: (ExprExecutionIterator) -> Unit
    ) {
        when (subExpr) {
            is BinaryExpression -> onRecurse(CallbackIterator(
                par,
                PartialIterator(
                    par,
                    mutableListOf(),
                    mutableListOf(subExpr.left, subExpr.right),
                    subExpr.pos
                )
            ) { subExpr.op.withValues(it[0], it[1], subExpr.pos) })

            is CallExpression -> onRecurse(InvocationIterator(
                par,
                subExpr.name,
                null,
                PartialIterator(par, mutableListOf(), subExpr.args.toMutableList(), subExpr.pos),
                subExpr.pos
            ))
            is IndexExpression -> onRecurse(CallbackIterator(
                par,
                PartialIterator(
                    par,
                    mutableListOf(),
                    mutableListOf(subExpr.target, subExpr.index),
                    e.pos
                )
            ) {
                it[0].requireOrNull<ListValue>()?.let { l ->
                    it[1].require<IntValue>("int", it[1].pos).let { i ->
                        l.value[i.value]
                    }
                } ?: it[0].require<ObjectValue>("list or object", it[0].pos).let { o ->
                    it[1].require<StringValue>("string", it[1].pos).let { s ->
                        o.value[s.value]?.value ?: throw FieldError(o.type.name, s.value, s.pos)
                    }
                }
            }
            )

            is LiteralExpression -> onFinish(subExpr.value)
            is MemberCallExpression -> onRecurse(InvocationIterator(
                par,
                subExpr.member,
                PartialIterator(par, mutableListOf(), mutableListOf(subExpr.target), subExpr.pos),
                PartialIterator(par, mutableListOf(), subExpr.args.toMutableList(), subExpr.pos),
                subExpr.pos
            ))
            is MemberExpression -> onRecurse(CallbackIterator(
                par,
                PartialIterator(
                    par,
                    mutableListOf(),
                    mutableListOf(subExpr.target),
                    subExpr.pos
                )
            ) {
                it[0].require<ObjectValue>("object", it[0].pos).let { o ->
                    o.value[subExpr.member]?.value ?: throw FieldError(
                        o.type.name,
                        subExpr.member,
                        subExpr.pos
                    )
                }
            })

            is RangeExpression -> onRecurse(CallbackIterator(
                par,
                PartialIterator(
                    par,
                    mutableListOf(),
                    mutableListOf(subExpr.start, subExpr.end),
                    subExpr.pos
                )
            ) {
                val start = it[0].require<IntValue>("int", it[0].pos).value
                val end = it[1].require<IntValue>("int", it[1].pos).value
                RangeValue(start, if (subExpr.inclusive) end else (end - 1), subExpr.pos)
            })

            is ListExpression -> onRecurse(
                PartialIterator(
                    par,
                    mutableListOf(),
                    subExpr.values.toMutableList(),
                    e.pos
                )
            )

            is TernaryExpression -> onRecurse(
                TernaryIterator(
                    par,
                    PartialIterator(par, mutableListOf(), mutableListOf(subExpr.cond), subExpr.pos),
                    PartialIterator(
                        par,
                        mutableListOf(),
                        mutableListOf(subExpr.bTrue),
                        subExpr.pos
                    ),
                    PartialIterator(
                        par,
                        mutableListOf(),
                        mutableListOf(subExpr.bFalse),
                        subExpr.pos
                    ),
                    subExpr.pos
                )
            )

            is UnaryExpression -> onRecurse(
                CallbackIterator(
                    par,
                    PartialIterator(
                        par,
                        mutableListOf(),
                        mutableListOf(subExpr.target),
                        subExpr.pos
                    )
                ) { subExpr.op.withValue(it[0], subExpr.pos) }
            )

            is VariableExpression ->
                parent.lookup(subExpr.name)?.value?.let(onFinish) ?:
                Runtime.getCache().getType(subExpr.name)?.construct(subExpr.pos) { exprs, after ->
                    CallbackIterator(par, PartialIterator(par, mutableListOf(), exprs.toMutableList(), subExpr.pos)) { after(it) }
                }?.let(onRecurse) ?: let {
                    throw VariableError(subExpr.name, subExpr.pos)
                }

            is MappedIntExpression -> onRecurse(
                CallbackIterator(
                    par,
                    PartialIterator(
                        par,
                        mutableListOf(),
                        mutableListOf(subExpr.target),
                        subExpr.pos
                    )
                ) {
                    it[0].require<IntValue>("int", it[0].pos).let { i -> subExpr.map(i) }
                }
            )
        }
    }

    private inner class RootIterator(private val actual: ExprExecutionIterator) : ExprExecutionIterator() {
        override val parent: ExecutionIterator = actual.parent
        override fun hasFinished(): Boolean = actual.hasFinished()
        override fun step() = actual.step()
        override fun finalValue(): Value {
            evaluator = null
            return actual.finalValue()
        }

        override fun currentlyExecuting(): ExecutionIterator = actual.currentlyExecuting()
    }

    private inner class FinishedIterator(override val parent: ExecutionIterator, val value: Value) : ExprExecutionIterator() {
        override fun hasFinished(): Boolean = true
        override fun step() = Unit
        override fun finalValue(): Value = value

        override fun currentlyExecuting(): ExecutionIterator = parent
    }

    private inner class PartialIterator(
        override var parent: ExecutionIterator, private val done: MutableList<Value>,
        private val todo: MutableList<Expression>, val at: Pos
    ) :
        ExprExecutionIterator() {
        private var waitingFor: ExprExecutionIterator? = null

        override fun hasFinished(): Boolean = todo.isEmpty()
        override fun step() {
            waitingFor?.let {
                if (it.hasFinished()) {
                    done.add(it.finalValue())
                    waitingFor = null
                } else {
                    it.step()
                }
            } ?: run {
                if(todo.isEmpty()) return@run

                val next = todo.removeAt(0)
                getEvaluator(this, next, { done.add(it) }){ waitingFor = it }
            }
        }
        override fun finalValue(): ListValue = ListValue(done, at)

        override fun currentlyExecuting(): ExecutionIterator = waitingFor?.currentlyExecuting() ?: (if(hasFinished()) parent else this)
    }

    private inner class CallbackIterator(
        override val parent: ExecutionIterator,
        val elements: PartialIterator,
        val post: (List<Value>) -> Value
    ) :
        ExprExecutionIterator() {
        init {
            elements.parent = this
        }
        override fun hasFinished(): Boolean = elements.hasFinished()
        override fun step() = elements.step()
        override fun finalValue(): Value = post(elements.finalValue().value)

        override fun currentlyExecuting(): ExecutionIterator =
            if(hasFinished()) parent else elements.currentlyExecuting()
    }

    private inner class TernaryIterator(
        override val parent: ExecutionIterator,
        val cond: PartialIterator,
        val bT: PartialIterator,
        val bF: PartialIterator,
        val at: Pos
    ) :
        ExprExecutionIterator() {

        private var state = false

        override fun hasFinished(): Boolean = cond.hasFinished() && (state && bT.hasFinished() || !state && bF.hasFinished())
        override fun step() {
            if(!cond.hasFinished()) {
                cond.step()
                if(cond.hasFinished()) {
                    val condition = cond.finalValue().value[0].require<BoolValue>("boolean", at)
                    state = condition.value
                }
            }
            else {
                if(state) bT.step() else bF.step()
            }
        }
        override fun finalValue(): Value = if(state) bT.finalValue() else bF.finalValue()

        override fun currentlyExecuting(): ExecutionIterator =
            if(hasFinished()) parent else if(cond.hasFinished()) (if(state) bT else bF).currentlyExecuting() else cond.currentlyExecuting()
    }

    private inner class InvocationIterator(
        override val parent: ExecutionIterator,
        private val target: String,
        private val scopeIterator: ExprExecutionIterator?,
        private val argsIterator: PartialIterator,
        private val at: Pos
    ) :
        ExprExecutionIterator() {

        private var invocIterator: ExecutionIterator? = null
        override fun currentlyExecuting(): ExecutionIterator {
            if(scopeIterator != null && !scopeIterator.hasFinished())
                return scopeIterator.currentlyExecuting()
            if(!argsIterator.hasFinished())
                return argsIterator.currentlyExecuting()
            return invocIterator?.let {
                if(!it.hasFinished()) it else null
            } ?: parent
        }
        override fun hasFinished(): Boolean =
            scopeIterator?.hasFinished() != false && argsIterator.hasFinished() && (invocIterator?.hasFinished() != false)
        override fun step() {
            if(scopeIterator != null && !scopeIterator.hasFinished()) {
                scopeIterator.step()
            }
            else if(!argsIterator.hasFinished()) {
                argsIterator.step()
                if(argsIterator.hasFinished()) {
                    val invoc = scopeIterator?.let {
                        val obj = it.finalValue().require<ObjectValue>("object", at)
                        obj.type.makeInvocation(obj, target, argsIterator.finalValue().value, at)
                    } ?: this@ExpressionContext.parent.getInvocation(target, argsIterator.finalValue().value, at)
                    invocIterator = onCall(invoc)
                }
            }
            else {
                invocIterator?.step()
            }
        }
        override fun finalValue(): Value {
            return invocIterator?.finalValue() ?: throw RuntimeInternalError("Invocation not finished")
        }
    }

    private var evaluator: RootIterator? = null

    fun getEvaluator(): ExprExecutionIterator {
        return evaluator ?: run {
            val par = parent.getEvaluator()
            getEvaluator(par, e, { evaluator = RootIterator(FinishedIterator(par, it)) }) {
                evaluator = RootIterator(it)
            }
            return evaluator!!
        }
    }
}

fun FunDeclaration.makeInvocation(thisObj: ObjectValue?, args: List<Value>, at: Pos): Invocation = thisObj?.let {
    MemberInvocation(this, it, args, at)
} ?: NormalInvocation(this, args, at)

fun Type.makeInvocation(obj: ObjectValue, member: String, args: List<Value>, at: Pos): Invocation =
    members.find { it.name == member }?.makeInvocation(obj, args, at) ?: throw MemberError(member, name, at)

class Context(
    private val parent: Context? = null,
    private val thisObj: ObjectValue? = null, private val executing: List<Statement>,
    private val isLoopBase: Boolean = false, private val isFunBase: Boolean = false,
    val pos: Pos
)
{
    private val locals = thisObj?.value?.toMutableMap() ?: mutableMapOf()
    private val members = thisObj?.type?.members?.associateBy { it.name } ?: mapOf()

    private var currentEvaluator: StmtExecutionIterator? = null

    var returnValue: Value? = null
        private set

    private fun canBreak(): Boolean = isLoopBase || parent?.canBreak() == true

    private fun onReturn(v: Value?) {
        var curr = this

        do {
            curr.returnValue = v
            curr.currentEvaluator?.interrupt()
            curr = curr.parent ?: break
        } while(!curr.isFunBase)
    }

    private fun onBreak(at: Pos) {
        if(!canBreak()) throw BreakError(at)
        var curr = this

        do {
            curr.currentEvaluator?.interrupt()
            curr = curr.parent ?: break
        } while(!curr.isLoopBase)
    }

    private fun getInvocationCallback(i: Invocation, parent: ExecutionIterator): ExecutionIterator {
        i.checkArgCount() // throws on errors
        val args = i.mergeArgs()
        return when(i) {
            is NormalInvocation -> {
                val ctx = Context(this@Context, thisObj, i.target.body, false, true, i.pos)
                args.forEach { (n, v) -> ctx.declare(n, v.value, true, v.pos) }
                ctx.getEvaluator()
            }
            is MemberInvocation -> {
                val ctx = Context(this@Context, i.scope, i.target.body, false, true, i.pos)
                args.forEach { (n, v) -> ctx.declare(n, v.value, true, v.pos) }
                ctx.getEvaluator()
            }
            is LibraryInvocation -> {
                Library.invoke(i, parent)
            }
        }
    }

    private inner class ExprBasedIterator(override val context: Context, e: Expression?, private val at: Pos, private val onFinish: (Value?) -> Unit) : StmtExecutionIterator() {
        private val it: ExecutionIterator?

        init {
            it = e?.let {
                val sub = ExpressionContext(this@Context, it) { i -> getInvocationCallback(i, this) }
                sub.getEvaluator()
            }
        }

        override fun internalFinished(): Boolean = it?.hasFinished() ?: true

        override fun step() {
            it?.step()
        }

        override fun finalValue(): Value = it?.finalValue() ?: VoidValue(at)
    }

    private inner class StepBasedIterator(override val context: Context, private val at: Pos, val generator: (Ref<Value?>) -> Sequence<ExecutionIterator>) : StmtExecutionIterator() {
        private val ref = (null as Value?).makeRef()
        private val seq = generator(ref).iterator()
        private var curr: ExecutionIterator? = null

        override fun internalFinished(): Boolean = !seq.hasNext() && curr?.hasFinished() != false

        override fun step() {
            if(curr == null || curr?.hasFinished() == true) {
                ref.set(curr?.finalValue())
                if(seq.hasNext()) curr = seq.next()
            }

            curr?.step()
        }

        override fun finalValue(): Value = curr?.finalValue() ?: VoidValue(at)

    }

    private fun stepInto(e: ExprStmt): ExecutionIterator = ExprBasedIterator(this, e.expr, e.pos) {}

    private fun stepInto(a: AssignmentStmt): ExecutionIterator = ExprBasedIterator(this, a.expr, a.pos) {
        if(it == null || it is VoidValue)
            throw NoValueError(a.expr.pos)

        val v = lookup(a.name)

        when(a.type) {
            DeclarationType.ASSIGN -> {
                if(v == null) throw VariableError(a.name, a.pos)
                else v.update(it, a.pos)
            }
            else -> {
                declare(a.name, it, a.type == DeclarationType.CONST, a.pos)
            }
        }
    }

    private fun stepInto(r: ReturnStmt): ExecutionIterator = ExprBasedIterator(this, r.expr, r.pos) {
        onReturn(it)
    }

    private fun stepInto(b: BreakStmt): ExecutionIterator = ExprBasedIterator(this, null, b.pos) {
        onBreak(b.pos)
    }

    private fun stepInto(c: IfStmt): ExecutionIterator = StepBasedIterator(this, c.pos) { prev ->
        sequence {
            yield(ExprBasedIterator(this@Context, c.condition, c.condition.pos) {})

            prev.get()?.let {
                val cond = it.require<BoolValue>("bool", c.condition.pos).value
                if(cond)
                    yield(Context(this@Context, thisObj, c.bodyTrue, pos = c.pos).getEvaluator())
                else if(c.bodyFalse != null)
                    yield(Context(this@Context, thisObj, c.bodyFalse, pos = c.pos).getEvaluator())
            } ?: throw RuntimeInternalError("Null-result in if's condition")
        }
    }

    private fun stepInto(c: WhileStmt): ExecutionIterator = StepBasedIterator(this, c.pos) { prev ->
        val check = {
            prev.get()?.require<BoolValue>("bool", c.condition.pos)?.value ?:
                throw RuntimeInternalError("Null-value in while's condition")
        }

        sequence {
            yield(ExprBasedIterator(this@Context, c.condition, c.condition.pos) {})
            while(check()) {
                val it = Context(this@Context, thisObj, c.body, true, pos = c.pos).getEvaluator()
                yield(it)
                if(it.stopped) break

                yield(ExprBasedIterator(this@Context, c.condition, c.condition.pos) {})
            }
        }
    }

    private fun stepInto(c: ForStmt): ExecutionIterator = StepBasedIterator(this, c.pos) { prev ->
        sequence {
            yield(ExprBasedIterator(this@Context, c.set, c.set.pos) {})
            val set = prev.get() ?: throw RuntimeInternalError("Null-value in for's set")

            set.requireOrNull<ListValue>()?.let {
                for(v in it.value) {
                    val ctx = Context(this@Context, thisObj, c.body, true, pos = c.pos)
                    ctx.declare(c.name, v, true, c.set.pos)
                    val iter = ctx.getEvaluator()
                    yield(iter)

                    if(iter.stopped) break
                }
            } ?: set.require<RangeValue>("list or range", set.pos).let {
                var i = it.start
                while(i <= it.endIncl) {
                    val ctx = Context(this@Context, thisObj, c.body, true, pos = c.pos)
                    ctx.declare(c.name, IntValue(i, c.set.pos), true, c.set.pos)
                    val iter = ctx.getEvaluator()
                    yield(iter)

                    if(iter.stopped) break
                    i++
                }
            }
        }
    }

    fun lookup(name: String): Variable? {
        return locals[name] ?: if(parent == null) Runtime.getCache().getGlobal(name) else parent.lookup(name)
    }

    fun declare(name: String, value: Value, immutable: Boolean, at: Pos) {
        locals[name]?.let {
            throw RedeclarationError(name, it.pos, at)
        } ?: locals.put(name, Variable(name, value, !immutable, at))
    }

    fun getInvocation(name: String, args: List<Value>, pos: Pos): Invocation {
        return members[name]?.makeInvocation(thisObj ?: throw RuntimeInternalError("No thisObj when invoking a member function"), args, pos) ?:
            Runtime.getCache().getFunction(name)?.makeInvocation(null, args, pos) ?:
            Library.invocationFor(name, args, pos) ?:
            throw MethodError(name, pos)
    }

    fun getEvaluator(): StmtExecutionIterator = StepBasedIterator(this, pos) {
        sequence {
            for(s in executing) {
                yield(when(s) {
                    is ExprStmt -> stepInto(s)
                    is AssignmentStmt -> stepInto(s)
                    is ReturnStmt -> stepInto(s)
                    is BreakStmt -> stepInto(s)
                    is IfStmt -> stepInto(s)
                    is WhileStmt -> stepInto(s)
                    is ForStmt -> stepInto(s)
                })
            }
        }
    }

    interface InteractiveContext {
        fun context(): Context
        fun getIterator(): StmtExecutionIterator
        fun attemptInvocation(obj: ObjectValue?, name: String, args: List<Value>, at: Pos): ExecutionIterator?
    }

    private inner class InteractiveExecutionIterator(val ctx: InteractiveContextImpl) : StmtExecutionIterator() {
        var current: ExecutionIterator? = null
        val iterator = ctx.seq.iterator()

        override val context: Context
            get() = ctx.context()

        override fun internalFinished(): Boolean = current == null && !iterator.hasNext()

        override fun step() {
            current?.let {
                it.step()
                if(it.hasFinished()) {
                    ctx.ref.set(it.finalValue())
                    current = null
                }
            } ?: if(iterator.hasNext()) {
                current = iterator.next().invoke(ctx)
            } else {}
        }

        override fun finalValue(): Value = VoidValue(pos)
    }

    private inner class InteractiveContextImpl(val ref: Ref<Value>, val seq: Sequence<InteractiveContext.() -> ExecutionIterator?>) : InteractiveContext {
        val iterator = InteractiveExecutionIterator(this)
        override fun context(): Context = this@Context

        override fun getIterator(): StmtExecutionIterator = iterator
        override fun attemptInvocation(obj: ObjectValue?, name: String, args: List<Value>, at: Pos): ExecutionIterator? {
            val fn = if(obj != null) {
                obj.type.members.find { it.name == name }?.makeInvocation(obj, args, at)
            } else {
                Runtime.getCache().getFunction(name)?.makeInvocation(null, args, at)
            }

            return fn?.let {
                getInvocationCallback(it, iterator)
            }
        }
    }

    companion object {
        fun performAll(ref: Ref<Value>, callbacks: Sequence<InteractiveContext.() -> ExecutionIterator?>): StmtExecutionIterator {
            val parent = Context(null, null, emptyList(), pos = Pos("<runtime::performAll>", 0, 0))
            val ctx = parent.InteractiveContextImpl(ref, callbacks)
            return ctx.getIterator()
        }
    }
}

class Variable(val name: String, v: Value, val mutable: Boolean, val pos: Pos) {
    var value: Value = v
        private set

    fun update(v: Value, at: Pos) {
        if(mutable) value = v
        else throw ImmutableError(name, at)
    }

    companion object {
        fun GlobalDeclaration.toVariable(): Variable {
            val ctx = Context(executing = listOf(ReturnStmt(value, value.pos)), pos = pos)
            val eval = ctx.getEvaluator()
            return Variable(name, eval.runUntilCompletion(), true, pos)
        }
    }
}