package runtime.ast

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import runtime.Context
import runtime.RuntimeInternalError
import runtime.TypeError
import ui.indented
import ui.indentedOpenClose

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
                    else -> throw TypeError("int or float", right::class.java, right.pos)
                }
                else -> {
                    if(right is IntValue) ListValue(List(right.value) { left }, at)
                    else throw TypeError("int", right::class.java, left.pos)
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
    abstract fun evaluate(ctx: Context): Value

    @Composable
    abstract fun ColumnScope.render(indent: Int)

    @Composable
    fun show(scope: ColumnScope, indent: Int = 0) {
        scope.render(indent)
    }
}

sealed class RecursiveExpression(pos: Pos) : Expression(pos)

class LiteralExpression(val value: Value, pos: Pos): Expression(pos) {
    override fun evaluate(ctx: Context): Value = value

    @Composable
    override fun ColumnScope.render(indent: Int) = indented(indent) {
        Text(value.toString())
    }
}

class VariableExpression(val name: String, pos: Pos): Expression(pos) {
    override fun evaluate(ctx: Context): Value = TODO()

    @Composable
    override fun ColumnScope.render(indent: Int) = indented(indent) {
        Text(name)
    }
}

class ListExpression(val values: List<Expression>, pos: Pos): RecursiveExpression(pos) {
    override fun evaluate(ctx: Context): Value = ListValue(values.map { it.evaluate(ctx) }, pos)

    @Composable
    override fun ColumnScope.render(indent: Int) {
        var showValues by remember { mutableStateOf(false) }
        indentedOpenClose(indent, showValues, { showValues = it }) {
            Text("List expression")
        }
        if (showValues) {
            values.forEach { it.show(this@render, indent + 1) }
        }
    }
}

class CallExpression(val name: String, val args: List<Expression>, pos: Pos): Expression(pos) {
    override fun evaluate(ctx: Context): Value = TODO()

    @Composable
    override fun ColumnScope.render(indent: Int) {
        var showValues by remember { mutableStateOf(false) }
        indentedOpenClose(indent, showValues, { showValues = it }) {
            Text("Call $name")
        }

        if (showValues) {
            args.forEach { it.show(this@render, indent + 1) }
        }
    }
}

class UnaryExpression(val op: UnaryOperator, val target: Expression, pos: Pos): Expression(pos) {
    override fun evaluate(ctx: Context): Value = TODO()

    @Composable
    override fun ColumnScope.render(indent: Int) {
        var showTarget by remember { mutableStateOf(false) }
        indentedOpenClose(indent, showTarget, { showTarget = it }) {
            Text("${op.repr()} operator")
        }

        if (showTarget) {
            target.show(this@render, indent + 1)
        }
    }
}

class BinaryExpression(val op: BinaryOperator, val left: Expression, val right: Expression, pos: Pos): Expression(pos) {
    override fun evaluate(ctx: Context): Value = TODO()

    @Composable
    override fun ColumnScope.render(indent: Int) {
        var showArgs by remember { mutableStateOf(false) }
        indentedOpenClose(indent, showArgs, { showArgs = it }) {
            Text("${op.repr()} operator")
        }

        if (showArgs) {
            left.show(this@render, indent + 1)
            right.show(this@render, indent + 1)
        }
    }
}

class TernaryExpression(val cond: Expression, val bTrue: Expression, val bFalse: Expression, pos: Pos): Expression(pos) {
    override fun evaluate(ctx: Context): Value = TODO()

    @Composable
    override fun ColumnScope.render(indent: Int) {
        var showArgs by remember { mutableStateOf(false) }
        indentedOpenClose(indent, showArgs, { showArgs = it }) {
            Text("Ternary operator")
        }

        if (showArgs) {
            cond.show(this@render, indent + 1)
            bTrue.show(this@render, indent + 1)
            bFalse.show(this@render, indent + 1)
        }
    }
}

class IndexExpression(val target: Expression, val index: Expression, pos: Pos): Expression(pos) {
    override fun evaluate(ctx: Context): Value = TODO()

    @Composable
    override fun ColumnScope.render(indent: Int) {
        var showArgs by remember { mutableStateOf(false) }
        indentedOpenClose(indent, showArgs, { showArgs = it }) {
            Text("Index operator")
        }

        if (showArgs) {
            target.show(this@render, indent + 1)
            index.show(this@render, indent + 1)
        }
    }
}

class MemberExpression(val target: Expression, val member: String, pos: Pos): Expression(pos) {
    override fun evaluate(ctx: Context): Value = TODO()

    @Composable
    override fun ColumnScope.render(indent: Int) {
        var showArgs by remember { mutableStateOf(false) }
        indentedOpenClose(indent, showArgs, { showArgs = it }) {
            Text("Member operator")
        }

        if (showArgs) {
            target.show(this@render, indent + 1)
            indented(indent + 1) {
                Text(member)
            }
        }
    }
}

class MemberCallExpression(val target: Expression, val member: String, val args: List<Expression>, pos: Pos): Expression(pos) {
    override fun evaluate(ctx: Context): Value = TODO()

    @Composable
    override fun ColumnScope.render(indent: Int) {
        var showArgs by remember { mutableStateOf(false) }
        indentedOpenClose(indent, showArgs, { showArgs = it }) {
            Text("Member call $member")
        }

        if (showArgs) {
            target.show(this@render, indent + 1)
            indented(indent + 1) {
                Text(member)
            }
            args.forEach { it.show(this@render, indent + 1) }
        }
    }
}

class RangeExpression(val start: Expression, val end: Expression, val inclusive: Boolean, pos: Pos): Expression(pos) {
    override fun evaluate(ctx: Context): Value = TODO()

    @Composable
    override fun ColumnScope.render(indent: Int) {
        var showArgs by remember { mutableStateOf(false) }
        indentedOpenClose(indent, showArgs, { showArgs = it }) {
            Text("${if(inclusive) "Inclusive" else "Exclusive"} range expression")
        }

        if (showArgs) {
            start.show(this@render, indent + 1)
            end.show(this@render, indent + 1)
        }
    }
}