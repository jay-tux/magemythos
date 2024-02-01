package runtime.ast

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.atn.ATNConfigSet
import org.antlr.v4.runtime.dfa.DFA
import runtime.ast.BinaryOperator.Companion.match
import runtime.ast.DiceValue.Companion.toDiceOrNull
import runtime.ast.RollValue.Companion.toRollOrNull
import runtime.parser.MMBaseVisitor
import runtime.parser.MMLexer
import runtime.parser.MMParser
import ui.indented
import java.io.InputStream
import java.util.BitSet

typealias Provider = (source: String, file: String) -> InputStream

fun ParserRuleContext.toPos(file: String): Pos = Pos(file, start.line, start.charPositionInLine)
fun Token.toPos(file: String): Pos = Pos(file, line, charPositionInLine)

inline fun <reified T, R> nonNull(v: T?, withT: (T) -> R): R = v?.let(withT) ?: throw NodeNullError(T::class.java)
inline fun <reified T: Node> Node.require(): T = this as? T ?: throw InvalidNodeTypeError(T::class.java, this::class.java)

inline fun <reified T> List<T?>.withNonNull(withT: (T) -> Unit): Unit = forEach { nonNull(it, withT) }
inline fun <reified T, R> List<T?>.mapNonNull(withT: (T) -> R): List<R> = map { nonNull(it, withT) }

class AntlrListener(val file: String) : BaseErrorListener() {
    override fun syntaxError(recognizer: Recognizer<*, *>?, offendingSymbol: Any?, line: Int, charPositionInLine: Int, msg: String?, e: RecognitionException?) {
        throw SyntaxError(msg ?: "Unknown error", Pos(file, line, charPositionInLine))
    }
}

class Ast(val source: String, val deps: Map<String, List<String>>, val content: List<Declaration>, pos: Pos) : Node(pos) {
    @Composable
    fun render() {
        LazyColumn(Modifier.fillMaxSize()) {
            item {
                Text("File ${pos.file} (source $source)")
            }
            item {
                indented(1) { Text("Dependencies:") }
            }
            items(deps.toList()) {
                indented(2) {
                    Text("From source ${it.first}: ${it.second.joinToString(", ")}")
                }
            }
            item {
                indented(1) { Text("Content (${content.size} declarations):") }
            }

            for(c in content) {
                item {
                    Column {
                        c.show(this, 2)
                    }
                }
            }
        }
    }
}

class HelperNodes {
    class ListNode<T : Node>(val values: List<T>, pos: Pos) : Node(pos)
    class StringListNode(val values: List<String>, pos: Pos) : Node(pos)
    class ImportNode(val source: String, val deps: List<String>, pos: Pos) : Node(pos)
    class PreambleNode(val source: String, val deps: Map<String, List<String>>, pos: Pos) : Node(pos)
    class ValueNode(val value: Value) : Node(value.pos)
}

class AstBuilder(private val sourceFile: String) : MMBaseVisitor<Node>() {
    private inline fun <reified T: Node> visitRequire(ctx: ParserRuleContext): T = visit(ctx).require<T>()
    private inline fun <reified T: Node> fullVisit(ctx: ParserRuleContext?): T = nonNull(ctx) { visitRequire<T>(it) }
    private inline fun <reified T: Node> List<ParserRuleContext?>.visitAll(): List<T> = map { fullVisit<T>(it) }

    //region Program/Preamble
    override fun visitProgram(ctx: MMParser.ProgramContext?): Node = nonNull(ctx) { c ->
        val preamble: HelperNodes.PreambleNode = visitRequire(c.preamble())
        val body = mutableListOf<Declaration>()
        c.declaration().withNonNull {
            when(val temp = visit(it)) {
                is Declaration -> body.add(temp)
                is HelperNodes.ListNode<*> -> {
                    body.addAll(temp.values.map { v -> v.require<Declaration>() })
                }
                else -> throw InvalidNodeTypeError(Declaration::class.java, temp::class.java)
            }
        }
        Ast(preamble.source, preamble.deps, body, c.toPos(sourceFile))
    }

    override fun visitPreamble(ctx: MMParser.PreambleContext?): Node = nonNull(ctx) { c ->
        val deps = mutableMapOf<String, MutableList<String>>()
        c.deps.withNonNull{
            visitRequire<HelperNodes.ImportNode>(it).let { i ->
                deps[i.source]?.addAll(i.deps) ?: deps.put(i.source, i.deps.toMutableList())
            }
        }

        HelperNodes.PreambleNode(
            c.ID().text,
            deps,
            c.toPos(sourceFile)
        )
    }

    override fun visitDependency(ctx: MMParser.DependencyContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ImportNode(
            nonNull(c.src) { it.text },
            visitRequire<HelperNodes.StringListNode>(c.idList()).values,
            c.toPos(sourceFile)
        )
    }
    //endregion

    //region Declarations
    override fun visitSimpleDecl(ctx: MMParser.SimpleDeclContext?): Node = nonNull(ctx) { c ->
        TypeDeclaration(
            nonNull(c.kind) { it.text },
            nonNull(c.name) { it.text },
            c.tags?.let { visitRequire<HelperNodes.ListNode<Tag>>(it).values } ?: listOf(),
            listOf(),
            listOf(),
            c.toPos(sourceFile)
        )
    }

    override fun visitFullDecl(ctx: MMParser.FullDeclContext?): Node = nonNull(ctx) { c ->
        val body = c.body.visitAll<BodyDeclaration>()

        TypeDeclaration(
            nonNull(c.kind) { it.text },
            nonNull(c.name) { it.text },
            c.tags?.let { visitRequire<HelperNodes.ListNode<Tag>>(it).values } ?: listOf(),
            body.filterIsInstance<MemberDeclaration>(),
            body.filterIsInstance<FunDeclaration>(),
            c.toPos(sourceFile)
        )
    }

    override fun visitMultipleDecl(ctx: MMParser.MultipleDeclContext?): Node = nonNull(ctx) { c ->
        val tags = fullVisit<HelperNodes.ListNode<Tag>>(c.tags).values
        val kind = nonNull(c.kind) { it.text }

        HelperNodes.ListNode(nonNull(c.names) { l ->
            visitRequire<HelperNodes.StringListNode>(l).values.map {
                TypeDeclaration(
                    kind,
                    it,
                    tags,
                    listOf(),
                    listOf(),
                    l.toPos(sourceFile)
                )
            }
        }, c.toPos(sourceFile))
    }

    override fun visitFunction(ctx: MMParser.FunctionContext?): Node = nonNull(ctx) {
        visitRequire<FunDeclaration>(it.funDecl())
    }

    override fun visitGlobal(ctx: MMParser.GlobalContext?): Node = nonNull(ctx) {
        visitRequire<GlobalDeclaration>(it.globalDecl())
    }

    override fun visitMemberFunc(ctx: MMParser.MemberFuncContext?): Node = nonNull(ctx) {
        visitRequire<FunDeclaration>(it.funDecl())
    }

    override fun visitMemberConst(ctx: MMParser.MemberConstContext?): Node = nonNull(ctx) {
        val temp = visitRequire<GlobalDeclaration>(it.globalDecl())
        MemberDeclaration(temp.name, temp.value, true, temp.pos)
    }

    override fun visitMemberField(ctx: MMParser.MemberFieldContext?): Node = nonNull(ctx) { c ->
        MemberDeclaration(
            nonNull(c.name) { it.text },
            fullVisit(c.expr()),
            false,
            c.toPos(sourceFile)
        )
    }

    override fun visitFunDecl(ctx: MMParser.FunDeclContext?): Node = nonNull(ctx) { c ->
        FunDeclaration(
            nonNull(c.name) { it.text },
            c.args?.let { visitRequire<HelperNodes.StringListNode>(it).values } ?: listOf(),
            c.body.visitAll(),
            c.toPos(sourceFile)
        )
    }

    override fun visitGlobalDecl(ctx: MMParser.GlobalDeclContext?): Node = nonNull(ctx) { c ->
        GlobalDeclaration(
            nonNull(c.name) { it.text },
            fullVisit(c.value),
            c.toPos(sourceFile)
        )
    }

    override fun visitTagList(ctx: MMParser.TagListContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ListNode(
            c.tags.visitAll(),
            c.toPos(sourceFile)
        )
    }

    override fun visitSimpleTag(ctx: MMParser.SimpleTagContext?): Node = nonNull(ctx) { c ->
        Tag(
            nonNull(c.name) { it.text },
            listOf(),
            c.toPos(sourceFile)
        )
    }

    override fun visitParamTag(ctx: MMParser.ParamTagContext?): Node = nonNull(ctx) { c ->
        Tag(
            nonNull(c.name) { it.text },
            c.args?.let { visitRequire<HelperNodes.ListNode<Expression>>(it).values } ?: listOf(),
            c.toPos(sourceFile)
        )
    }
    //endregion

    //region Statements
    override fun visitExprStmt(ctx: MMParser.ExprStmtContext?): Node = nonNull(ctx) { c ->
        ExprStmt(
            fullVisit(c.expr()),
            c.toPos(sourceFile)
        )
    }

    override fun visitVarDecl(ctx: MMParser.VarDeclContext?): Node = nonNull(ctx) { c ->
        AssignmentStmt(
            nonNull(c.name) { it.text },
            fullVisit(c.value),
            DeclarationType.VAR,
            c.toPos(sourceFile)
        )
    }

    override fun visitConstDecl(ctx: MMParser.ConstDeclContext?): Node = nonNull(ctx) { c ->
        AssignmentStmt(
            nonNull(c.name) { it.text },
            fullVisit(c.value),
            DeclarationType.CONST,
            c.toPos(sourceFile)
        )
    }

    override fun visitAssignStmt(ctx: MMParser.AssignStmtContext?): Node = nonNull(ctx) { c ->
        AssignmentStmt(
            nonNull(c.name) { it.text },
            fullVisit(c.value),
            DeclarationType.ASSIGN,
            c.toPos(sourceFile)
        )
    }

    override fun visitIfStmt(ctx: MMParser.IfStmtContext?): Node = nonNull(ctx) { c ->
        IfStmt(
            fullVisit(c.cond),
            c.body.visitAll(),
            null,
            c.toPos(sourceFile)
        )
    }

    override fun visitIfElseStmt(ctx: MMParser.IfElseStmtContext?): Node = nonNull(ctx) { c ->
        IfStmt(
            fullVisit(c.cond),
            c.bTrue.visitAll(),
            c.bFalse.visitAll(),
            c.toPos(sourceFile)
        )
    }

    override fun visitWhileStmt(ctx: MMParser.WhileStmtContext?): Node = nonNull(ctx) { c ->
        WhileStmt(
            fullVisit(c.cond),
            c.body.visitAll(),
            c.toPos(sourceFile)
        )
    }

    override fun visitForStmt(ctx: MMParser.ForStmtContext?): Node = nonNull(ctx) { c ->
        ForStmt(
            nonNull(c.v) { it.text },
            fullVisit(c.set),
            c.body.visitAll(),
            c.toPos(sourceFile)
        )
    }

    override fun visitBreakStmt(ctx: MMParser.BreakStmtContext?): Node = nonNull(ctx) { c ->
        BreakStmt(c.toPos(sourceFile))
    }

    override fun visitReturnStmt(ctx: MMParser.ReturnStmtContext?): Node = nonNull(ctx) { c ->
        ReturnStmt(
            c.e?.let { visitRequire(it) },
            c.toPos(sourceFile)
        )
    }
    //endregion

    //region Expressions
    override fun visitLiteralExpr(ctx: MMParser.LiteralExprContext?): Node = nonNull(ctx) { c ->
        LiteralExpression(visitRequire<HelperNodes.ValueNode>(c.literal()).value, c.toPos(sourceFile))
    }

    override fun visitNameExpr(ctx: MMParser.NameExprContext?): Node = nonNull(ctx) { c ->
        VariableExpression(
            c.ID().text,
            c.toPos(sourceFile)
        )
    }

    override fun visitListExpr(ctx: MMParser.ListExprContext?): Node = nonNull(ctx) { c ->
        ListExpression(
            c.exprs?.let { visitRequire<HelperNodes.ListNode<Expression>>(it).values } ?: listOf(),
            c.toPos(sourceFile)
        )
    }

    override fun visitCallExpr(ctx: MMParser.CallExprContext?): Node = nonNull(ctx) { c ->
        CallExpression(
            c.ID().text,
            c.args?.let { visitRequire<HelperNodes.ListNode<Expression>>(it).values } ?: listOf(),
            c.toPos(sourceFile)
        )
    }

    override fun visitParenExpr(ctx: MMParser.ParenExprContext?): Node = nonNull(ctx) { c ->
        fullVisit(c.e)
    }

    override fun visitIndexExpr(ctx: MMParser.IndexExprContext?): Node = nonNull(ctx) { c ->
        IndexExpression(
            fullVisit(c.base),
            fullVisit(c.index),
            c.toPos(sourceFile)
        )
    }

    override fun visitMemberExpr(ctx: MMParser.MemberExprContext?): Node = nonNull(ctx) { c ->
        MemberExpression(
            fullVisit(c.base),
            nonNull(c.name) { it.text },
            c.toPos(sourceFile)
        )
    }

    override fun visitMemberCallExpr(ctx: MMParser.MemberCallExprContext?): Node = nonNull(ctx) { c ->
        MemberCallExpression(
            fullVisit(c.base),
            nonNull(c.name) { it.text },
            c.args?.let { visitRequire<HelperNodes.ListNode<Expression>>(it).values } ?: listOf(),
            c.toPos(sourceFile)
        )
    }

    override fun visitUnaryExpr(ctx: MMParser.UnaryExprContext?): Node = nonNull(ctx) { c ->
        UnaryExpression(
            nonNull(c.op) { UnaryOperator.match(it.text, it.toPos(sourceFile)) },
            fullVisit(c.expr()),
            c.toPos(sourceFile)
        )
    }

    override fun visitMulExpr(ctx: MMParser.MulExprContext?): Node = nonNull(ctx) { c ->
        BinaryExpression(
            nonNull(c.op) { BinaryOperator.match(it.text, it.toPos(sourceFile)) },
            fullVisit(c.left),
            fullVisit(c.right),
            c.toPos(sourceFile)
        )
    }

    override fun visitAddExpr(ctx: MMParser.AddExprContext?): Node = nonNull(ctx) { c ->
        BinaryExpression(
            nonNull(c.op) { BinaryOperator.match(it.text, it.toPos(sourceFile)) },
            fullVisit(c.left),
            fullVisit(c.right),
            c.toPos(sourceFile)
        )
    }

    override fun visitCmpExpr(ctx: MMParser.CmpExprContext?): Node = nonNull(ctx) { c ->
        BinaryExpression(
            nonNull(c.op) { BinaryOperator.match(it.text, it.toPos(sourceFile)) },
            fullVisit(c.left),
            fullVisit(c.right),
            c.toPos(sourceFile)
        )
    }

    override fun visitBoolExpr(ctx: MMParser.BoolExprContext?): Node = nonNull(ctx) { c ->
        BinaryExpression(
            nonNull(c.op) { BinaryOperator.match(it.text, it.toPos(sourceFile)) },
            fullVisit(c.left),
            fullVisit(c.right),
            c.toPos(sourceFile)
        )
    }

    override fun visitTernaryExpr(ctx: MMParser.TernaryExprContext?): Node = nonNull(ctx) { c ->
        TernaryExpression(
            fullVisit(c.cond),
            fullVisit(c.bTrue),
            fullVisit(c.bFalse),
            c.toPos(sourceFile)
        )
    }

    override fun visitRangeExpr(ctx: MMParser.RangeExprContext?): Node = nonNull(ctx) { c ->
        RangeExpression(
            fullVisit(c.begin),
            fullVisit(c.end),
            false,
            c.toPos(sourceFile)
        )
    }

    override fun visitRangeInclusiveExpr(ctx: MMParser.RangeInclusiveExprContext?): Node = nonNull(ctx) { c ->
        RangeExpression(
            fullVisit(c.begin),
            fullVisit(c.end),
            true,
            c.toPos(sourceFile)
        )
    }
    //endregion

    //region Literals
    override fun visitStringLiteral(ctx: MMParser.StringLiteralContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ValueNode(
            StringValue(
                nonNull(c.content) { it.text },
                c.toPos(sourceFile)
            )
        )
    }

    override fun visitIntLiteral(ctx: MMParser.IntLiteralContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ValueNode(
            IntValue(
                c.INT().text.toIntOrNull() ?: throw LiteralError("int", c.INT().text, c.toPos(sourceFile)),
                c.toPos(sourceFile)
            )
        )
    }

    override fun visitFloatLiteral(ctx: MMParser.FloatLiteralContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ValueNode(
            FloatValue(
                c.FLOAT().text.toFloatOrNull() ?: throw LiteralError("float", c.FLOAT().text, c.toPos(sourceFile)),
                c.toPos(sourceFile)
            )
        )
    }

    override fun visitDiceLiteral(ctx: MMParser.DiceLiteralContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ValueNode(
            DiceValue(
                c.DICE().text.toDiceOrNull() ?: throw LiteralError("dice value", c.DICE().text, c.toPos(sourceFile)),
                c.toPos(sourceFile)
            )
        )
    }

    override fun visitCountDiceLiteral(ctx: MMParser.CountDiceLiteralContext?): Node = nonNull(ctx) { c ->
        val literal = c.INT().text + c.DICE().text
        HelperNodes.ValueNode(
            RollValue(
                literal.toRollOrNull() ?: throw LiteralError("roll value", literal, c.toPos(sourceFile)),
                c.toPos(sourceFile)
            )
        )
    }

    override fun visitTrueLiteral(ctx: MMParser.TrueLiteralContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ValueNode(
            BoolValue(
                true,
                c.toPos(sourceFile)
            )
        )
    }

    override fun visitFalseLiteral(ctx: MMParser.FalseLiteralContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ValueNode(
            BoolValue(
                false,
                c.toPos(sourceFile)
            )
        )
    }
    //endregion

    //region Misc
    override fun visitIdList(ctx: MMParser.IdListContext?): Node = nonNull(ctx) { c ->
        HelperNodes.StringListNode(
            c.ids.map { nonNull(it) { v -> v.text } },
            c.toPos(sourceFile)
        )
    }

    override fun visitExprList(ctx: MMParser.ExprListContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ListNode(
            c.expr().visitAll<Expression>(),
            c.toPos(sourceFile)
        )
    }
    //endregion

    companion object {
        fun loadSingle(source: String, file: String, provider: Provider): Ast {
            val error = AntlrListener("$source($file)")
            val lexer = MMLexer(CharStreams.fromStream(provider(source, file)))
//            lexer.removeErrorListeners()
            lexer.addErrorListener(error)

            val tokens = CommonTokenStream(lexer)
            val parser = MMParser(tokens)
//            parser.removeErrorListeners()
            parser.addErrorListener(error)

            val tree = parser.program()
            val loader = AstBuilder(file)

            return loader.visitProgram(tree) as Ast
        }

        // TODO: load recursive with dependencies
    }
}