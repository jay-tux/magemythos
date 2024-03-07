package runtime

import runtime.ast.Pos
import runtime.ast.Value

sealed class RuntimeError(message: String) : Exception(message)

class VariableError(name: String, pos: Pos) :
        RuntimeError("Variable '$name' not found at $pos")

class TypeError(expected: String, actual: Value, pos: Pos) :
        RuntimeError("Type error: expected $expected, got ${actual.typeName()} at $pos")

class RuntimeInternalError(message: String) :
        RuntimeError("Internal error: $message")

class FieldError(type: String, name: String, pos: Pos) :
        RuntimeError("Field '$name' does not exist on $type; at $pos")

class MethodError(name: String, pos: Pos) :
        RuntimeError("Method '$name' does not exist (invocation attempted at $pos)")

class MemberError(name: String, type: String, pos: Pos) :
        RuntimeError("Member function '$name' does not exist on $type; at $pos")

class ImmutableError(name: String, pos: Pos) :
        RuntimeError("Variable '$name' is immutable; at $pos")

class RedeclarationError(name: String, declPos: Pos, pos: Pos) :
        RuntimeError("Redeclaration of '$name' at $pos; previous declaration at $declPos")

class NoValueError(pos: Pos) :
        RuntimeError("Assignment/Declaration requires a value, none given at $pos")

class BreakError(pos: Pos) :
        RuntimeError("Can't break when not inside a loop, at $pos")

class ArgumentCountError(name: String, got: Int, required: Int, pos: Pos) :
        RuntimeError("Wrong number of arguments for '$name': got $got, but requires $required; at $pos")

class ScopeException(call: String, pos: Pos) :
        RuntimeError("Library function $call requires a character scope, none available at $pos")

class ConversionError(from: String, to: String, pos: Pos) :
        RuntimeError("Cannot convert from $from to $to at $pos")

class IOBError(index: Int, size: Int, pos: Pos) :
        RuntimeError("Index $index out of bounds for size $size at $pos")

class ChoiceException(required: Int, got: Int, pos: Pos) :
        RuntimeError("Impossible choice at $pos: user should choose $required options, but only $got are given")

class NoFunctionError(name: String, pos: Pos) :
        RuntimeError("Function '$name' does not exist at $pos")