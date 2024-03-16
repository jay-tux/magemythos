package runtime

import runtime.ast.FunDeclaration
import runtime.ast.TypeDeclaration
import runtime.ast.Variable

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
    fun characterIterator(): Iterator<Character>
}

inline fun <reified T : Type> ICache.typesOfKind(): List<T> = typeIterator().asSequence().filterIsInstance<T>().toList()
fun ICache.subracesFor(race: Race): List<Subrace> =
    if(!race.hasSubraces) listOf()
    else typesOfKind<Subrace>().filter { it.baseRace == race }