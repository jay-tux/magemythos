package runtime.ast

class Context {
}

class Variable(val name: String, v: Value, val mutable: Boolean, pos: Pos) {
    var value: Value = v
        private set
}