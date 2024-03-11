package runtime.library

import runtime.Ability
import runtime.ArbitraryRuntimeError
import runtime.ArgumentCountError
import runtime.Library
import runtime.Runtime
import runtime.ast.IntValue
import runtime.ast.Pos
import runtime.ast.Value
import runtime.ast.VoidValue

fun checkArgCount(name: String, args: List<Value>, expected: Int, at: Pos) {
    if(args.size != expected) throw ArgumentCountError(name, expected, args.size, at)
}

fun print(args: List<Value>): Value {
    Runtime.getLogger().logMessage(args.joinToString(" ") { it.toString() })
    return VoidValue(Pos("<runtime::Library>", 0, 0))
}