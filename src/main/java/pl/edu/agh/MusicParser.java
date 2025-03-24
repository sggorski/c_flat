// Generated from C:/Users/kacpe/IdeaProjects/c_flat/src/main/java/pl/edu/agh/grammar/Music.g4 by ANTLR 4.13.2
package pl.edu.agh;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MusicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, INT=17, 
		BOOL=18, CHORD=19, NOTE=20, TRACK=21, BOOL_VAL=22, INT_VAL=23, NOTE_VAL=24, 
		PACE=25, DISTORTION=26, VOLUME=27, JAZZ=28, BLUES=29, INSTRUMENT=30, SUSTAIN=31, 
		KEY=32, INSTRUMENT_VALUE=33, KEY_VAL=34, SET=35, PLAY=36, PAUSE=37, LP=38, 
		RP=39, EQ=40, NEQ=41, GT=42, LT=43, GEQ=44, LEQ=45, DIV=46, MUL=47, ADD=48, 
		SUB=49, PER=50, AND=51, OR=52, NOT=53, ID=54, WS=55;
	public static final int
		RULE_program = 0, RULE_functionDecl = 1, RULE_mainDecl = 2, RULE_parameters = 3, 
		RULE_parameter = 4, RULE_type = 5, RULE_statement = 6, RULE_settings = 7, 
		RULE_settingsAssigment = 8, RULE_assignment = 9, RULE_varDecl = 10, RULE_playStatement = 11, 
		RULE_pauseStatement = 12, RULE_controlStatement = 13, RULE_forInit = 14, 
		RULE_forUpdate = 15, RULE_breakStatement = 16, RULE_continueStatement = 17, 
		RULE_functionCall = 18, RULE_arguments = 19, RULE_settingsList = 20, RULE_expr = 21, 
		RULE_op = 22, RULE_chord = 23, RULE_trackStatement = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functionDecl", "mainDecl", "parameters", "parameter", "type", 
			"statement", "settings", "settingsAssigment", "assignment", "varDecl", 
			"playStatement", "pauseStatement", "controlStatement", "forInit", "forUpdate", 
			"breakStatement", "continueStatement", "functionCall", "arguments", "settingsList", 
			"expr", "op", "chord", "trackStatement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'melody'", "'{'", "'}'", "'main'", "','", "';'", "'='", "'while'", 
			"'if'", "'else'", "'for'", "'break'", "'continue'", "'['", "']'", "'ADD'", 
			"'int'", "'bool'", "'Chord'", "'Note'", "'Track'", null, null, null, 
			"'PACE'", "'DISTORTION'", "'VOLUME'", "'JAZZ'", "'BLUES'", "'INSTRUMENT'", 
			"'SUSTAIN'", "'KEY'", null, null, "'SET'", "'PLAY'", "'PAUSE'", "'('", 
			"')'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'/'", "'*'", "'+'", 
			"'-'", "'%'", "'AND'", "'OR'", "'NOT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "INT", "BOOL", "CHORD", "NOTE", "TRACK", 
			"BOOL_VAL", "INT_VAL", "NOTE_VAL", "PACE", "DISTORTION", "VOLUME", "JAZZ", 
			"BLUES", "INSTRUMENT", "SUSTAIN", "KEY", "INSTRUMENT_VALUE", "KEY_VAL", 
			"SET", "PLAY", "PAUSE", "LP", "RP", "EQ", "NEQ", "GT", "LT", "GEQ", "LEQ", 
			"DIV", "MUL", "ADD", "SUB", "PER", "AND", "OR", "NOT", "ID", "WS"
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
	public String getGrammarFileName() { return "Music.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MusicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public MainDeclContext mainDecl() {
			return getRuleContext(MainDeclContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MusicParser.EOF, 0); }
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(50);
					functionDecl();
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(56);
			mainDecl();
			setState(57);
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
	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public TerminalNode LP() { return getToken(MusicParser.LP, 0); }
		public TerminalNode RP() { return getToken(MusicParser.RP, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__0);
			setState(60);
			match(ID);
			setState(61);
			match(LP);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) {
				{
				setState(62);
				parameters();
				}
			}

			setState(65);
			match(RP);
			setState(66);
			match(T__1);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014639031728898L) != 0)) {
				{
				{
				setState(67);
				statement();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			match(T__2);
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
	public static class MainDeclContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(MusicParser.LP, 0); }
		public TerminalNode RP() { return getToken(MusicParser.RP, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterMainDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitMainDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitMainDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainDeclContext mainDecl() throws RecognitionException {
		MainDeclContext _localctx = new MainDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mainDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(T__0);
			setState(76);
			match(T__3);
			setState(77);
			match(LP);
			setState(78);
			match(RP);
			setState(79);
			match(T__1);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014639031728898L) != 0)) {
				{
				{
				setState(80);
				statement();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			match(T__2);
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
	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			parameter();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(89);
				match(T__4);
				setState(90);
				parameter();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			type();
			setState(97);
			match(ID);
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MusicParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(MusicParser.BOOL, 0); }
		public TerminalNode CHORD() { return getToken(MusicParser.CHORD, 0); }
		public TerminalNode NOTE() { return getToken(MusicParser.NOTE, 0); }
		public TerminalNode TRACK() { return getToken(MusicParser.TRACK, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class StatementContext extends ParserRuleContext {
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public SettingsContext settings() {
			return getRuleContext(SettingsContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public PlayStatementContext playStatement() {
			return getRuleContext(PlayStatementContext.class,0);
		}
		public PauseStatementContext pauseStatement() {
			return getRuleContext(PauseStatementContext.class,0);
		}
		public ControlStatementContext controlStatement() {
			return getRuleContext(ControlStatementContext.class,0);
		}
		public TrackStatementContext trackStatement() {
			return getRuleContext(TrackStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				functionDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				settings();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				varDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(105);
				playStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(106);
				pauseStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(107);
				controlStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(108);
				trackStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(109);
				breakStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(110);
				continueStatement();
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
	public static class SettingsContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(MusicParser.SET, 0); }
		public SettingsAssigmentContext settingsAssigment() {
			return getRuleContext(SettingsAssigmentContext.class,0);
		}
		public SettingsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_settings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterSettings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitSettings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitSettings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SettingsContext settings() throws RecognitionException {
		SettingsContext _localctx = new SettingsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_settings);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(SET);
			setState(114);
			settingsAssigment();
			setState(115);
			match(T__5);
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
	public static class SettingsAssigmentContext extends ParserRuleContext {
		public SettingsAssigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_settingsAssigment; }
	 
		public SettingsAssigmentContext() { }
		public void copyFrom(SettingsAssigmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VolumeContext extends SettingsAssigmentContext {
		public TerminalNode VOLUME() { return getToken(MusicParser.VOLUME, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public VolumeContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterVolume(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitVolume(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitVolume(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JazzContext extends SettingsAssigmentContext {
		public TerminalNode JAZZ() { return getToken(MusicParser.JAZZ, 0); }
		public TerminalNode BOOL_VAL() { return getToken(MusicParser.BOOL_VAL, 0); }
		public JazzContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterJazz(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitJazz(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitJazz(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PaceContext extends SettingsAssigmentContext {
		public TerminalNode PACE() { return getToken(MusicParser.PACE, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public PaceContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitPace(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstrumentContext extends SettingsAssigmentContext {
		public TerminalNode INSTRUMENT() { return getToken(MusicParser.INSTRUMENT, 0); }
		public TerminalNode INSTRUMENT_VALUE() { return getToken(MusicParser.INSTRUMENT_VALUE, 0); }
		public InstrumentContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterInstrument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitInstrument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitInstrument(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SustainContext extends SettingsAssigmentContext {
		public TerminalNode SUSTAIN() { return getToken(MusicParser.SUSTAIN, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public SustainContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterSustain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitSustain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitSustain(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BluesContext extends SettingsAssigmentContext {
		public TerminalNode BLUES() { return getToken(MusicParser.BLUES, 0); }
		public TerminalNode BOOL_VAL() { return getToken(MusicParser.BOOL_VAL, 0); }
		public BluesContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterBlues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitBlues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitBlues(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class KeyContext extends SettingsAssigmentContext {
		public TerminalNode KEY() { return getToken(MusicParser.KEY, 0); }
		public TerminalNode KEY_VAL() { return getToken(MusicParser.KEY_VAL, 0); }
		public KeyContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitKey(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DistortionContext extends SettingsAssigmentContext {
		public TerminalNode DISTORTION() { return getToken(MusicParser.DISTORTION, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public DistortionContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterDistortion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitDistortion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitDistortion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SettingsAssigmentContext settingsAssigment() throws RecognitionException {
		SettingsAssigmentContext _localctx = new SettingsAssigmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_settingsAssigment);
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PACE:
				_localctx = new PaceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(PACE);
				setState(118);
				match(T__6);
				setState(119);
				match(INT_VAL);
				}
				break;
			case SUSTAIN:
				_localctx = new SustainContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(SUSTAIN);
				setState(121);
				match(T__6);
				setState(122);
				match(INT_VAL);
				}
				break;
			case INSTRUMENT:
				_localctx = new InstrumentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				match(INSTRUMENT);
				setState(124);
				match(T__6);
				setState(125);
				match(INSTRUMENT_VALUE);
				}
				break;
			case DISTORTION:
				_localctx = new DistortionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				match(DISTORTION);
				setState(127);
				match(T__6);
				setState(128);
				match(INT_VAL);
				}
				break;
			case JAZZ:
				_localctx = new JazzContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(129);
				match(JAZZ);
				setState(130);
				match(T__6);
				setState(131);
				match(BOOL_VAL);
				}
				break;
			case BLUES:
				_localctx = new BluesContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(132);
				match(BLUES);
				setState(133);
				match(T__6);
				setState(134);
				match(BOOL_VAL);
				}
				break;
			case VOLUME:
				_localctx = new VolumeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(135);
				match(VOLUME);
				setState(136);
				match(T__6);
				setState(137);
				match(INT_VAL);
				}
				break;
			case KEY:
				_localctx = new KeyContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(138);
				match(KEY);
				setState(139);
				match(T__6);
				setState(140);
				match(KEY_VAL);
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(ID);
			setState(144);
			match(T__6);
			setState(145);
			expr(0);
			setState(146);
			match(T__5);
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
	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_varDecl);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				type();
				setState(149);
				match(ID);
				setState(150);
				match(T__6);
				setState(151);
				expr(0);
				setState(152);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				type();
				setState(155);
				match(ID);
				setState(156);
				match(T__5);
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
	public static class PlayStatementContext extends ParserRuleContext {
		public PlayStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playStatement; }
	 
		public PlayStatementContext() { }
		public void copyFrom(PlayStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlayTrackContext extends PlayStatementContext {
		public TerminalNode PLAY() { return getToken(MusicParser.PLAY, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public PlayTrackContext(PlayStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPlayTrack(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPlayTrack(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitPlayTrack(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlayFuncContext extends PlayStatementContext {
		public TerminalNode PLAY() { return getToken(MusicParser.PLAY, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public PlayFuncContext(PlayStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPlayFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPlayFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitPlayFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlayNoteContext extends PlayStatementContext {
		public TerminalNode PLAY() { return getToken(MusicParser.PLAY, 0); }
		public TerminalNode NOTE_VAL() { return getToken(MusicParser.NOTE_VAL, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public PlayNoteContext(PlayStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPlayNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPlayNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitPlayNote(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlayChordContext extends PlayStatementContext {
		public TerminalNode PLAY() { return getToken(MusicParser.PLAY, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public PlayChordContext(PlayStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPlayChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPlayChord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitPlayChord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlayStatementContext playStatement() throws RecognitionException {
		PlayStatementContext _localctx = new PlayStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_playStatement);
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new PlayNoteContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(PLAY);
				setState(161);
				match(NOTE_VAL);
				setState(162);
				match(INT_VAL);
				setState(163);
				match(T__5);
				}
				break;
			case 2:
				_localctx = new PlayChordContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(PLAY);
				setState(165);
				match(ID);
				setState(166);
				match(INT_VAL);
				setState(167);
				match(T__5);
				}
				break;
			case 3:
				_localctx = new PlayFuncContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(PLAY);
				setState(169);
				functionCall();
				setState(170);
				match(T__5);
				}
				break;
			case 4:
				_localctx = new PlayTrackContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				match(PLAY);
				setState(173);
				match(ID);
				setState(174);
				match(T__5);
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
	public static class PauseStatementContext extends ParserRuleContext {
		public TerminalNode PAUSE() { return getToken(MusicParser.PAUSE, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public PauseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pauseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPauseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPauseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitPauseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PauseStatementContext pauseStatement() throws RecognitionException {
		PauseStatementContext _localctx = new PauseStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pauseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(PAUSE);
			setState(178);
			match(INT_VAL);
			setState(179);
			match(T__5);
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
	public static class ControlStatementContext extends ParserRuleContext {
		public List<TerminalNode> LP() { return getTokens(MusicParser.LP); }
		public TerminalNode LP(int i) {
			return getToken(MusicParser.LP, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RP() { return getTokens(MusicParser.RP); }
		public TerminalNode RP(int i) {
			return getToken(MusicParser.RP, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ControlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterControlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitControlStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitControlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlStatementContext controlStatement() throws RecognitionException {
		ControlStatementContext _localctx = new ControlStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_controlStatement);
		int _la;
		try {
			int _alt;
			setState(258);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(T__7);
				setState(182);
				match(LP);
				setState(183);
				expr(0);
				setState(184);
				match(RP);
				setState(185);
				match(T__1);
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014639031728898L) != 0)) {
					{
					{
					setState(186);
					statement();
					}
					}
					setState(191);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(192);
				match(T__2);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				match(T__8);
				setState(195);
				match(LP);
				setState(196);
				expr(0);
				setState(197);
				match(RP);
				setState(198);
				match(T__1);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014639031728898L) != 0)) {
					{
					{
					setState(199);
					statement();
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(205);
				match(T__2);
				setState(222);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(206);
						match(T__9);
						setState(207);
						match(T__8);
						setState(208);
						match(LP);
						setState(209);
						expr(0);
						setState(210);
						match(RP);
						setState(211);
						match(T__1);
						setState(215);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014639031728898L) != 0)) {
							{
							{
							setState(212);
							statement();
							}
							}
							setState(217);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(218);
						match(T__2);
						}
						} 
					}
					setState(224);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(225);
					match(T__9);
					setState(226);
					match(T__1);
					setState(230);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014639031728898L) != 0)) {
						{
						{
						setState(227);
						statement();
						}
						}
						setState(232);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(233);
					match(T__2);
					}
				}

				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(236);
				match(T__10);
				setState(237);
				match(LP);
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014398513545216L) != 0)) {
					{
					setState(238);
					forInit();
					}
				}

				setState(241);
				match(T__5);
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014673416765440L) != 0)) {
					{
					setState(242);
					expr(0);
					}
				}

				setState(245);
				match(T__5);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(246);
					forUpdate();
					}
				}

				setState(249);
				match(RP);
				setState(250);
				match(T__1);
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014639031728898L) != 0)) {
					{
					{
					setState(251);
					statement();
					}
					}
					setState(256);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(257);
				match(T__2);
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
	public static class ForInitContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forInit);
		try {
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				match(ID);
				}
				break;
			case INT:
			case BOOL:
			case CHORD:
			case NOTE:
			case TRACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				type();
				setState(262);
				match(ID);
				setState(263);
				match(T__6);
				setState(264);
				expr(0);
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
	public static class ForUpdateContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitForUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forUpdate);
		try {
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				functionCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				assignment();
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
	public static class BreakStatementContext extends ParserRuleContext {
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(T__11);
			setState(273);
			match(T__5);
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
	public static class ContinueStatementContext extends ParserRuleContext {
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(T__12);
			setState(276);
			match(T__5);
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
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public TerminalNode LP() { return getToken(MusicParser.LP, 0); }
		public TerminalNode RP() { return getToken(MusicParser.RP, 0); }
		public List<ArgumentsContext> arguments() {
			return getRuleContexts(ArgumentsContext.class);
		}
		public ArgumentsContext arguments(int i) {
			return getRuleContext(ArgumentsContext.class,i);
		}
		public SettingsListContext settingsList() {
			return getRuleContext(SettingsListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(ID);
			setState(279);
			match(LP);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18014673416765440L) != 0)) {
				{
				{
				setState(280);
				arguments();
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(286);
				match(T__4);
				}
			}

			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8556380160L) != 0)) {
				{
				setState(289);
				settingsList();
				}
			}

			setState(292);
			match(RP);
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
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_arguments);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			expr(0);
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(295);
					match(T__4);
					setState(296);
					expr(0);
					}
					} 
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
	public static class SettingsListContext extends ParserRuleContext {
		public List<SettingsAssigmentContext> settingsAssigment() {
			return getRuleContexts(SettingsAssigmentContext.class);
		}
		public SettingsAssigmentContext settingsAssigment(int i) {
			return getRuleContext(SettingsAssigmentContext.class,i);
		}
		public SettingsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_settingsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterSettingsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitSettingsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitSettingsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SettingsListContext settingsList() throws RecognitionException {
		SettingsListContext _localctx = new SettingsListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_settingsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			settingsAssigment();
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(303);
				match(T__4);
				setState(304);
				settingsAssigment();
				}
				}
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class NoteContext extends ExprContext {
		public TerminalNode NOTE_VAL() { return getToken(MusicParser.NOTE_VAL, 0); }
		public NoteContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitNote(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ExprContext {
		public TerminalNode BOOL_VAL() { return getToken(MusicParser.BOOL_VAL, 0); }
		public BoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParanthesesContext extends ExprContext {
		public TerminalNode LP() { return getToken(MusicParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(MusicParser.RP, 0); }
		public ParanthesesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterParantheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitParantheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitParantheses(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChordExprContext extends ExprContext {
		public ChordContext chord() {
			return getRuleContext(ChordContext.class,0);
		}
		public ChordExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterChordExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitChordExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitChordExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public OperatorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitOperator(this);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTE_VAL:
				{
				_localctx = new NoteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(311);
				match(NOTE_VAL);
				}
				break;
			case INT_VAL:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(312);
				match(INT_VAL);
				}
				break;
			case BOOL_VAL:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(313);
				match(BOOL_VAL);
				}
				break;
			case LP:
				{
				_localctx = new ParanthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(314);
				match(LP);
				setState(315);
				expr(0);
				setState(316);
				match(RP);
				}
				break;
			case T__13:
				{
				_localctx = new ChordExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(318);
				chord();
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(319);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(328);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OperatorContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(322);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(323);
					op();
					setState(324);
					expr(5);
					}
					} 
				}
				setState(330);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
	public static class OpContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(MusicParser.LT, 0); }
		public TerminalNode EQ() { return getToken(MusicParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MusicParser.NEQ, 0); }
		public TerminalNode GEQ() { return getToken(MusicParser.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(MusicParser.LEQ, 0); }
		public TerminalNode GT() { return getToken(MusicParser.GT, 0); }
		public TerminalNode DIV() { return getToken(MusicParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(MusicParser.MUL, 0); }
		public TerminalNode SUB() { return getToken(MusicParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(MusicParser.ADD, 0); }
		public TerminalNode PER() { return getToken(MusicParser.PER, 0); }
		public TerminalNode AND() { return getToken(MusicParser.AND, 0); }
		public TerminalNode OR() { return getToken(MusicParser.OR, 0); }
		public TerminalNode NOT() { return getToken(MusicParser.NOT, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 18013298997854208L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class ChordContext extends ParserRuleContext {
		public List<TerminalNode> NOTE_VAL() { return getTokens(MusicParser.NOTE_VAL); }
		public TerminalNode NOTE_VAL(int i) {
			return getToken(MusicParser.NOTE_VAL, i);
		}
		public ChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitChord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitChord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChordContext chord() throws RecognitionException {
		ChordContext _localctx = new ChordContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_chord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(T__13);
			setState(334);
			match(NOTE_VAL);
			setState(337); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(335);
				match(T__4);
				setState(336);
				match(NOTE_VAL);
				}
				}
				setState(339); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(341);
			match(T__14);
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
	public static class TrackStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TrackStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trackStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterTrackStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitTrackStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitTrackStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrackStatementContext trackStatement() throws RecognitionException {
		TrackStatementContext _localctx = new TrackStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_trackStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(ID);
			setState(344);
			match(T__15);
			setState(345);
			functionCall();
			setState(346);
			match(T__5);
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
		case 21:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00017\u015d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0005\u00004\b\u0000\n\u0000\f\u00007\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001@\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"E\b\u0001\n\u0001\f\u0001H\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"R\b\u0002\n\u0002\f\u0002U\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003\\\b\u0003\n\u0003\f\u0003_\t\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006p\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u008e\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u009f\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00b0"+
		"\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u00bc\b\r\n\r\f\r\u00bf\t\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00c9\b\r\n\r"+
		"\f\r\u00cc\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0005\r\u00d6\b\r\n\r\f\r\u00d9\t\r\u0001\r\u0001\r\u0005\r\u00dd"+
		"\b\r\n\r\f\r\u00e0\t\r\u0001\r\u0001\r\u0001\r\u0005\r\u00e5\b\r\n\r\f"+
		"\r\u00e8\t\r\u0001\r\u0003\r\u00eb\b\r\u0001\r\u0001\r\u0001\r\u0003\r"+
		"\u00f0\b\r\u0001\r\u0001\r\u0003\r\u00f4\b\r\u0001\r\u0001\r\u0003\r\u00f8"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0005\r\u00fd\b\r\n\r\f\r\u0100\t\r\u0001"+
		"\r\u0003\r\u0103\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u010b\b\u000e\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u010f\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u011a"+
		"\b\u0012\n\u0012\f\u0012\u011d\t\u0012\u0001\u0012\u0003\u0012\u0120\b"+
		"\u0012\u0001\u0012\u0003\u0012\u0123\b\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u012a\b\u0013\n\u0013\f\u0013"+
		"\u012d\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0132\b"+
		"\u0014\n\u0014\f\u0014\u0135\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u0141\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0005\u0015\u0147\b\u0015\n\u0015\f\u0015\u014a\t\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0004"+
		"\u0017\u0152\b\u0017\u000b\u0017\f\u0017\u0153\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0000\u0001*\u0019\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.0\u0000\u0002\u0001\u0000\u0011"+
		"\u0015\u0001\u0000(5\u0176\u00005\u0001\u0000\u0000\u0000\u0002;\u0001"+
		"\u0000\u0000\u0000\u0004K\u0001\u0000\u0000\u0000\u0006X\u0001\u0000\u0000"+
		"\u0000\b`\u0001\u0000\u0000\u0000\nc\u0001\u0000\u0000\u0000\fo\u0001"+
		"\u0000\u0000\u0000\u000eq\u0001\u0000\u0000\u0000\u0010\u008d\u0001\u0000"+
		"\u0000\u0000\u0012\u008f\u0001\u0000\u0000\u0000\u0014\u009e\u0001\u0000"+
		"\u0000\u0000\u0016\u00af\u0001\u0000\u0000\u0000\u0018\u00b1\u0001\u0000"+
		"\u0000\u0000\u001a\u0102\u0001\u0000\u0000\u0000\u001c\u010a\u0001\u0000"+
		"\u0000\u0000\u001e\u010e\u0001\u0000\u0000\u0000 \u0110\u0001\u0000\u0000"+
		"\u0000\"\u0113\u0001\u0000\u0000\u0000$\u0116\u0001\u0000\u0000\u0000"+
		"&\u0126\u0001\u0000\u0000\u0000(\u012e\u0001\u0000\u0000\u0000*\u0140"+
		"\u0001\u0000\u0000\u0000,\u014b\u0001\u0000\u0000\u0000.\u014d\u0001\u0000"+
		"\u0000\u00000\u0157\u0001\u0000\u0000\u000024\u0003\u0002\u0001\u0000"+
		"32\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u000056\u0001\u0000\u0000\u000068\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u000089\u0003\u0004\u0002\u00009:\u0005\u0000\u0000\u0001:\u0001"+
		"\u0001\u0000\u0000\u0000;<\u0005\u0001\u0000\u0000<=\u00056\u0000\u0000"+
		"=?\u0005&\u0000\u0000>@\u0003\u0006\u0003\u0000?>\u0001\u0000\u0000\u0000"+
		"?@\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0005\'\u0000\u0000"+
		"BF\u0005\u0002\u0000\u0000CE\u0003\f\u0006\u0000DC\u0001\u0000\u0000\u0000"+
		"EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000GI\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0005\u0003"+
		"\u0000\u0000J\u0003\u0001\u0000\u0000\u0000KL\u0005\u0001\u0000\u0000"+
		"LM\u0005\u0004\u0000\u0000MN\u0005&\u0000\u0000NO\u0005\'\u0000\u0000"+
		"OS\u0005\u0002\u0000\u0000PR\u0003\f\u0006\u0000QP\u0001\u0000\u0000\u0000"+
		"RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000"+
		"\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VW\u0005\u0003"+
		"\u0000\u0000W\u0005\u0001\u0000\u0000\u0000X]\u0003\b\u0004\u0000YZ\u0005"+
		"\u0005\u0000\u0000Z\\\u0003\b\u0004\u0000[Y\u0001\u0000\u0000\u0000\\"+
		"_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^\u0007\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`a\u0003"+
		"\n\u0005\u0000ab\u00056\u0000\u0000b\t\u0001\u0000\u0000\u0000cd\u0007"+
		"\u0000\u0000\u0000d\u000b\u0001\u0000\u0000\u0000ep\u0003\u0002\u0001"+
		"\u0000fp\u0003\u0012\t\u0000gp\u0003\u000e\u0007\u0000hp\u0003\u0014\n"+
		"\u0000ip\u0003\u0016\u000b\u0000jp\u0003\u0018\f\u0000kp\u0003\u001a\r"+
		"\u0000lp\u00030\u0018\u0000mp\u0003 \u0010\u0000np\u0003\"\u0011\u0000"+
		"oe\u0001\u0000\u0000\u0000of\u0001\u0000\u0000\u0000og\u0001\u0000\u0000"+
		"\u0000oh\u0001\u0000\u0000\u0000oi\u0001\u0000\u0000\u0000oj\u0001\u0000"+
		"\u0000\u0000ok\u0001\u0000\u0000\u0000ol\u0001\u0000\u0000\u0000om\u0001"+
		"\u0000\u0000\u0000on\u0001\u0000\u0000\u0000p\r\u0001\u0000\u0000\u0000"+
		"qr\u0005#\u0000\u0000rs\u0003\u0010\b\u0000st\u0005\u0006\u0000\u0000"+
		"t\u000f\u0001\u0000\u0000\u0000uv\u0005\u0019\u0000\u0000vw\u0005\u0007"+
		"\u0000\u0000w\u008e\u0005\u0017\u0000\u0000xy\u0005\u001f\u0000\u0000"+
		"yz\u0005\u0007\u0000\u0000z\u008e\u0005\u0017\u0000\u0000{|\u0005\u001e"+
		"\u0000\u0000|}\u0005\u0007\u0000\u0000}\u008e\u0005!\u0000\u0000~\u007f"+
		"\u0005\u001a\u0000\u0000\u007f\u0080\u0005\u0007\u0000\u0000\u0080\u008e"+
		"\u0005\u0017\u0000\u0000\u0081\u0082\u0005\u001c\u0000\u0000\u0082\u0083"+
		"\u0005\u0007\u0000\u0000\u0083\u008e\u0005\u0016\u0000\u0000\u0084\u0085"+
		"\u0005\u001d\u0000\u0000\u0085\u0086\u0005\u0007\u0000\u0000\u0086\u008e"+
		"\u0005\u0016\u0000\u0000\u0087\u0088\u0005\u001b\u0000\u0000\u0088\u0089"+
		"\u0005\u0007\u0000\u0000\u0089\u008e\u0005\u0017\u0000\u0000\u008a\u008b"+
		"\u0005 \u0000\u0000\u008b\u008c\u0005\u0007\u0000\u0000\u008c\u008e\u0005"+
		"\"\u0000\u0000\u008du\u0001\u0000\u0000\u0000\u008dx\u0001\u0000\u0000"+
		"\u0000\u008d{\u0001\u0000\u0000\u0000\u008d~\u0001\u0000\u0000\u0000\u008d"+
		"\u0081\u0001\u0000\u0000\u0000\u008d\u0084\u0001\u0000\u0000\u0000\u008d"+
		"\u0087\u0001\u0000\u0000\u0000\u008d\u008a\u0001\u0000\u0000\u0000\u008e"+
		"\u0011\u0001\u0000\u0000\u0000\u008f\u0090\u00056\u0000\u0000\u0090\u0091"+
		"\u0005\u0007\u0000\u0000\u0091\u0092\u0003*\u0015\u0000\u0092\u0093\u0005"+
		"\u0006\u0000\u0000\u0093\u0013\u0001\u0000\u0000\u0000\u0094\u0095\u0003"+
		"\n\u0005\u0000\u0095\u0096\u00056\u0000\u0000\u0096\u0097\u0005\u0007"+
		"\u0000\u0000\u0097\u0098\u0003*\u0015\u0000\u0098\u0099\u0005\u0006\u0000"+
		"\u0000\u0099\u009f\u0001\u0000\u0000\u0000\u009a\u009b\u0003\n\u0005\u0000"+
		"\u009b\u009c\u00056\u0000\u0000\u009c\u009d\u0005\u0006\u0000\u0000\u009d"+
		"\u009f\u0001\u0000\u0000\u0000\u009e\u0094\u0001\u0000\u0000\u0000\u009e"+
		"\u009a\u0001\u0000\u0000\u0000\u009f\u0015\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0005$\u0000\u0000\u00a1\u00a2\u0005\u0018\u0000\u0000\u00a2\u00a3"+
		"\u0005\u0017\u0000\u0000\u00a3\u00b0\u0005\u0006\u0000\u0000\u00a4\u00a5"+
		"\u0005$\u0000\u0000\u00a5\u00a6\u00056\u0000\u0000\u00a6\u00a7\u0005\u0017"+
		"\u0000\u0000\u00a7\u00b0\u0005\u0006\u0000\u0000\u00a8\u00a9\u0005$\u0000"+
		"\u0000\u00a9\u00aa\u0003$\u0012\u0000\u00aa\u00ab\u0005\u0006\u0000\u0000"+
		"\u00ab\u00b0\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005$\u0000\u0000\u00ad"+
		"\u00ae\u00056\u0000\u0000\u00ae\u00b0\u0005\u0006\u0000\u0000\u00af\u00a0"+
		"\u0001\u0000\u0000\u0000\u00af\u00a4\u0001\u0000\u0000\u0000\u00af\u00a8"+
		"\u0001\u0000\u0000\u0000\u00af\u00ac\u0001\u0000\u0000\u0000\u00b0\u0017"+
		"\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005%\u0000\u0000\u00b2\u00b3\u0005"+
		"\u0017\u0000\u0000\u00b3\u00b4\u0005\u0006\u0000\u0000\u00b4\u0019\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b6\u0005\b\u0000\u0000\u00b6\u00b7\u0005&"+
		"\u0000\u0000\u00b7\u00b8\u0003*\u0015\u0000\u00b8\u00b9\u0005\'\u0000"+
		"\u0000\u00b9\u00bd\u0005\u0002\u0000\u0000\u00ba\u00bc\u0003\f\u0006\u0000"+
		"\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000"+
		"\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000"+
		"\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c1\u0005\u0003\u0000\u0000\u00c1\u0103\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c3\u0005\t\u0000\u0000\u00c3\u00c4\u0005&\u0000\u0000\u00c4"+
		"\u00c5\u0003*\u0015\u0000\u00c5\u00c6\u0005\'\u0000\u0000\u00c6\u00ca"+
		"\u0005\u0002\u0000\u0000\u00c7\u00c9\u0003\f\u0006\u0000\u00c8\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd\u00de\u0005"+
		"\u0003\u0000\u0000\u00ce\u00cf\u0005\n\u0000\u0000\u00cf\u00d0\u0005\t"+
		"\u0000\u0000\u00d0\u00d1\u0005&\u0000\u0000\u00d1\u00d2\u0003*\u0015\u0000"+
		"\u00d2\u00d3\u0005\'\u0000\u0000\u00d3\u00d7\u0005\u0002\u0000\u0000\u00d4"+
		"\u00d6\u0003\f\u0006\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d9"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d8\u00da\u0001\u0000\u0000\u0000\u00d9\u00d7"+
		"\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u0003\u0000\u0000\u00db\u00dd"+
		"\u0001\u0000\u0000\u0000\u00dc\u00ce\u0001\u0000\u0000\u0000\u00dd\u00e0"+
		"\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00df"+
		"\u0001\u0000\u0000\u0000\u00df\u00ea\u0001\u0000\u0000\u0000\u00e0\u00de"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005\n\u0000\u0000\u00e2\u00e6\u0005"+
		"\u0002\u0000\u0000\u00e3\u00e5\u0003\f\u0006\u0000\u00e4\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e8\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e9\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e9\u00eb\u0005\u0003"+
		"\u0000\u0000\u00ea\u00e1\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000"+
		"\u0000\u0000\u00eb\u0103\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u000b"+
		"\u0000\u0000\u00ed\u00ef\u0005&\u0000\u0000\u00ee\u00f0\u0003\u001c\u000e"+
		"\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f3\u0005\u0006\u0000"+
		"\u0000\u00f2\u00f4\u0003*\u0015\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f7\u0005\u0006\u0000\u0000\u00f6\u00f8\u0003\u001e\u000f\u0000"+
		"\u00f7\u00f6\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000"+
		"\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005\'\u0000\u0000\u00fa"+
		"\u00fe\u0005\u0002\u0000\u0000\u00fb\u00fd\u0003\f\u0006\u0000\u00fc\u00fb"+
		"\u0001\u0000\u0000\u0000\u00fd\u0100\u0001\u0000\u0000\u0000\u00fe\u00fc"+
		"\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0101"+
		"\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0101\u0103"+
		"\u0005\u0003\u0000\u0000\u0102\u00b5\u0001\u0000\u0000\u0000\u0102\u00c2"+
		"\u0001\u0000\u0000\u0000\u0102\u00ec\u0001\u0000\u0000\u0000\u0103\u001b"+
		"\u0001\u0000\u0000\u0000\u0104\u010b\u00056\u0000\u0000\u0105\u0106\u0003"+
		"\n\u0005\u0000\u0106\u0107\u00056\u0000\u0000\u0107\u0108\u0005\u0007"+
		"\u0000\u0000\u0108\u0109\u0003*\u0015\u0000\u0109\u010b\u0001\u0000\u0000"+
		"\u0000\u010a\u0104\u0001\u0000\u0000\u0000\u010a\u0105\u0001\u0000\u0000"+
		"\u0000\u010b\u001d\u0001\u0000\u0000\u0000\u010c\u010f\u0003$\u0012\u0000"+
		"\u010d\u010f\u0003\u0012\t\u0000\u010e\u010c\u0001\u0000\u0000\u0000\u010e"+
		"\u010d\u0001\u0000\u0000\u0000\u010f\u001f\u0001\u0000\u0000\u0000\u0110"+
		"\u0111\u0005\f\u0000\u0000\u0111\u0112\u0005\u0006\u0000\u0000\u0112!"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0005\r\u0000\u0000\u0114\u0115\u0005"+
		"\u0006\u0000\u0000\u0115#\u0001\u0000\u0000\u0000\u0116\u0117\u00056\u0000"+
		"\u0000\u0117\u011b\u0005&\u0000\u0000\u0118\u011a\u0003&\u0013\u0000\u0119"+
		"\u0118\u0001\u0000\u0000\u0000\u011a\u011d\u0001\u0000\u0000\u0000\u011b"+
		"\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c"+
		"\u011f\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011e"+
		"\u0120\u0005\u0005\u0000\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u011f"+
		"\u0120\u0001\u0000\u0000\u0000\u0120\u0122\u0001\u0000\u0000\u0000\u0121"+
		"\u0123\u0003(\u0014\u0000\u0122\u0121\u0001\u0000\u0000\u0000\u0122\u0123"+
		"\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u0125"+
		"\u0005\'\u0000\u0000\u0125%\u0001\u0000\u0000\u0000\u0126\u012b\u0003"+
		"*\u0015\u0000\u0127\u0128\u0005\u0005\u0000\u0000\u0128\u012a\u0003*\u0015"+
		"\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u012a\u012d\u0001\u0000\u0000"+
		"\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000"+
		"\u0000\u012c\'\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000"+
		"\u012e\u0133\u0003\u0010\b\u0000\u012f\u0130\u0005\u0005\u0000\u0000\u0130"+
		"\u0132\u0003\u0010\b\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0132\u0135"+
		"\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0133\u0134"+
		"\u0001\u0000\u0000\u0000\u0134)\u0001\u0000\u0000\u0000\u0135\u0133\u0001"+
		"\u0000\u0000\u0000\u0136\u0137\u0006\u0015\uffff\uffff\u0000\u0137\u0141"+
		"\u0005\u0018\u0000\u0000\u0138\u0141\u0005\u0017\u0000\u0000\u0139\u0141"+
		"\u0005\u0016\u0000\u0000\u013a\u013b\u0005&\u0000\u0000\u013b\u013c\u0003"+
		"*\u0015\u0000\u013c\u013d\u0005\'\u0000\u0000\u013d\u0141\u0001\u0000"+
		"\u0000\u0000\u013e\u0141\u0003.\u0017\u0000\u013f\u0141\u00056\u0000\u0000"+
		"\u0140\u0136\u0001\u0000\u0000\u0000\u0140\u0138\u0001\u0000\u0000\u0000"+
		"\u0140\u0139\u0001\u0000\u0000\u0000\u0140\u013a\u0001\u0000\u0000\u0000"+
		"\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u013f\u0001\u0000\u0000\u0000"+
		"\u0141\u0148\u0001\u0000\u0000\u0000\u0142\u0143\n\u0004\u0000\u0000\u0143"+
		"\u0144\u0003,\u0016\u0000\u0144\u0145\u0003*\u0015\u0005\u0145\u0147\u0001"+
		"\u0000\u0000\u0000\u0146\u0142\u0001\u0000\u0000\u0000\u0147\u014a\u0001"+
		"\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0148\u0149\u0001"+
		"\u0000\u0000\u0000\u0149+\u0001\u0000\u0000\u0000\u014a\u0148\u0001\u0000"+
		"\u0000\u0000\u014b\u014c\u0007\u0001\u0000\u0000\u014c-\u0001\u0000\u0000"+
		"\u0000\u014d\u014e\u0005\u000e\u0000\u0000\u014e\u0151\u0005\u0018\u0000"+
		"\u0000\u014f\u0150\u0005\u0005\u0000\u0000\u0150\u0152\u0005\u0018\u0000"+
		"\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000\u0000"+
		"\u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000"+
		"\u0000\u0154\u0155\u0001\u0000\u0000\u0000\u0155\u0156\u0005\u000f\u0000"+
		"\u0000\u0156/\u0001\u0000\u0000\u0000\u0157\u0158\u00056\u0000\u0000\u0158"+
		"\u0159\u0005\u0010\u0000\u0000\u0159\u015a\u0003$\u0012\u0000\u015a\u015b"+
		"\u0005\u0006\u0000\u0000\u015b1\u0001\u0000\u0000\u0000\u001e5?FS]o\u008d"+
		"\u009e\u00af\u00bd\u00ca\u00d7\u00de\u00e6\u00ea\u00ef\u00f3\u00f7\u00fe"+
		"\u0102\u010a\u010e\u011b\u011f\u0122\u012b\u0133\u0140\u0148\u0153";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}