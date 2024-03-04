package runtime.ast

sealed class AstError(message: String) : Exception(message)

class ArbitraryAstError(message: String) : AstError(message)

class NodeNullError(expect: Class<*>) :
    AstError("Unexpected null node, expected a ${expect.simpleName}")

class InvalidNodeTypeError(expect: Class<*>, actual: Class<*>) :
    AstError("Invalid node type, expected a ${expect.simpleName}, got a ${actual.simpleName}")

class InvalidOperatorError(op: String, pos: Pos) :
    AstError("Nonexistent operator: $op at $pos")

class LiteralError(expected: String, actual: String, pos: Pos) :
    AstError("Invalid literal, expected a(n) $expected, got '$actual' at $pos")

class SyntaxError(message: String, pos: Pos) : AstError("$message at $pos")

class InvalidTagError(name: String, pos: Pos) : AstError("Tag '$name' does not exist; attempted to use at $pos")

class TagArgumentError(name: String, req: Int, got: Int, pos: Pos) :
        AstError("Tag '$name' requires $req arguments, got $got at $pos")

class TagInvalidReceiverError(name: String, kind: String, pos: Pos) :
        AstError("Tag '$name' is not valid for a type of kind '$kind' at $pos")

class InvalidKindError(name: String, kind: String, pos: Pos) :
    AstError("Type '$name' declared with invalid kind '$kind' at $pos")

class InvalidObjectTypeError(expected: String, got: String, pos: Pos) :
    AstError("Invalid object type, expected a(n) $expected, got a(n) $got at $pos")

class RedeclarationError(name: String, ogPos: Pos, pos: Pos) :
    AstError("Redeclaration of '$name' at $pos (first declared at $ogPos)")

class MissingTagError(name: String, type: String, what: String, tag: String, pos: Pos) :
        AstError("$type $name has no associated $what (declared at $pos). Did you forget to use $tag?")