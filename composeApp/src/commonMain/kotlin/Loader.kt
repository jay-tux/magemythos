import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import parser.ast.AbilityDeclaration
import parser.ast.AstNode
import parser.ast.BackgroundDeclaration
import parser.ast.ClassDeclaration
import parser.ast.Declaration
import parser.ast.DeclarationSet
import parser.ast.Dice
import parser.ast.DiceLiteral
import parser.ast.DistanceLiteral
import parser.ast.EmptyNode
import parser.ast.FloatLiteral
import parser.ast.HeaderNode
import parser.ast.IntLiteral
import parser.ast.ItemDeclaration
import parser.ast.Literal
import parser.ast.ParseError
import parser.ast.Pos
import parser.ast.RaceDeclaration
import parser.ast.SkillDeclaration
import parser.ast.SpellDeclaration
import parser.ast.StringLiteral
import parser.ast.SubClassDeclaration
import parser.ast.SubRaceDeclaration
import parser.ast.TypedListLiteral
import parser.ast.WeightLiteral
import parser.ast.asIntIfIsInt
import parser.ast.merge
import parser.ast.nonNull
import parser.ast.notLast
import parser.ast.relativeTo
import parser.ast.toPathAndFile
import parser.ast.toPos
import parser.ast.upOneDir
import parser.mm.MMBaseVisitor
import parser.mm.MMLexer
import parser.mm.MMParser
import java.io.File
import java.io.FileNotFoundException
import java.nio.file.Path

inline fun <reified T> nonNull(t: T?): T = t ?: throw ParseError("Unexpected null node (expected a node of type ${T::class.simpleName}).")
inline fun <reified T, R> nonNull(t: T?, f: (T) -> R): R = t?.let { f(it) } ?: throw ParseError("Unexpected null node (expected a node of type ${T::class.simpleName}).")
inline fun <reified T: AstNode> require(t: AstNode): T = if(t is T) (t as T) else throw ParseError("Unexpected node type: ${t::class.simpleName}, expected ${T::class.simpleName}")

class ParseErrorListener : BaseErrorListener() {
    override fun syntaxError(recognizer: Recognizer<*, *>?, offendingSymbol: Any?, line: Int, charPositionInLine: Int, msg: String?, e: RecognitionException?) {
        throw ParseError("Syntax error at $line:$charPositionInLine: $msg (offending token: ${e?.offendingToken?.text})")
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
    val file = Path.of(target).toFile().canonicalPath
    var strings: Map<String, String> = mapOf()
        private set

    private var enableAutoName = false
    private var enableAutoDescr = false

    private inline fun <reified T: AstNode> visitThrough(ctx: ParserRuleContext?): T = nonNull(ctx) {
        require<T>(visit(it.getChild(0)))
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
            }
        }

        DeclarationSet(
            h.src, h.deps,
            classes, races, subClasses, subRaces, items, spells, backgrounds, abilities, skills,
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
    //endregion

    //region Expressions
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

    companion object {
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

            val res = loader.visitMageProg(tree) as DeclarationSet
            val str = loader.strings

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