package runtime

import runtime.ast.ObjectValue
import runtime.ast.Pos
import runtime.ast.Value

class Character(private val choices: MutableMap<String, Value>) {

    fun registerChoice(name: String, result: Value) {
        choices[name] = result
    }
    fun retrieveChoice(name: String): Value? = choices[name]

    companion object {
        private val runtimePos = Pos("<runtime::CreateCharacter>", 0, 0)

        class Builder(val name: String, val race: Race, val subrace: Subrace?, val clazz: Class, val background: Background) {
            private val choices = mutableMapOf<String, Value>()
            private var state = 0

            private fun selector(): ObjectValue = when(state) {
                0 -> ObjectValue(race, mapOf(), runtimePos)
                1 -> {
                    if(subrace != null) ObjectValue(subrace, mapOf(), runtimePos)
                    else {
                        state++
                        selector()
                    }
                }
                2 -> ObjectValue(clazz, mapOf(), runtimePos)
                3 -> ObjectValue(background, mapOf(), runtimePos)
                else -> throw IllegalStateException("Invalid state")
            }.also { state++ }

            suspend fun run(onChoice: suspend (ChoiceDesc) -> Unit) {
                Runtime.getLogger().logMessage(" -> Running creation (is continuation? ${DfsRuntime.isRunning()})")
                if(DfsRuntime.isRunning()) {
                    val temp = DfsRuntime.getInstance().runUntilChoice().leftOrNull()
                    if(temp != null) {
                        onChoice(temp)
                    }
                    else {
                        run(onChoice)
                    }
                }
                else {
                    Runtime.getLogger().logMessage("   -> Starting runtime with next selector")
                    DfsRuntime.ready(selector().also { Runtime.getLogger().logMessage("      -> Next selector is of type ${it.type::class.java.simpleName}") }, "onGain", listOf(), runtimePos)
                    run(onChoice)
                }
            }

            fun provideChoice(name: String, result: Value) {
                choices[name] = result
                if(DfsRuntime.isRunning()) DfsRuntime.getInstance().provideChoice(result)
            }

            fun doneRunning() = state == 4 && !DfsRuntime.isRunning()
        }
    }
}