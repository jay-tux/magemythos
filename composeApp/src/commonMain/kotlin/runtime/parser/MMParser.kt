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
                while (_la and 0x3f.inv() == 0 && 1L shl _la and 143005231087616L != 0L) {
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
            state = 89
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
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 2405181685760L != 0L) {
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
                    _localctx = MultipleDeclContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 79
                        (_localctx as MultipleDeclContext).kind = match(ID)
                        state = 80
                        match(PO)
                        state = 81
                        (_localctx as MultipleDeclContext).names = idList()
                        state = 82
                        match(PC)
                        state = 83
                        match(T__2)
                        state = 85
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la == TAGNAME) {
                            run {
                                state = 84
                                (_localctx as MultipleDeclContext).tags = tagList()
                            }
                        }
                    }
                }

                4 -> {
                    _localctx = FunctionContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 87
                        funDecl()
                    }
                }

                5 -> {
                    _localctx = GlobalContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 88
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
            state = 99
            _errHandler.sync(this)
            when (_input.LA(1)) {
                FUN -> {
                    _localctx = MemberFuncContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 91
                        funDecl()
                    }
                }

                CONST -> {
                    _localctx = MemberConstContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 92
                        globalDecl()
                    }
                }

                VAR -> {
                    _localctx = MemberFieldContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 93
                        match(VAR)
                        state = 94
                        _localctx.name = match(ID)
                        state = 95
                        match(EQ)
                        state = 96
                        _localctx.value = expr(0)
                        state = 97
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

        fun stmt(): List<StmtContext> {
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
                state = 101
                match(FUN)
                state = 102
                _localctx.name = match(ID)
                state = 103
                match(PO)
                state = 105
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == ID) {
                    run {
                        state = 104
                        _localctx.args = idList()
                    }
                }
                state = 107
                match(PC)
                state = 108
                match(BO)
                state = 112
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la and 0x3f.inv() == 0 && 1L shl _la and 1055170458812528L != 0L) {
                    run {
                        run {
                            state = 109
                            _localctx.stmt = stmt()
                            _localctx.body.add(_localctx.stmt)
                        }
                    }
                    state = 114
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 115
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
                state = 117
                match(CONST)
                state = 118
                _localctx.name = match(ID)
                state = 119
                match(EQ)
                state = 120
                _localctx.value = expr(0)
                state = 121
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
        fun tag(): List<TagContext> {
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
                state = 124
                _errHandler.sync(this)
                _la = _input.LA(1)
                do {
                    run {
                        run {
                            state = 123
                            _localctx.tag = tag()
                            _localctx.tags.add(_localctx.tag)
                        }
                    }
                    state = 126
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
            state = 135
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 13, _ctx)) {
                1 -> {
                    _localctx = SimpleTagContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 128
                        (_localctx as SimpleTagContext).name = match(TAGNAME)
                    }
                }

                2 -> {
                    _localctx = ParamTagContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 129
                        _localctx.name = match(TAGNAME)
                        state = 130
                        match(PO)
                        state = 132
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la and 0x3f.inv() == 0 && 1L shl _la and 1025294666301552L != 0L) {
                            run {
                                state = 131
                                _localctx.args = exprList()
                            }
                        }
                        state = 134
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
        fun expr(): List<ExprContext> {
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
                state = 137
                _localctx.expr = expr(0)
                _localctx.exprs.add(_localctx.expr)
                state = 142
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == COMMA) {
                    run {
                        run {
                            state = 138
                            match(COMMA)
                            state = 139
                            _localctx.expr = expr(0)
                            _localctx.exprs.add(_localctx.expr)
                        }
                    }
                    state = 144
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

        fun stmt(): List<StmtContext> {
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

        fun stmt(): List<StmtContext> {
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

        fun stmt(): List<StmtContext> {
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

        fun stmt(): List<StmtContext> {
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
            state = 235
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 21, _ctx)) {
                1 -> {
                    _localctx = ExprStmtContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 145
                        expr(0)
                        state = 146
                        match(SEMI)
                    }
                }

                2 -> {
                    _localctx = VarDeclContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 148
                        match(VAR)
                        state = 149
                        (_localctx as VarDeclContext).name = match(ID)
                        state = 150
                        match(EQ)
                        state = 151
                        (_localctx as VarDeclContext).value = expr(0)
                        state = 152
                        match(SEMI)
                    }
                }

                3 -> {
                    _localctx = ConstDeclContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 154
                        match(CONST)
                        state = 155
                        (_localctx as ConstDeclContext).name = match(ID)
                        state = 156
                        match(EQ)
                        state = 157
                        (_localctx as ConstDeclContext).value = expr(0)
                        state = 158
                        match(SEMI)
                    }
                }

                4 -> {
                    _localctx = AssignStmtContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 160
                        (_localctx as AssignStmtContext).name = match(ID)
                        state = 161
                        match(EQ)
                        state = 162
                        (_localctx as AssignStmtContext).value = expr(0)
                        state = 163
                        match(SEMI)
                    }
                }

                5 -> {
                    _localctx = IfStmtContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 165
                        match(IF)
                        state = 166
                        match(PO)
                        state = 167
                        (_localctx as IfStmtContext).cond = expr(0)
                        state = 168
                        match(PC)
                        state = 169
                        match(BO)
                        state = 173
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 1055170458812528L != 0L) {
                            run {
                                run {
                                    state = 170
                                    (_localctx as IfStmtContext).stmt = stmt()
                                    (_localctx as IfStmtContext).body.add((_localctx as IfStmtContext).stmt)
                                }
                            }
                            state = 175
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 176
                        match(BC)
                    }
                }

                6 -> {
                    _localctx = IfElseStmtContext(_localctx)
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 178
                        match(IF)
                        state = 179
                        match(PO)
                        state = 180
                        (_localctx as IfElseStmtContext).cond = expr(0)
                        state = 181
                        match(PC)
                        state = 182
                        match(BO)
                        state = 186
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 1055170458812528L != 0L) {
                            run {
                                run {
                                    state = 183
                                    (_localctx as IfElseStmtContext).stmt = stmt()
                                    (_localctx as IfElseStmtContext).bTrue.add((_localctx as IfElseStmtContext).stmt)
                                }
                            }
                            state = 188
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 189
                        match(BC)
                        state = 190
                        match(ELSE)
                        state = 191
                        match(BO)
                        state = 195
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 1055170458812528L != 0L) {
                            run {
                                run {
                                    state = 192
                                    (_localctx as IfElseStmtContext).stmt = stmt()
                                    (_localctx as IfElseStmtContext).bFalse.add((_localctx as IfElseStmtContext).stmt)
                                }
                            }
                            state = 197
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 198
                        match(BC)
                    }
                }

                7 -> {
                    _localctx = WhileStmtContext(_localctx)
                    enterOuterAlt(_localctx, 7)
                    run {
                        state = 200
                        match(WHILE)
                        state = 201
                        match(PO)
                        state = 202
                        (_localctx as WhileStmtContext).cond = expr(0)
                        state = 203
                        match(PC)
                        state = 204
                        match(BO)
                        state = 208
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 1055170458812528L != 0L) {
                            run {
                                run {
                                    state = 205
                                    (_localctx as WhileStmtContext).stmt = stmt()
                                    (_localctx as WhileStmtContext).body.add((_localctx as WhileStmtContext).stmt)
                                }
                            }
                            state = 210
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 211
                        match(BC)
                    }
                }

                8 -> {
                    _localctx = ForStmtContext(_localctx)
                    enterOuterAlt(_localctx, 8)
                    run {
                        state = 213
                        match(FOR)
                        state = 214
                        match(PO)
                        state = 215
                        (_localctx as ForStmtContext).v = match(ID)
                        state = 216
                        match(COLON)
                        state = 217
                        (_localctx as ForStmtContext).set = expr(0)
                        state = 218
                        match(PC)
                        state = 219
                        match(BO)
                        state = 223
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 1055170458812528L != 0L) {
                            run {
                                run {
                                    state = 220
                                    (_localctx as ForStmtContext).stmt = stmt()
                                    (_localctx as ForStmtContext).body.add((_localctx as ForStmtContext).stmt)
                                }
                            }
                            state = 225
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 226
                        match(BC)
                    }
                }

                9 -> {
                    _localctx = BreakStmtContext(_localctx)
                    enterOuterAlt(_localctx, 9)
                    run {
                        state = 228
                        match(BREAK)
                        state = 229
                        match(SEMI)
                    }
                }

                10 -> {
                    _localctx = ReturnStmtContext(_localctx)
                    enterOuterAlt(_localctx, 10)
                    run {
                        state = 230
                        match(RETURN)
                        state = 232
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la and 0x3f.inv() == 0 && 1L shl _la and 1025294666301552L != 0L) {
                            run {
                                state = 231
                                _localctx.e = expr(0)
                            }
                        }
                        state = 234
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
        fun expr(): List<ExprContext> {
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

        fun expr(): List<ExprContext> {
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

        fun expr(): List<ExprContext> {
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
        fun expr(): List<ExprContext> {
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
        fun expr(): List<ExprContext> {
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
        fun expr(): List<ExprContext> {
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
        fun expr(): List<ExprContext> {
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
        fun expr(): List<ExprContext> {
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
                state = 257
                _errHandler.sync(this)
                when (interpreter.adaptivePredict(_input, 24, _ctx)) {
                    1 -> {
                        _localctx = LiteralExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 238
                        literal()
                    }

                    2 -> {
                        _localctx = NameExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 239
                        match(ID)
                    }

                    3 -> {
                        _localctx = ListExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 240
                        match(BRO)
                        state = 242
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la and 0x3f.inv() == 0 && 1L shl _la and 1025294666301552L != 0L) {
                            run {
                                state = 241
                                (_localctx as ListExprContext).exprs = exprList()
                            }
                        }
                        state = 244
                        match(BRC)
                    }

                    4 -> {
                        _localctx = CallExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 245
                        match(ID)
                        state = 246
                        match(PO)
                        state = 248
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la and 0x3f.inv() == 0 && 1L shl _la and 1025294666301552L != 0L) {
                            run {
                                state = 247
                                (_localctx as CallExprContext).args = exprList()
                            }
                        }
                        state = 250
                        match(PC)
                    }

                    5 -> {
                        _localctx = ParenExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 251
                        match(PO)
                        state = 252
                        (_localctx as ParenExprContext).e = expr(0)
                        state = 253
                        match(PC)
                    }

                    6 -> {
                        _localctx = UnaryExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 255
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
                        state = 256
                        (_localctx as UnaryExprContext).right = expr(8)
                    }
                }
                _ctx.stop = _input.LT(-1)
                state = 306
                _errHandler.sync(this)
                _alt = interpreter.adaptivePredict(_input, 28, _ctx)
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent()
                        _prevctx = _localctx
                        run {
                            state = 304
                            _errHandler.sync(this)
                            when (interpreter.adaptivePredict(_input, 27, _ctx)) {
                                1 -> {
                                    _localctx =
                                        MulExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as MulExprContext).left = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 259
                                    if (!precpred(_ctx, 7)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 7)"
                                    )
                                    state = 260
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
                                    state = 261
                                    (_localctx as MulExprContext).right = expr(8)
                                }

                                2 -> {
                                    _localctx =
                                        AddExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as AddExprContext).left = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 262
                                    if (!precpred(_ctx, 6)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 6)"
                                    )
                                    state = 263
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
                                    state = 264
                                    (_localctx as AddExprContext).right = expr(7)
                                }

                                3 -> {
                                    _localctx =
                                        CmpExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as CmpExprContext).left = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 265
                                    if (!precpred(_ctx, 5)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 5)"
                                    )
                                    state = 266
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
                                    state = 267
                                    (_localctx as CmpExprContext).right = expr(6)
                                }

                                4 -> {
                                    _localctx =
                                        BoolExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as BoolExprContext).left = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 268
                                    if (!precpred(_ctx, 4)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 4)"
                                    )
                                    state = 269
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
                                    state = 270
                                    (_localctx as BoolExprContext).right = expr(5)
                                }

                                5 -> {
                                    _localctx =
                                        TernaryExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as TernaryExprContext).cond = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 271
                                    if (!precpred(_ctx, 3)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 3)"
                                    )
                                    state = 272
                                    match(QMARK)
                                    state = 273
                                    (_localctx as TernaryExprContext).bTrue = expr(0)
                                    state = 274
                                    match(COLON)
                                    state = 275
                                    (_localctx as TernaryExprContext).bFalse = expr(4)
                                }

                                6 -> {
                                    _localctx =
                                        IndexExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as IndexExprContext).base = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 277
                                    if (!precpred(_ctx, 11)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 11)"
                                    )
                                    state = 278
                                    match(BRO)
                                    state = 279
                                    (_localctx as IndexExprContext).index = expr(0)
                                    state = 280
                                    match(BRC)
                                }

                                7 -> {
                                    _localctx =
                                        MemberExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as MemberExprContext).base = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 282
                                    if (!precpred(_ctx, 10)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 10)"
                                    )
                                    state = 283
                                    match(DOT)
                                    state = 284
                                    (_localctx as MemberExprContext).name = match(ID)
                                }

                                8 -> {
                                    _localctx =
                                        MemberCallExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as MemberCallExprContext).base = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 285
                                    if (!precpred(_ctx, 9)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 9)"
                                    )
                                    state = 286
                                    match(DOT)
                                    state = 287
                                    (_localctx as MemberCallExprContext).name = match(ID)
                                    state = 288
                                    match(PO)
                                    state = 290
                                    _errHandler.sync(this)
                                    _la = _input.LA(1)
                                    if (_la and 0x3f.inv() == 0 && 1L shl _la and 1025294666301552L != 0L) {
                                        run {
                                            state = 289
                                            (_localctx as MemberCallExprContext).args = exprList()
                                        }
                                    }
                                    state = 292
                                    match(PC)
                                }

                                9 -> {
                                    _localctx =
                                        RangeExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as RangeExprContext).begin = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 293
                                    if (!precpred(_ctx, 2)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 2)"
                                    )
                                    state = 294
                                    match(T__17)
                                    state = 295
                                    (_localctx as RangeExprContext).end = expr(0)
                                    state = 297
                                    _errHandler.sync(this)
                                    when (interpreter.adaptivePredict(_input, 26, _ctx)) {
                                        1 -> {
                                            state = 296
                                            match(T__18)
                                        }

                                        else -> {}
                                    }
                                }

                                10 -> {
                                    _localctx = RangeInclusiveExprContext(
                                        ExprContext(
                                            _parentctx,
                                            _parentState
                                        )
                                    )
                                    (_localctx as RangeInclusiveExprContext).begin = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 299
                                    if (!precpred(_ctx, 1)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 1)"
                                    )
                                    state = 300
                                    match(T__17)
                                    state = 301
                                    (_localctx as RangeInclusiveExprContext).end = expr(0)
                                    state = 302
                                    match(T__19)
                                }

                                else -> {}
                            }
                        }
                    }
                    state = 308
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

    class CountDiceLiteralContext(ctx: LiteralContext?) : LiteralContext() {
        fun INT(): TerminalNode {
            return getToken(INT, 0)
        }

        fun DICE(): TerminalNode {
            return getToken(DICE, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitCountDiceLiteral(
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
        var content: Token? = null

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

    @Throws(RecognitionException::class)
    fun literal(): LiteralContext {
        var _localctx = LiteralContext(_ctx, state)
        enterRule(_localctx, 26, RULE_literal)
        var _la: Int
        try {
            state = 324
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 30, _ctx)) {
                1 -> {
                    _localctx = StringLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 309
                        match(T__20)
                        state = 313
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la and 0x3f.inv() == 0 && 1L shl _la and 4503599625273342L != 0L) {
                            run {
                                run {
                                    state = 310
                                    (_localctx as StringLiteralContext).content = _input.LT(1)
                                    _la = _input.LA(1)
                                    if (_la <= 0 || _la == T__20) {
                                        (_localctx as StringLiteralContext).content =
                                            _errHandler.recoverInline(this) as Token
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                }
                            }
                            state = 315
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 316
                        match(T__20)
                    }
                }

                2 -> {
                    _localctx = IntLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 317
                        match(INT)
                    }
                }

                3 -> {
                    _localctx = FloatLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 318
                        match(FLOAT)
                    }
                }

                4 -> {
                    _localctx = DiceLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 319
                        match(DICE)
                    }
                }

                5 -> {
                    _localctx = CountDiceLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 320
                        match(INT)
                        state = 321
                        match(DICE)
                    }
                }

                6 -> {
                    _localctx = TrueLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 322
                        match(TRUE)
                    }
                }

                7 -> {
                    _localctx = FalseLiteralContext(_localctx)
                    enterOuterAlt(_localctx, 7)
                    run {
                        state = 323
                        match(FALSE)
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
            5 -> return precpred(_ctx, 11)
            6 -> return precpred(_ctx, 10)
            7 -> return precpred(_ctx, 9)
            8 -> return precpred(_ctx, 2)
            9 -> return precpred(_ctx, 1)
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
        const val PO = 22
        const val PC = 23
        const val BO = 24
        const val BC = 25
        const val BRO = 26
        const val BRC = 27
        const val COMMA = 28
        const val SEMI = 29
        const val QMARK = 30
        const val EQ = 31
        const val DOT = 32
        const val COLON = 33
        const val IF = 34
        const val FOR = 35
        const val FUN = 36
        const val VAR = 37
        const val ELSE = 38
        const val TRUE = 39
        const val BREAK = 40
        const val CONST = 41
        const val FALSE = 42
        const val WHILE = 43
        const val RETURN = 44
        const val DICE = 45
        const val TAGNAME = 46
        const val ID = 47
        const val INT = 48
        const val FLOAT = 49
        const val COMMENT = 50
        const val WS = 51
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
                "'to'", "'exclusive'", "'inclusive'", "'\"'", "'('", "')'", "'{'", "'}'",
                "'['", "']'", "','", "';'", "'?'", "'='", "'.'", "':'", "'if'", "'for'",
                "'fun'", "'var'", "'else'", "'true'", "'break'", "'const'", "'false'",
                "'while'", "'return'"
            )
        }

        private val _LITERAL_NAMES = makeLiteralNames()
        private fun makeSymbolicNames(): Array<String?> {
            return arrayOf(
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, "PO", "PC",
                "BO", "BC", "BRO", "BRC", "COMMA", "SEMI", "QMARK", "EQ", "DOT", "COLON",
                "IF", "FOR", "FUN", "VAR", "ELSE", "TRUE", "BREAK", "CONST", "FALSE",
                "WHILE", "RETURN", "DICE", "TAGNAME", "ID", "INT", "FLOAT", "COMMENT",
                "WS"
            )
        }

        private val _SYMBOLIC_NAMES = makeSymbolicNames()
        val VOCABULARY: Vocabulary = VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES)

        @Deprecated("Use {@link #VOCABULARY} instead.")
        val tokenNames = _SYMBOLIC_NAMES.indices.map {
            VOCABULARY.getLiteralName(it) ?: VOCABULARY.getSymbolicName(it) ?: "<INVALID>"
        }.toTypedArray()

        const val _serializedATN =
            "\u0004\u00013\u0147\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
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
                    "\u0001\u0004\u0003\u0004V\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004" +
                    "Z\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005" +
                    "\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005d\b\u0005\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006j\b\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0005\u0006o\b\u0006\n\u0006\u000c\u0006r\t\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\b\u0004\b}\b\b\u000b\b\u000c\b~\u0001\t\u0001" +
                    "\t\u0001\t\u0001\t\u0003\t\u0085\b\t\u0001\t\u0003\t\u0088\b\t\u0001\n" +
                    "\u0001\n\u0001\n\u0005\n\u008d\b\n\n\n\u000c\n\u0090\t\n\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0005\u000b\u00ac\b\u000b\n\u000b\u000c\u000b\u00af\t\u000b\u0001\u000b" +
                    "\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b" +
                    "\u0001\u000b\u0005\u000b\u00b9\b\u000b\n\u000b\u000c\u000b\u00bc\t\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00c2\b\u000b\n" +
                    "\u000b\u000c\u000b\u00c5\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00cf" +
                    "\b\u000b\n\u000b\u000c\u000b\u00d2\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b" +
                    "\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b" +
                    "\u0001\u000b\u0005\u000b\u00de\b\u000b\n\u000b\u000c\u000b\u00e1\t\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003" +
                    "\u000b\u00e9\b\u000b\u0001\u000b\u0003\u000b\u00ec\b\u000b\u0001\u000c\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0003\u000c\u00f3\b\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0003\u000c\u00f9\b\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0003\u000c\u0102\b\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0003\u000c\u0123\b\u000c\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0003\u000c\u012a\b\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0005\u000c\u0131\b\u000c\n\u000c\u000c\u000c\u0134\t\u000c\u0001\r\u0001\r" +
                    "\u0005\r\u0138\b\r\n\r\u000c\r\u013b\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001" +
                    "\r\u0001\r\u0001\r\u0001\r\u0003\r\u0145\b\r\u0001\r\u0000\u0001\u0018" +
                    "\u000e\u0000\u0002\u0004\u0006\b\n\u000c\u000e\u0010\u0012\u0014\u0016\u0018" +
                    "\u001a\u0000\u0006\u0001\u0000\u0004\u0006\u0001\u0000\u0007\t\u0001\u0000" +
                    "\u0004\u0005\u0001\u0000\n\u000f\u0001\u0000\u0010\u0011\u0001\u0000\u0015" +
                    "\u0015\u0174\u0000\u001c\u0001\u0000\u0000\u0000\u0002%\u0001\u0000\u0000" +
                    "\u0000\u0004.\u0001\u0000\u0000\u0000\u00065\u0001\u0000\u0000\u0000\b" +
                    "Y\u0001\u0000\u0000\u0000\nc\u0001\u0000\u0000\u0000\u000ce\u0001\u0000\u0000" +
                    "\u0000\u000eu\u0001\u0000\u0000\u0000\u0010|\u0001\u0000\u0000\u0000\u0012" +
                    "\u0087\u0001\u0000\u0000\u0000\u0014\u0089\u0001\u0000\u0000\u0000\u0016" +
                    "\u00eb\u0001\u0000\u0000\u0000\u0018\u0101\u0001\u0000\u0000\u0000\u001a" +
                    "\u0144\u0001\u0000\u0000\u0000\u001c \u0003\u0002\u0001\u0000\u001d\u001f" +
                    "\u0003\b\u0004\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f\"\u0001" +
                    "\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000" +
                    "\u0000!#\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000#$\u0005\u0000" +
                    "\u0000\u0001$\u0001\u0001\u0000\u0000\u0000%&\u0005\u0001\u0000\u0000" +
                    "&\'\u0005/\u0000\u0000\'+\u0005\u001d\u0000\u0000(*\u0003\u0004\u0002" +
                    "\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001\u0000" +
                    "\u0000\u0000+,\u0001\u0000\u0000\u0000,\u0003\u0001\u0000\u0000\u0000" +
                    "-+\u0001\u0000\u0000\u0000./\u0005\u0002\u0000\u0000/0\u0005/\u0000\u0000" +
                    "01\u0005\u0016\u0000\u000012\u0003\u0006\u0003\u000023\u0005\u0017\u0000" +
                    "\u000034\u0005\u001d\u0000\u00004\u0005\u0001\u0000\u0000\u00005:\u0005" +
                    "/\u0000\u000067\u0005\u001c\u0000\u000079\u0005/\u0000\u000086\u0001\u0000" +
                    "\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001" +
                    "\u0000\u0000\u0000;\u0007\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000" +
                    "\u0000=>\u0005/\u0000\u0000>@\u0005/\u0000\u0000?A\u0003\u0010\b\u0000" +
                    "@?\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AZ\u0001\u0000\u0000" +
                    "\u0000BC\u0005/\u0000\u0000CE\u0005/\u0000\u0000DF\u0003\u0010\b\u0000" +
                    "ED\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000" +
                    "\u0000GK\u0005\u0018\u0000\u0000HJ\u0003\n\u0005\u0000IH\u0001\u0000\u0000" +
                    "\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000" +
                    "\u0000\u0000LN\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NZ\u0005" +
                    "\u0019\u0000\u0000OP\u0005/\u0000\u0000PQ\u0005\u0016\u0000\u0000QR\u0003" +
                    "\u0006\u0003\u0000RS\u0005\u0017\u0000\u0000SU\u0005\u0003\u0000\u0000" +
                    "TV\u0003\u0010\b\u0000UT\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000" +
                    "VZ\u0001\u0000\u0000\u0000WZ\u0003\u000c\u0006\u0000XZ\u0003\u000e\u0007\u0000" +
                    "Y=\u0001\u0000\u0000\u0000YB\u0001\u0000\u0000\u0000YO\u0001\u0000\u0000" +
                    "\u0000YW\u0001\u0000\u0000\u0000YX\u0001\u0000\u0000\u0000Z\t\u0001\u0000" +
                    "\u0000\u0000[d\u0003\u000c\u0006\u0000\\d\u0003\u000e\u0007\u0000]^\u0005" +
                    "%\u0000\u0000^_\u0005/\u0000\u0000_`\u0005\u001f\u0000\u0000`a\u0003\u0018" +
                    "\u000c\u0000ab\u0005\u001d\u0000\u0000bd\u0001\u0000\u0000\u0000c[\u0001\u0000" +
                    "\u0000\u0000c\\\u0001\u0000\u0000\u0000c]\u0001\u0000\u0000\u0000d\u000b" +
                    "\u0001\u0000\u0000\u0000ef\u0005$\u0000\u0000fg\u0005/\u0000\u0000gi\u0005" +
                    "\u0016\u0000\u0000hj\u0003\u0006\u0003\u0000ih\u0001\u0000\u0000\u0000" +
                    "ij\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0005\u0017\u0000" +
                    "\u0000lp\u0005\u0018\u0000\u0000mo\u0003\u0016\u000b\u0000nm\u0001\u0000" +
                    "\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001" +
                    "\u0000\u0000\u0000qs\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000" +
                    "st\u0005\u0019\u0000\u0000t\r\u0001\u0000\u0000\u0000uv\u0005)\u0000\u0000" +
                    "vw\u0005/\u0000\u0000wx\u0005\u001f\u0000\u0000xy\u0003\u0018\u000c\u0000" +
                    "yz\u0005\u001d\u0000\u0000z\u000f\u0001\u0000\u0000\u0000{}\u0003\u0012" +
                    "\t\u0000|{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001\u0000" +
                    "\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0011\u0001\u0000\u0000" +
                    "\u0000\u0080\u0088\u0005.\u0000\u0000\u0081\u0082\u0005.\u0000\u0000\u0082" +
                    "\u0084\u0005\u0016\u0000\u0000\u0083\u0085\u0003\u0014\n\u0000\u0084\u0083" +
                    "\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086" +
                    "\u0001\u0000\u0000\u0000\u0086\u0088\u0005\u0017\u0000\u0000\u0087\u0080" +
                    "\u0001\u0000\u0000\u0000\u0087\u0081\u0001\u0000\u0000\u0000\u0088\u0013" +
                    "\u0001\u0000\u0000\u0000\u0089\u008e\u0003\u0018\u000c\u0000\u008a\u008b\u0005" +
                    "\u001c\u0000\u0000\u008b\u008d\u0003\u0018\u000c\u0000\u008c\u008a\u0001\u0000" +
                    "\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000" +
                    "\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0015\u0001\u0000" +
                    "\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0092\u0003\u0018" +
                    "\u000c\u0000\u0092\u0093\u0005\u001d\u0000\u0000\u0093\u00ec\u0001\u0000\u0000" +
                    "\u0000\u0094\u0095\u0005%\u0000\u0000\u0095\u0096\u0005/\u0000\u0000\u0096" +
                    "\u0097\u0005\u001f\u0000\u0000\u0097\u0098\u0003\u0018\u000c\u0000\u0098\u0099" +
                    "\u0005\u001d\u0000\u0000\u0099\u00ec\u0001\u0000\u0000\u0000\u009a\u009b" +
                    "\u0005)\u0000\u0000\u009b\u009c\u0005/\u0000\u0000\u009c\u009d\u0005\u001f" +
                    "\u0000\u0000\u009d\u009e\u0003\u0018\u000c\u0000\u009e\u009f\u0005\u001d\u0000" +
                    "\u0000\u009f\u00ec\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005/\u0000\u0000" +
                    "\u00a1\u00a2\u0005\u001f\u0000\u0000\u00a2\u00a3\u0003\u0018\u000c\u0000\u00a3" +
                    "\u00a4\u0005\u001d\u0000\u0000\u00a4\u00ec\u0001\u0000\u0000\u0000\u00a5" +
                    "\u00a6\u0005\"\u0000\u0000\u00a6\u00a7\u0005\u0016\u0000\u0000\u00a7\u00a8" +
                    "\u0003\u0018\u000c\u0000\u00a8\u00a9\u0005\u0017\u0000\u0000\u00a9\u00ad\u0005" +
                    "\u0018\u0000\u0000\u00aa\u00ac\u0003\u0016\u000b\u0000\u00ab\u00aa\u0001" +
                    "\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001" +
                    "\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00b0\u0001" +
                    "\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005" +
                    "\u0019\u0000\u0000\u00b1\u00ec\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005" +
                    "\"\u0000\u0000\u00b3\u00b4\u0005\u0016\u0000\u0000\u00b4\u00b5\u0003\u0018" +
                    "\u000c\u0000\u00b5\u00b6\u0005\u0017\u0000\u0000\u00b6\u00ba\u0005\u0018\u0000" +
                    "\u0000\u00b7\u00b9\u0003\u0016\u000b\u0000\u00b8\u00b7\u0001\u0000\u0000" +
                    "\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000" +
                    "\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bd\u0001\u0000\u0000" +
                    "\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00be\u0005\u0019\u0000" +
                    "\u0000\u00be\u00bf\u0005&\u0000\u0000\u00bf\u00c3\u0005\u0018\u0000\u0000" +
                    "\u00c0\u00c2\u0003\u0016\u000b\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000" +
                    "\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000" +
                    "\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c6\u0001\u0000\u0000\u0000" +
                    "\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\u0019\u0000\u0000" +
                    "\u00c7\u00ec\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005+\u0000\u0000\u00c9" +
                    "\u00ca\u0005\u0016\u0000\u0000\u00ca\u00cb\u0003\u0018\u000c\u0000\u00cb\u00cc" +
                    "\u0005\u0017\u0000\u0000\u00cc\u00d0\u0005\u0018\u0000\u0000\u00cd\u00cf" +
                    "\u0003\u0016\u000b\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d2" +
                    "\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1" +
                    "\u0001\u0000\u0000\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2\u00d0" +
                    "\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u0019\u0000\u0000\u00d4\u00ec" +
                    "\u0001\u0000\u0000\u0000\u00d5\u00d6\u0005#\u0000\u0000\u00d6\u00d7\u0005" +
                    "\u0016\u0000\u0000\u00d7\u00d8\u0005/\u0000\u0000\u00d8\u00d9\u0005!\u0000" +
                    "\u0000\u00d9\u00da\u0003\u0018\u000c\u0000\u00da\u00db\u0005\u0017\u0000\u0000" +
                    "\u00db\u00df\u0005\u0018\u0000\u0000\u00dc\u00de\u0003\u0016\u000b\u0000" +
                    "\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de\u00e1\u0001\u0000\u0000\u0000" +
                    "\u00df\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000" +
                    "\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000" +
                    "\u00e2\u00e3\u0005\u0019\u0000\u0000\u00e3\u00ec\u0001\u0000\u0000\u0000" +
                    "\u00e4\u00e5\u0005(\u0000\u0000\u00e5\u00ec\u0005\u001d\u0000\u0000\u00e6" +
                    "\u00e8\u0005,\u0000\u0000\u00e7\u00e9\u0003\u0018\u000c\u0000\u00e8\u00e7" +
                    "\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00ea" +
                    "\u0001\u0000\u0000\u0000\u00ea\u00ec\u0005\u001d\u0000\u0000\u00eb\u0091" +
                    "\u0001\u0000\u0000\u0000\u00eb\u0094\u0001\u0000\u0000\u0000\u00eb\u009a" +
                    "\u0001\u0000\u0000\u0000\u00eb\u00a0\u0001\u0000\u0000\u0000\u00eb\u00a5" +
                    "\u0001\u0000\u0000\u0000\u00eb\u00b2\u0001\u0000\u0000\u0000\u00eb\u00c8" +
                    "\u0001\u0000\u0000\u0000\u00eb\u00d5\u0001\u0000\u0000\u0000\u00eb\u00e4" +
                    "\u0001\u0000\u0000\u0000\u00eb\u00e6\u0001\u0000\u0000\u0000\u00ec\u0017" +
                    "\u0001\u0000\u0000\u0000\u00ed\u00ee\u0006\u000c\uffff\uffff\u0000\u00ee\u0102" +
                    "\u0003\u001a\r\u0000\u00ef\u0102\u0005/\u0000\u0000\u00f0\u00f2\u0005" +
                    "\u001a\u0000\u0000\u00f1\u00f3\u0003\u0014\n\u0000\u00f2\u00f1\u0001\u0000" +
                    "\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000" +
                    "\u0000\u0000\u00f4\u0102\u0005\u001b\u0000\u0000\u00f5\u00f6\u0005/\u0000" +
                    "\u0000\u00f6\u00f8\u0005\u0016\u0000\u0000\u00f7\u00f9\u0003\u0014\n\u0000" +
                    "\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000" +
                    "\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u0102\u0005\u0017\u0000\u0000" +
                    "\u00fb\u00fc\u0005\u0016\u0000\u0000\u00fc\u00fd\u0003\u0018\u000c\u0000\u00fd" +
                    "\u00fe\u0005\u0017\u0000\u0000\u00fe\u0102\u0001\u0000\u0000\u0000\u00ff" +
                    "\u0100\u0007\u0000\u0000\u0000\u0100\u0102\u0003\u0018\u000c\b\u0101\u00ed" +
                    "\u0001\u0000\u0000\u0000\u0101\u00ef\u0001\u0000\u0000\u0000\u0101\u00f0" +
                    "\u0001\u0000\u0000\u0000\u0101\u00f5\u0001\u0000\u0000\u0000\u0101\u00fb" +
                    "\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0102\u0132" +
                    "\u0001\u0000\u0000\u0000\u0103\u0104\n\u0007\u0000\u0000\u0104\u0105\u0007" +
                    "\u0001\u0000\u0000\u0105\u0131\u0003\u0018\u000c\b\u0106\u0107\n\u0006\u0000" +
                    "\u0000\u0107\u0108\u0007\u0002\u0000\u0000\u0108\u0131\u0003\u0018\u000c\u0007" +
                    "\u0109\u010a\n\u0005\u0000\u0000\u010a\u010b\u0007\u0003\u0000\u0000\u010b" +
                    "\u0131\u0003\u0018\u000c\u0006\u010c\u010d\n\u0004\u0000\u0000\u010d\u010e" +
                    "\u0007\u0004\u0000\u0000\u010e\u0131\u0003\u0018\u000c\u0005\u010f\u0110\n" +
                    "\u0003\u0000\u0000\u0110\u0111\u0005\u001e\u0000\u0000\u0111\u0112\u0003" +
                    "\u0018\u000c\u0000\u0112\u0113\u0005!\u0000\u0000\u0113\u0114\u0003\u0018" +
                    "\u000c\u0004\u0114\u0131\u0001\u0000\u0000\u0000\u0115\u0116\n\u000b\u0000" +
                    "\u0000\u0116\u0117\u0005\u001a\u0000\u0000\u0117\u0118\u0003\u0018\u000c\u0000" +
                    "\u0118\u0119\u0005\u001b\u0000\u0000\u0119\u0131\u0001\u0000\u0000\u0000" +
                    "\u011a\u011b\n\n\u0000\u0000\u011b\u011c\u0005 \u0000\u0000\u011c\u0131" +
                    "\u0005/\u0000\u0000\u011d\u011e\n\t\u0000\u0000\u011e\u011f\u0005 \u0000" +
                    "\u0000\u011f\u0120\u0005/\u0000\u0000\u0120\u0122\u0005\u0016\u0000\u0000" +
                    "\u0121\u0123\u0003\u0014\n\u0000\u0122\u0121\u0001\u0000\u0000\u0000\u0122" +
                    "\u0123\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124" +
                    "\u0131\u0005\u0017\u0000\u0000\u0125\u0126\n\u0002\u0000\u0000\u0126\u0127" +
                    "\u0005\u0012\u0000\u0000\u0127\u0129\u0003\u0018\u000c\u0000\u0128\u012a\u0005" +
                    "\u0013\u0000\u0000\u0129\u0128\u0001\u0000\u0000\u0000\u0129\u012a\u0001" +
                    "\u0000\u0000\u0000\u012a\u0131\u0001\u0000\u0000\u0000\u012b\u012c\n\u0001" +
                    "\u0000\u0000\u012c\u012d\u0005\u0012\u0000\u0000\u012d\u012e\u0003\u0018" +
                    "\u000c\u0000\u012e\u012f\u0005\u0014\u0000\u0000\u012f\u0131\u0001\u0000\u0000" +
                    "\u0000\u0130\u0103\u0001\u0000\u0000\u0000\u0130\u0106\u0001\u0000\u0000" +
                    "\u0000\u0130\u0109\u0001\u0000\u0000\u0000\u0130\u010c\u0001\u0000\u0000" +
                    "\u0000\u0130\u010f\u0001\u0000\u0000\u0000\u0130\u0115\u0001\u0000\u0000" +
                    "\u0000\u0130\u011a\u0001\u0000\u0000\u0000\u0130\u011d\u0001\u0000\u0000" +
                    "\u0000\u0130\u0125\u0001\u0000\u0000\u0000\u0130\u012b\u0001\u0000\u0000" +
                    "\u0000\u0131\u0134\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000" +
                    "\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133\u0019\u0001\u0000\u0000" +
                    "\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0135\u0139\u0005\u0015\u0000" +
                    "\u0000\u0136\u0138\b\u0005\u0000\u0000\u0137\u0136\u0001\u0000\u0000\u0000" +
                    "\u0138\u013b\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000" +
                    "\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013c\u0001\u0000\u0000\u0000" +
                    "\u013b\u0139\u0001\u0000\u0000\u0000\u013c\u0145\u0005\u0015\u0000\u0000" +
                    "\u013d\u0145\u00050\u0000\u0000\u013e\u0145\u00051\u0000\u0000\u013f\u0145" +
                    "\u0005-\u0000\u0000\u0140\u0141\u00050\u0000\u0000\u0141\u0145\u0005-" +
                    "\u0000\u0000\u0142\u0145\u0005\'\u0000\u0000\u0143\u0145\u0005*\u0000" +
                    "\u0000\u0144\u0135\u0001\u0000\u0000\u0000\u0144\u013d\u0001\u0000\u0000" +
                    "\u0000\u0144\u013e\u0001\u0000\u0000\u0000\u0144\u013f\u0001\u0000\u0000" +
                    "\u0000\u0144\u0140\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000\u0000" +
                    "\u0000\u0144\u0143\u0001\u0000\u0000\u0000\u0145\u001b\u0001\u0000\u0000" +
                    "\u0000\u001f +:@EKUYcip~\u0084\u0087\u008e\u00ad\u00ba\u00c3\u00d0\u00df" +
                    "\u00e8\u00eb\u00f2\u00f8\u0101\u0122\u0129\u0130\u0132\u0139\u0144"
        val _ATN = ATNDeserializer().deserialize(_serializedATN.toCharArray())

        init {
            _decisionToDFA = (0 until _ATN.numberOfDecisions).map {
                DFA(_ATN.getDecisionState(it), it)
            }.toTypedArray()
        }
    }
}