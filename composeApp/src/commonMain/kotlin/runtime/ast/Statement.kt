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

sealed class Statement(pos: Pos) : Node(pos)

class ExprStmt(val expr: Expression, pos: Pos) : Statement(pos)
enum class DeclarationType { ASSIGN, VAR, CONST }
class AssignmentStmt(val name: String, val expr: Expression, val type: DeclarationType, pos: Pos) : Statement(pos)
class IfStmt(val condition: Expression, val bodyTrue: List<Statement>, val bodyFalse: List<Statement>?, pos: Pos) : Statement(pos)
class WhileStmt(val condition: Expression, val body: List<Statement>, pos: Pos) : Statement(pos)
class ForStmt(val name: String, val set: Expression, val body: List<Statement>, pos: Pos) : Statement(pos)
class ReturnStmt(val expr: Expression?, pos: Pos) : Statement(pos)
class BreakStmt(pos: Pos) : Statement(pos)