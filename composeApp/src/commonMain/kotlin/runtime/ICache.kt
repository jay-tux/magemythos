package runtime

import runtime.ast.FunDeclaration
import runtime.ast.TypeDeclaration

interface ICache {
    fun register(type: Type)
    fun register(fn: FunDeclaration)
    fun register(global: Variable)
    fun register(char: Character)

    fun getType(name: String): Type?
    fun getFunction(name: String): FunDeclaration?
    fun getGlobal(name: String): Variable?

    fun typeIterator(): Iterator<Type>
    fun functionIterator(): Iterator<FunDeclaration>
    fun globalIterator(): Iterator<Variable>
}