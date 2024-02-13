package runtime

import runtime.ast.Pos
import runtime.ast.Value
import runtime.ast.VoidValue

data class Choice(val name: String, val desc: String, val corresponding: Value)
typealias ChoiceScope = (title: String, options: List<Choice>) -> Choice
typealias LibraryFunc = ExecutionIterator.(List<Value>, at: Pos) -> ExprExecutionIterator

object Library {
    private class FinishedIterator(val result: Value, override val parent: ExecutionIterator) : ExprExecutionIterator() {
        override fun currentlyExecuting(): ExecutionIterator = this

        override fun hasFinished(): Boolean = true

        override fun step() {
            throw RuntimeInternalError("Finished iterator should not be stepped")
        }

        override fun finalValue(): Value = result
    }
    private class ChoiceIterator(val title: String, val options: List<Choice>, override val parent: ExecutionIterator, pos: Pos) : ExprExecutionIterator() {
        var chosen: Choice? = null

        init {
            if(options.isEmpty()) throw ChoiceException(pos)
            if(options.size == 1) chosen = options[0]
        }

        override fun currentlyExecuting(): ExecutionIterator = this

        override fun hasFinished(): Boolean = chosen != null

        override fun step() {
            if(!hasFinished()) withChoices { chosen = this@withChoices(title, options) }
        }

        override fun finalValue(): Value = chosen?.corresponding ?: throw RuntimeInternalError("Choice not made but result requested")
    }

    var character: Character? = null
    var choice: ChoiceScope? = null

    private fun <T> withCharacter(name: String, at: Pos, block: Character.() -> T): T =
        character?.let { it.block() } ?: throw ScopeException(name, at)

    private fun <T> withChoices(block: ChoiceScope.() -> T): T =
        choice?.let { it.block() } ?: throw RuntimeInternalError("No choice scope available")

    private val libFuncs = mapOf<String, LibraryFunc>(
        "print" to { args: List<Value>, at: Pos -> println(args); FinishedIterator(VoidValue(at), this) }
    )

    fun invocationFor(name: String, args: List<Value>, at: Pos): Invocation? {
        return if(libFuncs.containsKey(name)) LibraryInvocation(name, args, at) else null
    }

    fun invoke(inv: LibraryInvocation, parent: ExecutionIterator): ExecutionIterator =
        libFuncs[inv.target]?.invoke(parent, inv.args, inv.pos) ?:
        throw RuntimeInternalError("Library function ${inv.target} not found")
}