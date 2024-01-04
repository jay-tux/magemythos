package parser.ast

data class Dice(val num: Int, val sides: Int)
enum class Currency {
    CP, SP, GP, PP
}

sealed class Literal(pos: Pos) : AstNode(pos)

class StringLiteral(val value: String, pos: Pos) : Literal(pos)

class TypedListLiteral<T>(val value: List<T>, pos: Pos) : Literal(pos)

class FloatLiteral(val value: Float, pos: Pos) : Literal(pos)

class IntLiteral(val value: Int, pos: Pos) : Literal(pos)

class BoolLiteral(val value: Boolean, pos: Pos) : Literal(pos)

class NullLiteral(pos: Pos) : Literal(pos)

class ListLiteral(val value: List<Literal>, pos: Pos) : Literal(pos)

class DiceLiteral(val value: Dice, pos: Pos) : Literal(pos)

class DistanceLiteral(val value: Float, pos: Pos) : Literal(pos)

class WeightLiteral(val value: Float, pos: Pos) : Literal(pos)

class CurrencyLiteral(val value: Int, val currency: Currency, pos: Pos) : Literal(pos)
