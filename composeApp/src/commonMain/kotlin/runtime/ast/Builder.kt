package runtime.ast

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.Token
import runtime.ILoader
import runtime.Runtime
import runtime.Type.Companion.build
import runtime.ast.Currency.Companion.toCurrencyOrNull
import runtime.ast.DiceValue.Companion.toDiceOrNull
import runtime.ast.Variable.Companion.toVariable
import runtime.parser.MMBaseVisitor
import runtime.parser.MMLexer
import runtime.parser.MMParser
import java.io.InputStream

data class Streams(val source: InputStream, val description: InputStream)

fun ParserRuleContext.toPos(source: String, file: String): Pos = Pos(source, file, start.line, start.charPositionInLine)
fun Token.toPos(source: String, file: String): Pos = Pos(source, file, line, charPositionInLine)

inline fun <reified T, R> nonNull(v: T?, withT: (T) -> R): R = v?.let(withT) ?: throw NodeNullError(T::class.java)
inline fun <reified T: Node> Node.require(): T = this as? T ?: throw InvalidNodeTypeError(T::class.java, this::class.java)

inline fun <reified T> List<T?>.withNonNull(withT: (T) -> Unit): Unit = forEach { nonNull(it, withT) }
inline fun <reified T, R> List<T?>.mapNonNull(withT: (T) -> R): List<R> = map { nonNull(it, withT) }

class AntlrListener(val source: String, val file: String) : BaseErrorListener() {
    override fun syntaxError(recognizer: Recognizer<*, *>?, offendingSymbol: Any?, line: Int, charPositionInLine: Int, msg: String?, e: RecognitionException?) {
        throw SyntaxError(msg ?: "Unknown error", Pos(source, file, line, charPositionInLine))
    }
}

class Ast(val source: String, val deps: Map<String, List<String>>, val content: List<Declaration>, pos: Pos) : Node(pos)

class HelperNodes {
    class ListNode<T : Node>(val values: List<T>, pos: Pos) : Node(pos)
    class StringListNode(val values: List<String>, pos: Pos) : Node(pos)
    class ImportNode(val source: String, val deps: List<String>, pos: Pos) : Node(pos)
    class PreambleNode(val source: String, val deps: Map<String, List<String>>, pos: Pos) : Node(pos)
    class ValueNode(val value: Value) : Node(value.pos)
}

class AstBuilder(private val source: String, private val file: String) : MMBaseVisitor<Node>() {
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
        Ast(preamble.source, preamble.deps, body, c.toPos(source, file))
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
            c.toPos(source, file)
        )
    }

    override fun visitDependency(ctx: MMParser.DependencyContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ImportNode(
            nonNull(c.src) { it.text },
            visitRequire<HelperNodes.StringListNode>(c.idList()).values,
            c.toPos(source, file)
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
            c.toPos(source, file)
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
            c.toPos(source, file)
        )
    }

    override fun visitSimpleMultipleDecl(ctx: MMParser.SimpleMultipleDeclContext?): Node = nonNull(ctx) { c ->
        val kind = nonNull(c.kind) { it.text }

        HelperNodes.ListNode(nonNull(c.names) { l ->
            visitRequire<HelperNodes.StringListNode>(l).values.map {
                TypeDeclaration(
                    kind,
                    it,
                    listOf(),
                    listOf(),
                    listOf(),
                    l.toPos(source, file)
                )
            }
        }, c.toPos(source, file))
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
                    l.toPos(source, file)
                )
            }
        }, c.toPos(source, file))
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
            c.toPos(source, file)
        )
    }

    override fun visitFunDecl(ctx: MMParser.FunDeclContext?): Node = nonNull(ctx) { c ->
        FunDeclaration(
            nonNull(c.name) { it.text },
            c.args?.let { visitRequire<HelperNodes.StringListNode>(it).values } ?: listOf(),
            c.body.visitAll(),
            c.toPos(source, file)
        )
    }

    override fun visitGlobalDecl(ctx: MMParser.GlobalDeclContext?): Node = nonNull(ctx) { c ->
        GlobalDeclaration(
            nonNull(c.name) { it.text },
            fullVisit(c.value),
            c.toPos(source, file)
        )
    }

    override fun visitTagList(ctx: MMParser.TagListContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ListNode(
            c.tags.visitAll(),
            c.toPos(source, file)
        )
    }

    override fun visitSimpleTag(ctx: MMParser.SimpleTagContext?): Node = nonNull(ctx) { c ->
        Tag(
            nonNull(c.name) { it.text },
            listOf(),
            c.toPos(source, file)
        )
    }

    override fun visitParamTag(ctx: MMParser.ParamTagContext?): Node = nonNull(ctx) { c ->
        Tag(
            nonNull(c.name) { it.text },
            c.args?.let { visitRequire<HelperNodes.ListNode<Expression>>(it).values } ?: listOf(),
            c.toPos(source, file)
        )
    }
    //endregion


    //region Statements
    override fun visitExprStmt(ctx: MMParser.ExprStmtContext?): Node = nonNull(ctx) { c ->
        ExprStmt(
            fullVisit(c.expr()),
            c.toPos(source, file)
        )
    }

    override fun visitVarDecl(ctx: MMParser.VarDeclContext?): Node = nonNull(ctx) { c ->
        AssignmentStmt(
            nonNull(c.name) { it.text },
            fullVisit(c.value),
            DeclarationType.VAR,
            c.toPos(source, file)
        )
    }

    override fun visitConstDecl(ctx: MMParser.ConstDeclContext?): Node = nonNull(ctx) { c ->
        AssignmentStmt(
            nonNull(c.name) { it.text },
            fullVisit(c.value),
            DeclarationType.CONST,
            c.toPos(source, file)
        )
    }

    override fun visitAssignStmt(ctx: MMParser.AssignStmtContext?): Node = nonNull(ctx) { c ->
        AssignmentStmt(
            nonNull(c.name) { it.text },
            fullVisit(c.value),
            DeclarationType.ASSIGN,
            c.toPos(source, file)
        )
    }

    override fun visitIfStmt(ctx: MMParser.IfStmtContext?): Node = nonNull(ctx) { c ->
        IfStmt(
            fullVisit(c.cond),
            c.body.visitAll(),
            null,
            c.toPos(source, file)
        )
    }

    override fun visitIfElseStmt(ctx: MMParser.IfElseStmtContext?): Node = nonNull(ctx) { c ->
        IfStmt(
            fullVisit(c.cond),
            c.bTrue.visitAll(),
            c.bFalse.visitAll(),
            c.toPos(source, file)
        )
    }

    override fun visitWhileStmt(ctx: MMParser.WhileStmtContext?): Node = nonNull(ctx) { c ->
        WhileStmt(
            fullVisit(c.cond),
            c.body.visitAll(),
            c.toPos(source, file)
        )
    }

    override fun visitForStmt(ctx: MMParser.ForStmtContext?): Node = nonNull(ctx) { c ->
        ForStmt(
            nonNull(c.v) { it.text },
            fullVisit(c.set),
            c.body.visitAll(),
            c.toPos(source, file)
        )
    }

    override fun visitBreakStmt(ctx: MMParser.BreakStmtContext?): Node = nonNull(ctx) { c ->
        BreakStmt(c.toPos(source, file))
    }

    override fun visitReturnStmt(ctx: MMParser.ReturnStmtContext?): Node = nonNull(ctx) { c ->
        ReturnStmt(
            c.e?.let { visitRequire(it) },
            c.toPos(source, file)
        )
    }
    //endregion

    //region Expressions
    override fun visitLiteralExpr(ctx: MMParser.LiteralExprContext?): Node = nonNull(ctx) { c ->
        LiteralExpression(fullVisit<HelperNodes.ValueNode>(c.literal()).value, c.toPos(source, file))
    }

    override fun visitNameExpr(ctx: MMParser.NameExprContext?): Node = nonNull(ctx) { c ->
        VariableExpression(
            c.ID().text,
            c.toPos(source, file)
        )
    }

    override fun visitListExpr(ctx: MMParser.ListExprContext?): Node = nonNull(ctx) { c ->
        ListExpression(
            c.exprs?.let { visitRequire<HelperNodes.ListNode<Expression>>(it).values } ?: listOf(),
            c.toPos(source, file)
        )
    }

    override fun visitCallExpr(ctx: MMParser.CallExprContext?): Node = nonNull(ctx) { c ->
        CallExpression(
            c.ID().text,
            c.args?.let { visitRequire<HelperNodes.ListNode<Expression>>(it).values } ?: listOf(),
            c.toPos(source, file)
        )
    }

    override fun visitParenExpr(ctx: MMParser.ParenExprContext?): Node = nonNull(ctx) { c ->
        fullVisit(c.e)
    }

    override fun visitIndexExpr(ctx: MMParser.IndexExprContext?): Node = nonNull(ctx) { c ->
        IndexExpression(
            fullVisit(c.base),
            fullVisit(c.index),
            c.toPos(source, file)
        )
    }

    override fun visitMemberExpr(ctx: MMParser.MemberExprContext?): Node = nonNull(ctx) { c ->
        MemberExpression(
            fullVisit(c.base),
            nonNull(c.name) { it.text },
            c.toPos(source, file)
        )
    }

    override fun visitMemberCallExpr(ctx: MMParser.MemberCallExprContext?): Node = nonNull(ctx) { c ->
        MemberCallExpression(
            fullVisit(c.base),
            nonNull(c.name) { it.text },
            c.args?.let { visitRequire<HelperNodes.ListNode<Expression>>(it).values } ?: listOf(),
            c.toPos(source, file)
        )
    }

    override fun visitUnaryExpr(ctx: MMParser.UnaryExprContext?): Node = nonNull(ctx) { c ->
        UnaryExpression(
            nonNull(c.op) { UnaryOperator.match(it.text, it.toPos(source, file)) },
            fullVisit(c.expr()),
            c.toPos(source, file)
        )
    }

    override fun visitMulExpr(ctx: MMParser.MulExprContext?): Node = nonNull(ctx) { c ->
        BinaryExpression(
            nonNull(c.op) { BinaryOperator.match(it.text, it.toPos(source, file)) },
            fullVisit(c.left),
            fullVisit(c.right),
            c.toPos(source, file)
        )
    }

    override fun visitAddExpr(ctx: MMParser.AddExprContext?): Node = nonNull(ctx) { c ->
        BinaryExpression(
            nonNull(c.op) { BinaryOperator.match(it.text, it.toPos(source, file)) },
            fullVisit(c.left),
            fullVisit(c.right),
            c.toPos(source, file)
        )
    }

    override fun visitCmpExpr(ctx: MMParser.CmpExprContext?): Node = nonNull(ctx) { c ->
        BinaryExpression(
            nonNull(c.op) { BinaryOperator.match(it.text, it.toPos(source, file)) },
            fullVisit(c.left),
            fullVisit(c.right),
            c.toPos(source, file)
        )
    }

    override fun visitBoolExpr(ctx: MMParser.BoolExprContext?): Node = nonNull(ctx) { c ->
        BinaryExpression(
            nonNull(c.op) { BinaryOperator.match(it.text, it.toPos(source, file)) },
            fullVisit(c.left),
            fullVisit(c.right),
            c.toPos(source, file)
        )
    }

    override fun visitTernaryExpr(ctx: MMParser.TernaryExprContext?): Node = nonNull(ctx) { c ->
        TernaryExpression(
            fullVisit(c.cond),
            fullVisit(c.bTrue),
            fullVisit(c.bFalse),
            c.toPos(source, file)
        )
    }

    override fun visitRangeExpr(ctx: MMParser.RangeExprContext?): Node = nonNull(ctx) { c ->
        RangeExpression(
            fullVisit(c.begin),
            fullVisit(c.end),
            false,
            c.toPos(source, file)
        )
    }

    override fun visitRangeInclusiveExpr(ctx: MMParser.RangeInclusiveExprContext?): Node = nonNull(ctx) { c ->
        RangeExpression(
            fullVisit(c.begin),
            fullVisit(c.end),
            true,
            c.toPos(source, file)
        )
    }

    override fun visitCurrencyExpr(ctx: MMParser.CurrencyExprContext?): Node = nonNull(ctx) { c ->
        MappedIntExpression(fullVisit(c.count), {
            CurrencyValue(
                it.value,
                c.CURRENCY().text.toCurrencyOrNull() ?: throw LiteralError("currency", c.CURRENCY().text, c.toPos(source, file)),
                c.toPos(source, file)
            )
        }, c.toPos(source, file))
    }

    override fun visitDiceExpr(ctx: MMParser.DiceExprContext?): Node = nonNull(ctx) { c ->
        MappedIntExpression(fullVisit(c.count), {
            RollValue(
                it.value,
                c.DICE().text.toDiceOrNull() ?: throw LiteralError("dice", c.DICE().text, c.toPos(source, file)),
                c.toPos(source, file)
            )
        }, c.toPos(source, file))
    }
    //endregion

    //region Literals
    override fun visitStringLiteral(ctx: MMParser.StringLiteralContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ValueNode(
            StringValue(
                c.STRING().text.substring(1 until c.STRING().text.length - 1),
                c.toPos(source, file)
            )
        )
    }

    override fun visitIntLiteral(ctx: MMParser.IntLiteralContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ValueNode(
            IntValue(
                c.INT().text.toIntOrNull() ?: throw LiteralError("int", c.INT().text, c.toPos(source, file)),
                c.toPos(source, file)
            )
        )
    }

    override fun visitFloatLiteral(ctx: MMParser.FloatLiteralContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ValueNode(
            FloatValue(
                c.FLOAT().text.toFloatOrNull() ?: throw LiteralError("float", c.FLOAT().text, c.toPos(source, file)),
                c.toPos(source, file)
            )
        )
    }

    override fun visitDiceLiteral(ctx: MMParser.DiceLiteralContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ValueNode(
            DiceValue(
                c.DICE().text.toDiceOrNull() ?: throw LiteralError("dice value", c.DICE().text, c.toPos(source, file)),
                c.toPos(source, file)
            )
        )
    }

    override fun visitTrueLiteral(ctx: MMParser.TrueLiteralContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ValueNode(
            BoolValue(
                true,
                c.toPos(source, file)
            )
        )
    }

    override fun visitFalseLiteral(ctx: MMParser.FalseLiteralContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ValueNode(
            BoolValue(
                false,
                c.toPos(source, file)
            )
        )
    }

    override fun visitInfIntLiteral(ctx: MMParser.InfIntLiteralContext?): Node = nonNull(ctx) {
        HelperNodes.ValueNode(
            IntValue(
                Int.MAX_VALUE,
                it.toPos(source, file)
            )
        )
    }

    override fun visitInfFloatLiteral(ctx: MMParser.InfFloatLiteralContext?): Node = nonNull(ctx) {
        HelperNodes.ValueNode(
            FloatValue(
                Float.POSITIVE_INFINITY,
                it.toPos(source, file)
            )
        )
    }
    //endregion

    //region Misc
    override fun visitIdList(ctx: MMParser.IdListContext?): Node = nonNull(ctx) { c ->
        HelperNodes.StringListNode(
            c.ids.map { nonNull(it) { v -> v.text } },
            c.toPos(source, file)
        )
    }

    override fun visitExprList(ctx: MMParser.ExprListContext?): Node = nonNull(ctx) { c ->
        HelperNodes.ListNode(
            c.expr().visitAll<Expression>(),
            c.toPos(source, file)
        )
    }
    //endregion

    companion object {
        private suspend fun loadSingle(source: String, file: String, provider: ILoader): Map<String, Declaration> {
            val error = AntlrListener(source, file)
            val inputs = provider.loadSource(source, file)
            val lexer = MMLexer(CharStreams.fromStream(inputs.source))
            lexer.addErrorListener(error)

            val tokens = CommonTokenStream(lexer)
            val parser = MMParser(tokens)
            parser.addErrorListener(error)

            val tree = parser.program()
            val loader = AstBuilder(source, file)

            val ast = loader.visitProgram(tree) as Ast
            val declarations = mutableMapOf<String, Declaration>()
            ast.content.forEach {
                if(declarations.containsKey(it.name)) {
                    throw RedeclarationError(it.name, declarations[it.name]!!.pos, it.pos)
                }
                else {
                    declarations[it.name] = it
                }
            }

            val descs = DescriptionLoader(inputs.description.bufferedReader().use { it.readText() }, "$source($file)::descriptions").parse()
            descs.forEach { (n, d) ->
                declarations[n]?.let {
                    if(it is TypeDeclaration) it.description = d
                    else {
                        Runtime.getLogger().logWarning("Description provided for $n (declared at ${it.pos}), but it is not a type declaration (perhaps you made a typo?)")
                    }
                } ?: Runtime.getLogger().logWarning("Description provided for $n, but no such declaration exists (perhaps you made a typo or it is declared in another file?)")
            }

            return declarations
        }

        suspend fun loadWithDeps(source: String, file: String, provider: ILoader) {
            val output = Runtime.getCache()
            val deps = mutableListOf<Pair<String, String>>()
            val data: MutableMap<String, Declaration> = mutableMapOf()

            val already = mutableSetOf<Pair<String, String>>()
            deps.add(source to file)
            while(deps.isNotEmpty()) {
                val (src, f) = deps.removeFirst()
                if(already.contains(src to f)) continue
                already.add(src to f)

                loadSingle(src, f, provider).forEach { (name, decl) ->
                    if(data.containsKey(name)) {
                        throw RedeclarationError(name, data[name]!!.pos, decl.pos)
                    }
                    else {
                        data[name] = decl
                    }
                }
            }

            data.forEach { (_, v) ->
                when(v) {
                    is TypeDeclaration -> output.register(v.build())
                    is FunDeclaration -> output.register(v)
                    is GlobalDeclaration -> output.register(v.toVariable())
                    else -> throw ArbitraryAstError("Invalid top-level declaration of type ${v::class.java.simpleName}.")
                }
            }

            output.typeIterator().forEach { it.finalize() }
        }

        @OptIn(ExperimentalSerializationApi::class)
        suspend fun loadEntireCache(provider: ILoader) {
            val output = Runtime.getCache()
            val strm = provider.loadSourceList()
            val map = Json.decodeFromStream<Map<String, List<String>>>(strm)
            val parsed = mutableMapOf<String, Declaration>()
            map.forEach { (src, files) ->
                files.forEach { file ->
                    loadSingle(src, file, provider).forEach { (name, decl) ->
                        if(parsed.containsKey(name)) {
                            throw RedeclarationError(name, parsed[name]!!.pos, decl.pos)
                        }
                        else {
                            parsed[name] = decl
                        }
                    }
                }
            }

            parsed.forEach { (_, v) ->
                when(v) {
                    is TypeDeclaration -> output.register(v.build())
                    is FunDeclaration -> output.register(v)
                    is GlobalDeclaration -> output.register(v.toVariable())
                    else -> throw ArbitraryAstError("Invalid top-level declaration of type ${v::class.java.simpleName}.")
                }
            }

            output.typeIterator().forEach { it.finalize() }
        }
    }
}