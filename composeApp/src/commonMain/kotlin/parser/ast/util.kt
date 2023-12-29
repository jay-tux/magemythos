package parser.ast

import org.antlr.v4.runtime.ParserRuleContext

fun <K, V> List<Map<K, V>>.merge() = this.fold(mapOf<K, V>()) { acc, map ->
    acc + map
}

fun <T> nonNull(l: List<T>?) = l ?: listOf()

fun ParserRuleContext.toPos(file: String): Pos = Pos(file, this.start.line, this.start.charPositionInLine)

fun String.relativeTo(other: String): String {
    val parts = other.split("/")
    return parts.notLast().joinToString("/") + "/" + this
}

fun <T> List<T>.notLast() = this.subList(0, this.size - 1)