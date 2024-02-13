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

sealed class Declaration(pos: Pos) : Node(pos) {
    @Composable
    abstract fun ColumnScope.render(indent: Int)

    @Composable
    fun show(scope: ColumnScope, indent: Int) {
        scope.render(indent)
    }
}

sealed class BodyDeclaration(pos: Pos) : Declaration(pos)

class TypeDeclaration(
    val kind: String, val name: String, val tags: List<Tag>, val fields: List<MemberDeclaration>,
    val members: List<FunDeclaration>, pos: Pos
) : Declaration(pos)
{
    fun finalize() {
        tags.forEach { TagEffect.applyTag(this, it.name, it.arguments, it.pos) }
    }

    @Composable
    override fun ColumnScope.render(indent: Int) {
        var isOpen by remember { mutableStateOf(false) }
        var tagsOpen by remember { mutableStateOf(false) }
        var fieldsOpen by remember { mutableStateOf(false) }
        var membersOpen by remember { mutableStateOf(false) }

        indentedOpenClose(indent, isOpen, { isOpen = it }) {
            Text("$kind $name")
        }

        if (isOpen) {
            indentedOpenClose(indent + 1, tagsOpen, { tagsOpen = it }) {
                Text("Tags (${tags.size})")
            }

            if (tagsOpen) {
                tags.forEach { it.render(this@render, indent + 2) }
            }

            indentedOpenClose(indent + 1, fieldsOpen, { fieldsOpen = it }) {
                Text("Fields (${fields.size})")
            }

            if (fieldsOpen) {
                fields.forEach { it.show(this@render, indent + 2) }
            }

            indentedOpenClose(indent + 1, membersOpen, { membersOpen = it }) {
                Text("Members (${members.size})")
            }

            if (membersOpen) {
                members.forEach { it.show(this@render, indent + 2) }
            }
        }
    }
}

class FunDeclaration(
    val name: String, val params: List<String>, val body: List<Statement>, pos: Pos
) : BodyDeclaration(pos)
{
    @Composable
    override fun ColumnScope.render(indent: Int) {
        var isOpen by remember { mutableStateOf(false) }
        var bodyOpen by remember { mutableStateOf(false) }

        indentedOpenClose(indent, isOpen, { isOpen = it }) {
            Text("Fun $name")
        }

        if (isOpen) {
            indented(indent + 1) {
                Text("Parameters (${params.size}): ${params.joinToString(", ")}")
            }

            indentedOpenClose(indent + 1, bodyOpen, { bodyOpen = it }) {
                Text("Body")
            }

            if (bodyOpen) {
                body.forEach { it.show(this@render, indent + 2) }
            }
        }
    }
}

class Tag(val name: String, val arguments: List<Expression>, pos: Pos) : Node(pos) {
    @Composable
    fun render(scope: ColumnScope, indent: Int) {
        scope.run {
            indented(indent) {
                Text("Tag $name")
            }
            arguments.forEach { it.show(this, indent + 1) }
        }
    }
}

class GlobalDeclaration(val name: String, val value: Expression, pos: Pos) : Declaration(pos) {
    @Composable
    override fun ColumnScope.render(indent: Int) {
        indented(indent) {
            Text("Global constant $name")
        }
        value.show(this@render, indent + 1)
    }

}

class MemberDeclaration(val name: String, val value: Expression, val isConst: Boolean, pos: Pos) :
    BodyDeclaration(pos) {
    @Composable
    override fun ColumnScope.render(indent: Int) {
        indented(indent) {
            Text("Member ${if (isConst) "constant" else "field"} $name")
        }
        value.show(this@render, indent + 1)
    }
}