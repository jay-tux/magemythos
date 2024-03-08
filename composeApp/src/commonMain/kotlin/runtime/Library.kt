package runtime

import Ref
import runtime.ast.ListValue
import runtime.ast.Pos
import runtime.ast.Value
import runtime.ast.VoidValue

data class ChoiceDesc(val name: String, val title: String, val count: Int, val options: List<Value>, val requiredAt: Pos)
interface ChoiceScope {
    operator fun invoke(what: ChoiceDesc)
}

object Library {
    private object Implementations {

    }

    var character: Character? = null
    var choice: ChoiceScope? = null

    fun invokeFunction(target: String, args: List<Value>, at: Pos): Value? = when(target) {
        // ......

        else -> throw NoFunctionError(target, at)
    }

    fun invokeChoice(target: String, args: List<Value>, at: Pos): Unit? = when(target) {
        // ......

        else -> throw NoFunctionError(target, at)
    }

    private fun <T> withCharacter(name: String, at: Pos, block: Character.() -> T): T =
        character?.let { it.block() } ?: throw ScopeException(name, at)

    private fun <T> withChoices(block: ChoiceScope.() -> T): T =
        choice?.let { it.block() } ?: throw RuntimeInternalError("No choice scope available")
}