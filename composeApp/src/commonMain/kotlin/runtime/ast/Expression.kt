package runtime.ast

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ui.indented
import ui.indentedOpenClose

enum class UnaryOperator {
    PLUS, NOT, NEG;

    fun repr(): String = when (this) {
        PLUS -> "+"
        NOT -> "!"
        NEG -> "-"
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

    companion object {
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

class ListExpression(val values: List<Expression>, pos: Pos): Expression(pos) {
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

class CallExpression(val name: String, private val args: List<Expression>, pos: Pos): Expression(pos) {
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