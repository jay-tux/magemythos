// Generated from /home/data/kotlin/MageMythos/composeApp/src/parser/MM.g4 by ANTLR 4.13.1
package parser.mm

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
                state = 61
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == IDENTIFIER) {
                    run {
                        run {
                            state = 58
                            singleString()
                        }
                    }
                    state = 63
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 64
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
        fun ASSIGN(): TerminalNode {
            return getToken(ASSIGN, 0)
        }

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
                state = 66
                _localctx.key = match(IDENTIFIER)
                state = 67
                match(ASSIGN)
                state = 68
                _localctx.value = match(STRING_LIT)
                state = 69
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
                state = 71
                header()
                state = 75
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == ENABLE) {
                    run {
                        run {
                            state = 72
                            enables()
                        }
                    }
                    state = 77
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 81
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la and 0x3f.inv() == 0 && 1L shl _la and 563791079816560640L != 0L) {
                    run {
                        run {
                            state = 78
                            topLevel()
                        }
                    }
                    state = 83
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 84
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
            state = 114
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 5, _ctx)) {
                1 -> {
                    _localctx = SourceHeaderContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 86
                        match(SOURCE)
                        state = 87
                        (_localctx as SourceHeaderContext).src = match(IDENTIFIER)
                        state = 88
                        match(SEMI)
                    }
                }

                2 -> {
                    _localctx = SourceHeaderDepsContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 89
                        match(SOURCE)
                        state = 90
                        (_localctx as SourceHeaderDepsContext).src = match(IDENTIFIER)
                        state = 91
                        match(DEPENDS_ON)
                        state = 95
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la == STRING_LIT) {
                            run {
                                run {
                                    state = 92
                                    (_localctx as SourceHeaderDepsContext).deps = match(STRING_LIT)
                                }
                            }
                            state = 97
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 98
                        match(SEMI)
                    }
                }

                3 -> {
                    _localctx = SourceHeaderStringsContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 99
                        match(SOURCE)
                        state = 100
                        (_localctx as SourceHeaderStringsContext).src = match(IDENTIFIER)
                        state = 101
                        match(SEMI)
                        state = 102
                        setStrings()
                    }
                }

                4 -> {
                    _localctx = SourceHeaderDepsStringsContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 103
                        match(SOURCE)
                        state = 104
                        _localctx.src = match(IDENTIFIER)
                        state = 105
                        match(DEPENDS_ON)
                        state = 109
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la == STRING_LIT) {
                            run {
                                run {
                                    state = 106
                                    _localctx.deps = match(STRING_LIT)
                                }
                            }
                            state = 111
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 112
                        match(SEMI)
                        state = 113
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
                state = 116
                match(STRINGS)
                state = 117
                match(IN)
                state = 118
                _localctx.file = match(STRING_LIT)
                state = 123
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == COMMA) {
                    run {
                        run {
                            state = 119
                            match(COMMA)
                            state = 120
                            _localctx.file = match(STRING_LIT)
                        }
                    }
                    state = 125
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 126
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
                state = 128
                match(ENABLE)
                state = 132
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == AUTO_TARGETS) {
                    run {
                        run {
                            state = 129
                            match(AUTO_TARGETS)
                        }
                    }
                    state = 134
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 135
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

    class DndItemTagContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun itemTagDecl(): ItemTagDeclContext {
            return getRuleContext(ItemTagDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndItemTag(
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

    class DndTraitContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun traitDecl(): TraitDeclContext {
            return getRuleContext(TraitDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndTrait(
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

    class DndItemTraitContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun itemTraitDecl(): ItemTraitDeclContext {
            return getRuleContext(ItemTraitDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndItemTrait(
                this
            ) else visitor.visitChildren(this)
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

    class DndDamageContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun damageDecl(): DamageDeclContext {
            return getRuleContext(DamageDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndDamage(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class FunctionContext(ctx: TopLevelContext?) : TopLevelContext() {
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
            state = 151
            _errHandler.sync(this)
            when (_input.LA(1)) {
                CLASS -> {
                    _localctx = DndClassContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 137
                        classDecl()
                    }
                }

                RACE -> {
                    _localctx = DndRaceContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 138
                        raceDecl()
                    }
                }

                SUBCLASS -> {
                    _localctx = DndSubClassContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 139
                        subclassDecl()
                    }
                }

                SUBRACE -> {
                    _localctx = DndSubRaceContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 140
                        subRaceDecl()
                    }
                }

                ITEM -> {
                    _localctx = DndItemContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 141
                        itemDecl()
                    }
                }

                SPELL -> {
                    _localctx = DndSpellContext(_localctx)
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 142
                        spellDecl()
                    }
                }

                BACKGROUND -> {
                    _localctx = DndBgContext(_localctx)
                    enterOuterAlt(_localctx, 7)
                    run {
                        state = 143
                        backgroundDecl()
                    }
                }

                ABILITY -> {
                    _localctx = DndAbilityContext(_localctx)
                    enterOuterAlt(_localctx, 8)
                    run {
                        state = 144
                        abilityDecl()
                    }
                }

                SKILL -> {
                    _localctx = DndSkillContext(_localctx)
                    enterOuterAlt(_localctx, 9)
                    run {
                        state = 145
                        skillDecl()
                    }
                }

                TRAIT -> {
                    _localctx = DndTraitContext(_localctx)
                    enterOuterAlt(_localctx, 10)
                    run {
                        state = 146
                        traitDecl()
                    }
                }

                ITEM_TRAIT -> {
                    _localctx = DndItemTraitContext(_localctx)
                    enterOuterAlt(_localctx, 11)
                    run {
                        state = 147
                        itemTraitDecl()
                    }
                }

                DAMAGE -> {
                    _localctx = DndDamageContext(_localctx)
                    enterOuterAlt(_localctx, 12)
                    run {
                        state = 148
                        damageDecl()
                    }
                }

                ITEM_TAG -> {
                    _localctx = DndItemTagContext(_localctx)
                    enterOuterAlt(_localctx, 13)
                    run {
                        state = 149
                        itemTagDecl()
                    }
                }

                FUN -> {
                    _localctx = FunctionContext(_localctx)
                    enterOuterAlt(_localctx, 14)
                    run {
                        state = 150
                        funDecl()
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

        fun BLOCK(): TerminalNode {
            return getToken(BLOCK, 0)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
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

        fun declBody(): List<DeclBodyContext> {
            return getRuleContexts(DeclBodyContext::class.java)
        }

        fun declBody(i: Int): DeclBodyContext {
            return getRuleContext(DeclBodyContext::class.java, i)
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
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 153
                match(CLASS)
                state = 154
                _localctx.name = match(IDENTIFIER)
                state = 156
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 155
                        _localctx.dispName = description()
                    }
                }
                state = 162
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 158
                        match(P_OPEN)
                        state = 159
                        _localctx.d = description()
                        state = 160
                        match(P_CLOSE)
                    }
                }
                state = 164
                match(BLOCK)
                state = 168
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN) {
                    run {
                        run {
                            state = 165
                            declBody()
                        }
                    }
                    state = 170
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
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

    class RaceDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var d: DescriptionContext? = null
        fun RACE(): TerminalNode {
            return getToken(RACE, 0)
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

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun ALLOW_SUBRACE(): TerminalNode {
            return getToken(ALLOW_SUBRACE, 0)
        }

        fun declBody(): List<DeclBodyContext> {
            return getRuleContexts(DeclBodyContext::class.java)
        }

        fun declBody(i: Int): DeclBodyContext {
            return getRuleContext(DeclBodyContext::class.java, i)
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
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 173
                match(RACE)
                state = 174
                _localctx.name = match(IDENTIFIER)
                state = 176
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 175
                        _localctx.dispName = description()
                    }
                }
                state = 182
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 178
                        match(P_OPEN)
                        state = 179
                        _localctx.d = description()
                        state = 180
                        match(P_CLOSE)
                    }
                }
                state = 185
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == ALLOW_SUBRACE) {
                    run {
                        state = 184
                        match(ALLOW_SUBRACE)
                    }
                }
                state = 187
                match(BLOCK)
                state = 191
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN) {
                    run {
                        run {
                            state = 188
                            declBody()
                        }
                    }
                    state = 193
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 194
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

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun declBody(): List<DeclBodyContext> {
            return getRuleContexts(DeclBodyContext::class.java)
        }

        fun declBody(i: Int): DeclBodyContext {
            return getRuleContext(DeclBodyContext::class.java, i)
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
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 196
                match(SUBCLASS)
                state = 197
                _localctx.name = match(IDENTIFIER)
                state = 199
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 198
                        _localctx.dispName = description()
                    }
                }
                state = 201
                match(FOR)
                state = 202
                _localctx.cls = match(IDENTIFIER)
                state = 207
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 203
                        match(P_OPEN)
                        state = 204
                        _localctx.d = description()
                        state = 205
                        match(P_CLOSE)
                    }
                }
                state = 209
                match(BLOCK)
                state = 213
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN) {
                    run {
                        run {
                            state = 210
                            declBody()
                        }
                    }
                    state = 215
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 216
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

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun declBody(): List<DeclBodyContext> {
            return getRuleContexts(DeclBodyContext::class.java)
        }

        fun declBody(i: Int): DeclBodyContext {
            return getRuleContext(DeclBodyContext::class.java, i)
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
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 218
                match(SUBRACE)
                state = 219
                _localctx.name = match(IDENTIFIER)
                state = 221
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 220
                        _localctx.dispName = description()
                    }
                }
                state = 223
                match(FOR)
                state = 224
                _localctx.race = match(IDENTIFIER)
                state = 229
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 225
                        match(P_OPEN)
                        state = 226
                        _localctx.d = description()
                        state = 227
                        match(P_CLOSE)
                    }
                }
                state = 231
                match(BLOCK)
                state = 235
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN) {
                    run {
                        run {
                            state = 232
                            declBody()
                        }
                    }
                    state = 237
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 238
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
        var worth: Token? = null
        var weight: Token? = null
        var traits: IdentifierSetContext? = null
        var tags: IdentifierSetContext? = null
        fun ITEM(): TerminalNode {
            return getToken(ITEM, 0)
        }

        fun P_OPEN(): List<TerminalNode> {
            return getTokens(P_OPEN)
        }

        fun P_OPEN(i: Int): TerminalNode {
            return getToken(P_OPEN, i)
        }

        fun P_CLOSE(): List<TerminalNode> {
            return getTokens(P_CLOSE)
        }

        fun P_CLOSE(i: Int): TerminalNode {
            return getToken(P_CLOSE, i)
        }

        fun BR_OPEN(): TerminalNode {
            return getToken(BR_OPEN, 0)
        }

        fun BR_CLOSE(): TerminalNode {
            return getToken(BR_CLOSE, 0)
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

        fun CURRENCY_LIT(): TerminalNode {
            return getToken(CURRENCY_LIT, 0)
        }

        fun WEIGHT_LIT(): TerminalNode {
            return getToken(WEIGHT_LIT, 0)
        }

        fun identifierSet(): List<IdentifierSetContext> {
            return getRuleContexts(IdentifierSetContext::class.java)
        }

        fun identifierSet(i: Int): IdentifierSetContext {
            return getRuleContext(IdentifierSetContext::class.java, i)
        }

        fun declBody(): List<DeclBodyContext> {
            return getRuleContexts(DeclBodyContext::class.java)
        }

        fun declBody(i: Int): DeclBodyContext {
            return getRuleContext(DeclBodyContext::class.java, i)
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
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 240
                match(ITEM)
                state = 241
                _localctx.name = match(IDENTIFIER)
                state = 243
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 242
                        _localctx.dispName = description()
                    }
                }
                state = 249
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 245
                        match(P_OPEN)
                        state = 246
                        _localctx.d = description()
                        state = 247
                        match(P_CLOSE)
                    }
                }
                state = 251
                _localctx.worth = match(CURRENCY_LIT)
                state = 252
                _localctx.weight = match(WEIGHT_LIT)
                state = 253
                match(P_OPEN)
                state = 254
                _localctx.traits = identifierSet()
                state = 255
                match(P_CLOSE)
                state = 256
                match(BR_OPEN)
                state = 257
                _localctx.tags = identifierSet()
                state = 258
                match(BR_CLOSE)
                state = 259
                match(BLOCK)
                state = 263
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN) {
                    run {
                        run {
                            state = 260
                            declBody()
                        }
                    }
                    state = 265
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 266
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

        fun BLOCK(): TerminalNode {
            return getToken(BLOCK, 0)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
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

        fun declBody(): List<DeclBodyContext> {
            return getRuleContexts(DeclBodyContext::class.java)
        }

        fun declBody(i: Int): DeclBodyContext {
            return getRuleContext(DeclBodyContext::class.java, i)
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
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 268
                match(SPELL)
                state = 269
                _localctx.name = match(IDENTIFIER)
                state = 271
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 270
                        _localctx.dispName = description()
                    }
                }
                state = 277
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 273
                        match(P_OPEN)
                        state = 274
                        _localctx.d = description()
                        state = 275
                        match(P_CLOSE)
                    }
                }
                state = 279
                match(BLOCK)
                state = 283
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN) {
                    run {
                        run {
                            state = 280
                            declBody()
                        }
                    }
                    state = 285
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 286
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

        fun BLOCK(): TerminalNode {
            return getToken(BLOCK, 0)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
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

        fun declBody(): List<DeclBodyContext> {
            return getRuleContexts(DeclBodyContext::class.java)
        }

        fun declBody(i: Int): DeclBodyContext {
            return getRuleContext(DeclBodyContext::class.java, i)
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
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 288
                match(BACKGROUND)
                state = 289
                _localctx.name = match(IDENTIFIER)
                state = 291
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 290
                        _localctx.dispName = description()
                    }
                }
                state = 297
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 293
                        match(P_OPEN)
                        state = 294
                        _localctx.d = description()
                        state = 295
                        match(P_CLOSE)
                    }
                }
                state = 299
                match(BLOCK)
                state = 303
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN) {
                    run {
                        run {
                            state = 300
                            declBody()
                        }
                    }
                    state = 305
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 306
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
                state = 308
                match(ABILITY)
                state = 309
                _localctx.name = match(IDENTIFIER)
                state = 311
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 310
                        _localctx.dispName = description()
                    }
                }
                state = 317
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 313
                        match(P_OPEN)
                        state = 314
                        _localctx.d = description()
                        state = 315
                        match(P_CLOSE)
                    }
                }
                state = 319
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
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 321
                match(SKILL)
                state = 322
                _localctx.name = match(IDENTIFIER)
                state = 324
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 323
                        _localctx.dispName = description()
                    }
                }
                state = 330
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 326
                        match(P_OPEN)
                        state = 327
                        _localctx.d = description()
                        state = 328
                        match(P_CLOSE)
                    }
                }
                state = 332
                match(DEPENDS_ON)
                state = 333
                _localctx.ability = match(IDENTIFIER)
                state = 334
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

    class TraitDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var d: DescriptionContext? = null
        fun TRAIT(): TerminalNode {
            return getToken(TRAIT, 0)
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

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun declBody(): List<DeclBodyContext> {
            return getRuleContexts(DeclBodyContext::class.java)
        }

        fun declBody(i: Int): DeclBodyContext {
            return getRuleContext(DeclBodyContext::class.java, i)
        }

        fun description(): List<DescriptionContext> {
            return getRuleContexts(DescriptionContext::class.java)
        }

        fun description(i: Int): DescriptionContext {
            return getRuleContext(DescriptionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_traitDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitTraitDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun traitDecl(): TraitDeclContext {
        val _localctx = TraitDeclContext(_ctx, state)
        enterRule(_localctx, 32, RULE_traitDecl)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 336
                match(TRAIT)
                state = 337
                _localctx.name = match(IDENTIFIER)
                state = 339
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 338
                        _localctx.dispName = description()
                    }
                }
                state = 345
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 341
                        match(P_OPEN)
                        state = 342
                        _localctx.d = description()
                        state = 343
                        match(P_CLOSE)
                    }
                }
                state = 347
                match(BLOCK)
                state = 351
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN) {
                    run {
                        run {
                            state = 348
                            declBody()
                        }
                    }
                    state = 353
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 354
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

    class ItemTagDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var d: DescriptionContext? = null
        fun ITEM_TAG(): TerminalNode {
            return getToken(ITEM_TAG, 0)
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
            return RULE_itemTagDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitItemTagDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun itemTagDecl(): ItemTagDeclContext {
        val _localctx = ItemTagDeclContext(_ctx, state)
        enterRule(_localctx, 34, RULE_itemTagDecl)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 356
                match(ITEM_TAG)
                state = 357
                _localctx.name = match(IDENTIFIER)
                state = 359
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 358
                        _localctx.dispName = description()
                    }
                }
                state = 365
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 361
                        match(P_OPEN)
                        state = 362
                        _localctx.d = description()
                        state = 363
                        match(P_CLOSE)
                    }
                }
                state = 367
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

    class ItemTraitDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var d: DescriptionContext? = null
        fun ITEM_TRAIT(): TerminalNode {
            return getToken(ITEM_TRAIT, 0)
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

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun declBody(): List<DeclBodyContext> {
            return getRuleContexts(DeclBodyContext::class.java)
        }

        fun declBody(i: Int): DeclBodyContext {
            return getRuleContext(DeclBodyContext::class.java, i)
        }

        fun description(): List<DescriptionContext> {
            return getRuleContexts(DescriptionContext::class.java)
        }

        fun description(i: Int): DescriptionContext {
            return getRuleContext(DescriptionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_itemTraitDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitItemTraitDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun itemTraitDecl(): ItemTraitDeclContext {
        val _localctx = ItemTraitDeclContext(_ctx, state)
        enterRule(_localctx, 36, RULE_itemTraitDecl)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 369
                match(ITEM_TRAIT)
                state = 370
                _localctx.name = match(IDENTIFIER)
                state = 372
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 371
                        _localctx.dispName = description()
                    }
                }
                state = 378
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 374
                        match(P_OPEN)
                        state = 375
                        _localctx.d = description()
                        state = 376
                        match(P_CLOSE)
                    }
                }
                state = 380
                match(BLOCK)
                state = 384
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN) {
                    run {
                        run {
                            state = 381
                            declBody()
                        }
                    }
                    state = 386
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 387
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

    class DamageDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var dispName: DescriptionContext? = null
        var d: DescriptionContext? = null
        fun DAMAGE(): TerminalNode {
            return getToken(DAMAGE, 0)
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
            return RULE_damageDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDamageDecl(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun damageDecl(): DamageDeclContext {
        val _localctx = DamageDeclContext(_ctx, state)
        enterRule(_localctx, 38, RULE_damageDecl)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 389
                match(DAMAGE)
                state = 390
                _localctx.name = match(IDENTIFIER)
                state = 392
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 391
                        _localctx.dispName = description()
                    }
                }
                state = 398
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 394
                        match(P_OPEN)
                        state = 395
                        _localctx.d = description()
                        state = 396
                        match(P_CLOSE)
                    }
                }
                state = 400
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

    class DeclBodyContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun funDecl(): FunDeclContext {
            return getRuleContext(FunDeclContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_declBody
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDeclBody(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun declBody(): DeclBodyContext {
        val _localctx = DeclBodyContext(_ctx, state)
        enterRule(_localctx, 40, RULE_declBody)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 402
                funDecl()
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
        fun FUN(): TerminalNode {
            return getToken(FUN, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun identifierSet(): IdentifierSetContext {
            return getRuleContext(IdentifierSetContext::class.java, 0)
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
        enterRule(_localctx, 42, RULE_funDecl)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 404
                match(FUN)
                state = 405
                _localctx.name = match(IDENTIFIER)
                state = 406
                match(P_OPEN)
                state = 407
                identifierSet()
                state = 408
                match(P_CLOSE)
                state = 409
                match(BLOCK)
                state = 413
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la - 23 and 0x3f.inv() == 0 && 1L shl _la - 23 and 135515915487237L != 0L) {
                    run {
                        run {
                            state = 410
                            stmt()
                        }
                    }
                    state = 415
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 416
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

    class IdentifierSetContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun IDENTIFIER(): List<TerminalNode> {
            return getTokens(IDENTIFIER)
        }

        fun IDENTIFIER(i: Int): TerminalNode {
            return getToken(IDENTIFIER, i)
        }

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_identifierSet
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitIdentifierSet(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun identifierSet(): IdentifierSetContext {
        val _localctx = IdentifierSetContext(_ctx, state)
        enterRule(_localctx, 44, RULE_identifierSet)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 426
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == IDENTIFIER) {
                    run {
                        state = 418
                        match(IDENTIFIER)
                        state = 423
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la == COMMA) {
                            run {
                                run {
                                    state = 419
                                    match(COMMA)
                                    state = 420
                                    match(IDENTIFIER)
                                }
                            }
                            state = 425
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
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
        fun FOR(): TerminalNode {
            return getToken(FOR, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun IN(): TerminalNode {
            return getToken(IN, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun stmt(): StmtContext {
            return getRuleContext(StmtContext::class.java, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
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
        fun WHILE(): TerminalNode {
            return getToken(WHILE, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun stmt(): StmtContext {
            return getRuleContext(StmtContext::class.java, 0)
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
        fun IF(): TerminalNode {
            return getToken(IF, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        fun stmt(): List<StmtContext> {
            return getRuleContexts(StmtContext::class.java)
        }

        fun stmt(i: Int): StmtContext {
            return getRuleContext(StmtContext::class.java, i)
        }

        fun ELSE(): TerminalNode {
            return getToken(ELSE, 0)
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

    class BlockStmtContext(ctx: StmtContext?) : StmtContext() {
        fun BLOCK(): TerminalNode {
            return getToken(BLOCK, 0)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitBlockStmt(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class AssignStmtContext(ctx: StmtContext?) : StmtContext() {
        var v: RefContext? = null
        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun ref(): RefContext {
            return getRuleContext(RefContext::class.java, 0)
        }

        fun ASSIGN(): TerminalNode {
            return getToken(ASSIGN, 0)
        }

        fun PLUS_ASSIGN(): TerminalNode {
            return getToken(PLUS_ASSIGN, 0)
        }

        fun MINUS_ASSIGN(): TerminalNode {
            return getToken(MINUS_ASSIGN, 0)
        }

        fun MULT_ASSIGN(): TerminalNode {
            return getToken(MULT_ASSIGN, 0)
        }

        fun DIV_ASSIGN(): TerminalNode {
            return getToken(DIV_ASSIGN, 0)
        }

        fun MOD_ASSIGN(): TerminalNode {
            return getToken(MOD_ASSIGN, 0)
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

    @Throws(RecognitionException::class)
    fun stmt(): StmtContext {
        var _localctx = StmtContext(_ctx, state)
        enterRule(_localctx, 46, RULE_stmt)
        var _la: Int
        try {
            state = 467
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 50, _ctx)) {
                1 -> {
                    _localctx = ExprStmtContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 428
                        expr(0)
                        state = 429
                        match(SEMI)
                    }
                }

                2 -> {
                    _localctx = BlockStmtContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 431
                        match(BLOCK)
                        state = 435
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la - 23 and 0x3f.inv() == 0 && 1L shl _la - 23 and 135515915487237L != 0L) {
                            run {
                                run {
                                    state = 432
                                    stmt()
                                }
                            }
                            state = 437
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 438
                        match(END)
                    }
                }

                3 -> {
                    _localctx = IfStmtContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 439
                        match(IF)
                        state = 440
                        match(P_OPEN)
                        state = 441
                        expr(0)
                        state = 442
                        match(P_CLOSE)
                        state = 443
                        stmt()
                        state = 446
                        _errHandler.sync(this)
                        when (interpreter.adaptivePredict(_input, 49, _ctx)) {
                            1 -> {
                                state = 444
                                match(ELSE)
                                state = 445
                                stmt()
                            }

                            else -> {}
                        }
                    }
                }

                4 -> {
                    _localctx = WhileStmtContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 448
                        match(WHILE)
                        state = 449
                        match(P_OPEN)
                        state = 450
                        expr(0)
                        state = 451
                        match(P_CLOSE)
                        state = 452
                        stmt()
                    }
                }

                5 -> {
                    _localctx = ForStmtContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 454
                        match(FOR)
                        state = 455
                        match(P_OPEN)
                        state = 456
                        (_localctx as ForStmtContext).v = match(IDENTIFIER)
                        state = 457
                        match(IN)
                        state = 458
                        expr(0)
                        state = 459
                        match(P_CLOSE)
                        state = 460
                        stmt()
                    }
                }

                6 -> {
                    _localctx = AssignStmtContext(_localctx)
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 462
                        _localctx.v = ref()
                        state = 463
                        _la = _input.LA(1)
                        if (!(_la and 0x3f.inv() == 0 && 1L shl _la and 8257536L != 0L)) {
                            _errHandler.recoverInline(this)
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true
                            _errHandler.reportMatch(this)
                            consume()
                        }
                        state = 464
                        expr(0)
                        state = 465
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

    open class RefContext : ParserRuleContext {
        constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState)

        override fun getRuleIndex(): Int {
            return RULE_ref
        }

        constructor()

        fun copyFrom(ctx: RefContext?) {
            super.copyFrom(ctx)
        }
    }

    class IndexRefContext(ctx: RefContext?) : RefContext() {
        var base: ExprContext? = null
        fun BR_OPEN(): TerminalNode {
            return getToken(BR_OPEN, 0)
        }

        fun expr(): List<ExprContext> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        fun BR_CLOSE(): TerminalNode {
            return getToken(BR_CLOSE, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitIndexRef(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class NameRefContext(ctx: RefContext?) : RefContext() {
        var name: Token? = null
        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitNameRef(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class DotRefContext(ctx: RefContext?) : RefContext() {
        var base: ExprContext? = null
        var name: Token? = null
        fun DOT(): TerminalNode {
            return getToken(DOT, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDotRef(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun ref(): RefContext {
        var _localctx = RefContext(_ctx, state)
        enterRule(_localctx, 48, RULE_ref)
        try {
            state = 479
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 51, _ctx)) {
                1 -> {
                    _localctx = DotRefContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 469
                        (_localctx as DotRefContext).base = expr(0)
                        state = 470
                        match(DOT)
                        state = 471
                        (_localctx as DotRefContext).name = match(IDENTIFIER)
                    }
                }

                2 -> {
                    _localctx = IndexRefContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 473
                        (_localctx as IndexRefContext).base = expr(0)
                        state = 474
                        match(BR_OPEN)
                        state = 475
                        expr(0)
                        state = 476
                        match(BR_CLOSE)
                    }
                }

                3 -> {
                    _localctx = NameRefContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 478
                        _localctx.name = match(IDENTIFIER)
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

    class ArgsContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
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
            return RULE_args
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitArgs(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun args(): ArgsContext {
        val _localctx = ArgsContext(_ctx, state)
        enterRule(_localctx, 50, RULE_args)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 489
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la - 25 and 0x3f.inv() == 0 && 1L shl _la - 25 and 33878970466305L != 0L) {
                    run {
                        state = 481
                        expr(0)
                        state = 486
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la == COMMA) {
                            run {
                                run {
                                    state = 482
                                    match(COMMA)
                                    state = 483
                                    expr(0)
                                }
                            }
                            state = 488
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
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

    class IndexExprContext(ctx: ExprContext?) : ExprContext() {
        var base: ExprContext? = null
        fun BR_OPEN(): TerminalNode {
            return getToken(BR_OPEN, 0)
        }

        fun expr(): List<ExprContext> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        fun BR_CLOSE(): TerminalNode {
            return getToken(BR_CLOSE, 0)
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

    class DotExprContext(ctx: ExprContext?) : ExprContext() {
        var base: ExprContext? = null
        var name: Token? = null
        fun DOT(): TerminalNode {
            return getToken(DOT, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDotExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class AddExprContext(ctx: ExprContext?) : ExprContext() {
        fun expr(): List<ExprContext> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        fun PLUS(): TerminalNode {
            return getToken(PLUS, 0)
        }

        fun MINUS(): TerminalNode {
            return getToken(MINUS, 0)
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

    class CompExprContext(ctx: ExprContext?) : ExprContext() {
        fun expr(): List<ExprContext> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        fun GT(): TerminalNode {
            return getToken(GT, 0)
        }

        fun LT(): TerminalNode {
            return getToken(LT, 0)
        }

        fun GE(): TerminalNode {
            return getToken(GE, 0)
        }

        fun LE(): TerminalNode {
            return getToken(LE, 0)
        }

        fun EQ(): TerminalNode {
            return getToken(EQ, 0)
        }

        fun NE(): TerminalNode {
            return getToken(NE, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitCompExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class FunctionCallExprContext(ctx: ExprContext?) : ExprContext() {
        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun args(): ArgsContext {
            return getRuleContext(ArgsContext::class.java, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitFunctionCallExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class BoolExprContext(ctx: ExprContext?) : ExprContext() {
        fun expr(): List<ExprContext> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        fun AND(): TerminalNode {
            return getToken(AND, 0)
        }

        fun OR(): TerminalNode {
            return getToken(OR, 0)
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

    class MultExprContext(ctx: ExprContext?) : ExprContext() {
        fun expr(): List<ExprContext> {
            return getRuleContexts(ExprContext::class.java)
        }

        fun expr(i: Int): ExprContext {
            return getRuleContext(ExprContext::class.java, i)
        }

        fun MULT(): TerminalNode {
            return getToken(MULT, 0)
        }

        fun DIV(): TerminalNode {
            return getToken(DIV, 0)
        }

        fun MOD(): TerminalNode {
            return getToken(MOD, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMultExpr(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class ParenExprContext(ctx: ExprContext?) : ExprContext() {
        fun P_OPEN(): TerminalNode {
            return getToken(P_OPEN, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun P_CLOSE(): TerminalNode {
            return getToken(P_CLOSE, 0)
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

    class IdentifierExprContext(ctx: ExprContext?) : ExprContext() {
        var name: Token? = null
        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitIdentifierExpr(
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
        val _startState = 52
        enterRecursionRule(_localctx, 52, RULE_expr, _p)
        var _la: Int
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                state = 503
                _errHandler.sync(this)
                when (interpreter.adaptivePredict(_input, 54, _ctx)) {
                    1 -> {
                        _localctx = LiteralExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 492
                        literal()
                    }

                    2 -> {
                        _localctx = IdentifierExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 493
                        (_localctx as IdentifierExprContext).name = match(IDENTIFIER)
                    }

                    3 -> {
                        _localctx = FunctionCallExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 494
                        match(IDENTIFIER)
                        state = 495
                        match(P_OPEN)
                        state = 496
                        args()
                        state = 497
                        match(P_CLOSE)
                    }

                    4 -> {
                        _localctx = ParenExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 499
                        match(P_OPEN)
                        state = 500
                        expr(0)
                        state = 501
                        match(P_CLOSE)
                    }
                }
                _ctx.stop = _input.LT(-1)
                state = 527
                _errHandler.sync(this)
                _alt = interpreter.adaptivePredict(_input, 56, _ctx)
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent()
                        _prevctx = _localctx
                        run {
                            state = 525
                            _errHandler.sync(this)
                            when (interpreter.adaptivePredict(_input, 55, _ctx)) {
                                1 -> {
                                    _localctx =
                                        MultExprContext(ExprContext(_parentctx, _parentState))
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 505
                                    if (!precpred(_ctx, 4)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 4)"
                                    )
                                    state = 506
                                    _la = _input.LA(1)
                                    if (!(_la and 0x3f.inv() == 0 && 1L shl _la and 112L != 0L)) {
                                        _errHandler.recoverInline(this)
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                    state = 507
                                    expr(5)
                                }

                                2 -> {
                                    _localctx =
                                        AddExprContext(ExprContext(_parentctx, _parentState))
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 508
                                    if (!precpred(_ctx, 3)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 3)"
                                    )
                                    state = 509
                                    _la = _input.LA(1)
                                    if (!(_la == PLUS || _la == MINUS)) {
                                        _errHandler.recoverInline(this)
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                    state = 510
                                    expr(4)
                                }

                                3 -> {
                                    _localctx =
                                        CompExprContext(ExprContext(_parentctx, _parentState))
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 511
                                    if (!precpred(_ctx, 2)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 2)"
                                    )
                                    state = 512
                                    _la = _input.LA(1)
                                    if (!(_la and 0x3f.inv() == 0 && 1L shl _la and 32256L != 0L)) {
                                        _errHandler.recoverInline(this)
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                    state = 513
                                    expr(3)
                                }

                                4 -> {
                                    _localctx =
                                        BoolExprContext(ExprContext(_parentctx, _parentState))
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 514
                                    if (!precpred(_ctx, 1)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 1)"
                                    )
                                    state = 515
                                    _la = _input.LA(1)
                                    if (!(_la == AND || _la == OR)) {
                                        _errHandler.recoverInline(this)
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                    state = 516
                                    expr(2)
                                }

                                5 -> {
                                    _localctx =
                                        DotExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as DotExprContext).base = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 517
                                    if (!precpred(_ctx, 8)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 8)"
                                    )
                                    state = 518
                                    match(DOT)
                                    state = 519
                                    (_localctx as DotExprContext).name = match(IDENTIFIER)
                                }

                                6 -> {
                                    _localctx =
                                        IndexExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as IndexExprContext).base = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 520
                                    if (!precpred(_ctx, 7)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 7)"
                                    )
                                    state = 521
                                    match(BR_OPEN)
                                    state = 522
                                    expr(0)
                                    state = 523
                                    match(BR_CLOSE)
                                }

                                else -> {}
                            }
                        }
                    }
                    state = 529
                    _errHandler.sync(this)
                    _alt = interpreter.adaptivePredict(_input, 56, _ctx)
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

    class CurrencyLitContext(ctx: LiteralContext?) : LiteralContext() {
        fun CURRENCY_LIT(): TerminalNode {
            return getToken(CURRENCY_LIT, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitCurrencyLit(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class StringLitContext(ctx: LiteralContext?) : LiteralContext() {
        fun description(): DescriptionContext {
            return getRuleContext(DescriptionContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitStringLit(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class WeightLitContext(ctx: LiteralContext?) : LiteralContext() {
        fun WEIGHT_LIT(): TerminalNode {
            return getToken(WEIGHT_LIT, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitWeightLit(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class NumberLitContext(ctx: LiteralContext?) : LiteralContext() {
        fun NUMBER(): TerminalNode {
            return getToken(NUMBER, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitNumberLit(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class RawDiceLitContext(ctx: LiteralContext?) : LiteralContext() {
        fun DICE_LIT(): TerminalNode {
            return getToken(DICE_LIT, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitRawDiceLit(
                this
            ) else visitor.visitChildren(this)
        }
    }

    class DistanceLitContext(ctx: LiteralContext?) : LiteralContext() {
        fun DIST_LIT(): TerminalNode {
            return getToken(DIST_LIT, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDistanceLit(
                this
            ) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun literal(): LiteralContext {
        var _localctx = LiteralContext(_ctx, state)
        enterRule(_localctx, 54, RULE_literal)
        try {
            state = 536
            _errHandler.sync(this)
            when (_input.LA(1)) {
                NUMBER -> {
                    _localctx = NumberLitContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 530
                        match(NUMBER)
                    }
                }

                DICE_LIT -> {
                    _localctx = RawDiceLitContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 531
                        match(DICE_LIT)
                    }
                }

                DIST_LIT -> {
                    _localctx = DistanceLitContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 532
                        match(DIST_LIT)
                    }
                }

                CURRENCY_LIT -> {
                    _localctx = CurrencyLitContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 533
                        match(CURRENCY_LIT)
                    }
                }

                WEIGHT_LIT -> {
                    _localctx = WeightLitContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 534
                        match(WEIGHT_LIT)
                    }
                }

                STRINGS, STRING_LIT -> {
                    _localctx = StringLitContext(_localctx)
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 535
                        description()
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
        enterRule(_localctx, 56, RULE_description)
        try {
            state = 542
            _errHandler.sync(this)
            when (_input.LA(1)) {
                STRING_LIT -> {
                    _localctx = StringDescrContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 538
                        match(STRING_LIT)
                    }
                }

                STRINGS -> {
                    _localctx = RefDescrContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 539
                        match(STRINGS)
                        state = 540
                        match(DOT)
                        state = 541
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

    override fun sempred(_localctx: RuleContext, ruleIndex: Int, predIndex: Int): Boolean {
        when (ruleIndex) {
            26 -> return expr_sempred(_localctx as ExprContext, predIndex)
        }
        return true
    }

    private fun expr_sempred(_localctx: ExprContext, predIndex: Int): Boolean {
        when (predIndex) {
            0 -> return precpred(_ctx, 4)
            1 -> return precpred(_ctx, 3)
            2 -> return precpred(_ctx, 2)
            3 -> return precpred(_ctx, 1)
            4 -> return precpred(_ctx, 8)
            5 -> return precpred(_ctx, 7)
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
        const val DOT = 1
        const val SEMI = 2
        const val COMMA = 3
        const val MULT = 4
        const val DIV = 5
        const val MOD = 6
        const val PLUS = 7
        const val MINUS = 8
        const val GT = 9
        const val LT = 10
        const val GE = 11
        const val LE = 12
        const val EQ = 13
        const val NE = 14
        const val AND = 15
        const val OR = 16
        const val ASSIGN = 17
        const val PLUS_ASSIGN = 18
        const val MINUS_ASSIGN = 19
        const val MULT_ASSIGN = 20
        const val DIV_ASSIGN = 21
        const val MOD_ASSIGN = 22
        const val BLOCK = 23
        const val END = 24
        const val P_OPEN = 25
        const val P_CLOSE = 26
        const val BR_OPEN = 27
        const val BR_CLOSE = 28
        const val FS_SEP = 29
        const val D = 30
        const val CP = 31
        const val FT = 32
        const val GP = 33
        const val IF = 34
        const val LB = 35
        const val IN = 36
        const val PP = 37
        const val SP = 38
        const val FOR = 39
        const val FUN = 40
        const val ELSE = 41
        const val ITEM = 42
        const val RACE = 43
        const val CLASS = 44
        const val SKILL = 45
        const val SPELL = 46
        const val TRAIT = 47
        const val WHILE = 48
        const val DAMAGE = 49
        const val ENABLE = 50
        const val SOURCE = 51
        const val ABILITY = 52
        const val STRINGS = 53
        const val SUBRACE = 54
        const val SUBCLASS = 55
        const val ITEM_TAG = 56
        const val ITEM_TRAIT = 57
        const val BACKGROUND = 58
        const val DEPENDS_ON = 59
        const val ALLOW_SUBRACE = 60
        const val NUMBER = 61
        const val AUTO_TARGETS = 62
        const val DICE_LIT = 63
        const val DIST_LIT = 64
        const val CURRENCY = 65
        const val CURRENCY_LIT = 66
        const val WEIGHT_LIT = 67
        const val IDENTIFIER = 68
        const val STRING_LIT = 69
        const val NEWLINE = 70
        const val WS = 71
        const val COMMENT = 72
        const val ML_COMMENT = 73
        const val ANY = 74
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
        const val RULE_traitDecl = 16
        const val RULE_itemTagDecl = 17
        const val RULE_itemTraitDecl = 18
        const val RULE_damageDecl = 19
        const val RULE_declBody = 20
        const val RULE_funDecl = 21
        const val RULE_identifierSet = 22
        const val RULE_stmt = 23
        const val RULE_ref = 24
        const val RULE_args = 25
        const val RULE_expr = 26
        const val RULE_literal = 27
        const val RULE_description = 28
        private fun makeRuleNames(): Array<String> {
            return arrayOf(
                "strings", "singleString", "mageProg", "header", "setStrings", "enables",
                "topLevel", "classDecl", "raceDecl", "subclassDecl", "subRaceDecl", "itemDecl",
                "spellDecl", "backgroundDecl", "abilityDecl", "skillDecl", "traitDecl",
                "itemTagDecl", "itemTraitDecl", "damageDecl", "declBody", "funDecl",
                "identifierSet", "stmt", "ref", "args", "expr", "literal", "description"
            )
        }

        val ruleNames = makeRuleNames()
        private fun makeLiteralNames(): Array<String?> {
            return arrayOf(
                null, "'.'", "';'", "','", "'*'", "'/'", "'%'", "'+'", "'-'", "'>'",
                "'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "'='", "'+='",
                "'-='", "'*='", "'/='", "'%='", "'{'", "'}'", "'('", "')'", "'['", "']'",
                "'#~#'", null, "'cp'", "'ft'", "'gp'", "'if'", "'lb'", "'in'", "'pp'",
                "'sp'", "'for'", "'fun'", "'else'", "'item'", "'race'", "'class'", "'skill'",
                "'spell'", "'trait'", "'while'", "'damage'", "'enable'", "'source'",
                "'ability'", "'strings'", "'subrace'", "'subclass'", "'item_tag'", "'item_trait'",
                "'background'", "'depends on'", "'allow subrace'"
            )
        }

        private val _LITERAL_NAMES = makeLiteralNames()
        private fun makeSymbolicNames(): Array<String?> {
            return arrayOf(
                null, "DOT", "SEMI", "COMMA", "MULT", "DIV", "MOD", "PLUS", "MINUS",
                "GT", "LT", "GE", "LE", "EQ", "NE", "AND", "OR", "ASSIGN", "PLUS_ASSIGN",
                "MINUS_ASSIGN", "MULT_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", "BLOCK", "END",
                "P_OPEN", "P_CLOSE", "BR_OPEN", "BR_CLOSE", "FS_SEP", "D", "CP", "FT",
                "GP", "IF", "LB", "IN", "PP", "SP", "FOR", "FUN", "ELSE", "ITEM", "RACE",
                "CLASS", "SKILL", "SPELL", "TRAIT", "WHILE", "DAMAGE", "ENABLE", "SOURCE",
                "ABILITY", "STRINGS", "SUBRACE", "SUBCLASS", "ITEM_TAG", "ITEM_TRAIT",
                "BACKGROUND", "DEPENDS_ON", "ALLOW_SUBRACE", "NUMBER", "AUTO_TARGETS",
                "DICE_LIT", "DIST_LIT", "CURRENCY", "CURRENCY_LIT", "WEIGHT_LIT", "IDENTIFIER",
                "STRING_LIT", "NEWLINE", "WS", "COMMENT", "ML_COMMENT", "ANY"
            )
        }

        private val _SYMBOLIC_NAMES = makeSymbolicNames()
        val VOCABULARY: Vocabulary = VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES)

        @Deprecated("Use {@link #VOCABULARY} instead.")
        val tokenNames = _SYMBOLIC_NAMES.indices.map {
            VOCABULARY.getLiteralName(it) ?: VOCABULARY.getSymbolicName(it) ?: "<INVALID>"
        }.toTypedArray()

        const val _serializedATN =
            "\u0004\u0001J\u0221\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
                    "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
                    "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
                    "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002" +
                    "\u000c\u0007\u000c\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f" +
                    "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012" +
                    "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015" +
                    "\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018" +
                    "\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b" +
                    "\u0002\u001c\u0007\u001c\u0001\u0000\u0005\u0000<\b\u0000\n\u0000\u000c\u0000" +
                    "?\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001" +
                    "\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002J\b\u0002" +
                    "\n\u0002\u000c\u0002M\t\u0002\u0001\u0002\u0005\u0002P\b\u0002\n\u0002\u000c\u0002" +
                    "S\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003^\b\u0003" +
                    "\n\u0003\u000c\u0003a\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003" +
                    "l\b\u0003\n\u0003\u000c\u0003o\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003" +
                    "s\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0005\u0004z\b\u0004\n\u0004\u000c\u0004}\t\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0005\u0001\u0005\u0005\u0005\u0083\b\u0005\n\u0005\u000c\u0005\u0086" +
                    "\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001" +
                    "\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001" +
                    "\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0098" +
                    "\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u009d\b\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a3\b\u0007" +
                    "\u0001\u0007\u0001\u0007\u0005\u0007\u00a7\b\u0007\n\u0007\u000c\u0007\u00aa" +
                    "\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u00b1" +
                    "\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b7\b\b\u0001\b\u0003\b" +
                    "\u00ba\b\b\u0001\b\u0001\b\u0005\b\u00be\b\b\n\b\u000c\b\u00c1\t\b\u0001\b" +
                    "\u0001\b\u0001\t\u0001\t\u0001\t\u0003\t\u00c8\b\t\u0001\t\u0001\t\u0001" +
                    "\t\u0001\t\u0001\t\u0001\t\u0003\t\u00d0\b\t\u0001\t\u0001\t\u0005\t\u00d4" +
                    "\b\t\n\t\u000c\t\u00d7\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n" +
                    "\u00de\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00e6" +
                    "\b\n\u0001\n\u0001\n\u0005\n\u00ea\b\n\n\n\u000c\n\u00ed\t\n\u0001\n\u0001" +
                    "\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00f4\b\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00fa\b\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0106\b\u000b\n" +
                    "\u000b\u000c\u000b\u0109\t\u000b\u0001\u000b\u0001\u000b\u0001\u000c\u0001\u000c\u0001" +
                    "\u000c\u0003\u000c\u0110\b\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0003\u000c\u0116\b\u000c" +
                    "\u0001\u000c\u0001\u000c\u0005\u000c\u011a\b\u000c\n\u000c\u000c\u000c\u011d\t\u000c\u0001\u000c\u0001\u000c\u0001" +
                    "\r\u0001\r\u0001\r\u0003\r\u0124\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003" +
                    "\r\u012a\b\r\u0001\r\u0001\r\u0005\r\u012e\b\r\n\r\u000c\r\u0131\t\r\u0001" +
                    "\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0138\b\u000e" +
                    "\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u013e\b\u000e" +
                    "\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f" +
                    "\u0145\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f" +
                    "\u014b\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010" +
                    "\u0001\u0010\u0001\u0010\u0003\u0010\u0154\b\u0010\u0001\u0010\u0001\u0010" +
                    "\u0001\u0010\u0001\u0010\u0003\u0010\u015a\b\u0010\u0001\u0010\u0001\u0010" +
                    "\u0005\u0010\u015e\b\u0010\n\u0010\u000c\u0010\u0161\t\u0010\u0001\u0010\u0001" +
                    "\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0168\b\u0011\u0001" +
                    "\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u016e\b\u0011\u0001" +
                    "\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0175" +
                    "\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u017b" +
                    "\b\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u017f\b\u0012\n\u0012\u000c\u0012" +
                    "\u0182\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013" +
                    "\u0003\u0013\u0189\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013" +
                    "\u0003\u0013\u018f\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014" +
                    "\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015" +
                    "\u0001\u0015\u0005\u0015\u019c\b\u0015\n\u0015\u000c\u0015\u019f\t\u0015\u0001" +
                    "\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u01a6" +
                    "\b\u0016\n\u0016\u000c\u0016\u01a9\t\u0016\u0003\u0016\u01ab\b\u0016\u0001" +
                    "\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u01b2" +
                    "\b\u0017\n\u0017\u000c\u0017\u01b5\t\u0017\u0001\u0017\u0001\u0017\u0001\u0017" +
                    "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017" +
                    "\u01bf\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017" +
                    "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017" +
                    "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017" +
                    "\u0001\u0017\u0001\u0017\u0003\u0017\u01d4\b\u0017\u0001\u0018\u0001\u0018" +
                    "\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018" +
                    "\u0001\u0018\u0001\u0018\u0003\u0018\u01e0\b\u0018\u0001\u0019\u0001\u0019" +
                    "\u0001\u0019\u0005\u0019\u01e5\b\u0019\n\u0019\u000c\u0019\u01e8\t\u0019\u0003" +
                    "\u0019\u01ea\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001" +
                    "\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001" +
                    "\u001a\u0001\u001a\u0003\u001a\u01f8\b\u001a\u0001\u001a\u0001\u001a\u0001" +
                    "\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001" +
                    "\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001" +
                    "\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005" +
                    "\u001a\u020e\b\u001a\n\u001a\u000c\u001a\u0211\t\u001a\u0001\u001b\u0001\u001b" +
                    "\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0219\b\u001b" +
                    "\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u021f\b\u001c" +
                    "\u0001\u001c\u0000\u00014\u001d\u0000\u0002\u0004\u0006\b\n\u000c\u000e\u0010" +
                    "\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468\u0000\u0005\u0001" +
                    "\u0000\u0011\u0016\u0001\u0000\u0004\u0006\u0001\u0000\u0007\b\u0001\u0000" +
                    "\t\u000e\u0001\u0000\u000f\u0010\u025b\u0000=\u0001\u0000\u0000\u0000" +
                    "\u0002B\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006r" +
                    "\u0001\u0000\u0000\u0000\bt\u0001\u0000\u0000\u0000\n\u0080\u0001\u0000" +
                    "\u0000\u0000\u000c\u0097\u0001\u0000\u0000\u0000\u000e\u0099\u0001\u0000\u0000" +
                    "\u0000\u0010\u00ad\u0001\u0000\u0000\u0000\u0012\u00c4\u0001\u0000\u0000" +
                    "\u0000\u0014\u00da\u0001\u0000\u0000\u0000\u0016\u00f0\u0001\u0000\u0000" +
                    "\u0000\u0018\u010c\u0001\u0000\u0000\u0000\u001a\u0120\u0001\u0000\u0000" +
                    "\u0000\u001c\u0134\u0001\u0000\u0000\u0000\u001e\u0141\u0001\u0000\u0000" +
                    "\u0000 \u0150\u0001\u0000\u0000\u0000\"\u0164\u0001\u0000\u0000\u0000" +
                    "$\u0171\u0001\u0000\u0000\u0000&\u0185\u0001\u0000\u0000\u0000(\u0192" +
                    "\u0001\u0000\u0000\u0000*\u0194\u0001\u0000\u0000\u0000,\u01aa\u0001\u0000" +
                    "\u0000\u0000.\u01d3\u0001\u0000\u0000\u00000\u01df\u0001\u0000\u0000\u0000" +
                    "2\u01e9\u0001\u0000\u0000\u00004\u01f7\u0001\u0000\u0000\u00006\u0218" +
                    "\u0001\u0000\u0000\u00008\u021e\u0001\u0000\u0000\u0000:<\u0003\u0002" +
                    "\u0001\u0000;:\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001" +
                    "\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001\u0000\u0000\u0000" +
                    "?=\u0001\u0000\u0000\u0000@A\u0005\u0000\u0000\u0001A\u0001\u0001\u0000" +
                    "\u0000\u0000BC\u0005D\u0000\u0000CD\u0005\u0011\u0000\u0000DE\u0005E\u0000" +
                    "\u0000EF\u0005\u0002\u0000\u0000F\u0003\u0001\u0000\u0000\u0000GK\u0003" +
                    "\u0006\u0003\u0000HJ\u0003\n\u0005\u0000IH\u0001\u0000\u0000\u0000JM\u0001" +
                    "\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000" +
                    "LQ\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NP\u0003\u000c\u0006\u0000" +
                    "ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000" +
                    "\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001\u0000" +
                    "\u0000\u0000TU\u0005\u0000\u0000\u0001U\u0005\u0001\u0000\u0000\u0000" +
                    "VW\u00053\u0000\u0000WX\u0005D\u0000\u0000Xs\u0005\u0002\u0000\u0000Y" +
                    "Z\u00053\u0000\u0000Z[\u0005D\u0000\u0000[_\u0005;\u0000\u0000\\^\u0005" +
                    "E\u0000\u0000]\\\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001" +
                    "\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000" +
                    "a_\u0001\u0000\u0000\u0000bs\u0005\u0002\u0000\u0000cd\u00053\u0000\u0000" +
                    "de\u0005D\u0000\u0000ef\u0005\u0002\u0000\u0000fs\u0003\b\u0004\u0000" +
                    "gh\u00053\u0000\u0000hi\u0005D\u0000\u0000im\u0005;\u0000\u0000jl\u0005" +
                    "E\u0000\u0000kj\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000\u0000mk\u0001" +
                    "\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000np\u0001\u0000\u0000\u0000" +
                    "om\u0001\u0000\u0000\u0000pq\u0005\u0002\u0000\u0000qs\u0003\b\u0004\u0000" +
                    "rV\u0001\u0000\u0000\u0000rY\u0001\u0000\u0000\u0000rc\u0001\u0000\u0000" +
                    "\u0000rg\u0001\u0000\u0000\u0000s\u0007\u0001\u0000\u0000\u0000tu\u0005" +
                    "5\u0000\u0000uv\u0005$\u0000\u0000v{\u0005E\u0000\u0000wx\u0005\u0003" +
                    "\u0000\u0000xz\u0005E\u0000\u0000yw\u0001\u0000\u0000\u0000z}\u0001\u0000" +
                    "\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0001" +
                    "\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u007f\u0005\u0002\u0000" +
                    "\u0000\u007f\t\u0001\u0000\u0000\u0000\u0080\u0084\u00052\u0000\u0000" +
                    "\u0081\u0083\u0005>\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083" +
                    "\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084" +
                    "\u0085\u0001\u0000\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086" +
                    "\u0084\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0002\u0000\u0000\u0088" +
                    "\u000b\u0001\u0000\u0000\u0000\u0089\u0098\u0003\u000e\u0007\u0000\u008a" +
                    "\u0098\u0003\u0010\b\u0000\u008b\u0098\u0003\u0012\t\u0000\u008c\u0098" +
                    "\u0003\u0014\n\u0000\u008d\u0098\u0003\u0016\u000b\u0000\u008e\u0098\u0003" +
                    "\u0018\u000c\u0000\u008f\u0098\u0003\u001a\r\u0000\u0090\u0098\u0003\u001c" +
                    "\u000e\u0000\u0091\u0098\u0003\u001e\u000f\u0000\u0092\u0098\u0003 \u0010" +
                    "\u0000\u0093\u0098\u0003$\u0012\u0000\u0094\u0098\u0003&\u0013\u0000\u0095" +
                    "\u0098\u0003\"\u0011\u0000\u0096\u0098\u0003*\u0015\u0000\u0097\u0089" +
                    "\u0001\u0000\u0000\u0000\u0097\u008a\u0001\u0000\u0000\u0000\u0097\u008b" +
                    "\u0001\u0000\u0000\u0000\u0097\u008c\u0001\u0000\u0000\u0000\u0097\u008d" +
                    "\u0001\u0000\u0000\u0000\u0097\u008e\u0001\u0000\u0000\u0000\u0097\u008f" +
                    "\u0001\u0000\u0000\u0000\u0097\u0090\u0001\u0000\u0000\u0000\u0097\u0091" +
                    "\u0001\u0000\u0000\u0000\u0097\u0092\u0001\u0000\u0000\u0000\u0097\u0093" +
                    "\u0001\u0000\u0000\u0000\u0097\u0094\u0001\u0000\u0000\u0000\u0097\u0095" +
                    "\u0001\u0000\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\r\u0001" +
                    "\u0000\u0000\u0000\u0099\u009a\u0005,\u0000\u0000\u009a\u009c\u0005D\u0000" +
                    "\u0000\u009b\u009d\u00038\u001c\u0000\u009c\u009b\u0001\u0000\u0000\u0000" +
                    "\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u00a2\u0001\u0000\u0000\u0000" +
                    "\u009e\u009f\u0005\u0019\u0000\u0000\u009f\u00a0\u00038\u001c\u0000\u00a0" +
                    "\u00a1\u0005\u001a\u0000\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2" +
                    "\u009e\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3" +
                    "\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a8\u0005\u0017\u0000\u0000\u00a5" +
                    "\u00a7\u0003(\u0014\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u00aa" +
                    "\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9" +
                    "\u0001\u0000\u0000\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa\u00a8" +
                    "\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u0018\u0000\u0000\u00ac\u000f" +
                    "\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005+\u0000\u0000\u00ae\u00b0\u0005" +
                    "D\u0000\u0000\u00af\u00b1\u00038\u001c\u0000\u00b0\u00af\u0001\u0000\u0000" +
                    "\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b6\u0001\u0000\u0000" +
                    "\u0000\u00b2\u00b3\u0005\u0019\u0000\u0000\u00b3\u00b4\u00038\u001c\u0000" +
                    "\u00b4\u00b5\u0005\u001a\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000" +
                    "\u00b6\u00b2\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000" +
                    "\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8\u00ba\u0005<\u0000\u0000\u00b9" +
                    "\u00b8\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba" +
                    "\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bf\u0005\u0017\u0000\u0000\u00bc" +
                    "\u00be\u0003(\u0014\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u00c1" +
                    "\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0" +
                    "\u0001\u0000\u0000\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00bf" +
                    "\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\u0018\u0000\u0000\u00c3\u0011" +
                    "\u0001\u0000\u0000\u0000\u00c4\u00c5\u00057\u0000\u0000\u00c5\u00c7\u0005" +
                    "D\u0000\u0000\u00c6\u00c8\u00038\u001c\u0000\u00c7\u00c6\u0001\u0000\u0000" +
                    "\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000" +
                    "\u0000\u00c9\u00ca\u0005\'\u0000\u0000\u00ca\u00cf\u0005D\u0000\u0000" +
                    "\u00cb\u00cc\u0005\u0019\u0000\u0000\u00cc\u00cd\u00038\u001c\u0000\u00cd" +
                    "\u00ce\u0005\u001a\u0000\u0000\u00ce\u00d0\u0001\u0000\u0000\u0000\u00cf" +
                    "\u00cb\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0" +
                    "\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d5\u0005\u0017\u0000\u0000\u00d2" +
                    "\u00d4\u0003(\u0014\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d7" +
                    "\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6" +
                    "\u0001\u0000\u0000\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d5" +
                    "\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u0018\u0000\u0000\u00d9\u0013" +
                    "\u0001\u0000\u0000\u0000\u00da\u00db\u00056\u0000\u0000\u00db\u00dd\u0005" +
                    "D\u0000\u0000\u00dc\u00de\u00038\u001c\u0000\u00dd\u00dc\u0001\u0000\u0000" +
                    "\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000" +
                    "\u0000\u00df\u00e0\u0005\'\u0000\u0000\u00e0\u00e5\u0005D\u0000\u0000" +
                    "\u00e1\u00e2\u0005\u0019\u0000\u0000\u00e2\u00e3\u00038\u001c\u0000\u00e3" +
                    "\u00e4\u0005\u001a\u0000\u0000\u00e4\u00e6\u0001\u0000\u0000\u0000\u00e5" +
                    "\u00e1\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6" +
                    "\u00e7\u0001\u0000\u0000\u0000\u00e7\u00eb\u0005\u0017\u0000\u0000\u00e8" +
                    "\u00ea\u0003(\u0014\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00ea\u00ed" +
                    "\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec" +
                    "\u0001\u0000\u0000\u0000\u00ec\u00ee\u0001\u0000\u0000\u0000\u00ed\u00eb" +
                    "\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005\u0018\u0000\u0000\u00ef\u0015" +
                    "\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005*\u0000\u0000\u00f1\u00f3\u0005" +
                    "D\u0000\u0000\u00f2\u00f4\u00038\u001c\u0000\u00f3\u00f2\u0001\u0000\u0000" +
                    "\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f9\u0001\u0000\u0000" +
                    "\u0000\u00f5\u00f6\u0005\u0019\u0000\u0000\u00f6\u00f7\u00038\u001c\u0000" +
                    "\u00f7\u00f8\u0005\u001a\u0000\u0000\u00f8\u00fa\u0001\u0000\u0000\u0000" +
                    "\u00f9\u00f5\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000" +
                    "\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005B\u0000\u0000\u00fc" +
                    "\u00fd\u0005C\u0000\u0000\u00fd\u00fe\u0005\u0019\u0000\u0000\u00fe\u00ff" +
                    "\u0003,\u0016\u0000\u00ff\u0100\u0005\u001a\u0000\u0000\u0100\u0101\u0005" +
                    "\u001b\u0000\u0000\u0101\u0102\u0003,\u0016\u0000\u0102\u0103\u0005\u001c" +
                    "\u0000\u0000\u0103\u0107\u0005\u0017\u0000\u0000\u0104\u0106\u0003(\u0014" +
                    "\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0106\u0109\u0001\u0000\u0000" +
                    "\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000" +
                    "\u0000\u0108\u010a\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000" +
                    "\u0000\u010a\u010b\u0005\u0018\u0000\u0000\u010b\u0017\u0001\u0000\u0000" +
                    "\u0000\u010c\u010d\u0005.\u0000\u0000\u010d\u010f\u0005D\u0000\u0000\u010e" +
                    "\u0110\u00038\u001c\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u010f\u0110" +
                    "\u0001\u0000\u0000\u0000\u0110\u0115\u0001\u0000\u0000\u0000\u0111\u0112" +
                    "\u0005\u0019\u0000\u0000\u0112\u0113\u00038\u001c\u0000\u0113\u0114\u0005" +
                    "\u001a\u0000\u0000\u0114\u0116\u0001\u0000\u0000\u0000\u0115\u0111\u0001" +
                    "\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0117\u0001" +
                    "\u0000\u0000\u0000\u0117\u011b\u0005\u0017\u0000\u0000\u0118\u011a\u0003" +
                    "(\u0014\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u011a\u011d\u0001\u0000" +
                    "\u0000\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000" +
                    "\u0000\u0000\u011c\u011e\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000" +
                    "\u0000\u0000\u011e\u011f\u0005\u0018\u0000\u0000\u011f\u0019\u0001\u0000" +
                    "\u0000\u0000\u0120\u0121\u0005:\u0000\u0000\u0121\u0123\u0005D\u0000\u0000" +
                    "\u0122\u0124\u00038\u001c\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0123" +
                    "\u0124\u0001\u0000\u0000\u0000\u0124\u0129\u0001\u0000\u0000\u0000\u0125" +
                    "\u0126\u0005\u0019\u0000\u0000\u0126\u0127\u00038\u001c\u0000\u0127\u0128" +
                    "\u0005\u001a\u0000\u0000\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u0125" +
                    "\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u012b" +
                    "\u0001\u0000\u0000\u0000\u012b\u012f\u0005\u0017\u0000\u0000\u012c\u012e" +
                    "\u0003(\u0014\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012e\u0131\u0001" +
                    "\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130\u0001" +
                    "\u0000\u0000\u0000\u0130\u0132\u0001\u0000\u0000\u0000\u0131\u012f\u0001" +
                    "\u0000\u0000\u0000\u0132\u0133\u0005\u0018\u0000\u0000\u0133\u001b\u0001" +
                    "\u0000\u0000\u0000\u0134\u0135\u00054\u0000\u0000\u0135\u0137\u0005D\u0000" +
                    "\u0000\u0136\u0138\u00038\u001c\u0000\u0137\u0136\u0001\u0000\u0000\u0000" +
                    "\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u013d\u0001\u0000\u0000\u0000" +
                    "\u0139\u013a\u0005\u0019\u0000\u0000\u013a\u013b\u00038\u001c\u0000\u013b" +
                    "\u013c\u0005\u001a\u0000\u0000\u013c\u013e\u0001\u0000\u0000\u0000\u013d" +
                    "\u0139\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e" +
                    "\u013f\u0001\u0000\u0000\u0000\u013f\u0140\u0005\u0002\u0000\u0000\u0140" +
                    "\u001d\u0001\u0000\u0000\u0000\u0141\u0142\u0005-\u0000\u0000\u0142\u0144" +
                    "\u0005D\u0000\u0000\u0143\u0145\u00038\u001c\u0000\u0144\u0143\u0001\u0000" +
                    "\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u014a\u0001\u0000" +
                    "\u0000\u0000\u0146\u0147\u0005\u0019\u0000\u0000\u0147\u0148\u00038\u001c" +
                    "\u0000\u0148\u0149\u0005\u001a\u0000\u0000\u0149\u014b\u0001\u0000\u0000" +
                    "\u0000\u014a\u0146\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000" +
                    "\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u014d\u0005;\u0000\u0000" +
                    "\u014d\u014e\u0005D\u0000\u0000\u014e\u014f\u0005\u0002\u0000\u0000\u014f" +
                    "\u001f\u0001\u0000\u0000\u0000\u0150\u0151\u0005/\u0000\u0000\u0151\u0153" +
                    "\u0005D\u0000\u0000\u0152\u0154\u00038\u001c\u0000\u0153\u0152\u0001\u0000" +
                    "\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0159\u0001\u0000" +
                    "\u0000\u0000\u0155\u0156\u0005\u0019\u0000\u0000\u0156\u0157\u00038\u001c" +
                    "\u0000\u0157\u0158\u0005\u001a\u0000\u0000\u0158\u015a\u0001\u0000\u0000" +
                    "\u0000\u0159\u0155\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000" +
                    "\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015f\u0005\u0017\u0000" +
                    "\u0000\u015c\u015e\u0003(\u0014\u0000\u015d\u015c\u0001\u0000\u0000\u0000" +
                    "\u015e\u0161\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000" +
                    "\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0162\u0001\u0000\u0000\u0000" +
                    "\u0161\u015f\u0001\u0000\u0000\u0000\u0162\u0163\u0005\u0018\u0000\u0000" +
                    "\u0163!\u0001\u0000\u0000\u0000\u0164\u0165\u00058\u0000\u0000\u0165\u0167" +
                    "\u0005D\u0000\u0000\u0166\u0168\u00038\u001c\u0000\u0167\u0166\u0001\u0000" +
                    "\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u016d\u0001\u0000" +
                    "\u0000\u0000\u0169\u016a\u0005\u0019\u0000\u0000\u016a\u016b\u00038\u001c" +
                    "\u0000\u016b\u016c\u0005\u001a\u0000\u0000\u016c\u016e\u0001\u0000\u0000" +
                    "\u0000\u016d\u0169\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000\u0000" +
                    "\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u0170\u0005\u0002\u0000" +
                    "\u0000\u0170#\u0001\u0000\u0000\u0000\u0171\u0172\u00059\u0000\u0000\u0172" +
                    "\u0174\u0005D\u0000\u0000\u0173\u0175\u00038\u001c\u0000\u0174\u0173\u0001" +
                    "\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175\u017a\u0001" +
                    "\u0000\u0000\u0000\u0176\u0177\u0005\u0019\u0000\u0000\u0177\u0178\u0003" +
                    "8\u001c\u0000\u0178\u0179\u0005\u001a\u0000\u0000\u0179\u017b\u0001\u0000" +
                    "\u0000\u0000\u017a\u0176\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000" +
                    "\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017c\u0180\u0005\u0017" +
                    "\u0000\u0000\u017d\u017f\u0003(\u0014\u0000\u017e\u017d\u0001\u0000\u0000" +
                    "\u0000\u017f\u0182\u0001\u0000\u0000\u0000\u0180\u017e\u0001\u0000\u0000" +
                    "\u0000\u0180\u0181\u0001\u0000\u0000\u0000\u0181\u0183\u0001\u0000\u0000" +
                    "\u0000\u0182\u0180\u0001\u0000\u0000\u0000\u0183\u0184\u0005\u0018\u0000" +
                    "\u0000\u0184%\u0001\u0000\u0000\u0000\u0185\u0186\u00051\u0000\u0000\u0186" +
                    "\u0188\u0005D\u0000\u0000\u0187\u0189\u00038\u001c\u0000\u0188\u0187\u0001" +
                    "\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000\u0000\u0189\u018e\u0001" +
                    "\u0000\u0000\u0000\u018a\u018b\u0005\u0019\u0000\u0000\u018b\u018c\u0003" +
                    "8\u001c\u0000\u018c\u018d\u0005\u001a\u0000\u0000\u018d\u018f\u0001\u0000" +
                    "\u0000\u0000\u018e\u018a\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000" +
                    "\u0000\u0000\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u0191\u0005\u0002" +
                    "\u0000\u0000\u0191\'\u0001\u0000\u0000\u0000\u0192\u0193\u0003*\u0015" +
                    "\u0000\u0193)\u0001\u0000\u0000\u0000\u0194\u0195\u0005(\u0000\u0000\u0195" +
                    "\u0196\u0005D\u0000\u0000\u0196\u0197\u0005\u0019\u0000\u0000\u0197\u0198" +
                    "\u0003,\u0016\u0000\u0198\u0199\u0005\u001a\u0000\u0000\u0199\u019d\u0005" +
                    "\u0017\u0000\u0000\u019a\u019c\u0003.\u0017\u0000\u019b\u019a\u0001\u0000" +
                    "\u0000\u0000\u019c\u019f\u0001\u0000\u0000\u0000\u019d\u019b\u0001\u0000" +
                    "\u0000\u0000\u019d\u019e\u0001\u0000\u0000\u0000\u019e\u01a0\u0001\u0000" +
                    "\u0000\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u01a0\u01a1\u0005\u0018" +
                    "\u0000\u0000\u01a1+\u0001\u0000\u0000\u0000\u01a2\u01a7\u0005D\u0000\u0000" +
                    "\u01a3\u01a4\u0005\u0003\u0000\u0000\u01a4\u01a6\u0005D\u0000\u0000\u01a5" +
                    "\u01a3\u0001\u0000\u0000\u0000\u01a6\u01a9\u0001\u0000\u0000\u0000\u01a7" +
                    "\u01a5\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8" +
                    "\u01ab\u0001\u0000\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000\u01aa" +
                    "\u01a2\u0001\u0000\u0000\u0000\u01aa\u01ab\u0001\u0000\u0000\u0000\u01ab" +
                    "-\u0001\u0000\u0000\u0000\u01ac\u01ad\u00034\u001a\u0000\u01ad\u01ae\u0005" +
                    "\u0002\u0000\u0000\u01ae\u01d4\u0001\u0000\u0000\u0000\u01af\u01b3\u0005" +
                    "\u0017\u0000\u0000\u01b0\u01b2\u0003.\u0017\u0000\u01b1\u01b0\u0001\u0000" +
                    "\u0000\u0000\u01b2\u01b5\u0001\u0000\u0000\u0000\u01b3\u01b1\u0001\u0000" +
                    "\u0000\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4\u01b6\u0001\u0000" +
                    "\u0000\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b6\u01d4\u0005\u0018" +
                    "\u0000\u0000\u01b7\u01b8\u0005\"\u0000\u0000\u01b8\u01b9\u0005\u0019\u0000" +
                    "\u0000\u01b9\u01ba\u00034\u001a\u0000\u01ba\u01bb\u0005\u001a\u0000\u0000" +
                    "\u01bb\u01be\u0003.\u0017\u0000\u01bc\u01bd\u0005)\u0000\u0000\u01bd\u01bf" +
                    "\u0003.\u0017\u0000\u01be\u01bc\u0001\u0000\u0000\u0000\u01be\u01bf\u0001" +
                    "\u0000\u0000\u0000\u01bf\u01d4\u0001\u0000\u0000\u0000\u01c0\u01c1\u0005" +
                    "0\u0000\u0000\u01c1\u01c2\u0005\u0019\u0000\u0000\u01c2\u01c3\u00034\u001a" +
                    "\u0000\u01c3\u01c4\u0005\u001a\u0000\u0000\u01c4\u01c5\u0003.\u0017\u0000" +
                    "\u01c5\u01d4\u0001\u0000\u0000\u0000\u01c6\u01c7\u0005\'\u0000\u0000\u01c7" +
                    "\u01c8\u0005\u0019\u0000\u0000\u01c8\u01c9\u0005D\u0000\u0000\u01c9\u01ca" +
                    "\u0005$\u0000\u0000\u01ca\u01cb\u00034\u001a\u0000\u01cb\u01cc\u0005\u001a" +
                    "\u0000\u0000\u01cc\u01cd\u0003.\u0017\u0000\u01cd\u01d4\u0001\u0000\u0000" +
                    "\u0000\u01ce\u01cf\u00030\u0018\u0000\u01cf\u01d0\u0007\u0000\u0000\u0000" +
                    "\u01d0\u01d1\u00034\u001a\u0000\u01d1\u01d2\u0005\u0002\u0000\u0000\u01d2" +
                    "\u01d4\u0001\u0000\u0000\u0000\u01d3\u01ac\u0001\u0000\u0000\u0000\u01d3" +
                    "\u01af\u0001\u0000\u0000\u0000\u01d3\u01b7\u0001\u0000\u0000\u0000\u01d3" +
                    "\u01c0\u0001\u0000\u0000\u0000\u01d3\u01c6\u0001\u0000\u0000\u0000\u01d3" +
                    "\u01ce\u0001\u0000\u0000\u0000\u01d4/\u0001\u0000\u0000\u0000\u01d5\u01d6" +
                    "\u00034\u001a\u0000\u01d6\u01d7\u0005\u0001\u0000\u0000\u01d7\u01d8\u0005" +
                    "D\u0000\u0000\u01d8\u01e0\u0001\u0000\u0000\u0000\u01d9\u01da\u00034\u001a" +
                    "\u0000\u01da\u01db\u0005\u001b\u0000\u0000\u01db\u01dc\u00034\u001a\u0000" +
                    "\u01dc\u01dd\u0005\u001c\u0000\u0000\u01dd\u01e0\u0001\u0000\u0000\u0000" +
                    "\u01de\u01e0\u0005D\u0000\u0000\u01df\u01d5\u0001\u0000\u0000\u0000\u01df" +
                    "\u01d9\u0001\u0000\u0000\u0000\u01df\u01de\u0001\u0000\u0000\u0000\u01e0" +
                    "1\u0001\u0000\u0000\u0000\u01e1\u01e6\u00034\u001a\u0000\u01e2\u01e3\u0005" +
                    "\u0003\u0000\u0000\u01e3\u01e5\u00034\u001a\u0000\u01e4\u01e2\u0001\u0000" +
                    "\u0000\u0000\u01e5\u01e8\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001\u0000" +
                    "\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01ea\u0001\u0000" +
                    "\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e9\u01e1\u0001\u0000" +
                    "\u0000\u0000\u01e9\u01ea\u0001\u0000\u0000\u0000\u01ea3\u0001\u0000\u0000" +
                    "\u0000\u01eb\u01ec\u0006\u001a\uffff\uffff\u0000\u01ec\u01f8\u00036\u001b" +
                    "\u0000\u01ed\u01f8\u0005D\u0000\u0000\u01ee\u01ef\u0005D\u0000\u0000\u01ef" +
                    "\u01f0\u0005\u0019\u0000\u0000\u01f0\u01f1\u00032\u0019\u0000\u01f1\u01f2" +
                    "\u0005\u001a\u0000\u0000\u01f2\u01f8\u0001\u0000\u0000\u0000\u01f3\u01f4" +
                    "\u0005\u0019\u0000\u0000\u01f4\u01f5\u00034\u001a\u0000\u01f5\u01f6\u0005" +
                    "\u001a\u0000\u0000\u01f6\u01f8\u0001\u0000\u0000\u0000\u01f7\u01eb\u0001" +
                    "\u0000\u0000\u0000\u01f7\u01ed\u0001\u0000\u0000\u0000\u01f7\u01ee\u0001" +
                    "\u0000\u0000\u0000\u01f7\u01f3\u0001\u0000\u0000\u0000\u01f8\u020f\u0001" +
                    "\u0000\u0000\u0000\u01f9\u01fa\n\u0004\u0000\u0000\u01fa\u01fb\u0007\u0001" +
                    "\u0000\u0000\u01fb\u020e\u00034\u001a\u0005\u01fc\u01fd\n\u0003\u0000" +
                    "\u0000\u01fd\u01fe\u0007\u0002\u0000\u0000\u01fe\u020e\u00034\u001a\u0004" +
                    "\u01ff\u0200\n\u0002\u0000\u0000\u0200\u0201\u0007\u0003\u0000\u0000\u0201" +
                    "\u020e\u00034\u001a\u0003\u0202\u0203\n\u0001\u0000\u0000\u0203\u0204" +
                    "\u0007\u0004\u0000\u0000\u0204\u020e\u00034\u001a\u0002\u0205\u0206\n" +
                    "\b\u0000\u0000\u0206\u0207\u0005\u0001\u0000\u0000\u0207\u020e\u0005D" +
                    "\u0000\u0000\u0208\u0209\n\u0007\u0000\u0000\u0209\u020a\u0005\u001b\u0000" +
                    "\u0000\u020a\u020b\u00034\u001a\u0000\u020b\u020c\u0005\u001c\u0000\u0000" +
                    "\u020c\u020e\u0001\u0000\u0000\u0000\u020d\u01f9\u0001\u0000\u0000\u0000" +
                    "\u020d\u01fc\u0001\u0000\u0000\u0000\u020d\u01ff\u0001\u0000\u0000\u0000" +
                    "\u020d\u0202\u0001\u0000\u0000\u0000\u020d\u0205\u0001\u0000\u0000\u0000" +
                    "\u020d\u0208\u0001\u0000\u0000\u0000\u020e\u0211\u0001\u0000\u0000\u0000" +
                    "\u020f\u020d\u0001\u0000\u0000\u0000\u020f\u0210\u0001\u0000\u0000\u0000" +
                    "\u02105\u0001\u0000\u0000\u0000\u0211\u020f\u0001\u0000\u0000\u0000\u0212" +
                    "\u0219\u0005=\u0000\u0000\u0213\u0219\u0005?\u0000\u0000\u0214\u0219\u0005" +
                    "@\u0000\u0000\u0215\u0219\u0005B\u0000\u0000\u0216\u0219\u0005C\u0000" +
                    "\u0000\u0217\u0219\u00038\u001c\u0000\u0218\u0212\u0001\u0000\u0000\u0000" +
                    "\u0218\u0213\u0001\u0000\u0000\u0000\u0218\u0214\u0001\u0000\u0000\u0000" +
                    "\u0218\u0215\u0001\u0000\u0000\u0000\u0218\u0216\u0001\u0000\u0000\u0000" +
                    "\u0218\u0217\u0001\u0000\u0000\u0000\u02197\u0001\u0000\u0000\u0000\u021a" +
                    "\u021f\u0005E\u0000\u0000\u021b\u021c\u00055\u0000\u0000\u021c\u021d\u0005" +
                    "\u0001\u0000\u0000\u021d\u021f\u0005D\u0000\u0000\u021e\u021a\u0001\u0000" +
                    "\u0000\u0000\u021e\u021b\u0001\u0000\u0000\u0000\u021f9\u0001\u0000\u0000" +
                    "\u0000;=KQ_mr{\u0084\u0097\u009c\u00a2\u00a8\u00b0\u00b6\u00b9\u00bf\u00c7" +
                    "\u00cf\u00d5\u00dd\u00e5\u00eb\u00f3\u00f9\u0107\u010f\u0115\u011b\u0123" +
                    "\u0129\u012f\u0137\u013d\u0144\u014a\u0153\u0159\u015f\u0167\u016d\u0174" +
                    "\u017a\u0180\u0188\u018e\u019d\u01a7\u01aa\u01b3\u01be\u01d3\u01df\u01e6" +
                    "\u01e9\u01f7\u020d\u020f\u0218\u021e"
        val _ATN = ATNDeserializer().deserialize(_serializedATN.toCharArray())

        init {
            _decisionToDFA = (0 until _ATN.numberOfDecisions).map {
                DFA(_ATN.getDecisionState(it), it)
            }.toTypedArray()
        }
    }
}