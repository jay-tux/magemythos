// Generated from /home/data/kotlin/MageMythos/antlr/MM.g4 by ANTLR 4.13.1
package parser.mm;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MMParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MMVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MMParser#strings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrings(MMParser.StringsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#singleString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleString(MMParser.SingleStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#mageProg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMageProg(MMParser.MageProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sourceHeader}
	 * labeled alternative in {@link MMParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceHeader(MMParser.SourceHeaderContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sourceHeaderDeps}
	 * labeled alternative in {@link MMParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceHeaderDeps(MMParser.SourceHeaderDepsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sourceHeaderStrings}
	 * labeled alternative in {@link MMParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceHeaderStrings(MMParser.SourceHeaderStringsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sourceHeaderDepsStrings}
	 * labeled alternative in {@link MMParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceHeaderDepsStrings(MMParser.SourceHeaderDepsStringsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#setStrings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetStrings(MMParser.SetStringsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#enables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnables(MMParser.EnablesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndClass}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndClass(MMParser.DndClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndRace}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndRace(MMParser.DndRaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndSubClass}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndSubClass(MMParser.DndSubClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndSubRace}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndSubRace(MMParser.DndSubRaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndItem}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndItem(MMParser.DndItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndSpell}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndSpell(MMParser.DndSpellContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndBg}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndBg(MMParser.DndBgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndAbility}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndAbility(MMParser.DndAbilityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndSkill}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndSkill(MMParser.DndSkillContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndTrait}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndTrait(MMParser.DndTraitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndItemTrait}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndItemTrait(MMParser.DndItemTraitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndDamage}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndDamage(MMParser.DndDamageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dndItemTag}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDndItemTag(MMParser.DndItemTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code function}
	 * labeled alternative in {@link MMParser#topLevel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(MMParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(MMParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#raceDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRaceDecl(MMParser.RaceDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#subclassDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubclassDecl(MMParser.SubclassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#subRaceDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubRaceDecl(MMParser.SubRaceDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#itemDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemDecl(MMParser.ItemDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#spellDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpellDecl(MMParser.SpellDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#backgroundDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackgroundDecl(MMParser.BackgroundDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#abilityDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbilityDecl(MMParser.AbilityDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#skillDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkillDecl(MMParser.SkillDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#traitDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTraitDecl(MMParser.TraitDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#itemTagDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemTagDecl(MMParser.ItemTagDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#itemTraitDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemTraitDecl(MMParser.ItemTraitDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#damageDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDamageDecl(MMParser.DamageDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#declBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclBody(MMParser.DeclBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#funDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDecl(MMParser.FunDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#identifierSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierSet(MMParser.IdentifierSetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link MMParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(MMParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStmt}
	 * labeled alternative in {@link MMParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(MMParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link MMParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MMParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link MMParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MMParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStmt}
	 * labeled alternative in {@link MMParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(MMParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStmt}
	 * labeled alternative in {@link MMParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(MMParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotRef}
	 * labeled alternative in {@link MMParser#ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotRef(MMParser.DotRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexRef}
	 * labeled alternative in {@link MMParser#ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexRef(MMParser.IndexRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nameRef}
	 * labeled alternative in {@link MMParser#ref}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameRef(MMParser.NameRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MMParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(MMParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexExpr}
	 * labeled alternative in {@link MMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexExpr(MMParser.IndexExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotExpr}
	 * labeled alternative in {@link MMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotExpr(MMParser.DotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link MMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(MMParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link MMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(MMParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link MMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(MMParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link MMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(MMParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link MMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(MMParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link MMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(MMParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(MMParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link MMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpr(MMParser.IdentifierExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLit}
	 * labeled alternative in {@link MMParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLit(MMParser.NumberLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rawDiceLit}
	 * labeled alternative in {@link MMParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRawDiceLit(MMParser.RawDiceLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code distanceLit}
	 * labeled alternative in {@link MMParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistanceLit(MMParser.DistanceLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code currencyLit}
	 * labeled alternative in {@link MMParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurrencyLit(MMParser.CurrencyLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code weightLit}
	 * labeled alternative in {@link MMParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightLit(MMParser.WeightLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLit}
	 * labeled alternative in {@link MMParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLit(MMParser.StringLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringDescr}
	 * labeled alternative in {@link MMParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringDescr(MMParser.StringDescrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code refDescr}
	 * labeled alternative in {@link MMParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefDescr(MMParser.RefDescrContext ctx);
}