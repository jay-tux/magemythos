package runtime

import runtime.ast.FunDeclaration
import runtime.ast.TypeDeclaration

interface ICache {
    fun register(type: TypeDeclaration)
    fun register(fn: FunDeclaration)
    fun register(global: Variable)

    fun getType(name: String): TypeDeclaration?
    fun getFunction(name: String): FunDeclaration?
    fun getGlobal(name: String): Variable?
}