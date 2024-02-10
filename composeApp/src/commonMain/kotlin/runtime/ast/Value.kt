package runtime.ast

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import runtime.TypeError
import runtime.Variable

sealed class Value(val pos: Pos) {
    inline fun <reified T: Value> require(desc: String, at: Pos): T = this as? T ?: throw TypeError(desc, this::class.java, at)
    inline fun <reified T: Value> requireOrNull(): T? = this as? T
}

class StringValue(val value: String, pos: Pos) : Value(pos) {
    override fun toString(): String = value
    override fun equals(other: Any?): Boolean = other is StringValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
}
class IntValue(val value: Int, pos: Pos) : Value(pos) {
    override fun toString(): String = value.toString()
    override fun equals(other: Any?): Boolean = other is IntValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
    fun map(f: (Int) -> Int, at: Pos): IntValue = IntValue(f(value), at)
}
class FloatValue(val value: Float, pos: Pos) : Value(pos) {
    override fun toString(): String = value.toString()
    override fun equals(other: Any?): Boolean = other is FloatValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
    fun map(f: (Float) -> Float, at: Pos): FloatValue = FloatValue(f(value), at)
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
    fun map(f: (Boolean) -> Boolean, at: Pos): BoolValue = BoolValue(f(value), at)
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
    override fun hashCode(): Int = (count to kind to 1).hashCode()

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
class RangeValue(val start: Int, val endIncl: Int, pos: Pos) : Value(pos) {
    override fun toString(): String = "$start..$endIncl"
    override fun equals(other: Any?): Boolean = other is RangeValue && other.start == start && other.endIncl == endIncl
    override fun hashCode(): Int = (start to endIncl to 2).hashCode()
}

class ObjectValue(val type: TypeDeclaration, val value: Map<String, Variable>, pos: Pos) : Value(pos) {
    override fun toString(): String = "{${value.entries.joinToString(", ") { (k, v) -> "$k: $v" }}}"
    override fun equals(other: Any?): Boolean = other is ObjectValue && other.value == value
    override fun hashCode(): Int = (value to type to 3).hashCode()
}