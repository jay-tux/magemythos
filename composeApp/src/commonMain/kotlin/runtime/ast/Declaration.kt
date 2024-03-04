package runtime.ast

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import immutable
import ui.indented
import ui.indentedOpenClose

sealed class Declaration(val name: String, pos: Pos) : Node(pos)
sealed class BodyDeclaration(name: String, pos: Pos) : Declaration(name, pos)
class TypeDeclaration(
    val kind: String, name: String, val tags: List<Tag>, val fields: List<MemberDeclaration>,
    val members: List<FunDeclaration>, pos: Pos
) : Declaration(name, pos)

class FunDeclaration(
    name: String, val params: List<String>, body: List<Statement>, pos: Pos
) : BodyDeclaration(name, pos)
{
    private val _body: MutableList<Statement> = body.toMutableList()
    val body = _body.immutable()

    fun growBody(stmts: List<Statement>): Unit = _body.addAll(stmts).let{}
}

class Tag(val name: String, val arguments: List<Expression>, pos: Pos) : Node(pos)
class GlobalDeclaration(name: String, val value: Expression, pos: Pos) : Declaration(name, pos)
class MemberDeclaration(name: String, val value: Expression, val isConst: Boolean, pos: Pos) :
    BodyDeclaration(name, pos)