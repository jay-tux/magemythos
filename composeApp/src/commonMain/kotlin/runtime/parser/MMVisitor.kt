// Generated from /home/data/kotlin/MageMythos/composeApp/src/parser/MM.g4 by ANTLR 4.13.1
package runtime.parser

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
     * Visit a parse tree produced by [MMParser.program].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitProgram(ctx: MMParser.ProgramContext?): T

    /**
     * Visit a parse tree produced by [MMParser.preamble].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitPreamble(ctx: MMParser.PreambleContext?): T

    /**
     * Visit a parse tree produced by [MMParser.dependency].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDependency(ctx: MMParser.DependencyContext?): T

    /**
     * Visit a parse tree produced by [MMParser.idList].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIdList(ctx: MMParser.IdListContext?): T

    /**
     * Visit a parse tree produced by the `simpleDecl`
     * labeled alternative in [MMParser.declaration].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSimpleDecl(ctx: MMParser.SimpleDeclContext?): T

    /**
     * Visit a parse tree produced by the `fullDecl`
     * labeled alternative in [MMParser.declaration].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFullDecl(ctx: MMParser.FullDeclContext?): T

    /**
     * Visit a parse tree produced by the `multipleDecl`
     * labeled alternative in [MMParser.declaration].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMultipleDecl(ctx: MMParser.MultipleDeclContext?): T

    /**
     * Visit a parse tree produced by the `function`
     * labeled alternative in [MMParser.declaration].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFunction(ctx: MMParser.FunctionContext?): T

    /**
     * Visit a parse tree produced by the `global`
     * labeled alternative in [MMParser.declaration].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitGlobal(ctx: MMParser.GlobalContext?): T

    /**
     * Visit a parse tree produced by the `memberFunc`
     * labeled alternative in [MMParser.bodyDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMemberFunc(ctx: MMParser.MemberFuncContext?): T

    /**
     * Visit a parse tree produced by the `memberConst`
     * labeled alternative in [MMParser.bodyDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMemberConst(ctx: MMParser.MemberConstContext?): T

    /**
     * Visit a parse tree produced by the `memberField`
     * labeled alternative in [MMParser.bodyDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMemberField(ctx: MMParser.MemberFieldContext?): T

    /**
     * Visit a parse tree produced by [MMParser.funDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFunDecl(ctx: MMParser.FunDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.globalDecl].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitGlobalDecl(ctx: MMParser.GlobalDeclContext?): T

    /**
     * Visit a parse tree produced by [MMParser.tagList].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTagList(ctx: MMParser.TagListContext?): T

    /**
     * Visit a parse tree produced by the `simpleTag`
     * labeled alternative in [MMParser.tag].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitSimpleTag(ctx: MMParser.SimpleTagContext?): T

    /**
     * Visit a parse tree produced by the `paramTag`
     * labeled alternative in [MMParser.tag].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitParamTag(ctx: MMParser.ParamTagContext?): T

    /**
     * Visit a parse tree produced by [MMParser.exprList].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitExprList(ctx: MMParser.ExprListContext?): T

    /**
     * Visit a parse tree produced by the `exprStmt`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitExprStmt(ctx: MMParser.ExprStmtContext?): T

    /**
     * Visit a parse tree produced by the `varDecl`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitVarDecl(ctx: MMParser.VarDeclContext?): T

    /**
     * Visit a parse tree produced by the `constDecl`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitConstDecl(ctx: MMParser.ConstDeclContext?): T

    /**
     * Visit a parse tree produced by the `assignStmt`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitAssignStmt(ctx: MMParser.AssignStmtContext?): T

    /**
     * Visit a parse tree produced by the `ifStmt`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIfStmt(ctx: MMParser.IfStmtContext?): T

    /**
     * Visit a parse tree produced by the `ifElseStmt`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIfElseStmt(ctx: MMParser.IfElseStmtContext?): T

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
     * Visit a parse tree produced by the `breakStmt`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitBreakStmt(ctx: MMParser.BreakStmtContext?): T

    /**
     * Visit a parse tree produced by the `returnStmt`
     * labeled alternative in [MMParser.stmt].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitReturnStmt(ctx: MMParser.ReturnStmtContext?): T

    /**
     * Visit a parse tree produced by the `memberCallExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMemberCallExpr(ctx: MMParser.MemberCallExprContext?): T

    /**
     * Visit a parse tree produced by the `memberExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMemberExpr(ctx: MMParser.MemberExprContext?): T

    /**
     * Visit a parse tree produced by the `nameExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitNameExpr(ctx: MMParser.NameExprContext?): T

    /**
     * Visit a parse tree produced by the `parenExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitParenExpr(ctx: MMParser.ParenExprContext?): T

    /**
     * Visit a parse tree produced by the `cmpExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitCmpExpr(ctx: MMParser.CmpExprContext?): T

    /**
     * Visit a parse tree produced by the `indexExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIndexExpr(ctx: MMParser.IndexExprContext?): T

    /**
     * Visit a parse tree produced by the `unaryExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitUnaryExpr(ctx: MMParser.UnaryExprContext?): T

    /**
     * Visit a parse tree produced by the `ternaryExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTernaryExpr(ctx: MMParser.TernaryExprContext?): T

    /**
     * Visit a parse tree produced by the `rangeInclusiveExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitRangeInclusiveExpr(ctx: MMParser.RangeInclusiveExprContext?): T

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
     * Visit a parse tree produced by the `mulExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitMulExpr(ctx: MMParser.MulExprContext?): T

    /**
     * Visit a parse tree produced by the `callExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitCallExpr(ctx: MMParser.CallExprContext?): T

    /**
     * Visit a parse tree produced by the `boolExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitBoolExpr(ctx: MMParser.BoolExprContext?): T

    /**
     * Visit a parse tree produced by the `listExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitListExpr(ctx: MMParser.ListExprContext?): T

    /**
     * Visit a parse tree produced by the `rangeExpr`
     * labeled alternative in [MMParser.expr].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitRangeExpr(ctx: MMParser.RangeExprContext?): T

    /**
     * Visit a parse tree produced by the `stringLiteral`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitStringLiteral(ctx: MMParser.StringLiteralContext?): T

    /**
     * Visit a parse tree produced by the `intLiteral`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitIntLiteral(ctx: MMParser.IntLiteralContext?): T

    /**
     * Visit a parse tree produced by the `floatLiteral`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFloatLiteral(ctx: MMParser.FloatLiteralContext?): T

    /**
     * Visit a parse tree produced by the `diceLiteral`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitDiceLiteral(ctx: MMParser.DiceLiteralContext?): T

    /**
     * Visit a parse tree produced by the `countDiceLiteral`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitCountDiceLiteral(ctx: MMParser.CountDiceLiteralContext?): T

    /**
     * Visit a parse tree produced by the `trueLiteral`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitTrueLiteral(ctx: MMParser.TrueLiteralContext?): T

    /**
     * Visit a parse tree produced by the `falseLiteral`
     * labeled alternative in [MMParser.literal].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitFalseLiteral(ctx: MMParser.FalseLiteralContext?): T
}