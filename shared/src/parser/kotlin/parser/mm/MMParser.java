// Generated from /home/data/kotlin/MageMythos/antlr/MM.g4 by ANTLR 4.13.1
package parser.mm;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, SEMI=2, COMMA=3, MULT=4, DIV=5, MOD=6, PLUS=7, MINUS=8, GT=9, LT=10, 
		GE=11, LE=12, EQ=13, NE=14, AND=15, OR=16, ASSIGN=17, PLUS_ASSIGN=18, 
		MINUS_ASSIGN=19, MULT_ASSIGN=20, DIV_ASSIGN=21, MOD_ASSIGN=22, BLOCK=23, 
		END=24, P_OPEN=25, P_CLOSE=26, BR_OPEN=27, BR_CLOSE=28, FS_SEP=29, D=30, 
		CP=31, FT=32, GP=33, IF=34, LB=35, IN=36, PP=37, SP=38, FOR=39, FUN=40, 
		ELSE=41, ITEM=42, RACE=43, CLASS=44, SKILL=45, SPELL=46, TRAIT=47, WHILE=48, 
		DAMAGE=49, ENABLE=50, SOURCE=51, ABILITY=52, STRINGS=53, SUBRACE=54, SUBCLASS=55, 
		ITEM_TAG=56, ITEM_TRAIT=57, BACKGROUND=58, DEPENDS_ON=59, ALLOW_SUBRACE=60, 
		NUMBER=61, AUTO_TARGETS=62, DICE_LIT=63, DIST_LIT=64, CURRENCY=65, CURRENCY_LIT=66, 
		WEIGHT_LIT=67, IDENTIFIER=68, STRING_LIT=69, NEWLINE=70, WS=71, COMMENT=72, 
		ML_COMMENT=73, ANY=74;
	public static final int
		RULE_strings = 0, RULE_singleString = 1, RULE_mageProg = 2, RULE_header = 3, 
		RULE_setStrings = 4, RULE_enables = 5, RULE_topLevel = 6, RULE_classDecl = 7, 
		RULE_raceDecl = 8, RULE_subclassDecl = 9, RULE_subRaceDecl = 10, RULE_itemDecl = 11, 
		RULE_spellDecl = 12, RULE_backgroundDecl = 13, RULE_abilityDecl = 14, 
		RULE_skillDecl = 15, RULE_traitDecl = 16, RULE_itemTagDecl = 17, RULE_itemTraitDecl = 18, 
		RULE_damageDecl = 19, RULE_declBody = 20, RULE_funDecl = 21, RULE_identifierSet = 22, 
		RULE_stmt = 23, RULE_ref = 24, RULE_args = 25, RULE_expr = 26, RULE_literal = 27, 
		RULE_description = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"strings", "singleString", "mageProg", "header", "setStrings", "enables", 
			"topLevel", "classDecl", "raceDecl", "subclassDecl", "subRaceDecl", "itemDecl", 
			"spellDecl", "backgroundDecl", "abilityDecl", "skillDecl", "traitDecl", 
			"itemTagDecl", "itemTraitDecl", "damageDecl", "declBody", "funDecl", 
			"identifierSet", "stmt", "ref", "args", "expr", "literal", "description"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "';'", "','", "'*'", "'/'", "'%'", "'+'", "'-'", "'>'", 
			"'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "'='", "'+='", 
			"'-='", "'*='", "'/='", "'%='", "'{'", "'}'", "'('", "')'", "'['", "']'", 
			"'#~#'", null, "'cp'", "'ft'", "'gp'", "'if'", "'lb'", "'in'", "'pp'", 
			"'sp'", "'for'", "'fun'", "'else'", "'item'", "'race'", "'class'", "'skill'", 
			"'spell'", "'trait'", "'while'", "'damage'", "'enable'", "'source'", 
			"'ability'", "'strings'", "'subrace'", "'subclass'", "'item_tag'", "'item_trait'", 
			"'background'", "'depends on'", "'allow subrace'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringsContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MMParser.EOF, 0); }
		public List<SingleStringContext> singleString() {
			return getRuleContexts(SingleStringContext.class);
		}
		public SingleStringContext singleString(int i) {
			return getRuleContext(SingleStringContext.class,i);
		}
		public StringsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strings; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitStrings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringsContext strings() throws RecognitionException {
		StringsContext _localctx = new StringsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_strings);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(58);
				singleString();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SingleStringContext extends ParserRuleContext {
		public Token key;
		public Token value;
		public TerminalNode ASSIGN() { return getToken(MMParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LIT() { return getToken(MMParser.STRING_LIT, 0); }
		public SingleStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleString; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitSingleString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStringContext singleString() throws RecognitionException {
		SingleStringContext _localctx = new SingleStringContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_singleString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			((SingleStringContext)_localctx).key = match(IDENTIFIER);
			setState(67);
			match(ASSIGN);
			setState(68);
			((SingleStringContext)_localctx).value = match(STRING_LIT);
			setState(69);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MageProgContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MMParser.EOF, 0); }
		public List<EnablesContext> enables() {
			return getRuleContexts(EnablesContext.class);
		}
		public EnablesContext enables(int i) {
			return getRuleContext(EnablesContext.class,i);
		}
		public List<TopLevelContext> topLevel() {
			return getRuleContexts(TopLevelContext.class);
		}
		public TopLevelContext topLevel(int i) {
			return getRuleContext(TopLevelContext.class,i);
		}
		public MageProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mageProg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitMageProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MageProgContext mageProg() throws RecognitionException {
		MageProgContext _localctx = new MageProgContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mageProg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			header();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ENABLE) {
				{
				{
				setState(72);
				enables();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 563791079816560640L) != 0)) {
				{
				{
				setState(78);
				topLevel();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderContext extends ParserRuleContext {
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
	 
		public HeaderContext() { }
		public void copyFrom(HeaderContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SourceHeaderStringsContext extends HeaderContext {
		public Token src;
		public TerminalNode SOURCE() { return getToken(MMParser.SOURCE, 0); }
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public SetStringsContext setStrings() {
			return getRuleContext(SetStringsContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public SourceHeaderStringsContext(HeaderContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitSourceHeaderStrings(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SourceHeaderDepsStringsContext extends HeaderContext {
		public Token src;
		public Token deps;
		public TerminalNode SOURCE() { return getToken(MMParser.SOURCE, 0); }
		public TerminalNode DEPENDS_ON() { return getToken(MMParser.DEPENDS_ON, 0); }
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public SetStringsContext setStrings() {
			return getRuleContext(SetStringsContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public List<TerminalNode> STRING_LIT() { return getTokens(MMParser.STRING_LIT); }
		public TerminalNode STRING_LIT(int i) {
			return getToken(MMParser.STRING_LIT, i);
		}
		public SourceHeaderDepsStringsContext(HeaderContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitSourceHeaderDepsStrings(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SourceHeaderDepsContext extends HeaderContext {
		public Token src;
		public Token deps;
		public TerminalNode SOURCE() { return getToken(MMParser.SOURCE, 0); }
		public TerminalNode DEPENDS_ON() { return getToken(MMParser.DEPENDS_ON, 0); }
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public List<TerminalNode> STRING_LIT() { return getTokens(MMParser.STRING_LIT); }
		public TerminalNode STRING_LIT(int i) {
			return getToken(MMParser.STRING_LIT, i);
		}
		public SourceHeaderDepsContext(HeaderContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitSourceHeaderDeps(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SourceHeaderContext extends HeaderContext {
		public Token src;
		public TerminalNode SOURCE() { return getToken(MMParser.SOURCE, 0); }
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public SourceHeaderContext(HeaderContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitSourceHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_header);
		int _la;
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new SourceHeaderContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(SOURCE);
				setState(87);
				((SourceHeaderContext)_localctx).src = match(IDENTIFIER);
				setState(88);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new SourceHeaderDepsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(SOURCE);
				setState(90);
				((SourceHeaderDepsContext)_localctx).src = match(IDENTIFIER);
				setState(91);
				match(DEPENDS_ON);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==STRING_LIT) {
					{
					{
					setState(92);
					((SourceHeaderDepsContext)_localctx).deps = match(STRING_LIT);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new SourceHeaderStringsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				match(SOURCE);
				setState(100);
				((SourceHeaderStringsContext)_localctx).src = match(IDENTIFIER);
				setState(101);
				match(SEMI);
				setState(102);
				setStrings();
				}
				break;
			case 4:
				_localctx = new SourceHeaderDepsStringsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
				match(SOURCE);
				setState(104);
				((SourceHeaderDepsStringsContext)_localctx).src = match(IDENTIFIER);
				setState(105);
				match(DEPENDS_ON);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==STRING_LIT) {
					{
					{
					setState(106);
					((SourceHeaderDepsStringsContext)_localctx).deps = match(STRING_LIT);
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
				match(SEMI);
				setState(113);
				setStrings();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetStringsContext extends ParserRuleContext {
		public Token file;
		public TerminalNode STRINGS() { return getToken(MMParser.STRINGS, 0); }
		public TerminalNode IN() { return getToken(MMParser.IN, 0); }
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public List<TerminalNode> STRING_LIT() { return getTokens(MMParser.STRING_LIT); }
		public TerminalNode STRING_LIT(int i) {
			return getToken(MMParser.STRING_LIT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MMParser.COMMA, i);
		}
		public SetStringsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setStrings; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitSetStrings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetStringsContext setStrings() throws RecognitionException {
		SetStringsContext _localctx = new SetStringsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_setStrings);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(STRINGS);
			setState(117);
			match(IN);
			setState(118);
			((SetStringsContext)_localctx).file = match(STRING_LIT);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(119);
				match(COMMA);
				setState(120);
				((SetStringsContext)_localctx).file = match(STRING_LIT);
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnablesContext extends ParserRuleContext {
		public TerminalNode ENABLE() { return getToken(MMParser.ENABLE, 0); }
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public List<TerminalNode> AUTO_TARGETS() { return getTokens(MMParser.AUTO_TARGETS); }
		public TerminalNode AUTO_TARGETS(int i) {
			return getToken(MMParser.AUTO_TARGETS, i);
		}
		public EnablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enables; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitEnables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnablesContext enables() throws RecognitionException {
		EnablesContext _localctx = new EnablesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_enables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(ENABLE);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AUTO_TARGETS) {
				{
				{
				setState(129);
				match(AUTO_TARGETS);
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TopLevelContext extends ParserRuleContext {
		public TopLevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevel; }
	 
		public TopLevelContext() { }
		public void copyFrom(TopLevelContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndSpellContext extends TopLevelContext {
		public SpellDeclContext spellDecl() {
			return getRuleContext(SpellDeclContext.class,0);
		}
		public DndSpellContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndSpell(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndItemContext extends TopLevelContext {
		public ItemDeclContext itemDecl() {
			return getRuleContext(ItemDeclContext.class,0);
		}
		public DndItemContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndItem(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndItemTagContext extends TopLevelContext {
		public ItemTagDeclContext itemTagDecl() {
			return getRuleContext(ItemTagDeclContext.class,0);
		}
		public DndItemTagContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndItemTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndRaceContext extends TopLevelContext {
		public RaceDeclContext raceDecl() {
			return getRuleContext(RaceDeclContext.class,0);
		}
		public DndRaceContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndRace(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndAbilityContext extends TopLevelContext {
		public AbilityDeclContext abilityDecl() {
			return getRuleContext(AbilityDeclContext.class,0);
		}
		public DndAbilityContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndAbility(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndTraitContext extends TopLevelContext {
		public TraitDeclContext traitDecl() {
			return getRuleContext(TraitDeclContext.class,0);
		}
		public DndTraitContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndTrait(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndSubClassContext extends TopLevelContext {
		public SubclassDeclContext subclassDecl() {
			return getRuleContext(SubclassDeclContext.class,0);
		}
		public DndSubClassContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndSubClass(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndBgContext extends TopLevelContext {
		public BackgroundDeclContext backgroundDecl() {
			return getRuleContext(BackgroundDeclContext.class,0);
		}
		public DndBgContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndBg(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndItemTraitContext extends TopLevelContext {
		public ItemTraitDeclContext itemTraitDecl() {
			return getRuleContext(ItemTraitDeclContext.class,0);
		}
		public DndItemTraitContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndItemTrait(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndSubRaceContext extends TopLevelContext {
		public SubRaceDeclContext subRaceDecl() {
			return getRuleContext(SubRaceDeclContext.class,0);
		}
		public DndSubRaceContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndSubRace(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndClassContext extends TopLevelContext {
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public DndClassContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndClass(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndDamageContext extends TopLevelContext {
		public DamageDeclContext damageDecl() {
			return getRuleContext(DamageDeclContext.class,0);
		}
		public DndDamageContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndDamage(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends TopLevelContext {
		public FunDeclContext funDecl() {
			return getRuleContext(FunDeclContext.class,0);
		}
		public FunctionContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DndSkillContext extends TopLevelContext {
		public SkillDeclContext skillDecl() {
			return getRuleContext(SkillDeclContext.class,0);
		}
		public DndSkillContext(TopLevelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDndSkill(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopLevelContext topLevel() throws RecognitionException {
		TopLevelContext _localctx = new TopLevelContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_topLevel);
		try {
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				_localctx = new DndClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				classDecl();
				}
				break;
			case RACE:
				_localctx = new DndRaceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				raceDecl();
				}
				break;
			case SUBCLASS:
				_localctx = new DndSubClassContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				subclassDecl();
				}
				break;
			case SUBRACE:
				_localctx = new DndSubRaceContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				subRaceDecl();
				}
				break;
			case ITEM:
				_localctx = new DndItemContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(141);
				itemDecl();
				}
				break;
			case SPELL:
				_localctx = new DndSpellContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(142);
				spellDecl();
				}
				break;
			case BACKGROUND:
				_localctx = new DndBgContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(143);
				backgroundDecl();
				}
				break;
			case ABILITY:
				_localctx = new DndAbilityContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(144);
				abilityDecl();
				}
				break;
			case SKILL:
				_localctx = new DndSkillContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(145);
				skillDecl();
				}
				break;
			case TRAIT:
				_localctx = new DndTraitContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(146);
				traitDecl();
				}
				break;
			case ITEM_TRAIT:
				_localctx = new DndItemTraitContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(147);
				itemTraitDecl();
				}
				break;
			case DAMAGE:
				_localctx = new DndDamageContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(148);
				damageDecl();
				}
				break;
			case ITEM_TAG:
				_localctx = new DndItemTagContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(149);
				itemTagDecl();
				}
				break;
			case FUN:
				_localctx = new FunctionContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(150);
				funDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public DescriptionContext d;
		public TerminalNode CLASS() { return getToken(MMParser.CLASS, 0); }
		public TerminalNode BLOCK() { return getToken(MMParser.BLOCK, 0); }
		public TerminalNode END() { return getToken(MMParser.END, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public List<DeclBodyContext> declBody() {
			return getRuleContexts(DeclBodyContext.class);
		}
		public DeclBodyContext declBody(int i) {
			return getRuleContext(DeclBodyContext.class,i);
		}
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(CLASS);
			setState(154);
			((ClassDeclContext)_localctx).name = match(IDENTIFIER);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(155);
				((ClassDeclContext)_localctx).dispName = description();
				}
			}

			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(158);
				match(P_OPEN);
				setState(159);
				((ClassDeclContext)_localctx).d = description();
				setState(160);
				match(P_CLOSE);
				}
			}

			setState(164);
			match(BLOCK);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(165);
				declBody();
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(171);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RaceDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public DescriptionContext d;
		public TerminalNode RACE() { return getToken(MMParser.RACE, 0); }
		public TerminalNode BLOCK() { return getToken(MMParser.BLOCK, 0); }
		public TerminalNode END() { return getToken(MMParser.END, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public TerminalNode ALLOW_SUBRACE() { return getToken(MMParser.ALLOW_SUBRACE, 0); }
		public List<DeclBodyContext> declBody() {
			return getRuleContexts(DeclBodyContext.class);
		}
		public DeclBodyContext declBody(int i) {
			return getRuleContext(DeclBodyContext.class,i);
		}
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public RaceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raceDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitRaceDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RaceDeclContext raceDecl() throws RecognitionException {
		RaceDeclContext _localctx = new RaceDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_raceDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(RACE);
			setState(174);
			((RaceDeclContext)_localctx).name = match(IDENTIFIER);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(175);
				((RaceDeclContext)_localctx).dispName = description();
				}
			}

			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(178);
				match(P_OPEN);
				setState(179);
				((RaceDeclContext)_localctx).d = description();
				setState(180);
				match(P_CLOSE);
				}
			}

			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALLOW_SUBRACE) {
				{
				setState(184);
				match(ALLOW_SUBRACE);
				}
			}

			setState(187);
			match(BLOCK);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(188);
				declBody();
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(194);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubclassDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public Token cls;
		public DescriptionContext d;
		public TerminalNode SUBCLASS() { return getToken(MMParser.SUBCLASS, 0); }
		public TerminalNode FOR() { return getToken(MMParser.FOR, 0); }
		public TerminalNode BLOCK() { return getToken(MMParser.BLOCK, 0); }
		public TerminalNode END() { return getToken(MMParser.END, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(MMParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MMParser.IDENTIFIER, i);
		}
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public List<DeclBodyContext> declBody() {
			return getRuleContexts(DeclBodyContext.class);
		}
		public DeclBodyContext declBody(int i) {
			return getRuleContext(DeclBodyContext.class,i);
		}
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public SubclassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subclassDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitSubclassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubclassDeclContext subclassDecl() throws RecognitionException {
		SubclassDeclContext _localctx = new SubclassDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_subclassDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(SUBCLASS);
			setState(197);
			((SubclassDeclContext)_localctx).name = match(IDENTIFIER);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(198);
				((SubclassDeclContext)_localctx).dispName = description();
				}
			}

			setState(201);
			match(FOR);
			setState(202);
			((SubclassDeclContext)_localctx).cls = match(IDENTIFIER);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(203);
				match(P_OPEN);
				setState(204);
				((SubclassDeclContext)_localctx).d = description();
				setState(205);
				match(P_CLOSE);
				}
			}

			setState(209);
			match(BLOCK);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(210);
				declBody();
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(216);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubRaceDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public Token race;
		public DescriptionContext d;
		public TerminalNode SUBRACE() { return getToken(MMParser.SUBRACE, 0); }
		public TerminalNode FOR() { return getToken(MMParser.FOR, 0); }
		public TerminalNode BLOCK() { return getToken(MMParser.BLOCK, 0); }
		public TerminalNode END() { return getToken(MMParser.END, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(MMParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MMParser.IDENTIFIER, i);
		}
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public List<DeclBodyContext> declBody() {
			return getRuleContexts(DeclBodyContext.class);
		}
		public DeclBodyContext declBody(int i) {
			return getRuleContext(DeclBodyContext.class,i);
		}
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public SubRaceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subRaceDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitSubRaceDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubRaceDeclContext subRaceDecl() throws RecognitionException {
		SubRaceDeclContext _localctx = new SubRaceDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_subRaceDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(SUBRACE);
			setState(219);
			((SubRaceDeclContext)_localctx).name = match(IDENTIFIER);
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(220);
				((SubRaceDeclContext)_localctx).dispName = description();
				}
			}

			setState(223);
			match(FOR);
			setState(224);
			((SubRaceDeclContext)_localctx).race = match(IDENTIFIER);
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(225);
				match(P_OPEN);
				setState(226);
				((SubRaceDeclContext)_localctx).d = description();
				setState(227);
				match(P_CLOSE);
				}
			}

			setState(231);
			match(BLOCK);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(232);
				declBody();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(238);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ItemDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public DescriptionContext d;
		public Token worth;
		public Token weight;
		public IdentifierSetContext traits;
		public IdentifierSetContext tags;
		public TerminalNode ITEM() { return getToken(MMParser.ITEM, 0); }
		public List<TerminalNode> P_OPEN() { return getTokens(MMParser.P_OPEN); }
		public TerminalNode P_OPEN(int i) {
			return getToken(MMParser.P_OPEN, i);
		}
		public List<TerminalNode> P_CLOSE() { return getTokens(MMParser.P_CLOSE); }
		public TerminalNode P_CLOSE(int i) {
			return getToken(MMParser.P_CLOSE, i);
		}
		public TerminalNode BR_OPEN() { return getToken(MMParser.BR_OPEN, 0); }
		public TerminalNode BR_CLOSE() { return getToken(MMParser.BR_CLOSE, 0); }
		public TerminalNode BLOCK() { return getToken(MMParser.BLOCK, 0); }
		public TerminalNode END() { return getToken(MMParser.END, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public TerminalNode CURRENCY_LIT() { return getToken(MMParser.CURRENCY_LIT, 0); }
		public TerminalNode WEIGHT_LIT() { return getToken(MMParser.WEIGHT_LIT, 0); }
		public List<IdentifierSetContext> identifierSet() {
			return getRuleContexts(IdentifierSetContext.class);
		}
		public IdentifierSetContext identifierSet(int i) {
			return getRuleContext(IdentifierSetContext.class,i);
		}
		public List<DeclBodyContext> declBody() {
			return getRuleContexts(DeclBodyContext.class);
		}
		public DeclBodyContext declBody(int i) {
			return getRuleContext(DeclBodyContext.class,i);
		}
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public ItemDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitItemDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemDeclContext itemDecl() throws RecognitionException {
		ItemDeclContext _localctx = new ItemDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_itemDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(ITEM);
			setState(241);
			((ItemDeclContext)_localctx).name = match(IDENTIFIER);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(242);
				((ItemDeclContext)_localctx).dispName = description();
				}
			}

			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(245);
				match(P_OPEN);
				setState(246);
				((ItemDeclContext)_localctx).d = description();
				setState(247);
				match(P_CLOSE);
				}
			}

			setState(251);
			((ItemDeclContext)_localctx).worth = match(CURRENCY_LIT);
			setState(252);
			((ItemDeclContext)_localctx).weight = match(WEIGHT_LIT);
			setState(253);
			match(P_OPEN);
			setState(254);
			((ItemDeclContext)_localctx).traits = identifierSet();
			setState(255);
			match(P_CLOSE);
			setState(256);
			match(BR_OPEN);
			setState(257);
			((ItemDeclContext)_localctx).tags = identifierSet();
			setState(258);
			match(BR_CLOSE);
			setState(259);
			match(BLOCK);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(260);
				declBody();
				}
				}
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(266);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SpellDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public DescriptionContext d;
		public TerminalNode SPELL() { return getToken(MMParser.SPELL, 0); }
		public TerminalNode BLOCK() { return getToken(MMParser.BLOCK, 0); }
		public TerminalNode END() { return getToken(MMParser.END, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public List<DeclBodyContext> declBody() {
			return getRuleContexts(DeclBodyContext.class);
		}
		public DeclBodyContext declBody(int i) {
			return getRuleContext(DeclBodyContext.class,i);
		}
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public SpellDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spellDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitSpellDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpellDeclContext spellDecl() throws RecognitionException {
		SpellDeclContext _localctx = new SpellDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_spellDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(SPELL);
			setState(269);
			((SpellDeclContext)_localctx).name = match(IDENTIFIER);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(270);
				((SpellDeclContext)_localctx).dispName = description();
				}
			}

			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(273);
				match(P_OPEN);
				setState(274);
				((SpellDeclContext)_localctx).d = description();
				setState(275);
				match(P_CLOSE);
				}
			}

			setState(279);
			match(BLOCK);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(280);
				declBody();
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(286);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BackgroundDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public DescriptionContext d;
		public TerminalNode BACKGROUND() { return getToken(MMParser.BACKGROUND, 0); }
		public TerminalNode BLOCK() { return getToken(MMParser.BLOCK, 0); }
		public TerminalNode END() { return getToken(MMParser.END, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public List<DeclBodyContext> declBody() {
			return getRuleContexts(DeclBodyContext.class);
		}
		public DeclBodyContext declBody(int i) {
			return getRuleContext(DeclBodyContext.class,i);
		}
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public BackgroundDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_backgroundDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitBackgroundDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BackgroundDeclContext backgroundDecl() throws RecognitionException {
		BackgroundDeclContext _localctx = new BackgroundDeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_backgroundDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(BACKGROUND);
			setState(289);
			((BackgroundDeclContext)_localctx).name = match(IDENTIFIER);
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(290);
				((BackgroundDeclContext)_localctx).dispName = description();
				}
			}

			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(293);
				match(P_OPEN);
				setState(294);
				((BackgroundDeclContext)_localctx).d = description();
				setState(295);
				match(P_CLOSE);
				}
			}

			setState(299);
			match(BLOCK);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(300);
				declBody();
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(306);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AbilityDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public DescriptionContext d;
		public TerminalNode ABILITY() { return getToken(MMParser.ABILITY, 0); }
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public AbilityDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abilityDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitAbilityDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbilityDeclContext abilityDecl() throws RecognitionException {
		AbilityDeclContext _localctx = new AbilityDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_abilityDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(ABILITY);
			setState(309);
			((AbilityDeclContext)_localctx).name = match(IDENTIFIER);
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(310);
				((AbilityDeclContext)_localctx).dispName = description();
				}
			}

			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(313);
				match(P_OPEN);
				setState(314);
				((AbilityDeclContext)_localctx).d = description();
				setState(315);
				match(P_CLOSE);
				}
			}

			setState(319);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SkillDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public DescriptionContext d;
		public Token ability;
		public TerminalNode SKILL() { return getToken(MMParser.SKILL, 0); }
		public TerminalNode DEPENDS_ON() { return getToken(MMParser.DEPENDS_ON, 0); }
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(MMParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MMParser.IDENTIFIER, i);
		}
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public SkillDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skillDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitSkillDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkillDeclContext skillDecl() throws RecognitionException {
		SkillDeclContext _localctx = new SkillDeclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_skillDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(SKILL);
			setState(322);
			((SkillDeclContext)_localctx).name = match(IDENTIFIER);
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(323);
				((SkillDeclContext)_localctx).dispName = description();
				}
			}

			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(326);
				match(P_OPEN);
				setState(327);
				((SkillDeclContext)_localctx).d = description();
				setState(328);
				match(P_CLOSE);
				}
			}

			setState(332);
			match(DEPENDS_ON);
			setState(333);
			((SkillDeclContext)_localctx).ability = match(IDENTIFIER);
			setState(334);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TraitDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public DescriptionContext d;
		public TerminalNode TRAIT() { return getToken(MMParser.TRAIT, 0); }
		public TerminalNode BLOCK() { return getToken(MMParser.BLOCK, 0); }
		public TerminalNode END() { return getToken(MMParser.END, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public List<DeclBodyContext> declBody() {
			return getRuleContexts(DeclBodyContext.class);
		}
		public DeclBodyContext declBody(int i) {
			return getRuleContext(DeclBodyContext.class,i);
		}
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public TraitDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitTraitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraitDeclContext traitDecl() throws RecognitionException {
		TraitDeclContext _localctx = new TraitDeclContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_traitDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(TRAIT);
			setState(337);
			((TraitDeclContext)_localctx).name = match(IDENTIFIER);
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(338);
				((TraitDeclContext)_localctx).dispName = description();
				}
			}

			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(341);
				match(P_OPEN);
				setState(342);
				((TraitDeclContext)_localctx).d = description();
				setState(343);
				match(P_CLOSE);
				}
			}

			setState(347);
			match(BLOCK);
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(348);
				declBody();
				}
				}
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(354);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ItemTagDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public DescriptionContext d;
		public TerminalNode ITEM_TAG() { return getToken(MMParser.ITEM_TAG, 0); }
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public ItemTagDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemTagDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitItemTagDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemTagDeclContext itemTagDecl() throws RecognitionException {
		ItemTagDeclContext _localctx = new ItemTagDeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_itemTagDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(ITEM_TAG);
			setState(357);
			((ItemTagDeclContext)_localctx).name = match(IDENTIFIER);
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(358);
				((ItemTagDeclContext)_localctx).dispName = description();
				}
			}

			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(361);
				match(P_OPEN);
				setState(362);
				((ItemTagDeclContext)_localctx).d = description();
				setState(363);
				match(P_CLOSE);
				}
			}

			setState(367);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ItemTraitDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public DescriptionContext d;
		public TerminalNode ITEM_TRAIT() { return getToken(MMParser.ITEM_TRAIT, 0); }
		public TerminalNode BLOCK() { return getToken(MMParser.BLOCK, 0); }
		public TerminalNode END() { return getToken(MMParser.END, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public List<DeclBodyContext> declBody() {
			return getRuleContexts(DeclBodyContext.class);
		}
		public DeclBodyContext declBody(int i) {
			return getRuleContext(DeclBodyContext.class,i);
		}
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public ItemTraitDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemTraitDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitItemTraitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemTraitDeclContext itemTraitDecl() throws RecognitionException {
		ItemTraitDeclContext _localctx = new ItemTraitDeclContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_itemTraitDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(ITEM_TRAIT);
			setState(370);
			((ItemTraitDeclContext)_localctx).name = match(IDENTIFIER);
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(371);
				((ItemTraitDeclContext)_localctx).dispName = description();
				}
			}

			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(374);
				match(P_OPEN);
				setState(375);
				((ItemTraitDeclContext)_localctx).d = description();
				setState(376);
				match(P_CLOSE);
				}
			}

			setState(380);
			match(BLOCK);
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUN) {
				{
				{
				setState(381);
				declBody();
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(387);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DamageDeclContext extends ParserRuleContext {
		public Token name;
		public DescriptionContext dispName;
		public DescriptionContext d;
		public TerminalNode DAMAGE() { return getToken(MMParser.DAMAGE, 0); }
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public DamageDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_damageDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDamageDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DamageDeclContext damageDecl() throws RecognitionException {
		DamageDeclContext _localctx = new DamageDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_damageDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(DAMAGE);
			setState(390);
			((DamageDeclContext)_localctx).name = match(IDENTIFIER);
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGS || _la==STRING_LIT) {
				{
				setState(391);
				((DamageDeclContext)_localctx).dispName = description();
				}
			}

			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==P_OPEN) {
				{
				setState(394);
				match(P_OPEN);
				setState(395);
				((DamageDeclContext)_localctx).d = description();
				setState(396);
				match(P_CLOSE);
				}
			}

			setState(400);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclBodyContext extends ParserRuleContext {
		public FunDeclContext funDecl() {
			return getRuleContext(FunDeclContext.class,0);
		}
		public DeclBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDeclBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclBodyContext declBody() throws RecognitionException {
		DeclBodyContext _localctx = new DeclBodyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_declBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			funDecl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunDeclContext extends ParserRuleContext {
		public Token name;
		public TerminalNode FUN() { return getToken(MMParser.FUN, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public IdentifierSetContext identifierSet() {
			return getRuleContext(IdentifierSetContext.class,0);
		}
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public TerminalNode BLOCK() { return getToken(MMParser.BLOCK, 0); }
		public TerminalNode END() { return getToken(MMParser.END, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public FunDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitFunDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunDeclContext funDecl() throws RecognitionException {
		FunDeclContext _localctx = new FunDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_funDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			match(FUN);
			setState(405);
			((FunDeclContext)_localctx).name = match(IDENTIFIER);
			setState(406);
			match(P_OPEN);
			setState(407);
			identifierSet();
			setState(408);
			match(P_CLOSE);
			setState(409);
			match(BLOCK);
			setState(413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 135515915487237L) != 0)) {
				{
				{
				setState(410);
				stmt();
				}
				}
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(416);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierSetContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(MMParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MMParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MMParser.COMMA, i);
		}
		public IdentifierSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitIdentifierSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierSetContext identifierSet() throws RecognitionException {
		IdentifierSetContext _localctx = new IdentifierSetContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_identifierSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(418);
				match(IDENTIFIER);
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(419);
					match(COMMA);
					setState(420);
					match(IDENTIFIER);
					}
					}
					setState(425);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public ExprStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends StmtContext {
		public Token v;
		public TerminalNode FOR() { return getToken(MMParser.FOR, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public TerminalNode IN() { return getToken(MMParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public ForStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends StmtContext {
		public TerminalNode WHILE() { return getToken(MMParser.WHILE, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhileStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends StmtContext {
		public TerminalNode IF() { return getToken(MMParser.IF, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MMParser.ELSE, 0); }
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStmtContext extends StmtContext {
		public TerminalNode BLOCK() { return getToken(MMParser.BLOCK, 0); }
		public TerminalNode END() { return getToken(MMParser.END, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignStmtContext extends StmtContext {
		public RefContext v;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MMParser.SEMI, 0); }
		public RefContext ref() {
			return getRuleContext(RefContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MMParser.ASSIGN, 0); }
		public TerminalNode PLUS_ASSIGN() { return getToken(MMParser.PLUS_ASSIGN, 0); }
		public TerminalNode MINUS_ASSIGN() { return getToken(MMParser.MINUS_ASSIGN, 0); }
		public TerminalNode MULT_ASSIGN() { return getToken(MMParser.MULT_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(MMParser.DIV_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(MMParser.MOD_ASSIGN, 0); }
		public AssignStmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_stmt);
		int _la;
		try {
			setState(467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(428);
				expr(0);
				setState(429);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				match(BLOCK);
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 135515915487237L) != 0)) {
					{
					{
					setState(432);
					stmt();
					}
					}
					setState(437);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(438);
				match(END);
				}
				break;
			case 3:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(439);
				match(IF);
				setState(440);
				match(P_OPEN);
				setState(441);
				expr(0);
				setState(442);
				match(P_CLOSE);
				setState(443);
				stmt();
				setState(446);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(444);
					match(ELSE);
					setState(445);
					stmt();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(448);
				match(WHILE);
				setState(449);
				match(P_OPEN);
				setState(450);
				expr(0);
				setState(451);
				match(P_CLOSE);
				setState(452);
				stmt();
				}
				break;
			case 5:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(454);
				match(FOR);
				setState(455);
				match(P_OPEN);
				setState(456);
				((ForStmtContext)_localctx).v = match(IDENTIFIER);
				setState(457);
				match(IN);
				setState(458);
				expr(0);
				setState(459);
				match(P_CLOSE);
				setState(460);
				stmt();
				}
				break;
			case 6:
				_localctx = new AssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(462);
				((AssignStmtContext)_localctx).v = ref();
				setState(463);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8257536L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(464);
				expr(0);
				setState(465);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RefContext extends ParserRuleContext {
		public RefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ref; }
	 
		public RefContext() { }
		public void copyFrom(RefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexRefContext extends RefContext {
		public ExprContext base;
		public TerminalNode BR_OPEN() { return getToken(MMParser.BR_OPEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BR_CLOSE() { return getToken(MMParser.BR_CLOSE, 0); }
		public IndexRefContext(RefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitIndexRef(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NameRefContext extends RefContext {
		public Token name;
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public NameRefContext(RefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitNameRef(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DotRefContext extends RefContext {
		public ExprContext base;
		public Token name;
		public TerminalNode DOT() { return getToken(MMParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public DotRefContext(RefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDotRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefContext ref() throws RecognitionException {
		RefContext _localctx = new RefContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_ref);
		try {
			setState(479);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				_localctx = new DotRefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				((DotRefContext)_localctx).base = expr(0);
				setState(470);
				match(DOT);
				setState(471);
				((DotRefContext)_localctx).name = match(IDENTIFIER);
				}
				break;
			case 2:
				_localctx = new IndexRefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(473);
				((IndexRefContext)_localctx).base = expr(0);
				setState(474);
				match(BR_OPEN);
				setState(475);
				expr(0);
				setState(476);
				match(BR_CLOSE);
				}
				break;
			case 3:
				_localctx = new NameRefContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(478);
				((NameRefContext)_localctx).name = match(IDENTIFIER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MMParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & 33878970466305L) != 0)) {
				{
				setState(481);
				expr(0);
				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(482);
					match(COMMA);
					setState(483);
					expr(0);
					}
					}
					setState(488);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexExprContext extends ExprContext {
		public ExprContext base;
		public TerminalNode BR_OPEN() { return getToken(MMParser.BR_OPEN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BR_CLOSE() { return getToken(MMParser.BR_CLOSE, 0); }
		public IndexExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitIndexExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DotExprContext extends ExprContext {
		public ExprContext base;
		public Token name;
		public TerminalNode DOT() { return getToken(MMParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public DotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(MMParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MMParser.MINUS, 0); }
		public AddExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralExprContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT() { return getToken(MMParser.GT, 0); }
		public TerminalNode LT() { return getToken(MMParser.LT, 0); }
		public TerminalNode GE() { return getToken(MMParser.GE, 0); }
		public TerminalNode LE() { return getToken(MMParser.LE, 0); }
		public TerminalNode EQ() { return getToken(MMParser.EQ, 0); }
		public TerminalNode NE() { return getToken(MMParser.NE, 0); }
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExprContext extends ExprContext {
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public FunctionCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitFunctionCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(MMParser.AND, 0); }
		public TerminalNode OR() { return getToken(MMParser.OR, 0); }
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(MMParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(MMParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MMParser.MOD, 0); }
		public MultExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public TerminalNode P_OPEN() { return getToken(MMParser.P_OPEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode P_CLOSE() { return getToken(MMParser.P_CLOSE, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExprContext extends ExprContext {
		public Token name;
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public IdentifierExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitIdentifierExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(492);
				literal();
				}
				break;
			case 2:
				{
				_localctx = new IdentifierExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(493);
				((IdentifierExprContext)_localctx).name = match(IDENTIFIER);
				}
				break;
			case 3:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(494);
				match(IDENTIFIER);
				setState(495);
				match(P_OPEN);
				setState(496);
				args();
				setState(497);
				match(P_CLOSE);
				}
				break;
			case 4:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(499);
				match(P_OPEN);
				setState(500);
				expr(0);
				setState(501);
				match(P_CLOSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(527);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(525);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(505);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(506);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 112L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(507);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(508);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(509);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(510);
						expr(4);
						}
						break;
					case 3:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(511);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(512);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32256L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(513);
						expr(3);
						}
						break;
					case 4:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(514);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(515);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(516);
						expr(2);
						}
						break;
					case 5:
						{
						_localctx = new DotExprContext(new ExprContext(_parentctx, _parentState));
						((DotExprContext)_localctx).base = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(517);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(518);
						match(DOT);
						setState(519);
						((DotExprContext)_localctx).name = match(IDENTIFIER);
						}
						break;
					case 6:
						{
						_localctx = new IndexExprContext(new ExprContext(_parentctx, _parentState));
						((IndexExprContext)_localctx).base = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(520);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(521);
						match(BR_OPEN);
						setState(522);
						expr(0);
						setState(523);
						match(BR_CLOSE);
						}
						break;
					}
					} 
				}
				setState(529);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CurrencyLitContext extends LiteralContext {
		public TerminalNode CURRENCY_LIT() { return getToken(MMParser.CURRENCY_LIT, 0); }
		public CurrencyLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitCurrencyLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLitContext extends LiteralContext {
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public StringLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitStringLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WeightLitContext extends LiteralContext {
		public TerminalNode WEIGHT_LIT() { return getToken(MMParser.WEIGHT_LIT, 0); }
		public WeightLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitWeightLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberLitContext extends LiteralContext {
		public TerminalNode NUMBER() { return getToken(MMParser.NUMBER, 0); }
		public NumberLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitNumberLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RawDiceLitContext extends LiteralContext {
		public TerminalNode DICE_LIT() { return getToken(MMParser.DICE_LIT, 0); }
		public RawDiceLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitRawDiceLit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DistanceLitContext extends LiteralContext {
		public TerminalNode DIST_LIT() { return getToken(MMParser.DIST_LIT, 0); }
		public DistanceLitContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitDistanceLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_literal);
		try {
			setState(536);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new NumberLitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(530);
				match(NUMBER);
				}
				break;
			case DICE_LIT:
				_localctx = new RawDiceLitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(531);
				match(DICE_LIT);
				}
				break;
			case DIST_LIT:
				_localctx = new DistanceLitContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(532);
				match(DIST_LIT);
				}
				break;
			case CURRENCY_LIT:
				_localctx = new CurrencyLitContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(533);
				match(CURRENCY_LIT);
				}
				break;
			case WEIGHT_LIT:
				_localctx = new WeightLitContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(534);
				match(WEIGHT_LIT);
				}
				break;
			case STRINGS:
			case STRING_LIT:
				_localctx = new StringLitContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(535);
				description();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DescriptionContext extends ParserRuleContext {
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
	 
		public DescriptionContext() { }
		public void copyFrom(DescriptionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringDescrContext extends DescriptionContext {
		public TerminalNode STRING_LIT() { return getToken(MMParser.STRING_LIT, 0); }
		public StringDescrContext(DescriptionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitStringDescr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RefDescrContext extends DescriptionContext {
		public Token name;
		public TerminalNode STRINGS() { return getToken(MMParser.STRINGS, 0); }
		public TerminalNode DOT() { return getToken(MMParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MMParser.IDENTIFIER, 0); }
		public RefDescrContext(DescriptionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MMVisitor ) return ((MMVisitor<? extends T>)visitor).visitRefDescr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_description);
		try {
			setState(542);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LIT:
				_localctx = new StringDescrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(538);
				match(STRING_LIT);
				}
				break;
			case STRINGS:
				_localctx = new RefDescrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(539);
				match(STRINGS);
				setState(540);
				match(DOT);
				setState(541);
				((RefDescrContext)_localctx).name = match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 26:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001J\u0221\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0005\u0000<\b\u0000\n\u0000\f\u0000"+
		"?\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002J\b\u0002"+
		"\n\u0002\f\u0002M\t\u0002\u0001\u0002\u0005\u0002P\b\u0002\n\u0002\f\u0002"+
		"S\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003^\b\u0003"+
		"\n\u0003\f\u0003a\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"l\b\u0003\n\u0003\f\u0003o\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"s\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004z\b\u0004\n\u0004\f\u0004}\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u0083\b\u0005\n\u0005\f\u0005\u0086"+
		"\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0098"+
		"\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u009d\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a3\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007\u00a7\b\u0007\n\u0007\f\u0007\u00aa"+
		"\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u00b1"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b7\b\b\u0001\b\u0003\b"+
		"\u00ba\b\b\u0001\b\u0001\b\u0005\b\u00be\b\b\n\b\f\b\u00c1\t\b\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\t\u0003\t\u00c8\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u00d0\b\t\u0001\t\u0001\t\u0005\t\u00d4"+
		"\b\t\n\t\f\t\u00d7\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n"+
		"\u00de\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00e6"+
		"\b\n\u0001\n\u0001\n\u0005\n\u00ea\b\n\n\n\f\n\u00ed\t\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00f4\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00fa\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0106\b\u000b\n"+
		"\u000b\f\u000b\u0109\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u0110\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0116\b\f"+
		"\u0001\f\u0001\f\u0005\f\u011a\b\f\n\f\f\f\u011d\t\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u0124\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u012a\b\r\u0001\r\u0001\r\u0005\r\u012e\b\r\n\r\f\r\u0131\t\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0138\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u013e\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u0145\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u014b\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u0154\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u015a\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u015e\b\u0010\n\u0010\f\u0010\u0161\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0168\b\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u016e\b\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0175"+
		"\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u017b"+
		"\b\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u017f\b\u0012\n\u0012\f\u0012"+
		"\u0182\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u0189\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u018f\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0005\u0015\u019c\b\u0015\n\u0015\f\u0015\u019f\t\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u01a6"+
		"\b\u0016\n\u0016\f\u0016\u01a9\t\u0016\u0003\u0016\u01ab\b\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u01b2"+
		"\b\u0017\n\u0017\f\u0017\u01b5\t\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u01bf\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u01d4\b\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u01e0\b\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u01e5\b\u0019\n\u0019\f\u0019\u01e8\t\u0019\u0003"+
		"\u0019\u01ea\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u01f8\b\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005"+
		"\u001a\u020e\b\u001a\n\u001a\f\u001a\u0211\t\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0219\b\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u021f\b\u001c"+
		"\u0001\u001c\u0000\u00014\u001d\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468\u0000\u0005\u0001"+
		"\u0000\u0011\u0016\u0001\u0000\u0004\u0006\u0001\u0000\u0007\b\u0001\u0000"+
		"\t\u000e\u0001\u0000\u000f\u0010\u025b\u0000=\u0001\u0000\u0000\u0000"+
		"\u0002B\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006r"+
		"\u0001\u0000\u0000\u0000\bt\u0001\u0000\u0000\u0000\n\u0080\u0001\u0000"+
		"\u0000\u0000\f\u0097\u0001\u0000\u0000\u0000\u000e\u0099\u0001\u0000\u0000"+
		"\u0000\u0010\u00ad\u0001\u0000\u0000\u0000\u0012\u00c4\u0001\u0000\u0000"+
		"\u0000\u0014\u00da\u0001\u0000\u0000\u0000\u0016\u00f0\u0001\u0000\u0000"+
		"\u0000\u0018\u010c\u0001\u0000\u0000\u0000\u001a\u0120\u0001\u0000\u0000"+
		"\u0000\u001c\u0134\u0001\u0000\u0000\u0000\u001e\u0141\u0001\u0000\u0000"+
		"\u0000 \u0150\u0001\u0000\u0000\u0000\"\u0164\u0001\u0000\u0000\u0000"+
		"$\u0171\u0001\u0000\u0000\u0000&\u0185\u0001\u0000\u0000\u0000(\u0192"+
		"\u0001\u0000\u0000\u0000*\u0194\u0001\u0000\u0000\u0000,\u01aa\u0001\u0000"+
		"\u0000\u0000.\u01d3\u0001\u0000\u0000\u00000\u01df\u0001\u0000\u0000\u0000"+
		"2\u01e9\u0001\u0000\u0000\u00004\u01f7\u0001\u0000\u0000\u00006\u0218"+
		"\u0001\u0000\u0000\u00008\u021e\u0001\u0000\u0000\u0000:<\u0003\u0002"+
		"\u0001\u0000;:\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001"+
		"\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001\u0000\u0000\u0000"+
		"?=\u0001\u0000\u0000\u0000@A\u0005\u0000\u0000\u0001A\u0001\u0001\u0000"+
		"\u0000\u0000BC\u0005D\u0000\u0000CD\u0005\u0011\u0000\u0000DE\u0005E\u0000"+
		"\u0000EF\u0005\u0002\u0000\u0000F\u0003\u0001\u0000\u0000\u0000GK\u0003"+
		"\u0006\u0003\u0000HJ\u0003\n\u0005\u0000IH\u0001\u0000\u0000\u0000JM\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000"+
		"LQ\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NP\u0003\f\u0006\u0000"+
		"ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000"+
		"\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000TU\u0005\u0000\u0000\u0001U\u0005\u0001\u0000\u0000\u0000"+
		"VW\u00053\u0000\u0000WX\u0005D\u0000\u0000Xs\u0005\u0002\u0000\u0000Y"+
		"Z\u00053\u0000\u0000Z[\u0005D\u0000\u0000[_\u0005;\u0000\u0000\\^\u0005"+
		"E\u0000\u0000]\\\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000"+
		"a_\u0001\u0000\u0000\u0000bs\u0005\u0002\u0000\u0000cd\u00053\u0000\u0000"+
		"de\u0005D\u0000\u0000ef\u0005\u0002\u0000\u0000fs\u0003\b\u0004\u0000"+
		"gh\u00053\u0000\u0000hi\u0005D\u0000\u0000im\u0005;\u0000\u0000jl\u0005"+
		"E\u0000\u0000kj\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000\u0000mk\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000np\u0001\u0000\u0000\u0000"+
		"om\u0001\u0000\u0000\u0000pq\u0005\u0002\u0000\u0000qs\u0003\b\u0004\u0000"+
		"rV\u0001\u0000\u0000\u0000rY\u0001\u0000\u0000\u0000rc\u0001\u0000\u0000"+
		"\u0000rg\u0001\u0000\u0000\u0000s\u0007\u0001\u0000\u0000\u0000tu\u0005"+
		"5\u0000\u0000uv\u0005$\u0000\u0000v{\u0005E\u0000\u0000wx\u0005\u0003"+
		"\u0000\u0000xz\u0005E\u0000\u0000yw\u0001\u0000\u0000\u0000z}\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0001"+
		"\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000~\u007f\u0005\u0002\u0000"+
		"\u0000\u007f\t\u0001\u0000\u0000\u0000\u0080\u0084\u00052\u0000\u0000"+
		"\u0081\u0083\u0005>\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083"+
		"\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0001\u0000\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086"+
		"\u0084\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0002\u0000\u0000\u0088"+
		"\u000b\u0001\u0000\u0000\u0000\u0089\u0098\u0003\u000e\u0007\u0000\u008a"+
		"\u0098\u0003\u0010\b\u0000\u008b\u0098\u0003\u0012\t\u0000\u008c\u0098"+
		"\u0003\u0014\n\u0000\u008d\u0098\u0003\u0016\u000b\u0000\u008e\u0098\u0003"+
		"\u0018\f\u0000\u008f\u0098\u0003\u001a\r\u0000\u0090\u0098\u0003\u001c"+
		"\u000e\u0000\u0091\u0098\u0003\u001e\u000f\u0000\u0092\u0098\u0003 \u0010"+
		"\u0000\u0093\u0098\u0003$\u0012\u0000\u0094\u0098\u0003&\u0013\u0000\u0095"+
		"\u0098\u0003\"\u0011\u0000\u0096\u0098\u0003*\u0015\u0000\u0097\u0089"+
		"\u0001\u0000\u0000\u0000\u0097\u008a\u0001\u0000\u0000\u0000\u0097\u008b"+
		"\u0001\u0000\u0000\u0000\u0097\u008c\u0001\u0000\u0000\u0000\u0097\u008d"+
		"\u0001\u0000\u0000\u0000\u0097\u008e\u0001\u0000\u0000\u0000\u0097\u008f"+
		"\u0001\u0000\u0000\u0000\u0097\u0090\u0001\u0000\u0000\u0000\u0097\u0091"+
		"\u0001\u0000\u0000\u0000\u0097\u0092\u0001\u0000\u0000\u0000\u0097\u0093"+
		"\u0001\u0000\u0000\u0000\u0097\u0094\u0001\u0000\u0000\u0000\u0097\u0095"+
		"\u0001\u0000\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\r\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0005,\u0000\u0000\u009a\u009c\u0005D\u0000"+
		"\u0000\u009b\u009d\u00038\u001c\u0000\u009c\u009b\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u00a2\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0005\u0019\u0000\u0000\u009f\u00a0\u00038\u001c\u0000\u00a0"+
		"\u00a1\u0005\u001a\u0000\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2"+
		"\u009e\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a8\u0005\u0017\u0000\u0000\u00a5"+
		"\u00a7\u0003(\u0014\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u00aa"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0001\u0000\u0000\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa\u00a8"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005\u0018\u0000\u0000\u00ac\u000f"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005+\u0000\u0000\u00ae\u00b0\u0005"+
		"D\u0000\u0000\u00af\u00b1\u00038\u001c\u0000\u00b0\u00af\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0005\u0019\u0000\u0000\u00b3\u00b4\u00038\u001c\u0000"+
		"\u00b4\u00b5\u0005\u001a\u0000\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b2\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8\u00ba\u0005<\u0000\u0000\u00b9"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bf\u0005\u0017\u0000\u0000\u00bc"+
		"\u00be\u0003(\u0014\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u00c1"+
		"\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\u0018\u0000\u0000\u00c3\u0011"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u00057\u0000\u0000\u00c5\u00c7\u0005"+
		"D\u0000\u0000\u00c6\u00c8\u00038\u001c\u0000\u00c7\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000"+
		"\u0000\u00c9\u00ca\u0005\'\u0000\u0000\u00ca\u00cf\u0005D\u0000\u0000"+
		"\u00cb\u00cc\u0005\u0019\u0000\u0000\u00cc\u00cd\u00038\u001c\u0000\u00cd"+
		"\u00ce\u0005\u001a\u0000\u0000\u00ce\u00d0\u0001\u0000\u0000\u0000\u00cf"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d5\u0005\u0017\u0000\u0000\u00d2"+
		"\u00d4\u0003(\u0014\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u0018\u0000\u0000\u00d9\u0013"+
		"\u0001\u0000\u0000\u0000\u00da\u00db\u00056\u0000\u0000\u00db\u00dd\u0005"+
		"D\u0000\u0000\u00dc\u00de\u00038\u001c\u0000\u00dd\u00dc\u0001\u0000\u0000"+
		"\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0005\'\u0000\u0000\u00e0\u00e5\u0005D\u0000\u0000"+
		"\u00e1\u00e2\u0005\u0019\u0000\u0000\u00e2\u00e3\u00038\u001c\u0000\u00e3"+
		"\u00e4\u0005\u001a\u0000\u0000\u00e4\u00e6\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e7\u00eb\u0005\u0017\u0000\u0000\u00e8"+
		"\u00ea\u0003(\u0014\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00ea\u00ed"+
		"\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec"+
		"\u0001\u0000\u0000\u0000\u00ec\u00ee\u0001\u0000\u0000\u0000\u00ed\u00eb"+
		"\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005\u0018\u0000\u0000\u00ef\u0015"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005*\u0000\u0000\u00f1\u00f3\u0005"+
		"D\u0000\u0000\u00f2\u00f4\u00038\u001c\u0000\u00f3\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f9\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0005\u0019\u0000\u0000\u00f6\u00f7\u00038\u001c\u0000"+
		"\u00f7\u00f8\u0005\u001a\u0000\u0000\u00f8\u00fa\u0001\u0000\u0000\u0000"+
		"\u00f9\u00f5\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005B\u0000\u0000\u00fc"+
		"\u00fd\u0005C\u0000\u0000\u00fd\u00fe\u0005\u0019\u0000\u0000\u00fe\u00ff"+
		"\u0003,\u0016\u0000\u00ff\u0100\u0005\u001a\u0000\u0000\u0100\u0101\u0005"+
		"\u001b\u0000\u0000\u0101\u0102\u0003,\u0016\u0000\u0102\u0103\u0005\u001c"+
		"\u0000\u0000\u0103\u0107\u0005\u0017\u0000\u0000\u0104\u0106\u0003(\u0014"+
		"\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0106\u0109\u0001\u0000\u0000"+
		"\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000"+
		"\u0000\u0108\u010a\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000"+
		"\u0000\u010a\u010b\u0005\u0018\u0000\u0000\u010b\u0017\u0001\u0000\u0000"+
		"\u0000\u010c\u010d\u0005.\u0000\u0000\u010d\u010f\u0005D\u0000\u0000\u010e"+
		"\u0110\u00038\u001c\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u010f\u0110"+
		"\u0001\u0000\u0000\u0000\u0110\u0115\u0001\u0000\u0000\u0000\u0111\u0112"+
		"\u0005\u0019\u0000\u0000\u0112\u0113\u00038\u001c\u0000\u0113\u0114\u0005"+
		"\u001a\u0000\u0000\u0114\u0116\u0001\u0000\u0000\u0000\u0115\u0111\u0001"+
		"\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0117\u0001"+
		"\u0000\u0000\u0000\u0117\u011b\u0005\u0017\u0000\u0000\u0118\u011a\u0003"+
		"(\u0014\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u011a\u011d\u0001\u0000"+
		"\u0000\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000"+
		"\u0000\u0000\u011c\u011e\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000"+
		"\u0000\u0000\u011e\u011f\u0005\u0018\u0000\u0000\u011f\u0019\u0001\u0000"+
		"\u0000\u0000\u0120\u0121\u0005:\u0000\u0000\u0121\u0123\u0005D\u0000\u0000"+
		"\u0122\u0124\u00038\u001c\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0123"+
		"\u0124\u0001\u0000\u0000\u0000\u0124\u0129\u0001\u0000\u0000\u0000\u0125"+
		"\u0126\u0005\u0019\u0000\u0000\u0126\u0127\u00038\u001c\u0000\u0127\u0128"+
		"\u0005\u001a\u0000\u0000\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u0125"+
		"\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u012b"+
		"\u0001\u0000\u0000\u0000\u012b\u012f\u0005\u0017\u0000\u0000\u012c\u012e"+
		"\u0003(\u0014\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012e\u0131\u0001"+
		"\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130\u0001"+
		"\u0000\u0000\u0000\u0130\u0132\u0001\u0000\u0000\u0000\u0131\u012f\u0001"+
		"\u0000\u0000\u0000\u0132\u0133\u0005\u0018\u0000\u0000\u0133\u001b\u0001"+
		"\u0000\u0000\u0000\u0134\u0135\u00054\u0000\u0000\u0135\u0137\u0005D\u0000"+
		"\u0000\u0136\u0138\u00038\u001c\u0000\u0137\u0136\u0001\u0000\u0000\u0000"+
		"\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u013d\u0001\u0000\u0000\u0000"+
		"\u0139\u013a\u0005\u0019\u0000\u0000\u013a\u013b\u00038\u001c\u0000\u013b"+
		"\u013c\u0005\u001a\u0000\u0000\u013c\u013e\u0001\u0000\u0000\u0000\u013d"+
		"\u0139\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e"+
		"\u013f\u0001\u0000\u0000\u0000\u013f\u0140\u0005\u0002\u0000\u0000\u0140"+
		"\u001d\u0001\u0000\u0000\u0000\u0141\u0142\u0005-\u0000\u0000\u0142\u0144"+
		"\u0005D\u0000\u0000\u0143\u0145\u00038\u001c\u0000\u0144\u0143\u0001\u0000"+
		"\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u014a\u0001\u0000"+
		"\u0000\u0000\u0146\u0147\u0005\u0019\u0000\u0000\u0147\u0148\u00038\u001c"+
		"\u0000\u0148\u0149\u0005\u001a\u0000\u0000\u0149\u014b\u0001\u0000\u0000"+
		"\u0000\u014a\u0146\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000"+
		"\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u014d\u0005;\u0000\u0000"+
		"\u014d\u014e\u0005D\u0000\u0000\u014e\u014f\u0005\u0002\u0000\u0000\u014f"+
		"\u001f\u0001\u0000\u0000\u0000\u0150\u0151\u0005/\u0000\u0000\u0151\u0153"+
		"\u0005D\u0000\u0000\u0152\u0154\u00038\u001c\u0000\u0153\u0152\u0001\u0000"+
		"\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0159\u0001\u0000"+
		"\u0000\u0000\u0155\u0156\u0005\u0019\u0000\u0000\u0156\u0157\u00038\u001c"+
		"\u0000\u0157\u0158\u0005\u001a\u0000\u0000\u0158\u015a\u0001\u0000\u0000"+
		"\u0000\u0159\u0155\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000"+
		"\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015f\u0005\u0017\u0000"+
		"\u0000\u015c\u015e\u0003(\u0014\u0000\u015d\u015c\u0001\u0000\u0000\u0000"+
		"\u015e\u0161\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000"+
		"\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0162\u0001\u0000\u0000\u0000"+
		"\u0161\u015f\u0001\u0000\u0000\u0000\u0162\u0163\u0005\u0018\u0000\u0000"+
		"\u0163!\u0001\u0000\u0000\u0000\u0164\u0165\u00058\u0000\u0000\u0165\u0167"+
		"\u0005D\u0000\u0000\u0166\u0168\u00038\u001c\u0000\u0167\u0166\u0001\u0000"+
		"\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u016d\u0001\u0000"+
		"\u0000\u0000\u0169\u016a\u0005\u0019\u0000\u0000\u016a\u016b\u00038\u001c"+
		"\u0000\u016b\u016c\u0005\u001a\u0000\u0000\u016c\u016e\u0001\u0000\u0000"+
		"\u0000\u016d\u0169\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000\u0000"+
		"\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u0170\u0005\u0002\u0000"+
		"\u0000\u0170#\u0001\u0000\u0000\u0000\u0171\u0172\u00059\u0000\u0000\u0172"+
		"\u0174\u0005D\u0000\u0000\u0173\u0175\u00038\u001c\u0000\u0174\u0173\u0001"+
		"\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175\u017a\u0001"+
		"\u0000\u0000\u0000\u0176\u0177\u0005\u0019\u0000\u0000\u0177\u0178\u0003"+
		"8\u001c\u0000\u0178\u0179\u0005\u001a\u0000\u0000\u0179\u017b\u0001\u0000"+
		"\u0000\u0000\u017a\u0176\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000"+
		"\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017c\u0180\u0005\u0017"+
		"\u0000\u0000\u017d\u017f\u0003(\u0014\u0000\u017e\u017d\u0001\u0000\u0000"+
		"\u0000\u017f\u0182\u0001\u0000\u0000\u0000\u0180\u017e\u0001\u0000\u0000"+
		"\u0000\u0180\u0181\u0001\u0000\u0000\u0000\u0181\u0183\u0001\u0000\u0000"+
		"\u0000\u0182\u0180\u0001\u0000\u0000\u0000\u0183\u0184\u0005\u0018\u0000"+
		"\u0000\u0184%\u0001\u0000\u0000\u0000\u0185\u0186\u00051\u0000\u0000\u0186"+
		"\u0188\u0005D\u0000\u0000\u0187\u0189\u00038\u001c\u0000\u0188\u0187\u0001"+
		"\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000\u0000\u0189\u018e\u0001"+
		"\u0000\u0000\u0000\u018a\u018b\u0005\u0019\u0000\u0000\u018b\u018c\u0003"+
		"8\u001c\u0000\u018c\u018d\u0005\u001a\u0000\u0000\u018d\u018f\u0001\u0000"+
		"\u0000\u0000\u018e\u018a\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000"+
		"\u0000\u0000\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u0191\u0005\u0002"+
		"\u0000\u0000\u0191\'\u0001\u0000\u0000\u0000\u0192\u0193\u0003*\u0015"+
		"\u0000\u0193)\u0001\u0000\u0000\u0000\u0194\u0195\u0005(\u0000\u0000\u0195"+
		"\u0196\u0005D\u0000\u0000\u0196\u0197\u0005\u0019\u0000\u0000\u0197\u0198"+
		"\u0003,\u0016\u0000\u0198\u0199\u0005\u001a\u0000\u0000\u0199\u019d\u0005"+
		"\u0017\u0000\u0000\u019a\u019c\u0003.\u0017\u0000\u019b\u019a\u0001\u0000"+
		"\u0000\u0000\u019c\u019f\u0001\u0000\u0000\u0000\u019d\u019b\u0001\u0000"+
		"\u0000\u0000\u019d\u019e\u0001\u0000\u0000\u0000\u019e\u01a0\u0001\u0000"+
		"\u0000\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u01a0\u01a1\u0005\u0018"+
		"\u0000\u0000\u01a1+\u0001\u0000\u0000\u0000\u01a2\u01a7\u0005D\u0000\u0000"+
		"\u01a3\u01a4\u0005\u0003\u0000\u0000\u01a4\u01a6\u0005D\u0000\u0000\u01a5"+
		"\u01a3\u0001\u0000\u0000\u0000\u01a6\u01a9\u0001\u0000\u0000\u0000\u01a7"+
		"\u01a5\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8"+
		"\u01ab\u0001\u0000\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000\u01aa"+
		"\u01a2\u0001\u0000\u0000\u0000\u01aa\u01ab\u0001\u0000\u0000\u0000\u01ab"+
		"-\u0001\u0000\u0000\u0000\u01ac\u01ad\u00034\u001a\u0000\u01ad\u01ae\u0005"+
		"\u0002\u0000\u0000\u01ae\u01d4\u0001\u0000\u0000\u0000\u01af\u01b3\u0005"+
		"\u0017\u0000\u0000\u01b0\u01b2\u0003.\u0017\u0000\u01b1\u01b0\u0001\u0000"+
		"\u0000\u0000\u01b2\u01b5\u0001\u0000\u0000\u0000\u01b3\u01b1\u0001\u0000"+
		"\u0000\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4\u01b6\u0001\u0000"+
		"\u0000\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000\u01b6\u01d4\u0005\u0018"+
		"\u0000\u0000\u01b7\u01b8\u0005\"\u0000\u0000\u01b8\u01b9\u0005\u0019\u0000"+
		"\u0000\u01b9\u01ba\u00034\u001a\u0000\u01ba\u01bb\u0005\u001a\u0000\u0000"+
		"\u01bb\u01be\u0003.\u0017\u0000\u01bc\u01bd\u0005)\u0000\u0000\u01bd\u01bf"+
		"\u0003.\u0017\u0000\u01be\u01bc\u0001\u0000\u0000\u0000\u01be\u01bf\u0001"+
		"\u0000\u0000\u0000\u01bf\u01d4\u0001\u0000\u0000\u0000\u01c0\u01c1\u0005"+
		"0\u0000\u0000\u01c1\u01c2\u0005\u0019\u0000\u0000\u01c2\u01c3\u00034\u001a"+
		"\u0000\u01c3\u01c4\u0005\u001a\u0000\u0000\u01c4\u01c5\u0003.\u0017\u0000"+
		"\u01c5\u01d4\u0001\u0000\u0000\u0000\u01c6\u01c7\u0005\'\u0000\u0000\u01c7"+
		"\u01c8\u0005\u0019\u0000\u0000\u01c8\u01c9\u0005D\u0000\u0000\u01c9\u01ca"+
		"\u0005$\u0000\u0000\u01ca\u01cb\u00034\u001a\u0000\u01cb\u01cc\u0005\u001a"+
		"\u0000\u0000\u01cc\u01cd\u0003.\u0017\u0000\u01cd\u01d4\u0001\u0000\u0000"+
		"\u0000\u01ce\u01cf\u00030\u0018\u0000\u01cf\u01d0\u0007\u0000\u0000\u0000"+
		"\u01d0\u01d1\u00034\u001a\u0000\u01d1\u01d2\u0005\u0002\u0000\u0000\u01d2"+
		"\u01d4\u0001\u0000\u0000\u0000\u01d3\u01ac\u0001\u0000\u0000\u0000\u01d3"+
		"\u01af\u0001\u0000\u0000\u0000\u01d3\u01b7\u0001\u0000\u0000\u0000\u01d3"+
		"\u01c0\u0001\u0000\u0000\u0000\u01d3\u01c6\u0001\u0000\u0000\u0000\u01d3"+
		"\u01ce\u0001\u0000\u0000\u0000\u01d4/\u0001\u0000\u0000\u0000\u01d5\u01d6"+
		"\u00034\u001a\u0000\u01d6\u01d7\u0005\u0001\u0000\u0000\u01d7\u01d8\u0005"+
		"D\u0000\u0000\u01d8\u01e0\u0001\u0000\u0000\u0000\u01d9\u01da\u00034\u001a"+
		"\u0000\u01da\u01db\u0005\u001b\u0000\u0000\u01db\u01dc\u00034\u001a\u0000"+
		"\u01dc\u01dd\u0005\u001c\u0000\u0000\u01dd\u01e0\u0001\u0000\u0000\u0000"+
		"\u01de\u01e0\u0005D\u0000\u0000\u01df\u01d5\u0001\u0000\u0000\u0000\u01df"+
		"\u01d9\u0001\u0000\u0000\u0000\u01df\u01de\u0001\u0000\u0000\u0000\u01e0"+
		"1\u0001\u0000\u0000\u0000\u01e1\u01e6\u00034\u001a\u0000\u01e2\u01e3\u0005"+
		"\u0003\u0000\u0000\u01e3\u01e5\u00034\u001a\u0000\u01e4\u01e2\u0001\u0000"+
		"\u0000\u0000\u01e5\u01e8\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001\u0000"+
		"\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01ea\u0001\u0000"+
		"\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e9\u01e1\u0001\u0000"+
		"\u0000\u0000\u01e9\u01ea\u0001\u0000\u0000\u0000\u01ea3\u0001\u0000\u0000"+
		"\u0000\u01eb\u01ec\u0006\u001a\uffff\uffff\u0000\u01ec\u01f8\u00036\u001b"+
		"\u0000\u01ed\u01f8\u0005D\u0000\u0000\u01ee\u01ef\u0005D\u0000\u0000\u01ef"+
		"\u01f0\u0005\u0019\u0000\u0000\u01f0\u01f1\u00032\u0019\u0000\u01f1\u01f2"+
		"\u0005\u001a\u0000\u0000\u01f2\u01f8\u0001\u0000\u0000\u0000\u01f3\u01f4"+
		"\u0005\u0019\u0000\u0000\u01f4\u01f5\u00034\u001a\u0000\u01f5\u01f6\u0005"+
		"\u001a\u0000\u0000\u01f6\u01f8\u0001\u0000\u0000\u0000\u01f7\u01eb\u0001"+
		"\u0000\u0000\u0000\u01f7\u01ed\u0001\u0000\u0000\u0000\u01f7\u01ee\u0001"+
		"\u0000\u0000\u0000\u01f7\u01f3\u0001\u0000\u0000\u0000\u01f8\u020f\u0001"+
		"\u0000\u0000\u0000\u01f9\u01fa\n\u0004\u0000\u0000\u01fa\u01fb\u0007\u0001"+
		"\u0000\u0000\u01fb\u020e\u00034\u001a\u0005\u01fc\u01fd\n\u0003\u0000"+
		"\u0000\u01fd\u01fe\u0007\u0002\u0000\u0000\u01fe\u020e\u00034\u001a\u0004"+
		"\u01ff\u0200\n\u0002\u0000\u0000\u0200\u0201\u0007\u0003\u0000\u0000\u0201"+
		"\u020e\u00034\u001a\u0003\u0202\u0203\n\u0001\u0000\u0000\u0203\u0204"+
		"\u0007\u0004\u0000\u0000\u0204\u020e\u00034\u001a\u0002\u0205\u0206\n"+
		"\b\u0000\u0000\u0206\u0207\u0005\u0001\u0000\u0000\u0207\u020e\u0005D"+
		"\u0000\u0000\u0208\u0209\n\u0007\u0000\u0000\u0209\u020a\u0005\u001b\u0000"+
		"\u0000\u020a\u020b\u00034\u001a\u0000\u020b\u020c\u0005\u001c\u0000\u0000"+
		"\u020c\u020e\u0001\u0000\u0000\u0000\u020d\u01f9\u0001\u0000\u0000\u0000"+
		"\u020d\u01fc\u0001\u0000\u0000\u0000\u020d\u01ff\u0001\u0000\u0000\u0000"+
		"\u020d\u0202\u0001\u0000\u0000\u0000\u020d\u0205\u0001\u0000\u0000\u0000"+
		"\u020d\u0208\u0001\u0000\u0000\u0000\u020e\u0211\u0001\u0000\u0000\u0000"+
		"\u020f\u020d\u0001\u0000\u0000\u0000\u020f\u0210\u0001\u0000\u0000\u0000"+
		"\u02105\u0001\u0000\u0000\u0000\u0211\u020f\u0001\u0000\u0000\u0000\u0212"+
		"\u0219\u0005=\u0000\u0000\u0213\u0219\u0005?\u0000\u0000\u0214\u0219\u0005"+
		"@\u0000\u0000\u0215\u0219\u0005B\u0000\u0000\u0216\u0219\u0005C\u0000"+
		"\u0000\u0217\u0219\u00038\u001c\u0000\u0218\u0212\u0001\u0000\u0000\u0000"+
		"\u0218\u0213\u0001\u0000\u0000\u0000\u0218\u0214\u0001\u0000\u0000\u0000"+
		"\u0218\u0215\u0001\u0000\u0000\u0000\u0218\u0216\u0001\u0000\u0000\u0000"+
		"\u0218\u0217\u0001\u0000\u0000\u0000\u02197\u0001\u0000\u0000\u0000\u021a"+
		"\u021f\u0005E\u0000\u0000\u021b\u021c\u00055\u0000\u0000\u021c\u021d\u0005"+
		"\u0001\u0000\u0000\u021d\u021f\u0005D\u0000\u0000\u021e\u021a\u0001\u0000"+
		"\u0000\u0000\u021e\u021b\u0001\u0000\u0000\u0000\u021f9\u0001\u0000\u0000"+
		"\u0000;=KQ_mr{\u0084\u0097\u009c\u00a2\u00a8\u00b0\u00b6\u00b9\u00bf\u00c7"+
		"\u00cf\u00d5\u00dd\u00e5\u00eb\u00f3\u00f9\u0107\u010f\u0115\u011b\u0123"+
		"\u0129\u012f\u0137\u013d\u0144\u014a\u0153\u0159\u015f\u0167\u016d\u0174"+
		"\u017a\u0180\u0188\u018e\u019d\u01a7\u01aa\u01b3\u01be\u01d3\u01df\u01e6"+
		"\u01e9\u01f7\u020d\u020f\u0218\u021e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}