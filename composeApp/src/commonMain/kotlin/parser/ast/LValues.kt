package parser.ast

sealed class LValueTail(pos: Pos) : AstNode(pos) {
    abstract fun evaluate(c: Context, v: Variable): Variable
}

class ObjectMemberTail(private val member: String, pos: Pos) : LValueTail(pos) {
    override fun evaluate(c: Context, v: Variable): Variable = when(val vl = v.value) {
        is ObjectLiteral -> when(val m = vl.lookup(member)) {
            null -> throw InvalidMember(vl.type, member, pos)
            else -> m
        }
        else -> throw TypeError("object", vl.typeName(), pos)
    }
}

class IndexTail(private val index: Expression, pos: Pos) : LValueTail(pos) {
    override fun evaluate(c: Context, v: Variable): Variable {
        val idx = index.evaluate(c)
        return IndexExpr.performIndexing(v.value, idx, pos)
    }
}

class LValue(val name: String, private val tail: List<LValueTail>, pos: Pos) : AstNode(pos) {
    fun evaluate(c: Context): Variable {
        val v = c.lookup(name) ?: throw UndefinedVariable(name, pos)
        return tail.fold(v) { acc, t -> t.evaluate(c, acc) }
    }

    fun canBeDeclaration(): Boolean = tail.isEmpty()
}