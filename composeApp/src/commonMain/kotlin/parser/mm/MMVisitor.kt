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