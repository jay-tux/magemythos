package runtime

import runtime.ast.Value

class Character(private val choices: MutableMap<String, Value>) {

    fun registerChoice(name: String, result: Value) {
        choices[name] = result
    }
    fun retrieveChoice(name: String): Value? = choices[name]
}