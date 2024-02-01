package runtime.ast

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ui.indented
import ui.indentedOpenClose

sealed class Statement(pos: Pos) : Node(pos) {
    @Composable
    abstract fun ColumnScope.render(indent: Int)

    @Composable
    fun show(scope: ColumnScope, indent: Int) {
        scope.render(indent)
    }
}

class ExprStmt(val expr: Expression, pos: Pos) : Statement(pos) {
    @Composable
    override fun ColumnScope.render(indent: Int) {
        indented(indent) {
            Text("Expression Statement")
        }
        expr.show(this@render, indent + 1)
    }
}

enum class DeclarationType { ASSIGN, VAR, CONST }

class AssignmentStmt(val name: String, val expr: Expression, val type: DeclarationType, pos: Pos) : Statement(pos) {
    @Composable
    override fun ColumnScope.render(indent: Int) {
        var isOpen by remember { mutableStateOf(false) }
        indentedOpenClose(indent, isOpen, { isOpen = it }) {
            when(type) {
                DeclarationType.ASSIGN -> Text("Assignment to $name")
                DeclarationType.VAR -> Text("Declaration of variable $name")
                DeclarationType.CONST -> Text("Declaration of constant $name")
            }
        }
        if(isOpen)
            expr.show(this@render, indent + 1)
    }
}

class IfStmt(val condition: Expression, val bodyTrue: List<Statement>, val bodyFalse: List<Statement>?, pos: Pos) : Statement(pos) {
    @Composable
    override fun ColumnScope.render(indent: Int) {
        var isOpen by remember { mutableStateOf(false) }
        indentedOpenClose(indent, isOpen, { isOpen = it }) {
            Text("If statement")
        }
        if(isOpen) {
            condition.show(this@render, indent + 1)
            indented(indent + 1) {
                Text("True branch")
            }
            bodyTrue.forEach { it.show(this@render, indent + 2) }
            if(bodyFalse != null) {
                indented(indent + 1) {
                    Text("False branch")
                }
                bodyFalse.forEach { it.show(this@render, indent + 2) }
            }
        }
    }
}

class WhileStmt(val condition: Expression, val body: List<Statement>, pos: Pos) : Statement(pos) {
    @Composable
    override fun ColumnScope.render(indent: Int) {
        var isOpen by remember { mutableStateOf(false) }
        indentedOpenClose(indent, isOpen, { isOpen = it }) {
            Text("While statement")
        }
        if(isOpen) {
            condition.show(this@render, indent + 1)
            indented(indent + 1) {
                Text("Body")
            }
            body.forEach { it.show(this@render, indent + 2) }
        }
    }
}

class ForStmt(val name: String, val set: Expression, val body: List<Statement>, pos: Pos) : Statement(pos) {
    @Composable
    override fun ColumnScope.render(indent: Int) {
        var isOpen by remember { mutableStateOf(false) }
        indentedOpenClose(indent, isOpen, { isOpen = it }) {
            Text("For statement")
        }
        if(isOpen) {
            indented(indent + 1) {
                Text("Name: $name")
            }
            set.show(this@render, indent + 1)
            indented(indent + 1) {
                Text("Body")
            }
            body.forEach { it.show(this@render, indent + 2) }
        }
    }
}

class ReturnStmt(val expr: Expression?, pos: Pos) : Statement(pos) {
    @Composable
    override fun ColumnScope.render(indent: Int) {
        indented(indent) {
            Text("Return statement")
        }
        expr?.show(this@render, indent + 1)
    }
}

class BreakStmt(pos: Pos) : Statement(pos) {
    @Composable
    override fun ColumnScope.render(indent: Int) {
        indented(indent) {
            Text("Break statement")
        }
    }
}