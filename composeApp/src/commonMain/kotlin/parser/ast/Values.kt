package parser.ast

sealed class Literal(pos: Pos) : AstNode(pos)

class StringLiteral(val value: String, pos: Pos) : Literal(pos)

class TypedListLiteral<T>(val value: List<T>, pos: Pos) : Literal(pos)