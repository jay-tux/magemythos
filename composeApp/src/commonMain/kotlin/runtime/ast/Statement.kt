package runtime.ast

import runtime.DfsRuntime
import runtime.RuntimeInternalError
import runtime.TypeError

sealed class Statement(pos: Pos) : Node(pos) {
    abstract fun mkState(): DfsRuntime.IStatementState
}

class ExprStmt(val expr: Expression, pos: Pos) : Statement(pos) {
    override fun mkState(): DfsRuntime.IStatementState = object : DfsRuntime.IStatementState {
        private var ran = false
        override fun isFinished(): Boolean = ran
        override fun step(scope: DfsRuntime.IStatementScope) {
            scope.onExpr(expr)
            ran = true
        }
        override fun onValue(v: Value) {}
    }
}
enum class DeclarationType { ASSIGN, VAR, CONST }
class AssignmentStmt(val name: String, val expr: Expression, val type: DeclarationType, pos: Pos) : Statement(pos) {
    override fun mkState(): DfsRuntime.IStatementState = object : DfsRuntime.IStatementState {
        private lateinit var result: Value
        private var ran = false

        override fun isFinished(): Boolean = ran
        override fun step(scope: DfsRuntime.IStatementScope) {
            if(!::result.isInitialized) scope.onExpr(expr)
            else {
                scope.onAssign(type, name, result, pos)
                ran = true
            }
        }
        override fun onValue(v: Value) {
            if(::result.isInitialized) throw RuntimeInternalError("Assignment statement received unexpected value.")
            result = v
        }
    }

}
class IfStmt(val condition: Expression, val bodyTrue: List<Statement>, val bodyFalse: List<Statement>?, pos: Pos) : Statement(pos) {
    override fun mkState(): DfsRuntime.IStatementState = object : DfsRuntime.IStatementState {
        private var ran = false
        private var result: Boolean? = null

        override fun isFinished(): Boolean = ran
        override fun step(scope: DfsRuntime.IStatementScope) {
            result?.let {
                if(it) scope.onMkBlock(bodyTrue, pos)
                else bodyFalse?.let { bf -> scope.onMkBlock(bf, pos) }
                ran = true
            } ?: scope.onExpr(condition)
        }
        override fun onValue(v: Value) {
            if(result != null) throw RuntimeInternalError("If statement received unexpected value.")
            result = v.require<BoolValue>("boolean", pos).value
        }
    }

}
class WhileStmt(val condition: Expression, val body: List<Statement>, pos: Pos) : Statement(pos) {
    override fun mkState(): DfsRuntime.IStatementState = object : DfsRuntime.IStatementState {
        // 0 -> 1: eval condition
        // 1 -> 2: condition true
        // 1 -> 3: condition false
        // 2 -> 0: run body
        private var state = 0
        private var conditionResult = false

        override fun isFinished(): Boolean = state == 3
        override fun step(scope: DfsRuntime.IStatementScope) {
            when(state) {
                0 -> { scope.onExpr(condition); state = 1 }
                1 -> { state = if(conditionResult) 2 else 3; step(scope) } // shouldn't happen???
                2 -> { scope.onMkLoop(body, emptyMap(), pos); state = 0 }
                3 -> { throw RuntimeInternalError("While loop continued past end point.") }
            }
        }
        override fun onValue(v: Value) {
            if(state == 0) {
                conditionResult = v.require<BoolValue>("boolean", pos).value
                state = if (conditionResult) 2 else 3
            }
            else {
                throw RuntimeInternalError("While loop received unexpected value.")
            }
        }
    }
}
class ForStmt(val name: String, val set: Expression, val body: List<Statement>, pos: Pos) : Statement(pos) {
    override fun mkState(): DfsRuntime.IStatementState = object : DfsRuntime.IStatementState {
        // 0 -> 1: eval set
        // 1 -> 1: set is non-empty, run body
        // 1 -> 2: set is empty
        private var state = 0
        private lateinit var setIter: Iterator<Value>

        override fun isFinished(): Boolean = state == 3
        override fun step(scope: DfsRuntime.IStatementScope) {
            when(state) {
                0 -> { scope.onExpr(set); state = 1 }
                1 -> {
                    if(setIter.hasNext()) {
                        val value = setIter.next()
                        scope.onMkLoop(body, mapOf(name to value), pos)
                    } else state = 2
                }
                2 -> { throw RuntimeInternalError("For loop continued past end point.") }
            }
        }
        override fun onValue(v: Value) {
            if(!::setIter.isInitialized) {
                setIter = when(v) {
                    is ListValue -> v.value.iterator()
                    is RangeValue -> (v.start..v.endIncl).map { IntValue(it, pos) }.iterator()
                    else -> throw TypeError("iterable (list or range)", v, pos)
                }
            }
            else {
                throw RuntimeInternalError("For loop received unexpected value.")
            }
        }
    }

}
class ReturnStmt(val expr: Expression?, pos: Pos) : Statement(pos) {
    override fun mkState(): DfsRuntime.IStatementState = object : DfsRuntime.IStatementState {
        private lateinit var result: Value
        private var ran = false
        override fun isFinished(): Boolean = ran
        override fun step(scope: DfsRuntime.IStatementScope) {
            if(expr == null) {
                scope.onReturn(VoidValue(pos))
                ran = true
            }
            else if(!::result.isInitialized) scope.onExpr(expr)
            else {
                scope.onReturn(result)
                ran = true
            }
        }
        override fun onValue(v: Value) {
            if(::result.isInitialized) throw RuntimeInternalError("Return statement received unexpected value.")
            result = v
        }
    }

}
class BreakStmt(pos: Pos) : Statement(pos) {
    override fun mkState(): DfsRuntime.IStatementState = object : DfsRuntime.IStatementState {
        private var ran = false
        override fun isFinished(): Boolean = ran
        override fun step(scope: DfsRuntime.IStatementScope) {
            scope.onBreak(pos)
            ran = true
        }
        override fun onValue(v: Value) {
            throw RuntimeInternalError("Break statement received unexpected value.")
        }
    }
}