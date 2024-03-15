package runtime.ast

import runtime.DfsRuntime
import runtime.FieldError
import runtime.IOBError
import runtime.RuntimeInternalError
import runtime.TypeError
import runtime.VariableError

enum class UnaryOperator {
    PLUS, NOT, NEG;

    fun repr(): String = when (this) {
        PLUS -> "+"
        NOT -> "!"
        NEG -> "-"
    }

    fun withValue(v: Value, at: Pos): Value = when (this) {
        PLUS -> v.requireOrNull<IntValue>() ?: v.require<FloatValue>("int or float", at)
        NOT -> v.require<BoolValue>("bool", at).map(Boolean::not, at)
        NEG -> v.requireOrNull<IntValue>()?.map(Int::unaryMinus, at) ?: v.require<FloatValue>("int or float", at).map(Float::unaryMinus, at)
    }

    companion object {
        fun match(s: String, p: Pos): UnaryOperator = when (s) {
            "+" -> PLUS
            "!" -> NOT
            "-" -> NEG
            else -> throw InvalidOperatorError(s, p)
        }
    }
}

enum class BinaryOperator {
    ADD, SUB, MUL, DIV, MOD,
    EQ, NEQ, LT, GT, LTE, GTE,
    AND, OR;

    fun repr(): String = when (this) {
        ADD -> "+"
        SUB -> "-"
        MUL -> "*"
        DIV -> "/"
        MOD -> "%"
        EQ -> "=="
        NEQ -> "!="
        LT -> "<"
        GT -> ">"
        LTE -> "<="
        GTE -> ">="
        AND -> "&&"
        OR -> "||"
    }

    fun withValues(left: Value, right: Value, at: Pos): Value = when(this) {
        ADD -> arithmetic(left, right, at, Int::plus, Float::plus)
        SUB -> arithmetic(left, right, at, Int::minus, Float::minus)
        MUL -> {
            when(left) {
                is IntValue -> when(right) {
                    is IntValue -> IntValue(left.value * right.value, at)
                    is FloatValue -> FloatValue(left.value.toFloat() * right.value, at)
                    else -> ListValue(List(left.value) { right }, at)
                }
                is FloatValue -> when(right) {
                    is IntValue -> FloatValue(left.value * right.value.toFloat(), at)
                    is FloatValue -> FloatValue(left.value * right.value, at)
                    else -> throw TypeError("int or float", right, right.pos)
                }
                else -> {
                    if(right is IntValue) ListValue(List(right.value) { left }, at)
                    else throw TypeError("int", right, left.pos)
                }
            }
        }
        DIV -> arithmetic(left, right, at, Int::div, Float::div)
        MOD -> arithmetic(left, right, at, Int::rem, Float::rem)
        EQ -> equality(left, right, false)
        NEQ -> equality(left, right, true)
        LT -> comparison(left, right, at, { a, b -> a < b }) { a, b -> a < b }
        GT -> comparison(left, right, at, { a, b -> a > b }) { a, b -> a > b }
        LTE -> comparison(left, right, at, { a, b -> a <= b }) { a, b -> a <= b }
        GTE -> comparison(left, right, at, { a, b -> a >= b }) { a, b -> a >= b }
        AND -> boolean(left, right, at, Boolean::and)
        OR -> boolean(left, right, at, Boolean::or)
    }

    companion object {
        private fun arithmetic(left: Value, right: Value, at: Pos, f: (Int, Int) -> Int, g: (Float, Float) -> Float): Value {
            val l = left.requireOrNull<IntValue>() ?: left.require<FloatValue>("int or float", at)
            val r = right.requireOrNull<IntValue>() ?: right.require<FloatValue>("int or float", at)
            return when {
                l is IntValue && r is IntValue -> IntValue(f(l.value, r.value), at)
                l is IntValue && r is FloatValue -> FloatValue(g(l.value.toFloat(), r.value), at)
                l is FloatValue && r is IntValue -> FloatValue(g(l.value, r.value.toFloat()), at)
                l is FloatValue && r is FloatValue -> FloatValue(g(l.value, r.value), at)
                else -> throw RuntimeInternalError("Arithmetic type check is non-exhaustive")
            }
        }

        private fun equality(left: Value, right: Value, invert: Boolean) : BoolValue {
            return BoolValue(if(invert) left != right else left == right, left.pos)
        }

        private fun comparison(left: Value, right: Value, at: Pos, f: (Int, Int) -> Boolean, g: (Float, Float) -> Boolean) : BoolValue {
            val l = left.requireOrNull<IntValue>() ?: left.require<FloatValue>("int or float", at)
            val r = right.requireOrNull<IntValue>() ?: right.require<FloatValue>("int or float", at)
            return when {
                l is IntValue && r is IntValue -> BoolValue(f(l.value, r.value), at)
                l is IntValue && r is FloatValue -> BoolValue(g(l.value.toFloat(), r.value), at)
                l is FloatValue && r is IntValue -> BoolValue(g(l.value, r.value.toFloat()), at)
                l is FloatValue && r is FloatValue -> BoolValue(g(l.value, r.value), at)
                else -> throw RuntimeInternalError("Comparison type check is non-exhaustive")
            }
        }

        private fun boolean(left: Value, right: Value, at: Pos, f: (Boolean, Boolean) -> Boolean) : BoolValue {
            val l = left.require<BoolValue>("bool", at)
            val r = right.require<BoolValue>("bool", at)
            return BoolValue(f(l.value, r.value), at)
        }

        fun match(s: String, p: Pos): BinaryOperator = when (s) {
            "+" -> ADD
            "-" -> SUB
            "*" -> MUL
            "/" -> DIV
            "%" -> MOD
            "==" -> EQ
            "!=" -> NEQ
            "<" -> LT
            ">" -> GT
            "<=" -> LTE
            ">=" -> GTE
            "&&" -> AND
            "||" -> OR
            else -> throw InvalidOperatorError(s, p)
        }
    }
}

sealed class Expression(pos: Pos) : Node(pos) {
    abstract fun argCount(): Int
    abstract operator fun get(index: Int, previous: List<Value>): Expression
    abstract fun mergeValues(values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos)
}
sealed class RecursiveExpression(pos: Pos) : Expression(pos)
class LiteralExpression(val value: Value, pos: Pos): Expression(pos) {
    override fun argCount(): Int = 0
    override fun get(index: Int, previous: List<Value>): Expression = throw RuntimeInternalError("Literal expression has no children")
    override fun mergeValues(values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos) = scope.onValue(value)

    override fun toString(): String = "LiteralExpression(${value})"
}
class VariableExpression(val name: String, pos: Pos): Expression(pos) {
    override fun argCount(): Int = 0
    override fun get(index: Int, previous: List<Value>): Expression = throw RuntimeInternalError("Name expression has no children")
    override fun mergeValues(values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos) = scope.onValue(scope.lookup(name, at) ?: throw VariableError(name, at))

    override fun toString(): String = "VariableExpression(${name})"
}
class ListExpression(val values: List<Expression>, pos: Pos): RecursiveExpression(pos) {
    override fun argCount(): Int = values.size
    override fun get(index: Int, previous: List<Value>): Expression = values[index]
    override fun mergeValues(
        values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos
    ) {
        scope.onValue(ListValue(values, at))
    }

    override fun toString(): String = "ListExpression(${values.size})"
}
class CallExpression(val name: String, val args: List<Expression>, pos: Pos): Expression(pos) {
    override fun argCount(): Int = args.size
    override fun get(index: Int, previous: List<Value>): Expression = args[index]
    override fun mergeValues(
        values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos
    ) = scope.onCall(null, name, values, pos)

    override fun toString(): String = "CallExpression(${name} (${args.size} args))"
}
class UnaryExpression(val op: UnaryOperator, val target: Expression, pos: Pos): Expression(pos) {
    override fun argCount(): Int = 1
    override fun get(index: Int, previous: List<Value>): Expression = target
    override fun mergeValues(
        values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos
    ) = scope.onValue(op.withValue(values[0], at))

    override fun toString(): String = "UnaryExpression(${op.repr()})"
}
class BinaryExpression(val op: BinaryOperator, val left: Expression, val right: Expression, pos: Pos): Expression(pos) {
    override fun argCount(): Int = 2
    override fun get(index: Int, previous: List<Value>): Expression = if(index == 0) left else right
    override fun mergeValues(
        values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos
    ) = scope.onValue(op.withValues(values[0], values[1], at))

    override fun toString(): String = "BinaryExpression(${op.repr()})"
}
class TernaryExpression(val cond: Expression, val bTrue: Expression, val bFalse: Expression, pos: Pos): Expression(pos) {
    override fun argCount(): Int = 2
    override fun get(index: Int, previous: List<Value>): Expression {
        if(index == 0) return cond
        return if(previous[0].require<BoolValue>("bool", pos).value) bTrue else bFalse
    }
    override fun mergeValues(
        values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos
    ) = scope.onValue(values[1])

    override fun toString(): String = "TernaryExpression"
}
class IndexExpression(val target: Expression, val index: Expression, pos: Pos): Expression(pos) {
    override fun argCount(): Int = 2
    override fun get(index: Int, previous: List<Value>): Expression = if(index == 0) target else this.index
    override fun mergeValues(
        values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos
    ) {
        when(values[0]) {
            is ListValue -> {
                val index = values[1].require<IntValue>("int", at).value
                if(index < 0 || index >= (values[0] as ListValue).value.size) throw IOBError(index, (values[0] as ListValue).value.size, at)
                scope.onValue((values[0] as ListValue).value[index])
            }
            is RangeValue -> {
                val index = values[1].require<IntValue>("int", at).value
                val range = values[0] as RangeValue
                if(index + range.start > range.endIncl) throw IOBError(index, range.endIncl - range.start, at)
                IntValue(range.start + index, at)
            }
            is ObjectValue -> scope.onValue((values[0] as ObjectValue).value[values[1].require<StringValue>("string", at).value]?.value ?: throw FieldError((values[0] as ObjectValue).type.name, values[1].require<StringValue>("string", at).value, at))
            else -> throw TypeError("list or object", values[0], at)
        }
    }

    override fun toString(): String = "IndexExpression"
}
class MemberExpression(val target: Expression, val member: String, pos: Pos): Expression(pos) {
    override fun argCount(): Int = 1
    override fun get(index: Int, previous: List<Value>): Expression = target
    override fun mergeValues(
        values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos
    ) {
        val obj = values[0].require<ObjectValue>("object", at)
        scope.onValue(obj.value[member]?.value ?: throw FieldError(obj.type.name, member, at))
    }

    override fun toString(): String = "MemberExpression(${member})"
}
class MemberCallExpression(val target: Expression, val member: String, val args: List<Expression>, pos: Pos): Expression(pos) {
    override fun argCount(): Int = args.size + 1
    override fun get(index: Int, previous: List<Value>): Expression = if(index == 0) target else args[index - 1]
    override fun mergeValues(
        values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos
    ) = scope.onCall(values[0].requireOrNull<ObjectValue>(), member, values.subList(1, values.size), pos)

    override fun toString(): String = "MemberCallExpression(${member} (${args.size} args))"
}
class RangeExpression(val start: Expression, val end: Expression, val inclusive: Boolean, pos: Pos): Expression(pos) {
    override fun argCount(): Int = 2
    override fun get(index: Int, previous: List<Value>): Expression = if(index == 0) start else end
    override fun mergeValues(
        values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos
    ) {
        val start = values[0].require<IntValue>("int", at).value
        val end = values[1].require<IntValue>("int", at).value
        scope.onValue(RangeValue(start, if(inclusive) end else end - 1, at))
    }

    override fun toString(): String = "RangeExpression"
}
class MappedIntExpression(val target: Expression, val map: (IntValue) -> Value, pos: Pos) : Expression(pos) {
    override fun argCount(): Int = 1
    override fun get(index: Int, previous: List<Value>): Expression = target
    override fun mergeValues(
        values: List<Value>, scope: DfsRuntime.IExpressionScope, at: Pos
    ) {
        val target = values[0].require<IntValue>("int", at)
        scope.onValue(map(target))
    }

    override fun toString(): String = "MappedIntExpression"
}