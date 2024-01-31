package parser.ast

enum class UnaryOperator {
    NOT, NEGATE;

    fun apply(l: Literal, at: Pos): Literal = when(this) {
        NOT -> applyNot(l, at)
        NEGATE -> applyNegate(l, at)
    }

    companion object {
        fun applyNot(l: Literal, at: Pos): Literal = when(l) {
            is BoolLiteral -> BoolLiteral(!l.value, at)
            is IntLiteral -> BoolLiteral(l.value == 0, at)
            else -> throw TypeError("bool or int", l.typeName(), at)
        }

        fun applyNegate(l: Literal, at: Pos): Literal = when(l) {
            is IntLiteral -> IntLiteral(-l.value, at)
            is FloatLiteral -> FloatLiteral(-l.value, at)
            else -> throw TypeError("int or float", l.typeName(), at)
        }
    }
}

enum class BinaryOperator {
    ADD, SUB, MUL, DIV, MOD, AND, OR, EQ, NEQ, LT, GT, LTE, GTE;

    fun apply(l: Literal, r: Literal, at: Pos): Literal = when(this) {
        ADD -> applyAdd(l, r, at)
        SUB -> applyMath(l, r, { a, b -> a - b }, { a, b -> a - b }, at)
        MUL -> applyMath(l, r, { a, b -> a * b }, { a, b -> a * b }, at)
        DIV -> applyMath(l, r, { a, b -> if(b == 0) throw ZeroDivError(at) else a / b }, { a, b -> a / b }, at)
        MOD -> applyInts(l, r, { a, b -> a % b }, at)

        AND -> applyBools(l, r, { a, b -> a && b }, at)
        OR -> applyBools(l, r, { a, b -> a || b }, at)

        EQ -> applyEqual(l, r, at)
        NEQ -> BoolLiteral(!applyEqual(l, r, at).value, at)
        LT -> applyComp(l, r, { a, b -> a < b }, { a, b -> a < b }, at)
        GT -> applyComp(l, r, { a, b -> a > b }, { a, b -> a > b }, at)
        LTE -> applyComp(l, r, { a, b -> a <= b }, { a, b -> a <= b }, at)
        GTE -> applyComp(l, r, { a, b -> a >= b }, { a, b -> a >= b }, at)
    }

    companion object {
        fun applyAdd(l: Literal, r: Literal, at: Pos) = when(l) {
            is IntLiteral -> when(r) {
                is IntLiteral -> IntLiteral(l.value + r.value, at)
                is FloatLiteral -> FloatLiteral(l.value + r.value, at)
                else -> throw TypeError("int or float", r.typeName(), at)
            }
            is FloatLiteral -> when(r) {
                is IntLiteral -> FloatLiteral(l.value + r.value, at)
                is FloatLiteral -> FloatLiteral(l.value + r.value, at)
                else -> throw TypeError("int or float", r.typeName(), at)
            }
            is StringLiteral -> when(r) {
                is StringLiteral -> StringLiteral(l.value + r.value, at)
                else -> throw TypeError("string", r.typeName(), at)
            }
            else -> throw TypeError("int, float or string", l.typeName(), at)
        }

        fun applyMath(l: Literal, r: Literal, bothInt: (Int, Int) -> Int, withFloat: (Float, Float) -> Float, at: Pos) = when(l) {
            is IntLiteral -> when(r) {
                is IntLiteral -> IntLiteral(bothInt(l.value, r.value), at)
                is FloatLiteral -> FloatLiteral(withFloat(l.value.toFloat(), r.value), at)
                else -> throw TypeError("int or float", r.typeName(), at)
            }
            is FloatLiteral -> when(r) {
                is IntLiteral -> FloatLiteral(withFloat(l.value, r.value.toFloat()), at)
                is FloatLiteral -> FloatLiteral(withFloat(l.value, r.value), at)
                else -> throw TypeError("int or float", r.typeName(), at)
            }
            else -> throw TypeError("int or float", l.typeName(), at)
        }

        fun applyInts(l: Literal, r: Literal, action: (Int, Int) -> Int, at: Pos) = when(l) {
            is IntLiteral -> when(r) {
                is IntLiteral -> IntLiteral(action(l.value, r.value), at)
                else -> throw TypeError("int", r.typeName(), at)
            }
            else -> throw TypeError("int", l.typeName(), at)
        }

        fun applyBools(l: Literal, r: Literal, action: (Boolean, Boolean) -> Boolean, at: Pos) = when(l) {
            is BoolLiteral -> when(r) {
                is BoolLiteral -> BoolLiteral(action(l.value, r.value), at)
                else -> throw TypeError("bool", r.typeName(), at)
            }
            else -> throw TypeError("bool", l.typeName(), at)
        }

        fun applyComp(l: Literal, r: Literal, bothInt: (Int, Int) -> Boolean, withFloat: (Float, Float) -> Boolean, at: Pos) = when(l) {
            is IntLiteral -> when(r) {
                is IntLiteral -> BoolLiteral(bothInt(l.value, r.value), at)
                is FloatLiteral -> BoolLiteral(withFloat(l.value.toFloat(), r.value), at)
                else -> throw TypeError("int or float", r.typeName(), at)
            }
            is FloatLiteral -> when(r) {
                is IntLiteral -> BoolLiteral(withFloat(l.value, r.value.toFloat()), at)
                is FloatLiteral -> BoolLiteral(withFloat(l.value, r.value), at)
                else -> throw TypeError("int or float", r.typeName(), at)
            }
            else -> throw TypeError("int", l.typeName(), at)
        }

        fun applyEqual(l: Literal, r: Literal, at: Pos) = BoolLiteral(l == r, at)
    }
}