package runtime

import runtime.ast.FunDeclaration
import runtime.ast.ObjectValue
import runtime.ast.Value

sealed class Invocation

class NormalInvocation(val target: FunDeclaration, val args: List<Value>) : Invocation()

class MemberInvocation(val target: FunDeclaration, val scope: ObjectValue, val args: List<Value>) : Invocation()

class LibraryInvocation(val target: String, val args: List<Value>) : Invocation()
