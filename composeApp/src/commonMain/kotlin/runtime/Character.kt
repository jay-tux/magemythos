package runtime

import Ref.Companion.makeRef
import runtime.ast.ObjectValue
import runtime.ast.Pos
import runtime.ast.Value
import runtime.ast.VoidValue

class Character(private val choices: MutableMap<String, Value>) {

    fun registerChoice(name: String, result: Value) {
        choices[name] = result
    }
    fun retrieveChoice(name: String): Value? = choices[name]

    companion object {
        private val runtimePos = Pos("<runtime::CreateCharacter>", 0, 0)
        fun startBuilding(race: Race, subrace: Subrace?, clazz: Class, background: Background, scope: ChoiceScope): ExecutionIterator {
            val raceObj = ObjectValue(race, mapOf(), runtimePos)
            val subraceObj = subrace?.let { ObjectValue(it, mapOf(), runtimePos) }
            val classObj = ObjectValue(clazz, mapOf(), runtimePos)
            val backgroundObj = ObjectValue(background, mapOf(), runtimePos)

            val output = (VoidValue(runtimePos) as Value).makeRef()
            val iterator = Context.performAll(output, sequence {
                Library.choice = scope
                yield { attemptInvocation(raceObj, "onGain", listOf(), runtimePos) }
                subraceObj?.let { yield { attemptInvocation(it, "onGain", listOf(), runtimePos) } }
                yield { attemptInvocation(classObj, "onGain", listOf(), runtimePos) }
                yield { attemptInvocation(backgroundObj, "onGain", listOf(), runtimePos) }
                Library.choice = null
            })

            return iterator
        }
    }
}