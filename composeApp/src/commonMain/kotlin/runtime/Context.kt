package runtime

import runtime.ast.BinaryExpression
import runtime.ast.BoolValue
import runtime.ast.CallExpression
import runtime.ast.Expression
import runtime.ast.FunDeclaration
import runtime.ast.IndexExpression
import runtime.ast.IntValue
import runtime.ast.ListExpression
import runtime.ast.ListValue
import runtime.ast.LiteralExpression
import runtime.ast.MemberCallExpression
import runtime.ast.MemberExpression
import runtime.ast.ObjectValue
import runtime.ast.Pos
import runtime.ast.RangeExpression
import runtime.ast.RangeValue
import runtime.ast.StringValue
import runtime.ast.TernaryExpression
import runtime.ast.TypeDeclaration
import runtime.ast.UnaryExpression
import runtime.ast.Value
import runtime.ast.VariableExpression

sealed class ExecutionIterator {
    abstract fun hasFinished(): Boolean
    abstract fun step()
    abstract fun finalValue(): Value
}

sealed class ExprExecutionIterator : ExecutionIterator() {
    abstract val parent: ExecutionIterator
    abstract fun currentlyExecuting(): ExecutionIterator
    fun update(): ExecutionIterator {
        if(!hasFinished()) step()
        return currentlyExecuting()
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

            is VariableExpression -> onFinish(parent.lookup(subExpr.name)?.value ?: throw VariableError(subExpr.name, subExpr.pos))
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
    MemberInvocation(this, it, args)
} ?: NormalInvocation(this, args)

fun TypeDeclaration.makeInvocation(obj: ObjectValue, member: String, args: List<Value>, at: Pos): Invocation =
    members.find { it.name == member }?.makeInvocation(obj, args, at) ?: throw MemberError(member, name, at)

class Context(private val parent: Context? = null, private val thisObj: ObjectValue?, val pos: Pos) {
    private val locals = thisObj?.value?.toMutableMap() ?: mutableMapOf()
    private val members = thisObj?.type?.members?.associateBy { it.name } ?: mapOf()

    constructor(parent: Context?, pos: Pos) : this(parent, null, pos)

    fun lookup(name: String): Variable? {
        return locals[name] ?: parent?.lookup(name)
    }

    fun getInvocation(name: String, args: List<Value>, pos: Pos): Invocation {
        return members[name]?.makeInvocation(thisObj ?: throw RuntimeInternalError("No thisObj when invoking a member function"), args, pos) ?:
        // TODO: try to find it as a global function
        // TODO: try to find it as a library function
            throw MethodError(name, pos)
    }

    fun getEvaluator(): ExecutionIterator = TODO()
}

class Variable(val name: String, v: Value, val mutable: Boolean, pos: Pos) {
    var value: Value = v
        private set
}