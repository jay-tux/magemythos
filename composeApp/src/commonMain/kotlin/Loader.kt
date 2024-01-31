import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import parser.ast.AbilityDeclaration
import parser.ast.AssignStmt
import parser.ast.AstNode
import parser.ast.BackgroundDeclaration
import parser.ast.BinaryExpr
import parser.ast.BinaryOperator
import parser.ast.BreakStmt
import parser.ast.ClassDeclaration
import parser.ast.Currency
import parser.ast.CurrencyLiteral
import parser.ast.Declaration
import parser.ast.DeclarationSet
import parser.ast.Dice
import parser.ast.DiceLiteral
import parser.ast.DictExpression
import parser.ast.DistanceLiteral
import parser.ast.EmptyNode
import parser.ast.ExprStmt
import parser.ast.Expression
import parser.ast.VariableDeclaration
import parser.ast.FloatLiteral
import parser.ast.ForStmt
import parser.ast.FunCallExpr
import parser.ast.FunctionDeclaration
import parser.ast.HeaderNode
import parser.ast.IdentifierExpr
import parser.ast.IfStmt
import parser.ast.IndexExpr
import parser.ast.IndexTail
import parser.ast.IntLiteral
import parser.ast.ItemDeclaration
import parser.ast.LValue
import parser.ast.LValueTail
import parser.ast.ListExpression
import parser.ast.LiteralExpr
import parser.ast.ObjectMemberExpr
import parser.ast.ObjectMemberTail
import parser.ast.ParseError
import parser.ast.Pos
import parser.ast.RaceDeclaration
import parser.ast.ReturnStmt
import parser.ast.SkillDeclaration
import parser.ast.SpellDeclaration
import parser.ast.Statement
import parser.ast.StmtBlock
import parser.ast.StringLiteral
import parser.ast.SubClassDeclaration
import parser.ast.SubRaceDeclaration
import parser.ast.TypedListLiteral
import parser.ast.UnaryExpr
import parser.ast.UnaryOperator
import parser.ast.WeightLiteral
import parser.ast.WhileStmt
import parser.ast.asIntIfIsInt
import parser.ast.merge
import parser.ast.nonNull
import parser.ast.notLast
import parser.ast.relativeTo
import parser.ast.toPathAndFile
import parser.ast.toPos
import parser.mm.MMBaseVisitor
import parser.mm.MMLexer
import parser.mm.MMParser
import java.io.File
import java.lang.IllegalArgumentException
import java.nio.file.Path

inline fun <reified T> nonNull(t: T?): T = t ?: throw ParseError("Unexpected null node (expected a node of type ${T::class.simpleName}).")
inline fun <reified T, R> nonNull(t: T?, f: (T) -> R): R = t?.let { f(it) } ?: throw ParseError("Unexpected null node (expected a node of type ${T::class.simpleName}).")
inline fun <reified T: AstNode> require(t: AstNode): T = if(t is T) (t as T) else throw ParseError("Unexpected node type: ${t::class.simpleName}, expected ${T::class.simpleName}")

class ParseErrorListener : BaseErrorListener() {
    override fun syntaxError(recognizer: Recognizer<*, *>?, offendingSymbol: Any?, line: Int, charPositionInLine: Int, msg: String?, e: RecognitionException?) {
        throw ParseError("Syntax error at ${DataLoader.currentFile()}:$line:$charPositionInLine: $msg (offending token: ${e?.offendingToken?.text})")
    }
}

class StringsLoader : MMBaseVisitor<Map<String, String>>() {
    override fun visitStrings(ctx: MMParser.StringsContext?) = ctx?.singleString()?.map { s ->
        this.visitSingleString(s)
    }?.merge() ?: mapOf()

    override fun visitSingleString(ctx: MMParser.SingleStringContext?) = nonNull(ctx) { ctx ->
        ctx.key?.text?.let { k ->
           ctx.value?.text?.let { v -> mapOf(k to v)  }
        }
    } ?: mapOf()

    companion object {
        fun loadFrom(file: String): Map<String, String> {
            val error = ParseErrorListener()

            val input = File(file).inputStream()
            val lexer = MMLexer(CharStreams.fromStream(input))
            lexer.removeErrorListeners()
            lexer.addErrorListener(error)

            val tokens = CommonTokenStream(lexer)
            val parser = MMParser(tokens)
            parser.removeErrorListeners()
            parser.addErrorListener(error)

            val tree = parser.strings()
            val loader = StringsLoader()
            return loader.visitStrings(tree)
        }
    }
}

data class LoaderResult(val strings: Map<String, String>, val tree: DeclarationSet)

class DataLoader(target: String) : MMBaseVisitor<AstNode>() {
    //region Preamble
    val file = Path.of(target).toFile().canonicalPath
    var strings: Map<String, String> = mapOf()
        private set

    private var enableAutoName = false
    private var enableAutoDescr = false

    private inline fun <reified T: AstNode> visitThrough(ctx: ParserRuleContext?): T = nonNull(ctx) {
        require<T>(visit(it.getChild(0)))
    }

    private inline fun <reified T: AstNode> visitRequire(ctx: ParserRuleContext?): T = nonNull(ctx) {
        require<T>(visit(it))
    }

    private fun visitDesc(ctx: MMParser.DescriptionContext?, base: String): String {
        return ctx?.let {
            require<StringLiteral>(visit(it)).value
        } ?: run {
            if(enableAutoDescr) return strings[base + "_descr"] ?: throw ParseError("Unknown string reference: ${base}_descr")
            throw ParseError("No description given for $base. Perhaps you forgot to `enable \$AUTO_DESCR;`?")
        }
    }

    private fun visitName(ctx: MMParser.DescriptionContext?, base: String): String {
        return ctx?.let {
            require<StringLiteral>(visit(it)).value
        } ?: run {
            if(enableAutoName) return strings[base + "_name"] ?: throw ParseError("Unknown string reference: ${base}_name")
            throw ParseError("No description given for $base. Perhaps you forgot to `enable \$AUTO_NAME;`?")
        }
    }

    override fun visitMageProg(ctx: MMParser.MageProgContext?): AstNode = nonNull(ctx) { c ->
        val h = nonNull(c.header()) {
            println(it)
            require<HeaderNode>(visit(it))
        }

        strings = h.strFiles.map {
            val target = it.relativeTo(file)
            StringsLoader.loadFrom(target)
        }.merge()
        println(" -> Total of ${strings.size} strings loaded.")

        c.enables().forEach { visit(it) }

        val classes = mutableListOf<ClassDeclaration>()
        val races = mutableListOf<RaceDeclaration>()
        val subClasses = mutableListOf<SubClassDeclaration>()
        val subRaces = mutableListOf<SubRaceDeclaration>()
        val items = mutableListOf<ItemDeclaration>()
        val spells = mutableListOf<SpellDeclaration>()
        val backgrounds = mutableListOf<BackgroundDeclaration>()
        val abilities = mutableListOf<AbilityDeclaration>()
        val skills = mutableListOf<SkillDeclaration>()
        val freeFuncs = mutableListOf<FunctionDeclaration>()
        val globals = mutableListOf<VariableDeclaration>()

        nonNull(c.topLevel()).map {
            visit(it) as? Declaration
        }.filterNotNull().forEach {
            when(it) {
                is ClassDeclaration -> classes.add(it)
                is RaceDeclaration -> races.add(it)
                is SubClassDeclaration -> subClasses.add(it)
                is SubRaceDeclaration -> subRaces.add(it)
                is ItemDeclaration -> items.add(it)
                is SpellDeclaration -> spells.add(it)
                is BackgroundDeclaration -> backgrounds.add(it)
                is AbilityDeclaration -> abilities.add(it)
                is SkillDeclaration -> skills.add(it)
                is FunctionDeclaration -> freeFuncs.add(it)
                is VariableDeclaration -> globals.add(it)
            }
        }

        DeclarationSet(
            h.src, h.deps,
            classes, races, subClasses, subRaces, items, spells, backgrounds, abilities, skills,
            freeFuncs, globals,
            c.toPos(file)
        )
    }

    override fun visitSourceHeader(ctx: MMParser.SourceHeaderContext?): AstNode = nonNull(ctx) {
        HeaderNode(nonNull(it.src?.text), listOf(), listOf(), it.toPos(file))
    }

    override fun visitSourceHeaderDeps(ctx: MMParser.SourceHeaderDepsContext?): AstNode = nonNull(ctx) {
        HeaderNode(nonNull(it.src?.text), it.STRING_LIT().map { it.text }, listOf(), it.toPos(file))
    }

    override fun visitSourceHeaderStrings(ctx: MMParser.SourceHeaderStringsContext?): AstNode = nonNull(ctx) {
        HeaderNode(nonNull(it.src?.text), listOf(), require<TypedListLiteral<String>>(visit(it.setStrings())).value, it.toPos(file))
    }

    override fun visitSourceHeaderDepsStrings(ctx: MMParser.SourceHeaderDepsStringsContext?): AstNode = nonNull(ctx) {
        HeaderNode(nonNull(it.src?.text), it.STRING_LIT().map { it.text }, require<TypedListLiteral<String>>(visit(it.setStrings())).value, it.toPos(file))
    }

    override fun visitSetStrings(ctx: MMParser.SetStringsContext?): AstNode = nonNull(ctx) { ctx ->
        TypedListLiteral(ctx.STRING_LIT().map { it.text }, ctx.toPos(file))
    }

    override fun visitEnables(ctx: MMParser.EnablesContext?): AstNode {
        ctx?.let {
            it.AUTO_TARGETS().map { it.text }.forEach { toggle ->
                println("Attempting to enable '$toggle'")
                when(toggle) {
                    "\$AUTO_NAME" -> enableAutoName = true
                    "\$AUTO_DESCR" -> enableAutoDescr = true
                    else -> println("Warning: Invalid toggle to enable: '$toggle'"); // TODO: warning
                }
            }
        }
        return EmptyNode(ctx?.toPos(file) ?: Pos("???", -1, -1))
    }
    //endregion

    //region Declarations
    override fun visitDndClass(ctx: MMParser.DndClassContext?): AstNode = visitThrough<ClassDeclaration>(ctx)
    override fun visitDndRace(ctx: MMParser.DndRaceContext?): AstNode = visitThrough<RaceDeclaration>(ctx)
    override fun visitDndSubClass(ctx: MMParser.DndSubClassContext?): AstNode = visitThrough<SubClassDeclaration>(ctx)
    override fun visitDndSubRace(ctx: MMParser.DndSubRaceContext?): AstNode = visitThrough<SubRaceDeclaration>(ctx)
    override fun visitDndItem(ctx: MMParser.DndItemContext?): AstNode = visitThrough<ItemDeclaration>(ctx)
    override fun visitDndSpell(ctx: MMParser.DndSpellContext?): AstNode = visitThrough<SpellDeclaration>(ctx)
    override fun visitDndBg(ctx: MMParser.DndBgContext?): AstNode = visitThrough<BackgroundDeclaration>(ctx)
    override fun visitDndAbility(ctx: MMParser.DndAbilityContext?): AstNode = visitThrough<AbilityDeclaration>(ctx)
    override fun visitDndSkill(ctx: MMParser.DndSkillContext?): AstNode = visitThrough<SkillDeclaration>(ctx)
    override fun visitFunction(ctx: MMParser.FunctionContext?): AstNode = visitThrough<FunctionDeclaration>(ctx)

    override fun visitClassDecl(ctx: MMParser.ClassDeclContext?): AstNode = nonNull(ctx) { ctx ->
        ctx.name?.text?.let {
            ClassDeclaration(
                it, visitName(ctx.dispName, it), visitDesc(ctx.d, it), ctx.toPos(file)
            )
        } ?: throw ParseError("No class name given.")
    }

    override fun visitRaceDecl(ctx: MMParser.RaceDeclContext?): AstNode = nonNull(ctx) { ctx ->
        ctx.name?.text?.let {
            RaceDeclaration(
                it, visitName(ctx.dispName, it), visitDesc(ctx.d, it), ctx.toPos(file)
            )
        } ?: throw ParseError("No race name given.")
    }

    override fun visitSubclassDecl(ctx: MMParser.SubclassDeclContext?): AstNode = nonNull(ctx) { ctx ->
        ctx.name?.text?.let {
            SubClassDeclaration(
                it, visitName(ctx.dispName, it),
                ctx.cls?.text ?: throw ParseError("No class given for sub-class $it."),
                visitDesc(ctx.d, it), ctx.toPos(file)
            )
        } ?: throw ParseError("No sub-class name given.")
    }

    override fun visitSubRaceDecl(ctx: MMParser.SubRaceDeclContext?): AstNode = nonNull(ctx) { ctx ->
        ctx.name?.text?.let {
            SkillDeclaration(
                it, visitName(ctx.dispName, it),
                ctx.race?.text ?: throw ParseError("No race given for sub-race $it."),
                visitDesc(ctx.d, it), ctx.toPos(file)
            )
        } ?: throw ParseError("No sub-race name given.")
    }

    override fun visitItemDecl(ctx: MMParser.ItemDeclContext?): AstNode = nonNull(ctx) { ctx ->
        ctx.name?.text?.let {
            ItemDeclaration(
                it, visitName(ctx.dispName, it), visitDesc(ctx.d, it), ctx.toPos(file)
            )
        } ?: throw ParseError("No item name given.")
    }

    override fun visitSpellDecl(ctx: MMParser.SpellDeclContext?): AstNode = nonNull(ctx) { ctx ->
        ctx.name?.text?.let {
            SpellDeclaration(
                it, visitName(ctx.dispName, it), visitDesc(ctx.d, it), ctx.toPos(file)
            )
        } ?: throw ParseError("No spell name given.")
    }

    override fun visitBackgroundDecl(ctx: MMParser.BackgroundDeclContext?): AstNode = nonNull(ctx) { ctx ->
        ctx.name?.text?.let {
            BackgroundDeclaration(
                it, visitName(ctx.dispName, it), visitDesc(ctx.d, it), ctx.toPos(file)
            )
        } ?: throw ParseError("No background name given.")
    }

    override fun visitAbilityDecl(ctx: MMParser.AbilityDeclContext?): AstNode = nonNull(ctx) { ctx ->
        ctx.name?.text?.let {
            AbilityDeclaration(
                it, visitName(ctx.dispName, it), visitDesc(ctx.d, it), ctx.toPos(file)
            )
        } ?: throw ParseError("No ability name given.")
    }

    override fun visitSkillDecl(ctx: MMParser.SkillDeclContext?): AstNode = nonNull(ctx) { ctx ->
        ctx.name?.text?.let {
            SkillDeclaration(
                it, visitName(ctx.dispName, it),
                ctx.ability?.text ?: throw ParseError("No ability given for skill $it."),
                visitDesc(ctx.d, it), ctx.toPos(file)
            )
        } ?: throw ParseError("No skill name given.")
    }

    override fun visitFunDecl(ctx: MMParser.FunDeclContext?): AstNode = nonNull(ctx) { ctx ->
        FunctionDeclaration(
            ctx.name?.text ?: throw ParseError("No function name given."),
            visitRequire<TypedListLiteral<String>>(ctx.identifierSet()).value,
            ctx.stmt().map { visitRequire<Statement>(it) },
            ctx.toPos(file)
        )
    }

    override fun visitMemberField(ctx: MMParser.MemberFieldContext?): AstNode = nonNull(ctx) {
        visitRequire<VariableDeclaration>(it.fieldDecl())
    }

    override fun visitMemberFunc(ctx: MMParser.MemberFuncContext?): AstNode = nonNull(ctx) {
        visitRequire<FunctionDeclaration>(it.funDecl())
    }
    //endregion

    //region Statements
    override fun visitExprStmt(ctx: MMParser.ExprStmtContext?): AstNode = nonNull(ctx) {
        ExprStmt(visitRequire(it.expr()), it.toPos(file))
    }

    override fun visitBlockStmt(ctx: MMParser.BlockStmtContext?): AstNode = nonNull(ctx) {
        StmtBlock(it.stmt().map { s -> visitRequire<Statement>(s) }, it.toPos(file))
    }

    override fun visitIfStmt(ctx: MMParser.IfStmtContext?): AstNode = nonNull(ctx) {
        IfStmt(
            visitRequire(it.expr()),
            visitRequire(it.bTrue ?: throw ParseError("Unexpected null node (branch-true for if-statement) at ${it.toPos(file)}")),
            it.bFalse?.let { o -> visitRequire(o) },
            it.toPos(file)
        )
    }

    override fun visitWhileStmt(ctx: MMParser.WhileStmtContext?): AstNode = nonNull(ctx) {
        WhileStmt(
            visitRequire(it.expr()),
            visitRequire(it.stmt()),
            it.toPos(file)
        )
    }

    override fun visitForStmt(ctx: MMParser.ForStmtContext?): AstNode = nonNull(ctx) {
        ForStmt(
            it.IDENTIFIER().text,
            visitRequire(it.expr()),
            visitRequire(it.stmt()),
            it.toPos(file)
        )
    }

    override fun visitBreakStmt(ctx: MMParser.BreakStmtContext?): AstNode = nonNull(ctx) {
        BreakStmt(it.toPos(file))
    }

    override fun visitReturnStmt(ctx: MMParser.ReturnStmtContext?): AstNode = nonNull(ctx) {
        ReturnStmt(it.v?.let { e -> visitRequire(e) }, it.toPos(file))
    }

    override fun visitAssignStmt(ctx: MMParser.AssignStmtContext?): AstNode = nonNull(ctx) {
        AssignStmt(
            visitRequire<LValue>(it.v),
            visitRequire(it.expr()),
            it.toPos(file)
        )
    }
    //endregion

    //region References
    override fun visitRef(ctx: MMParser.RefContext?): AstNode = nonNull(ctx) {
        val n = it.name?.text ?: throw ParseError("Unexpected null start of reference at ${it.toPos(file)}.")
        val tail = it.refTail().map { e -> visitRequire<LValueTail>(e) }
        LValue(n, tail, it.toPos(file))
    }

    override fun visitFieldRef(ctx: MMParser.FieldRefContext?): AstNode = nonNull(ctx) {
        ObjectMemberTail(it.IDENTIFIER().text, it.toPos(file))
    }

    override fun visitIndexRef(ctx: MMParser.IndexRefContext?): AstNode = nonNull(ctx) {
        IndexTail(visitRequire(it.idx), it.toPos(file))
    }
    //endregion

    //region Expressions
    override fun visitArgs(ctx: MMParser.ArgsContext?): AstNode = nonNull(ctx) {
        TypedListLiteral(it.expr().map { e -> visitRequire<Expression>(e) }, it.toPos(file))
    }

    override fun visitLiteralExpr(ctx: MMParser.LiteralExprContext?): AstNode = nonNull(ctx) {
        LiteralExpr(visitRequire(it.literal()), it.toPos(file))
    }

    override fun visitIdentifierExpr(ctx: MMParser.IdentifierExprContext?): AstNode = nonNull(ctx) {
        IdentifierExpr(it.IDENTIFIER().text, it.toPos(file))
    }

    override fun visitDotExpr(ctx: MMParser.DotExprContext?): AstNode = nonNull(ctx) {
        ObjectMemberExpr(visitRequire(it.base), it.IDENTIFIER().text, it.toPos(file))
    }

    override fun visitIndexExpr(ctx: MMParser.IndexExprContext?): AstNode = nonNull(ctx) {
        IndexExpr(visitRequire(it.base), visitRequire(it.idx), it.toPos(file))
    }

    override fun visitFunctionCallExpr(ctx: MMParser.FunctionCallExprContext?): AstNode = nonNull(ctx) {
        FunCallExpr(it.IDENTIFIER().text, visitRequire<TypedListLiteral<Expression>>(it.args()).value, it.toPos(file))
    }

    override fun visitParenExpr(ctx: MMParser.ParenExprContext?): AstNode = nonNull(ctx) {
        visitRequire<Expression>(it.expr())
    }

    override fun visitUnaryExpr(ctx: MMParser.UnaryExprContext?): AstNode = nonNull(ctx) {
        val body = visitRequire<Expression>(it.expr())
        when(val opStr = it.op?.text) {
            "!" -> UnaryExpr(UnaryOperator.NOT, body, it.toPos(file))
            "-" -> UnaryExpr(UnaryOperator.NEGATE, body, it.toPos(file))
            "+" -> body
            null -> throw ParseError("Unexpected null unary operator at ${it.toPos(file)}")
            else -> throw ParseError("Invalid unary operator: $opStr at ${it.toPos(file)}")
        }
    }

    override fun visitMultExpr(ctx: MMParser.MultExprContext?): AstNode = nonNull(ctx) {
        val l = visitRequire<Expression>(it.l)
        val r = visitRequire<Expression>(it.r)

        when(val opStr = it.op?.text) {
            "*" -> BinaryExpr(BinaryOperator.MUL, l, r, it.toPos(file))
            "/" -> BinaryExpr(BinaryOperator.DIV, l, r, it.toPos(file))
            "%" -> BinaryExpr(BinaryOperator.MOD, l, r, it.toPos(file))
            null -> throw ParseError("Unexpected null binary operator at ${it.toPos(file)}")
            else -> throw ParseError("Invalid binary operator: $opStr at ${it.toPos(file)}")
        }
    }

    override fun visitAddExpr(ctx: MMParser.AddExprContext?): AstNode = nonNull(ctx) {
        val l = visitRequire<Expression>(it.l)
        val r = visitRequire<Expression>(it.r)

        when(val opStr = it.op?.text) {
            "+" -> BinaryExpr(BinaryOperator.ADD, l, r, it.toPos(file))
            "-" -> BinaryExpr(BinaryOperator.SUB, l, r, it.toPos(file))
            null -> throw ParseError("Unexpected null binary operator at ${it.toPos(file)}")
            else -> throw ParseError("Invalid binary operator: $opStr at ${it.toPos(file)}")
        }
    }

    override fun visitBoolExpr(ctx: MMParser.BoolExprContext?): AstNode = nonNull(ctx) {
        val l = visitRequire<Expression>(it.l)
        val r = visitRequire<Expression>(it.r)

        when(val opStr = it.op?.text) {
            "&&" -> BinaryExpr(BinaryOperator.AND, l, r, it.toPos(file))
            "||" -> BinaryExpr(BinaryOperator.OR, l, r, it.toPos(file))
            null -> throw ParseError("Unexpected null binary operator at ${it.toPos(file)}")
            else -> throw ParseError("Invalid binary operator: $opStr at ${it.toPos(file)}")
        }
    }

    override fun visitCompExpr(ctx: MMParser.CompExprContext?): AstNode = nonNull(ctx) {
        val l = visitRequire<Expression>(it.l)
        val r = visitRequire<Expression>(it.r)

        when(val opStr = it.op?.text) {
            "<" -> BinaryExpr(BinaryOperator.LT, l, r, it.toPos(file))
            ">" -> BinaryExpr(BinaryOperator.GT, l, r, it.toPos(file))
            "<=" -> BinaryExpr(BinaryOperator.LTE, l, r, it.toPos(file))
            ">=" -> BinaryExpr(BinaryOperator.GTE, l, r, it.toPos(file))
            "==" -> BinaryExpr(BinaryOperator.EQ, l, r, it.toPos(file))
            "!=" -> BinaryExpr(BinaryOperator.NEQ, l, r, it.toPos(file))
            null -> throw ParseError("Unexpected null binary operator at ${it.toPos(file)}")
            else -> throw ParseError("Invalid binary operator: $opStr at ${it.toPos(file)}")
        }
    }

    override fun visitListLit(ctx: MMParser.ListLitContext?): AstNode = nonNull(ctx) {
        ListExpression(it.expr().map { e -> visitRequire<Expression>(e) }, it.toPos(file))
    }

    override fun visitDictLit(ctx: MMParser.DictLitContext?): AstNode = nonNull(ctx) {
        DictExpression(it.keys.zip(it.values).map { (k, v) ->
            val key = visitRequire<Expression>(k ?: throw ParseError("Null key in dictionary expression at ${it.toPos(file)}"))
            val value = visitRequire<Expression>(v ?: throw ParseError("Null value in dictionary expression at ${it.toPos(file)}"))
            key to value
        }, it.toPos(file))
    }
    //endregion

    //region Literals
    override fun visitNumberLit(ctx: MMParser.NumberLitContext?): AstNode = nonNull(ctx) {
        val temp = it.NUMBER().text.toFloatOrNull()
            ?: throw ParseError("Invalid number literal: ${it.NUMBER().text} at ${it.toPos(file)}")

        temp.asIntIfIsInt()?.let { i -> IntLiteral(i, it.toPos(file)) } ?: FloatLiteral(temp, it.toPos(file))
    }

    override fun visitRawDiceLit(ctx: MMParser.RawDiceLitContext?): AstNode = nonNull(ctx) {
        val temp = it.DICE_LIT().text.split('d', 'D').map { s ->
            s.toIntOrNull() ?: throw ParseError("Invalid dice literal: ${it.DICE_LIT().text} at ${it.toPos(file)}")
        }

        DiceLiteral(Dice(temp[0], temp[1]), it.toPos(file))
    }

    override fun visitDistanceLit(ctx: MMParser.DistanceLitContext?): AstNode = nonNull(ctx) {
        val temp = it.DIST_LIT().text.substring(0, it.DIST_LIT().text.length - 2).toFloatOrNull()
            ?: throw ParseError("Invalid distance literal: ${it.DIST_LIT().text} at ${it.toPos(file)}")

        DistanceLiteral(temp, it.toPos(file))
    }

    override fun visitWeightLit(ctx: MMParser.WeightLitContext?): AstNode = nonNull(ctx) {
        val temp = it.WEIGHT_LIT().text.substring(0, it.WEIGHT_LIT().text.length - 2).toFloatOrNull()
            ?: throw ParseError("Invalid weight literal: ${it.WEIGHT_LIT().text} at ${it.toPos(file)}")

        WeightLiteral(temp, it.toPos(file))
    }

    override fun visitCurrencyLit(ctx: MMParser.CurrencyLitContext?): AstNode = nonNull(ctx) {
        val temp = it.CURRENCY_LIT().text
        val amount = temp.substring(0 until temp.length - 2).toIntOrNull()
            ?: throw ParseError("Invalid currency literal: ${it.CURRENCY_LIT().text} at ${it.toPos(file)}")
        val unit = try {
            Currency.valueOf(temp.substring(temp.length - 2).uppercase())
        }
        catch(e: IllegalArgumentException) {
            throw ParseError("Invalid currency literal: ${it.CURRENCY_LIT().text} at ${it.toPos(file)}")
        }

        CurrencyLiteral(amount, unit, it.toPos(file))
    }

    override fun visitStringLit(ctx: MMParser.StringLitContext?): AstNode = nonNull(ctx) {
        visit(it.description())
    }
    //endregion

    //region Descriptions
    override fun visitStringDescr(ctx: MMParser.StringDescrContext?): AstNode = nonNull(ctx) {
        StringLiteral(it.STRING_LIT().text, it.toPos(file))
    }

    override fun visitRefDescr(ctx: MMParser.RefDescrContext?): AstNode = nonNull(ctx) {
        val n = it.name?.text ?: throw ParseError("Unexpected null reference string.")
        strings[n]?.let { s ->
            StringLiteral(s, it.toPos(file))
        } ?: throw ParseError("Unknown reference string: $n")
    }
    //endregion

    //region Misc
    override fun visitIdentifierSet(ctx: MMParser.IdentifierSetContext?): AstNode = nonNull(ctx) {
        TypedListLiteral(it.IDENTIFIER().map { i -> i.text }, it.toPos(file))
    }
    //endregion

    companion object {
        private var currentInstance: DataLoader? = null

        fun currentFile() = currentInstance?.file ?: throw ParseError("Not currently parsing a file.")

        fun loadFrom(file: String): LoaderResult {
            val error = ParseErrorListener()

            val input = File(file).inputStream()
            val lexer = MMLexer(CharStreams.fromStream(input))
            lexer.removeErrorListeners()
            lexer.addErrorListener(error)

            val tokens = CommonTokenStream(lexer)
            val parser = MMParser(tokens)
            parser.removeErrorListeners()
            parser.addErrorListener(error)

            val tree = parser.mageProg()
            val loader = DataLoader(file)
            currentInstance = loader

            val res = loader.visitMageProg(tree) as DeclarationSet
            val str = loader.strings

            currentInstance = null
            return LoaderResult(str, res)
        }

        fun attemptResolve(file: String, depFrom: String): String? {
            var curBase = depFrom.toPathAndFile().first
            println("     -> Attempting to load $curBase/$file...")
            var f = File("$curBase/$file")
            while(!f.exists() && curBase.isNotEmpty()) {
                curBase = curBase.split('/').notLast().joinToString("/")
                println("     -> Not found, attempting with $curBase/$file...")
                f = File("$curBase/$file")
            }
            return if(!f.exists()) null
            else f.canonicalPath
        }
    }
}