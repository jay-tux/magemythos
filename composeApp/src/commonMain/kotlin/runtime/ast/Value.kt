package runtime.ast

import kotlinx.serialization.json.JsonElement
import runtime.ConversionError
import runtime.DfsRuntime
import runtime.ImmutableError
import runtime.RuntimeInternalError
import runtime.Type

sealed class Value(val pos: Pos) {
    inline fun <reified T: Value> require(desc: String, at: Pos): T = convertTo<T>(at)
    inline fun <reified T: Type> requireObject(desc: String, at: Pos): T = require<ObjectValue>("$desc object", at).let {
        if(it.type is T) it.type as T
        else throw InvalidObjectTypeError(desc, it.type.name, at)
    }
    inline fun <reified T: Value> requireOrNull(): T? = this as? T

    protected fun noConversion(what: String, at: Pos): Nothing =
        throw ConversionError(typeName(), what, at)

    fun convertToString(at: Pos): StringValue = StringValue(toString(), at)
    open fun convertToInt(at: Pos): IntValue = noConversion("int", at)
    open fun convertToFloat(at: Pos): FloatValue = noConversion("float", at)
    open fun convertToBool(at: Pos): BoolValue = noConversion("bool", at)
    open fun convertToList(at: Pos): ListValue = noConversion("list", at)
    open fun convertToCurrency(at: Pos): CurrencyValue = noConversion("currency", at)
    open fun convertToDice(at: Pos): DiceValue = noConversion("dice", at)
    open fun convertToRoll(at: Pos): RollValue = noConversion("roll", at)
    open fun convertToRange(at: Pos): RangeValue = noConversion("range", at)
    fun convertToObject(at: Pos): ObjectValue = noConversion("object", at)

    inline fun <reified T: Value> doConvert(at: Pos): Value =
        if(this is T) this
        else when(T::class) {
            StringValue::class -> convertToString(at)
            IntValue::class -> convertToInt(at)
            FloatValue::class -> convertToFloat(at)
            BoolValue::class -> convertToBool(at)
            ListValue::class -> convertToList(at)
            CurrencyValue::class -> convertToCurrency(at)
            DiceValue::class -> convertToDice(at)
            RollValue::class -> convertToRoll(at)
            RangeValue::class -> convertToRange(at)
            ObjectValue::class -> convertToObject(at)
            else -> throw RuntimeInternalError("invalid conversion/cast attempt to ${T::class} at $pos")
        }

    inline fun <reified T: Value> convertTo(at: Pos): T = doConvert<T>(at) as T

    abstract fun typeName(): String
}

class StringValue(val value: String, pos: Pos) : Value(pos) {
    override fun toString(): String = value
    override fun equals(other: Any?): Boolean = other is StringValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
    override fun typeName(): String = "string"
    override fun convertToInt(at: Pos): IntValue = value.toIntOrNull()?.let { IntValue(it, at) } ?: super.convertToInt(at)
    override fun convertToFloat(at: Pos): FloatValue = value.toFloatOrNull()?.let { FloatValue(it, at) } ?: super.convertToFloat(at)
}
class IntValue(val value: Int, pos: Pos) : Value(pos) {
    override fun toString(): String = value.toString()
    override fun equals(other: Any?): Boolean = other is IntValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
    fun map(f: (Int) -> Int, at: Pos): IntValue = IntValue(f(value), at)
    override fun typeName(): String = "int"
    override fun convertToFloat(at: Pos): FloatValue = FloatValue(value.toFloat(), at)
}
class FloatValue(val value: Float, pos: Pos) : Value(pos) {
    override fun toString(): String = value.toString()
    override fun equals(other: Any?): Boolean = other is FloatValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
    fun map(f: (Float) -> Float, at: Pos): FloatValue = FloatValue(f(value), at)
    override fun typeName(): String = "float"
    override fun convertToInt(at: Pos): IntValue = IntValue(value.toInt(), at)
}
class ListValue(val value: List<Value>, pos: Pos) : Value(pos) {
    override fun toString(): String = "[${value.joinToString(", ")}]"
    override fun equals(other: Any?): Boolean = other is ListValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
    override fun typeName(): String = "list"
}
class BoolValue(val value: Boolean, pos: Pos) : Value(pos) {
    override fun toString(): String = value.toString()
    override fun equals(other: Any?): Boolean = other is BoolValue && other.value == value
    override fun hashCode(): Int = value.hashCode()
    fun map(f: (Boolean) -> Boolean, at: Pos): BoolValue = BoolValue(f(value), at)
    override fun typeName(): String = "bool"
}

enum class Currency(private val shorthand: String) { PP("pp"), GP("gp"), SP("sp"), CP("cp");

    override fun toString(): String = shorthand

    companion object {
        fun String.toCurrencyOrNull(): Currency? = when (this) {
            "pp" -> PP
            "gp" -> GP
            "sp" -> SP
            "cp" -> CP
            else -> null
        }
    }
}
class CurrencyValue(val amount: Int, val unit: Currency, pos: Pos) : Value(pos) {
    override fun toString(): String = "$amount $unit"
    override fun equals(other: Any?): Boolean = other is CurrencyValue && other.amount == amount && other.unit == unit
    override fun hashCode(): Int = (amount to unit).hashCode()
    override fun typeName(): String = "currency"
}
class DiceValue(val kind: Int, pos: Pos) : Value(pos) {
    override fun toString(): String = "d$kind"
    override fun equals(other: Any?): Boolean = other is DiceValue && other.kind == kind
    override fun hashCode(): Int = kind.hashCode()
    override fun typeName(): String = "dice"

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
    override fun typeName(): String = "roll"

    override fun convertToDice(at: Pos): DiceValue = DiceValue(kind, at)

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
    override fun typeName(): String = "range"
}
class VoidValue(pos: Pos) : Value(pos) {
    override fun toString(): String = "void"
    override fun equals(other: Any?): Boolean = other is VoidValue
    override fun hashCode(): Int = 0
    override fun typeName(): String = "void"
}
class ObjectValue(val type: Type, val value: Map<String, Variable>, pos: Pos) : Value(pos) {
    override fun toString(): String = "{[${type.name}]::${value.entries.joinToString(", ") { (k, v) -> "$k: $v" }}}"
    override fun equals(other: Any?): Boolean = other is ObjectValue && other.value == value
    override fun hashCode(): Int = (value to type to 3).hashCode()
    override fun typeName(): String = type.name
}

class Variable(val name: String, value: Value, val mutable: Boolean, val pos: Pos) {
    var value: Value = value
        set(value) {
            if (!mutable) throw ImmutableError(name, pos)
            field = value
        }

    companion object {
        suspend fun GlobalDeclaration.toVariable(): Variable = Variable(name, DfsRuntime.evaluate(value, pos), false, pos)
    }
}