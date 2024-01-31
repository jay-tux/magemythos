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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitStrings(this) else visitor.visitChildren(
                this
            )
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
                state = 67
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == IDENTIFIER) {
                    run {
                        run {
                            state = 64
                            singleString()
                        }
                    }
                    state = 69
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 70
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSingleString(this) else visitor.visitChildren(
                this
            )
        }
    }

    @Throws(RecognitionException::class)
    fun singleString(): SingleStringContext {
        val _localctx = SingleStringContext(_ctx, state)
        enterRule(_localctx, 2, RULE_singleString)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 72
                _localctx.key = match(IDENTIFIER)
                state = 73
                match(ASSIGN)
                state = 74
                _localctx.value = match(STRING_LIT)
                state = 75
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMageProg(this) else visitor.visitChildren(
                this
            )
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
                state = 77
                header()
                state = 81
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == ENABLE) {
                    run {
                        run {
                            state = 78
                            enables()
                        }
                    }
                    state = 83
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 87
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la and 0x3f.inv() == 0 && 1L shl _la and 563718305890697216L != 0L) {
                    run {
                        run {
                            state = 84
                            topLevel()
                        }
                    }
                    state = 89
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 90
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSourceHeader(this) else visitor.visitChildren(
                this
            )
        }
    }

    @Throws(RecognitionException::class)
    fun header(): HeaderContext {
        var _localctx = HeaderContext(_ctx, state)
        enterRule(_localctx, 6, RULE_header)
        var _la: Int
        try {
            state = 120
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 5, _ctx)) {
                1 -> {
                    _localctx = SourceHeaderContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 92
                        match(SOURCE)
                        state = 93
                        (_localctx as SourceHeaderContext).src = match(IDENTIFIER)
                        state = 94
                        match(SEMI)
                    }
                }

                2 -> {
                    _localctx = SourceHeaderDepsContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 95
                        match(SOURCE)
                        state = 96
                        (_localctx as SourceHeaderDepsContext).src = match(IDENTIFIER)
                        state = 97
                        match(DEPENDS_ON)
                        state = 101
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la == STRING_LIT) {
                            run {
                                run {
                                    state = 98
                                    (_localctx as SourceHeaderDepsContext).deps = match(STRING_LIT)
                                }
                            }
                            state = 103
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 104
                        match(SEMI)
                    }
                }

                3 -> {
                    _localctx = SourceHeaderStringsContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 105
                        match(SOURCE)
                        state = 106
                        (_localctx as SourceHeaderStringsContext).src = match(IDENTIFIER)
                        state = 107
                        match(SEMI)
                        state = 108
                        setStrings()
                    }
                }

                4 -> {
                    _localctx = SourceHeaderDepsStringsContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 109
                        match(SOURCE)
                        state = 110
                        _localctx.src = match(IDENTIFIER)
                        state = 111
                        match(DEPENDS_ON)
                        state = 115
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la == STRING_LIT) {
                            run {
                                run {
                                    state = 112
                                    _localctx.deps = match(STRING_LIT)
                                }
                            }
                            state = 117
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 118
                        match(SEMI)
                        state = 119
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSetStrings(this) else visitor.visitChildren(
                this
            )
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
                state = 122
                match(STRINGS)
                state = 123
                match(IN)
                state = 124
                _localctx.file = match(STRING_LIT)
                state = 129
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == COMMA) {
                    run {
                        run {
                            state = 125
                            match(COMMA)
                            state = 126
                            _localctx.file = match(STRING_LIT)
                        }
                    }
                    state = 131
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 132
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitEnables(this) else visitor.visitChildren(
                this
            )
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
                state = 134
                match(ENABLE)
                state = 138
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == AUTO_TARGETS) {
                    run {
                        run {
                            state = 135
                            match(AUTO_TARGETS)
                        }
                    }
                    state = 140
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 141
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndSpell(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndItem(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndItemTag(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndRace(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndAbility(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndTrait(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndSubClass(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndBg(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndItemTrait(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndSubRace(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndClass(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndDamage(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitFunction(this) else visitor.visitChildren(
                this
            )
        }
    }

    class GlobalVarContext(ctx: TopLevelContext?) : TopLevelContext() {
        fun globalDecl(): GlobalDeclContext {
            return getRuleContext(GlobalDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitGlobalVar(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDndSkill(this) else visitor.visitChildren(
                this
            )
        }
    }

    @Throws(RecognitionException::class)
    fun topLevel(): TopLevelContext {
        var _localctx = TopLevelContext(_ctx, state)
        enterRule(_localctx, 12, RULE_topLevel)
        try {
            state = 158
            _errHandler.sync(this)
            when (_input.LA(1)) {
                CLASS -> {
                    _localctx = DndClassContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 143
                        classDecl()
                    }
                }

                RACE -> {
                    _localctx = DndRaceContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 144
                        raceDecl()
                    }
                }

                SUBCLASS -> {
                    _localctx = DndSubClassContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 145
                        subclassDecl()
                    }
                }

                SUBRACE -> {
                    _localctx = DndSubRaceContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 146
                        subRaceDecl()
                    }
                }

                ITEM -> {
                    _localctx = DndItemContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 147
                        itemDecl()
                    }
                }

                SPELL -> {
                    _localctx = DndSpellContext(_localctx)
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 148
                        spellDecl()
                    }
                }

                BACKGROUND -> {
                    _localctx = DndBgContext(_localctx)
                    enterOuterAlt(_localctx, 7)
                    run {
                        state = 149
                        backgroundDecl()
                    }
                }

                ABILITY -> {
                    _localctx = DndAbilityContext(_localctx)
                    enterOuterAlt(_localctx, 8)
                    run {
                        state = 150
                        abilityDecl()
                    }
                }

                SKILL -> {
                    _localctx = DndSkillContext(_localctx)
                    enterOuterAlt(_localctx, 9)
                    run {
                        state = 151
                        skillDecl()
                    }
                }

                TRAIT -> {
                    _localctx = DndTraitContext(_localctx)
                    enterOuterAlt(_localctx, 10)
                    run {
                        state = 152
                        traitDecl()
                    }
                }

                ITEM_TRAIT -> {
                    _localctx = DndItemTraitContext(_localctx)
                    enterOuterAlt(_localctx, 11)
                    run {
                        state = 153
                        itemTraitDecl()
                    }
                }

                DAMAGE -> {
                    _localctx = DndDamageContext(_localctx)
                    enterOuterAlt(_localctx, 12)
                    run {
                        state = 154
                        damageDecl()
                    }
                }

                ITEM_TAG -> {
                    _localctx = DndItemTagContext(_localctx)
                    enterOuterAlt(_localctx, 13)
                    run {
                        state = 155
                        itemTagDecl()
                    }
                }

                FUN -> {
                    _localctx = FunctionContext(_localctx)
                    enterOuterAlt(_localctx, 14)
                    run {
                        state = 156
                        funDecl()
                    }
                }

                GLOBAL -> {
                    _localctx = GlobalVarContext(_localctx)
                    enterOuterAlt(_localctx, 15)
                    run {
                        state = 157
                        globalDecl()
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

        fun declBody(): List<MMParser.DeclBodyContext> {
            return getRuleContexts(MMParser.DeclBodyContext::class.java)
        }

        fun declBody(i: Int): MMParser.DeclBodyContext {
            return getRuleContext(MMParser.DeclBodyContext::class.java, i)
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitClassDecl(this) else visitor.visitChildren(
                this
            )
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
                state = 160
                match(CLASS)
                state = 161
                _localctx.name = match(IDENTIFIER)
                state = 163
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 162
                        _localctx.dispName = description()
                    }
                }
                state = 169
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 165
                        match(P_OPEN)
                        state = 166
                        _localctx.d = description()
                        state = 167
                        match(P_CLOSE)
                    }
                }
                state = 171
                match(BLOCK)
                state = 175
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN || _la == FIELD) {
                    run {
                        run {
                            state = 172
                            declBody()
                        }
                    }
                    state = 177
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 178
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

        fun declBody(): List<MMParser.DeclBodyContext> {
            return getRuleContexts(MMParser.DeclBodyContext::class.java)
        }

        fun declBody(i: Int): MMParser.DeclBodyContext {
            return getRuleContext(MMParser.DeclBodyContext::class.java, i)
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitRaceDecl(this) else visitor.visitChildren(
                this
            )
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
                state = 180
                match(RACE)
                state = 181
                _localctx.name = match(IDENTIFIER)
                state = 183
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 182
                        _localctx.dispName = description()
                    }
                }
                state = 189
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 185
                        match(P_OPEN)
                        state = 186
                        _localctx.d = description()
                        state = 187
                        match(P_CLOSE)
                    }
                }
                state = 192
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == ALLOW_SUBRACE) {
                    run {
                        state = 191
                        match(ALLOW_SUBRACE)
                    }
                }
                state = 194
                match(BLOCK)
                state = 198
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN || _la == FIELD) {
                    run {
                        run {
                            state = 195
                            declBody()
                        }
                    }
                    state = 200
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 201
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

        fun declBody(): List<MMParser.DeclBodyContext> {
            return getRuleContexts(MMParser.DeclBodyContext::class.java)
        }

        fun declBody(i: Int): MMParser.DeclBodyContext {
            return getRuleContext(MMParser.DeclBodyContext::class.java, i)
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSubclassDecl(this) else visitor.visitChildren(
                this
            )
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
                state = 203
                match(SUBCLASS)
                state = 204
                _localctx.name = match(IDENTIFIER)
                state = 206
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 205
                        _localctx.dispName = description()
                    }
                }
                state = 208
                match(FOR)
                state = 209
                _localctx.cls = match(IDENTIFIER)
                state = 214
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 210
                        match(P_OPEN)
                        state = 211
                        _localctx.d = description()
                        state = 212
                        match(P_CLOSE)
                    }
                }
                state = 216
                match(BLOCK)
                state = 220
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN || _la == FIELD) {
                    run {
                        run {
                            state = 217
                            declBody()
                        }
                    }
                    state = 222
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 223
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

        fun declBody(): List<MMParser.DeclBodyContext> {
            return getRuleContexts(MMParser.DeclBodyContext::class.java)
        }

        fun declBody(i: Int): MMParser.DeclBodyContext {
            return getRuleContext(MMParser.DeclBodyContext::class.java, i)
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSubRaceDecl(this) else visitor.visitChildren(
                this
            )
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
                state = 225
                match(SUBRACE)
                state = 226
                _localctx.name = match(IDENTIFIER)
                state = 228
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 227
                        _localctx.dispName = description()
                    }
                }
                state = 230
                match(FOR)
                state = 231
                _localctx.race = match(IDENTIFIER)
                state = 236
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 232
                        match(P_OPEN)
                        state = 233
                        _localctx.d = description()
                        state = 234
                        match(P_CLOSE)
                    }
                }
                state = 238
                match(BLOCK)
                state = 242
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN || _la == FIELD) {
                    run {
                        run {
                            state = 239
                            declBody()
                        }
                    }
                    state = 244
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 245
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

        fun declBody(): List<MMParser.DeclBodyContext> {
            return getRuleContexts(MMParser.DeclBodyContext::class.java)
        }

        fun declBody(i: Int): MMParser.DeclBodyContext {
            return getRuleContext(MMParser.DeclBodyContext::class.java, i)
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitItemDecl(this) else visitor.visitChildren(
                this
            )
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
                state = 247
                match(ITEM)
                state = 248
                _localctx.name = match(IDENTIFIER)
                state = 250
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 249
                        _localctx.dispName = description()
                    }
                }
                state = 256
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 252
                        match(P_OPEN)
                        state = 253
                        _localctx.d = description()
                        state = 254
                        match(P_CLOSE)
                    }
                }
                state = 258
                _localctx.worth = match(CURRENCY_LIT)
                state = 259
                _localctx.weight = match(WEIGHT_LIT)
                state = 260
                match(P_OPEN)
                state = 261
                _localctx.traits = identifierSet()
                state = 262
                match(P_CLOSE)
                state = 263
                match(BR_OPEN)
                state = 264
                _localctx.tags = identifierSet()
                state = 265
                match(BR_CLOSE)
                state = 266
                match(BLOCK)
                state = 270
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN || _la == FIELD) {
                    run {
                        run {
                            state = 267
                            declBody()
                        }
                    }
                    state = 272
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 273
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

        fun declBody(): List<MMParser.DeclBodyContext> {
            return getRuleContexts(MMParser.DeclBodyContext::class.java)
        }

        fun declBody(i: Int): MMParser.DeclBodyContext {
            return getRuleContext(MMParser.DeclBodyContext::class.java, i)
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSpellDecl(this) else visitor.visitChildren(
                this
            )
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
                state = 275
                match(SPELL)
                state = 276
                _localctx.name = match(IDENTIFIER)
                state = 278
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 277
                        _localctx.dispName = description()
                    }
                }
                state = 284
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 280
                        match(P_OPEN)
                        state = 281
                        _localctx.d = description()
                        state = 282
                        match(P_CLOSE)
                    }
                }
                state = 286
                match(BLOCK)
                state = 290
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN || _la == FIELD) {
                    run {
                        run {
                            state = 287
                            declBody()
                        }
                    }
                    state = 292
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 293
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

        fun declBody(): List<MMParser.DeclBodyContext> {
            return getRuleContexts(MMParser.DeclBodyContext::class.java)
        }

        fun declBody(i: Int): MMParser.DeclBodyContext {
            return getRuleContext(MMParser.DeclBodyContext::class.java, i)
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
                state = 295
                match(BACKGROUND)
                state = 296
                _localctx.name = match(IDENTIFIER)
                state = 298
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 297
                        _localctx.dispName = description()
                    }
                }
                state = 304
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 300
                        match(P_OPEN)
                        state = 301
                        _localctx.d = description()
                        state = 302
                        match(P_CLOSE)
                    }
                }
                state = 306
                match(BLOCK)
                state = 310
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN || _la == FIELD) {
                    run {
                        run {
                            state = 307
                            declBody()
                        }
                    }
                    state = 312
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 313
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitAbilityDecl(this) else visitor.visitChildren(
                this
            )
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
                state = 315
                match(ABILITY)
                state = 316
                _localctx.name = match(IDENTIFIER)
                state = 318
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 317
                        _localctx.dispName = description()
                    }
                }
                state = 324
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 320
                        match(P_OPEN)
                        state = 321
                        _localctx.d = description()
                        state = 322
                        match(P_CLOSE)
                    }
                }
                state = 326
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitSkillDecl(this) else visitor.visitChildren(
                this
            )
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
                state = 328
                match(SKILL)
                state = 329
                _localctx.name = match(IDENTIFIER)
                state = 331
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 330
                        _localctx.dispName = description()
                    }
                }
                state = 337
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 333
                        match(P_OPEN)
                        state = 334
                        _localctx.d = description()
                        state = 335
                        match(P_CLOSE)
                    }
                }
                state = 339
                match(DEPENDS_ON)
                state = 340
                _localctx.ability = match(IDENTIFIER)
                state = 341
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

        fun declBody(): List<MMParser.DeclBodyContext> {
            return getRuleContexts(MMParser.DeclBodyContext::class.java)
        }

        fun declBody(i: Int): MMParser.DeclBodyContext {
            return getRuleContext(MMParser.DeclBodyContext::class.java, i)
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitTraitDecl(this) else visitor.visitChildren(
                this
            )
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
                state = 343
                match(TRAIT)
                state = 344
                _localctx.name = match(IDENTIFIER)
                state = 346
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 345
                        _localctx.dispName = description()
                    }
                }
                state = 352
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 348
                        match(P_OPEN)
                        state = 349
                        _localctx.d = description()
                        state = 350
                        match(P_CLOSE)
                    }
                }
                state = 354
                match(BLOCK)
                state = 358
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN || _la == FIELD) {
                    run {
                        run {
                            state = 355
                            declBody()
                        }
                    }
                    state = 360
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 361
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitItemTagDecl(this) else visitor.visitChildren(
                this
            )
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
                state = 363
                match(ITEM_TAG)
                state = 364
                _localctx.name = match(IDENTIFIER)
                state = 366
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 365
                        _localctx.dispName = description()
                    }
                }
                state = 372
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 368
                        match(P_OPEN)
                        state = 369
                        _localctx.d = description()
                        state = 370
                        match(P_CLOSE)
                    }
                }
                state = 374
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

        fun declBody(): List<MMParser.DeclBodyContext> {
            return getRuleContexts(MMParser.DeclBodyContext::class.java)
        }

        fun declBody(i: Int): MMParser.DeclBodyContext {
            return getRuleContext(MMParser.DeclBodyContext::class.java, i)
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
                state = 376
                match(ITEM_TRAIT)
                state = 377
                _localctx.name = match(IDENTIFIER)
                state = 379
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 378
                        _localctx.dispName = description()
                    }
                }
                state = 385
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 381
                        match(P_OPEN)
                        state = 382
                        _localctx.d = description()
                        state = 383
                        match(P_CLOSE)
                    }
                }
                state = 387
                match(BLOCK)
                state = 391
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == FUN || _la == FIELD) {
                    run {
                        run {
                            state = 388
                            declBody()
                        }
                    }
                    state = 393
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 394
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDamageDecl(this) else visitor.visitChildren(
                this
            )
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
                state = 396
                match(DAMAGE)
                state = 397
                _localctx.name = match(IDENTIFIER)
                state = 399
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == STRINGS || _la == STRING_LIT) {
                    run {
                        state = 398
                        _localctx.dispName = description()
                    }
                }
                state = 405
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == P_OPEN) {
                    run {
                        state = 401
                        match(P_OPEN)
                        state = 402
                        _localctx.d = description()
                        state = 403
                        match(P_CLOSE)
                    }
                }
                state = 407
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

    open class DeclBodyContext : ParserRuleContext {
        constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState)

        override fun getRuleIndex(): Int {
            return RULE_declBody
        }

        constructor()

        fun copyFrom(ctx: MMParser.DeclBodyContext?) {
            super.copyFrom(ctx)
        }
    }

    class MemberFuncContext(ctx: MMParser.DeclBodyContext?) : MMParser.DeclBodyContext() {
        fun funDecl(): FunDeclContext {
            return getRuleContext(FunDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMemberFunc(this) else visitor.visitChildren(
                this
            )
        }
    }

    class MemberFieldContext(ctx: MMParser.DeclBodyContext?) : MMParser.DeclBodyContext() {
        fun fieldDecl(): FieldDeclContext {
            return getRuleContext(FieldDeclContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMemberField(this) else visitor.visitChildren(
                this
            )
        }
    }

    @Throws(RecognitionException::class)
    fun declBody(): MMParser.DeclBodyContext {
        var _localctx = MMParser.DeclBodyContext(_ctx, state)
        enterRule(_localctx, 40, RULE_declBody)
        try {
            state = 411
            _errHandler.sync(this)
            when (_input.LA(1)) {
                FUN -> {
                    _localctx = MemberFuncContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 409
                        funDecl()
                    }
                }

                FIELD -> {
                    _localctx = MemberFieldContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 410
                        fieldDecl()
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitFunDecl(this) else visitor.visitChildren(
                this
            )
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
                state = 413
                match(FUN)
                state = 414
                _localctx.name = match(IDENTIFIER)
                state = 415
                match(P_OPEN)
                state = 416
                identifierSet()
                state = 417
                match(P_CLOSE)
                state = 418
                match(BLOCK)
                state = 422
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la - 7 and 0x3f.inv() == 0 && 1L shl _la - 7 and 8881178188634476551L != 0L) {
                    run {
                        run {
                            state = 419
                            stmt()
                        }
                    }
                    state = 424
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 425
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

    class FieldDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        fun FIELD(): TerminalNode {
            return getToken(FIELD, 0)
        }

        fun ASSIGN(): TerminalNode {
            return getToken(ASSIGN, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fieldDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitFieldDecl(this) else visitor.visitChildren(
                this
            )
        }
    }

    @Throws(RecognitionException::class)
    fun fieldDecl(): FieldDeclContext {
        val _localctx = FieldDeclContext(_ctx, state)
        enterRule(_localctx, 44, RULE_fieldDecl)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 427
                match(FIELD)
                state = 428
                _localctx.name = match(IDENTIFIER)
                state = 429
                match(ASSIGN)
                state = 430
                expr(0)
                state = 431
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

    class GlobalDeclContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        fun GLOBAL(): TerminalNode {
            return getToken(GLOBAL, 0)
        }

        fun ASSIGN(): TerminalNode {
            return getToken(ASSIGN, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_globalDecl
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitGlobalDecl(this) else visitor.visitChildren(
                this
            )
        }
    }

    @Throws(RecognitionException::class)
    fun globalDecl(): GlobalDeclContext {
        val _localctx = GlobalDeclContext(_ctx, state)
        enterRule(_localctx, 46, RULE_globalDecl)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 433
                match(GLOBAL)
                state = 434
                _localctx.name = match(IDENTIFIER)
                state = 435
                match(ASSIGN)
                state = 436
                expr(0)
                state = 437
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
        enterRule(_localctx, 48, RULE_identifierSet)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 447
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == IDENTIFIER) {
                    run {
                        state = 439
                        match(IDENTIFIER)
                        state = 444
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la == COMMA) {
                            run {
                                run {
                                    state = 440
                                    match(COMMA)
                                    state = 441
                                    match(IDENTIFIER)
                                }
                            }
                            state = 446
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitExprStmt(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitForStmt(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitWhileStmt(this) else visitor.visitChildren(
                this
            )
        }
    }

    class IfStmtContext(ctx: StmtContext?) : StmtContext() {
        var bTrue: StmtContext? = null
        var bFalse: StmtContext? = null
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitIfStmt(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitBlockStmt(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitBreakStmt(this) else visitor.visitChildren(
                this
            )
        }
    }

    class AssignStmtContext(ctx: StmtContext?) : StmtContext() {
        var v: RefContext? = null
        fun ASSIGN(): TerminalNode {
            return getToken(ASSIGN, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun SEMI(): TerminalNode {
            return getToken(SEMI, 0)
        }

        fun ref(): RefContext {
            return getRuleContext(RefContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitAssignStmt(this) else visitor.visitChildren(
                this
            )
        }
    }

    class ReturnStmtContext(ctx: StmtContext?) : StmtContext() {
        var v: ExprContext? = null
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitReturnStmt(this) else visitor.visitChildren(
                this
            )
        }
    }

    @Throws(RecognitionException::class)
    fun stmt(): StmtContext {
        var _localctx = StmtContext(_ctx, state)
        enterRule(_localctx, 50, RULE_stmt)
        var _la: Int
        try {
            state = 495
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 52, _ctx)) {
                1 -> {
                    _localctx = ExprStmtContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 449
                        expr(0)
                        state = 450
                        match(SEMI)
                    }
                }

                2 -> {
                    _localctx = BlockStmtContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 452
                        match(BLOCK)
                        state = 456
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la - 7 and 0x3f.inv() == 0 && 1L shl _la - 7 and 8881178188634476551L != 0L) {
                            run {
                                run {
                                    state = 453
                                    stmt()
                                }
                            }
                            state = 458
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 459
                        match(END)
                    }
                }

                3 -> {
                    _localctx = IfStmtContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 460
                        match(IF)
                        state = 461
                        match(P_OPEN)
                        state = 462
                        expr(0)
                        state = 463
                        match(P_CLOSE)
                        state = 464
                        (_localctx as IfStmtContext).bTrue = stmt()
                        state = 467
                        _errHandler.sync(this)
                        when (interpreter.adaptivePredict(_input, 50, _ctx)) {
                            1 -> {
                                state = 465
                                match(ELSE)
                                state = 466
                                (_localctx as IfStmtContext).bFalse = stmt()
                            }
                        }
                    }
                }

                4 -> {
                    _localctx = WhileStmtContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 469
                        match(WHILE)
                        state = 470
                        match(P_OPEN)
                        state = 471
                        expr(0)
                        state = 472
                        match(P_CLOSE)
                        state = 473
                        stmt()
                    }
                }

                5 -> {
                    _localctx = ForStmtContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 475
                        match(FOR)
                        state = 476
                        match(P_OPEN)
                        state = 477
                        (_localctx as ForStmtContext).v = match(IDENTIFIER)
                        state = 478
                        match(IN)
                        state = 479
                        expr(0)
                        state = 480
                        match(P_CLOSE)
                        state = 481
                        stmt()
                    }
                }

                6 -> {
                    _localctx = BreakStmtContext(_localctx)
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 483
                        match(BREAK)
                        state = 484
                        match(SEMI)
                    }
                }

                7 -> {
                    _localctx = ReturnStmtContext(_localctx)
                    enterOuterAlt(_localctx, 7)
                    run {
                        state = 485
                        match(RETURN)
                        state = 487
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la - 7 and 0x3f.inv() == 0 && 1L shl _la - 7 and 8881168833918881799L != 0L) {
                            run {
                                state = 486
                                (_localctx as ReturnStmtContext).v = expr(0)
                            }
                        }
                        state = 489
                        match(SEMI)
                    }
                }

                8 -> {
                    _localctx = AssignStmtContext(_localctx)
                    enterOuterAlt(_localctx, 8)
                    run {
                        state = 490
                        _localctx.v = ref()
                        state = 491
                        match(ASSIGN)
                        state = 492
                        expr(0)
                        state = 493
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

    class RefContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        var name: Token? = null
        var rest: RefTailContext? = null
        fun IDENTIFIER(): TerminalNode {
            return getToken(IDENTIFIER, 0)
        }

        fun refTail(): List<RefTailContext> {
            return getRuleContexts(RefTailContext::class.java)
        }

        fun refTail(i: Int): RefTailContext {
            return getRuleContext(RefTailContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_ref
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitRef(this) else visitor.visitChildren(
                this
            )
        }
    }

    @Throws(RecognitionException::class)
    fun ref(): RefContext {
        val _localctx = RefContext(_ctx, state)
        enterRule(_localctx, 52, RULE_ref)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 497
                _localctx.name = match(IDENTIFIER)
                state = 501
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == DOT || _la == BR_OPEN) {
                    run {
                        run {
                            state = 498
                            _localctx.rest = refTail()
                        }
                    }
                    state = 503
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

    open class RefTailContext : ParserRuleContext {
        constructor(parent: ParserRuleContext?, invokingState: Int) : super(parent, invokingState)

        override fun getRuleIndex(): Int {
            return RULE_refTail
        }

        constructor()

        fun copyFrom(ctx: RefTailContext?) {
            super.copyFrom(ctx)
        }
    }

    class IndexRefContext(ctx: RefTailContext?) : RefTailContext() {
        var idx: ExprContext? = null
        fun BR_OPEN(): TerminalNode {
            return getToken(BR_OPEN, 0)
        }

        fun BR_CLOSE(): TerminalNode {
            return getToken(BR_CLOSE, 0)
        }

        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitIndexRef(this) else visitor.visitChildren(
                this
            )
        }
    }

    class FieldRefContext(ctx: RefTailContext?) : RefTailContext() {
        var next: Token? = null
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitFieldRef(this) else visitor.visitChildren(
                this
            )
        }
    }

    @Throws(RecognitionException::class)
    fun refTail(): RefTailContext {
        var _localctx = RefTailContext(_ctx, state)
        enterRule(_localctx, 54, RULE_refTail)
        try {
            state = 510
            _errHandler.sync(this)
            when (_input.LA(1)) {
                DOT -> {
                    _localctx = FieldRefContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 504
                        match(DOT)
                        state = 505
                        (_localctx as FieldRefContext).next = match(IDENTIFIER)
                    }
                }

                BR_OPEN -> {
                    _localctx = IndexRefContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 506
                        match(BR_OPEN)
                        state = 507
                        _localctx.idx = expr(0)
                        state = 508
                        match(BR_CLOSE)
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitArgs(this) else visitor.visitChildren(
                this
            )
        }
    }

    @Throws(RecognitionException::class)
    fun args(): ArgsContext {
        val _localctx = ArgsContext(_ctx, state)
        enterRule(_localctx, 56, RULE_args)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 520
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la - 7 and 0x3f.inv() == 0 && 1L shl _la - 7 and 8881168833918881799L != 0L) {
                    run {
                        state = 512
                        expr(0)
                        state = 517
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la == COMMA) {
                            run {
                                run {
                                    state = 513
                                    match(COMMA)
                                    state = 514
                                    expr(0)
                                }
                            }
                            state = 519
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

    class ListLitContext(ctx: ExprContext?) : ExprContext() {
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

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitListLit(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDotExpr(this) else visitor.visitChildren(
                this
            )
        }
    }

    class DictLitContext(ctx: ExprContext?) : ExprContext() {
        var expr: ExprContext? = null
        var keys: MutableList<ExprContext?> = ArrayList()
        var values: MutableList<ExprContext?> = ArrayList()
        fun BLOCK(): TerminalNode {
            return getToken(BLOCK, 0)
        }

        fun ASSIGN(): List<TerminalNode> {
            return getTokens(ASSIGN)
        }

        fun ASSIGN(i: Int): TerminalNode {
            return getToken(ASSIGN, i)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
        }

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

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDictLit(this) else visitor.visitChildren(
                this
            )
        }
    }

    class MultExprContext(ctx: ExprContext?) : ExprContext() {
        var l: ExprContext? = null
        var op: Token? = null
        var r: ExprContext? = null
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitMultExpr(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitParenExpr(this) else visitor.visitChildren(
                this
            )
        }
    }

    class IndexExprContext(ctx: ExprContext?) : ExprContext() {
        var base: ExprContext? = null
        var idx: ExprContext? = null
        fun BR_OPEN(): TerminalNode {
            return getToken(BR_OPEN, 0)
        }

        fun BR_CLOSE(): TerminalNode {
            return getToken(BR_CLOSE, 0)
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitIndexExpr(this) else visitor.visitChildren(
                this
            )
        }
    }

    class UnaryExprContext(ctx: ExprContext?) : ExprContext() {
        var op: Token? = null
        fun expr(): ExprContext {
            return getRuleContext(ExprContext::class.java, 0)
        }

        fun PLUS(): TerminalNode {
            return getToken(PLUS, 0)
        }

        fun MINUS(): TerminalNode {
            return getToken(MINUS, 0)
        }

        fun NOT(): TerminalNode {
            return getToken(NOT, 0)
        }

        init {
            copyFrom(ctx)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitUnaryExpr(this) else visitor.visitChildren(
                this
            )
        }
    }

    class AddExprContext(ctx: ExprContext?) : ExprContext() {
        var l: ExprContext? = null
        var op: Token? = null
        var r: ExprContext? = null
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitAddExpr(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitLiteralExpr(this) else visitor.visitChildren(
                this
            )
        }
    }

    class CompExprContext(ctx: ExprContext?) : ExprContext() {
        var l: ExprContext? = null
        var op: Token? = null
        var r: ExprContext? = null
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitCompExpr(this) else visitor.visitChildren(
                this
            )
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
        var l: ExprContext? = null
        var op: Token? = null
        var r: ExprContext? = null
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitBoolExpr(this) else visitor.visitChildren(
                this
            )
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
        val _startState = 58
        enterRecursionRule(_localctx, 58, RULE_expr, _p)
        var _la: Int
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                state = 563
                _errHandler.sync(this)
                when (interpreter.adaptivePredict(_input, 59, _ctx)) {
                    1 -> {
                        _localctx = LiteralExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 523
                        literal()
                    }

                    2 -> {
                        _localctx = IdentifierExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 524
                        (_localctx as IdentifierExprContext).name = match(IDENTIFIER)
                    }

                    3 -> {
                        _localctx = FunctionCallExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 525
                        match(IDENTIFIER)
                        state = 526
                        match(P_OPEN)
                        state = 527
                        args()
                        state = 528
                        match(P_CLOSE)
                    }

                    4 -> {
                        _localctx = ParenExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 530
                        match(P_OPEN)
                        state = 531
                        expr(0)
                        state = 532
                        match(P_CLOSE)
                    }

                    5 -> {
                        _localctx = UnaryExprContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 534
                        (_localctx as UnaryExprContext).op = _input.LT(1)
                        _la = _input.LA(1)
                        if (!(_la and 0x3f.inv() == 0 && 1L shl _la and 896L != 0L)) {
                            (_localctx as UnaryExprContext).op =
                                _errHandler.recoverInline(this) as Token
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true
                            _errHandler.reportMatch(this)
                            consume()
                        }
                        state = 535
                        expr(7)
                    }

                    6 -> {
                        _localctx = ListLitContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 536
                        match(BR_OPEN)
                        state = 537
                        expr(0)
                        state = 542
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la == COMMA) {
                            run {
                                run {
                                    state = 538
                                    match(COMMA)
                                    state = 539
                                    expr(0)
                                }
                            }
                            state = 544
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 545
                        match(BR_CLOSE)
                    }

                    7 -> {
                        _localctx = DictLitContext(_localctx)
                        _ctx = _localctx
                        _prevctx = _localctx
                        state = 547
                        match(BLOCK)
                        state = 548
                        (_localctx as DictLitContext).expr = expr(0)
                        (_localctx as DictLitContext).keys.add((_localctx as DictLitContext).expr)
                        state = 549
                        match(ASSIGN)
                        state = 550
                        (_localctx as DictLitContext).expr = expr(0)
                        (_localctx as DictLitContext).values.add((_localctx as DictLitContext).expr)
                        state = 558
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        while (_la == COMMA) {
                            run {
                                run {
                                    state = 551
                                    match(COMMA)
                                    state = 552
                                    (_localctx as DictLitContext).expr = expr(0)
                                    (_localctx as DictLitContext).keys.add((_localctx as DictLitContext).expr)
                                    state = 553
                                    match(ASSIGN)
                                    state = 554
                                    (_localctx as DictLitContext).expr = expr(0)
                                    (_localctx as DictLitContext).values.add((_localctx as DictLitContext).expr)
                                }
                            }
                            state = 560
                            _errHandler.sync(this)
                            _la = _input.LA(1)
                        }
                        state = 561
                        match(END)
                    }
                }
                _ctx.stop = _input.LT(-1)
                state = 587
                _errHandler.sync(this)
                _alt = interpreter.adaptivePredict(_input, 61, _ctx)
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent()
                        _prevctx = _localctx
                        run {
                            state = 585
                            _errHandler.sync(this)
                            when (interpreter.adaptivePredict(_input, 60, _ctx)) {
                                1 -> {
                                    _localctx =
                                        MultExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as MultExprContext).l = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 565
                                    if (!precpred(_ctx, 6)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 6)"
                                    )
                                    state = 566
                                    (_localctx as MultExprContext).op = _input.LT(1)
                                    _la = _input.LA(1)
                                    if (!(_la and 0x3f.inv() == 0 && 1L shl _la and 112L != 0L)) {
                                        (_localctx as MultExprContext).op =
                                            _errHandler.recoverInline(this) as Token
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                    state = 567
                                    (_localctx as MultExprContext).r = expr(7)
                                }

                                2 -> {
                                    _localctx =
                                        AddExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as AddExprContext).l = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 568
                                    if (!precpred(_ctx, 5)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 5)"
                                    )
                                    state = 569
                                    (_localctx as AddExprContext).op = _input.LT(1)
                                    _la = _input.LA(1)
                                    if (!(_la == PLUS || _la == MINUS)) {
                                        (_localctx as AddExprContext).op =
                                            _errHandler.recoverInline(this) as Token
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                    state = 570
                                    (_localctx as AddExprContext).r = expr(6)
                                }

                                3 -> {
                                    _localctx =
                                        BoolExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as BoolExprContext).l = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 571
                                    if (!precpred(_ctx, 4)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 4)"
                                    )
                                    state = 572
                                    (_localctx as BoolExprContext).op = _input.LT(1)
                                    _la = _input.LA(1)
                                    if (!(_la == AND || _la == OR)) {
                                        (_localctx as BoolExprContext).op =
                                            _errHandler.recoverInline(this) as Token
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                    state = 573
                                    (_localctx as BoolExprContext).r = expr(5)
                                }

                                4 -> {
                                    _localctx =
                                        CompExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as CompExprContext).l = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 574
                                    if (!precpred(_ctx, 3)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 3)"
                                    )
                                    state = 575
                                    (_localctx as CompExprContext).op = _input.LT(1)
                                    _la = _input.LA(1)
                                    if (!(_la and 0x3f.inv() == 0 && 1L shl _la and 64512L != 0L)) {
                                        (_localctx as CompExprContext).op =
                                            _errHandler.recoverInline(this) as Token
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true
                                        _errHandler.reportMatch(this)
                                        consume()
                                    }
                                    state = 576
                                    (_localctx as CompExprContext).r = expr(4)
                                }

                                5 -> {
                                    _localctx =
                                        DotExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as DotExprContext).base = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 577
                                    if (!precpred(_ctx, 11)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 11)"
                                    )
                                    state = 578
                                    match(DOT)
                                    state = 579
                                    (_localctx as DotExprContext).name = match(IDENTIFIER)
                                }

                                6 -> {
                                    _localctx =
                                        IndexExprContext(ExprContext(_parentctx, _parentState))
                                    (_localctx as IndexExprContext).base = _prevctx
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr)
                                    state = 580
                                    if (!precpred(_ctx, 10)) throw FailedPredicateException(
                                        this,
                                        "precpred(_ctx, 10)"
                                    )
                                    state = 581
                                    match(BR_OPEN)
                                    state = 582
                                    (_localctx as IndexExprContext).idx = expr(0)
                                    state = 583
                                    match(BR_CLOSE)
                                }

                                else -> {}
                            }
                        }
                    }
                    state = 589
                    _errHandler.sync(this)
                    _alt = interpreter.adaptivePredict(_input, 61, _ctx)
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitCurrencyLit(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitStringLit(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitWeightLit(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitNumberLit(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitRawDiceLit(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitDistanceLit(this) else visitor.visitChildren(
                this
            )
        }
    }

    @Throws(RecognitionException::class)
    fun literal(): LiteralContext {
        var _localctx = LiteralContext(_ctx, state)
        enterRule(_localctx, 60, RULE_literal)
        try {
            state = 596
            _errHandler.sync(this)
            when (_input.LA(1)) {
                NUMBER -> {
                    _localctx = NumberLitContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 590
                        match(NUMBER)
                    }
                }

                DICE_LIT -> {
                    _localctx = RawDiceLitContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 591
                        match(DICE_LIT)
                    }
                }

                DIST_LIT -> {
                    _localctx = DistanceLitContext(_localctx)
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 592
                        match(DIST_LIT)
                    }
                }

                CURRENCY_LIT -> {
                    _localctx = CurrencyLitContext(_localctx)
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 593
                        match(CURRENCY_LIT)
                    }
                }

                WEIGHT_LIT -> {
                    _localctx = WeightLitContext(_localctx)
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 594
                        match(WEIGHT_LIT)
                    }
                }

                STRINGS, STRING_LIT -> {
                    _localctx = StringLitContext(_localctx)
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 595
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitStringDescr(this) else visitor.visitChildren(
                this
            )
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
            return if (visitor is MMVisitor<*>) (visitor as MMVisitor<out T>).visitRefDescr(this) else visitor.visitChildren(
                this
            )
        }
    }

    @Throws(RecognitionException::class)
    fun description(): DescriptionContext {
        var _localctx = DescriptionContext(_ctx, state)
        enterRule(_localctx, 62, RULE_description)
        try {
            state = 602
            _errHandler.sync(this)
            when (_input.LA(1)) {
                STRING_LIT -> {
                    _localctx = StringDescrContext(_localctx)
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 598
                        match(STRING_LIT)
                    }
                }

                STRINGS -> {
                    _localctx = RefDescrContext(_localctx)
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 599
                        match(STRINGS)
                        state = 600
                        match(DOT)
                        state = 601
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
            29 -> return expr_sempred(_localctx as ExprContext, predIndex)
        }
        return true
    }

    private fun expr_sempred(_localctx: ExprContext, predIndex: Int): Boolean {
        when (predIndex) {
            0 -> return precpred(_ctx, 6)
            1 -> return precpred(_ctx, 5)
            2 -> return precpred(_ctx, 4)
            3 -> return precpred(_ctx, 3)
            4 -> return precpred(_ctx, 11)
            5 -> return precpred(_ctx, 10)
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
        const val NOT = 9
        const val GT = 10
        const val LT = 11
        const val GE = 12
        const val LE = 13
        const val EQ = 14
        const val NE = 15
        const val AND = 16
        const val OR = 17
        const val ASSIGN = 18
        const val BLOCK = 19
        const val END = 20
        const val P_OPEN = 21
        const val P_CLOSE = 22
        const val BR_OPEN = 23
        const val BR_CLOSE = 24
        const val FS_SEP = 25
        const val D = 26
        const val CP = 27
        const val FT = 28
        const val GP = 29
        const val IF = 30
        const val LB = 31
        const val IN = 32
        const val PP = 33
        const val SP = 34
        const val FOR = 35
        const val FUN = 36
        const val ELSE = 37
        const val ITEM = 38
        const val RACE = 39
        const val BREAK = 40
        const val CLASS = 41
        const val FIELD = 42
        const val SKILL = 43
        const val SPELL = 44
        const val TRAIT = 45
        const val WHILE = 46
        const val DAMAGE = 47
        const val ENABLE = 48
        const val GLOBAL = 49
        const val RETURN = 50
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
        const val RULE_fieldDecl = 22
        const val RULE_globalDecl = 23
        const val RULE_identifierSet = 24
        const val RULE_stmt = 25
        const val RULE_ref = 26
        const val RULE_refTail = 27
        const val RULE_args = 28
        const val RULE_expr = 29
        const val RULE_literal = 30
        const val RULE_description = 31
        private fun makeRuleNames(): Array<String> {
            return arrayOf(
                "strings", "singleString", "mageProg", "header", "setStrings", "enables",
                "topLevel", "classDecl", "raceDecl", "subclassDecl", "subRaceDecl", "itemDecl",
                "spellDecl", "backgroundDecl", "abilityDecl", "skillDecl", "traitDecl",
                "itemTagDecl", "itemTraitDecl", "damageDecl", "declBody", "funDecl",
                "fieldDecl", "globalDecl", "identifierSet", "stmt", "ref", "refTail",
                "args", "expr", "literal", "description"
            )
        }

        val ruleNames = makeRuleNames()
        private fun makeLiteralNames(): Array<String?> {
            return arrayOf(
                null, "'.'", "';'", "','", "'*'", "'/'", "'%'", "'+'", "'-'", "'!'",
                "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "'='",
                "'{'", "'}'", "'('", "')'", "'['", "']'", "'#~#'", null, "'cp'", "'ft'",
                "'gp'", "'if'", "'lb'", "'in'", "'pp'", "'sp'", "'for'", "'fun'", "'else'",
                "'item'", "'race'", "'break'", "'class'", "'field'", "'skill'", "'spell'",
                "'trait'", "'while'", "'damage'", "'enable'", "'global'", "'return'",
                "'source'", "'ability'", "'strings'", "'subrace'", "'subclass'", "'item_tag'",
                "'item_trait'", "'background'", "'depends on'", "'allow subrace'"
            )
        }

        private val _LITERAL_NAMES = makeLiteralNames()
        private fun makeSymbolicNames(): Array<String?> {
            return arrayOf(
                null, "DOT", "SEMI", "COMMA", "MULT", "DIV", "MOD", "PLUS", "MINUS",
                "NOT", "GT", "LT", "GE", "LE", "EQ", "NE", "AND", "OR", "ASSIGN", "BLOCK",
                "END", "P_OPEN", "P_CLOSE", "BR_OPEN", "BR_CLOSE", "FS_SEP", "D", "CP",
                "FT", "GP", "IF", "LB", "IN", "PP", "SP", "FOR", "FUN", "ELSE", "ITEM",
                "RACE", "BREAK", "CLASS", "FIELD", "SKILL", "SPELL", "TRAIT", "WHILE",
                "DAMAGE", "ENABLE", "GLOBAL", "RETURN", "SOURCE", "ABILITY", "STRINGS",
                "SUBRACE", "SUBCLASS", "ITEM_TAG", "ITEM_TRAIT", "BACKGROUND", "DEPENDS_ON",
                "ALLOW_SUBRACE", "NUMBER", "AUTO_TARGETS", "DICE_LIT", "DIST_LIT", "CURRENCY",
                "CURRENCY_LIT", "WEIGHT_LIT", "IDENTIFIER", "STRING_LIT", "NEWLINE",
                "WS", "COMMENT", "ML_COMMENT", "ANY"
            )
        }

        private val _SYMBOLIC_NAMES = makeSymbolicNames()
        val VOCABULARY: Vocabulary = VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES)

        @Deprecated("Use {@link #VOCABULARY} instead.")
        val tokenNames = _SYMBOLIC_NAMES.indices.map {
            VOCABULARY.getLiteralName(it) ?: VOCABULARY.getSymbolicName(it) ?: "<INVALID>"
        }.toTypedArray()

        const val _serializedATN =
            "\u0004\u0001J\u025d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
                    "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
                    "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
                    "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002" +
                    "\u000c\u0007\u000c\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f" +
                    "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012" +
                    "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015" +
                    "\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018" +
                    "\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b" +
                    "\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e" +
                    "\u0002\u001f\u0007\u001f\u0001\u0000\u0005\u0000B\b\u0000\n\u0000\u000c\u0000" +
                    "E\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001" +
                    "\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002P\b\u0002" +
                    "\n\u0002\u000c\u0002S\t\u0002\u0001\u0002\u0005\u0002V\b\u0002\n\u0002\u000c\u0002" +
                    "Y\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003d\b\u0003" +
                    "\n\u0003\u000c\u0003g\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003" +
                    "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003" +
                    "r\b\u0003\n\u0003\u000c\u0003u\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003" +
                    "y\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0005\u0004\u0080\b\u0004\n\u0004\u000c\u0004\u0083\t\u0004\u0001\u0004\u0001" +
                    "\u0004\u0001\u0005\u0001\u0005\u0005\u0005\u0089\b\u0005\n\u0005\u000c\u0005" +
                    "\u008c\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0003\u0006\u009f\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007" +
                    "\u00a4\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007" +
                    "\u00aa\b\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00ae\b\u0007\n\u0007" +
                    "\u000c\u0007\u00b1\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b" +
                    "\u0003\b\u00b8\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00be\b\b\u0001" +
                    "\b\u0003\b\u00c1\b\b\u0001\b\u0001\b\u0005\b\u00c5\b\b\n\b\u000c\b\u00c8\t" +
                    "\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\t\u00cf\b\t\u0001\t\u0001" +
                    "\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00d7\b\t\u0001\t\u0001\t\u0005" +
                    "\t\u00db\b\t\n\t\u000c\t\u00de\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n" +
                    "\u0003\n\u00e5\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003" +
                    "\n\u00ed\b\n\u0001\n\u0001\n\u0005\n\u00f1\b\n\n\n\u000c\n\u00f4\t\n\u0001" +
                    "\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00fb\b\u000b" +
                    "\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0101\b\u000b" +
                    "\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b" +
                    "\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u010d\b\u000b" +
                    "\n\u000b\u000c\u000b\u0110\t\u000b\u0001\u000b\u0001\u000b\u0001\u000c\u0001\u000c" +
                    "\u0001\u000c\u0003\u000c\u0117\b\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0003\u000c\u011d" +
                    "\b\u000c\u0001\u000c\u0001\u000c\u0005\u000c\u0121\b\u000c\n\u000c\u000c\u000c\u0124\t\u000c\u0001\u000c\u0001" +
                    "\u000c\u0001\r\u0001\r\u0001\r\u0003\r\u012b\b\r\u0001\r\u0001\r\u0001\r\u0001" +
                    "\r\u0003\r\u0131\b\r\u0001\r\u0001\r\u0005\r\u0135\b\r\n\r\u000c\r\u0138\t" +
                    "\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u013f" +
                    "\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0145" +
                    "\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003" +
                    "\u000f\u014c\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003" +
                    "\u000f\u0152\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001" +
                    "\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u015b\b\u0010\u0001\u0010\u0001" +
                    "\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0161\b\u0010\u0001\u0010\u0001" +
                    "\u0010\u0005\u0010\u0165\b\u0010\n\u0010\u000c\u0010\u0168\t\u0010\u0001\u0010" +
                    "\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u016f\b\u0011" +
                    "\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0175\b\u0011" +
                    "\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012" +
                    "\u017c\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012" +
                    "\u0182\b\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0186\b\u0012\n\u0012" +
                    "\u000c\u0012\u0189\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013" +
                    "\u0001\u0013\u0003\u0013\u0190\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013" +
                    "\u0001\u0013\u0003\u0013\u0196\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014" +
                    "\u0001\u0014\u0003\u0014\u019c\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015" +
                    "\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u01a5\b\u0015" +
                    "\n\u0015\u000c\u0015\u01a8\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001" +
                    "\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001" +
                    "\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001" +
                    "\u0018\u0001\u0018\u0005\u0018\u01bb\b\u0018\n\u0018\u000c\u0018\u01be\t\u0018" +
                    "\u0003\u0018\u01c0\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019" +
                    "\u0001\u0019\u0005\u0019\u01c7\b\u0019\n\u0019\u000c\u0019\u01ca\t\u0019\u0001" +
                    "\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001" +
                    "\u0019\u0001\u0019\u0003\u0019\u01d4\b\u0019\u0001\u0019\u0001\u0019\u0001" +
                    "\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001" +
                    "\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001" +
                    "\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u01e8\b\u0019\u0001" +
                    "\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003" +
                    "\u0019\u01f0\b\u0019\u0001\u001a\u0001\u001a\u0005\u001a\u01f4\b\u001a" +
                    "\n\u001a\u000c\u001a\u01f7\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001" +
                    "\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01ff\b\u001b\u0001\u001c\u0001" +
                    "\u001c\u0001\u001c\u0005\u001c\u0204\b\u001c\n\u001c\u000c\u001c\u0207\t\u001c" +
                    "\u0003\u001c\u0209\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d" +
                    "\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d" +
                    "\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d" +
                    "\u0001\u001d\u0001\u001d\u0005\u001d\u021d\b\u001d\n\u001d\u000c\u001d\u0220" +
                    "\t\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001" +
                    "\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005" +
                    "\u001d\u022d\b\u001d\n\u001d\u000c\u001d\u0230\t\u001d\u0001\u001d\u0001\u001d" +
                    "\u0003\u001d\u0234\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d" +
                    "\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d" +
                    "\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d" +
                    "\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u024a\b\u001d" +
                    "\n\u001d\u000c\u001d\u024d\t\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001" +
                    "\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0255\b\u001e\u0001\u001f\u0001" +
                    "\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u025b\b\u001f\u0001\u001f\u0000" +
                    "\u0001: \u0000\u0002\u0004\u0006\b\n\u000c\u000e\u0010\u0012\u0014\u0016\u0018" +
                    "\u001a\u001c\u001e \"$&(*,.02468:<>\u0000\u0005\u0001\u0000\u0007\t\u0001" +
                    "\u0000\u0004\u0006\u0001\u0000\u0007\b\u0001\u0000\u0010\u0011\u0001\u0000" +
                    "\n\u000f\u029e\u0000C\u0001\u0000\u0000\u0000\u0002H\u0001\u0000\u0000" +
                    "\u0000\u0004M\u0001\u0000\u0000\u0000\u0006x\u0001\u0000\u0000\u0000\b" +
                    "z\u0001\u0000\u0000\u0000\n\u0086\u0001\u0000\u0000\u0000\u000c\u009e\u0001" +
                    "\u0000\u0000\u0000\u000e\u00a0\u0001\u0000\u0000\u0000\u0010\u00b4\u0001" +
                    "\u0000\u0000\u0000\u0012\u00cb\u0001\u0000\u0000\u0000\u0014\u00e1\u0001" +
                    "\u0000\u0000\u0000\u0016\u00f7\u0001\u0000\u0000\u0000\u0018\u0113\u0001" +
                    "\u0000\u0000\u0000\u001a\u0127\u0001\u0000\u0000\u0000\u001c\u013b\u0001" +
                    "\u0000\u0000\u0000\u001e\u0148\u0001\u0000\u0000\u0000 \u0157\u0001\u0000" +
                    "\u0000\u0000\"\u016b\u0001\u0000\u0000\u0000$\u0178\u0001\u0000\u0000" +
                    "\u0000&\u018c\u0001\u0000\u0000\u0000(\u019b\u0001\u0000\u0000\u0000*" +
                    "\u019d\u0001\u0000\u0000\u0000,\u01ab\u0001\u0000\u0000\u0000.\u01b1\u0001" +
                    "\u0000\u0000\u00000\u01bf\u0001\u0000\u0000\u00002\u01ef\u0001\u0000\u0000" +
                    "\u00004\u01f1\u0001\u0000\u0000\u00006\u01fe\u0001\u0000\u0000\u00008" +
                    "\u0208\u0001\u0000\u0000\u0000:\u0233\u0001\u0000\u0000\u0000<\u0254\u0001" +
                    "\u0000\u0000\u0000>\u025a\u0001\u0000\u0000\u0000@B\u0003\u0002\u0001" +
                    "\u0000A@\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000" +
                    "\u0000\u0000CD\u0001\u0000\u0000\u0000DF\u0001\u0000\u0000\u0000EC\u0001" +
                    "\u0000\u0000\u0000FG\u0005\u0000\u0000\u0001G\u0001\u0001\u0000\u0000" +
                    "\u0000HI\u0005D\u0000\u0000IJ\u0005\u0012\u0000\u0000JK\u0005E\u0000\u0000" +
                    "KL\u0005\u0002\u0000\u0000L\u0003\u0001\u0000\u0000\u0000MQ\u0003\u0006" +
                    "\u0003\u0000NP\u0003\n\u0005\u0000ON\u0001\u0000\u0000\u0000PS\u0001\u0000" +
                    "\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RW\u0001" +
                    "\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000TV\u0003\u000c\u0006\u0000UT\u0001" +
                    "\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000" +
                    "WX\u0001\u0000\u0000\u0000XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000" +
                    "\u0000Z[\u0005\u0000\u0000\u0001[\u0005\u0001\u0000\u0000\u0000\\]\u0005" +
                    "3\u0000\u0000]^\u0005D\u0000\u0000^y\u0005\u0002\u0000\u0000_`\u00053" +
                    "\u0000\u0000`a\u0005D\u0000\u0000ae\u0005;\u0000\u0000bd\u0005E\u0000" +
                    "\u0000cb\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000" +
                    "\u0000\u0000ef\u0001\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000ge\u0001" +
                    "\u0000\u0000\u0000hy\u0005\u0002\u0000\u0000ij\u00053\u0000\u0000jk\u0005" +
                    "D\u0000\u0000kl\u0005\u0002\u0000\u0000ly\u0003\b\u0004\u0000mn\u0005" +
                    "3\u0000\u0000no\u0005D\u0000\u0000os\u0005;\u0000\u0000pr\u0005E\u0000" +
                    "\u0000qp\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000" +
                    "\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001" +
                    "\u0000\u0000\u0000vw\u0005\u0002\u0000\u0000wy\u0003\b\u0004\u0000x\\" +
                    "\u0001\u0000\u0000\u0000x_\u0001\u0000\u0000\u0000xi\u0001\u0000\u0000" +
                    "\u0000xm\u0001\u0000\u0000\u0000y\u0007\u0001\u0000\u0000\u0000z{\u0005" +
                    "5\u0000\u0000{|\u0005 \u0000\u0000|\u0081\u0005E\u0000\u0000}~\u0005\u0003" +
                    "\u0000\u0000~\u0080\u0005E\u0000\u0000\u007f}\u0001\u0000\u0000\u0000" +
                    "\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000" +
                    "\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0084\u0001\u0000\u0000\u0000" +
                    "\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u0002\u0000\u0000" +
                    "\u0085\t\u0001\u0000\u0000\u0000\u0086\u008a\u00050\u0000\u0000\u0087" +
                    "\u0089\u0005>\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008c" +
                    "\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b" +
                    "\u0001\u0000\u0000\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c\u008a" +
                    "\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0002\u0000\u0000\u008e\u000b" +
                    "\u0001\u0000\u0000\u0000\u008f\u009f\u0003\u000e\u0007\u0000\u0090\u009f" +
                    "\u0003\u0010\b\u0000\u0091\u009f\u0003\u0012\t\u0000\u0092\u009f\u0003" +
                    "\u0014\n\u0000\u0093\u009f\u0003\u0016\u000b\u0000\u0094\u009f\u0003\u0018" +
                    "\u000c\u0000\u0095\u009f\u0003\u001a\r\u0000\u0096\u009f\u0003\u001c\u000e" +
                    "\u0000\u0097\u009f\u0003\u001e\u000f\u0000\u0098\u009f\u0003 \u0010\u0000" +
                    "\u0099\u009f\u0003$\u0012\u0000\u009a\u009f\u0003&\u0013\u0000\u009b\u009f" +
                    "\u0003\"\u0011\u0000\u009c\u009f\u0003*\u0015\u0000\u009d\u009f\u0003" +
                    ".\u0017\u0000\u009e\u008f\u0001\u0000\u0000\u0000\u009e\u0090\u0001\u0000" +
                    "\u0000\u0000\u009e\u0091\u0001\u0000\u0000\u0000\u009e\u0092\u0001\u0000" +
                    "\u0000\u0000\u009e\u0093\u0001\u0000\u0000\u0000\u009e\u0094\u0001\u0000" +
                    "\u0000\u0000\u009e\u0095\u0001\u0000\u0000\u0000\u009e\u0096\u0001\u0000" +
                    "\u0000\u0000\u009e\u0097\u0001\u0000\u0000\u0000\u009e\u0098\u0001\u0000" +
                    "\u0000\u0000\u009e\u0099\u0001\u0000\u0000\u0000\u009e\u009a\u0001\u0000" +
                    "\u0000\u0000\u009e\u009b\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000" +
                    "\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009f\r\u0001\u0000\u0000" +
                    "\u0000\u00a0\u00a1\u0005)\u0000\u0000\u00a1\u00a3\u0005D\u0000\u0000\u00a2" +
                    "\u00a4\u0003>\u001f\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a3\u00a4" +
                    "\u0001\u0000\u0000\u0000\u00a4\u00a9\u0001\u0000\u0000\u0000\u00a5\u00a6" +
                    "\u0005\u0015\u0000\u0000\u00a6\u00a7\u0003>\u001f\u0000\u00a7\u00a8\u0005" +
                    "\u0016\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a5\u0001" +
                    "\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001" +
                    "\u0000\u0000\u0000\u00ab\u00af\u0005\u0013\u0000\u0000\u00ac\u00ae\u0003" +
                    "(\u0014\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\u00b1\u0001\u0000" +
                    "\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000" +
                    "\u0000\u0000\u00b0\u00b2\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000" +
                    "\u0000\u0000\u00b2\u00b3\u0005\u0014\u0000\u0000\u00b3\u000f\u0001\u0000" +
                    "\u0000\u0000\u00b4\u00b5\u0005\'\u0000\u0000\u00b5\u00b7\u0005D\u0000" +
                    "\u0000\u00b6\u00b8\u0003>\u001f\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000" +
                    "\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00bd\u0001\u0000\u0000\u0000" +
                    "\u00b9\u00ba\u0005\u0015\u0000\u0000\u00ba\u00bb\u0003>\u001f\u0000\u00bb" +
                    "\u00bc\u0005\u0016\u0000\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd" +
                    "\u00b9\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be" +
                    "\u00c0\u0001\u0000\u0000\u0000\u00bf\u00c1\u0005<\u0000\u0000\u00c0\u00bf" +
                    "\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2" +
                    "\u0001\u0000\u0000\u0000\u00c2\u00c6\u0005\u0013\u0000\u0000\u00c3\u00c5" +
                    "\u0003(\u0014\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001" +
                    "\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001" +
                    "\u0000\u0000\u0000\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001" +
                    "\u0000\u0000\u0000\u00c9\u00ca\u0005\u0014\u0000\u0000\u00ca\u0011\u0001" +
                    "\u0000\u0000\u0000\u00cb\u00cc\u00057\u0000\u0000\u00cc\u00ce\u0005D\u0000" +
                    "\u0000\u00cd\u00cf\u0003>\u001f\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000" +
                    "\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000" +
                    "\u00d0\u00d1\u0005#\u0000\u0000\u00d1\u00d6\u0005D\u0000\u0000\u00d2\u00d3" +
                    "\u0005\u0015\u0000\u0000\u00d3\u00d4\u0003>\u001f\u0000\u00d4\u00d5\u0005" +
                    "\u0016\u0000\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u00d2\u0001" +
                    "\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001" +
                    "\u0000\u0000\u0000\u00d8\u00dc\u0005\u0013\u0000\u0000\u00d9\u00db\u0003" +
                    "(\u0014\u0000\u00da\u00d9\u0001\u0000\u0000\u0000\u00db\u00de\u0001\u0000" +
                    "\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000" +
                    "\u0000\u0000\u00dd\u00df\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000" +
                    "\u0000\u0000\u00df\u00e0\u0005\u0014\u0000\u0000\u00e0\u0013\u0001\u0000" +
                    "\u0000\u0000\u00e1\u00e2\u00056\u0000\u0000\u00e2\u00e4\u0005D\u0000\u0000" +
                    "\u00e3\u00e5\u0003>\u001f\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e4" +
                    "\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6" +
                    "\u00e7\u0005#\u0000\u0000\u00e7\u00ec\u0005D\u0000\u0000\u00e8\u00e9\u0005" +
                    "\u0015\u0000\u0000\u00e9\u00ea\u0003>\u001f\u0000\u00ea\u00eb\u0005\u0016" +
                    "\u0000\u0000\u00eb\u00ed\u0001\u0000\u0000\u0000\u00ec\u00e8\u0001\u0000" +
                    "\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000" +
                    "\u0000\u0000\u00ee\u00f2\u0005\u0013\u0000\u0000\u00ef\u00f1\u0003(\u0014" +
                    "\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000" +
                    "\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000" +
                    "\u0000\u00f3\u00f5\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000" +
                    "\u0000\u00f5\u00f6\u0005\u0014\u0000\u0000\u00f6\u0015\u0001\u0000\u0000" +
                    "\u0000\u00f7\u00f8\u0005&\u0000\u0000\u00f8\u00fa\u0005D\u0000\u0000\u00f9" +
                    "\u00fb\u0003>\u001f\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fa\u00fb" +
                    "\u0001\u0000\u0000\u0000\u00fb\u0100\u0001\u0000\u0000\u0000\u00fc\u00fd" +
                    "\u0005\u0015\u0000\u0000\u00fd\u00fe\u0003>\u001f\u0000\u00fe\u00ff\u0005" +
                    "\u0016\u0000\u0000\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00fc\u0001" +
                    "\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0102\u0001" +
                    "\u0000\u0000\u0000\u0102\u0103\u0005B\u0000\u0000\u0103\u0104\u0005C\u0000" +
                    "\u0000\u0104\u0105\u0005\u0015\u0000\u0000\u0105\u0106\u00030\u0018\u0000" +
                    "\u0106\u0107\u0005\u0016\u0000\u0000\u0107\u0108\u0005\u0017\u0000\u0000" +
                    "\u0108\u0109\u00030\u0018\u0000\u0109\u010a\u0005\u0018\u0000\u0000\u010a" +
                    "\u010e\u0005\u0013\u0000\u0000\u010b\u010d\u0003(\u0014\u0000\u010c\u010b" +
                    "\u0001\u0000\u0000\u0000\u010d\u0110\u0001\u0000\u0000\u0000\u010e\u010c" +
                    "\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0111" +
                    "\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0112" +
                    "\u0005\u0014\u0000\u0000\u0112\u0017\u0001\u0000\u0000\u0000\u0113\u0114" +
                    "\u0005,\u0000\u0000\u0114\u0116\u0005D\u0000\u0000\u0115\u0117\u0003>" +
                    "\u001f\u0000\u0116\u0115\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000" +
                    "\u0000\u0000\u0117\u011c\u0001\u0000\u0000\u0000\u0118\u0119\u0005\u0015" +
                    "\u0000\u0000\u0119\u011a\u0003>\u001f\u0000\u011a\u011b\u0005\u0016\u0000" +
                    "\u0000\u011b\u011d\u0001\u0000\u0000\u0000\u011c\u0118\u0001\u0000\u0000" +
                    "\u0000\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000" +
                    "\u0000\u011e\u0122\u0005\u0013\u0000\u0000\u011f\u0121\u0003(\u0014\u0000" +
                    "\u0120\u011f\u0001\u0000\u0000\u0000\u0121\u0124\u0001\u0000\u0000\u0000" +
                    "\u0122\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000" +
                    "\u0123\u0125\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000" +
                    "\u0125\u0126\u0005\u0014\u0000\u0000\u0126\u0019\u0001\u0000\u0000\u0000" +
                    "\u0127\u0128\u0005:\u0000\u0000\u0128\u012a\u0005D\u0000\u0000\u0129\u012b" +
                    "\u0003>\u001f\u0000\u012a\u0129\u0001\u0000\u0000\u0000\u012a\u012b\u0001" +
                    "\u0000\u0000\u0000\u012b\u0130\u0001\u0000\u0000\u0000\u012c\u012d\u0005" +
                    "\u0015\u0000\u0000\u012d\u012e\u0003>\u001f\u0000\u012e\u012f\u0005\u0016" +
                    "\u0000\u0000\u012f\u0131\u0001\u0000\u0000\u0000\u0130\u012c\u0001\u0000" +
                    "\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000" +
                    "\u0000\u0000\u0132\u0136\u0005\u0013\u0000\u0000\u0133\u0135\u0003(\u0014" +
                    "\u0000\u0134\u0133\u0001\u0000\u0000\u0000\u0135\u0138\u0001\u0000\u0000" +
                    "\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000" +
                    "\u0000\u0137\u0139\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000" +
                    "\u0000\u0139\u013a\u0005\u0014\u0000\u0000\u013a\u001b\u0001\u0000\u0000" +
                    "\u0000\u013b\u013c\u00054\u0000\u0000\u013c\u013e\u0005D\u0000\u0000\u013d" +
                    "\u013f\u0003>\u001f\u0000\u013e\u013d\u0001\u0000\u0000\u0000\u013e\u013f" +
                    "\u0001\u0000\u0000\u0000\u013f\u0144\u0001\u0000\u0000\u0000\u0140\u0141" +
                    "\u0005\u0015\u0000\u0000\u0141\u0142\u0003>\u001f\u0000\u0142\u0143\u0005" +
                    "\u0016\u0000\u0000\u0143\u0145\u0001\u0000\u0000\u0000\u0144\u0140\u0001" +
                    "\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0146\u0001" +
                    "\u0000\u0000\u0000\u0146\u0147\u0005\u0002\u0000\u0000\u0147\u001d\u0001" +
                    "\u0000\u0000\u0000\u0148\u0149\u0005+\u0000\u0000\u0149\u014b\u0005D\u0000" +
                    "\u0000\u014a\u014c\u0003>\u001f\u0000\u014b\u014a\u0001\u0000\u0000\u0000" +
                    "\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u0151\u0001\u0000\u0000\u0000" +
                    "\u014d\u014e\u0005\u0015\u0000\u0000\u014e\u014f\u0003>\u001f\u0000\u014f" +
                    "\u0150\u0005\u0016\u0000\u0000\u0150\u0152\u0001\u0000\u0000\u0000\u0151" +
                    "\u014d\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0152" +
                    "\u0153\u0001\u0000\u0000\u0000\u0153\u0154\u0005;\u0000\u0000\u0154\u0155" +
                    "\u0005D\u0000\u0000\u0155\u0156\u0005\u0002\u0000\u0000\u0156\u001f\u0001" +
                    "\u0000\u0000\u0000\u0157\u0158\u0005-\u0000\u0000\u0158\u015a\u0005D\u0000" +
                    "\u0000\u0159\u015b\u0003>\u001f\u0000\u015a\u0159\u0001\u0000\u0000\u0000" +
                    "\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u0160\u0001\u0000\u0000\u0000" +
                    "\u015c\u015d\u0005\u0015\u0000\u0000\u015d\u015e\u0003>\u001f\u0000\u015e" +
                    "\u015f\u0005\u0016\u0000\u0000\u015f\u0161\u0001\u0000\u0000\u0000\u0160" +
                    "\u015c\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000\u0161" +
                    "\u0162\u0001\u0000\u0000\u0000\u0162\u0166\u0005\u0013\u0000\u0000\u0163" +
                    "\u0165\u0003(\u0014\u0000\u0164\u0163\u0001\u0000\u0000\u0000\u0165\u0168" +
                    "\u0001\u0000\u0000\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0166\u0167" +
                    "\u0001\u0000\u0000\u0000\u0167\u0169\u0001\u0000\u0000\u0000\u0168\u0166" +
                    "\u0001\u0000\u0000\u0000\u0169\u016a\u0005\u0014\u0000\u0000\u016a!\u0001" +
                    "\u0000\u0000\u0000\u016b\u016c\u00058\u0000\u0000\u016c\u016e\u0005D\u0000" +
                    "\u0000\u016d\u016f\u0003>\u001f\u0000\u016e\u016d\u0001\u0000\u0000\u0000" +
                    "\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u0174\u0001\u0000\u0000\u0000" +
                    "\u0170\u0171\u0005\u0015\u0000\u0000\u0171\u0172\u0003>\u001f\u0000\u0172" +
                    "\u0173\u0005\u0016\u0000\u0000\u0173\u0175\u0001\u0000\u0000\u0000\u0174" +
                    "\u0170\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175" +
                    "\u0176\u0001\u0000\u0000\u0000\u0176\u0177\u0005\u0002\u0000\u0000\u0177" +
                    "#\u0001\u0000\u0000\u0000\u0178\u0179\u00059\u0000\u0000\u0179\u017b\u0005" +
                    "D\u0000\u0000\u017a\u017c\u0003>\u001f\u0000\u017b\u017a\u0001\u0000\u0000" +
                    "\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017c\u0181\u0001\u0000\u0000" +
                    "\u0000\u017d\u017e\u0005\u0015\u0000\u0000\u017e\u017f\u0003>\u001f\u0000" +
                    "\u017f\u0180\u0005\u0016\u0000\u0000\u0180\u0182\u0001\u0000\u0000\u0000" +
                    "\u0181\u017d\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000\u0000\u0000" +
                    "\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0187\u0005\u0013\u0000\u0000" +
                    "\u0184\u0186\u0003(\u0014\u0000\u0185\u0184\u0001\u0000\u0000\u0000\u0186" +
                    "\u0189\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0187" +
                    "\u0188\u0001\u0000\u0000\u0000\u0188\u018a\u0001\u0000\u0000\u0000\u0189" +
                    "\u0187\u0001\u0000\u0000\u0000\u018a\u018b\u0005\u0014\u0000\u0000\u018b" +
                    "%\u0001\u0000\u0000\u0000\u018c\u018d\u0005/\u0000\u0000\u018d\u018f\u0005" +
                    "D\u0000\u0000\u018e\u0190\u0003>\u001f\u0000\u018f\u018e\u0001\u0000\u0000" +
                    "\u0000\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u0195\u0001\u0000\u0000" +
                    "\u0000\u0191\u0192\u0005\u0015\u0000\u0000\u0192\u0193\u0003>\u001f\u0000" +
                    "\u0193\u0194\u0005\u0016\u0000\u0000\u0194\u0196\u0001\u0000\u0000\u0000" +
                    "\u0195\u0191\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000" +
                    "\u0196\u0197\u0001\u0000\u0000\u0000\u0197\u0198\u0005\u0002\u0000\u0000" +
                    "\u0198\'\u0001\u0000\u0000\u0000\u0199\u019c\u0003*\u0015\u0000\u019a" +
                    "\u019c\u0003,\u0016\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019b\u019a" +
                    "\u0001\u0000\u0000\u0000\u019c)\u0001\u0000\u0000\u0000\u019d\u019e\u0005" +
                    "$\u0000\u0000\u019e\u019f\u0005D\u0000\u0000\u019f\u01a0\u0005\u0015\u0000" +
                    "\u0000\u01a0\u01a1\u00030\u0018\u0000\u01a1\u01a2\u0005\u0016\u0000\u0000" +
                    "\u01a2\u01a6\u0005\u0013\u0000\u0000\u01a3\u01a5\u00032\u0019\u0000\u01a4" +
                    "\u01a3\u0001\u0000\u0000\u0000\u01a5\u01a8\u0001\u0000\u0000\u0000\u01a6" +
                    "\u01a4\u0001\u0000\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a7" +
                    "\u01a9\u0001\u0000\u0000\u0000\u01a8\u01a6\u0001\u0000\u0000\u0000\u01a9" +
                    "\u01aa\u0005\u0014\u0000\u0000\u01aa+\u0001\u0000\u0000\u0000\u01ab\u01ac" +
                    "\u0005*\u0000\u0000\u01ac\u01ad\u0005D\u0000\u0000\u01ad\u01ae\u0005\u0012" +
                    "\u0000\u0000\u01ae\u01af\u0003:\u001d\u0000\u01af\u01b0\u0005\u0002\u0000" +
                    "\u0000\u01b0-\u0001\u0000\u0000\u0000\u01b1\u01b2\u00051\u0000\u0000\u01b2" +
                    "\u01b3\u0005D\u0000\u0000\u01b3\u01b4\u0005\u0012\u0000\u0000\u01b4\u01b5" +
                    "\u0003:\u001d\u0000\u01b5\u01b6\u0005\u0002\u0000\u0000\u01b6/\u0001\u0000" +
                    "\u0000\u0000\u01b7\u01bc\u0005D\u0000\u0000\u01b8\u01b9\u0005\u0003\u0000" +
                    "\u0000\u01b9\u01bb\u0005D\u0000\u0000\u01ba\u01b8\u0001\u0000\u0000\u0000" +
                    "\u01bb\u01be\u0001\u0000\u0000\u0000\u01bc\u01ba\u0001\u0000\u0000\u0000" +
                    "\u01bc\u01bd\u0001\u0000\u0000\u0000\u01bd\u01c0\u0001\u0000\u0000\u0000" +
                    "\u01be\u01bc\u0001\u0000\u0000\u0000\u01bf\u01b7\u0001\u0000\u0000\u0000" +
                    "\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c01\u0001\u0000\u0000\u0000\u01c1" +
                    "\u01c2\u0003:\u001d\u0000\u01c2\u01c3\u0005\u0002\u0000\u0000\u01c3\u01f0" +
                    "\u0001\u0000\u0000\u0000\u01c4\u01c8\u0005\u0013\u0000\u0000\u01c5\u01c7" +
                    "\u00032\u0019\u0000\u01c6\u01c5\u0001\u0000\u0000\u0000\u01c7\u01ca\u0001" +
                    "\u0000\u0000\u0000\u01c8\u01c6\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001" +
                    "\u0000\u0000\u0000\u01c9\u01cb\u0001\u0000\u0000\u0000\u01ca\u01c8\u0001" +
                    "\u0000\u0000\u0000\u01cb\u01f0\u0005\u0014\u0000\u0000\u01cc\u01cd\u0005" +
                    "\u001e\u0000\u0000\u01cd\u01ce\u0005\u0015\u0000\u0000\u01ce\u01cf\u0003" +
                    ":\u001d\u0000\u01cf\u01d0\u0005\u0016\u0000\u0000\u01d0\u01d3\u00032\u0019" +
                    "\u0000\u01d1\u01d2\u0005%\u0000\u0000\u01d2\u01d4\u00032\u0019\u0000\u01d3" +
                    "\u01d1\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4" +
                    "\u01f0\u0001\u0000\u0000\u0000\u01d5\u01d6\u0005.\u0000\u0000\u01d6\u01d7" +
                    "\u0005\u0015\u0000\u0000\u01d7\u01d8\u0003:\u001d\u0000\u01d8\u01d9\u0005" +
                    "\u0016\u0000\u0000\u01d9\u01da\u00032\u0019\u0000\u01da\u01f0\u0001\u0000" +
                    "\u0000\u0000\u01db\u01dc\u0005#\u0000\u0000\u01dc\u01dd\u0005\u0015\u0000" +
                    "\u0000\u01dd\u01de\u0005D\u0000\u0000\u01de\u01df\u0005 \u0000\u0000\u01df" +
                    "\u01e0\u0003:\u001d\u0000\u01e0\u01e1\u0005\u0016\u0000\u0000\u01e1\u01e2" +
                    "\u00032\u0019\u0000\u01e2\u01f0\u0001\u0000\u0000\u0000\u01e3\u01e4\u0005" +
                    "(\u0000\u0000\u01e4\u01f0\u0005\u0002\u0000\u0000\u01e5\u01e7\u00052\u0000" +
                    "\u0000\u01e6\u01e8\u0003:\u001d\u0000\u01e7\u01e6\u0001\u0000\u0000\u0000" +
                    "\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e8\u01e9\u0001\u0000\u0000\u0000" +
                    "\u01e9\u01f0\u0005\u0002\u0000\u0000\u01ea\u01eb\u00034\u001a\u0000\u01eb" +
                    "\u01ec\u0005\u0012\u0000\u0000\u01ec\u01ed\u0003:\u001d\u0000\u01ed\u01ee" +
                    "\u0005\u0002\u0000\u0000\u01ee\u01f0\u0001\u0000\u0000\u0000\u01ef\u01c1" +
                    "\u0001\u0000\u0000\u0000\u01ef\u01c4\u0001\u0000\u0000\u0000\u01ef\u01cc" +
                    "\u0001\u0000\u0000\u0000\u01ef\u01d5\u0001\u0000\u0000\u0000\u01ef\u01db" +
                    "\u0001\u0000\u0000\u0000\u01ef\u01e3\u0001\u0000\u0000\u0000\u01ef\u01e5" +
                    "\u0001\u0000\u0000\u0000\u01ef\u01ea\u0001\u0000\u0000\u0000\u01f03\u0001" +
                    "\u0000\u0000\u0000\u01f1\u01f5\u0005D\u0000\u0000\u01f2\u01f4\u00036\u001b" +
                    "\u0000\u01f3\u01f2\u0001\u0000\u0000\u0000\u01f4\u01f7\u0001\u0000\u0000" +
                    "\u0000\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000" +
                    "\u0000\u01f65\u0001\u0000\u0000\u0000\u01f7\u01f5\u0001\u0000\u0000\u0000" +
                    "\u01f8\u01f9\u0005\u0001\u0000\u0000\u01f9\u01ff\u0005D\u0000\u0000\u01fa" +
                    "\u01fb\u0005\u0017\u0000\u0000\u01fb\u01fc\u0003:\u001d\u0000\u01fc\u01fd" +
                    "\u0005\u0018\u0000\u0000\u01fd\u01ff\u0001\u0000\u0000\u0000\u01fe\u01f8" +
                    "\u0001\u0000\u0000\u0000\u01fe\u01fa\u0001\u0000\u0000\u0000\u01ff7\u0001" +
                    "\u0000\u0000\u0000\u0200\u0205\u0003:\u001d\u0000\u0201\u0202\u0005\u0003" +
                    "\u0000\u0000\u0202\u0204\u0003:\u001d\u0000\u0203\u0201\u0001\u0000\u0000" +
                    "\u0000\u0204\u0207\u0001\u0000\u0000\u0000\u0205\u0203\u0001\u0000\u0000" +
                    "\u0000\u0205\u0206\u0001\u0000\u0000\u0000\u0206\u0209\u0001\u0000\u0000" +
                    "\u0000\u0207\u0205\u0001\u0000\u0000\u0000\u0208\u0200\u0001\u0000\u0000" +
                    "\u0000\u0208\u0209\u0001\u0000\u0000\u0000\u02099\u0001\u0000\u0000\u0000" +
                    "\u020a\u020b\u0006\u001d\uffff\uffff\u0000\u020b\u0234\u0003<\u001e\u0000" +
                    "\u020c\u0234\u0005D\u0000\u0000\u020d\u020e\u0005D\u0000\u0000\u020e\u020f" +
                    "\u0005\u0015\u0000\u0000\u020f\u0210\u00038\u001c\u0000\u0210\u0211\u0005" +
                    "\u0016\u0000\u0000\u0211\u0234\u0001\u0000\u0000\u0000\u0212\u0213\u0005" +
                    "\u0015\u0000\u0000\u0213\u0214\u0003:\u001d\u0000\u0214\u0215\u0005\u0016" +
                    "\u0000\u0000\u0215\u0234\u0001\u0000\u0000\u0000\u0216\u0217\u0007\u0000" +
                    "\u0000\u0000\u0217\u0234\u0003:\u001d\u0007\u0218\u0219\u0005\u0017\u0000" +
                    "\u0000\u0219\u021e\u0003:\u001d\u0000\u021a\u021b\u0005\u0003\u0000\u0000" +
                    "\u021b\u021d\u0003:\u001d\u0000\u021c\u021a\u0001\u0000\u0000\u0000\u021d" +
                    "\u0220\u0001\u0000\u0000\u0000\u021e\u021c\u0001\u0000\u0000\u0000\u021e" +
                    "\u021f\u0001\u0000\u0000\u0000\u021f\u0221\u0001\u0000\u0000\u0000\u0220" +
                    "\u021e\u0001\u0000\u0000\u0000\u0221\u0222\u0005\u0018\u0000\u0000\u0222" +
                    "\u0234\u0001\u0000\u0000\u0000\u0223\u0224\u0005\u0013\u0000\u0000\u0224" +
                    "\u0225\u0003:\u001d\u0000\u0225\u0226\u0005\u0012\u0000\u0000\u0226\u022e" +
                    "\u0003:\u001d\u0000\u0227\u0228\u0005\u0003\u0000\u0000\u0228\u0229\u0003" +
                    ":\u001d\u0000\u0229\u022a\u0005\u0012\u0000\u0000\u022a\u022b\u0003:\u001d" +
                    "\u0000\u022b\u022d\u0001\u0000\u0000\u0000\u022c\u0227\u0001\u0000\u0000" +
                    "\u0000\u022d\u0230\u0001\u0000\u0000\u0000\u022e\u022c\u0001\u0000\u0000" +
                    "\u0000\u022e\u022f\u0001\u0000\u0000\u0000\u022f\u0231\u0001\u0000\u0000" +
                    "\u0000\u0230\u022e\u0001\u0000\u0000\u0000\u0231\u0232\u0005\u0014\u0000" +
                    "\u0000\u0232\u0234\u0001\u0000\u0000\u0000\u0233\u020a\u0001\u0000\u0000" +
                    "\u0000\u0233\u020c\u0001\u0000\u0000\u0000\u0233\u020d\u0001\u0000\u0000" +
                    "\u0000\u0233\u0212\u0001\u0000\u0000\u0000\u0233\u0216\u0001\u0000\u0000" +
                    "\u0000\u0233\u0218\u0001\u0000\u0000\u0000\u0233\u0223\u0001\u0000\u0000" +
                    "\u0000\u0234\u024b\u0001\u0000\u0000\u0000\u0235\u0236\n\u0006\u0000\u0000" +
                    "\u0236\u0237\u0007\u0001\u0000\u0000\u0237\u024a\u0003:\u001d\u0007\u0238" +
                    "\u0239\n\u0005\u0000\u0000\u0239\u023a\u0007\u0002\u0000\u0000\u023a\u024a" +
                    "\u0003:\u001d\u0006\u023b\u023c\n\u0004\u0000\u0000\u023c\u023d\u0007" +
                    "\u0003\u0000\u0000\u023d\u024a\u0003:\u001d\u0005\u023e\u023f\n\u0003" +
                    "\u0000\u0000\u023f\u0240\u0007\u0004\u0000\u0000\u0240\u024a\u0003:\u001d" +
                    "\u0004\u0241\u0242\n\u000b\u0000\u0000\u0242\u0243\u0005\u0001\u0000\u0000" +
                    "\u0243\u024a\u0005D\u0000\u0000\u0244\u0245\n\n\u0000\u0000\u0245\u0246" +
                    "\u0005\u0017\u0000\u0000\u0246\u0247\u0003:\u001d\u0000\u0247\u0248\u0005" +
                    "\u0018\u0000\u0000\u0248\u024a\u0001\u0000\u0000\u0000\u0249\u0235\u0001" +
                    "\u0000\u0000\u0000\u0249\u0238\u0001\u0000\u0000\u0000\u0249\u023b\u0001" +
                    "\u0000\u0000\u0000\u0249\u023e\u0001\u0000\u0000\u0000\u0249\u0241\u0001" +
                    "\u0000\u0000\u0000\u0249\u0244\u0001\u0000\u0000\u0000\u024a\u024d\u0001" +
                    "\u0000\u0000\u0000\u024b\u0249\u0001\u0000\u0000\u0000\u024b\u024c\u0001" +
                    "\u0000\u0000\u0000\u024c;\u0001\u0000\u0000\u0000\u024d\u024b\u0001\u0000" +
                    "\u0000\u0000\u024e\u0255\u0005=\u0000\u0000\u024f\u0255\u0005?\u0000\u0000" +
                    "\u0250\u0255\u0005@\u0000\u0000\u0251\u0255\u0005B\u0000\u0000\u0252\u0255" +
                    "\u0005C\u0000\u0000\u0253\u0255\u0003>\u001f\u0000\u0254\u024e\u0001\u0000" +
                    "\u0000\u0000\u0254\u024f\u0001\u0000\u0000\u0000\u0254\u0250\u0001\u0000" +
                    "\u0000\u0000\u0254\u0251\u0001\u0000\u0000\u0000\u0254\u0252\u0001\u0000" +
                    "\u0000\u0000\u0254\u0253\u0001\u0000\u0000\u0000\u0255=\u0001\u0000\u0000" +
                    "\u0000\u0256\u025b\u0005E\u0000\u0000\u0257\u0258\u00055\u0000\u0000\u0258" +
                    "\u0259\u0005\u0001\u0000\u0000\u0259\u025b\u0005D\u0000\u0000\u025a\u0256" +
                    "\u0001\u0000\u0000\u0000\u025a\u0257\u0001\u0000\u0000\u0000\u025b?\u0001" +
                    "\u0000\u0000\u0000@CQWesx\u0081\u008a\u009e\u00a3\u00a9\u00af\u00b7\u00bd" +
                    "\u00c0\u00c6\u00ce\u00d6\u00dc\u00e4\u00ec\u00f2\u00fa\u0100\u010e\u0116" +
                    "\u011c\u0122\u012a\u0130\u0136\u013e\u0144\u014b\u0151\u015a\u0160\u0166" +
                    "\u016e\u0174\u017b\u0181\u0187\u018f\u0195\u019b\u01a6\u01bc\u01bf\u01c8" +
                    "\u01d3\u01e7\u01ef\u01f5\u01fe\u0205\u0208\u021e\u022e\u0233\u0249\u024b" +
                    "\u0254\u025a"
        val _ATN = ATNDeserializer().deserialize(_serializedATN.toCharArray())

        init {
            _decisionToDFA = (0 until _ATN.numberOfDecisions).map {
                DFA(_ATN.getDecisionState(it), it)
            }.toTypedArray()
        }
    }
}