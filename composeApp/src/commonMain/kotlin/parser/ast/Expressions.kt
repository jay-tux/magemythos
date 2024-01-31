package parser.ast

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

sealed class Expression(pos: Pos) : AstNode(pos) {
    abstract fun evaluate(c: Context): Literal

    @Composable
    abstract fun repr()
}

class LiteralExpr(private val l: Literal, pos: Pos) : Expression(pos) {
    override fun evaluate(c: Context): Literal = l

    @Composable
    override fun repr() {
        Text("literal: ${l.repr()}")
    }
}

class IdentifierExpr(private val name: String, pos: Pos) : Expression(pos) {
    override fun evaluate(c: Context): Literal = c.lookup(name)?.value ?: throw UndefinedVariable(name, pos)

    @Composable
    override fun repr() {
        Text("identifier: $name")
    }
}

class ObjectMemberExpr(private val obj: Expression, private val member: String, pos: Pos) : Expression(pos) {
    override fun evaluate(c: Context): Literal {
        val o = obj.evaluate(c)
        if (o !is ObjectLiteral) throw TypeError("object", o.typeName(), pos)
        return o.lookup(member)?.value ?: throw InvalidMember(o.typeName(), member, pos)
    }

    @Composable
    override fun repr() {
        Text("member $member on: ${obj.repr()}")
    }
}

class ListExpression(private val contents: List<Expression>, pos: Pos) : Expression(pos) {
    override fun evaluate(c: Context): Literal =
        ListLiteral(contents.map {
            Variable("#list value#", it.evaluate(c), true, pos)
        }.toMutableList(), pos)

    @Composable
    override fun repr() = Column {
        Text("list expression:")
        Row {
            Spacer(Modifier.width(10.dp))
            Column {
                contents.forEach { it.repr() }
            }
        }
    }
}

class DictExpression(private val contents: List<Pair<Expression, Expression>>, pos: Pos) : Expression(pos) {
    override fun evaluate(c: Context): Literal =
        DictLiteral(contents.associate {
            it.first.evaluate(c) to Variable(
                "#dict value#",
                it.second.evaluate(c),
                true,
                pos
            )
        }.toMutableMap(), pos)

    @Composable
    override fun repr() = Column {
        Text("dict expression:")
        Row {
            Spacer(Modifier.width(10.dp))
            Column {
                contents.forEach { (k, v) ->
                    Row {
                        Spacer(Modifier.width(10.dp))
                        Column {
                            Text("key:")
                            k.repr()
                            Text("value:")
                            v.repr()
                        }
                    }
                }
            }
        }
    }
}

class IndexExpr(private val obj: Expression, private val index: Expression, pos: Pos) : Expression(pos) {
    override fun evaluate(c: Context): Literal =
        performIndexing(obj.evaluate(c), index.evaluate(c), pos).value

    @Composable
    override fun repr() = Column {
        Text("index ${index.repr()}")
        Text(" on: ${obj.repr()}")
    }

    companion object {
        fun performIndexing(o: Literal, i: Literal, pos: Pos): Variable {
            return when(o) {
                is ListLiteral -> {
                    if (i !is IntLiteral) throw TypeError("int", i.typeName(), pos)
                    if(i.value < 0 || i.value > o.value.size) throw IndexOutOfBounds(i.value, o.value.size, pos)
                    o.value[i.value]
                }

                is DictLiteral -> {
                    o.value[i] ?: throw KeyError(i, pos)
                }

                is ObjectLiteral -> {
                    if(i !is StringLiteral) throw TypeError("string", i.typeName(), pos)
                    o.lookup(i.value) ?: throw InvalidMember(o.typeName(), i.value, pos)
                }

                else -> throw TypeError("indexable (list, dict or object)", o.typeName(), pos)
            }
        }
    }
}

class FunCallExpr(private val name: String, private val args: List<Expression>, pos: Pos) : Expression(pos) {
    override fun evaluate(c: Context): Literal = c.call(name, args.map { it.evaluate(c) }) ?: throw UndefinedFunction(name, pos)

    @Composable
    override fun repr() = Column {
        Text("function call: $name, with arguments:")
        Row {
            Spacer(Modifier.width(10.dp))
            Column {
                args.forEach {it.repr()}
            }
        }
    }
}

class UnaryExpr(private val op: UnaryOperator, private val expr: Expression, pos: Pos) : Expression(pos) {
    override fun evaluate(c: Context): Literal = op.apply(expr.evaluate(c), pos)

    @Composable
    override fun repr() = Column {
        Text("unary operator: $op on:")
        expr.repr()
    }
}

class BinaryExpr(private val op: BinaryOperator, private val l: Expression, private val r: Expression, pos: Pos) : Expression(pos) {
    override fun evaluate(c: Context): Literal = op.apply(l.evaluate(c), r.evaluate(c), pos)

    @Composable
    override fun repr() = Column {
        Text("binary operator: $op on:")
        Row {
            Spacer(Modifier.width(10.dp))
            Column {
                l.repr()
                r.repr()
            }
        }
    }
}