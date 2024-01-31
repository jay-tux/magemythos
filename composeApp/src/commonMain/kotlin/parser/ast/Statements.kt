package parser.ast

sealed class Statement(pos: Pos) : AstNode(pos) {
    abstract fun execute(c: Context)
}

class ExprStmt(private val expr: Expression, pos: Pos) : Statement(pos) {
    override fun execute(c: Context) {
        expr.evaluate(c)
    }
}

class StmtBlock(private val stmts: List<Statement>, pos: Pos) : Statement(pos) {
    override fun execute(c: Context) {
        // TODO: handle return, break
        stmts.forEach { it.execute(c) }
    }
}

class IfStmt(private val cond: Expression, private val then: Statement, private val otherwise: Statement?, pos: Pos) : Statement(pos) {
    override fun execute(c: Context) {
        val condVal = cond.evaluate(c)
        if (condVal is BoolLiteral) {
            if (condVal.value) {
                then.execute(c)
            } else {
                otherwise?.execute(c)
            }
        } else {
            throw TypeError("bool", condVal.typeName(), pos)
        }
    }
}

class WhileStmt(private val cond: Expression, private val body: Statement, pos: Pos) : Statement(pos) {
    override fun execute(c: Context) {
        var condVal = cond.evaluate(c)
        while (condVal is BoolLiteral && condVal.value) {
            body.execute(c)
            condVal = cond.evaluate(c)
        }
        if(condVal !is BoolLiteral) {
            throw TypeError("bool", condVal.typeName(), pos)
        }
    }
}

class ForStmt(private val name: String, private val expr: Expression, private val body: Statement, pos: Pos) : Statement(pos) {
    override fun execute(c: Context) {
        val list = expr.evaluate(c)
        // TODO: iteration? Is iterable?
        TODO()
    }
}

class AssignStmt(private val lvalue: LValue, private val expr: Expression, pos: Pos) : Statement(pos) {
    override fun execute(c: Context) {
        val v = expr.evaluate(c)
        if(lvalue.canBeDeclaration()) {
            c.lookup(lvalue.name)?.update(v) ?: c.declare(lvalue.name, v)
        }
        else {
            lvalue.evaluate(c).update(v)
        }
    }
}

class BreakStmt(pos: Pos) : Statement(pos) {
    override fun execute(c: Context) {
        TODO()
    }
}

class ReturnStmt(private val expr: Expression?, pos: Pos) : Statement(pos) {
    override fun execute(c: Context) {
        TODO()
    }
}