package runtime.ast

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

sealed class Value(val pos: Pos)

class StringValue(val value: String, pos: Pos) : Value(pos) {
    override fun toString(): String = value
    override fun equals(other: Any?): Boolean = other is StringValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
}
class IntValue(val value: Int, pos: Pos) : Value(pos) {
    override fun toString(): String = value.toString()
    override fun equals(other: Any?): Boolean = other is IntValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
}
class FloatValue(val value: Float, pos: Pos) : Value(pos) {
    override fun toString(): String = value.toString()
    override fun equals(other: Any?): Boolean = other is FloatValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
}
class ListValue(val value: List<Value>, pos: Pos) : Value(pos) {
    override fun toString(): String = "[${value.joinToString(", ")}]"
    override fun equals(other: Any?): Boolean = other is ListValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
}
class BoolValue(val value: Boolean, pos: Pos) : Value(pos) {
    override fun toString(): String = value.toString()
    override fun equals(other: Any?): Boolean = other is BoolValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
}
class DiceValue(val kind: Int, pos: Pos) : Value(pos) {
    override fun toString(): String = "d$kind"
    override fun equals(other: Any?): Boolean = other is DiceValue && other.kind == kind
    override fun hashCode(): Int = kind.hashCode()

    companion object {
        fun String.toDiceOrNull(): Int? =
            if (startsWith("d")) substring(1).toIntOrNull()
            else null
    }
}
class RollValue(val count: Int, val kind: Int, pos: Pos) : Value(pos) {
    constructor(countKind: Pair<Int, Int>, pos: Pos) : this(countKind.first, countKind.second, pos)

    override fun toString(): String = "$count${DiceValue(kind, pos)}"
    override fun equals(other: Any?): Boolean = other is RollValue && other.count == count && other.kind == kind
    override fun hashCode(): Int = count.hashCode() + kind.hashCode()

    companion object {
        fun String.toRollOrNull(): Pair<Int, Int>? {
            val parts = split("d")
            return if (parts.size == 2) {
                val count = parts[0].toIntOrNull()
                val kind = parts[1].toIntOrNull()
                if (count != null && kind != null) count to kind
                else null
            } else null
        }
    }
}

// TODO: object values