package parser.ast

class Context {
    fun lookup(name: String): Variable? = TODO()
    fun call(name: String, expr: List<Literal>): Literal? = TODO()
    fun declare(name: String, value: Literal): Unit = TODO()
}