package runtime

import androidx.compose.runtime.toMutableStateMap
import runtime.ast.FunDeclaration
import runtime.ast.ObjectValue
import runtime.ast.Pos
import runtime.ast.Value

sealed class Invocation(val pos: Pos) {
    abstract fun checkArgCount()
    abstract fun mergeArgs(): Map<String, Variable>
}

class NormalInvocation(val target: FunDeclaration, val args: List<Value>, pos: Pos) : Invocation(pos) {
    override fun checkArgCount() {
        if (target.params.size != args.size)
            throw ArgumentCountError(target.name, target.params.size, args.size, pos)
    }

    override fun mergeArgs(): Map<String, Variable> {
        return target.params.zip(args).associate { (n, v) -> n to Variable(n, v, false, v.pos) }
    }
}

class MemberInvocation(val target: FunDeclaration, val scope: ObjectValue, val args: List<Value>, pos: Pos) : Invocation(pos) {
    override fun checkArgCount() {
        if (target.params.size != args.size)
            throw ArgumentCountError(target.name, target.params.size, args.size, pos)
    }

    override fun mergeArgs(): Map<String, Variable> {
        return target.params.zip(args).associate { (n, v) -> n to Variable(n, v, false, v.pos) }.toMutableMap()
    }
}

class LibraryInvocation(val target: String, val args: List<Value>, pos: Pos) : Invocation(pos) {
    override fun checkArgCount() = Unit
    override fun mergeArgs(): Map<String, Variable> = mapOf()
}
