package runtime.ast

data class Pos(val file: String, val line: Int, val col: Int) {
    override fun toString(): String = "$file:$line:$col"
}

sealed class Node(val pos: Pos)