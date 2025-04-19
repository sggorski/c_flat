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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, IMPORT=16, 
		INT=17, BOOL=18, CHORD=19, NOTE=20, TRACK=21, BOOL_VAL=22, INT_VAL=23, 
		NOTE_VAL=24, STRING_VAL=25, ESC=26, PACE=27, DISTORTION=28, VOLUME=29, 
		JAZZ=30, BLUES=31, INSTRUMENT=32, SUSTAIN=33, VIBRATO=34, BALANCE=35, 
		SOSTENUTO=36, SOFT=37, RESONANCE=38, REVERB=39, TREMOLO=40, CHORUS=41, 
		PHRASER=42, INSTRUMENT_VALUE=43, SET=44, PLAY=45, PAUSE=46, SUMIS=47, 
		DIVIS=48, MULIS=49, SUBIS=50, LP=51, RP=52, EQ=53, NEQ=54, GT=55, LT=56, 
		GEQ=57, LEQ=58, DIV=59, MUL=60, ADD=61, SUB=62, PER=63, AND=64, OR=65, 
		NOT=66, LINE_COMMENT=67, BLOCK_COMMENT=68, ID=69, WS=70, SEMICOLON=71;
	public static final int
		RULE_program = 0, RULE_imports = 1, RULE_functionDecl = 2, RULE_mainDecl = 3, 
		RULE_parameters = 4, RULE_parameter = 5, RULE_type = 6, RULE_mainStatement = 7, 
		RULE_statement = 8, RULE_loopStatement = 9, RULE_settings = 10, RULE_settingsAssigment = 11, 
		RULE_settingsValues = 12, RULE_assignment = 13, RULE_selfAssignment = 14, 
		RULE_varDecl = 15, RULE_playStatement = 16, RULE_playValues = 17, RULE_multiPlayValues = 18, 
		RULE_pauseStatement = 19, RULE_controlStatement = 20, RULE_forInit = 21, 
		RULE_forUpdate = 22, RULE_forAssignment = 23, RULE_breakStatement = 24, 
		RULE_continueStatement = 25, RULE_functionCall = 26, RULE_arguments = 27, 
		RULE_settingsList = 28, RULE_expr = 29, RULE_orderOp = 30, RULE_eqOp = 31, 
		RULE_andOp = 32, RULE_orOp = 33, RULE_addSubOp = 34, RULE_mullDivOp = 35, 
		RULE_assOp = 36, RULE_chord = 37, RULE_trackStatements = 38, RULE_trackStatement = 39, 
		RULE_trackDeclaration = 40, RULE_intVal = 41;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "imports", "functionDecl", "mainDecl", "parameters", "parameter", 
			"type", "mainStatement", "statement", "loopStatement", "settings", "settingsAssigment", 
			"settingsValues", "assignment", "selfAssignment", "varDecl", "playStatement", 
			"playValues", "multiPlayValues", "pauseStatement", "controlStatement", 
			"forInit", "forUpdate", "forAssignment", "breakStatement", "continueStatement", 
			"functionCall", "arguments", "settingsList", "expr", "orderOp", "eqOp", 
			"andOp", "orOp", "addSubOp", "mullDivOp", "assOp", "chord", "trackStatements", 
			"trackStatement", "trackDeclaration", "intVal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'melody'", "'{'", "'}'", "'main'", "','", "'='", "'while'", "'if'", 
			"'else'", "'for'", "'break'", "'continue'", "'['", "']'", "'ADD'", "'import'", 
			"'int'", "'bool'", "'Chord'", "'Note'", "'Track'", null, null, null, 
			null, null, "'PACE'", "'DISTORTION'", "'VOLUME'", "'JAZZ'", "'BLUES'", 
			"'INSTRUMENT'", "'SUSTAIN'", "'VIBRATO'", "'BALANCE'", "'SOSTENUTO'", 
			"'SOFT'", "'RESONANCE'", "'REVERB'", "'TREMOLO'", "'CHORUS'", "'PHRASER'", 
			null, "'SET'", "'PLAY'", "'PAUSE'", "'+='", "'/='", "'*='", "'-='", "'('", 
			"')'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'/'", "'*'", "'+'", 
			"'-'", "'%'", "'AND'", "'OR'", "'NOT'", null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "IMPORT", "INT", "BOOL", "CHORD", "NOTE", "TRACK", 
			"BOOL_VAL", "INT_VAL", "NOTE_VAL", "STRING_VAL", "ESC", "PACE", "DISTORTION", 
			"VOLUME", "JAZZ", "BLUES", "INSTRUMENT", "SUSTAIN", "VIBRATO", "BALANCE", 
			"SOSTENUTO", "SOFT", "RESONANCE", "REVERB", "TREMOLO", "CHORUS", "PHRASER", 
			"INSTRUMENT_VALUE", "SET", "PLAY", "PAUSE", "SUMIS", "DIVIS", "MULIS", 
			"SUBIS", "LP", "RP", "EQ", "NEQ", "GT", "LT", "GEQ", "LEQ", "DIV", "MUL", 
			"ADD", "SUB", "PER", "AND", "OR", "NOT", "LINE_COMMENT", "BLOCK_COMMENT", 
			"ID", "WS", "SEMICOLON"
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
		public TerminalNode EOF() { return getToken(MusicParser.EOF, 0); }
		public List<ImportsContext> imports() {
			return getRuleContexts(ImportsContext.class);
		}
		public ImportsContext imports(int i) {
			return getRuleContext(ImportsContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public MainDeclContext mainDecl() {
			return getRuleContext(MainDeclContext.class,0);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(84);
				imports();
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(90);
					functionDecl();
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(96);
				mainDecl();
				}
			}

			setState(99);
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
	public static class ImportsContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(MusicParser.IMPORT, 0); }
		public TerminalNode STRING_VAL() { return getToken(MusicParser.STRING_VAL, 0); }
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitImports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_imports);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(IMPORT);
			setState(102);
			match(STRING_VAL);
			setState(103);
			match(SEMICOLON);
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
		enterRule(_localctx, 4, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__0);
			setState(106);
			match(ID);
			setState(107);
			match(LP);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1966080L) != 0)) {
				{
				setState(108);
				parameters();
				}
			}

			setState(111);
			match(RP);
			setState(112);
			match(T__1);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 123145304278402L) != 0) || _la==ID) {
				{
				{
				setState(113);
				statement();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
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
		public List<MainStatementContext> mainStatement() {
			return getRuleContexts(MainStatementContext.class);
		}
		public MainStatementContext mainStatement(int i) {
			return getRuleContext(MainStatementContext.class,i);
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
		enterRule(_localctx, 6, RULE_mainDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__0);
			setState(122);
			match(T__3);
			setState(123);
			match(LP);
			setState(124);
			match(RP);
			setState(125);
			match(T__1);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 123145306375554L) != 0) || _la==ID) {
				{
				{
				setState(126);
				mainStatement();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
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
		enterRule(_localctx, 8, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			parameter();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(135);
				match(T__4);
				setState(136);
				parameter();
				}
				}
				setState(141);
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
		enterRule(_localctx, 10, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			type();
			setState(143);
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
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1966080L) != 0)) ) {
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
	public static class MainStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TrackStatementsContext trackStatements() {
			return getRuleContext(TrackStatementsContext.class,0);
		}
		public MainStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterMainStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitMainStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitMainStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainStatementContext mainStatement() throws RecognitionException {
		MainStatementContext _localctx = new MainStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_mainStatement);
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				trackStatements();
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
	public static class StatementContext extends ParserRuleContext {
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public SelfAssignmentContext selfAssignment() {
			return getRuleContext(SelfAssignmentContext.class,0);
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
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				functionDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				selfAssignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				settings();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(155);
				varDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(156);
				playStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(157);
				pauseStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(158);
				controlStatement();
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
	public static class LoopStatementContext extends ParserRuleContext {
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_loopStatement);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				breakStatement();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				continueStatement();
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
	public static class SettingsContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(MusicParser.SET, 0); }
		public SettingsAssigmentContext settingsAssigment() {
			return getRuleContext(SettingsAssigmentContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 20, RULE_settings);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(SET);
			setState(166);
			settingsAssigment();
			setState(167);
			match(SEMICOLON);
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
	public static class JazzContext extends SettingsAssigmentContext {
		public TerminalNode JAZZ() { return getToken(MusicParser.JAZZ, 0); }
		public TerminalNode BOOL_VAL() { return getToken(MusicParser.BOOL_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
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
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
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
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
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
	public static class ResonanceContext extends SettingsAssigmentContext {
		public TerminalNode RESONANCE() { return getToken(MusicParser.RESONANCE, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public ResonanceContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterResonance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitResonance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitResonance(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BluesContext extends SettingsAssigmentContext {
		public TerminalNode BLUES() { return getToken(MusicParser.BLUES, 0); }
		public TerminalNode BOOL_VAL() { return getToken(MusicParser.BOOL_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
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
	public static class SostenutoPedalContext extends SettingsAssigmentContext {
		public TerminalNode SOSTENUTO() { return getToken(MusicParser.SOSTENUTO, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public SostenutoPedalContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterSostenutoPedal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitSostenutoPedal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitSostenutoPedal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VolumeContext extends SettingsAssigmentContext {
		public TerminalNode VOLUME() { return getToken(MusicParser.VOLUME, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
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
	public static class TremoloContext extends SettingsAssigmentContext {
		public TerminalNode TREMOLO() { return getToken(MusicParser.TREMOLO, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public TremoloContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterTremolo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitTremolo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitTremolo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BalanceContext extends SettingsAssigmentContext {
		public TerminalNode BALANCE() { return getToken(MusicParser.BALANCE, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public BalanceContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterBalance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitBalance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitBalance(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SoftPedalContext extends SettingsAssigmentContext {
		public TerminalNode SOFT() { return getToken(MusicParser.SOFT, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public SoftPedalContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterSoftPedal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitSoftPedal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitSoftPedal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChorusContext extends SettingsAssigmentContext {
		public TerminalNode CHORUS() { return getToken(MusicParser.CHORUS, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public ChorusContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterChorus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitChorus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitChorus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReverbContext extends SettingsAssigmentContext {
		public TerminalNode REVERB() { return getToken(MusicParser.REVERB, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public ReverbContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterReverb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitReverb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitReverb(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SustainContext extends SettingsAssigmentContext {
		public TerminalNode SUSTAIN() { return getToken(MusicParser.SUSTAIN, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
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
	public static class DistortionContext extends SettingsAssigmentContext {
		public TerminalNode DISTORTION() { return getToken(MusicParser.DISTORTION, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class VibratoContext extends SettingsAssigmentContext {
		public TerminalNode VIBRATO() { return getToken(MusicParser.VIBRATO, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public VibratoContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterVibrato(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitVibrato(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitVibrato(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PhraserContext extends SettingsAssigmentContext {
		public TerminalNode PHRASER() { return getToken(MusicParser.PHRASER, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public PhraserContext(SettingsAssigmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPhraser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPhraser(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitPhraser(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SettingsAssigmentContext settingsAssigment() throws RecognitionException {
		SettingsAssigmentContext _localctx = new SettingsAssigmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_settingsAssigment);
		int _la;
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PACE:
				_localctx = new PaceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(PACE);
				setState(170);
				match(T__5);
				setState(171);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case SUSTAIN:
				_localctx = new SustainContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(SUSTAIN);
				setState(173);
				match(T__5);
				setState(174);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case INSTRUMENT:
				_localctx = new InstrumentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(175);
				match(INSTRUMENT);
				setState(176);
				match(T__5);
				setState(177);
				_la = _input.LA(1);
				if ( !(_la==INSTRUMENT_VALUE || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case DISTORTION:
				_localctx = new DistortionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(178);
				match(DISTORTION);
				setState(179);
				match(T__5);
				setState(180);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case JAZZ:
				_localctx = new JazzContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(181);
				match(JAZZ);
				setState(182);
				match(T__5);
				setState(183);
				_la = _input.LA(1);
				if ( !(_la==BOOL_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case BLUES:
				_localctx = new BluesContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(184);
				match(BLUES);
				setState(185);
				match(T__5);
				setState(186);
				_la = _input.LA(1);
				if ( !(_la==BOOL_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case VOLUME:
				_localctx = new VolumeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(187);
				match(VOLUME);
				setState(188);
				match(T__5);
				setState(189);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case VIBRATO:
				_localctx = new VibratoContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(190);
				match(VIBRATO);
				setState(191);
				match(T__5);
				setState(192);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case BALANCE:
				_localctx = new BalanceContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(193);
				match(BALANCE);
				setState(194);
				match(T__5);
				setState(195);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case SOSTENUTO:
				_localctx = new SostenutoPedalContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(196);
				match(SOSTENUTO);
				setState(197);
				match(T__5);
				setState(198);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case SOFT:
				_localctx = new SoftPedalContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(199);
				match(SOFT);
				setState(200);
				match(T__5);
				setState(201);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case RESONANCE:
				_localctx = new ResonanceContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(202);
				match(RESONANCE);
				setState(203);
				match(T__5);
				setState(204);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case REVERB:
				_localctx = new ReverbContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(205);
				match(REVERB);
				setState(206);
				match(T__5);
				setState(207);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case TREMOLO:
				_localctx = new TremoloContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(208);
				match(TREMOLO);
				setState(209);
				match(T__5);
				setState(210);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case CHORUS:
				_localctx = new ChorusContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(211);
				match(CHORUS);
				setState(212);
				match(T__5);
				setState(213);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case PHRASER:
				_localctx = new PhraserContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(214);
				match(PHRASER);
				setState(215);
				match(T__5);
				setState(216);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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
	public static class SettingsValuesContext extends ParserRuleContext {
		public TerminalNode PACE() { return getToken(MusicParser.PACE, 0); }
		public TerminalNode SUSTAIN() { return getToken(MusicParser.SUSTAIN, 0); }
		public TerminalNode INSTRUMENT() { return getToken(MusicParser.INSTRUMENT, 0); }
		public TerminalNode DISTORTION() { return getToken(MusicParser.DISTORTION, 0); }
		public TerminalNode JAZZ() { return getToken(MusicParser.JAZZ, 0); }
		public TerminalNode BLUES() { return getToken(MusicParser.BLUES, 0); }
		public TerminalNode VOLUME() { return getToken(MusicParser.VOLUME, 0); }
		public TerminalNode VIBRATO() { return getToken(MusicParser.VIBRATO, 0); }
		public TerminalNode BALANCE() { return getToken(MusicParser.BALANCE, 0); }
		public TerminalNode SOSTENUTO() { return getToken(MusicParser.SOSTENUTO, 0); }
		public TerminalNode SOFT() { return getToken(MusicParser.SOFT, 0); }
		public TerminalNode RESONANCE() { return getToken(MusicParser.RESONANCE, 0); }
		public TerminalNode REVERB() { return getToken(MusicParser.REVERB, 0); }
		public TerminalNode TREMOLO() { return getToken(MusicParser.TREMOLO, 0); }
		public TerminalNode CHORUS() { return getToken(MusicParser.CHORUS, 0); }
		public TerminalNode PHRASER() { return getToken(MusicParser.PHRASER, 0); }
		public SettingsValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_settingsValues; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterSettingsValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitSettingsValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitSettingsValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SettingsValuesContext settingsValues() throws RecognitionException {
		SettingsValuesContext _localctx = new SettingsValuesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_settingsValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8795958804480L) != 0)) ) {
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 26, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(ID);
			setState(222);
			match(T__5);
			setState(223);
			expr(0);
			setState(224);
			match(SEMICOLON);
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
	public static class SelfAssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public AssOpContext assOp() {
			return getRuleContext(AssOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
		public SelfAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selfAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterSelfAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitSelfAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitSelfAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfAssignmentContext selfAssignment() throws RecognitionException {
		SelfAssignmentContext _localctx = new SelfAssignmentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_selfAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(ID);
			setState(227);
			assOp();
			setState(228);
			expr(0);
			setState(229);
			match(SEMICOLON);
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
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	 
		public VarDeclContext() { }
		public void copyFrom(VarDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclWithARgContext extends VarDeclContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
		public VarDeclWithARgContext(VarDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterVarDeclWithARg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitVarDeclWithARg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitVarDeclWithARg(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclWithoutArgContext extends VarDeclContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
		public VarDeclWithoutArgContext(VarDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterVarDeclWithoutArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitVarDeclWithoutArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitVarDeclWithoutArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varDecl);
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new VarDeclWithARgContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				type();
				setState(232);
				match(ID);
				setState(233);
				match(T__5);
				setState(234);
				expr(0);
				setState(235);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new VarDeclWithoutArgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				type();
				setState(238);
				match(ID);
				setState(239);
				match(SEMICOLON);
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
		public TerminalNode PLAY() { return getToken(MusicParser.PLAY, 0); }
		public PlayValuesContext playValues() {
			return getRuleContext(PlayValuesContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
		public PlayStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPlayStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPlayStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitPlayStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlayStatementContext playStatement() throws RecognitionException {
		PlayStatementContext _localctx = new PlayStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_playStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(PLAY);
			setState(244);
			playValues();
			setState(245);
			match(SEMICOLON);
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
	public static class PlayValuesContext extends ParserRuleContext {
		public PlayValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playValues; }
	 
		public PlayValuesContext() { }
		public void copyFrom(PlayValuesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlayIDVariantsContext extends PlayValuesContext {
		public List<TerminalNode> ID() { return getTokens(MusicParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MusicParser.ID, i);
		}
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public PlayIDVariantsContext(PlayValuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPlayIDVariants(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPlayIDVariants(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitPlayIDVariants(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlayFuncContext extends PlayValuesContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public PlayFuncContext(PlayValuesContext ctx) { copyFrom(ctx); }
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
	public static class PlayNoteContext extends PlayValuesContext {
		public TerminalNode NOTE_VAL() { return getToken(MusicParser.NOTE_VAL, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public PlayNoteContext(PlayValuesContext ctx) { copyFrom(ctx); }
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
	public static class PlayChordContext extends PlayValuesContext {
		public ChordContext chord() {
			return getRuleContext(ChordContext.class,0);
		}
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public PlayChordContext(PlayValuesContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class PlayMultiContext extends PlayValuesContext {
		public List<MultiPlayValuesContext> multiPlayValues() {
			return getRuleContexts(MultiPlayValuesContext.class);
		}
		public MultiPlayValuesContext multiPlayValues(int i) {
			return getRuleContext(MultiPlayValuesContext.class,i);
		}
		public PlayMultiContext(PlayValuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPlayMulti(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPlayMulti(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitPlayMulti(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlayValuesContext playValues() throws RecognitionException {
		PlayValuesContext _localctx = new PlayValuesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_playValues);
		int _la;
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new PlayNoteContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				match(NOTE_VAL);
				setState(248);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				_localctx = new PlayChordContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				chord();
				setState(250);
				_la = _input.LA(1);
				if ( !(_la==INT_VAL || _la==ID) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				_localctx = new PlayFuncContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(252);
				functionCall();
				}
				break;
			case 4:
				_localctx = new PlayIDVariantsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(253);
				match(ID);
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INT_VAL || _la==ID) {
					{
					setState(254);
					_la = _input.LA(1);
					if ( !(_la==INT_VAL || _la==ID) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			case 5:
				_localctx = new PlayMultiContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(258); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(257);
					multiPlayValues();
					}
					}
					setState(260); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & 72057594037929985L) != 0) );
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
	public static class MultiPlayValuesContext extends ParserRuleContext {
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public List<TerminalNode> ID() { return getTokens(MusicParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MusicParser.ID, i);
		}
		public List<TerminalNode> NOTE_VAL() { return getTokens(MusicParser.NOTE_VAL); }
		public TerminalNode NOTE_VAL(int i) {
			return getToken(MusicParser.NOTE_VAL, i);
		}
		public List<ChordContext> chord() {
			return getRuleContexts(ChordContext.class);
		}
		public ChordContext chord(int i) {
			return getRuleContext(ChordContext.class,i);
		}
		public MultiPlayValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiPlayValues; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterMultiPlayValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitMultiPlayValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitMultiPlayValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiPlayValuesContext multiPlayValues() throws RecognitionException {
		MultiPlayValuesContext _localctx = new MultiPlayValuesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_multiPlayValues);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(267); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(267);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NOTE_VAL:
						{
						setState(264);
						match(NOTE_VAL);
						}
						break;
					case T__12:
						{
						setState(265);
						chord();
						}
						break;
					case ID:
						{
						setState(266);
						match(ID);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(269); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(271);
			_la = _input.LA(1);
			if ( !(_la==INT_VAL || _la==ID) ) {
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
	public static class PauseStatementContext extends ParserRuleContext {
		public TerminalNode PAUSE() { return getToken(MusicParser.PAUSE, 0); }
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
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
		enterRule(_localctx, 38, RULE_pauseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(PAUSE);
			setState(274);
			_la = _input.LA(1);
			if ( !(_la==INT_VAL || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(275);
			match(SEMICOLON);
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
		public ControlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlStatement; }
	 
		public ControlStatementContext() { }
		public void copyFrom(ControlStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileLoopContext extends ControlStatementContext {
		public TerminalNode LP() { return getToken(MusicParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(MusicParser.RP, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<LoopStatementContext> loopStatement() {
			return getRuleContexts(LoopStatementContext.class);
		}
		public LoopStatementContext loopStatement(int i) {
			return getRuleContext(LoopStatementContext.class,i);
		}
		public WhileLoopContext(ControlStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends ControlStatementContext {
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
		public List<LoopStatementContext> loopStatement() {
			return getRuleContexts(LoopStatementContext.class);
		}
		public LoopStatementContext loopStatement(int i) {
			return getRuleContext(LoopStatementContext.class,i);
		}
		public IfContext(ControlStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopContext extends ControlStatementContext {
		public TerminalNode LP() { return getToken(MusicParser.LP, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(MusicParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MusicParser.SEMICOLON, i);
		}
		public TerminalNode RP() { return getToken(MusicParser.RP, 0); }
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<LoopStatementContext> loopStatement() {
			return getRuleContexts(LoopStatementContext.class);
		}
		public LoopStatementContext loopStatement(int i) {
			return getRuleContext(LoopStatementContext.class,i);
		}
		public ForLoopContext(ControlStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlStatementContext controlStatement() throws RecognitionException {
		ControlStatementContext _localctx = new ControlStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_controlStatement);
		int _la;
		try {
			int _alt;
			setState(356);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				match(T__6);
				setState(278);
				match(LP);
				setState(279);
				expr(0);
				setState(280);
				match(RP);
				setState(281);
				match(T__1);
				setState(284); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(284);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__0:
					case T__6:
					case T__7:
					case T__9:
					case INT:
					case BOOL:
					case CHORD:
					case NOTE:
					case SET:
					case PLAY:
					case PAUSE:
					case ID:
						{
						setState(282);
						statement();
						}
						break;
					case T__10:
					case T__11:
						{
						setState(283);
						loopStatement();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(286); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 123145304284546L) != 0) || _la==ID );
				setState(288);
				match(T__2);
				}
				break;
			case T__7:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				match(T__7);
				setState(291);
				match(LP);
				setState(292);
				expr(0);
				setState(293);
				match(RP);
				setState(294);
				match(T__1);
				setState(297); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(297);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__0:
					case T__6:
					case T__7:
					case T__9:
					case INT:
					case BOOL:
					case CHORD:
					case NOTE:
					case SET:
					case PLAY:
					case PAUSE:
					case ID:
						{
						setState(295);
						statement();
						}
						break;
					case T__10:
					case T__11:
						{
						setState(296);
						loopStatement();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(299); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 123145304284546L) != 0) || _la==ID );
				setState(301);
				match(T__2);
				setState(318);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(302);
						match(T__8);
						setState(303);
						match(T__7);
						setState(304);
						match(LP);
						setState(305);
						expr(0);
						setState(306);
						match(RP);
						setState(307);
						match(T__1);
						setState(310); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							setState(310);
							_errHandler.sync(this);
							switch (_input.LA(1)) {
							case T__0:
							case T__6:
							case T__7:
							case T__9:
							case INT:
							case BOOL:
							case CHORD:
							case NOTE:
							case SET:
							case PLAY:
							case PAUSE:
							case ID:
								{
								setState(308);
								statement();
								}
								break;
							case T__10:
							case T__11:
								{
								setState(309);
								loopStatement();
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							}
							setState(312); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 123145304284546L) != 0) || _la==ID );
						setState(314);
						match(T__2);
						}
						} 
					}
					setState(320);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				}
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(321);
					match(T__8);
					setState(322);
					match(T__1);
					setState(325); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(325);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__0:
						case T__6:
						case T__7:
						case T__9:
						case INT:
						case BOOL:
						case CHORD:
						case NOTE:
						case SET:
						case PLAY:
						case PAUSE:
						case ID:
							{
							setState(323);
							statement();
							}
							break;
						case T__10:
						case T__11:
							{
							setState(324);
							loopStatement();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(327); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 123145304284546L) != 0) || _la==ID );
					setState(329);
					match(T__2);
					}
				}

				}
				break;
			case T__9:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(333);
				match(T__9);
				setState(334);
				match(LP);
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & 4503599627370511L) != 0)) {
					{
					setState(335);
					forInit();
					}
				}

				setState(338);
				match(SEMICOLON);
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & 81628019197726209L) != 0)) {
					{
					setState(339);
					expr(0);
					}
				}

				setState(342);
				match(SEMICOLON);
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(343);
					forUpdate();
					}
				}

				setState(346);
				match(RP);
				setState(347);
				match(T__1);
				setState(350); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(350);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__0:
					case T__6:
					case T__7:
					case T__9:
					case INT:
					case BOOL:
					case CHORD:
					case NOTE:
					case SET:
					case PLAY:
					case PAUSE:
					case ID:
						{
						setState(348);
						statement();
						}
						break;
					case T__10:
					case T__11:
						{
						setState(349);
						loopStatement();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(352); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 123145304284546L) != 0) || _la==ID );
				setState(354);
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
		enterRule(_localctx, 42, RULE_forInit);
		try {
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(359);
				type();
				setState(360);
				match(ID);
				setState(361);
				match(T__5);
				setState(362);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(364);
				match(ID);
				setState(365);
				match(T__5);
				setState(366);
				expr(0);
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
	public static class ForUpdateContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ForAssignmentContext forAssignment() {
			return getRuleContext(ForAssignmentContext.class,0);
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
		enterRule(_localctx, 44, RULE_forUpdate);
		try {
			setState(371);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				functionCall();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(370);
				forAssignment();
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
	public static class ForAssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssOpContext assOp() {
			return getRuleContext(AssOpContext.class,0);
		}
		public ForAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterForAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitForAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitForAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForAssignmentContext forAssignment() throws RecognitionException {
		ForAssignmentContext _localctx = new ForAssignmentContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_forAssignment);
		try {
			setState(380);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				match(ID);
				setState(374);
				match(T__5);
				setState(375);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				match(ID);
				setState(377);
				assOp();
				setState(378);
				expr(0);
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
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 48, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(T__10);
			setState(383);
			match(SEMICOLON);
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
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 50, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(T__11);
			setState(386);
			match(SEMICOLON);
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
		enterRule(_localctx, 52, RULE_functionCall);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			match(ID);
			setState(389);
			match(LP);
			setState(393);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(390);
					arguments();
					}
					} 
				}
				setState(395);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(396);
				match(T__4);
				}
			}

			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8795958804480L) != 0)) {
				{
				setState(399);
				settingsList();
				}
			}

			setState(402);
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
		enterRule(_localctx, 54, RULE_arguments);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			expr(0);
			setState(409);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(405);
					match(T__4);
					setState(406);
					expr(0);
					}
					} 
				}
				setState(411);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
		enterRule(_localctx, 56, RULE_settingsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			settingsAssigment();
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(413);
				match(T__4);
				setState(414);
				settingsAssigment();
				}
				}
				setState(419);
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
	public static class IntExprContext extends ExprContext {
		public IntValContext intVal() {
			return getRuleContext(IntValContext.class,0);
		}
		public IntExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitIntExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqOperatorExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqOpContext eqOp() {
			return getRuleContext(EqOpContext.class,0);
		}
		public EqOperatorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterEqOperatorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitEqOperatorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitEqOperatorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SettingsExprContext extends ExprContext {
		public SettingsValuesContext settingsValues() {
			return getRuleContext(SettingsValuesContext.class,0);
		}
		public SettingsExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterSettingsExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitSettingsExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitSettingsExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParanthesesExprContext extends ExprContext {
		public TerminalNode LP() { return getToken(MusicParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(MusicParser.RP, 0); }
		public ParanthesesExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterParanthesesExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitParanthesesExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitParanthesesExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoteExprContext extends ExprContext {
		public TerminalNode NOTE_VAL() { return getToken(MusicParser.NOTE_VAL, 0); }
		public NoteExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterNoteExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitNoteExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitNoteExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrOperatorExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrOpContext orOp() {
			return getRuleContext(OrOpContext.class,0);
		}
		public OrOperatorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterOrOperatorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitOrOperatorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitOrOperatorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(MusicParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrderOperatorExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrderOpContext orderOp() {
			return getRuleContext(OrderOpContext.class,0);
		}
		public OrderOperatorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterOrderOperatorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitOrderOperatorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitOrderOperatorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstrumentOperatorExprContext extends ExprContext {
		public TerminalNode INSTRUMENT() { return getToken(MusicParser.INSTRUMENT, 0); }
		public EqOpContext eqOp() {
			return getRuleContext(EqOpContext.class,0);
		}
		public TerminalNode INSTRUMENT_VALUE() { return getToken(MusicParser.INSTRUMENT_VALUE, 0); }
		public InstrumentOperatorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterInstrumentOperatorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitInstrumentOperatorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitInstrumentOperatorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubOperatorExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubOpContext addSubOp() {
			return getRuleContext(AddSubOpContext.class,0);
		}
		public AddSubOperatorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterAddSubOperatorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitAddSubOperatorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitAddSubOperatorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndOperatorExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AndOpContext andOp() {
			return getRuleContext(AndOpContext.class,0);
		}
		public AndOperatorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterAndOperatorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitAndOperatorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitAndOperatorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MullDivOperatorExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MullDivOpContext mullDivOp() {
			return getRuleContext(MullDivOpContext.class,0);
		}
		public MullDivOperatorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterMullDivOperatorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitMullDivOperatorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitMullDivOperatorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolExprContext extends ExprContext {
		public TerminalNode BOOL_VAL() { return getToken(MusicParser.BOOL_VAL, 0); }
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitBoolExpr(this);
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
	public static class IdExprContext extends ExprContext {
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitIdExpr(this);
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				_localctx = new ParanthesesExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(421);
				match(LP);
				setState(422);
				expr(0);
				setState(423);
				match(RP);
				}
				break;
			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(425);
				match(NOT);
				setState(426);
				expr(14);
				}
				break;
			case 3:
				{
				_localctx = new InstrumentOperatorExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(427);
				match(INSTRUMENT);
				setState(428);
				eqOp();
				setState(429);
				match(INSTRUMENT_VALUE);
				}
				break;
			case 4:
				{
				_localctx = new ChordExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(431);
				chord();
				}
				break;
			case 5:
				{
				_localctx = new SettingsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(432);
				settingsValues();
				}
				break;
			case 6:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(433);
				intVal();
				}
				break;
			case 7:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(434);
				match(BOOL_VAL);
				}
				break;
			case 8:
				{
				_localctx = new NoteExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(435);
				match(NOTE_VAL);
				}
				break;
			case 9:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(436);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(465);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(463);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
					case 1:
						{
						_localctx = new MullDivOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(439);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(440);
						mullDivOp();
						setState(441);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new AddSubOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(443);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(444);
						addSubOp();
						setState(445);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new OrderOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(447);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(448);
						orderOp();
						setState(449);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new EqOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(451);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(452);
						eqOp();
						setState(453);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new AndOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(455);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(456);
						andOp();
						setState(457);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new OrOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(459);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(460);
						orOp();
						setState(461);
						expr(9);
						}
						break;
					}
					} 
				}
				setState(467);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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
	public static class OrderOpContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(MusicParser.LT, 0); }
		public TerminalNode GEQ() { return getToken(MusicParser.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(MusicParser.LEQ, 0); }
		public TerminalNode GT() { return getToken(MusicParser.GT, 0); }
		public OrderOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterOrderOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitOrderOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitOrderOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderOpContext orderOp() throws RecognitionException {
		OrderOpContext _localctx = new OrderOpContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_orderOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 540431955284459520L) != 0)) ) {
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
	public static class EqOpContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(MusicParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MusicParser.NEQ, 0); }
		public EqOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterEqOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitEqOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitEqOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqOpContext eqOp() throws RecognitionException {
		EqOpContext _localctx = new EqOpContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_eqOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==NEQ) ) {
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
	public static class AndOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(MusicParser.AND, 0); }
		public AndOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterAndOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitAndOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitAndOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndOpContext andOp() throws RecognitionException {
		AndOpContext _localctx = new AndOpContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_andOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(AND);
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
	public static class OrOpContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(MusicParser.OR, 0); }
		public OrOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterOrOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitOrOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitOrOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrOpContext orOp() throws RecognitionException {
		OrOpContext _localctx = new OrOpContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_orOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			match(OR);
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
	public static class AddSubOpContext extends ParserRuleContext {
		public TerminalNode SUB() { return getToken(MusicParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(MusicParser.ADD, 0); }
		public AddSubOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addSubOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterAddSubOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitAddSubOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitAddSubOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddSubOpContext addSubOp() throws RecognitionException {
		AddSubOpContext _localctx = new AddSubOpContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_addSubOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
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
	public static class MullDivOpContext extends ParserRuleContext {
		public TerminalNode DIV() { return getToken(MusicParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(MusicParser.MUL, 0); }
		public TerminalNode PER() { return getToken(MusicParser.PER, 0); }
		public MullDivOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mullDivOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterMullDivOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitMullDivOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitMullDivOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MullDivOpContext mullDivOp() throws RecognitionException {
		MullDivOpContext _localctx = new MullDivOpContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_mullDivOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -7493989779944505344L) != 0)) ) {
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
	public static class AssOpContext extends ParserRuleContext {
		public TerminalNode SUMIS() { return getToken(MusicParser.SUMIS, 0); }
		public TerminalNode SUBIS() { return getToken(MusicParser.SUBIS, 0); }
		public TerminalNode MULIS() { return getToken(MusicParser.MULIS, 0); }
		public TerminalNode DIVIS() { return getToken(MusicParser.DIVIS, 0); }
		public AssOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterAssOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitAssOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitAssOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssOpContext assOp() throws RecognitionException {
		AssOpContext _localctx = new AssOpContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_assOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2111062325329920L) != 0)) ) {
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
		enterRule(_localctx, 74, RULE_chord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			match(T__12);
			setState(483);
			match(NOTE_VAL);
			setState(486); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(484);
				match(T__4);
				setState(485);
				match(NOTE_VAL);
				}
				}
				setState(488); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(490);
			match(T__13);
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
	public static class TrackStatementsContext extends ParserRuleContext {
		public TrackStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trackStatements; }
	 
		public TrackStatementsContext() { }
		public void copyFrom(TrackStatementsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrackDeclareContext extends TrackStatementsContext {
		public TrackDeclarationContext trackDeclaration() {
			return getRuleContext(TrackDeclarationContext.class,0);
		}
		public TrackDeclareContext(TrackStatementsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterTrackDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitTrackDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitTrackDeclare(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrackAddContext extends TrackStatementsContext {
		public TrackStatementContext trackStatement() {
			return getRuleContext(TrackStatementContext.class,0);
		}
		public TrackAddContext(TrackStatementsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterTrackAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitTrackAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitTrackAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrackStatementsContext trackStatements() throws RecognitionException {
		TrackStatementsContext _localctx = new TrackStatementsContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_trackStatements);
		try {
			setState(494);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new TrackAddContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(492);
				trackStatement();
				}
				break;
			case TRACK:
				_localctx = new TrackDeclareContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(493);
				trackDeclaration();
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
	public static class TrackStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 78, RULE_trackStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			match(ID);
			setState(497);
			match(T__14);
			setState(498);
			functionCall();
			setState(499);
			match(SEMICOLON);
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
	public static class TrackDeclarationContext extends ParserRuleContext {
		public TerminalNode TRACK() { return getToken(MusicParser.TRACK, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
		public TrackDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trackDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterTrackDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitTrackDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitTrackDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrackDeclarationContext trackDeclaration() throws RecognitionException {
		TrackDeclarationContext _localctx = new TrackDeclarationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_trackDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(TRACK);
			setState(502);
			match(ID);
			setState(503);
			match(SEMICOLON);
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
	public static class IntValContext extends ParserRuleContext {
		public TerminalNode INT_VAL() { return getToken(MusicParser.INT_VAL, 0); }
		public TerminalNode SUB() { return getToken(MusicParser.SUB, 0); }
		public IntValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterIntVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitIntVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitIntVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntValContext intVal() throws RecognitionException {
		IntValContext _localctx = new IntValContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_intVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SUB) {
				{
				setState(505);
				match(SUB);
				}
			}

			setState(508);
			match(INT_VAL);
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
		case 29:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001G\u01ff\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0001\u0000\u0005\u0000V\b\u0000\n\u0000\f\u0000"+
		"Y\t\u0000\u0001\u0000\u0005\u0000\\\b\u0000\n\u0000\f\u0000_\t\u0000\u0001"+
		"\u0000\u0003\u0000b\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002n\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002s\b\u0002\n\u0002\f\u0002v\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003\u0080\b\u0003\n\u0003\f\u0003\u0083\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u008a\b\u0004\n\u0004"+
		"\f\u0004\u008d\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u0096\b\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a0"+
		"\b\b\u0001\t\u0001\t\u0003\t\u00a4\b\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00da\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00f2\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0100\b\u0011\u0001\u0011\u0004\u0011\u0103\b\u0011\u000b"+
		"\u0011\f\u0011\u0104\u0003\u0011\u0107\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0004\u0012\u010c\b\u0012\u000b\u0012\f\u0012\u010d\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0004\u0014\u011d\b\u0014\u000b\u0014\f\u0014\u011e\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0004\u0014\u012a\b\u0014\u000b\u0014\f\u0014"+
		"\u012b\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0004\u0014\u0137\b\u0014\u000b"+
		"\u0014\f\u0014\u0138\u0001\u0014\u0001\u0014\u0005\u0014\u013d\b\u0014"+
		"\n\u0014\f\u0014\u0140\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0004\u0014\u0146\b\u0014\u000b\u0014\f\u0014\u0147\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u014c\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0151\b\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0155\b"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0159\b\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0004\u0014\u015f\b\u0014\u000b\u0014\f"+
		"\u0014\u0160\u0001\u0014\u0001\u0014\u0003\u0014\u0165\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u0170\b\u0015\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u0174\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u017d\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0005\u001a\u0188\b\u001a\n\u001a\f\u001a\u018b"+
		"\t\u001a\u0001\u001a\u0003\u001a\u018e\b\u001a\u0001\u001a\u0003\u001a"+
		"\u0191\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0005\u001b\u0198\b\u001b\n\u001b\f\u001b\u019b\t\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0005\u001c\u01a0\b\u001c\n\u001c\f\u001c\u01a3\t\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d"+
		"\u01b6\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0005\u001d\u01d0\b\u001d\n\u001d\f\u001d\u01d3\t\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001%\u0001"+
		"%\u0004%\u01e7\b%\u000b%\f%\u01e8\u0001%\u0001%\u0001&\u0001&\u0003&\u01ef"+
		"\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001"+
		"(\u0001)\u0003)\u01fb\b)\u0001)\u0001)\u0001)\u0000\u0001:*\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPR\u0000\n\u0001\u0000\u0011\u0014\u0002\u0000"+
		"\u0017\u0017EE\u0002\u0000++EE\u0002\u0000\u0016\u0016EE\u0001\u0000\u001b"+
		"*\u0001\u00007:\u0001\u000056\u0001\u0000=>\u0002\u0000;<??\u0001\u0000"+
		"/2\u0228\u0000W\u0001\u0000\u0000\u0000\u0002e\u0001\u0000\u0000\u0000"+
		"\u0004i\u0001\u0000\u0000\u0000\u0006y\u0001\u0000\u0000\u0000\b\u0086"+
		"\u0001\u0000\u0000\u0000\n\u008e\u0001\u0000\u0000\u0000\f\u0091\u0001"+
		"\u0000\u0000\u0000\u000e\u0095\u0001\u0000\u0000\u0000\u0010\u009f\u0001"+
		"\u0000\u0000\u0000\u0012\u00a3\u0001\u0000\u0000\u0000\u0014\u00a5\u0001"+
		"\u0000\u0000\u0000\u0016\u00d9\u0001\u0000\u0000\u0000\u0018\u00db\u0001"+
		"\u0000\u0000\u0000\u001a\u00dd\u0001\u0000\u0000\u0000\u001c\u00e2\u0001"+
		"\u0000\u0000\u0000\u001e\u00f1\u0001\u0000\u0000\u0000 \u00f3\u0001\u0000"+
		"\u0000\u0000\"\u0106\u0001\u0000\u0000\u0000$\u010b\u0001\u0000\u0000"+
		"\u0000&\u0111\u0001\u0000\u0000\u0000(\u0164\u0001\u0000\u0000\u0000*"+
		"\u016f\u0001\u0000\u0000\u0000,\u0173\u0001\u0000\u0000\u0000.\u017c\u0001"+
		"\u0000\u0000\u00000\u017e\u0001\u0000\u0000\u00002\u0181\u0001\u0000\u0000"+
		"\u00004\u0184\u0001\u0000\u0000\u00006\u0194\u0001\u0000\u0000\u00008"+
		"\u019c\u0001\u0000\u0000\u0000:\u01b5\u0001\u0000\u0000\u0000<\u01d4\u0001"+
		"\u0000\u0000\u0000>\u01d6\u0001\u0000\u0000\u0000@\u01d8\u0001\u0000\u0000"+
		"\u0000B\u01da\u0001\u0000\u0000\u0000D\u01dc\u0001\u0000\u0000\u0000F"+
		"\u01de\u0001\u0000\u0000\u0000H\u01e0\u0001\u0000\u0000\u0000J\u01e2\u0001"+
		"\u0000\u0000\u0000L\u01ee\u0001\u0000\u0000\u0000N\u01f0\u0001\u0000\u0000"+
		"\u0000P\u01f5\u0001\u0000\u0000\u0000R\u01fa\u0001\u0000\u0000\u0000T"+
		"V\u0003\u0002\u0001\u0000UT\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000"+
		"\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X]\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000Z\\\u0003\u0004\u0002\u0000[Z\u0001"+
		"\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000"+
		"]^\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"+
		"\u0000`b\u0003\u0006\u0003\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000"+
		"\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0005\u0000\u0000\u0001d\u0001"+
		"\u0001\u0000\u0000\u0000ef\u0005\u0010\u0000\u0000fg\u0005\u0019\u0000"+
		"\u0000gh\u0005G\u0000\u0000h\u0003\u0001\u0000\u0000\u0000ij\u0005\u0001"+
		"\u0000\u0000jk\u0005E\u0000\u0000km\u00053\u0000\u0000ln\u0003\b\u0004"+
		"\u0000ml\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0001\u0000"+
		"\u0000\u0000op\u00054\u0000\u0000pt\u0005\u0002\u0000\u0000qs\u0003\u0010"+
		"\b\u0000rq\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000"+
		"\u0000\u0000tu\u0001\u0000\u0000\u0000uw\u0001\u0000\u0000\u0000vt\u0001"+
		"\u0000\u0000\u0000wx\u0005\u0003\u0000\u0000x\u0005\u0001\u0000\u0000"+
		"\u0000yz\u0005\u0001\u0000\u0000z{\u0005\u0004\u0000\u0000{|\u00053\u0000"+
		"\u0000|}\u00054\u0000\u0000}\u0081\u0005\u0002\u0000\u0000~\u0080\u0003"+
		"\u000e\u0007\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0083\u0001\u0000"+
		"\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000"+
		"\u0000\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0005\u0003\u0000\u0000\u0085\u0007\u0001\u0000"+
		"\u0000\u0000\u0086\u008b\u0003\n\u0005\u0000\u0087\u0088\u0005\u0005\u0000"+
		"\u0000\u0088\u008a\u0003\n\u0005\u0000\u0089\u0087\u0001\u0000\u0000\u0000"+
		"\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\t\u0001\u0000\u0000\u0000\u008d"+
		"\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0003\f\u0006\u0000\u008f\u0090"+
		"\u0005E\u0000\u0000\u0090\u000b\u0001\u0000\u0000\u0000\u0091\u0092\u0007"+
		"\u0000\u0000\u0000\u0092\r\u0001\u0000\u0000\u0000\u0093\u0096\u0003\u0010"+
		"\b\u0000\u0094\u0096\u0003L&\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u000f\u0001\u0000\u0000\u0000"+
		"\u0097\u00a0\u0003\u0004\u0002\u0000\u0098\u00a0\u0003\u001a\r\u0000\u0099"+
		"\u00a0\u0003\u001c\u000e\u0000\u009a\u00a0\u0003\u0014\n\u0000\u009b\u00a0"+
		"\u0003\u001e\u000f\u0000\u009c\u00a0\u0003 \u0010\u0000\u009d\u00a0\u0003"+
		"&\u0013\u0000\u009e\u00a0\u0003(\u0014\u0000\u009f\u0097\u0001\u0000\u0000"+
		"\u0000\u009f\u0098\u0001\u0000\u0000\u0000\u009f\u0099\u0001\u0000\u0000"+
		"\u0000\u009f\u009a\u0001\u0000\u0000\u0000\u009f\u009b\u0001\u0000\u0000"+
		"\u0000\u009f\u009c\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000"+
		"\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u0011\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a4\u00030\u0018\u0000\u00a2\u00a4\u00032\u0019\u0000\u00a3"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4"+
		"\u0013\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005,\u0000\u0000\u00a6\u00a7"+
		"\u0003\u0016\u000b\u0000\u00a7\u00a8\u0005G\u0000\u0000\u00a8\u0015\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0005\u001b\u0000\u0000\u00aa\u00ab\u0005"+
		"\u0006\u0000\u0000\u00ab\u00da\u0007\u0001\u0000\u0000\u00ac\u00ad\u0005"+
		"!\u0000\u0000\u00ad\u00ae\u0005\u0006\u0000\u0000\u00ae\u00da\u0007\u0001"+
		"\u0000\u0000\u00af\u00b0\u0005 \u0000\u0000\u00b0\u00b1\u0005\u0006\u0000"+
		"\u0000\u00b1\u00da\u0007\u0002\u0000\u0000\u00b2\u00b3\u0005\u001c\u0000"+
		"\u0000\u00b3\u00b4\u0005\u0006\u0000\u0000\u00b4\u00da\u0007\u0001\u0000"+
		"\u0000\u00b5\u00b6\u0005\u001e\u0000\u0000\u00b6\u00b7\u0005\u0006\u0000"+
		"\u0000\u00b7\u00da\u0007\u0003\u0000\u0000\u00b8\u00b9\u0005\u001f\u0000"+
		"\u0000\u00b9\u00ba\u0005\u0006\u0000\u0000\u00ba\u00da\u0007\u0003\u0000"+
		"\u0000\u00bb\u00bc\u0005\u001d\u0000\u0000\u00bc\u00bd\u0005\u0006\u0000"+
		"\u0000\u00bd\u00da\u0007\u0001\u0000\u0000\u00be\u00bf\u0005\"\u0000\u0000"+
		"\u00bf\u00c0\u0005\u0006\u0000\u0000\u00c0\u00da\u0007\u0001\u0000\u0000"+
		"\u00c1\u00c2\u0005#\u0000\u0000\u00c2\u00c3\u0005\u0006\u0000\u0000\u00c3"+
		"\u00da\u0007\u0001\u0000\u0000\u00c4\u00c5\u0005$\u0000\u0000\u00c5\u00c6"+
		"\u0005\u0006\u0000\u0000\u00c6\u00da\u0007\u0001\u0000\u0000\u00c7\u00c8"+
		"\u0005%\u0000\u0000\u00c8\u00c9\u0005\u0006\u0000\u0000\u00c9\u00da\u0007"+
		"\u0001\u0000\u0000\u00ca\u00cb\u0005&\u0000\u0000\u00cb\u00cc\u0005\u0006"+
		"\u0000\u0000\u00cc\u00da\u0007\u0001\u0000\u0000\u00cd\u00ce\u0005\'\u0000"+
		"\u0000\u00ce\u00cf\u0005\u0006\u0000\u0000\u00cf\u00da\u0007\u0001\u0000"+
		"\u0000\u00d0\u00d1\u0005(\u0000\u0000\u00d1\u00d2\u0005\u0006\u0000\u0000"+
		"\u00d2\u00da\u0007\u0001\u0000\u0000\u00d3\u00d4\u0005)\u0000\u0000\u00d4"+
		"\u00d5\u0005\u0006\u0000\u0000\u00d5\u00da\u0007\u0001\u0000\u0000\u00d6"+
		"\u00d7\u0005*\u0000\u0000\u00d7\u00d8\u0005\u0006\u0000\u0000\u00d8\u00da"+
		"\u0007\u0001\u0000\u0000\u00d9\u00a9\u0001\u0000\u0000\u0000\u00d9\u00ac"+
		"\u0001\u0000\u0000\u0000\u00d9\u00af\u0001\u0000\u0000\u0000\u00d9\u00b2"+
		"\u0001\u0000\u0000\u0000\u00d9\u00b5\u0001\u0000\u0000\u0000\u00d9\u00b8"+
		"\u0001\u0000\u0000\u0000\u00d9\u00bb\u0001\u0000\u0000\u0000\u00d9\u00be"+
		"\u0001\u0000\u0000\u0000\u00d9\u00c1\u0001\u0000\u0000\u0000\u00d9\u00c4"+
		"\u0001\u0000\u0000\u0000\u00d9\u00c7\u0001\u0000\u0000\u0000\u00d9\u00ca"+
		"\u0001\u0000\u0000\u0000\u00d9\u00cd\u0001\u0000\u0000\u0000\u00d9\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d9\u00d3\u0001\u0000\u0000\u0000\u00d9\u00d6"+
		"\u0001\u0000\u0000\u0000\u00da\u0017\u0001\u0000\u0000\u0000\u00db\u00dc"+
		"\u0007\u0004\u0000\u0000\u00dc\u0019\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0005E\u0000\u0000\u00de\u00df\u0005\u0006\u0000\u0000\u00df\u00e0\u0003"+
		":\u001d\u0000\u00e0\u00e1\u0005G\u0000\u0000\u00e1\u001b\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e3\u0005E\u0000\u0000\u00e3\u00e4\u0003H$\u0000\u00e4"+
		"\u00e5\u0003:\u001d\u0000\u00e5\u00e6\u0005G\u0000\u0000\u00e6\u001d\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e8\u0003\f\u0006\u0000\u00e8\u00e9\u0005E"+
		"\u0000\u0000\u00e9\u00ea\u0005\u0006\u0000\u0000\u00ea\u00eb\u0003:\u001d"+
		"\u0000\u00eb\u00ec\u0005G\u0000\u0000\u00ec\u00f2\u0001\u0000\u0000\u0000"+
		"\u00ed\u00ee\u0003\f\u0006\u0000\u00ee\u00ef\u0005E\u0000\u0000\u00ef"+
		"\u00f0\u0005G\u0000\u0000\u00f0\u00f2\u0001\u0000\u0000\u0000\u00f1\u00e7"+
		"\u0001\u0000\u0000\u0000\u00f1\u00ed\u0001\u0000\u0000\u0000\u00f2\u001f"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005-\u0000\u0000\u00f4\u00f5\u0003"+
		"\"\u0011\u0000\u00f5\u00f6\u0005G\u0000\u0000\u00f6!\u0001\u0000\u0000"+
		"\u0000\u00f7\u00f8\u0005\u0018\u0000\u0000\u00f8\u0107\u0007\u0001\u0000"+
		"\u0000\u00f9\u00fa\u0003J%\u0000\u00fa\u00fb\u0007\u0001\u0000\u0000\u00fb"+
		"\u0107\u0001\u0000\u0000\u0000\u00fc\u0107\u00034\u001a\u0000\u00fd\u00ff"+
		"\u0005E\u0000\u0000\u00fe\u0100\u0007\u0001\u0000\u0000\u00ff\u00fe\u0001"+
		"\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0107\u0001"+
		"\u0000\u0000\u0000\u0101\u0103\u0003$\u0012\u0000\u0102\u0101\u0001\u0000"+
		"\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000"+
		"\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0107\u0001\u0000"+
		"\u0000\u0000\u0106\u00f7\u0001\u0000\u0000\u0000\u0106\u00f9\u0001\u0000"+
		"\u0000\u0000\u0106\u00fc\u0001\u0000\u0000\u0000\u0106\u00fd\u0001\u0000"+
		"\u0000\u0000\u0106\u0102\u0001\u0000\u0000\u0000\u0107#\u0001\u0000\u0000"+
		"\u0000\u0108\u010c\u0005\u0018\u0000\u0000\u0109\u010c\u0003J%\u0000\u010a"+
		"\u010c\u0005E\u0000\u0000\u010b\u0108\u0001\u0000\u0000\u0000\u010b\u0109"+
		"\u0001\u0000\u0000\u0000\u010b\u010a\u0001\u0000\u0000\u0000\u010c\u010d"+
		"\u0001\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010d\u010e"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0110"+
		"\u0007\u0001\u0000\u0000\u0110%\u0001\u0000\u0000\u0000\u0111\u0112\u0005"+
		".\u0000\u0000\u0112\u0113\u0007\u0001\u0000\u0000\u0113\u0114\u0005G\u0000"+
		"\u0000\u0114\'\u0001\u0000\u0000\u0000\u0115\u0116\u0005\u0007\u0000\u0000"+
		"\u0116\u0117\u00053\u0000\u0000\u0117\u0118\u0003:\u001d\u0000\u0118\u0119"+
		"\u00054\u0000\u0000\u0119\u011c\u0005\u0002\u0000\u0000\u011a\u011d\u0003"+
		"\u0010\b\u0000\u011b\u011d\u0003\u0012\t\u0000\u011c\u011a\u0001\u0000"+
		"\u0000\u0000\u011c\u011b\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000"+
		"\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000"+
		"\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u0121\u0005\u0003"+
		"\u0000\u0000\u0121\u0165\u0001\u0000\u0000\u0000\u0122\u0123\u0005\b\u0000"+
		"\u0000\u0123\u0124\u00053\u0000\u0000\u0124\u0125\u0003:\u001d\u0000\u0125"+
		"\u0126\u00054\u0000\u0000\u0126\u0129\u0005\u0002\u0000\u0000\u0127\u012a"+
		"\u0003\u0010\b\u0000\u0128\u012a\u0003\u0012\t\u0000\u0129\u0127\u0001"+
		"\u0000\u0000\u0000\u0129\u0128\u0001\u0000\u0000\u0000\u012a\u012b\u0001"+
		"\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012c\u0001"+
		"\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u013e\u0005"+
		"\u0003\u0000\u0000\u012e\u012f\u0005\t\u0000\u0000\u012f\u0130\u0005\b"+
		"\u0000\u0000\u0130\u0131\u00053\u0000\u0000\u0131\u0132\u0003:\u001d\u0000"+
		"\u0132\u0133\u00054\u0000\u0000\u0133\u0136\u0005\u0002\u0000\u0000\u0134"+
		"\u0137\u0003\u0010\b\u0000\u0135\u0137\u0003\u0012\t\u0000\u0136\u0134"+
		"\u0001\u0000\u0000\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0137\u0138"+
		"\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139"+
		"\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013b"+
		"\u0005\u0003\u0000\u0000\u013b\u013d\u0001\u0000\u0000\u0000\u013c\u012e"+
		"\u0001\u0000\u0000\u0000\u013d\u0140\u0001\u0000\u0000\u0000\u013e\u013c"+
		"\u0001\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u014b"+
		"\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0141\u0142"+
		"\u0005\t\u0000\u0000\u0142\u0145\u0005\u0002\u0000\u0000\u0143\u0146\u0003"+
		"\u0010\b\u0000\u0144\u0146\u0003\u0012\t\u0000\u0145\u0143\u0001\u0000"+
		"\u0000\u0000\u0145\u0144\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000"+
		"\u0000\u0000\u0147\u0145\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000"+
		"\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014a\u0005\u0003"+
		"\u0000\u0000\u014a\u014c\u0001\u0000\u0000\u0000\u014b\u0141\u0001\u0000"+
		"\u0000\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u0165\u0001\u0000"+
		"\u0000\u0000\u014d\u014e\u0005\n\u0000\u0000\u014e\u0150\u00053\u0000"+
		"\u0000\u014f\u0151\u0003*\u0015\u0000\u0150\u014f\u0001\u0000\u0000\u0000"+
		"\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000"+
		"\u0152\u0154\u0005G\u0000\u0000\u0153\u0155\u0003:\u001d\u0000\u0154\u0153"+
		"\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000\u0000\u0000\u0155\u0156"+
		"\u0001\u0000\u0000\u0000\u0156\u0158\u0005G\u0000\u0000\u0157\u0159\u0003"+
		",\u0016\u0000\u0158\u0157\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000"+
		"\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u015b\u00054\u0000"+
		"\u0000\u015b\u015e\u0005\u0002\u0000\u0000\u015c\u015f\u0003\u0010\b\u0000"+
		"\u015d\u015f\u0003\u0012\t\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015e"+
		"\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160"+
		"\u015e\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000\u0161"+
		"\u0162\u0001\u0000\u0000\u0000\u0162\u0163\u0005\u0003\u0000\u0000\u0163"+
		"\u0165\u0001\u0000\u0000\u0000\u0164\u0115\u0001\u0000\u0000\u0000\u0164"+
		"\u0122\u0001\u0000\u0000\u0000\u0164\u014d\u0001\u0000\u0000\u0000\u0165"+
		")\u0001\u0000\u0000\u0000\u0166\u0170\u0005E\u0000\u0000\u0167\u0168\u0003"+
		"\f\u0006\u0000\u0168\u0169\u0005E\u0000\u0000\u0169\u016a\u0005\u0006"+
		"\u0000\u0000\u016a\u016b\u0003:\u001d\u0000\u016b\u0170\u0001\u0000\u0000"+
		"\u0000\u016c\u016d\u0005E\u0000\u0000\u016d\u016e\u0005\u0006\u0000\u0000"+
		"\u016e\u0170\u0003:\u001d\u0000\u016f\u0166\u0001\u0000\u0000\u0000\u016f"+
		"\u0167\u0001\u0000\u0000\u0000\u016f\u016c\u0001\u0000\u0000\u0000\u0170"+
		"+\u0001\u0000\u0000\u0000\u0171\u0174\u00034\u001a\u0000\u0172\u0174\u0003"+
		".\u0017\u0000\u0173\u0171\u0001\u0000\u0000\u0000\u0173\u0172\u0001\u0000"+
		"\u0000\u0000\u0174-\u0001\u0000\u0000\u0000\u0175\u0176\u0005E\u0000\u0000"+
		"\u0176\u0177\u0005\u0006\u0000\u0000\u0177\u017d\u0003:\u001d\u0000\u0178"+
		"\u0179\u0005E\u0000\u0000\u0179\u017a\u0003H$\u0000\u017a\u017b\u0003"+
		":\u001d\u0000\u017b\u017d\u0001\u0000\u0000\u0000\u017c\u0175\u0001\u0000"+
		"\u0000\u0000\u017c\u0178\u0001\u0000\u0000\u0000\u017d/\u0001\u0000\u0000"+
		"\u0000\u017e\u017f\u0005\u000b\u0000\u0000\u017f\u0180\u0005G\u0000\u0000"+
		"\u01801\u0001\u0000\u0000\u0000\u0181\u0182\u0005\f\u0000\u0000\u0182"+
		"\u0183\u0005G\u0000\u0000\u01833\u0001\u0000\u0000\u0000\u0184\u0185\u0005"+
		"E\u0000\u0000\u0185\u0189\u00053\u0000\u0000\u0186\u0188\u00036\u001b"+
		"\u0000\u0187\u0186\u0001\u0000\u0000\u0000\u0188\u018b\u0001\u0000\u0000"+
		"\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000"+
		"\u0000\u018a\u018d\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000\u0000"+
		"\u0000\u018c\u018e\u0005\u0005\u0000\u0000\u018d\u018c\u0001\u0000\u0000"+
		"\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018e\u0190\u0001\u0000\u0000"+
		"\u0000\u018f\u0191\u00038\u001c\u0000\u0190\u018f\u0001\u0000\u0000\u0000"+
		"\u0190\u0191\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000"+
		"\u0192\u0193\u00054\u0000\u0000\u01935\u0001\u0000\u0000\u0000\u0194\u0199"+
		"\u0003:\u001d\u0000\u0195\u0196\u0005\u0005\u0000\u0000\u0196\u0198\u0003"+
		":\u001d\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0198\u019b\u0001\u0000"+
		"\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u0199\u019a\u0001\u0000"+
		"\u0000\u0000\u019a7\u0001\u0000\u0000\u0000\u019b\u0199\u0001\u0000\u0000"+
		"\u0000\u019c\u01a1\u0003\u0016\u000b\u0000\u019d\u019e\u0005\u0005\u0000"+
		"\u0000\u019e\u01a0\u0003\u0016\u000b\u0000\u019f\u019d\u0001\u0000\u0000"+
		"\u0000\u01a0\u01a3\u0001\u0000\u0000\u0000\u01a1\u019f\u0001\u0000\u0000"+
		"\u0000\u01a1\u01a2\u0001\u0000\u0000\u0000\u01a29\u0001\u0000\u0000\u0000"+
		"\u01a3\u01a1\u0001\u0000\u0000\u0000\u01a4\u01a5\u0006\u001d\uffff\uffff"+
		"\u0000\u01a5\u01a6\u00053\u0000\u0000\u01a6\u01a7\u0003:\u001d\u0000\u01a7"+
		"\u01a8\u00054\u0000\u0000\u01a8\u01b6\u0001\u0000\u0000\u0000\u01a9\u01aa"+
		"\u0005B\u0000\u0000\u01aa\u01b6\u0003:\u001d\u000e\u01ab\u01ac\u0005 "+
		"\u0000\u0000\u01ac\u01ad\u0003>\u001f\u0000\u01ad\u01ae\u0005+\u0000\u0000"+
		"\u01ae\u01b6\u0001\u0000\u0000\u0000\u01af\u01b6\u0003J%\u0000\u01b0\u01b6"+
		"\u0003\u0018\f\u0000\u01b1\u01b6\u0003R)\u0000\u01b2\u01b6\u0005\u0016"+
		"\u0000\u0000\u01b3\u01b6\u0005\u0018\u0000\u0000\u01b4\u01b6\u0005E\u0000"+
		"\u0000\u01b5\u01a4\u0001\u0000\u0000\u0000\u01b5\u01a9\u0001\u0000\u0000"+
		"\u0000\u01b5\u01ab\u0001\u0000\u0000\u0000\u01b5\u01af\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b0\u0001\u0000\u0000\u0000\u01b5\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b2\u0001\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b4\u0001\u0000\u0000\u0000\u01b6\u01d1\u0001\u0000\u0000"+
		"\u0000\u01b7\u01b8\n\r\u0000\u0000\u01b8\u01b9\u0003F#\u0000\u01b9\u01ba"+
		"\u0003:\u001d\u000e\u01ba\u01d0\u0001\u0000\u0000\u0000\u01bb\u01bc\n"+
		"\f\u0000\u0000\u01bc\u01bd\u0003D\"\u0000\u01bd\u01be\u0003:\u001d\r\u01be"+
		"\u01d0\u0001\u0000\u0000\u0000\u01bf\u01c0\n\u000b\u0000\u0000\u01c0\u01c1"+
		"\u0003<\u001e\u0000\u01c1\u01c2\u0003:\u001d\f\u01c2\u01d0\u0001\u0000"+
		"\u0000\u0000\u01c3\u01c4\n\n\u0000\u0000\u01c4\u01c5\u0003>\u001f\u0000"+
		"\u01c5\u01c6\u0003:\u001d\u000b\u01c6\u01d0\u0001\u0000\u0000\u0000\u01c7"+
		"\u01c8\n\t\u0000\u0000\u01c8\u01c9\u0003@ \u0000\u01c9\u01ca\u0003:\u001d"+
		"\n\u01ca\u01d0\u0001\u0000\u0000\u0000\u01cb\u01cc\n\b\u0000\u0000\u01cc"+
		"\u01cd\u0003B!\u0000\u01cd\u01ce\u0003:\u001d\t\u01ce\u01d0\u0001\u0000"+
		"\u0000\u0000\u01cf\u01b7\u0001\u0000\u0000\u0000\u01cf\u01bb\u0001\u0000"+
		"\u0000\u0000\u01cf\u01bf\u0001\u0000\u0000\u0000\u01cf\u01c3\u0001\u0000"+
		"\u0000\u0000\u01cf\u01c7\u0001\u0000\u0000\u0000\u01cf\u01cb\u0001\u0000"+
		"\u0000\u0000\u01d0\u01d3\u0001\u0000\u0000\u0000\u01d1\u01cf\u0001\u0000"+
		"\u0000\u0000\u01d1\u01d2\u0001\u0000\u0000\u0000\u01d2;\u0001\u0000\u0000"+
		"\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000\u01d4\u01d5\u0007\u0005\u0000"+
		"\u0000\u01d5=\u0001\u0000\u0000\u0000\u01d6\u01d7\u0007\u0006\u0000\u0000"+
		"\u01d7?\u0001\u0000\u0000\u0000\u01d8\u01d9\u0005@\u0000\u0000\u01d9A"+
		"\u0001\u0000\u0000\u0000\u01da\u01db\u0005A\u0000\u0000\u01dbC\u0001\u0000"+
		"\u0000\u0000\u01dc\u01dd\u0007\u0007\u0000\u0000\u01ddE\u0001\u0000\u0000"+
		"\u0000\u01de\u01df\u0007\b\u0000\u0000\u01dfG\u0001\u0000\u0000\u0000"+
		"\u01e0\u01e1\u0007\t\u0000\u0000\u01e1I\u0001\u0000\u0000\u0000\u01e2"+
		"\u01e3\u0005\r\u0000\u0000\u01e3\u01e6\u0005\u0018\u0000\u0000\u01e4\u01e5"+
		"\u0005\u0005\u0000\u0000\u01e5\u01e7\u0005\u0018\u0000\u0000\u01e6\u01e4"+
		"\u0001\u0000\u0000\u0000\u01e7\u01e8\u0001\u0000\u0000\u0000\u01e8\u01e6"+
		"\u0001\u0000\u0000\u0000\u01e8\u01e9\u0001\u0000\u0000\u0000\u01e9\u01ea"+
		"\u0001\u0000\u0000\u0000\u01ea\u01eb\u0005\u000e\u0000\u0000\u01ebK\u0001"+
		"\u0000\u0000\u0000\u01ec\u01ef\u0003N\'\u0000\u01ed\u01ef\u0003P(\u0000"+
		"\u01ee\u01ec\u0001\u0000\u0000\u0000\u01ee\u01ed\u0001\u0000\u0000\u0000"+
		"\u01efM\u0001\u0000\u0000\u0000\u01f0\u01f1\u0005E\u0000\u0000\u01f1\u01f2"+
		"\u0005\u000f\u0000\u0000\u01f2\u01f3\u00034\u001a\u0000\u01f3\u01f4\u0005"+
		"G\u0000\u0000\u01f4O\u0001\u0000\u0000\u0000\u01f5\u01f6\u0005\u0015\u0000"+
		"\u0000\u01f6\u01f7\u0005E\u0000\u0000\u01f7\u01f8\u0005G\u0000\u0000\u01f8"+
		"Q\u0001\u0000\u0000\u0000\u01f9\u01fb\u0005>\u0000\u0000\u01fa\u01f9\u0001"+
		"\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000\u01fb\u01fc\u0001"+
		"\u0000\u0000\u0000\u01fc\u01fd\u0005\u0017\u0000\u0000\u01fdS\u0001\u0000"+
		"\u0000\u0000/W]amt\u0081\u008b\u0095\u009f\u00a3\u00d9\u00f1\u00ff\u0104"+
		"\u0106\u010b\u010d\u011c\u011e\u0129\u012b\u0136\u0138\u013e\u0145\u0147"+
		"\u014b\u0150\u0154\u0158\u015e\u0160\u0164\u016f\u0173\u017c\u0189\u018d"+
		"\u0190\u0199\u01a1\u01b5\u01cf\u01d1\u01e8\u01ee\u01fa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}