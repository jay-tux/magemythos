// Generated from /home/data/kotlin/MageMythos/composeApp/src/parser/MM.g4 by ANTLR 4.13.1
package parser.mm

import org.antlr.v4.runtime.NoViableAltException
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.RecognitionException
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

    class StringsContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun EOF(): TerminalNode {
            return getToken(EOF, 0)
        }

        fun singleString(): List<SingleStringContext> {
            return getRuleContexts(SingleStringContext::class.java)
        }

        fun singleString(i: Int): SingleStringContext {
            return getRuleContext(SingleStringContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_strings
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitStrings(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun strings(): StringsContext {
        val _localctx = StringsContext(_ctx, state)
        enterRule(_localctx, 0, RULE_strings)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 37
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == IDENTIFIER) {
                    run {
                        run {
                            state = 34
                            singleString()
                        }
                    }
                    state = 39
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 40
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

    class SingleStringContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var key: Token? = null
        var value: Token? = null
        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        fun STRING_LIT(): TerminalNode {
            return getToken(STRING_LIT, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_singleString
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSingleString(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun singleString(): SingleStringContext {
        val _localctx = SingleStringContext(_ctx, state)
        enterRule(_localctx, 2, RULE_singleString)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 42
                _localctx.key = match(IDENTIFIER)
                state = 43
                match(T__0)
                state = 44
                _localctx.value = match(STRING_LIT)
                state = 45
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

    class MageProgContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun header(): HeaderContext {
            return getRuleContext(HeaderContext::class.java, 0)
        }

        fun EOF(): TerminalNode {
            return getToken(EOF, 0)
        }

        fun enables(): List<EnablesContext> {
            return getRuleContexts(EnablesContext::class.java)
        }

        fun enables(i: Int): EnablesContext {
            return getRuleContext(EnablesContext::class.java, i)
        }

        fun topLevel(): List<TopLevelContext> {
            return getRuleContexts(TopLevelContext::class.java)
        }

        fun topLevel(i: Int): TopLevelContext {
            return getRuleContext(TopLevelContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_mageProg
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMageProg(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun mageProg(): MageProgContext {
        val _localctx = MageProgContext(_ctx, state)
        enterRule(_localctx, 4, RULE_mageProg)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 47
                header()
                state = 51
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == ENABLE) {
                    run {
                        run {
                            state = 48
                            enables()
                        }
                    }
                    state = 53
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 57
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la and 0x3f.inv() == 0 && 1L shl _la and 15331328L != 0L) {
                    run {
                        run {
                            state = 54
                            topLevel()
                        }
                    }
                    state = 59
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 60
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

    open class HeaderContext : ParserRuleContext {
        constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState)

        override fun getRuleIndex(): Int {
            return RULE_header
        }

        constructor()

        fun copyFrom(ctx: HeaderContext?) {
            super.copyFrom(ctx)
        }
    }

    class SourceHeaderStringsContext(ctx: HeaderContext?) : HeaderContext() {
        var src: Token? = null
        fun SOURCE(): TerminalNode {
            return getToken(SOURCE, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun setStrings(): SetStringsContext {
            return getRuleContext(SetStringsContext::class.java, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSourceHeaderStrings(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class SourceHeaderDepsStringsContext(ctx: HeaderContext?) : HeaderContext() {
        var src: Token? = null
        var deps: Token? = null
        fun SOURCE(): TerminalNode {
            return getToken(SOURCE, 0)
        }

        fun DEPENDS_ON(): TerminalNode {
            return getToken(DEPENDS_ON, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun setStrings(): SetStringsContext {
            return getRuleContext(SetStringsContext::class.java, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        fun STRING_LIT(): List<TerminalNode> {
            return getTokens(STRING_LIT)
        }

        fun STRING_LIT(i: Int): TerminalNode {
            return getToken(STRING_LIT, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSourceHeaderDepsStrings(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class SourceHeaderDepsContext(ctx: HeaderContext?) : HeaderContext() {
        var src: Token? = null
        var deps: Token? = null
        fun SOURCE(): TerminalNode {
            return getToken(SOURCE, 0)
        }

        fun DEPENDS_ON(): TerminalNode {
            return getToken(DEPENDS_ON, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        fun STRING_LIT(): List<TerminalNode> {
            return getTokens(STRING_LIT)
        }

        fun STRING_LIT(i: Int): TerminalNode {
            return getToken(STRING_LIT, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSourceHeaderDeps(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class SourceHeaderContext(ctx: HeaderContext?) : HeaderContext() {
        var src: Token? = null
        fun SOURCE(): TerminalNode {
            return getToken(SOURCE, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSourceHeader(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun header(): HeaderContext {
        var _localctx = HeaderContext(_ctx, state)
        enterRule(_localctx, 6, RULE_header)
        var _la: Int
        try {
            state = 90
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 5, _ctx)) {
                1 -> {
                    _localctx = SourceHeaderContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 62
                        match(SOURCE)
                        state = 63
                        (_localctx as SourceHeaderContext).src = match(IDENTIFIER)
                        state = 64
                        match(SEMI)
                    }
                }

                2 -> {
                    _localctx = SourceHeaderDepsContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 65
                        match(SOURCE)
                        state = 66
                        (_localctx as SourceHeaderDepsContext).src = match(IDENTIFIER)
                        state = 67
                        match(DEPENDS_ON)
                        state = 71
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la == STRING_LIT) {
                            run {
                                run {
                                    state = 68
                                    (_localctx as SourceHeaderDepsContext).deps = match(STRING_LIT)
                                }
                            }
                            state = 73
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 74
                        match(SEMI)
                    }
                }

                3 -> {
                    _localctx = SourceHeaderStringsContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 75
                        match(SOURCE)
                        state = 76
                        (_localctx as SourceHeaderStringsContext).src = match(IDENTIFIER)
                        state = 77
                        match(SEMI)
                        state = 78
                        setStrings()
                    }
                }

                4 -> {
                    _localctx = SourceHeaderDepsStringsContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 79
                        match(SOURCE)
                        state = 80
                        _localctx.src = match(IDENTIFIER)
                        state = 81
                        match(DEPENDS_ON)
                        state = 85
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la == STRING_LIT) {
                            run {
                                run {
                                    state = 82
                                    _localctx.deps = match(STRING_LIT)
                                }
                            }
                            state = 87
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 88
                        match(SEMI)
                        state = 89
                        setStrings()
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

    class SetStringsContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var file: Token? = null
        fun STRINGS(): TerminalNode {
            return getToken(STRINGS, 0)
        }

        fun IN(): TerminalNode {
            return getToken(IN, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun STRING_LIT(): List<TerminalNode> {
            return getTokens(STRING_LIT)
        }

        fun STRING_LIT(i: Int): TerminalNode {
            return getToken(STRING_LIT, i)
        }

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_setStrings
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSetStrings(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun setStrings(): SetStringsContext {
        val _localctx = SetStringsContext(_ctx, state)
        enterRule(_localctx, 8, RULE_setStrings)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 92
                match(STRINGS)
                state = 93
                match(IN)
                state = 94
                _localctx.file = match(STRING_LIT)
                state = 99
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == COMMA) {
                    run {
                        run {
                            state = 95
                            match(COMMA)
                            state = 96
                            _localctx.file = match(STRING_LIT)
                        }
                    }
                    state = 101
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 102
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

    class EnablesContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ENABLE(): TerminalNode {
            return getToken(ENABLE, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun AUTO_TARGETS(): List<TerminalNode> {
            return getTokens(AUTO_TARGETS)
        }

        fun AUTO_TARGETS(i: Int): TerminalNode {
            return getToken(AUTO_TARGETS, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_enables
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitEnables(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun enables(): EnablesContext {
        val _localctx = EnablesContext(_ctx, state)
        enterRule(_localctx, 10, RULE_enables)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 104
                match(ENABLE)
                state = 108
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == AUTO_TARGETS) {
                    run {
                        run {
                            state = 105
                            match(AUTO_TARGETS)
                        }
                    }
                    state = 110
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 111
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

    open class TopLevelContext : ParserRuleContext {
        constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState)

        override fun getRuleIndex(): Int {
            return RULE_topLevel
        }

        constructor()

        fun copyFrom(ctx: TopLevelContext?) {
            super.copyFrom(ctx)
        }
    }

    class DndSubRaceContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun subRaceDecl(): SubRaceDeclContext {
            return getRuleContext(SubRaceDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndSubRace(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class DndSpellContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun spellDecl(): SpellDeclContext {
            return getRuleContext(SpellDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndSpell(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class DndClassContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun classDecl(): ClassDeclContext {
            return getRuleContext(ClassDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndClass(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class DndItemContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun itemDecl(): ItemDeclContext {
            return getRuleContext(ItemDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndItem(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class DndRaceContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun raceDecl(): RaceDeclContext {
            return getRuleContext(RaceDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndRace(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class DndAbilityContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun abilityDecl(): AbilityDeclContext {
            return getRuleContext(AbilityDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndAbility(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class DndSubClassContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun subclassDecl(): SubclassDeclContext {
            return getRuleContext(SubclassDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndSubClass(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class DndBgContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun backgroundDecl(): BackgroundDeclContext {
            return getRuleContext(BackgroundDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndBg(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class DndSkillContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun skillDecl(): SkillDeclContext {
            return getRuleContext(SkillDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndSkill(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun topLevel(): TopLevelContext {
        var _localctx = TopLevelContext(_ctx, state)
        enterRule(_localctx, 12, RULE_topLevel)
        try {
            state = 122
            _errHandler.sync(this)
            when (_input.LA(1)) {
                CLASS -> {
                    _localctx = DndClassContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 113
                        classDecl()
                    }
                }

                RACE -> {
                    _localctx = DndRaceContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 114
                        raceDecl()
                    }
                }

                SUBCLASS -> {
                    _localctx = DndSubClassContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 115
                        subclassDecl()
                    }
                }

                SUBRACE -> {
                    _localctx = DndSubRaceContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 116
                        subRaceDecl()
                    }
                }

                ITEM -> {
                    _localctx = DndItemContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 117
                        itemDecl()
                    }
                }

                SPELL -> {
                    _localctx = DndSpellContext(_localctx)
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 118
                        spellDecl()
                    }
                }

                BACKGROUND -> {
                    _localctx = DndBgContext(_localctx)
                    enterOuterAlt(_localctx, 7)
                    run {
                        state = 119
                        backgroundDecl()
                    }
                }

                ABILITY -> {
                    _localctx = DndAbilityContext(_localctx)
                    enterOuterAlt(_localctx, 8)
                    run {
                        state = 120
                        abilityDecl()
                    }
                }

                SKILL -> {
                    _localctx = DndSkillContext(_localctx)
                    enterOuterAlt(_localctx, 9)
                    run {
                        state = 121
                        skillDecl()
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

    class ClassDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var d: DescriptionContext? = null
        fun CLASS(): TerminalNode {
            return getToken(CLASS, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun BLOCK(): TerminalNode {
            return getToken(BLOCK, 0)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        fun description(): List<DescriptionContext> {
            return getRuleContexts(DescriptionContext::class.java)
        }

        fun description(i: Int): DescriptionContext {
            return getRuleContext(DescriptionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_classDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitClassDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun classDecl(): ClassDeclContext {
        val _localctx = ClassDeclContext(_ctx, state)
        enterRule(_localctx, 14, RULE_classDecl)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 124
                match(CLASS)
                state = 125
                _localctx.name = match(IDENTIFIER)
                state = 126
                _localctx.dispName = description()
                state = 127
                match(P_OPEN)
                state = 128
                _localctx.d = description()
                state = 129
                match(P_CLOSE)
                state = 130
                match(BLOCK)
                state = 131
                match(END)
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

    class RaceDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var d: DescriptionContext? = null
        fun RACE(): TerminalNode {
            return getToken(RACE, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun BLOCK(): TerminalNode {
            return getToken(BLOCK, 0)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        fun description(): List<DescriptionContext> {
            return getRuleContexts(DescriptionContext::class.java)
        }

        fun description(i: Int): DescriptionContext {
            return getRuleContext(DescriptionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_raceDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitRaceDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun raceDecl(): RaceDeclContext {
        val _localctx = RaceDeclContext(_ctx, state)
        enterRule(_localctx, 16, RULE_raceDecl)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 133
                match(RACE)
                state = 134
                _localctx.name = match(IDENTIFIER)
                state = 135
                _localctx.dispName = description()
                state = 136
                match(P_OPEN)
                state = 137
                _localctx.d = description()
                state = 138
                match(P_CLOSE)
                state = 139
                match(BLOCK)
                state = 140
                match(END)
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

    class SubclassDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var cls: Token? = null
        var d: DescriptionContext? = null
        fun SUBCLASS(): TerminalNode {
            return getToken(SUBCLASS, 0)
        }

        fun FOR(): TerminalNode {
            return getToken(FOR, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun BLOCK(): TerminalNode {
            return getToken(BLOCK, 0)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
        }

        fun IDENTIFIER(): List<TerminalNode> {
            return getTokens(IDENTIFIER)
        }

        fun IDENTIFIER(i: Int): TerminalNode {
            return getToken(IDENTIFIER, i)
        }

        fun description(): List<DescriptionContext> {
            return getRuleContexts(DescriptionContext::class.java)
        }

        fun description(i: Int): DescriptionContext {
            return getRuleContext(DescriptionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_subclassDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSubclassDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun subclassDecl(): SubclassDeclContext {
        val _localctx = SubclassDeclContext(_ctx, state)
        enterRule(_localctx, 18, RULE_subclassDecl)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 142
                match(SUBCLASS)
                state = 143
                _localctx.name = match(IDENTIFIER)
                state = 144
                _localctx.dispName = description()
                state = 145
                match(FOR)
                state = 146
                _localctx.cls = match(IDENTIFIER)
                state = 147
                match(P_OPEN)
                state = 148
                _localctx.d = description()
                state = 149
                match(P_CLOSE)
                state = 150
                match(BLOCK)
                state = 151
                match(END)
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

    class SubRaceDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var race: Token? = null
        var d: DescriptionContext? = null
        fun SUBRACE(): TerminalNode {
            return getToken(SUBRACE, 0)
        }

        fun FOR(): TerminalNode {
            return getToken(FOR, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun BLOCK(): TerminalNode {
            return getToken(BLOCK, 0)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
        }

        fun IDENTIFIER(): List<TerminalNode> {
            return getTokens(IDENTIFIER)
        }

        fun IDENTIFIER(i: Int): TerminalNode {
            return getToken(IDENTIFIER, i)
        }

        fun description(): List<DescriptionContext> {
            return getRuleContexts(DescriptionContext::class.java)
        }

        fun description(i: Int): DescriptionContext {
            return getRuleContext(DescriptionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_subRaceDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSubRaceDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun subRaceDecl(): SubRaceDeclContext {
        val _localctx = SubRaceDeclContext(_ctx, state)
        enterRule(_localctx, 20, RULE_subRaceDecl)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 153
                match(SUBRACE)
                state = 154
                _localctx.name = match(IDENTIFIER)
                state = 155
                _localctx.dispName = description()
                state = 156
                match(FOR)
                state = 157
                _localctx.race = match(IDENTIFIER)
                state = 158
                match(P_OPEN)
                state = 159
                _localctx.d = description()
                state = 160
                match(P_CLOSE)
                state = 161
                match(BLOCK)
                state = 162
                match(END)
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

    class ItemDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var d: DescriptionContext? = null
        fun ITEM(): TerminalNode {
            return getToken(ITEM, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun BLOCK(): TerminalNode {
            return getToken(BLOCK, 0)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        fun description(): List<DescriptionContext> {
            return getRuleContexts(DescriptionContext::class.java)
        }

        fun description(i: Int): DescriptionContext {
            return getRuleContext(DescriptionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_itemDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitItemDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun itemDecl(): ItemDeclContext {
        val _localctx = ItemDeclContext(_ctx, state)
        enterRule(_localctx, 22, RULE_itemDecl)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 164
                match(ITEM)
                state = 165
                _localctx.name = match(IDENTIFIER)
                state = 166
                _localctx.dispName = description()
                state = 167
                match(P_OPEN)
                state = 168
                _localctx.d = description()
                state = 169
                match(P_CLOSE)
                state = 170
                match(BLOCK)
                state = 171
                match(END)
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

    class SpellDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var d: DescriptionContext? = null
        fun SPELL(): TerminalNode {
            return getToken(SPELL, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun BLOCK(): TerminalNode {
            return getToken(BLOCK, 0)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        fun description(): List<DescriptionContext> {
            return getRuleContexts(DescriptionContext::class.java)
        }

        fun description(i: Int): DescriptionContext {
            return getRuleContext(DescriptionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_spellDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSpellDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun spellDecl(): SpellDeclContext {
        val _localctx = SpellDeclContext(_ctx, state)
        enterRule(_localctx, 24, RULE_spellDecl)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 173
                match(SPELL)
                state = 174
                _localctx.name = match(IDENTIFIER)
                state = 175
                _localctx.dispName = description()
                state = 176
                match(P_OPEN)
                state = 177
                _localctx.d = description()
                state = 178
                match(P_CLOSE)
                state = 179
                match(BLOCK)
                state = 180
                match(END)
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

    class BackgroundDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var d: DescriptionContext? = null
        fun BACKGROUND(): TerminalNode {
            return getToken(BACKGROUND, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun BLOCK(): TerminalNode {
            return getToken(BLOCK, 0)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        fun description(): List<DescriptionContext> {
            return getRuleContexts(DescriptionContext::class.java)
        }

        fun description(i: Int): DescriptionContext {
            return getRuleContext(DescriptionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_backgroundDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitBackgroundDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun backgroundDecl(): BackgroundDeclContext {
        val _localctx = BackgroundDeclContext(_ctx, state)
        enterRule(_localctx, 26, RULE_backgroundDecl)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 182
                match(BACKGROUND)
                state = 183
                _localctx.name = match(IDENTIFIER)
                state = 184
                _localctx.dispName = description()
                state = 185
                match(P_OPEN)
                state = 186
                _localctx.d = description()
                state = 187
                match(P_CLOSE)
                state = 188
                match(BLOCK)
                state = 189
                match(END)
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

    class AbilityDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var d: DescriptionContext? = null
        fun ABILITY(): TerminalNode {
            return getToken(ABILITY, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun description(): List<DescriptionContext> {
            return getRuleContexts(DescriptionContext::class.java)
        }

        fun description(i: Int): DescriptionContext {
            return getRuleContext(DescriptionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_abilityDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitAbilityDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun abilityDecl(): AbilityDeclContext {
        val _localctx = AbilityDeclContext(_ctx, state)
        enterRule(_localctx, 28, RULE_abilityDecl)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 191
                match(ABILITY)
                state = 192
                _localctx.name = match(IDENTIFIER)
                state = 194
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 193
                        _localctx.dispName = description()
                    }
                }
                state = 200
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 196
                        match(P_OPEN)
                        state = 197
                        _localctx.d = description()
                        state = 198
                        match(P_CLOSE)
                    }
                }
                state = 202
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

    class SkillDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var d: DescriptionContext? = null
        var ability: Token? = null
        fun SKILL(): TerminalNode {
            return getToken(SKILL, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun DEPENDS_ON(): TerminalNode {
            return getToken(DEPENDS_ON, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun IDENTIFIER(): List<TerminalNode> {
            return getTokens(IDENTIFIER)
        }

        fun IDENTIFIER(i: Int): TerminalNode {
            return getToken(IDENTIFIER, i)
        }

        fun description(): List<DescriptionContext> {
            return getRuleContexts(DescriptionContext::class.java)
        }

        fun description(i: Int): DescriptionContext {
            return getRuleContext(DescriptionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_skillDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSkillDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun skillDecl(): SkillDeclContext {
        val _localctx = SkillDeclContext(_ctx, state)
        enterRule(_localctx, 30, RULE_skillDecl)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 204
                match(SKILL)
                state = 205
                _localctx.name = match(IDENTIFIER)
                state = 206
                _localctx.dispName = description()
                state = 207
                match(P_OPEN)
                state = 208
                _localctx.d = description()
                state = 209
                match(P_CLOSE)
                state = 210
                match(DEPENDS_ON)
                state = 211
                _localctx.ability = match(IDENTIFIER)
                state = 212
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

    open class DescriptionContext : ParserRuleContext {
        constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState)

        override fun getRuleIndex(): Int {
            return RULE_description
        }

        constructor()

        fun copyFrom(ctx: DescriptionContext?) {
            super.copyFrom(ctx)
        }
    }

    class StringDescrContext(ctx: DescriptionContext?) : DescriptionContext() {
        fun STRING_LIT(): TerminalNode {
            return getToken(STRING_LIT, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitStringDescr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class RefDescrContext(ctx: DescriptionContext?) : DescriptionContext() {
        var name: Token? = null
        fun STRINGS(): TerminalNode {
            return getToken(STRINGS, 0)
        }

        fun DOT(): TerminalNode {
            return getToken(DOT, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitRefDescr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun description(): DescriptionContext {
        var _localctx = DescriptionContext(_ctx, state)
        enterRule(_localctx, 32, RULE_description)
        try {
            state = 218
            _errHandler.sync(this)
            when (_input.LA(1)) {
                STRING_LIT -> {
                    _localctx = StringDescrContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 214
                        match(STRING_LIT)
                    }
                }

                STRINGS -> {
                    _localctx = RefDescrContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 215
                        match(STRINGS)
                        state = 216
                        match(DOT)
                        state = 217
                        _localctx.name = match(IDENTIFIER)
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
        const val DOT = 2
        const val SEMI = 3
        const val COMMA = 4
        const val BLOCK = 5
        const val END = 6
        const val P_OPEN = 7
        const val P_CLOSE = 8
        const val FS_SEP = 9
        const val IN = 10
        const val FOR = 11
        const val ITEM = 12
        const val RACE = 13
        const val CLASS = 14
        const val SKILL = 15
        const val SPELL = 16
        const val ENABLE = 17
        const val SOURCE = 18
        const val ABILITY = 19
        const val STRINGS = 20
        const val SUBRACE = 21
        const val SUBCLASS = 22
        const val BACKGROUND = 23
        const val DEPENDS_ON = 24
        const val AUTO_TARGETS = 25
        const val IDENTIFIER = 26
        const val STRING_LIT = 27
        const val NEWLINE = 28
        const val WS = 29
        const val COMMENT = 30
        const val ANY = 31
        const val RULE_strings = 0
        const val RULE_singleString = 1
        const val RULE_mageProg = 2
        const val RULE_header = 3
        const val RULE_setStrings = 4
        const val RULE_enables = 5
        const val RULE_topLevel = 6
        const val RULE_classDecl = 7
        const val RULE_raceDecl = 8
        const val RULE_subclassDecl = 9
        const val RULE_subRaceDecl = 10
        const val RULE_itemDecl = 11
        const val RULE_spellDecl = 12
        const val RULE_backgroundDecl = 13
        const val RULE_abilityDecl = 14
        const val RULE_skillDecl = 15
        const val RULE_description = 16
        private fun makeRuleNames(): Array<String> {
            return arrayOf(
                "strings", "singleString", "mageProg", "header", "setStrings", "enables",
                "topLevel", "classDecl", "raceDecl", "subclassDecl", "subRaceDecl", "itemDecl",
                "spellDecl", "backgroundDecl", "abilityDecl", "skillDecl", "description"
            )
        }

        val ruleNames = makeRuleNames()
        private fun makeLiteralNames(): Array<String?> {
            return arrayOf(
                null, "'='", "'.'", "';'", "','", "'{'", "'}'", "'('", "')'", "'#~#'",
                "'in'", "'for'", "'item'", "'race'", "'class'", "'skill'", "'spell'",
                "'enable'", "'source'", "'ability'", "'strings'", "'subrace'", "'subclass'",
                "'background'", "'depends on'"
            )
        }

        private val _LITERAL_NAMES = makeLiteralNames()
        private fun makeSymbolicNames(): Array<String?> {
            return arrayOf(
                null, null, "DOT", "SEMI", "COMMA", "BLOCK", "END", "P_OPEN", "P_CLOSE",
                "FS_SEP", "IN", "FOR", "ITEM", "RACE", "CLASS", "SKILL", "SPELL", "ENABLE",
                "SOURCE", "ABILITY", "STRINGS", "SUBRACE", "SUBCLASS", "BACKGROUND",
                "DEPENDS_ON", "AUTO_TARGETS", "IDENTIFIER", "STRING_LIT", "NEWLINE",
                "WS", "COMMENT", "ANY"
            )
        }

        private val _SYMBOLIC_NAMES = makeSymbolicNames()
        val VOCABULARY: Vocabulary = VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES)

        @Deprecated("Use {@link #VOCABULARY} instead.")
        val tokenNames = _SYMBOLIC_NAMES.indices.map {
            VOCABULARY.getLiteralName(it) ?: VOCABULARY.getSymbolicName(it) ?: "<INVALID>"
        }.toTypedArray()

        const val _serializedATN =
            "\u0004\u0001\u001f\u00dd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001" +
                    "\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004" +
                    "\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007" +
                    "\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b" +
                    "\u0002\u000c\u0007\u000c\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007" +
                    "\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0005\u0000$\b\u0000\n\u0000" +
                    "\u000c\u0000\'\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001" +
                    "\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u00022\b" +
                    "\u0002\n\u0002\u000c\u00025\t\u0002\u0001\u0002\u0005\u00028\b\u0002\n\u0002" +
                    "\u000c\u0002;\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001" +
                    "\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003F\b" +
                    "\u0003\n\u0003\u000c\u0003I\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001" +
                    "\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005" +
                    "\u0003T\b\u0003\n\u0003\u000c\u0003W\t\u0003\u0001\u0003\u0001\u0003\u0003" +
                    "\u0003[\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001" +
                    "\u0004\u0005\u0004b\b\u0004\n\u0004\u000c\u0004e\t\u0004\u0001\u0004\u0001" +
                    "\u0004\u0001\u0005\u0001\u0005\u0005\u0005k\b\u0005\n\u0005\u000c\u0005n\t" +
                    "\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001" +
                    "\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003" +
                    "\u0006{\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001" +
                    "\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b" +
                    "\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001" +
                    "\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001" +
                    "\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001" +
                    "\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000c\u0001\u000c" +
                    "\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\r\u0001" +
                    "\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e" +
                    "\u0001\u000e\u0001\u000e\u0003\u000e\u00c3\b\u000e\u0001\u000e\u0001\u000e" +
                    "\u0001\u000e\u0001\u000e\u0003\u000e\u00c9\b\u000e\u0001\u000e\u0001\u000e" +
                    "\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f" +
                    "\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010" +
                    "\u0001\u0010\u0001\u0010\u0003\u0010\u00db\b\u0010\u0001\u0010\u0000\u0000" +
                    "\u0011\u0000\u0002\u0004\u0006\b\n\u000c\u000e\u0010\u0012\u0014\u0016\u0018" +
                    "\u001a\u001c\u001e \u0000\u0000\u00e0\u0000%\u0001\u0000\u0000\u0000\u0002" +
                    "*\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000\u0006Z\u0001" +
                    "\u0000\u0000\u0000\b\\\u0001\u0000\u0000\u0000\nh\u0001\u0000\u0000\u0000" +
                    "\u000cz\u0001\u0000\u0000\u0000\u000e|\u0001\u0000\u0000\u0000\u0010\u0085" +
                    "\u0001\u0000\u0000\u0000\u0012\u008e\u0001\u0000\u0000\u0000\u0014\u0099" +
                    "\u0001\u0000\u0000\u0000\u0016\u00a4\u0001\u0000\u0000\u0000\u0018\u00ad" +
                    "\u0001\u0000\u0000\u0000\u001a\u00b6\u0001\u0000\u0000\u0000\u001c\u00bf" +
                    "\u0001\u0000\u0000\u0000\u001e\u00cc\u0001\u0000\u0000\u0000 \u00da\u0001" +
                    "\u0000\u0000\u0000\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000\u0000\u0000" +
                    "$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000" +
                    "\u0000&(\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000()\u0005\u0000" +
                    "\u0000\u0001)\u0001\u0001\u0000\u0000\u0000*+\u0005\u001a\u0000\u0000" +
                    "+,\u0005\u0001\u0000\u0000,-\u0005\u001b\u0000\u0000-.\u0005\u0003\u0000" +
                    "\u0000.\u0003\u0001\u0000\u0000\u0000/3\u0003\u0006\u0003\u000002\u0003" +
                    "\n\u0005\u000010\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001" +
                    "\u0000\u0000\u000034\u0001\u0000\u0000\u000049\u0001\u0000\u0000\u0000" +
                    "53\u0001\u0000\u0000\u000068\u0003\u000c\u0006\u000076\u0001\u0000\u0000\u0000" +
                    "8;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000" +
                    "\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0005\u0000" +
                    "\u0000\u0001=\u0005\u0001\u0000\u0000\u0000>?\u0005\u0012\u0000\u0000" +
                    "?@\u0005\u001a\u0000\u0000@[\u0005\u0003\u0000\u0000AB\u0005\u0012\u0000" +
                    "\u0000BC\u0005\u001a\u0000\u0000CG\u0005\u0018\u0000\u0000DF\u0005\u001b" +
                    "\u0000\u0000ED\u0001\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001" +
                    "\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001\u0000\u0000\u0000" +
                    "IG\u0001\u0000\u0000\u0000J[\u0005\u0003\u0000\u0000KL\u0005\u0012\u0000" +
                    "\u0000LM\u0005\u001a\u0000\u0000MN\u0005\u0003\u0000\u0000N[\u0003\b\u0004" +
                    "\u0000OP\u0005\u0012\u0000\u0000PQ\u0005\u001a\u0000\u0000QU\u0005\u0018" +
                    "\u0000\u0000RT\u0005\u001b\u0000\u0000SR\u0001\u0000\u0000\u0000TW\u0001" +
                    "\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000" +
                    "VX\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XY\u0005\u0003\u0000" +
                    "\u0000Y[\u0003\b\u0004\u0000Z>\u0001\u0000\u0000\u0000ZA\u0001\u0000\u0000" +
                    "\u0000ZK\u0001\u0000\u0000\u0000ZO\u0001\u0000\u0000\u0000[\u0007\u0001" +
                    "\u0000\u0000\u0000\\]\u0005\u0014\u0000\u0000]^\u0005\n\u0000\u0000^c" +
                    "\u0005\u001b\u0000\u0000_`\u0005\u0004\u0000\u0000`b\u0005\u001b\u0000" +
                    "\u0000a_\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000" +
                    "\u0000\u0000cd\u0001\u0000\u0000\u0000df\u0001\u0000\u0000\u0000ec\u0001" +
                    "\u0000\u0000\u0000fg\u0005\u0003\u0000\u0000g\t\u0001\u0000\u0000\u0000" +
                    "hl\u0005\u0011\u0000\u0000ik\u0005\u0019\u0000\u0000ji\u0001\u0000\u0000" +
                    "\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000" +
                    "\u0000\u0000mo\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005" +
                    "\u0003\u0000\u0000p\u000b\u0001\u0000\u0000\u0000q{\u0003\u000e\u0007" +
                    "\u0000r{\u0003\u0010\b\u0000s{\u0003\u0012\t\u0000t{\u0003\u0014\n\u0000" +
                    "u{\u0003\u0016\u000b\u0000v{\u0003\u0018\u000c\u0000w{\u0003\u001a\r\u0000" +
                    "x{\u0003\u001c\u000e\u0000y{\u0003\u001e\u000f\u0000zq\u0001\u0000\u0000" +
                    "\u0000zr\u0001\u0000\u0000\u0000zs\u0001\u0000\u0000\u0000zt\u0001\u0000" +
                    "\u0000\u0000zu\u0001\u0000\u0000\u0000zv\u0001\u0000\u0000\u0000zw\u0001" +
                    "\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000zy\u0001\u0000\u0000\u0000" +
                    "{\r\u0001\u0000\u0000\u0000|}\u0005\u000e\u0000\u0000}~\u0005\u001a\u0000" +
                    "\u0000~\u007f\u0003 \u0010\u0000\u007f\u0080\u0005\u0007\u0000\u0000\u0080" +
                    "\u0081\u0003 \u0010\u0000\u0081\u0082\u0005\b\u0000\u0000\u0082\u0083" +
                    "\u0005\u0005\u0000\u0000\u0083\u0084\u0005\u0006\u0000\u0000\u0084\u000f" +
                    "\u0001\u0000\u0000\u0000\u0085\u0086\u0005\r\u0000\u0000\u0086\u0087\u0005" +
                    "\u001a\u0000\u0000\u0087\u0088\u0003 \u0010\u0000\u0088\u0089\u0005\u0007" +
                    "\u0000\u0000\u0089\u008a\u0003 \u0010\u0000\u008a\u008b\u0005\b\u0000" +
                    "\u0000\u008b\u008c\u0005\u0005\u0000\u0000\u008c\u008d\u0005\u0006\u0000" +
                    "\u0000\u008d\u0011\u0001\u0000\u0000\u0000\u008e\u008f\u0005\u0016\u0000" +
                    "\u0000\u008f\u0090\u0005\u001a\u0000\u0000\u0090\u0091\u0003 \u0010\u0000" +
                    "\u0091\u0092\u0005\u000b\u0000\u0000\u0092\u0093\u0005\u001a\u0000\u0000" +
                    "\u0093\u0094\u0005\u0007\u0000\u0000\u0094\u0095\u0003 \u0010\u0000\u0095" +
                    "\u0096\u0005\b\u0000\u0000\u0096\u0097\u0005\u0005\u0000\u0000\u0097\u0098" +
                    "\u0005\u0006\u0000\u0000\u0098\u0013\u0001\u0000\u0000\u0000\u0099\u009a" +
                    "\u0005\u0015\u0000\u0000\u009a\u009b\u0005\u001a\u0000\u0000\u009b\u009c" +
                    "\u0003 \u0010\u0000\u009c\u009d\u0005\u000b\u0000\u0000\u009d\u009e\u0005" +
                    "\u001a\u0000\u0000\u009e\u009f\u0005\u0007\u0000\u0000\u009f\u00a0\u0003" +
                    " \u0010\u0000\u00a0\u00a1\u0005\b\u0000\u0000\u00a1\u00a2\u0005\u0005" +
                    "\u0000\u0000\u00a2\u00a3\u0005\u0006\u0000\u0000\u00a3\u0015\u0001\u0000" +
                    "\u0000\u0000\u00a4\u00a5\u0005\u000c\u0000\u0000\u00a5\u00a6\u0005\u001a\u0000" +
                    "\u0000\u00a6\u00a7\u0003 \u0010\u0000\u00a7\u00a8\u0005\u0007\u0000\u0000" +
                    "\u00a8\u00a9\u0003 \u0010\u0000\u00a9\u00aa\u0005\b\u0000\u0000\u00aa" +
                    "\u00ab\u0005\u0005\u0000\u0000\u00ab\u00ac\u0005\u0006\u0000\u0000\u00ac" +
                    "\u0017\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0010\u0000\u0000\u00ae" +
                    "\u00af\u0005\u001a\u0000\u0000\u00af\u00b0\u0003 \u0010\u0000\u00b0\u00b1" +
                    "\u0005\u0007\u0000\u0000\u00b1\u00b2\u0003 \u0010\u0000\u00b2\u00b3\u0005" +
                    "\b\u0000\u0000\u00b3\u00b4\u0005\u0005\u0000\u0000\u00b4\u00b5\u0005\u0006" +
                    "\u0000\u0000\u00b5\u0019\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u0017" +
                    "\u0000\u0000\u00b7\u00b8\u0005\u001a\u0000\u0000\u00b8\u00b9\u0003 \u0010" +
                    "\u0000\u00b9\u00ba\u0005\u0007\u0000\u0000\u00ba\u00bb\u0003 \u0010\u0000" +
                    "\u00bb\u00bc\u0005\b\u0000\u0000\u00bc\u00bd\u0005\u0005\u0000\u0000\u00bd" +
                    "\u00be\u0005\u0006\u0000\u0000\u00be\u001b\u0001\u0000\u0000\u0000\u00bf" +
                    "\u00c0\u0005\u0013\u0000\u0000\u00c0\u00c2\u0005\u001a\u0000\u0000\u00c1" +
                    "\u00c3\u0003 \u0010\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c2\u00c3" +
                    "\u0001\u0000\u0000\u0000\u00c3\u00c8\u0001\u0000\u0000\u0000\u00c4\u00c5" +
                    "\u0005\u0007\u0000\u0000\u00c5\u00c6\u0003 \u0010\u0000\u00c6\u00c7\u0005" +
                    "\b\u0000\u0000\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00c4\u0001\u0000" +
                    "\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000" +
                    "\u0000\u0000\u00ca\u00cb\u0005\u0003\u0000\u0000\u00cb\u001d\u0001\u0000" +
                    "\u0000\u0000\u00cc\u00cd\u0005\u000f\u0000\u0000\u00cd\u00ce\u0005\u001a" +
                    "\u0000\u0000\u00ce\u00cf\u0003 \u0010\u0000\u00cf\u00d0\u0005\u0007\u0000" +
                    "\u0000\u00d0\u00d1\u0003 \u0010\u0000\u00d1\u00d2\u0005\b\u0000\u0000" +
                    "\u00d2\u00d3\u0005\u0018\u0000\u0000\u00d3\u00d4\u0005\u001a\u0000\u0000" +
                    "\u00d4\u00d5\u0005\u0003\u0000\u0000\u00d5\u001f\u0001\u0000\u0000\u0000" +
                    "\u00d6\u00db\u0005\u001b\u0000\u0000\u00d7\u00d8\u0005\u0014\u0000\u0000" +
                    "\u00d8\u00d9\u0005\u0002\u0000\u0000\u00d9\u00db\u0005\u001a\u0000\u0000" +
                    "\u00da\u00d6\u0001\u0000\u0000\u0000\u00da\u00d7\u0001\u0000\u0000\u0000" +
                    "\u00db!\u0001\u0000\u0000\u0000\u000c%39GUZclz\u00c2\u00c8\u00da"
        val _ATN = ATNDeserializer().deserialize(_serializedATN.toCharArray())

        init {
            _decisionToDFA = (0 until _ATN.numberOfDecisions).map {
                DFA(_ATN.getDecisionState(it), it)
            }.toTypedArray()
        }
    }
}