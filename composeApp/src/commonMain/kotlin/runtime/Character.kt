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
    }
}