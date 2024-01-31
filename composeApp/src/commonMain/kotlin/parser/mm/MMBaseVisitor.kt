// Generated from /home/data/kotlin/MageMythos/composeApp/src/parser/MM.g4 by ANTLR 4.13.1
package parser.mm

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor
import parser.mm.MMParser.FieldDeclContext
import parser.mm.MMParser.GlobalDeclContext
import parser.mm.MMParser.GlobalVarContext
import parser.mm.MMParser.MemberFieldContext
import parser.mm.MMParser.MemberFuncContext

/**
 * This class provides an empty implementation of [MMVisitor],
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use [Void] for
 * operations with no return type.
</T> */
open class MMBaseVisitor<T> : AbstractParseTreeVisitor<T>(), MMVisitor<T> {
    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitStrings(ctx: MMParser.StringsContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitSingleString(ctx: MMParser.SingleStringContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitMageProg(ctx: MMParser.MageProgContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitSourceHeader(ctx: MMParser.SourceHeaderContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitSourceHeaderDeps(ctx: MMParser.SourceHeaderDepsContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitSourceHeaderStrings(ctx: MMParser.SourceHeaderStringsContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitSourceHeaderDepsStrings(ctx: MMParser.SourceHeaderDepsStringsContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitSetStrings(ctx: MMParser.SetStringsContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitEnables(ctx: MMParser.EnablesContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndClass(ctx: MMParser.DndClassContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndRace(ctx: MMParser.DndRaceContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndSubClass(ctx: MMParser.DndSubClassContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndSubRace(ctx: MMParser.DndSubRaceContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndItem(ctx: MMParser.DndItemContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndSpell(ctx: MMParser.DndSpellContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndBg(ctx: MMParser.DndBgContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndAbility(ctx: MMParser.DndAbilityContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndSkill(ctx: MMParser.DndSkillContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndTrait(ctx: MMParser.DndTraitContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndItemTrait(ctx: MMParser.DndItemTraitContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndDamage(ctx: MMParser.DndDamageContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDndItemTag(ctx: MMParser.DndItemTagContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitFunction(ctx: MMParser.FunctionContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitGlobalVar(ctx: GlobalVarContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitClassDecl(ctx: MMParser.ClassDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitRaceDecl(ctx: MMParser.RaceDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitSubclassDecl(ctx: MMParser.SubclassDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitSubRaceDecl(ctx: MMParser.SubRaceDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitItemDecl(ctx: MMParser.ItemDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitSpellDecl(ctx: MMParser.SpellDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitBackgroundDecl(ctx: MMParser.BackgroundDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitAbilityDecl(ctx: MMParser.AbilityDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitSkillDecl(ctx: MMParser.SkillDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitTraitDecl(ctx: MMParser.TraitDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitItemTagDecl(ctx: MMParser.ItemTagDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitItemTraitDecl(ctx: MMParser.ItemTraitDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDamageDecl(ctx: MMParser.DamageDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitMemberFunc(ctx: MemberFuncContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitMemberField(ctx: MemberFieldContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitFunDecl(ctx: MMParser.FunDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitFieldDecl(ctx: FieldDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitGlobalDecl(ctx: GlobalDeclContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitIdentifierSet(ctx: MMParser.IdentifierSetContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitExprStmt(ctx: MMParser.ExprStmtContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitBlockStmt(ctx: MMParser.BlockStmtContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitIfStmt(ctx: MMParser.IfStmtContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitWhileStmt(ctx: MMParser.WhileStmtContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitForStmt(ctx: MMParser.ForStmtContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitBreakStmt(ctx: MMParser.BreakStmtContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitReturnStmt(ctx: MMParser.ReturnStmtContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitAssignStmt(ctx: MMParser.AssignStmtContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitRef(ctx: MMParser.RefContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitFieldRef(ctx: MMParser.FieldRefContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitIndexRef(ctx: MMParser.IndexRefContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitArgs(ctx: MMParser.ArgsContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitListLit(ctx: MMParser.ListLitContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDotExpr(ctx: MMParser.DotExprContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDictLit(ctx: MMParser.DictLitContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitMultExpr(ctx: MMParser.MultExprContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitParenExpr(ctx: MMParser.ParenExprContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitIndexExpr(ctx: MMParser.IndexExprContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitUnaryExpr(ctx: MMParser.UnaryExprContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitAddExpr(ctx: MMParser.AddExprContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitLiteralExpr(ctx: MMParser.LiteralExprContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitCompExpr(ctx: MMParser.CompExprContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitFunctionCallExpr(ctx: MMParser.FunctionCallExprContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitBoolExpr(ctx: MMParser.BoolExprContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitIdentifierExpr(ctx: MMParser.IdentifierExprContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitNumberLit(ctx: MMParser.NumberLitContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitRawDiceLit(ctx: MMParser.RawDiceLitContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitDistanceLit(ctx: MMParser.DistanceLitContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitCurrencyLit(ctx: MMParser.CurrencyLitContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitWeightLit(ctx: MMParser.WeightLitContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitStringLit(ctx: MMParser.StringLitContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitStringDescr(ctx: MMParser.StringDescrContext?): T {
        return visitChildren(ctx)
    }

    /**
     * {@inheritDoc}
     *
     *
     * The default implementation returns the result of calling
     * [.visitChildren] on `ctx`.
     */
    override fun visitRefDescr(ctx: MMParser.RefDescrContext?): T {
        return visitChildren(ctx)
    }
}