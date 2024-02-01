package runtime.ast

sealed class AstError(message: String) : Exception(message)

class NodeNullError(expect: Class<*>) :
    AstError("Unexpected null node, expected a ${expect.simpleName}")

class InvalidNodeTypeError(expect: Class<*>, actual: Class<*>) :
    AstError("Invalid node type, expected a ${expect.simpleName}, got a ${actual.simpleName}")

class InvalidOperatorError(op: String, pos: Pos) :
    AstError("Nonexistent operator: $op at $pos")

class LiteralError(expected: String, actual: String, pos: Pos) :
    AstError("Invalid literal, expected a(n) $expected, got '$actual' at $pos")

class SyntaxError(message: String, pos: Pos) : AstError("$message at $pos")