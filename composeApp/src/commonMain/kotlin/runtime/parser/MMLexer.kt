// Generated from /home/data/kotlin/MageMythos/composeApp/src/parser/MM.g4 by ANTLR 4.13.1
package runtime.parser

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.Lexer
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
        var channelNames = arrayOf(
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
        )
        var modeNames = arrayOf(
            "DEFAULT_MODE"
        )

        private fun makeRuleNames(): Array<String> {
            return arrayOf(
                "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
                "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16",
                "T__17", "T__18", "T__19", "T__20", "PO", "PC", "BO", "BC", "BRO", "BRC",
                "COMMA", "SEMI", "QMARK", "EQ", "DOT", "COLON", "IF", "FOR", "FUN", "VAR",
                "ELSE", "TRUE", "BREAK", "CONST", "FALSE", "WHILE", "RETURN", "DICE",
                "TAGNAME", "ID", "INT", "FLOAT", "COMMENT", "WS"
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
            "\u0004\u00003\u014b\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001" +
                    "\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004" +
                    "\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007" +
                    "\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b" +
                    "\u0007\u000b\u0002\u000c\u0007\u000c\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002" +
                    "\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002" +
                    "\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002" +
                    "\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002" +
                    "\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002" +
                    "\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002" +
                    "\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007" +
                    "!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007" +
                    "&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007" +
                    "+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007" +
                    "0\u00021\u00071\u00022\u00072\u0001\u0000\u0001\u0000\u0001\u0000\u0001" +
                    "\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001" +
                    "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001" +
                    "\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001" +
                    "\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001" +
                    "\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000c\u0001\u000c\u0001\u000c\u0001\r\u0001\r\u0001\r\u0001" +
                    "\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001" +
                    "\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001" +
                    "\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001" +
                    "\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001" +
                    "\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001" +
                    "\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001" +
                    "\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001" +
                    "\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001" +
                    "\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001" +
                    "\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001\"" +
                    "\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001" +
                    "$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001" +
                    "&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001" +
                    "(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001" +
                    "*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001" +
                    "+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001" +
                    ",\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001" +
                    ",\u0001,\u0003,\u0118\b,\u0001-\u0001-\u0001-\u0005-\u011d\b-\n-\u000c-\u0120" +
                    "\t-\u0001.\u0001.\u0005.\u0124\b.\n.\u000c.\u0127\t.\u0001/\u0004/\u012a\b" +
                    "/\u000b/\u000c/\u012b\u00010\u00050\u012f\b0\n0\u000c0\u0132\t0\u00010\u00010" +
                    "\u00040\u0136\b0\u000b0\u000c0\u0137\u00011\u00011\u00011\u00011\u00051\u013e" +
                    "\b1\n1\u000c1\u0141\t1\u00011\u00011\u00012\u00042\u0146\b2\u000b2\u000c2\u0147" +
                    "\u00012\u00012\u0000\u00003\u0001\u0001\u0003\u0002\u0005\u0003\u0007" +
                    "\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b" +
                    "\u0017\u000c\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013" +
                    "\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d" +
                    ";\u001e=\u001f? A!C\"E#G\$I%K&M\'O(Q)S*U+W,Y-[.]/_0a1c2e3\u0001\u0000\u0006" +
                    "\u0002\u0000AZaz\u0004\u000009AZ__az\u0003\u0000AZ__az\u0001\u000009\u0002" +
                    "\u0000\n\n\r\r\u0003\u0000\t\n\r\r  \u0157\u0000\u0001\u0001\u0000\u0000" +
                    "\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000" +
                    "\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000" +
                    "\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000" +
                    "\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000" +
                    "\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000" +
                    "\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000" +
                    "\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000" +
                    "\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001" +
                    "\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000" +
                    "\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000" +
                    "\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001" +
                    "\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000" +
                    "\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000" +
                    "\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?" +
                    "\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000" +
                    "\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000" +
                    "\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M" +
                    "\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000" +
                    "\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000" +
                    "\u0000W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[" +
                    "\u0001\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000" +
                    "\u0000\u0000\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000" +
                    "\u0000e\u0001\u0000\u0000\u0000\u0001g\u0001\u0000\u0000\u0000\u0003n" +
                    "\u0001\u0000\u0000\u0000\u0005u\u0001\u0000\u0000\u0000\u0007y\u0001\u0000" +
                    "\u0000\u0000\t{\u0001\u0000\u0000\u0000\u000b}\u0001\u0000\u0000\u0000" +
                    "\r\u007f\u0001\u0000\u0000\u0000\u000f\u0081\u0001\u0000\u0000\u0000\u0011" +
                    "\u0083\u0001\u0000\u0000\u0000\u0013\u0085\u0001\u0000\u0000\u0000\u0015" +
                    "\u0087\u0001\u0000\u0000\u0000\u0017\u0089\u0001\u0000\u0000\u0000\u0019" +
                    "\u008c\u0001\u0000\u0000\u0000\u001b\u008f\u0001\u0000\u0000\u0000\u001d" +
                    "\u0092\u0001\u0000\u0000\u0000\u001f\u0095\u0001\u0000\u0000\u0000!\u0098" +
                    "\u0001\u0000\u0000\u0000#\u009b\u0001\u0000\u0000\u0000%\u009e\u0001\u0000" +
                    "\u0000\u0000\'\u00a8\u0001\u0000\u0000\u0000)\u00b2\u0001\u0000\u0000" +
                    "\u0000+\u00b4\u0001\u0000\u0000\u0000-\u00b6\u0001\u0000\u0000\u0000/" +
                    "\u00b8\u0001\u0000\u0000\u00001\u00ba\u0001\u0000\u0000\u00003\u00bc\u0001" +
                    "\u0000\u0000\u00005\u00be\u0001\u0000\u0000\u00007\u00c0\u0001\u0000\u0000" +
                    "\u00009\u00c2\u0001\u0000\u0000\u0000;\u00c4\u0001\u0000\u0000\u0000=" +
                    "\u00c6\u0001\u0000\u0000\u0000?\u00c8\u0001\u0000\u0000\u0000A\u00ca\u0001" +
                    "\u0000\u0000\u0000C\u00cc\u0001\u0000\u0000\u0000E\u00cf\u0001\u0000\u0000" +
                    "\u0000G\u00d3\u0001\u0000\u0000\u0000I\u00d7\u0001\u0000\u0000\u0000K" +
                    "\u00db\u0001\u0000\u0000\u0000M\u00e0\u0001\u0000\u0000\u0000O\u00e5\u0001" +
                    "\u0000\u0000\u0000Q\u00eb\u0001\u0000\u0000\u0000S\u00f1\u0001\u0000\u0000" +
                    "\u0000U\u00f7\u0001\u0000\u0000\u0000W\u00fd\u0001\u0000\u0000\u0000Y" +
                    "\u0117\u0001\u0000\u0000\u0000[\u0119\u0001\u0000\u0000\u0000]\u0121\u0001" +
                    "\u0000\u0000\u0000_\u0129\u0001\u0000\u0000\u0000a\u0130\u0001\u0000\u0000" +
                    "\u0000c\u0139\u0001\u0000\u0000\u0000e\u0145\u0001\u0000\u0000\u0000g" +
                    "h\u0005s\u0000\u0000hi\u0005o\u0000\u0000ij\u0005u\u0000\u0000jk\u0005" +
                    "r\u0000\u0000kl\u0005c\u0000\u0000lm\u0005e\u0000\u0000m\u0002\u0001\u0000" +
                    "\u0000\u0000no\u0005i\u0000\u0000op\u0005m\u0000\u0000pq\u0005p\u0000" +
                    "\u0000qr\u0005o\u0000\u0000rs\u0005r\u0000\u0000st\u0005t\u0000\u0000" +
                    "t\u0004\u0001\u0000\u0000\u0000uv\u0005a\u0000\u0000vw\u0005l\u0000\u0000" +
                    "wx\u0005l\u0000\u0000x\u0006\u0001\u0000\u0000\u0000yz\u0005+\u0000\u0000" +
                    "z\b\u0001\u0000\u0000\u0000{|\u0005-\u0000\u0000|\n\u0001\u0000\u0000" +
                    "\u0000}~\u0005!\u0000\u0000~\u000c\u0001\u0000\u0000\u0000\u007f\u0080\u0005" +
                    "*\u0000\u0000\u0080\u000e\u0001\u0000\u0000\u0000\u0081\u0082\u0005/\u0000" +
                    "\u0000\u0082\u0010\u0001\u0000\u0000\u0000\u0083\u0084\u0005%\u0000\u0000" +
                    "\u0084\u0012\u0001\u0000\u0000\u0000\u0085\u0086\u0005<\u0000\u0000\u0086" +
                    "\u0014\u0001\u0000\u0000\u0000\u0087\u0088\u0005>\u0000\u0000\u0088\u0016" +
                    "\u0001\u0000\u0000\u0000\u0089\u008a\u0005<\u0000\u0000\u008a\u008b\u0005" +
                    "=\u0000\u0000\u008b\u0018\u0001\u0000\u0000\u0000\u008c\u008d\u0005>\u0000" +
                    "\u0000\u008d\u008e\u0005=\u0000\u0000\u008e\u001a\u0001\u0000\u0000\u0000" +
                    "\u008f\u0090\u0005=\u0000\u0000\u0090\u0091\u0005=\u0000\u0000\u0091\u001c" +
                    "\u0001\u0000\u0000\u0000\u0092\u0093\u0005!\u0000\u0000\u0093\u0094\u0005" +
                    "=\u0000\u0000\u0094\u001e\u0001\u0000\u0000\u0000\u0095\u0096\u0005&\u0000" +
                    "\u0000\u0096\u0097\u0005&\u0000\u0000\u0097 \u0001\u0000\u0000\u0000\u0098" +
                    "\u0099\u0005|\u0000\u0000\u0099\u009a\u0005|\u0000\u0000\u009a\"\u0001" +
                    "\u0000\u0000\u0000\u009b\u009c\u0005t\u0000\u0000\u009c\u009d\u0005o\u0000" +
                    "\u0000\u009d$\u0001\u0000\u0000\u0000\u009e\u009f\u0005e\u0000\u0000\u009f" +
                    "\u00a0\u0005x\u0000\u0000\u00a0\u00a1\u0005c\u0000\u0000\u00a1\u00a2\u0005" +
                    "l\u0000\u0000\u00a2\u00a3\u0005u\u0000\u0000\u00a3\u00a4\u0005s\u0000" +
                    "\u0000\u00a4\u00a5\u0005i\u0000\u0000\u00a5\u00a6\u0005v\u0000\u0000\u00a6" +
                    "\u00a7\u0005e\u0000\u0000\u00a7&\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005" +
                    "i\u0000\u0000\u00a9\u00aa\u0005n\u0000\u0000\u00aa\u00ab\u0005c\u0000" +
                    "\u0000\u00ab\u00ac\u0005l\u0000\u0000\u00ac\u00ad\u0005u\u0000\u0000\u00ad" +
                    "\u00ae\u0005s\u0000\u0000\u00ae\u00af\u0005i\u0000\u0000\u00af\u00b0\u0005" +
                    "v\u0000\u0000\u00b0\u00b1\u0005e\u0000\u0000\u00b1(\u0001\u0000\u0000" +
                    "\u0000\u00b2\u00b3\u0005\"\u0000\u0000\u00b3*\u0001\u0000\u0000\u0000" +
                    "\u00b4\u00b5\u0005(\u0000\u0000\u00b5,\u0001\u0000\u0000\u0000\u00b6\u00b7" +
                    "\u0005)\u0000\u0000\u00b7.\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005{" +
                    "\u0000\u0000\u00b90\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005}\u0000\u0000" +
                    "\u00bb2\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005[\u0000\u0000\u00bd4" +
                    "\u0001\u0000\u0000\u0000\u00be\u00bf\u0005]\u0000\u0000\u00bf6\u0001\u0000" +
                    "\u0000\u0000\u00c0\u00c1\u0005,\u0000\u0000\u00c18\u0001\u0000\u0000\u0000" +
                    "\u00c2\u00c3\u0005;\u0000\u0000\u00c3:\u0001\u0000\u0000\u0000\u00c4\u00c5" +
                    "\u0005?\u0000\u0000\u00c5<\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005=" +
                    "\u0000\u0000\u00c7>\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005.\u0000\u0000" +
                    "\u00c9@\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005:\u0000\u0000\u00cbB" +
                    "\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005i\u0000\u0000\u00cd\u00ce\u0005" +
                    "f\u0000\u0000\u00ceD\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005f\u0000" +
                    "\u0000\u00d0\u00d1\u0005o\u0000\u0000\u00d1\u00d2\u0005r\u0000\u0000\u00d2" +
                    "F\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005f\u0000\u0000\u00d4\u00d5\u0005" +
                    "u\u0000\u0000\u00d5\u00d6\u0005n\u0000\u0000\u00d6H\u0001\u0000\u0000" +
                    "\u0000\u00d7\u00d8\u0005v\u0000\u0000\u00d8\u00d9\u0005a\u0000\u0000\u00d9" +
                    "\u00da\u0005r\u0000\u0000\u00daJ\u0001\u0000\u0000\u0000\u00db\u00dc\u0005" +
                    "e\u0000\u0000\u00dc\u00dd\u0005l\u0000\u0000\u00dd\u00de\u0005s\u0000" +
                    "\u0000\u00de\u00df\u0005e\u0000\u0000\u00dfL\u0001\u0000\u0000\u0000\u00e0" +
                    "\u00e1\u0005t\u0000\u0000\u00e1\u00e2\u0005r\u0000\u0000\u00e2\u00e3\u0005" +
                    "u\u0000\u0000\u00e3\u00e4\u0005e\u0000\u0000\u00e4N\u0001\u0000\u0000" +
                    "\u0000\u00e5\u00e6\u0005b\u0000\u0000\u00e6\u00e7\u0005r\u0000\u0000\u00e7" +
                    "\u00e8\u0005e\u0000\u0000\u00e8\u00e9\u0005a\u0000\u0000\u00e9\u00ea\u0005" +
                    "k\u0000\u0000\u00eaP\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005c\u0000" +
                    "\u0000\u00ec\u00ed\u0005o\u0000\u0000\u00ed\u00ee\u0005n\u0000\u0000\u00ee" +
                    "\u00ef\u0005s\u0000\u0000\u00ef\u00f0\u0005t\u0000\u0000\u00f0R\u0001" +
                    "\u0000\u0000\u0000\u00f1\u00f2\u0005f\u0000\u0000\u00f2\u00f3\u0005a\u0000" +
                    "\u0000\u00f3\u00f4\u0005l\u0000\u0000\u00f4\u00f5\u0005s\u0000\u0000\u00f5" +
                    "\u00f6\u0005e\u0000\u0000\u00f6T\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005" +
                    "w\u0000\u0000\u00f8\u00f9\u0005h\u0000\u0000\u00f9\u00fa\u0005i\u0000" +
                    "\u0000\u00fa\u00fb\u0005l\u0000\u0000\u00fb\u00fc\u0005e\u0000\u0000\u00fc" +
                    "V\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005r\u0000\u0000\u00fe\u00ff\u0005" +
                    "e\u0000\u0000\u00ff\u0100\u0005t\u0000\u0000\u0100\u0101\u0005u\u0000" +
                    "\u0000\u0101\u0102\u0005r\u0000\u0000\u0102\u0103\u0005n\u0000\u0000\u0103" +
                    "X\u0001\u0000\u0000\u0000\u0104\u0105\u0005d\u0000\u0000\u0105\u0118\u0005" +
                    "4\u0000\u0000\u0106\u0107\u0005d\u0000\u0000\u0107\u0118\u00056\u0000" +
                    "\u0000\u0108\u0109\u0005d\u0000\u0000\u0109\u0118\u00058\u0000\u0000\u010a" +
                    "\u010b\u0005d\u0000\u0000\u010b\u010c\u00051\u0000\u0000\u010c\u0118\u0005" +
                    "0\u0000\u0000\u010d\u010e\u0005d\u0000\u0000\u010e\u010f\u00051\u0000" +
                    "\u0000\u010f\u0118\u00052\u0000\u0000\u0110\u0111\u0005d\u0000\u0000\u0111" +
                    "\u0112\u00052\u0000\u0000\u0112\u0118\u00050\u0000\u0000\u0113\u0114\u0005" +
                    "d\u0000\u0000\u0114\u0115\u00051\u0000\u0000\u0115\u0116\u00050\u0000" +
                    "\u0000\u0116\u0118\u00050\u0000\u0000\u0117\u0104\u0001\u0000\u0000\u0000" +
                    "\u0117\u0106\u0001\u0000\u0000\u0000\u0117\u0108\u0001\u0000\u0000\u0000" +
                    "\u0117\u010a\u0001\u0000\u0000\u0000\u0117\u010d\u0001\u0000\u0000\u0000" +
                    "\u0117\u0110\u0001\u0000\u0000\u0000\u0117\u0113\u0001\u0000\u0000\u0000" +
                    "\u0118Z\u0001\u0000\u0000\u0000\u0119\u011a\u0005@\u0000\u0000\u011a\u011e" +
                    "\u0007\u0000\u0000\u0000\u011b\u011d\u0007\u0001\u0000\u0000\u011c\u011b" +
                    "\u0001\u0000\u0000\u0000\u011d\u0120\u0001\u0000\u0000\u0000\u011e\u011c" +
                    "\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\\\u0001" +
                    "\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0121\u0125\u0007" +
                    "\u0002\u0000\u0000\u0122\u0124\u0007\u0001\u0000\u0000\u0123\u0122\u0001" +
                    "\u0000\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123\u0001" +
                    "\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126^\u0001\u0000" +
                    "\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u012a\u0007\u0003" +
                    "\u0000\u0000\u0129\u0128\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000" +
                    "\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000" +
                    "\u0000\u0000\u012c`\u0001\u0000\u0000\u0000\u012d\u012f\u0007\u0003\u0000" +
                    "\u0000\u012e\u012d\u0001\u0000\u0000\u0000\u012f\u0132\u0001\u0000\u0000" +
                    "\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000" +
                    "\u0000\u0131\u0133\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000" +
                    "\u0000\u0133\u0135\u0005.\u0000\u0000\u0134\u0136\u0007\u0003\u0000\u0000" +
                    "\u0135\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000" +
                    "\u0137\u0135\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000" +
                    "\u0138b\u0001\u0000\u0000\u0000\u0139\u013a\u0005/\u0000\u0000\u013a\u013b" +
                    "\u0005/\u0000\u0000\u013b\u013f\u0001\u0000\u0000\u0000\u013c\u013e\b" +
                    "\u0004\u0000\u0000\u013d\u013c\u0001\u0000\u0000\u0000\u013e\u0141\u0001" +
                    "\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u013f\u0140\u0001" +
                    "\u0000\u0000\u0000\u0140\u0142\u0001\u0000\u0000\u0000\u0141\u013f\u0001" +
                    "\u0000\u0000\u0000\u0142\u0143\u00061\u0000\u0000\u0143d\u0001\u0000\u0000" +
                    "\u0000\u0144\u0146\u0007\u0005\u0000\u0000\u0145\u0144\u0001\u0000\u0000" +
                    "\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u0145\u0001\u0000\u0000" +
                    "\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000" +
                    "\u0000\u0149\u014a\u00062\u0000\u0000\u014af\u0001\u0000\u0000\u0000\t" +
                    "\u0000\u0117\u011e\u0125\u012b\u0130\u0137\u013f\u0147\u0001\u0006\u0000" +
                    "\u0000"
        val _ATN = ATNDeserializer().deserialize(_serializedATN.toCharArray())

        init {
            _decisionToDFA = (0 until _ATN.numberOfDecisions).map {
                DFA(_ATN.getDecisionState(it), it)
            }.toTypedArray()
        }
    }
}