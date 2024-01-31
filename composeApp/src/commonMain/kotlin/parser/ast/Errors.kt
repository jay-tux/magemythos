package parser.ast

sealed class MMException(msg: String) : Exception(msg)

class TypeError(expected: String, actual: String, pos: Pos) :
    MMException("Expected $expected, got $actual at $pos")

class UndefinedVariable(name: String, pos: Pos) :
    MMException("Undefined variable $name at $pos")

class UndefinedFunction(name: String, pos: Pos) :
    MMException("Undefined function $name at $pos")

class InvalidMember(type: String, member: String, pos: Pos) :
    MMException("Type $type does not have a member field named $member, at $pos")

class ImmutableVariable(name: String, pos: Pos) :
    MMException("Variable $name is immutable at $pos")

class IndexOutOfBounds(index: Int, size: Int, pos: Pos) :
    MMException("Index $index is out of bounds for list of size $size at $pos")

class KeyError(key: Literal, pos: Pos) :
    MMException("Key ${key.repr()} not found at $pos")

class ZeroDivError(pos: Pos) :
    MMException("Division by zero at $pos")