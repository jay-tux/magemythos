package runtime

import runtime.ast.BinaryExpression
import runtime.ast.BoolValue
import runtime.ast.CallExpression
import runtime.ast.Expression
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
import runtime.ast.RecursiveExpression
import runtime.ast.StringValue
import runtime.ast.TernaryExpression
import runtime.ast.UnaryExpression
import runtime.ast.Value
import runtime.ast.VariableExpression
import java.util.Stack

data class Choice(val name: String, val desc: String, val corresponding: Value)
typealias ChoiceScope = (title: String, options: List<Choice>) -> Choice

class Runtime(val choices: ChoiceScope, val currentChar: Character? = null) {
    interface IExecutionIterator {
        fun hasFinished(): Boolean
        fun step()
        fun finalValue(): Value
    }

    interface IExpressionExecutionIterator : IExecutionIterator {
        val parent: IExecutionIterator
    }

    private inner class PartialExecutionIterator(
        override var parent: IExecutionIterator,
        private val done: MutableList<Value>,
        private val todo: MutableList<Expression>,
        val at: Pos
    ) :
        IExpressionExecutionIterator {
        private var waitingFor: IExecutionIterator? = null

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
                evaluate(
                    this,
                    { waitingFor = it },
                    { done.add(it) },
                    stack.peek(),
                    next
                )
            }
        }
        override fun finalValue(): ListValue = ListValue(done, at)
    }

    private class CallbackIterator(
        override val parent: IExecutionIterator,
        val elements: PartialExecutionIterator,
        val post: (List<Value>) -> Value
    ):
        IExpressionExecutionIterator {
            init {
                elements.parent = this
            }
        override fun hasFinished(): Boolean = elements.hasFinished()
        override fun step() = elements.step()
        override fun finalValue(): Value = post(elements.finalValue().value)
    }

    private class TernaryIterator(
        override val parent: IExecutionIterator,
        val cond: PartialExecutionIterator,
        val bT: PartialExecutionIterator,
        val bF: PartialExecutionIterator,
        val at: Pos
    ) : IExpressionExecutionIterator
    {
        init {
            cond.parent = this
            bT.parent = this
            bF.parent = this
        }
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
        override fun finalValue(): Value =
            if(state) bT.finalValue() else bF.finalValue()
    }

    //region Expression Evaluator
    private fun evaluate(current: IExecutionIterator, addChild: (IExecutionIterator) -> Unit, onFinish: (Value) -> Unit, ctx: Context, expr: Expression) {
        when (expr) {
            is BinaryExpression -> addChild(eval(current, expr))
            is CallExpression -> TODO()
            is IndexExpression -> addChild(eval(current, expr))
            is ListExpression -> addChild(eval(current, expr))
            is LiteralExpression -> onFinish(eval(expr))
            is MemberCallExpression -> TODO()
            is MemberExpression -> addChild(eval(current, expr))
            is RangeExpression -> addChild(eval(current, expr))
            is TernaryExpression -> addChild(eval(current, expr))
            is UnaryExpression -> addChild(eval(current, expr))
            is VariableExpression -> onFinish(eval(ctx, expr))
        }
    }

    private fun eval(lit: LiteralExpression): Value = lit.value
    private fun eval(ctx: Context, v: VariableExpression): Value =
        ctx.lookup(v.name)?.value ?: throw VariableError(v.name, v.pos)
    private fun eval(parent: IExecutionIterator, e: ListExpression): IExecutionIterator {
        return PartialExecutionIterator(parent, mutableListOf(), e.values.toMutableList(), e.pos)
    }
    private fun eval(parent: IExecutionIterator, e: UnaryExpression): IExecutionIterator {
        return CallbackIterator(parent,
            PartialExecutionIterator(
                parent,
                mutableListOf(),
                mutableListOf(e.target),
                e.pos
            )
        ) { e.op.withValue(it[0], e.pos) }
    }
    private fun eval(parent: IExecutionIterator, e: BinaryExpression): IExecutionIterator {
        return CallbackIterator(parent,
            PartialExecutionIterator(
                parent,
                mutableListOf(),
                mutableListOf(e.left, e.right),
                e.pos
            )
        ) { e.op.withValues(it[0], it[1], e.pos) }
    }
    private fun eval(parent: IExecutionIterator, e: TernaryExpression): IExecutionIterator {
        return TernaryIterator(parent,
            PartialExecutionIterator(parent, mutableListOf(), mutableListOf(e.cond), e.pos),
            PartialExecutionIterator(parent, mutableListOf(), mutableListOf(e.bTrue), e.pos),
            PartialExecutionIterator(parent, mutableListOf(), mutableListOf(e.bFalse), e.pos),
            e.pos
        )
    }
    private fun eval(parent: IExecutionIterator, e: IndexExpression): IExecutionIterator {
        return CallbackIterator(parent,
            PartialExecutionIterator(
                parent,
                mutableListOf(),
                mutableListOf(e.target, e.index),
                e.pos
            )
        ) {
            it[0].requireOrNull<ListValue>()?.let { l ->
                it[1].require<IntValue>("int", it[1].pos).let { i ->
                    l.value[i.value]
                }
            } ?: it[0].require<ObjectValue>("list or object", it[0].pos).let { o ->
                it[1].require<StringValue>("string", it[1].pos).let { s ->
                    o.value[s.value] ?: throw FieldError(o.type, s.value, s.pos)
                }
            }
        }
    }
    private fun eval(parent: IExecutionIterator, e: MemberExpression): IExecutionIterator {
        return CallbackIterator(parent,
            PartialExecutionIterator(
                parent,
                mutableListOf(),
                mutableListOf(e.target),
                e.pos
            )
        ) {
            it[0].require<ObjectValue>("object", it[0].pos).let { o ->
                o.value[e.member] ?: throw FieldError(o.type, e.member, e.pos)
            }
        }
    }
    private fun eval(parent: IExecutionIterator, e: RangeExpression): IExecutionIterator {
        return CallbackIterator(parent,
            PartialExecutionIterator(
                parent,
                mutableListOf(),
                mutableListOf(e.start, e.end),
                e.pos
            )
        ) {
            val start = it[0].require<IntValue>("int", it[0].pos).value
            val end = it[1].require<IntValue>("int", it[1].pos).value
            RangeValue(start, if(e.inclusive) end else (end - 1), e.pos)
        }
    }
    //endregion

    private inner class ExecutionIterator : IExecutionIterator {
        private var currentExpr: IExpressionExecutionIterator? = null

        override fun hasFinished(): Boolean {
            TODO("Not yet implemented")
        }

        override fun step() {
            TODO("Not yet implemented")
        }

        override fun finalValue(): Value {
            TODO("Not yet implemented")
        }
    }

    private val stack = Stack<Context>()

    fun startExecution(): IExecutionIterator {
        return ExecutionIterator()
    }

    fun stackUnwind(): List<Pos> = stack.map { it.pos }
}