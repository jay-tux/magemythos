// Generated from /home/data/kotlin/MageMythos/composeApp/src/parser/MM.g4 by ANTLR 4.13.1
package runtime.parser

import org.antlr.v4.runtime.FailedPredicateException
import org.antlr.v4.runtime.NoViableAltException
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.RuleContext
import org.antlr.v4.runtime.RuntimeMetaData
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.TokenStream
import org.antlr.v4.runtime.Vocabulary
import org.antlr.v4.runtime.VocabularyImpl
import org.antlr.v4.runtime.atn.ATN
import org.antlr.v4.runtime.atn.ATNDeserializer
import org.antlr.v4.runtime.atn.ParserATNSimulator
import org.antlr.v4.runtime.atn.PredictionContextCache
import org.antlr.v4.runtime.dfa.DFA
import org.antlr.v4.runtime.tree.ParseTreeVisitor
import org.antlr.v4.runtime.tree.TerminalNode

@Suppress("unused")
class MMParser(input: TokenStream?) : Parser(input) {
    @Deprecated("")
    override fun getTokenNames(): Array<String> {
        return Companion.tokenNames
    }

    override fun getVocabulary(): Vocabulary {
        return VOCABULARY
    }

    override fun getGrammarFileName(): String {
        return "MM.g4"
    }

    override fun getRuleNames(): Array<String> {
        return Companion.ruleNames
    }

    override fun getSerializedATN(): String {
        return _serializedATN
    }

    override fun getATN(): ATN {
        return _ATN
    }

    class ProgramContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun preamble(): PreambleContext {
            return getRuleContext(PreambleContext::class.java, 0)
        }

        fun EOF(): TerminalNode {
            return getToken(EOF, 0)
        }

        fun declaration(): List<DeclarationContext> {
            return getRuleContexts(DeclarationContext::class.java)
        }

        fun declaration(i: Int): DeclarationContext {
            return getRuleContext(DeclarationContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_program
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitProgram(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun program(): ProgramContext {
        val _localctx = ProgramContext(_ctx, state)
        enterRule(_localctx, 0, RULE_program)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 28
                preamble()
                state = 32
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la and 0x3f.inv() == 0 && 1L shl _la and 567485438885888L != 0L) {
                    run {
                        run {
                            state = 29
                            declaration()
                        }
                    }
                    state = 34
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 35
                match(EOF)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class PreambleContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var dependency: DependencyContext? = null
        var deps: MutableList<DependencyContext?> = ArrayList()
        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun dependency(): List<DependencyContext> {
            return getRuleContexts(DependencyContext::class.java)
        }

        fun dependency(i: Int): DependencyContext {
            return getRuleContext(DependencyContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_preamble
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitPreamble(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun preamble(): PreambleContext {
        val _localctx = PreambleContext(_ctx, state)
        enterRule(_localctx, 2, RULE_preamble)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 37
                match(T__0)
                state = 38
                match(ID)
                state = 39
                match(SEMI)
                state = 43
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == T__1) {
                    run {
                        run {
                            state = 40
                            _localctx.dependency = dependency()
                            _localctx.deps.add(_localctx.dependency)
                        }
                    }
                    state = 45
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class DependencyContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var src: Token? = null
        var items: IdListContext? = null
        fun PO(): TerminalNode {
            return getToken(PO, 0)
        }

        fun PC(): TerminalNode {
            return getToken(PC, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun idList(): IdListContext {
            return getRuleContext(IdListContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_dependency
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDependency(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun dependency(): DependencyContext {
        val _localctx = DependencyContext(_ctx, state)
        enterRule(_localctx, 4, RULE_dependency)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 46
                match(T__1)
                state = 47
                _localctx.src = match(ID)
                state = 48
                match(PO)
                state = 49
                _localctx.items = idList()
                state = 50
                match(PC)
                state = 51
                match(SEMI)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class IdListContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var ID: Token? = null
        var ids: MutableList<Token?> = ArrayList()
        fun ID(): List<TerminalNode> {
            return getTokens(Companion.ID)
        }

        fun ID(i: Int): TerminalNode {
            return getToken(Companion.ID, i)
        }

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_idList
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitIdList(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun idList(): IdListContext {
        val _localctx = IdListContext(_ctx, state)
        enterRule(_localctx, 6, RULE_idList)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 53
                _localctx.ID = match(ID)
                _localctx.ids.add(_localctx.ID)
                state = 58
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == COMMA) {
                    run {
                        run {
                            state = 54
                            match(COMMA)
                            state = 55
                            _localctx.ID = match(ID)
                            _localctx.ids.add(_localctx.ID)
                        }
                    }
                    state = 60
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    open class DeclarationContext : ParserRuleContext {
        constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState)

        override fun getRuleIndex(): Int {
            return RULE_declaration
        }

        constructor()

        fun copyFrom(ctx: DeclarationContext?) {
            super.copyFrom(ctx)
        }
    }

    class FullDeclContext(ctx: DeclarationContext?) : DeclarationContext() {
        var kind: Token? = null
        var name: Token? = null
        var tags: TagListContext? = null
        var bodyDecl: BodyDeclContext? = null
        var body: MutableList<BodyDeclContext?> = ArrayList()
        fun BO(): TerminalNode {
            return getToken(BO, 0)
        }

        fun BC(): TerminalNode {
            return getToken(BC, 0)
        }

        fun ID(): List<TerminalNode> {
            return getTokens(ID)
        }

        fun ID(i: Int): TerminalNode {
            return getToken(ID, i)
        }

        fun tagList(): TagListContext {
            return getRuleContext(TagListContext::class.java, 0)
        }

        fun bodyDecl(): List<BodyDeclContext> {
            return getRuleContexts(BodyDeclContext::class.java)
        }

        fun bodyDecl(i: Int): BodyDeclContext {
            return getRuleContext(BodyDeclContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitFullDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class FunctionContext(ctx: DeclarationContext?) : DeclarationContext() {
        fun funDecl(): FunDeclContext {
            return getRuleContext(FunDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitFunction(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class SimpleDeclContext(ctx: DeclarationContext?) : DeclarationContext() {
        var kind: Token? = null
        var name: Token? = null
        var tags: TagListContext? = null
        fun ID(): List<TerminalNode> {
            return getTokens(ID)
        }

        fun ID(i: Int): TerminalNode {
            return getToken(ID, i)
        }

        fun tagList(): TagListContext {
            return getRuleContext(TagListContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSimpleDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class SimpleMultipleDeclContext(ctx: DeclarationContext?) : DeclarationContext() {
        var kind: Token? = null
        var names: IdListContext? = null
        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun idList(): IdListContext {
            return getRuleContext(IdListContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSimpleMultipleDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class GlobalContext(ctx: DeclarationContext?) : DeclarationContext() {
        fun globalDecl(): GlobalDeclContext {
            return getRuleContext(GlobalDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitGlobal(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class MultipleDeclContext(ctx: DeclarationContext?) : DeclarationContext() {
        var kind: Token? = null
        var names: IdListContext? = null
        var tags: TagListContext? = null
        fun PO(): TerminalNode {
            return getToken(PO, 0)
        }

        fun PC(): TerminalNode {
            return getToken(PC, 0)
        }

        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun idList(): IdListContext {
            return getRuleContext(IdListContext::class.java, 0)
        }

        fun tagList(): TagListContext {
            return getRuleContext(TagListContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMultipleDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun declaration(): DeclarationContext {
        var _localctx = DeclarationContext(_ctx, state)
        enterRule(_localctx, 8, RULE_declaration)
        var _la: Int
        try {
            state = 91
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 7, _ctx)) {
                1 -> {
                    _localctx = SimpleDeclContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 61
                        (_localctx as SimpleDeclContext).kind = match(ID)
                        state = 62
                        (_localctx as SimpleDeclContext).name = match(ID)
                        state = 64
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la == TAGNAME) {
                            run {
                                state = 63
                                (_localctx as SimpleDeclContext).tags = tagList()
                            }
                        }
                    }
                }

                2 -> {
                    _localctx = FullDeclContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 66
                        (_localctx as FullDeclContext).kind = match(ID)
                        state = 67
                        (_localctx as FullDeclContext).name = match(ID)
                        state = 69
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la == TAGNAME) {
                            run {
                                state = 68
                                (_localctx as FullDeclContext).tags = tagList()
                            }
                        }
                        state = 71
                        match(BO)
                        state = 75
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 4810363371520L != 0L) {
                            run {
                                run {
                                    state = 72
                                    (_localctx as FullDeclContext).bodyDecl = bodyDecl()
                                    (_localctx as FullDeclContext).body.add((_localctx as FullDeclContext).bodyDecl)
                                }
                            }
                            state = 77
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 78
                        match(BC)
                    }
                }

                3 -> {
                    _localctx = SimpleMultipleDeclContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 79
                        (_localctx as SimpleMultipleDeclContext).kind = match(ID)
                        state = 80
                        (_localctx as SimpleMultipleDeclContext).names = idList()
                    }
                }

                4 -> {
                    _localctx = MultipleDeclContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 81
                        (_localctx as MultipleDeclContext).kind = match(ID)
                        state = 82
                        match(PO)
                        state = 83
                        (_localctx as MultipleDeclContext).names = idList()
                        state = 84
                        match(PC)
                        state = 85
                        match(T__2)
                        state = 87
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la == TAGNAME) {
                            run {
                                state = 86
                                (_localctx as MultipleDeclContext).tags = tagList()
                            }
                        }
                    }
                }

                5 -> {
                    _localctx = FunctionContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 89
                        funDecl()
                    }
                }

                6 -> {
                    _localctx = GlobalContext(_localctx)
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 90
                        globalDecl()
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    open class BodyDeclContext : ParserRuleContext {
        constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState)

        override fun getRuleIndex(): Int {
            return RULE_bodyDecl
        }

        constructor()

        fun copyFrom(ctx: BodyDeclContext?) {
            super.copyFrom(ctx)
        }
    }

    class MemberFuncContext(ctx: BodyDeclContext?) : BodyDeclContext() {
        fun funDecl(): FunDeclContext {
            return getRuleContext(FunDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMemberFunc(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class MemberFieldContext(ctx: BodyDeclContext?) : BodyDeclContext() {
        var name: Token? = null
        var value: ExprContext? = null
        fun VAR(): TerminalNode {
            return getToken(VAR, 0)
        }

        fun EQ(): TerminalNode {
            return getToken(EQ, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMemberField(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class MemberConstContext(ctx: BodyDeclContext?) : BodyDeclContext() {
        fun globalDecl(): GlobalDeclContext {
            return getRuleContext(GlobalDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMemberConst(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun bodyDecl(): BodyDeclContext {
        var _localctx = BodyDeclContext(_ctx, state)
        enterRule(_localctx, 10, RULE_bodyDecl)
        try {
            state = 101
            _errHandler.sync(this)
            when (_input.LA(1)) {
                FUN -> {
                    _localctx = MemberFuncContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 93
                        funDecl()
                    }
                }

                CONST -> {
                    _localctx = MemberConstContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 94
                        globalDecl()
                    }
                }

                VAR -> {
                    _localctx = MemberFieldContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 95
                        match(VAR)
                        state = 96
                        _localctx.name = match(ID)
                        state = 97
                        match(EQ)
                        state = 98
                        _localctx.value = expr(0)
                        state = 99
                        match(SEMI)
                    }
                }

                else -> throw NoViableAltException(this)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FunDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var args: IdListContext? = null
        var stmt: StmtContext? = null
        var body: MutableList<StmtContext?> = ArrayList()
        fun FUN(): TerminalNode {
            return getToken(FUN, 0)
        }

        fun PO(): TerminalNode {
            return getToken(PO, 0)
        }

        fun PC(): TerminalNode {
            return getToken(PC, 0)
        }

        fun BO(): TerminalNode {
            return getToken(BO, 0)
        }

        fun BC(): TerminalNode {
            return getToken(BC, 0)
        }

        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun idList(): IdListContext {
            return getRuleContext(IdListContext::class.java, 0)
        }

        fun stmt(): MutableList<StmtContext?> {
            return getRuleContexts(StmtContext::class.java)
        }

        fun stmt(i: Int): StmtContext {
            return getRuleContext(StmtContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_funDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitFunDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun funDecl(): FunDeclContext {
        val _localctx = FunDeclContext(_ctx, state)
        enterRule(_localctx, 12, RULE_funDecl)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 103
                match(FUN)
                state = 104
                _localctx.name = match(ID)
                state = 105
                match(PO)
                state = 107
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == ID) {
                    run {
                        state = 106
                        _localctx.args = idList()
                    }
                }
                state = 109
                match(PC)
                state = 110
                match(BO)
                state = 114
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la and 0x3f.inv() == 0 && 1L shl _la and 8584265384067184L != 0L) {
                    run {
                        run {
                            state = 111
                            _localctx.stmt = stmt()
                            _localctx.body.add(_localctx.stmt)
                        }
                    }
                    state = 116
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 117
                match(BC)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class GlobalDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var value: ExprContext? = null
        fun CONST(): TerminalNode {
            return getToken(CONST, 0)
        }

        fun EQ(): TerminalNode {
            return getToken(EQ, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_globalDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitGlobalDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun globalDecl(): GlobalDeclContext {
        val _localctx = GlobalDeclContext(_ctx, state)
        enterRule(_localctx, 14, RULE_globalDecl)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 119
                match(CONST)
                state = 120
                _localctx.name = match(ID)
                state = 121
                match(EQ)
                state = 122
                _localctx.value = expr(0)
                state = 123
                match(SEMI)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TagListContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var tag: TagContext? = null
        var tags: MutableList<TagContext?> = ArrayList()
        fun tag(): MutableList<TagContext?> {
            return getRuleContexts(TagContext::class.java)
        }

        fun tag(i: Int): TagContext {
            return getRuleContext(TagContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_tagList
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitTagList(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun tagList(): TagListContext {
        val _localctx = TagListContext(_ctx, state)
        enterRule(_localctx, 16, RULE_tagList)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 126
                _errHandler.sync(this)
                _la = _input.LA(1)
                do {
                    run {
                        run {
                            state = 125
                            _localctx.tag = tag()
                            _localctx.tags.add(_localctx.tag)
                        }
                    }
                    state = 128
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                } while (_la == TAGNAME)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    open class TagContext : ParserRuleContext {
        constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState)

        override fun getRuleIndex(): Int {
            return RULE_tag
        }

        constructor()

        fun copyFrom(ctx: TagContext?) {
            super.copyFrom(ctx)
        }
    }

    class SimpleTagContext(ctx: TagContext?) : TagContext() {
        var name: Token? = null
        fun TAGNAME(): TerminalNode {
            return getToken(TAGNAME, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSimpleTag(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class ParamTagContext(ctx: TagContext?) : TagContext() {
        var name: Token? = null
        var args: ExprListContext? = null
        fun PO(): TerminalNode {
            return getToken(PO, 0)
        }

        fun PC(): TerminalNode {
            return getToken(PC, 0)
        }

        fun TAGNAME(): TerminalNode {
            return getToken(TAGNAME, 0)
        }

        fun exprList(): ExprListContext {
            return getRuleContext(ExprListContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitParamTag(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun tag(): TagContext {
        var _localctx = TagContext(_ctx, state)
        enterRule(_localctx, 18, RULE_tag)
        var _la: Int
        try {
            state = 137
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 13, _ctx)) {
                1 -> {
                    _localctx = SimpleTagContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 130
                        (_localctx as SimpleTagContext).name = match(TAGNAME)
                    }
                }

                2 -> {
                    _localctx = ParamTagContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 131
                        _localctx.name = match(TAGNAME)
                        state = 132
                        match(PO)
                        state = 134
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la and 0x3f.inv() == 0 && 1L shl _la and 8524513799045232L != 0L) {
                            run {
                                state = 133
                                _localctx.args = exprList()
                            }
                        }
                        state = 136
                        match(PC)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ExprListContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var expr: ExprContext? = null
        var exprs: MutableList<ExprContext?> = ArrayList()
        fun expr(): MutableList<ExprContext?> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_exprList
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitExprList(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun exprList(): ExprListContext {
        val _localctx = ExprListContext(_ctx, state)
        enterRule(_localctx, 20, RULE_exprList)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 139
                _localctx.expr = expr(0)
                _localctx.exprs.add(_localctx.expr)
                state = 144
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == COMMA) {
                    run {
                        run {
                            state = 140
                            match(COMMA)
                            state = 141
                            _localctx.expr = expr(0)
                            _localctx.exprs.add(_localctx.expr)
                        }
                    }
                    state = 146
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    open class StmtContext : ParserRuleContext {
        constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState)

        override fun getRuleIndex(): Int {
            return RULE_stmt
        }

        constructor()

        fun copyFrom(ctx: StmtContext?) {
            super.copyFrom(ctx)
        }
    }

    class ExprStmtContext(ctx: StmtContext?) : StmtContext() {
        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitExprStmt(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class ForStmtContext(ctx: StmtContext?) : StmtContext() {
        var v: Token? = null
        var set: ExprContext? = null
        var stmt: StmtContext? = null
        var body: MutableList<StmtContext?> = ArrayList()
        fun FOR(): TerminalNode {
            return getToken(FOR, 0)
        }

        fun PO(): TerminalNode {
            return getToken(PO, 0)
        }

        fun COLON(): TerminalNode {
            return getToken(COLON, 0)
        }

        fun PC(): TerminalNode {
            return getToken(PC, 0)
        }

        fun BO(): TerminalNode {
            return getToken(BO, 0)
        }

        fun BC(): TerminalNode {
            return getToken(BC, 0)
        }

        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun stmt(): MutableList<StmtContext?> {
            return getRuleContexts(StmtContext::class.java)
        }

        fun stmt(i: Int): StmtContext {
            return getRuleContext(StmtContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitForStmt(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class WhileStmtContext(ctx: StmtContext?) : StmtContext() {
        var cond: ExprContext? = null
        var stmt: StmtContext? = null
        var body: MutableList<StmtContext?> = ArrayList()
        fun WHILE(): TerminalNode {
            return getToken(WHILE, 0)
        }

        fun PO(): TerminalNode {
            return getToken(PO, 0)
        }

        fun PC(): TerminalNode {
            return getToken(PC, 0)
        }

        fun BO(): TerminalNode {
            return getToken(BO, 0)
        }

        fun BC(): TerminalNode {
            return getToken(BC, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun stmt(): MutableList<StmtContext?> {
            return getRuleContexts(StmtContext::class.java)
        }

        fun stmt(i: Int): StmtContext {
            return getRuleContext(StmtContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitWhileStmt(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class IfStmtContext(ctx: StmtContext?) : StmtContext() {
        var cond: ExprContext? = null
        var stmt: StmtContext? = null
        var body: MutableList<StmtContext?> = ArrayList()
        fun IF(): TerminalNode {
            return getToken(IF, 0)
        }

        fun PO(): TerminalNode {
            return getToken(PO, 0)
        }

        fun PC(): TerminalNode {
            return getToken(PC, 0)
        }

        fun BO(): TerminalNode {
            return getToken(BO, 0)
        }

        fun BC(): TerminalNode {
            return getToken(BC, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun stmt(): MutableList<StmtContext?> {
            return getRuleContexts(StmtContext::class.java)
        }

        fun stmt(i: Int): StmtContext {
            return getRuleContext(StmtContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitIfStmt(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class IfElseStmtContext(ctx: StmtContext?) : StmtContext() {
        var cond: ExprContext? = null
        var stmt: StmtContext? = null
        var bTrue: MutableList<StmtContext?> = ArrayList()
        var bFalse: MutableList<StmtContext?> = ArrayList()
        fun IF(): TerminalNode {
            return getToken(IF, 0)
        }

        fun PO(): TerminalNode {
            return getToken(PO, 0)
        }

        fun PC(): TerminalNode {
            return getToken(PC, 0)
        }

        fun BO(): List<TerminalNode> {
            return getTokens(BO)
        }

        fun BO(i: Int): TerminalNode {
            return getToken(BO, i)
        }

        fun BC(): List<TerminalNode> {
            return getTokens(BC)
        }

        fun BC(i: Int): TerminalNode {
            return getToken(BC, i)
        }

        fun ELSE(): TerminalNode {
            return getToken(ELSE, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun stmt(): MutableList<StmtContext?> {
            return getRuleContexts(StmtContext::class.java)
        }

        fun stmt(i: Int): StmtContext {
            return getRuleContext(StmtContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitIfElseStmt(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class AssignStmtContext(ctx: StmtContext?) : StmtContext() {
        var name: Token? = null
        var value: ExprContext? = null
        fun EQ(): TerminalNode {
            return getToken(EQ, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitAssignStmt(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class BreakStmtContext(ctx: StmtContext?) : StmtContext() {
        fun BREAK(): TerminalNode {
            return getToken(BREAK, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitBreakStmt(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class ConstDeclContext(ctx: StmtContext?) : StmtContext() {
        var name: Token? = null
        var value: ExprContext? = null
        fun CONST(): TerminalNode {
            return getToken(CONST, 0)
        }

        fun EQ(): TerminalNode {
            return getToken(EQ, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitConstDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class ReturnStmtContext(ctx: StmtContext?) : StmtContext() {
        var e: ExprContext? = null
        fun RETURN(): TerminalNode {
            return getToken(RETURN, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitReturnStmt(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class VarDeclContext(ctx: StmtContext?) : StmtContext() {
        var name: Token? = null
        var value: ExprContext? = null
        fun VAR(): TerminalNode {
            return getToken(VAR, 0)
        }

        fun EQ(): TerminalNode {
            return getToken(EQ, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitVarDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun stmt(): StmtContext {
        var _localctx = StmtContext(_ctx, state)
        enterRule(_localctx, 22, RULE_stmt)
        var _la: Int
        try {
            state = 237
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 21, _ctx)) {
                1 -> {
                    _localctx = ExprStmtContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 147
                        expr(0)
                        state = 148
                        match(SEMI)
                    }
                }

                2 -> {
                    _localctx = VarDeclContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 150
                        match(VAR)
                        state = 151
                        (_localctx as VarDeclContext).name = match(ID)
                        state = 152
                        match(EQ)
                        state = 153
                        (_localctx as VarDeclContext).value = expr(0)
                        state = 154
                        match(SEMI)
                    }
                }

                3 -> {
                    _localctx = ConstDeclContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 156
                        match(CONST)
                        state = 157
                        (_localctx as ConstDeclContext).name = match(ID)
                        state = 158
                        match(EQ)
                        state = 159
                        (_localctx as ConstDeclContext).value = expr(0)
                        state = 160
                        match(SEMI)
                    }
                }

                4 -> {
                    _localctx = AssignStmtContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 162
                        (_localctx as AssignStmtContext).name = match(ID)
                        state = 163
                        match(EQ)
                        state = 164
                        (_localctx as AssignStmtContext).value = expr(0)
                        state = 165
                        match(SEMI)
                    }
                }

                5 -> {
                    _localctx = IfStmtContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 167
                        match(IF)
                        state = 168
                        match(PO)
                        state = 169
                        (_localctx as IfStmtContext).cond = expr(0)
                        state = 170
                        match(PC)
                        state = 171
                        match(BO)
                        state = 175
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 8584265384067184L != 0L) {
                            run {
                                run {
                                    state = 172
                                    (_localctx as IfStmtContext).stmt = stmt()
                                    (_localctx as IfStmtContext).body.add((_localctx as IfStmtContext).stmt)
                                }
                            }
                            state = 177
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 178
                        match(BC)
                    }
                }

                6 -> {
                    _localctx = IfElseStmtContext(_localctx)
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 180
                        match(IF)
                        state = 181
                        match(PO)
                        state = 182
                        (_localctx as IfElseStmtContext).cond = expr(0)
                        state = 183
                        match(PC)
                        state = 184
                        match(BO)
                        state = 188
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 8584265384067184L != 0L) {
                            run {
                                run {
                                    state = 185
                                    (_localctx as IfElseStmtContext).stmt = stmt()
                                    (_localctx as IfElseStmtContext).bTrue.add((_localctx as IfElseStmtContext).stmt)
                                }
                            }
                            state = 190
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 191
                        match(BC)
                        state = 192
                        match(ELSE)
                        state = 193
                        match(BO)
                        state = 197
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 8584265384067184L != 0L) {
                            run {
                                run {
                                    state = 194
                                    (_localctx as IfElseStmtContext).stmt = stmt()
                                    (_localctx as IfElseStmtContext).bFalse.add((_localctx as IfElseStmtContext).stmt)
                                }
                            }
                            state = 199
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 200
                        match(BC)
                    }
                }

                7 -> {
                    _localctx = WhileStmtContext(_localctx)
                    enterOuterAlt(_localctx, 7)
                    run {
                        state = 202
                        match(WHILE)
                        state = 203
                        match(PO)
                        state = 204
                        (_localctx as WhileStmtContext).cond = expr(0)
                        state = 205
                        match(PC)
                        state = 206
                        match(BO)
                        state = 210
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 8584265384067184L != 0L) {
                            run {
                                run {
                                    state = 207
                                    (_localctx as WhileStmtContext).stmt = stmt()
                                    (_localctx as WhileStmtContext).body.add((_localctx as WhileStmtContext).stmt)
                                }
                            }
                            state = 212
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 213
                        match(BC)
                    }
                }

                8 -> {
                    _localctx = ForStmtContext(_localctx)
                    enterOuterAlt(_localctx, 8)
                    run {
                        state = 215
                        match(FOR)
                        state = 216
                        match(PO)
                        state = 217
                        (_localctx as ForStmtContext).v = match(ID)
                        state = 218
                        match(COLON)
                        state = 219
                        (_localctx as ForStmtContext).set = expr(0)
                        state = 220
                        match(PC)
                        state = 221
                        match(BO)
                        state = 225
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 8584265384067184L != 0L) {
                            run {
                                run {
                                    state = 222
                                    (_localctx as ForStmtContext).stmt = stmt()
                                    (_localctx as ForStmtContext).body.add((_localctx as ForStmtContext).stmt)
                                }
                            }
                            state = 227
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 228
                        match(BC)
                    }
                }

                9 -> {
                    _localctx = BreakStmtContext(_localctx)
                    enterOuterAlt(_localctx, 9)
                    run {
                        state = 230
                        match(BREAK)
                        state = 231
                        match(SEMI)
                    }
                }

                10 -> {
                    _localctx = ReturnStmtContext(_localctx)
                    enterOuterAlt(_localctx, 10)
                    run {
                        state = 232
                        match(RETURN)
                        state = 234
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la and 0x3f.inv() == 0 && 1L shl _la and 8524513799045232L != 0L) {
                            run {
                                state = 233
                                _localctx.e = expr(0)
                            }
                        }
                        state = 236
                        match(SEMI)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    open class ExprContext : ParserRuleContext {
        constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState)

        override fun getRuleIndex(): Int {
            return RULE_expr
        }

        constructor()

        fun copyFrom(ctx: ExprContext?) {
            super.copyFrom(ctx)
        }
    }

    class MemberCallExprContext(ctx: ExprContext?) : ExprContext() {
        var base: ExprContext? = null
        var name: Token? = null
        var args: ExprListContext? = null
        fun DOT(): TerminalNode {
            return getToken(DOT, 0)
        }

        fun PO(): TerminalNode {
            return getToken(PO, 0)
        }

        fun PC(): TerminalNode {
            return getToken(PC, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun exprList(): ExprListContext {
            return getRuleContext(ExprListContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMemberCallExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class CurrencyExprContext(ctx: ExprContext?) : ExprContext() {
        var count: ExprContext? = null
        fun CURRENCY(): TerminalNode {
            return getToken(CURRENCY, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitCurrencyExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class MemberExprContext(ctx: ExprContext?) : ExprContext() {
        var base: ExprContext? = null
        var name: Token? = null
        fun DOT(): TerminalNode {
            return getToken(DOT, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMemberExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class NameExprContext(ctx: ExprContext?) : ExprContext() {
        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitNameExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class ParenExprContext(ctx: ExprContext?) : ExprContext() {
        var e: ExprContext? = null
        fun PO(): TerminalNode {
            return getToken(PO, 0)
        }

        fun PC(): TerminalNode {
            return getToken(PC, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitParenExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class CmpExprContext(ctx: ExprContext?) : ExprContext() {
        var left: ExprContext? = null
        var op: Token? = null
        var right: ExprContext? = null
        fun expr(): MutableList<ExprContext?> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitCmpExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class IndexExprContext(ctx: ExprContext?) : ExprContext() {
        var base: ExprContext? = null
        var index: ExprContext? = null
        fun BRO(): TerminalNode {
            return getToken(BRO, 0)
        }

        fun BRC(): TerminalNode {
            return getToken(BRC, 0)
        }

        fun expr(): MutableList<ExprContext?> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitIndexExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class UnaryExprContext(ctx: ExprContext?) : ExprContext() {
        var op: Token? = null
        var right: ExprContext? = null
        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitUnaryExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class TernaryExprContext(ctx: ExprContext?) : ExprContext() {
        var cond: ExprContext? = null
        var bTrue: ExprContext? = null
        var bFalse: ExprContext? = null
        fun QMARK(): TerminalNode {
            return getToken(QMARK, 0)
        }

        fun COLON(): TerminalNode {
            return getToken(COLON, 0)
        }

        fun expr(): MutableList<ExprContext?> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitTernaryExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class RangeInclusiveExprContext(ctx: ExprContext?) : ExprContext() {
        var begin: ExprContext? = null
        var end: ExprContext? = null
        fun expr(): MutableList<ExprContext?> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitRangeInclusiveExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class AddExprContext(ctx: ExprContext?) : ExprContext() {
        var left: ExprContext? = null
        var op: Token? = null
        var right: ExprContext? = null
        fun expr(): MutableList<ExprContext?> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitAddExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class LiteralExprContext(ctx: ExprContext?) : ExprContext() {
        fun literal(): LiteralContext {
            return getRuleContext(LiteralContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitLiteralExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class MulExprContext(ctx: ExprContext?) : ExprContext() {
        var left: ExprContext? = null
        var op: Token? = null
        var right: ExprContext? = null
        fun expr(): MutableList<ExprContext?> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMulExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class DiceExprContext(ctx: ExprContext?) : ExprContext() {
        var count: ExprContext? = null
        fun DICE(): TerminalNode {
            return getToken(DICE, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDiceExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class CallExprContext(ctx: ExprContext?) : ExprContext() {
        var args: ExprListContext? = null
        fun ID(): TerminalNode {
            return getToken(ID, 0)
        }

        fun PO(): TerminalNode {
            return getToken(PO, 0)
        }

        fun PC(): TerminalNode {
            return getToken(PC, 0)
        }

        fun exprList(): ExprListContext {
            return getRuleContext(ExprListContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitCallExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class BoolExprContext(ctx: ExprContext?) : ExprContext() {
        var left: ExprContext? = null
        var op: Token? = null
        var right: ExprContext? = null
        fun expr(): MutableList<ExprContext?> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitBoolExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class ListExprContext(ctx: ExprContext?) : ExprContext() {
        var exprs: ExprListContext? = null
        fun BRO(): TerminalNode {
            return getToken(BRO, 0)
        }

        fun BRC(): TerminalNode {
            return getToken(BRC, 0)
        }

        fun exprList(): ExprListContext {
            return getRuleContext(ExprListContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitListExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class RangeExprContext(ctx: ExprContext?) : ExprContext() {
        var begin: ExprContext? = null
        var end: ExprContext? = null
        fun expr(): MutableList<ExprContext?> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitRangeExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun expr(): ExprContext {
        return expr(0)
    }

    @Throws(RecognitionException::class)
    private fun expr(_p: Int): ExprContext {
        val _parentctx = _ctx
        val _parentState = state
        var _localctx = ExprContext(_ctx, _parentState)
        var _prevctx = _localctx
        val _startState = 24
        enterRecursionRule(_localctx, 24, RULE_expr, _p)
        var _la: Int
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                state = 259
                _errHandler.sync(this)
                when (interpreter.adaptivePredict(_input, 24, _ctx)) {
                    1 -> {
                        _localctx = LiteralExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 240
                        literal()
                    }

                    2 -> {
                        _localctx = NameExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 241
                        match(ID)
                    }

                    3 -> {
                        _localctx = ListExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 242
                        match(BRO)
                        state = 244
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la and 0x3f.inv() == 0 && 1L shl _la and 8524513799045232L != 0L) {
                            run {
                                state = 243
                                (_localctx as ListExprContext).exprs = exprList()
                            }
                        }
                        state = 246
                        match(BRC)
                    }

                    4 -> {
                        _localctx = CallExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 247
                        match(ID)
                        state = 248
                        match(PO)
                        state = 250
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la and 0x3f.inv() == 0 && 1L shl _la and 8524513799045232L != 0L) {
                            run {
                                state = 249
                                (_localctx as CallExprContext).args = exprList()
                            }
                        }
                        state = 252
                        match(PC)
                    }

                    5 -> {
                        _localctx = ParenExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 253
                        match(PO)
                        state = 254
                        (_localctx as ParenExprContext).e = expr(0)
                        state = 255
                        match(PC)
                    }

                    6 -> {
                        _localctx = UnaryExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 257
                        (_localctx as UnaryExprContext).op = _input.LT(1)
                        _la = _input.LA(1)
                        if (!(_la and 0x3f.inv() == 0 && 1L shl _la and 112L != 0L)) {
                            (_localctx as UnaryExprContext).op =
                                _errHandler.recoverInline(this) as Token
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true
                            _errHandler.reportMatch(this)
                            consume()
                        }
                        state = 258
                        (_localctx as UnaryExprContext).right = expr(8)
                    }
                }
                _ctx.stop = _input.LT(-1)
                state = 312
                _errHandler.sync(this)
                _alt = interpreter.adaptivePredict(_input, 28, _ctx)
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent()
                        _prevctx = _localctx
                        run {
                            state = 310
                            _errHandler.sync(this)
                            when (interpreter.adaptivePredict(_input, 27, _ctx)) {
                                1 -> {
                                    _localctx =
                                        MulExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as MulExprContext).left = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 261
                                    if (!precpred(_ctx, 7)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 7)"
                                    )
                                    state = 262
                                    (_localctx as MulExprContext).op = _input.LT(1)
                                    _la = _input.LA(1)
                                    if (!(_la and 0x3f.inv() == 0 && 1L shl _la and 896L != 0L)) {
                                        (_localctx as MulExprContext).op =
                                            _errHandler.recoverInline(this) as Token
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                    state = 263
                                    (_localctx as MulExprContext).right = expr(8)
                                }

                                2 -> {
                                    _localctx =
                                        AddExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as AddExprContext).left = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 264
                                    if (!precpred(_ctx, 6)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 6)"
                                    )
                                    state = 265
                                    (_localctx as AddExprContext).op = _input.LT(1)
                                    _la = _input.LA(1)
                                    if (!(_la == T__3 || _la == T__4)) {
                                        (_localctx as AddExprContext).op =
                                            _errHandler.recoverInline(this) as Token
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                    state = 266
                                    (_localctx as AddExprContext).right = expr(7)
                                }

                                3 -> {
                                    _localctx =
                                        CmpExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as CmpExprContext).left = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 267
                                    if (!precpred(_ctx, 5)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 5)"
                                    )
                                    state = 268
                                    (_localctx as CmpExprContext).op = _input.LT(1)
                                    _la = _input.LA(1)
                                    if (!(_la and 0x3f.inv() == 0 && 1L shl _la and 64512L != 0L)) {
                                        (_localctx as CmpExprContext).op =
                                            _errHandler.recoverInline(this) as Token
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                    state = 269
                                    (_localctx as CmpExprContext).right = expr(6)
                                }

                                4 -> {
                                    _localctx =
                                        BoolExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as BoolExprContext).left = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 270
                                    if (!precpred(_ctx, 4)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 4)"
                                    )
                                    state = 271
                                    (_localctx as BoolExprContext).op = _input.LT(1)
                                    _la = _input.LA(1)
                                    if (!(_la == T__15 || _la == T__16)) {
                                        (_localctx as BoolExprContext).op =
                                            _errHandler.recoverInline(this) as Token
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                    state = 272
                                    (_localctx as BoolExprContext).right = expr(5)
                                }

                                5 -> {
                                    _localctx =
                                        TernaryExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as TernaryExprContext).cond = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 273
                                    if (!precpred(_ctx, 3)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 3)"
                                    )
                                    state = 274
                                    match(QMARK)
                                    state = 275
                                    (_localctx as TernaryExprContext).bTrue = expr(0)
                                    state = 276
                                    match(COLON)
                                    state = 277
                                    (_localctx as TernaryExprContext).bFalse = expr(4)
                                }

                                6 -> {
                                    _localctx =
                                        DiceExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as DiceExprContext).count = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 279
                                    if (!precpred(_ctx, 13)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 13)"
                                    )
                                    state = 280
                                    match(DICE)
                                }

                                7 -> {
                                    _localctx =
                                        CurrencyExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as CurrencyExprContext).count = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 281
                                    if (!precpred(_ctx, 12)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 12)"
                                    )
                                    state = 282
                                    match(CURRENCY)
                                }

                                8 -> {
                                    _localctx =
                                        IndexExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as IndexExprContext).base = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 283
                                    if (!precpred(_ctx, 11)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 11)"
                                    )
                                    state = 284
                                    match(BRO)
                                    state = 285
                                    (_localctx as IndexExprContext).index = expr(0)
                                    state = 286
                                    match(BRC)
                                }

                                9 -> {
                                    _localctx =
                                        MemberExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as MemberExprContext).base = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 288
                                    if (!precpred(_ctx, 10)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 10)"
                                    )
                                    state = 289
                                    match(DOT)
                                    state = 290
                                    (_localctx as MemberExprContext).name = match(ID)
                                }

                                10 -> {
                                    _localctx =
                                        MemberCallExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as MemberCallExprContext).base = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 291
                                    if (!precpred(_ctx, 9)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 9)"
                                    )
                                    state = 292
                                    match(DOT)
                                    state = 293
                                    (_localctx as MemberCallExprContext).name = match(ID)
                                    state = 294
                                    match(PO)
                                    state = 296
                                    _errHandler.sync(this)
                                    _la = _input.LA(1)
                                    if (_la and 0x3f.inv() == 0 && 1L shl _la and 8524513799045232L != 0L) {
                                        run {
                                            state = 295
                                            (_localctx as MemberCallExprContext).args = exprList()
                                        }
                                    }
                                    state = 298
                                    match(PC)
                                }

                                11 -> {
                                    _localctx =
                                        RangeExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as RangeExprContext).begin = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 299
                                    if (!precpred(_ctx, 2)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 2)"
                                    )
                                    state = 300
                                    match(T__17)
                                    state = 301
                                    (_localctx as RangeExprContext).end = expr(0)
                                    state = 303
                                    _errHandler.sync(this)
                                    when (interpreter.adaptivePredict(_input, 26, _ctx)) {
                                        1 -> {
                                            state = 302
                                            match(T__18)
                                        }

                                        else -> {}
                                    }
                                }

                                12 -> {
                                    _localctx = RangeInclusiveExprContext(
                                        ExprContext(
                                            _parentctx,
                                            _parentState
                                        )
                                    )
                                    (_localctx as RangeInclusiveExprContext).begin = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 305
                                    if (!precpred(_ctx, 1)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 1)"
                                    )
                                    state = 306
                                    match(T__17)
                                    state = 307
                                    (_localctx as RangeInclusiveExprContext).end = expr(0)
                                    state = 308
                                    match(T__19)
                                }

                                else -> {}
                            }
                        }
                    }
                    state = 314
                    _errHandler.sync(this)
                    _alt = interpreter.adaptivePredict(_input, 28, _ctx)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            unrollRecursionContexts(_parentctx)
        }
        return _localctx
    }

    open class LiteralContext : ParserRuleContext {
        constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState)

        override fun getRuleIndex(): Int {
            return RULE_literal
        }

        constructor()

        fun copyFrom(ctx: LiteralContext?) {
            super.copyFrom(ctx)
        }
    }

    class InfFloatLiteralContext(ctx: LiteralContext?) : LiteralContext() {
        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitInfFloatLiteral(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class DiceLiteralContext(ctx: LiteralContext?) : LiteralContext() {
        fun DICE(): TerminalNode {
            return getToken(DICE, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDiceLiteral(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class FalseLiteralContext(ctx: LiteralContext?) : LiteralContext() {
        fun FALSE(): TerminalNode {
            return getToken(FALSE, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitFalseLiteral(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class StringLiteralContext(ctx: LiteralContext?) : LiteralContext() {
        fun STRING(): TerminalNode {
            return getToken(STRING, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitStringLiteral(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class IntLiteralContext(ctx: LiteralContext?) : LiteralContext() {
        fun INT(): TerminalNode {
            return getToken(INT, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitIntLiteral(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class FloatLiteralContext(ctx: LiteralContext?) : LiteralContext() {
        fun FLOAT(): TerminalNode {
            return getToken(FLOAT, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitFloatLiteral(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class TrueLiteralContext(ctx: LiteralContext?) : LiteralContext() {
        fun TRUE(): TerminalNode {
            return getToken(TRUE, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitTrueLiteral(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class InfIntLiteralContext(ctx: LiteralContext?) : LiteralContext() {
        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitInfIntLiteral(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun literal(): LiteralContext {
        var _localctx = LiteralContext(_ctx, state)
        enterRule(_localctx, 26, RULE_literal)
        try {
            state = 323
            _errHandler.sync(this)
            when (_input.LA(1)) {
                STRING -> {
                    _localctx = StringLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 315
                        match(STRING)
                    }
                }

                INT -> {
                    _localctx = IntLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 316
                        match(INT)
                    }
                }

                FLOAT -> {
                    _localctx = FloatLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 317
                        match(FLOAT)
                    }
                }

                DICE -> {
                    _localctx = DiceLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 318
                        match(DICE)
                    }
                }

                TRUE -> {
                    _localctx = TrueLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 319
                        match(TRUE)
                    }
                }

                FALSE -> {
                    _localctx = FalseLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 320
                        match(FALSE)
                    }
                }

                T__20 -> {
                    _localctx = InfIntLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 7)
                    run {
                        state = 321
                        match(T__20)
                    }
                }

                T__21 -> {
                    _localctx = InfFloatLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 8)
                    run {
                        state = 322
                        match(T__21)
                    }
                }

                else -> throw NoViableAltException(this)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    override fun sempred(_localctx: RuleContext, ruleIndex: Int, predIndex: Int): Boolean {
        when (ruleIndex) {
            12 -> return expr_sempred(_localctx as ExprContext, predIndex)
        }
        return true
    }

    private fun expr_sempred(_localctx: ExprContext, predIndex: Int): Boolean {
        when (predIndex) {
            0 -> return precpred(_ctx, 7)
            1 -> return precpred(_ctx, 6)
            2 -> return precpred(_ctx, 5)
            3 -> return precpred(_ctx, 4)
            4 -> return precpred(_ctx, 3)
            5 -> return precpred(_ctx, 13)
            6 -> return precpred(_ctx, 12)
            7 -> return precpred(_ctx, 11)
            8 -> return precpred(_ctx, 10)
            9 -> return precpred(_ctx, 9)
            10 -> return precpred(_ctx, 2)
            11 -> return precpred(_ctx, 1)
        }
        return true
    }

    init {
        _interp = ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache)
    }

    companion object {
        init {
            RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION)
        }

        protected val _decisionToDFA: Array<DFA>
        protected val _sharedContextCache = PredictionContextCache()
        const val T__0 = 1
        const val T__1 = 2
        const val T__2 = 3
        const val T__3 = 4
        const val T__4 = 5
        const val T__5 = 6
        const val T__6 = 7
        const val T__7 = 8
        const val T__8 = 9
        const val T__9 = 10
        const val T__10 = 11
        const val T__11 = 12
        const val T__12 = 13
        const val T__13 = 14
        const val T__14 = 15
        const val T__15 = 16
        const val T__16 = 17
        const val T__17 = 18
        const val T__18 = 19
        const val T__19 = 20
        const val T__20 = 21
        const val T__21 = 22
        const val PO = 23
        const val PC = 24
        const val BO = 25
        const val BC = 26
        const val BRO = 27
        const val BRC = 28
        const val COMMA = 29
        const val SEMI = 30
        const val QMARK = 31
        const val EQ = 32
        const val DOT = 33
        const val COLON = 34
        const val IF = 35
        const val FOR = 36
        const val FUN = 37
        const val VAR = 38
        const val ELSE = 39
        const val TRUE = 40
        const val BREAK = 41
        const val CONST = 42
        const val FALSE = 43
        const val WHILE = 44
        const val RETURN = 45
        const val DICE = 46
        const val CURRENCY = 47
        const val TAGNAME = 48
        const val ID = 49
        const val INT = 50
        const val FLOAT = 51
        const val STRING = 52
        const val COMMENT = 53
        const val WS = 54
        const val RULE_program = 0
        const val RULE_preamble = 1
        const val RULE_dependency = 2
        const val RULE_idList = 3
        const val RULE_declaration = 4
        const val RULE_bodyDecl = 5
        const val RULE_funDecl = 6
        const val RULE_globalDecl = 7
        const val RULE_tagList = 8
        const val RULE_tag = 9
        const val RULE_exprList = 10
        const val RULE_stmt = 11
        const val RULE_expr = 12
        const val RULE_literal = 13
        private fun makeRuleNames(): Array<String> {
            return arrayOf(
                "program", "preamble", "dependency", "idList", "declaration", "bodyDecl",
                "funDecl", "globalDecl", "tagList", "tag", "exprList", "stmt", "expr",
                "literal"
            )
        }

        val ruleNames = makeRuleNames()
        private fun makeLiteralNames(): Array<String?> {
            return arrayOf(
                null, "'source'", "'import'", "'all'", "'+'", "'-'", "'!'", "'*'", "'/'",
                "'%'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'",
                "'to'", "'exclusive'", "'inclusive'", "'INF'", "'INFF'", "'('", "')'",
                "'{'", "'}'", "'['", "']'", "','", "';'", "'?'", "'='", "'.'", "':'",
                "'if'", "'for'", "'fun'", "'var'", "'else'", "'true'", "'break'", "'const'",
                "'false'", "'while'", "'return'"
            )
        }

        private val _LITERAL_NAMES = makeLiteralNames()
        private fun makeSymbolicNames(): Array<String?> {
            return arrayOf(
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, "PO",
                "PC", "BO", "BC", "BRO", "BRC", "COMMA", "SEMI", "QMARK", "EQ", "DOT",
                "COLON", "IF", "FOR", "FUN", "VAR", "ELSE", "TRUE", "BREAK", "CONST",
                "FALSE", "WHILE", "RETURN", "DICE", "CURRENCY", "TAGNAME", "ID", "INT",
                "FLOAT", "STRING", "COMMENT", "WS"
            )
        }

        private val _SYMBOLIC_NAMES = makeSymbolicNames()
        val VOCABULARY: Vocabulary = VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES)

        @Deprecated("Use {@link #VOCABULARY} instead.")
        val tokenNames = _SYMBOLIC_NAMES.indices.map {
            VOCABULARY.getLiteralName(it) ?: VOCABULARY.getSymbolicName(it) ?: "<INVALID>"
        }.toTypedArray()

        const val _serializedATN =
            "\u0004\u00016\u0146\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
                    "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
                    "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
                    "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002" +
                    "\u000c\u0007\u000c\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0005\u0000\u001f\b" +
                    "\u0000\n\u0000\u000c\u0000\"\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001" +
                    "\u0001\u0001\u0001\u0001\u0001\u0005\u0001*\b\u0001\n\u0001\u000c\u0001-\t" +
                    "\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001" +
                    "\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u00039\b" +
                    "\u0003\n\u0003\u000c\u0003<\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003" +
                    "\u0004A\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004F\b\u0004" +
                    "\u0001\u0004\u0001\u0004\u0005\u0004J\b\u0004\n\u0004\u000c\u0004M\t\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004X\b\u0004\u0001\u0004" +
                    "\u0001\u0004\u0003\u0004\\\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005" +
                    "f\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006" +
                    "l\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006q\b\u0006\n\u0006" +
                    "\u000c\u0006t\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001" +
                    "\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0004\b\u007f\b\b\u000b" +
                    "\b\u000c\b\u0080\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0087\b\t\u0001\t" +
                    "\u0003\t\u008a\b\t\u0001\n\u0001\n\u0001\n\u0005\n\u008f\b\n\n\n\u000c\n\u0092" +
                    "\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00ae\b\u000b\n\u000b\u000c\u000b" +
                    "\u00b1\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b" +
                    "\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00bb\b\u000b\n\u000b" +
                    "\u000c\u000b\u00be\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b" +
                    "\u0005\u000b\u00c4\b\u000b\n\u000b\u000c\u000b\u00c7\t\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0005\u000b\u00d1\b\u000b\n\u000b\u000c\u000b\u00d4\t\u000b\u0001\u000b" +
                    "\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b" +
                    "\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00e0\b\u000b\n\u000b" +
                    "\u000c\u000b\u00e3\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b" +
                    "\u0001\u000b\u0001\u000b\u0003\u000b\u00eb\b\u000b\u0001\u000b\u0003\u000b" +
                    "\u00ee\b\u000b\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0003\u000c\u00f5\b" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0003\u000c\u00fb\b\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0003\u000c\u0104\b\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0003\u000c\u0129\b\u000c\u0001\u000c\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0003\u000c\u0130\b\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0001\u000c\u0005\u000c\u0137\b\u000c\n\u000c\u000c\u000c\u013a\t\u000c\u0001\r\u0001\r\u0001\r" +
                    "\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0144\b\r\u0001\r\u0000" +
                    "\u0001\u0018\u000e\u0000\u0002\u0004\u0006\b\n\u000c\u000e\u0010\u0012\u0014" +
                    "\u0016\u0018\u001a\u0000\u0005\u0001\u0000\u0004\u0006\u0001\u0000\u0007" +
                    "\t\u0001\u0000\u0004\u0005\u0001\u0000\n\u000f\u0001\u0000\u0010\u0011" +
                    "\u0176\u0000\u001c\u0001\u0000\u0000\u0000\u0002%\u0001\u0000\u0000\u0000" +
                    "\u0004.\u0001\u0000\u0000\u0000\u00065\u0001\u0000\u0000\u0000\b[\u0001" +
                    "\u0000\u0000\u0000\ne\u0001\u0000\u0000\u0000\u000cg\u0001\u0000\u0000\u0000" +
                    "\u000ew\u0001\u0000\u0000\u0000\u0010~\u0001\u0000\u0000\u0000\u0012\u0089" +
                    "\u0001\u0000\u0000\u0000\u0014\u008b\u0001\u0000\u0000\u0000\u0016\u00ed" +
                    "\u0001\u0000\u0000\u0000\u0018\u0103\u0001\u0000\u0000\u0000\u001a\u0143" +
                    "\u0001\u0000\u0000\u0000\u001c \u0003\u0002\u0001\u0000\u001d\u001f\u0003" +
                    "\b\u0004\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000" +
                    "\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000" +
                    "!#\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000#$\u0005\u0000\u0000" +
                    "\u0001$\u0001\u0001\u0000\u0000\u0000%&\u0005\u0001\u0000\u0000&\'\u0005" +
                    "1\u0000\u0000\'+\u0005\u001e\u0000\u0000(*\u0003\u0004\u0002\u0000)(\u0001" +
                    "\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000" +
                    "+,\u0001\u0000\u0000\u0000,\u0003\u0001\u0000\u0000\u0000-+\u0001\u0000" +
                    "\u0000\u0000./\u0005\u0002\u0000\u0000/0\u00051\u0000\u000001\u0005\u0017" +
                    "\u0000\u000012\u0003\u0006\u0003\u000023\u0005\u0018\u0000\u000034\u0005" +
                    "\u001e\u0000\u00004\u0005\u0001\u0000\u0000\u00005:\u00051\u0000\u0000" +
                    "67\u0005\u001d\u0000\u000079\u00051\u0000\u000086\u0001\u0000\u0000\u0000" +
                    "9<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000" +
                    "\u0000;\u0007\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=>\u0005" +
                    "1\u0000\u0000>@\u00051\u0000\u0000?A\u0003\u0010\b\u0000@?\u0001\u0000" +
                    "\u0000\u0000@A\u0001\u0000\u0000\u0000A\\\u0001\u0000\u0000\u0000BC\u0005" +
                    "1\u0000\u0000CE\u00051\u0000\u0000DF\u0003\u0010\b\u0000ED\u0001\u0000" +
                    "\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GK\u0005" +
                    "\u0019\u0000\u0000HJ\u0003\n\u0005\u0000IH\u0001\u0000\u0000\u0000JM\u0001" +
                    "\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000" +
                    "LN\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000N\\\u0005\u001a\u0000" +
                    "\u0000OP\u00051\u0000\u0000P\\\u0003\u0006\u0003\u0000QR\u00051\u0000" +
                    "\u0000RS\u0005\u0017\u0000\u0000ST\u0003\u0006\u0003\u0000TU\u0005\u0018" +
                    "\u0000\u0000UW\u0005\u0003\u0000\u0000VX\u0003\u0010\b\u0000WV\u0001\u0000" +
                    "\u0000\u0000WX\u0001\u0000\u0000\u0000X\\\u0001\u0000\u0000\u0000Y\\\u0003" +
                    "\u000c\u0006\u0000Z\\\u0003\u000e\u0007\u0000[=\u0001\u0000\u0000\u0000[B" +
                    "\u0001\u0000\u0000\u0000[O\u0001\u0000\u0000\u0000[Q\u0001\u0000\u0000" +
                    "\u0000[Y\u0001\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\\t\u0001\u0000" +
                    "\u0000\u0000]f\u0003\u000c\u0006\u0000^f\u0003\u000e\u0007\u0000_`\u0005&" +
                    "\u0000\u0000`a\u00051\u0000\u0000ab\u0005 \u0000\u0000bc\u0003\u0018\u000c" +
                    "\u0000cd\u0005\u001e\u0000\u0000df\u0001\u0000\u0000\u0000e]\u0001\u0000" +
                    "\u0000\u0000e^\u0001\u0000\u0000\u0000e_\u0001\u0000\u0000\u0000f\u000b" +
                    "\u0001\u0000\u0000\u0000gh\u0005%\u0000\u0000hi\u00051\u0000\u0000ik\u0005" +
                    "\u0017\u0000\u0000jl\u0003\u0006\u0003\u0000kj\u0001\u0000\u0000\u0000" +
                    "kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0005\u0018\u0000" +
                    "\u0000nr\u0005\u0019\u0000\u0000oq\u0003\u0016\u000b\u0000po\u0001\u0000" +
                    "\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001" +
                    "\u0000\u0000\u0000su\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000" +
                    "uv\u0005\u001a\u0000\u0000v\r\u0001\u0000\u0000\u0000wx\u0005*\u0000\u0000" +
                    "xy\u00051\u0000\u0000yz\u0005 \u0000\u0000z{\u0003\u0018\u000c\u0000{|\u0005" +
                    "\u001e\u0000\u0000|\u000f\u0001\u0000\u0000\u0000}\u007f\u0003\u0012\t" +
                    "\u0000~}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080" +
                    "~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0011" +
                    "\u0001\u0000\u0000\u0000\u0082\u008a\u00050\u0000\u0000\u0083\u0084\u0005" +
                    "0\u0000\u0000\u0084\u0086\u0005\u0017\u0000\u0000\u0085\u0087\u0003\u0014" +
                    "\n\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000" +
                    "\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008a\u0005\u0018\u0000" +
                    "\u0000\u0089\u0082\u0001\u0000\u0000\u0000\u0089\u0083\u0001\u0000\u0000" +
                    "\u0000\u008a\u0013\u0001\u0000\u0000\u0000\u008b\u0090\u0003\u0018\u000c\u0000" +
                    "\u008c\u008d\u0005\u001d\u0000\u0000\u008d\u008f\u0003\u0018\u000c\u0000\u008e" +
                    "\u008c\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090" +
                    "\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091" +
                    "\u0015\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093" +
                    "\u0094\u0003\u0018\u000c\u0000\u0094\u0095\u0005\u001e\u0000\u0000\u0095\u00ee" +
                    "\u0001\u0000\u0000\u0000\u0096\u0097\u0005&\u0000\u0000\u0097\u0098\u0005" +
                    "1\u0000\u0000\u0098\u0099\u0005 \u0000\u0000\u0099\u009a\u0003\u0018\u000c" +
                    "\u0000\u009a\u009b\u0005\u001e\u0000\u0000\u009b\u00ee\u0001\u0000\u0000" +
                    "\u0000\u009c\u009d\u0005*\u0000\u0000\u009d\u009e\u00051\u0000\u0000\u009e" +
                    "\u009f\u0005 \u0000\u0000\u009f\u00a0\u0003\u0018\u000c\u0000\u00a0\u00a1" +
                    "\u0005\u001e\u0000\u0000\u00a1\u00ee\u0001\u0000\u0000\u0000\u00a2\u00a3" +
                    "\u00051\u0000\u0000\u00a3\u00a4\u0005 \u0000\u0000\u00a4\u00a5\u0003\u0018" +
                    "\u000c\u0000\u00a5\u00a6\u0005\u001e\u0000\u0000\u00a6\u00ee\u0001\u0000\u0000" +
                    "\u0000\u00a7\u00a8\u0005#\u0000\u0000\u00a8\u00a9\u0005\u0017\u0000\u0000" +
                    "\u00a9\u00aa\u0003\u0018\u000c\u0000\u00aa\u00ab\u0005\u0018\u0000\u0000\u00ab" +
                    "\u00af\u0005\u0019\u0000\u0000\u00ac\u00ae\u0003\u0016\u000b\u0000\u00ad" +
                    "\u00ac\u0001\u0000\u0000\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af" +
                    "\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0" +
                    "\u00b2\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2" +
                    "\u00b3\u0005\u001a\u0000\u0000\u00b3\u00ee\u0001\u0000\u0000\u0000\u00b4" +
                    "\u00b5\u0005#\u0000\u0000\u00b5\u00b6\u0005\u0017\u0000\u0000\u00b6\u00b7" +
                    "\u0003\u0018\u000c\u0000\u00b7\u00b8\u0005\u0018\u0000\u0000\u00b8\u00bc\u0005" +
                    "\u0019\u0000\u0000\u00b9\u00bb\u0003\u0016\u000b\u0000\u00ba\u00b9\u0001" +
                    "\u0000\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001" +
                    "\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bf\u0001" +
                    "\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005" +
                    "\u001a\u0000\u0000\u00c0\u00c1\u0005\'\u0000\u0000\u00c1\u00c5\u0005\u0019" +
                    "\u0000\u0000\u00c2\u00c4\u0003\u0016\u000b\u0000\u00c3\u00c2\u0001\u0000" +
                    "\u0000\u0000\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000" +
                    "\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c8\u0001\u0000" +
                    "\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u001a" +
                    "\u0000\u0000\u00c9\u00ee\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005,\u0000" +
                    "\u0000\u00cb\u00cc\u0005\u0017\u0000\u0000\u00cc\u00cd\u0003\u0018\u000c\u0000" +
                    "\u00cd\u00ce\u0005\u0018\u0000\u0000\u00ce\u00d2\u0005\u0019\u0000\u0000" +
                    "\u00cf\u00d1\u0003\u0016\u000b\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000" +
                    "\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000" +
                    "\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d5\u0001\u0000\u0000\u0000" +
                    "\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005\u001a\u0000\u0000" +
                    "\u00d6\u00ee\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005$\u0000\u0000\u00d8" +
                    "\u00d9\u0005\u0017\u0000\u0000\u00d9\u00da\u00051\u0000\u0000\u00da\u00db" +
                    "\u0005\"\u0000\u0000\u00db\u00dc\u0003\u0018\u000c\u0000\u00dc\u00dd\u0005" +
                    "\u0018\u0000\u0000\u00dd\u00e1\u0005\u0019\u0000\u0000\u00de\u00e0\u0003" +
                    "\u0016\u000b\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001" +
                    "\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001" +
                    "\u0000\u0000\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001" +
                    "\u0000\u0000\u0000\u00e4\u00e5\u0005\u001a\u0000\u0000\u00e5\u00ee\u0001" +
                    "\u0000\u0000\u0000\u00e6\u00e7\u0005)\u0000\u0000\u00e7\u00ee\u0005\u001e" +
                    "\u0000\u0000\u00e8\u00ea\u0005-\u0000\u0000\u00e9\u00eb\u0003\u0018\u000c" +
                    "\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000" +
                    "\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ee\u0005\u001e\u0000" +
                    "\u0000\u00ed\u0093\u0001\u0000\u0000\u0000\u00ed\u0096\u0001\u0000\u0000" +
                    "\u0000\u00ed\u009c\u0001\u0000\u0000\u0000\u00ed\u00a2\u0001\u0000\u0000" +
                    "\u0000\u00ed\u00a7\u0001\u0000\u0000\u0000\u00ed\u00b4\u0001\u0000\u0000" +
                    "\u0000\u00ed\u00ca\u0001\u0000\u0000\u0000\u00ed\u00d7\u0001\u0000\u0000" +
                    "\u0000\u00ed\u00e6\u0001\u0000\u0000\u0000\u00ed\u00e8\u0001\u0000\u0000" +
                    "\u0000\u00ee\u0017\u0001\u0000\u0000\u0000\u00ef\u00f0\u0006\u000c\uffff\uffff" +
                    "\u0000\u00f0\u0104\u0003\u001a\r\u0000\u00f1\u0104\u00051\u0000\u0000" +
                    "\u00f2\u00f4\u0005\u001b\u0000\u0000\u00f3\u00f5\u0003\u0014\n\u0000\u00f4" +
                    "\u00f3\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5" +
                    "\u00f6\u0001\u0000\u0000\u0000\u00f6\u0104\u0005\u001c\u0000\u0000\u00f7" +
                    "\u00f8\u00051\u0000\u0000\u00f8\u00fa\u0005\u0017\u0000\u0000\u00f9\u00fb" +
                    "\u0003\u0014\n\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001" +
                    "\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u0104\u0005" +
                    "\u0018\u0000\u0000\u00fd\u00fe\u0005\u0017\u0000\u0000\u00fe\u00ff\u0003" +
                    "\u0018\u000c\u0000\u00ff\u0100\u0005\u0018\u0000\u0000\u0100\u0104\u0001\u0000" +
                    "\u0000\u0000\u0101\u0102\u0007\u0000\u0000\u0000\u0102\u0104\u0003\u0018" +
                    "\u000c\b\u0103\u00ef\u0001\u0000\u0000\u0000\u0103\u00f1\u0001\u0000\u0000" +
                    "\u0000\u0103\u00f2\u0001\u0000\u0000\u0000\u0103\u00f7\u0001\u0000\u0000" +
                    "\u0000\u0103\u00fd\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000" +
                    "\u0000\u0104\u0138\u0001\u0000\u0000\u0000\u0105\u0106\n\u0007\u0000\u0000" +
                    "\u0106\u0107\u0007\u0001\u0000\u0000\u0107\u0137\u0003\u0018\u000c\b\u0108" +
                    "\u0109\n\u0006\u0000\u0000\u0109\u010a\u0007\u0002\u0000\u0000\u010a\u0137" +
                    "\u0003\u0018\u000c\u0007\u010b\u010c\n\u0005\u0000\u0000\u010c\u010d\u0007" +
                    "\u0003\u0000\u0000\u010d\u0137\u0003\u0018\u000c\u0006\u010e\u010f\n\u0004" +
                    "\u0000\u0000\u010f\u0110\u0007\u0004\u0000\u0000\u0110\u0137\u0003\u0018" +
                    "\u000c\u0005\u0111\u0112\n\u0003\u0000\u0000\u0112\u0113\u0005\u001f\u0000" +
                    "\u0000\u0113\u0114\u0003\u0018\u000c\u0000\u0114\u0115\u0005\"\u0000\u0000" +
                    "\u0115\u0116\u0003\u0018\u000c\u0004\u0116\u0137\u0001\u0000\u0000\u0000\u0117" +
                    "\u0118\n\r\u0000\u0000\u0118\u0137\u0005.\u0000\u0000\u0119\u011a\n\u000c" +
                    "\u0000\u0000\u011a\u0137\u0005/\u0000\u0000\u011b\u011c\n\u000b\u0000" +
                    "\u0000\u011c\u011d\u0005\u001b\u0000\u0000\u011d\u011e\u0003\u0018\u000c\u0000" +
                    "\u011e\u011f\u0005\u001c\u0000\u0000\u011f\u0137\u0001\u0000\u0000\u0000" +
                    "\u0120\u0121\n\n\u0000\u0000\u0121\u0122\u0005!\u0000\u0000\u0122\u0137" +
                    "\u00051\u0000\u0000\u0123\u0124\n\t\u0000\u0000\u0124\u0125\u0005!\u0000" +
                    "\u0000\u0125\u0126\u00051\u0000\u0000\u0126\u0128\u0005\u0017\u0000\u0000" +
                    "\u0127\u0129\u0003\u0014\n\u0000\u0128\u0127\u0001\u0000\u0000\u0000\u0128" +
                    "\u0129\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a" +
                    "\u0137\u0005\u0018\u0000\u0000\u012b\u012c\n\u0002\u0000\u0000\u012c\u012d" +
                    "\u0005\u0012\u0000\u0000\u012d\u012f\u0003\u0018\u000c\u0000\u012e\u0130\u0005" +
                    "\u0013\u0000\u0000\u012f\u012e\u0001\u0000\u0000\u0000\u012f\u0130\u0001" +
                    "\u0000\u0000\u0000\u0130\u0137\u0001\u0000\u0000\u0000\u0131\u0132\n\u0001" +
                    "\u0000\u0000\u0132\u0133\u0005\u0012\u0000\u0000\u0133\u0134\u0003\u0018" +
                    "\u000c\u0000\u0134\u0135\u0005\u0014\u0000\u0000\u0135\u0137\u0001\u0000\u0000" +
                    "\u0000\u0136\u0105\u0001\u0000\u0000\u0000\u0136\u0108\u0001\u0000\u0000" +
                    "\u0000\u0136\u010b\u0001\u0000\u0000\u0000\u0136\u010e\u0001\u0000\u0000" +
                    "\u0000\u0136\u0111\u0001\u0000\u0000\u0000\u0136\u0117\u0001\u0000\u0000" +
                    "\u0000\u0136\u0119\u0001\u0000\u0000\u0000\u0136\u011b\u0001\u0000\u0000" +
                    "\u0000\u0136\u0120\u0001\u0000\u0000\u0000\u0136\u0123\u0001\u0000\u0000" +
                    "\u0000\u0136\u012b\u0001\u0000\u0000\u0000\u0136\u0131\u0001\u0000\u0000" +
                    "\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000" +
                    "\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u0019\u0001\u0000\u0000" +
                    "\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b\u0144\u00054\u0000\u0000" +
                    "\u013c\u0144\u00052\u0000\u0000\u013d\u0144\u00053\u0000\u0000\u013e\u0144" +
                    "\u0005.\u0000\u0000\u013f\u0144\u0005(\u0000\u0000\u0140\u0144\u0005+" +
                    "\u0000\u0000\u0141\u0144\u0005\u0015\u0000\u0000\u0142\u0144\u0005\u0016" +
                    "\u0000\u0000\u0143\u013b\u0001\u0000\u0000\u0000\u0143\u013c\u0001\u0000" +
                    "\u0000\u0000\u0143\u013d\u0001\u0000\u0000\u0000\u0143\u013e\u0001\u0000" +
                    "\u0000\u0000\u0143\u013f\u0001\u0000\u0000\u0000\u0143\u0140\u0001\u0000" +
                    "\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0143\u0142\u0001\u0000" +
                    "\u0000\u0000\u0144\u001b\u0001\u0000\u0000\u0000\u001e +:@EKW[ekr\u0080" +
                    "\u0086\u0089\u0090\u00af\u00bc\u00c5\u00d2\u00e1\u00ea\u00ed\u00f4\u00fa" +
                    "\u0103\u0128\u012f\u0136\u0138\u0143"
        val _ATN = ATNDeserializer().deserialize(_serializedATN.toCharArray())

        init {
            _decisionToDFA = (0 until _ATN.numberOfDecisions).map {
                DFA(_ATN.getDecisionState(it), it)
            }.toTypedArray()
        }
    }
}