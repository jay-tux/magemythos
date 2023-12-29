// Generated from /home/data/kotlin/MageMythos/composeApp/src/parser/MM.g4 by ANTLR 4.13.1
package parser.mm

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.Lexer
import org.antlr.v4.runtime.RuleContext
import org.antlr.v4.runtime.RuntimeMetaData
import org.antlr.v4.runtime.Vocabulary
import org.antlr.v4.runtime.VocabularyImpl
import org.antlr.v4.runtime.atn.ATN
import org.antlr.v4.runtime.atn.ATNDeserializer
import org.antlr.v4.runtime.atn.LexerATNSimulator
import org.antlr.v4.runtime.atn.PredictionContextCache
import org.antlr.v4.runtime.dfa.DFA

@Suppress("unused")
class MMLexer(input: CharStream?) : Lexer(input) {
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

    override fun getChannelNames(): Array<String> {
        return Companion.channelNames
    }

    override fun getModeNames(): Array<String> {
        return Companion.modeNames
    }

    override fun getATN(): ATN {
        return _ATN
    }

    override fun action(_localctx: RuleContext?, ruleIndex: Int, actionIndex: Int) {
        when (ruleIndex) {
            26 -> STRING_LIT_action(_localctx, actionIndex)
        }
    }

    private fun STRING_LIT_action(_localctx: RuleContext?, actionIndex: Int) {
        when (actionIndex) {
            0 -> text = text.substring(1, text.length - 1)
        }
    }

    init {
        _interp = LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache)
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
        var channelNames = arrayOf(
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
        )
        var modeNames = arrayOf(
            "DEFAULT_MODE"
        )

        private fun makeRuleNames(): Array<String> {
            return arrayOf(
                "T__0", "DOT", "SEMI", "COMMA", "BLOCK", "END", "P_OPEN", "P_CLOSE",
                "FS_SEP", "IN", "FOR", "ITEM", "RACE", "CLASS", "SKILL", "SPELL", "ENABLE",
                "SOURCE", "ABILITY", "STRINGS", "SUBRACE", "SUBCLASS", "BACKGROUND",
                "DEPENDS_ON", "AUTO_TARGETS", "IDENTIFIER", "STRING_LIT", "NEWLINE",
                "WS", "COMMENT", "ANY"
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
            "\u0004\u0000\u001f\u00f1\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002" +
                    "\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002" +
                    "\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002" +
                    "\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002" +
                    "\u000b\u0007\u000b\u0002\u000c\u0007\u000c\u0002\r\u0007\r\u0002\u000e\u0007\u000e" +
                    "\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011" +
                    "\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014" +
                    "\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017" +
                    "\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a" +
                    "\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d" +
                    "\u0002\u001e\u0007\u001e\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001" +
                    "\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004" +
                    "\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007" +
                    "\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001" +
                    "\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\r\u0001\r\u0001\r" +
                    "\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e" +
                    "\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f" +
                    "\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010" +
                    "\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011" +
                    "\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012" +
                    "\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012" +
                    "\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013" +
                    "\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014" +
                    "\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015" +
                    "\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015" +
                    "\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016" +
                    "\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016" +
                    "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017" +
                    "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018" +
                    "\u0001\u0018\u0001\u0018\u0005\u0018\u00bf\b\u0018\n\u0018\u000c\u0018\u00c2" +
                    "\t\u0018\u0001\u0019\u0001\u0019\u0005\u0019\u00c6\b\u0019\n\u0019\u000c\u0019" +
                    "\u00c9\t\u0019\u0001\u001a\u0001\u001a\u0005\u001a\u00cd\b\u001a\n\u001a" +
                    "\u000c\u001a\u00d0\t\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b" +
                    "\u0004\u001b\u00d6\b\u001b\u000b\u001b\u000c\u001b\u00d7\u0001\u001b\u0001" +
                    "\u001b\u0001\u001c\u0004\u001c\u00dd\b\u001c\u000b\u001c\u000c\u001c\u00de" +
                    "\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d" +
                    "\u0005\u001d\u00e7\b\u001d\n\u001d\u000c\u001d\u00ea\t\u001d\u0001\u001d\u0001" +
                    "\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0000\u0000\u001f" +
                    "\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r" +
                    "\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\u000c\u0019\r\u001b\u000e" +
                    "\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017" +
                    "/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f\u0001\u0000\u0007" +
                    "\u0001\u0000AZ\u0002\u0000AZ__\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001" +
                    "\u0000\"\"\u0002\u0000\n\n\r\r\u0002\u0000\t\t  \u00f6\u0000\u0001\u0001" +
                    "\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001" +
                    "\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000" +
                    "\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000" +
                    "\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000" +
                    "\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000" +
                    "\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000" +
                    "\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000" +
                    "\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000" +
                    "\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'" +
                    "\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000" +
                    "\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000" +
                    "\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005" +
                    "\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000" +
                    "\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000" +
                    "\u0001?\u0001\u0000\u0000\u0000\u0003A\u0001\u0000\u0000\u0000\u0005C" +
                    "\u0001\u0000\u0000\u0000\u0007E\u0001\u0000\u0000\u0000\tG\u0001\u0000" +
                    "\u0000\u0000\u000bI\u0001\u0000\u0000\u0000\rK\u0001\u0000\u0000\u0000" +
                    "\u000fM\u0001\u0000\u0000\u0000\u0011O\u0001\u0000\u0000\u0000\u0013S" +
                    "\u0001\u0000\u0000\u0000\u0015V\u0001\u0000\u0000\u0000\u0017Z\u0001\u0000" +
                    "\u0000\u0000\u0019_\u0001\u0000\u0000\u0000\u001bd\u0001\u0000\u0000\u0000" +
                    "\u001dj\u0001\u0000\u0000\u0000\u001fp\u0001\u0000\u0000\u0000!v\u0001" +
                    "\u0000\u0000\u0000#}\u0001\u0000\u0000\u0000%\u0084\u0001\u0000\u0000" +
                    "\u0000\'\u008c\u0001\u0000\u0000\u0000)\u0094\u0001\u0000\u0000\u0000" +
                    "+\u009c\u0001\u0000\u0000\u0000-\u00a5\u0001\u0000\u0000\u0000/\u00b0" +
                    "\u0001\u0000\u0000\u00001\u00bb\u0001\u0000\u0000\u00003\u00c3\u0001\u0000" +
                    "\u0000\u00005\u00ca\u0001\u0000\u0000\u00007\u00d5\u0001\u0000\u0000\u0000" +
                    "9\u00dc\u0001\u0000\u0000\u0000;\u00e2\u0001\u0000\u0000\u0000=\u00ef" +
                    "\u0001\u0000\u0000\u0000?@\u0005=\u0000\u0000@\u0002\u0001\u0000\u0000" +
                    "\u0000AB\u0005.\u0000\u0000B\u0004\u0001\u0000\u0000\u0000CD\u0005;\u0000" +
                    "\u0000D\u0006\u0001\u0000\u0000\u0000EF\u0005,\u0000\u0000F\b\u0001\u0000" +
                    "\u0000\u0000GH\u0005{\u0000\u0000H\n\u0001\u0000\u0000\u0000IJ\u0005}" +
                    "\u0000\u0000J\u000c\u0001\u0000\u0000\u0000KL\u0005(\u0000\u0000L\u000e\u0001" +
                    "\u0000\u0000\u0000MN\u0005)\u0000\u0000N\u0010\u0001\u0000\u0000\u0000" +
                    "OP\u0005#\u0000\u0000PQ\u0005~\u0000\u0000QR\u0005#\u0000\u0000R\u0012" +
                    "\u0001\u0000\u0000\u0000ST\u0005i\u0000\u0000TU\u0005n\u0000\u0000U\u0014" +
                    "\u0001\u0000\u0000\u0000VW\u0005f\u0000\u0000WX\u0005o\u0000\u0000XY\u0005" +
                    "r\u0000\u0000Y\u0016\u0001\u0000\u0000\u0000Z[\u0005i\u0000\u0000[\\\u0005" +
                    "t\u0000\u0000\\]\u0005e\u0000\u0000]^\u0005m\u0000\u0000^\u0018\u0001" +
                    "\u0000\u0000\u0000_`\u0005r\u0000\u0000`a\u0005a\u0000\u0000ab\u0005c" +
                    "\u0000\u0000bc\u0005e\u0000\u0000c\u001a\u0001\u0000\u0000\u0000de\u0005" +
                    "c\u0000\u0000ef\u0005l\u0000\u0000fg\u0005a\u0000\u0000gh\u0005s\u0000" +
                    "\u0000hi\u0005s\u0000\u0000i\u001c\u0001\u0000\u0000\u0000jk\u0005s\u0000" +
                    "\u0000kl\u0005k\u0000\u0000lm\u0005i\u0000\u0000mn\u0005l\u0000\u0000" +
                    "no\u0005l\u0000\u0000o\u001e\u0001\u0000\u0000\u0000pq\u0005s\u0000\u0000" +
                    "qr\u0005p\u0000\u0000rs\u0005e\u0000\u0000st\u0005l\u0000\u0000tu\u0005" +
                    "l\u0000\u0000u \u0001\u0000\u0000\u0000vw\u0005e\u0000\u0000wx\u0005n" +
                    "\u0000\u0000xy\u0005a\u0000\u0000yz\u0005b\u0000\u0000z{\u0005l\u0000" +
                    "\u0000{|\u0005e\u0000\u0000|\"\u0001\u0000\u0000\u0000}~\u0005s\u0000" +
                    "\u0000~\u007f\u0005o\u0000\u0000\u007f\u0080\u0005u\u0000\u0000\u0080" +
                    "\u0081\u0005r\u0000\u0000\u0081\u0082\u0005c\u0000\u0000\u0082\u0083\u0005" +
                    "e\u0000\u0000\u0083$\u0001\u0000\u0000\u0000\u0084\u0085\u0005a\u0000" +
                    "\u0000\u0085\u0086\u0005b\u0000\u0000\u0086\u0087\u0005i\u0000\u0000\u0087" +
                    "\u0088\u0005l\u0000\u0000\u0088\u0089\u0005i\u0000\u0000\u0089\u008a\u0005" +
                    "t\u0000\u0000\u008a\u008b\u0005y\u0000\u0000\u008b&\u0001\u0000\u0000" +
                    "\u0000\u008c\u008d\u0005s\u0000\u0000\u008d\u008e\u0005t\u0000\u0000\u008e" +
                    "\u008f\u0005r\u0000\u0000\u008f\u0090\u0005i\u0000\u0000\u0090\u0091\u0005" +
                    "n\u0000\u0000\u0091\u0092\u0005g\u0000\u0000\u0092\u0093\u0005s\u0000" +
                    "\u0000\u0093(\u0001\u0000\u0000\u0000\u0094\u0095\u0005s\u0000\u0000\u0095" +
                    "\u0096\u0005u\u0000\u0000\u0096\u0097\u0005b\u0000\u0000\u0097\u0098\u0005" +
                    "r\u0000\u0000\u0098\u0099\u0005a\u0000\u0000\u0099\u009a\u0005c\u0000" +
                    "\u0000\u009a\u009b\u0005e\u0000\u0000\u009b*\u0001\u0000\u0000\u0000\u009c" +
                    "\u009d\u0005s\u0000\u0000\u009d\u009e\u0005u\u0000\u0000\u009e\u009f\u0005" +
                    "b\u0000\u0000\u009f\u00a0\u0005c\u0000\u0000\u00a0\u00a1\u0005l\u0000" +
                    "\u0000\u00a1\u00a2\u0005a\u0000\u0000\u00a2\u00a3\u0005s\u0000\u0000\u00a3" +
                    "\u00a4\u0005s\u0000\u0000\u00a4,\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005" +
                    "b\u0000\u0000\u00a6\u00a7\u0005a\u0000\u0000\u00a7\u00a8\u0005c\u0000" +
                    "\u0000\u00a8\u00a9\u0005k\u0000\u0000\u00a9\u00aa\u0005g\u0000\u0000\u00aa" +
                    "\u00ab\u0005r\u0000\u0000\u00ab\u00ac\u0005o\u0000\u0000\u00ac\u00ad\u0005" +
                    "u\u0000\u0000\u00ad\u00ae\u0005n\u0000\u0000\u00ae\u00af\u0005d\u0000" +
                    "\u0000\u00af.\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005d\u0000\u0000\u00b1" +
                    "\u00b2\u0005e\u0000\u0000\u00b2\u00b3\u0005p\u0000\u0000\u00b3\u00b4\u0005" +
                    "e\u0000\u0000\u00b4\u00b5\u0005n\u0000\u0000\u00b5\u00b6\u0005d\u0000" +
                    "\u0000\u00b6\u00b7\u0005s\u0000\u0000\u00b7\u00b8\u0005 \u0000\u0000\u00b8" +
                    "\u00b9\u0005o\u0000\u0000\u00b9\u00ba\u0005n\u0000\u0000\u00ba0\u0001" +
                    "\u0000\u0000\u0000\u00bb\u00bc\u0005$\u0000\u0000\u00bc\u00c0\u0007\u0000" +
                    "\u0000\u0000\u00bd\u00bf\u0007\u0001\u0000\u0000\u00be\u00bd\u0001\u0000" +
                    "\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000" +
                    "\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c12\u0001\u0000\u0000" +
                    "\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u00c7\u0007\u0002\u0000" +
                    "\u0000\u00c4\u00c6\u0007\u0003\u0000\u0000\u00c5\u00c4\u0001\u0000\u0000" +
                    "\u0000\u00c6\u00c9\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000" +
                    "\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c84\u0001\u0000\u0000\u0000" +
                    "\u00c9\u00c7\u0001\u0000\u0000\u0000\u00ca\u00ce\u0005\"\u0000\u0000\u00cb" +
                    "\u00cd\b\u0004\u0000\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cd\u00d0" +
                    "\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf" +
                    "\u0001\u0000\u0000\u0000\u00cf\u00d1\u0001\u0000\u0000\u0000\u00d0\u00ce" +
                    "\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005\"\u0000\u0000\u00d2\u00d3\u0006" +
                    "\u001a\u0000\u0000\u00d36\u0001\u0000\u0000\u0000\u00d4\u00d6\u0007\u0005" +
                    "\u0000\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000" +
                    "\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000" +
                    "\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da\u0006\u001b" +
                    "\u0001\u0000\u00da8\u0001\u0000\u0000\u0000\u00db\u00dd\u0007\u0006\u0000" +
                    "\u0000\u00dc\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000" +
                    "\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000" +
                    "\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e1\u0006\u001c\u0001" +
                    "\u0000\u00e1:\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005/\u0000\u0000\u00e3" +
                    "\u00e4\u0005/\u0000\u0000\u00e4\u00e8\u0001\u0000\u0000\u0000\u00e5\u00e7" +
                    "\b\u0005\u0000\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e7\u00ea\u0001" +
                    "\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001" +
                    "\u0000\u0000\u0000\u00e9\u00eb\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001" +
                    "\u0000\u0000\u0000\u00eb\u00ec\u0007\u0005\u0000\u0000\u00ec\u00ed\u0001" +
                    "\u0000\u0000\u0000\u00ed\u00ee\u0006\u001d\u0001\u0000\u00ee<\u0001\u0000" +
                    "\u0000\u0000\u00ef\u00f0\t\u0000\u0000\u0000\u00f0>\u0001\u0000\u0000" +
                    "\u0000\u0007\u0000\u00c0\u00c7\u00ce\u00d7\u00de\u00e8\u0002\u0001\u001a" +
                    "\u0000\u0000\u0001\u0000"
        val _ATN = ATNDeserializer().deserialize(_serializedATN.toCharArray())

        init {
            _decisionToDFA = (0 until _ATN.numberOfDecisions).map {
                DFA(_ATN.getDecisionState(it), it)
            }.toTypedArray()
        }
    }
}