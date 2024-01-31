package parser.ast

interface FloatValue {
    val value: Float
}

data class Dice(val num: Int, val sides: Int) {
    override fun toString(): String {
        return "${num}d$sides"
    }

    override fun hashCode(): Int = (num to sides).hashCode()
    override fun equals(other: Any?): Boolean = other is Dice && num == other.num && sides == other.sides
}
enum class Currency(private val sign: String) {
    CP("cp"), SP("sp"), GP("gp"), PP("pp");

    override fun toString(): String = sign
}

sealed class Literal(pos: Pos) : AstNode(pos) {
    abstract fun repr(): String

    abstract fun typeName(): String

    override fun toString(): String = repr()
}

class StringLiteral(val value: String, pos: Pos) : Literal(pos) {
    override fun repr(): String = value
    override fun typeName(): String = "string"
    override fun hashCode(): Int = value.hashCode()
    override fun equals(other: Any?): Boolean = other is StringLiteral && value == other.value
}

class TypedListLiteral<T>(val value: List<T>, pos: Pos) : Literal(pos) {
    override fun repr(): String = value.joinToString(", ") { it.toString() }
    override fun typeName(): String = "list<???>"
    override fun hashCode(): Int = value.hashCode()
    override fun equals(other: Any?): Boolean = other is TypedListLiteral<*> && value == other.value
}

class FloatLiteral(override val value: Float, pos: Pos) : Literal(pos), FloatValue {
    override fun repr(): String = value.toString()
    override fun typeName(): String = "float"
    override fun hashCode(): Int = value.hashCode()
    override fun equals(other: Any?): Boolean = other is FloatLiteral && value == other.value
}

class IntLiteral(val value: Int, pos: Pos) : Literal(pos) {
    override fun repr(): String = value.toString()
    override fun typeName(): String = "int"

    override fun hashCode(): Int = value.hashCode()
    override fun equals(other: Any?): Boolean = other is IntLiteral && value == other.value
}

class BoolLiteral(val value: Boolean, pos: Pos) : Literal(pos) {
    override fun repr(): String = value.toString()
    override fun typeName(): String = "bool"

    override fun hashCode(): Int = value.hashCode()
    override fun equals(other: Any?): Boolean = other is BoolLiteral && value == other.value
}

class NullLiteral(pos: Pos) : Literal(pos) {
    override fun repr(): String = "(null)"
    override fun typeName(): String = "(void)"

    override fun hashCode(): Int = 0
    override fun equals(other: Any?): Boolean = other is NullLiteral
}

class ListLiteral(val value: MutableList<Variable>, pos: Pos) : Literal(pos) {
    override fun repr(): String = value.joinToString(", ") { it.toString() }
    override fun typeName(): String = "list"

    override fun hashCode(): Int = value.hashCode()
    override fun equals(other: Any?): Boolean = other is ListLiteral && value == other.value
}

class DictLiteral(val value: MutableMap<Literal, Variable>, pos: Pos): Literal(pos) {
    override fun repr(): String = value.entries.joinToString(", ") { "${it.key}: ${it.value}" }
    override fun typeName(): String = "dict"
    override fun hashCode(): Int = value.hashCode()
    override fun equals(other: Any?): Boolean = other is DictLiteral && value == other.value
}

class DiceLiteral(val value: Dice, pos: Pos) : Literal(pos) {
    override fun repr(): String = value.toString()
    override fun typeName(): String = "dice"
    override fun hashCode(): Int = value.hashCode()
    override fun equals(other: Any?): Boolean = other is DiceLiteral && value == other.value
}

class DistanceLiteral(override val value: Float, pos: Pos) : Literal(pos), FloatValue {
    override fun repr(): String = "$value ft"
    override fun typeName(): String = "distance"
    override fun hashCode(): Int = value.hashCode()
    override fun equals(other: Any?): Boolean = (other is DistanceLiteral && value == other.value)
            || (other is FloatLiteral && value == other.value)
}

class WeightLiteral(override val value: Float, pos: Pos) : Literal(pos), FloatValue {
    override fun repr(): String = "$value lb"
    override fun typeName(): String = "weight"
    override fun equals(other: Any?): Boolean = (other is WeightLiteral && value == other.value)
            || (other is FloatLiteral && value == other.value)

    override fun hashCode(): Int = value.hashCode()
}

class CurrencyLiteral(val value: Int, val currency: Currency, pos: Pos) : Literal(pos) {
    override fun repr(): String = "$value $currency"
    override fun typeName(): String = "currency"
    override fun equals(other: Any?): Boolean =
        (other is CurrencyLiteral && value == other.value && currency == other.currency)
            || (other is IntLiteral && value == other.value)

    override fun hashCode(): Int = (value to currency).hashCode()
}

class ObjectLiteral(val type: Type, pos: Pos) : Literal(pos) {
    private val fields = mutableMapOf<String, Variable>()

    fun lookup(name: String): Variable? = fields[name]

    override fun repr(): String = "(object of type $type constructed at $pos)"
    override fun typeName(): String = type.name

    override fun hashCode(): Int = (type to fields).hashCode()
    override fun equals(other: Any?): Boolean =
        other is ObjectLiteral && type == other.type && fields == other.fields
}

class Variable(val name: String, value: Literal, private val mutable: Boolean = true, val pos: Pos) {
    var value = value
        private set

    fun update(newValue: Literal) {
        if(mutable) value = newValue
        else throw ImmutableVariable(name, pos)
    }

    fun rtUpdate(upd: Literal) {
        value = upd
    }
}
