package parser.ast

data class Pos(val file: String, val line: Int, val col: Int) {
    override fun toString() = "$file:$line:$col"
}

sealed class AstNode(val pos: Pos)

class HeaderNode(val src: String, val deps: List<String>, val strFiles: List<String>, pos: Pos)
    : AstNode(pos)

class EmptyNode(pos: Pos) : AstNode(pos)