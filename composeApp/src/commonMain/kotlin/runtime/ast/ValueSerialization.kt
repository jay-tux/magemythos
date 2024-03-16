package runtime.ast

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.floatOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import runtime.CharacterLoader
import runtime.Runtime
import runtime.Type
import runtime.ast.Currency.Companion.toCurrencyOrNull
import runtime.ast.JsonExt.requireArray
import runtime.ast.JsonExt.requireBoolean
import runtime.ast.JsonExt.requireFloat
import runtime.ast.JsonExt.requireInt
import runtime.ast.JsonExt.requireKey
import runtime.ast.JsonExt.requireObject
import runtime.ast.JsonExt.requirePrimitive
import runtime.ast.JsonExt.requireString
import java.lang.IllegalArgumentException

object JsonExt {
    fun JsonElement.name() = when(this) {
        is JsonObject -> "object"
        is JsonPrimitive -> "primitive"
        is JsonArray -> "array"
        is JsonNull -> "(null)"
        else -> "[invalid JSON type]"
    }

    fun JsonPrimitive.type(): String {
        return if(isString) "string"
        else if(booleanOrNull != null) "boolean"
        else if(intOrNull != null) "int"
        else if(floatOrNull != null) "float"
        else if(doubleOrNull != null) "double"
        else "[invalid primitive type]"
    }

    fun JsonElement.requireObject() = try {
        this.jsonObject
    } catch(_: IllegalArgumentException) {
        throw CharacterLoader.CharacterParsingError("Expected an object, but got ${name()}")
    }

    fun JsonElement.requireArray() = try {
        this.jsonArray
    } catch(_: IllegalArgumentException) {
        throw CharacterLoader.CharacterParsingError("Expected an array, but got ${name()}")
    }

    fun JsonElement.requirePrimitive() = try {
        this.jsonPrimitive
    } catch(_: IllegalArgumentException) {
        throw CharacterLoader.CharacterParsingError("Expected a primitive, but got ${name()}")
    }

    fun JsonElement.requireNull() = try {
        this.jsonNull
    } catch(_: IllegalArgumentException) {
        throw CharacterLoader.CharacterParsingError("Expected null, but got ${name()}")
    }

    fun JsonObject.requireKey(key: String) = this[key] ?: throw CharacterLoader.CharacterParsingError(
        "Expected key $key, but it was not found"
    )

    fun JsonPrimitive.requireString() = if(isString) content else throw CharacterLoader.CharacterParsingError(
        "Expected a string, but got ${type()}"
    )
    fun JsonPrimitive.requireBoolean() = booleanOrNull ?: throw CharacterLoader.CharacterParsingError(
        "Expected a boolean, but got ${type()}"
    )
    fun JsonPrimitive.requireInt() = intOrNull ?: throw CharacterLoader.CharacterParsingError("Expected an int, but got ${type()}")
    fun JsonPrimitive.requireFloat() = floatOrNull ?: throw CharacterLoader.CharacterParsingError("Expected a float, but got ${type()}")
    fun JsonPrimitive.requireDouble() = doubleOrNull ?: throw CharacterLoader.CharacterParsingError(
        "Expected a double, but got ${type()}"
    )
}

@Serializable
class RTType(val src: String, val file: String, val name: String) {
    inline fun <reified T: Type> ctor(required: String): T {
        val t = ctor()
        if(t !is T) throw CharacterLoader.CharacterParsingError("Type $name from $src($file) is not a $required")
        return t
    }

    fun ctor(): Type = Runtime.getCache().getType(name) ?: throw CharacterLoader.CharacterParsingError("Can't find type $name from $src($file)")

    companion object {
        fun fromType(type: Type) = RTType(type.pos.source, type.pos.file, type.name)
        fun Type.toRTT() = RTType.fromType(this)
    }
}

object ValueSerialization {
    private const val TYPE_KEY = "__type"
    private const val VAL_KEY = "__val"
    private const val POS_KEY = "__pos"

    private const val CURRENCY_AMOUNT_KEY = "__amount"
    private const val CURRENCY_UNIT_KEY = "__type"
    private const val ROLL_KIND_KEY = "__kind"
    private const val ROLL_COUNT_KEY = "__count"
    private const val RANGE_START_KEY = "__start"
    private const val RANGE_END_KEY = "__end"
    private const val OBJECT_TYPE_KEY = "__rtt"
    private const val OBJECT_FIELDS_KEY = "__fields"

    private const val VAR_NAME_KEY = "__name"
    private const val VAR_VAL_KEY = "__val"
    private const val VAR_MUTABLE_KEY = "__isMut"
    private const val VAR_POS_KEY = "__pos"

    private const val STRING_TYPE_TAG = 0x01
    private const val INT_TYPE_TAG = 0x02
    private const val FLOAT_TYPE_TAG = 0x03
    private const val BOOL_TYPE_TAG = 0x04
    private const val LIST_TYPE_TAG = 0x20
    private const val OBJECT_TYPE_TAG = 0x21
    private const val CURRENCY_TYPE_TAG = 0x10
    private const val DICE_TYPE_TAG = 0x11
    private const val ROLL_TYPE_TAG = 0x12
    private const val RANGE_TYPE_TAG = 0x13
    private const val VOID_TYPE_TAG = 0x14

    fun Value.toJson(): JsonElement = JsonObject(mapOf(
        TYPE_KEY to JsonPrimitive(typeId()),
        VAL_KEY to baseJson(),
        POS_KEY to Json.encodeToJsonElement(pos)
    ))

    private fun Value.typeId() = when(this) {
        is StringValue -> STRING_TYPE_TAG
        is IntValue -> INT_TYPE_TAG
        is FloatValue -> FLOAT_TYPE_TAG
        is BoolValue -> BOOL_TYPE_TAG
        is ListValue -> LIST_TYPE_TAG
        is ObjectValue -> OBJECT_TYPE_TAG
        is CurrencyValue -> CURRENCY_TYPE_TAG
        is DiceValue -> DICE_TYPE_TAG
        is RangeValue -> RANGE_TYPE_TAG
        is RollValue -> ROLL_TYPE_TAG
        is VoidValue -> VOID_TYPE_TAG
    }
    private fun Value.baseJson() = when(this) {
        is StringValue -> toJson()
        is IntValue -> toJson()
        is FloatValue -> toJson()
        is BoolValue -> toJson()
        is ListValue -> toJson()
        is ObjectValue -> toJson()
        is CurrencyValue -> toJson()
        is DiceValue -> toJson()
        is RangeValue -> toJson()
        is RollValue -> toJson()
        is VoidValue -> toJson()
    }

    private fun StringValue.toJson(): JsonElement = JsonPrimitive(value)
    private fun IntValue.toJson(): JsonElement = JsonPrimitive(value)
    private fun FloatValue.toJson(): JsonElement = JsonPrimitive(value)
    private fun BoolValue.toJson(): JsonElement = JsonPrimitive(value)
    private fun ListValue.toJson(): JsonElement = JsonArray(value.map { it.toJson() })
    private fun CurrencyValue.toJson(): JsonElement = JsonObject(mapOf(
        CURRENCY_AMOUNT_KEY to JsonPrimitive(amount),
        CURRENCY_UNIT_KEY to JsonPrimitive("$unit")
    ))
    private fun DiceValue.toJson(): JsonElement = JsonPrimitive(kind)
    private fun RollValue.toJson(): JsonElement = JsonObject(mapOf(
        ROLL_COUNT_KEY to JsonPrimitive(count),
        ROLL_KIND_KEY to JsonPrimitive(kind)
    ))
    private fun RangeValue.toJson(): JsonElement = JsonObject(mapOf(
        RANGE_START_KEY to JsonPrimitive(start),
        RANGE_END_KEY to JsonPrimitive(endIncl)
    ))
    private fun VoidValue.toJson(): JsonElement = JsonObject(mapOf())
    private fun ObjectValue.toJson(): JsonElement = JsonObject(mapOf(
        OBJECT_TYPE_KEY to Json.encodeToJsonElement(RTType(type.pos.source, type.pos.file, type.name)),
        OBJECT_FIELDS_KEY to JsonObject(value.map { (k, v) -> k to v.toJson() }.toMap())
    ))

    private fun Variable.toJson(): JsonElement = JsonObject(mapOf(
        VAR_NAME_KEY to JsonPrimitive(name),
        VAR_VAL_KEY to value.toJson(),
        VAR_MUTABLE_KEY to JsonPrimitive(mutable),
        VAR_POS_KEY to Json.encodeToJsonElement(pos)
    ))

    fun JsonElement.toValue(): Value = when(this) {
        is JsonObject -> {
            val typeId = requireKey(TYPE_KEY).requirePrimitive().requireInt()
            val value = requireKey(VAL_KEY)
            val pos = Json.decodeFromJsonElement<Pos>(requireKey(POS_KEY))
            when(typeId) {
                STRING_TYPE_TAG -> value.toStringValue(pos)
                INT_TYPE_TAG -> value.toIntValue(pos)
                FLOAT_TYPE_TAG -> value.toFloatValue(pos)
                BOOL_TYPE_TAG -> value.toBoolValue(pos)
                LIST_TYPE_TAG -> value.toListValue(pos)
                OBJECT_TYPE_TAG -> value.toObjectValue(pos)
                CURRENCY_TYPE_TAG -> value.toCurrencyValue(pos)
                DICE_TYPE_TAG -> value.toDiceValue(pos)
                ROLL_TYPE_TAG -> value.toRollValue(pos)
                RANGE_TYPE_TAG -> value.toRangeValue(pos)
                VOID_TYPE_TAG -> value.toVoidValue(pos)
                else -> throw CharacterLoader.CharacterParsingError("Invalid type tag $typeId")
            }
        }
        else -> throw CharacterLoader.CharacterParsingError("Value must be an object")
    }

    private fun JsonElement.toStringValue(pos: Pos): StringValue = StringValue(requirePrimitive().requireString(), pos)
    private fun JsonElement.toIntValue(pos: Pos): IntValue = IntValue(requirePrimitive().requireInt(), pos)
    private fun JsonElement.toFloatValue(pos: Pos): FloatValue = FloatValue(requirePrimitive().requireFloat(), pos)
    private fun JsonElement.toBoolValue(pos: Pos): BoolValue = BoolValue(requirePrimitive().requireBoolean(), pos)
    private fun JsonElement.toListValue(pos: Pos): ListValue = ListValue(requireArray().map { it.toValue() }, pos)
    private fun JsonElement.toCurrencyValue(pos: Pos): CurrencyValue{
        val obj = requireObject()
        return CurrencyValue(
            obj.requireKey(CURRENCY_AMOUNT_KEY).requirePrimitive().requireInt(),
            obj.requireKey(CURRENCY_UNIT_KEY).requirePrimitive().requireString().let { it.toCurrencyOrNull() ?: throw CharacterLoader.CharacterParsingError("Invalid currency type $it") },
            pos
        )
    }
    private fun JsonElement.toDiceValue(pos: Pos): DiceValue = DiceValue(requirePrimitive().requireInt(), pos)
    private fun JsonElement.toRollValue(pos: Pos): RollValue {
        val obj = requireObject()
        return RollValue(
            obj.requireKey(ROLL_COUNT_KEY).requirePrimitive().requireInt(),
            obj.requireKey(ROLL_KIND_KEY).requirePrimitive().requireInt(),
            pos
        )
    }
    private fun JsonElement.toRangeValue(pos: Pos): RangeValue {
        val obj = requireObject()
        return RangeValue(
            obj.requireKey(RANGE_START_KEY).requirePrimitive().requireInt(),
            obj.requireKey(RANGE_END_KEY).requirePrimitive().requireInt(),
            pos
        )
    }
    private fun JsonElement.toVoidValue(pos: Pos): VoidValue = VoidValue(pos)
    private fun JsonElement.toObjectValue(pos: Pos): ObjectValue {
        val obj = requireObject()
        val type = Json.decodeFromJsonElement<RTType>(obj.requireKey(OBJECT_TYPE_KEY))
        val fields = obj.requireKey(OBJECT_FIELDS_KEY).requireObject().map { (k, v) -> k to v.toVariable() }.toMap()
        return ObjectValue(type.ctor<Type>("type"), fields, pos)
    }

    private fun JsonElement.toVariable(): Variable {
        val obj = requireObject()
        val name = obj.requireKey(VAR_NAME_KEY).requirePrimitive().requireString()
        val value = obj.requireKey(VAR_VAL_KEY).toValue()
        val mutable = obj.requireKey(VAR_MUTABLE_KEY).requirePrimitive().requireBoolean()
        val pos = Json.decodeFromJsonElement<Pos>(obj.requireKey(VAR_POS_KEY))
        return Variable(name, value, mutable, pos)
    }
}