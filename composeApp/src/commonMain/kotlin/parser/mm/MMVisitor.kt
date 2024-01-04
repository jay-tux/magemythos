// Generated from /home/data/kotlin/MageMythos/composeApp/src/parser/MM.g4 by ANTLR 4.13.1
package parser.mm

import org.antlr.v4.runtime.tree.ParseTreeVisitor

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by [MMParser].
 *
 * @param <T> The return type of the visit operation. Use [Void] for
 * operations with no return type.
</T> */
interface MMVisitor<T> : ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by [MMParser.strings].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitStrings(ctx: MMParser.StringsContext?): T

    /**
     * Visit a parse tree produced by [MMParser.singleString].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSingleString(ctx: MMParser.SingleStringContext?): T

    /**
     * Visit a parse tree produced by [MMParser.mageProg].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMageProg(ctx: MMParser.MageProgContext?): T

    /**
     * Visit a parse tree produced by the `sourceHeader`
     * labeled alternative in [MMParser.header].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSourceHeader(ctx: MMParser.SourceHeaderContext?): T

    /**
     * Visit a parse tree produced by the `sourceHeaderDeps`
     * labeled alternative in [MMParser.header].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSourceHeaderDeps(ctx: MMParser.SourceHeaderDepsContext?): T

    /**
     * Visit a parse tree produced by the `sourceHeaderStrings`
     * labeled alternative in [MMParser.header].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSourceHeaderStrings(ctx: MMParser.SourceHeaderStringsContext?): T

    /**
     * Visit a parse tree produced by the `sourceHeaderDepsStrings`
     * labeled alternative in [MMParser.header].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSourceHeaderDepsStrings(ctx: MMParser.SourceHeaderDepsStringsContext?): T

    /**
     * Visit a parse tree produced by [MMParser.setStrings].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSetStrings(ctx: MMParser.SetStringsContext?): T

    /**
     * Visit a parse tree produced by [MMParser.enables].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitEnables(ctx: MMParser.EnablesContext?): T

    /**
     * Visit a parse tree produced by the `dndClass`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndClass(ctx: MMParser.DndClassContext?): T

    /**
     * Visit a parse tree produced by the `dndRace`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndRace(ctx: MMParser.DndRaceContext?): T

    /**
     * Visit a parse tree produced by the `dndSubClass`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndSubClass(ctx: MMParser.DndSubClassContext?): T

    /**
     * Visit a parse tree produced by the `dndSubRace`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndSubRace(ctx: MMParser.DndSubRaceContext?): T

    /**
     * Visit a parse tree produced by the `dndItem`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndItem(ctx: MMParser.DndItemContext?): T

    /**
     * Visit a parse tree produced by the `dndSpell`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndSpell(ctx: MMParser.DndSpellContext?): T

    /**
     * Visit a parse tree produced by the `dndBg`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndBg(ctx: MMParser.DndBgContext?): T

    /**
     * Visit a parse tree produced by the `dndAbility`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndAbility(ctx: MMParser.DndAbilityContext?): T

    /**
     * Visit a parse tree produced by the `dndSkill`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndSkill(ctx: MMParser.DndSkillContext?): T

    /**
     * Visit a parse tree produced by the `dndTrait`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndTrait(ctx: MMParser.DndTraitContext?): T

    /**
     * Visit a parse tree produced by the `dndItemTrait`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndItemTrait(ctx: MMParser.DndItemTraitContext?): T

    /**
     * Visit a parse tree produced by the `dndDamage`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndDamage(ctx: MMParser.DndDamageContext?): T

    /**
     * Visit a parse tree produced by the `dndItemTag`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDndItemTag(ctx: MMParser.DndItemTagContext?): T

    /**
     * Visit a parse tree produced by the `function`
     * labeled alternative in [MMParser.topLevel].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFunction(ctx: MMParser.FunctionContext?): T

    /**
     * Visit a parse tree produced by [MMParser.classDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitClassDecl(ctx: MMParser.ClassDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.raceDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitRaceDecl(ctx: MMParser.RaceDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.subclassDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSubclassDecl(ctx: MMParser.SubclassDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.subRaceDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSubRaceDecl(ctx: MMParser.SubRaceDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.itemDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitItemDecl(ctx: MMParser.ItemDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.spellDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSpellDecl(ctx: MMParser.SpellDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.backgroundDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitBackgroundDecl(ctx: MMParser.BackgroundDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.abilityDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitAbilityDecl(ctx: MMParser.AbilityDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.skillDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSkillDecl(ctx: MMParser.SkillDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.traitDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTraitDecl(ctx: MMParser.TraitDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.itemTagDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitItemTagDecl(ctx: MMParser.ItemTagDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.itemTraitDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitItemTraitDecl(ctx: MMParser.ItemTraitDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.damageDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDamageDecl(ctx: MMParser.DamageDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.declBody].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDeclBody(ctx: MMParser.DeclBodyContext?): T

    /**
     * Visit a parse tree produced by [MMParser.funDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFunDecl(ctx: MMParser.FunDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.identifierSet].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIdentifierSet(ctx: MMParser.IdentifierSetContext?): T

    /**
     * Visit a parse tree produced by the `exprStmt`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitExprStmt(ctx: MMParser.ExprStmtContext?): T

    /**
     * Visit a parse tree produced by the `blockStmt`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitBlockStmt(ctx: MMParser.BlockStmtContext?): T

    /**
     * Visit a parse tree produced by the `ifStmt`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIfStmt(ctx: MMParser.IfStmtContext?): T

    /**
     * Visit a parse tree produced by the `whileStmt`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitWhileStmt(ctx: MMParser.WhileStmtContext?): T

    /**
     * Visit a parse tree produced by the `forStmt`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitForStmt(ctx: MMParser.ForStmtContext?): T

    /**
     * Visit a parse tree produced by the `assignStmt`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitAssignStmt(ctx: MMParser.AssignStmtContext?): T

    /**
     * Visit a parse tree produced by the `dotRef`
     * labeled alternative in [MMParser.ref].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDotRef(ctx: MMParser.DotRefContext?): T

    /**
     * Visit a parse tree produced by the `indexRef`
     * labeled alternative in [MMParser.ref].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIndexRef(ctx: MMParser.IndexRefContext?): T

    /**
     * Visit a parse tree produced by the `nameRef`
     * labeled alternative in [MMParser.ref].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitNameRef(ctx: MMParser.NameRefContext?): T

    /**
     * Visit a parse tree produced by [MMParser.args].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitArgs(ctx: MMParser.ArgsContext?): T

    /**
     * Visit a parse tree produced by the `indexExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIndexExpr(ctx: MMParser.IndexExprContext?): T

    /**
     * Visit a parse tree produced by the `dotExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDotExpr(ctx: MMParser.DotExprContext?): T

    /**
     * Visit a parse tree produced by the `addExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitAddExpr(ctx: MMParser.AddExprContext?): T

    /**
     * Visit a parse tree produced by the `literalExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitLiteralExpr(ctx: MMParser.LiteralExprContext?): T

    /**
     * Visit a parse tree produced by the `compExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitCompExpr(ctx: MMParser.CompExprContext?): T

    /**
     * Visit a parse tree produced by the `functionCallExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFunctionCallExpr(ctx: MMParser.FunctionCallExprContext?): T

    /**
     * Visit a parse tree produced by the `boolExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitBoolExpr(ctx: MMParser.BoolExprContext?): T

    /**
     * Visit a parse tree produced by the `multExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMultExpr(ctx: MMParser.MultExprContext?): T

    /**
     * Visit a parse tree produced by the `parenExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitParenExpr(ctx: MMParser.ParenExprContext?): T

    /**
     * Visit a parse tree produced by the `identifierExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIdentifierExpr(ctx: MMParser.IdentifierExprContext?): T

    /**
     * Visit a parse tree produced by the `numberLit`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitNumberLit(ctx: MMParser.NumberLitContext?): T

    /**
     * Visit a parse tree produced by the `rawDiceLit`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitRawDiceLit(ctx: MMParser.RawDiceLitContext?): T

    /**
     * Visit a parse tree produced by the `distanceLit`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDistanceLit(ctx: MMParser.DistanceLitContext?): T

    /**
     * Visit a parse tree produced by the `currencyLit`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitCurrencyLit(ctx: MMParser.CurrencyLitContext?): T

    /**
     * Visit a parse tree produced by the `weightLit`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitWeightLit(ctx: MMParser.WeightLitContext?): T

    /**
     * Visit a parse tree produced by the `stringLit`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitStringLit(ctx: MMParser.StringLitContext?): T

    /**
     * Visit a parse tree produced by the `stringDescr`
     * labeled alternative in [MMParser.description].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitStringDescr(ctx: MMParser.StringDescrContext?): T

    /**
     * Visit a parse tree produced by the `refDescr`
     * labeled alternative in [MMParser.description].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitRefDescr(ctx: MMParser.RefDescrContext?): T
}