package runtime.ast

import kotlinx.serialization.Serializable

@Serializable
data class Pos(val source: String, val file: String, val line: Int, val col: Int) {
    override fun toString(): String = "$source($file):$line:$col"
}

sealed class Node(val pos: Pos)