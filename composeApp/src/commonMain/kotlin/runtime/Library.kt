package runtime

import runtime.ast.ListValue
import runtime.ast.Pos
import runtime.ast.Value
import runtime.ast.VoidValue

data class Choice(val name: String, val desc: String, val corresponding: Value)
typealias ChoiceScope = (title: String, count: Int, options: List<Choice>) -> List<Choice>
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
    private class ChoiceIterator(val title: String, val options: List<Choice>, val count: Int, override val parent: ExecutionIterator, val pos: Pos) : ExprExecutionIterator() {
        var chosen: Value? = null

        init {
            if(options.size < count) throw ChoiceException(count, options.size, pos)
            if(options.size == count) {
                chosen = if(count == 1) options[0].corresponding
                else ListValue(options.map { it.corresponding }, pos)
            }
        }

        override fun currentlyExecuting(): ExecutionIterator = this

        override fun hasFinished(): Boolean = chosen != null

        override fun step() {
            if(!hasFinished()) withChoices {
                val temp = this@withChoices(title, count, options)
                chosen = if(temp.size == 1) temp[0].corresponding else ListValue(temp.map { it.corresponding }, pos)

            }
        }

        override fun finalValue(): Value = chosen ?: throw RuntimeInternalError("Choice not made but result requested")
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