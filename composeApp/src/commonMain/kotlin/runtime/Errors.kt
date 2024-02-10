package runtime

import runtime.ast.Pos

sealed class RuntimeError(message: String) : Exception(message)

class VariableError(name: String, pos: Pos) :
        RuntimeError("Variable '$name' not found at $pos")

class TypeError(expected: String, actual: Class<*>, pos: Pos) :
        RuntimeError("Type error: expected $expected, got ${actual.simpleName} at $pos")

class RuntimeInternalError(message: String) :
        RuntimeError("Internal error: $message")

class FieldError(type: String, name: String, pos: Pos) :
        RuntimeError("Field '$name' does not exist on $type; at $pos")

class MethodError(name: String, pos: Pos) :
        RuntimeError("Method '$name' does not exist (invocation attempted at $pos)")

class MemberError(name: String, type: String, pos: Pos) :
        RuntimeError("Member function '$name' does not exist on $type; at $pos")