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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		IMPORT=18, INT=19, BOOL=20, CHORD=21, NOTE=22, TRACK=23, BOOL_VAL=24, 
		INT_VAL=25, NOTE_VAL=26, STRING_VAL=27, ESC=28, PACE=29, DISTORTION=30, 
		VOLUME=31, JAZZ=32, BLUES=33, INSTRUMENT=34, SUSTAIN=35, VIBRATO=36, BALANCE=37, 
		SOSTENUTO=38, SOFT=39, RESONANCE=40, REVERB=41, TREMOLO=42, CHORUS=43, 
		PHRASER=44, INSTRUMENT_VALUE=45, SET=46, PLAY=47, PAUSE=48, SUMIS=49, 
		DIVIS=50, MULIS=51, SUBIS=52, LP=53, RP=54, EQ=55, NEQ=56, GT=57, LT=58, 
		GEQ=59, LEQ=60, DIV=61, MUL=62, ADD=63, SUB=64, PER=65, AND=66, OR=67, 
		NOT=68, LINE_COMMENT=69, BLOCK_COMMENT=70, ID=71, WS=72, SEMICOLON=73;
	public static final int
		RULE_program = 0, RULE_imports = 1, RULE_functionDecl = 2, RULE_mainDecl = 3, 
		RULE_parameters = 4, RULE_parameter = 5, RULE_type = 6, RULE_mainStatement = 7, 
		RULE_statement = 8, RULE_returnStatement = 9, RULE_exprStatement = 10, 
		RULE_settings = 11, RULE_settingsAssigment = 12, RULE_settingsValues = 13, 
		RULE_assignment = 14, RULE_selfAssignment = 15, RULE_varDecl = 16, RULE_playStatement = 17, 
		RULE_playValues = 18, RULE_multiPlayValues = 19, RULE_pauseStatement = 20, 
		RULE_controlStatement = 21, RULE_loop = 22, RULE_loopBody = 23, RULE_if = 24, 
		RULE_elseif = 25, RULE_else = 26, RULE_forUpdate = 27, RULE_forAssignment = 28, 
		RULE_breakStatement = 29, RULE_continueStatement = 30, RULE_functionCall = 31, 
		RULE_arguments = 32, RULE_settingsList = 33, RULE_expr = 34, RULE_orderOp = 35, 
		RULE_eqOp = 36, RULE_andOp = 37, RULE_orOp = 38, RULE_addSubOp = 39, RULE_mullDivOp = 40, 
		RULE_assOp = 41, RULE_chord = 42, RULE_trackStatements = 43, RULE_trackStatement = 44, 
		RULE_trackDeclaration = 45, RULE_intVal = 46;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "imports", "functionDecl", "mainDecl", "parameters", "parameter", 
			"type", "mainStatement", "statement", "returnStatement", "exprStatement", 
			"settings", "settingsAssigment", "settingsValues", "assignment", "selfAssignment", 
			"varDecl", "playStatement", "playValues", "multiPlayValues", "pauseStatement", 
			"controlStatement", "loop", "loopBody", "if", "elseif", "else", "forUpdate", 
			"forAssignment", "breakStatement", "continueStatement", "functionCall", 
			"arguments", "settingsList", "expr", "orderOp", "eqOp", "andOp", "orOp", 
			"addSubOp", "mullDivOp", "assOp", "chord", "trackStatements", "trackStatement", 
			"trackDeclaration", "intVal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'melody'", "'{'", "'}'", "'main'", "','", "'RETURN'", "'='", "'OUT'", 
			"'while'", "'for'", "'if'", "'else'", "'break'", "'continue'", "'['", 
			"']'", "'ADD'", "'import'", "'int'", "'bool'", "'Chord'", "'Note'", "'Track'", 
			null, null, null, null, null, "'PACE'", "'DISTORTION'", "'VOLUME'", "'JAZZ'", 
			"'BLUES'", "'INSTRUMENT'", "'SUSTAIN'", "'VIBRATO'", "'BALANCE'", "'SOSTENUTO'", 
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
			null, null, null, null, null, null, "IMPORT", "INT", "BOOL", "CHORD", 
			"NOTE", "TRACK", "BOOL_VAL", "INT_VAL", "NOTE_VAL", "STRING_VAL", "ESC", 
			"PACE", "DISTORTION", "VOLUME", "JAZZ", "BLUES", "INSTRUMENT", "SUSTAIN", 
			"VIBRATO", "BALANCE", "SOSTENUTO", "SOFT", "RESONANCE", "REVERB", "TREMOLO", 
			"CHORUS", "PHRASER", "INSTRUMENT_VALUE", "SET", "PLAY", "PAUSE", "SUMIS", 
			"DIVIS", "MULIS", "SUBIS", "LP", "RP", "EQ", "NEQ", "GT", "LT", "GEQ", 
			"LEQ", "DIV", "MUL", "ADD", "SUB", "PER", "AND", "OR", "NOT", "LINE_COMMENT", 
			"BLOCK_COMMENT", "ID", "WS", "SEMICOLON"
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
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(94);
				imports();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(100);
					functionDecl();
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(106);
				mainDecl();
				}
			}

			setState(109);
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
			setState(111);
			match(IMPORT);
			setState(112);
			match(STRING_VAL);
			setState(113);
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
			setState(115);
			match(T__0);
			setState(116);
			match(ID);
			setState(117);
			match(LP);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0)) {
				{
				setState(118);
				parameters();
				}
			}

			setState(121);
			match(RP);
			setState(122);
			match(T__1);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9213837072430231998L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 145L) != 0)) {
				{
				{
				setState(123);
				statement();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
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
			setState(131);
			match(T__0);
			setState(132);
			match(T__3);
			setState(133);
			match(LP);
			setState(134);
			match(RP);
			setState(135);
			match(T__1);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9213837072421843390L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 145L) != 0)) {
				{
				{
				setState(136);
				mainStatement();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
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
			setState(144);
			parameter();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(145);
				match(T__4);
				setState(146);
				parameter();
				}
				}
				setState(151);
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
			setState(152);
			type();
			setState(153);
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
			setState(155);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0)) ) {
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
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
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
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
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
		public ExprStatementContext exprStatement() {
			return getRuleContext(ExprStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
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
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				functionDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				assignment();
				setState(163);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				settings();
				setState(166);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				varDecl();
				setState(169);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(171);
				playStatement();
				setState(172);
				match(SEMICOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(174);
				pauseStatement();
				setState(175);
				match(SEMICOLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(177);
				controlStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(178);
				exprStatement();
				setState(179);
				match(SEMICOLON);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(181);
				returnStatement();
				setState(182);
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
	public static class ReturnStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(T__5);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & 81909494174436865L) != 0)) {
				{
				setState(187);
				expr(0);
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
	public static class ExprStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterExprStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitExprStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitExprStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStatementContext exprStatement() throws RecognitionException {
		ExprStatementContext _localctx = new ExprStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exprStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			expr(0);
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
		enterRule(_localctx, 22, RULE_settings);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(SET);
			setState(193);
			settingsAssigment();
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
		enterRule(_localctx, 24, RULE_settingsAssigment);
		int _la;
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PACE:
				_localctx = new PaceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				match(PACE);
				setState(196);
				match(T__6);
				setState(197);
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
				setState(198);
				match(SUSTAIN);
				setState(199);
				match(T__6);
				setState(200);
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
				setState(201);
				match(INSTRUMENT);
				setState(202);
				match(T__6);
				setState(203);
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
				setState(204);
				match(DISTORTION);
				setState(205);
				match(T__6);
				setState(206);
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
				setState(207);
				match(JAZZ);
				setState(208);
				match(T__6);
				setState(209);
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
				setState(210);
				match(BLUES);
				setState(211);
				match(T__6);
				setState(212);
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
				setState(213);
				match(VOLUME);
				setState(214);
				match(T__6);
				setState(215);
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
				setState(216);
				match(VIBRATO);
				setState(217);
				match(T__6);
				setState(218);
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
				setState(219);
				match(BALANCE);
				setState(220);
				match(T__6);
				setState(221);
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
				setState(222);
				match(SOSTENUTO);
				setState(223);
				match(T__6);
				setState(224);
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
				setState(225);
				match(SOFT);
				setState(226);
				match(T__6);
				setState(227);
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
				setState(228);
				match(RESONANCE);
				setState(229);
				match(T__6);
				setState(230);
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
				setState(231);
				match(REVERB);
				setState(232);
				match(T__6);
				setState(233);
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
				setState(234);
				match(TREMOLO);
				setState(235);
				match(T__6);
				setState(236);
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
				setState(237);
				match(CHORUS);
				setState(238);
				match(T__6);
				setState(239);
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
				setState(240);
				match(PHRASER);
				setState(241);
				match(T__6);
				setState(242);
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
		enterRule(_localctx, 26, RULE_settingsValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 35183835217920L) != 0)) ) {
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
		enterRule(_localctx, 28, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(ID);
			setState(248);
			match(T__6);
			setState(249);
			expr(0);
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
		enterRule(_localctx, 30, RULE_selfAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(ID);
			setState(252);
			assOp();
			setState(253);
			expr(0);
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
		enterRule(_localctx, 32, RULE_varDecl);
		try {
			setState(263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new VarDeclWithARgContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				type();
				setState(256);
				match(ID);
				setState(257);
				match(T__6);
				setState(258);
				expr(0);
				}
				break;
			case 2:
				_localctx = new VarDeclWithoutArgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				type();
				setState(261);
				match(ID);
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
		enterRule(_localctx, 34, RULE_playStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(PLAY);
			setState(266);
			playValues();
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
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
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
		enterRule(_localctx, 36, RULE_playValues);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new PlayNoteContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				match(NOTE_VAL);
				setState(269);
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
				setState(270);
				chord();
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
				break;
			case 3:
				_localctx = new PlayFuncContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(273);
				functionCall();
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(274);
					match(T__7);
					setState(275);
					match(ID);
					}
				}

				}
				break;
			case 4:
				_localctx = new PlayIDVariantsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(278);
				match(ID);
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INT_VAL || _la==ID) {
					{
					setState(279);
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
				setState(283); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(282);
					multiPlayValues();
					}
					}
					setState(285); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & 72057594037929985L) != 0) );
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
		enterRule(_localctx, 38, RULE_multiPlayValues);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(292); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(292);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NOTE_VAL:
						{
						setState(289);
						match(NOTE_VAL);
						}
						break;
					case T__14:
						{
						setState(290);
						chord();
						}
						break;
					case ID:
						{
						setState(291);
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
				setState(294); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(296);
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
		enterRule(_localctx, 40, RULE_pauseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(PAUSE);
			setState(299);
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
	public static class LoopStatementContext extends ControlStatementContext {
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public LoopStatementContext(ControlStatementContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ControlStatementContext {
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public List<ElseifContext> elseif() {
			return getRuleContexts(ElseifContext.class);
		}
		public ElseifContext elseif(int i) {
			return getRuleContext(ElseifContext.class,i);
		}
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public IfStatementContext(ControlStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlStatementContext controlStatement() throws RecognitionException {
		ControlStatementContext _localctx = new ControlStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_controlStatement);
		int _la;
		try {
			int _alt;
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
				_localctx = new LoopStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				loop();
				}
				break;
			case T__10:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(302);
				if_();
				setState(306);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(303);
						elseif();
						}
						} 
					}
					setState(308);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(309);
					else_();
					}
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
	public static class LoopContext extends ParserRuleContext {
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	 
		public LoopContext() { }
		public void copyFrom(LoopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileLoopContext extends LoopContext {
		public TerminalNode LP() { return getToken(MusicParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(MusicParser.RP, 0); }
		public LoopBodyContext loopBody() {
			return getRuleContext(LoopBodyContext.class,0);
		}
		public WhileLoopContext(LoopContext ctx) { copyFrom(ctx); }
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
	public static class ForLoopContext extends LoopContext {
		public TerminalNode LP() { return getToken(MusicParser.LP, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(MusicParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MusicParser.SEMICOLON, i);
		}
		public TerminalNode RP() { return getToken(MusicParser.RP, 0); }
		public LoopBodyContext loopBody() {
			return getRuleContext(LoopBodyContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ForLoopContext(LoopContext ctx) { copyFrom(ctx); }
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

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_loop);
		int _la;
		try {
			setState(340);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				match(T__8);
				setState(315);
				match(LP);
				setState(316);
				expr(0);
				setState(317);
				match(RP);
				setState(318);
				match(T__1);
				setState(319);
				loopBody();
				setState(320);
				match(T__2);
				}
				break;
			case T__9:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(322);
				match(T__9);
				setState(323);
				match(LP);
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0)) {
					{
					setState(324);
					varDecl();
					}
				}

				setState(327);
				match(SEMICOLON);
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & 81909494174436865L) != 0)) {
					{
					setState(328);
					expr(0);
					}
				}

				setState(331);
				match(SEMICOLON);
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLAY || _la==ID) {
					{
					setState(332);
					forUpdate();
					}
				}

				setState(335);
				match(RP);
				setState(336);
				match(T__1);
				setState(337);
				loopBody();
				setState(338);
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
	public static class LoopBodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<BreakStatementContext> breakStatement() {
			return getRuleContexts(BreakStatementContext.class);
		}
		public BreakStatementContext breakStatement(int i) {
			return getRuleContext(BreakStatementContext.class,i);
		}
		public List<ContinueStatementContext> continueStatement() {
			return getRuleContexts(ContinueStatementContext.class);
		}
		public ContinueStatementContext continueStatement(int i) {
			return getRuleContext(ContinueStatementContext.class,i);
		}
		public LoopBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterLoopBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitLoopBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitLoopBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopBodyContext loopBody() throws RecognitionException {
		LoopBodyContext _localctx = new LoopBodyContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_loopBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(345);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__5:
				case T__8:
				case T__9:
				case T__10:
				case T__14:
				case INT:
				case BOOL:
				case CHORD:
				case NOTE:
				case BOOL_VAL:
				case INT_VAL:
				case NOTE_VAL:
				case PACE:
				case DISTORTION:
				case VOLUME:
				case JAZZ:
				case BLUES:
				case INSTRUMENT:
				case SUSTAIN:
				case VIBRATO:
				case BALANCE:
				case SOSTENUTO:
				case SOFT:
				case RESONANCE:
				case REVERB:
				case TREMOLO:
				case CHORUS:
				case PHRASER:
				case SET:
				case PLAY:
				case PAUSE:
				case LP:
				case ADD:
				case SUB:
				case NOT:
				case ID:
					{
					setState(342);
					statement();
					}
					break;
				case T__12:
					{
					setState(343);
					breakStatement();
					}
					break;
				case T__13:
					{
					setState(344);
					continueStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(347); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -9213837072430207422L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 145L) != 0) );
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
	public static class IfContext extends ParserRuleContext {
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
		public List<BreakStatementContext> breakStatement() {
			return getRuleContexts(BreakStatementContext.class);
		}
		public BreakStatementContext breakStatement(int i) {
			return getRuleContext(BreakStatementContext.class,i);
		}
		public List<ContinueStatementContext> continueStatement() {
			return getRuleContexts(ContinueStatementContext.class);
		}
		public ContinueStatementContext continueStatement(int i) {
			return getRuleContext(ContinueStatementContext.class,i);
		}
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
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

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(T__10);
			setState(350);
			match(LP);
			setState(351);
			expr(0);
			setState(352);
			match(RP);
			setState(353);
			match(T__1);
			setState(357); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(357);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__5:
				case T__8:
				case T__9:
				case T__10:
				case T__14:
				case INT:
				case BOOL:
				case CHORD:
				case NOTE:
				case BOOL_VAL:
				case INT_VAL:
				case NOTE_VAL:
				case PACE:
				case DISTORTION:
				case VOLUME:
				case JAZZ:
				case BLUES:
				case INSTRUMENT:
				case SUSTAIN:
				case VIBRATO:
				case BALANCE:
				case SOSTENUTO:
				case SOFT:
				case RESONANCE:
				case REVERB:
				case TREMOLO:
				case CHORUS:
				case PHRASER:
				case SET:
				case PLAY:
				case PAUSE:
				case LP:
				case ADD:
				case SUB:
				case NOT:
				case ID:
					{
					setState(354);
					statement();
					}
					break;
				case T__12:
					{
					setState(355);
					breakStatement();
					}
					break;
				case T__13:
					{
					setState(356);
					continueStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(359); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -9213837072430207422L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 145L) != 0) );
			setState(361);
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
	public static class ElseifContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(MusicParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(MusicParser.RP, 0); }
		public LoopBodyContext loopBody() {
			return getRuleContext(LoopBodyContext.class,0);
		}
		public ElseifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterElseif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitElseif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitElseif(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifContext elseif() throws RecognitionException {
		ElseifContext _localctx = new ElseifContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_elseif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(T__11);
			setState(364);
			match(T__10);
			setState(365);
			match(LP);
			setState(366);
			expr(0);
			setState(367);
			match(RP);
			setState(368);
			match(T__1);
			setState(369);
			loopBody();
			setState(370);
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
	public static class ElseContext extends ParserRuleContext {
		public LoopBodyContext loopBody() {
			return getRuleContext(LoopBodyContext.class,0);
		}
		public ElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseContext else_() throws RecognitionException {
		ElseContext _localctx = new ElseContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(T__11);
			setState(373);
			match(T__1);
			setState(374);
			loopBody();
			setState(375);
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
	public static class ForUpdateContext extends ParserRuleContext {
		public PlayStatementContext playStatement() {
			return getRuleContext(PlayStatementContext.class,0);
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
		enterRule(_localctx, 54, RULE_forUpdate);
		try {
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLAY:
				enterOuterAlt(_localctx, 1);
				{
				setState(377);
				playStatement();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(378);
				forAssignment();
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
	public static class ForAssignmentContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public SelfAssignmentContext selfAssignment() {
			return getRuleContext(SelfAssignmentContext.class,0);
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
		enterRule(_localctx, 56, RULE_forAssignment);
		try {
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(381);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(382);
				selfAssignment();
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
		enterRule(_localctx, 58, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(T__12);
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
		enterRule(_localctx, 60, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			match(T__13);
			setState(389);
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
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
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
		enterRule(_localctx, 62, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(ID);
			setState(392);
			match(LP);
			setState(394);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(393);
				arguments();
				}
				break;
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35183835217920L) != 0)) {
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
		enterRule(_localctx, 64, RULE_arguments);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			expr(0);
			setState(409);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		enterRule(_localctx, 66, RULE_settingsList);
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
	public static class SelfAssignmentExprContext extends ExprContext {
		public SelfAssignmentContext selfAssignment() {
			return getRuleContext(SelfAssignmentContext.class,0);
		}
		public SelfAssignmentExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterSelfAssignmentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitSelfAssignmentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitSelfAssignmentExpr(this);
			else return visitor.visitChildren(this);
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
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				_localctx = new SelfAssignmentExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(421);
				selfAssignment();
				}
				break;
			case 2:
				{
				_localctx = new ParanthesesExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(422);
				match(LP);
				setState(423);
				expr(0);
				setState(424);
				match(RP);
				}
				break;
			case 3:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(426);
				match(NOT);
				setState(427);
				expr(14);
				}
				break;
			case 4:
				{
				_localctx = new InstrumentOperatorExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(428);
				match(INSTRUMENT);
				setState(429);
				eqOp();
				setState(430);
				match(INSTRUMENT_VALUE);
				}
				break;
			case 5:
				{
				_localctx = new ChordExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(432);
				chord();
				}
				break;
			case 6:
				{
				_localctx = new SettingsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(433);
				settingsValues();
				}
				break;
			case 7:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(434);
				intVal();
				}
				break;
			case 8:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(435);
				match(BOOL_VAL);
				}
				break;
			case 9:
				{
				_localctx = new NoteExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(436);
				match(NOTE_VAL);
				}
				break;
			case 10:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(437);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(466);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(464);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new MullDivOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(440);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(441);
						mullDivOp();
						setState(442);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new AddSubOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(444);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(445);
						addSubOp();
						setState(446);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new OrderOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(448);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(449);
						orderOp();
						setState(450);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new EqOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(452);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(453);
						eqOp();
						setState(454);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new AndOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(456);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(457);
						andOp();
						setState(458);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new OrOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(460);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(461);
						orOp();
						setState(462);
						expr(9);
						}
						break;
					}
					} 
				}
				setState(468);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
		enterRule(_localctx, 70, RULE_orderOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2161727821137838080L) != 0)) ) {
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
		enterRule(_localctx, 72, RULE_eqOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
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
		enterRule(_localctx, 74, RULE_andOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
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
		enterRule(_localctx, 76, RULE_orOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
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
		enterRule(_localctx, 78, RULE_addSubOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
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
		enterRule(_localctx, 80, RULE_mullDivOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			_la = _input.LA(1);
			if ( !(((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & 19L) != 0)) ) {
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
		enterRule(_localctx, 82, RULE_assOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8444249301319680L) != 0)) ) {
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
		enterRule(_localctx, 84, RULE_chord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(T__14);
			setState(484);
			match(NOTE_VAL);
			setState(487); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(485);
				match(T__4);
				setState(486);
				match(NOTE_VAL);
				}
				}
				setState(489); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(491);
			match(T__15);
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
		enterRule(_localctx, 86, RULE_trackStatements);
		try {
			setState(495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new TrackAddContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(493);
				trackStatement();
				}
				break;
			case TRACK:
				_localctx = new TrackDeclareContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(494);
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
		enterRule(_localctx, 88, RULE_trackStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(ID);
			setState(498);
			match(T__16);
			setState(499);
			functionCall();
			setState(500);
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
		enterRule(_localctx, 90, RULE_trackDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			match(TRACK);
			setState(503);
			match(ID);
			setState(504);
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
		public TerminalNode ADD() { return getToken(MusicParser.ADD, 0); }
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
		enterRule(_localctx, 92, RULE_intVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUB) {
				{
				setState(506);
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

			setState(509);
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
		case 34:
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
		"\u0004\u0001I\u0200\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0001\u0000\u0005\u0000`\b\u0000\n\u0000\f\u0000"+
		"c\t\u0000\u0001\u0000\u0005\u0000f\b\u0000\n\u0000\f\u0000i\t\u0000\u0001"+
		"\u0000\u0003\u0000l\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002x\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002}\b\u0002\n\u0002\f\u0002\u0080\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003\u008a\b\u0003\n\u0003\f\u0003\u008d\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0094\b\u0004\n"+
		"\u0004\f\u0004\u0097\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u00a0\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b9\b\b\u0001\t\u0001\t\u0003"+
		"\t\u00bd\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00f4\b\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0108\b\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0115\b\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u0119\b\u0012\u0001\u0012\u0004\u0012\u011c"+
		"\b\u0012\u000b\u0012\f\u0012\u011d\u0003\u0012\u0120\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0004\u0013\u0125\b\u0013\u000b\u0013\f\u0013"+
		"\u0126\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0131\b\u0015\n\u0015\f\u0015"+
		"\u0134\t\u0015\u0001\u0015\u0003\u0015\u0137\b\u0015\u0003\u0015\u0139"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u0146\b\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u014a\b\u0016"+
		"\u0001\u0016\u0001\u0016\u0003\u0016\u014e\b\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0155\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0004\u0017\u015a\b\u0017\u000b\u0017\f\u0017"+
		"\u015b\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0004\u0018\u0166\b\u0018\u000b\u0018\f"+
		"\u0018\u0167\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u017c\b\u001b\u0001\u001c\u0001\u001c\u0003\u001c"+
		"\u0180\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u018b\b\u001f"+
		"\u0001\u001f\u0003\u001f\u018e\b\u001f\u0001\u001f\u0003\u001f\u0191\b"+
		"\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0005 \u0198\b \n"+
		" \f \u019b\t \u0001!\u0001!\u0001!\u0005!\u01a0\b!\n!\f!\u01a3\t!\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003"+
		"\"\u01b7\b\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0005\"\u01d1"+
		"\b\"\n\"\f\"\u01d4\t\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001"+
		"&\u0001&\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001"+
		"*\u0001*\u0004*\u01e8\b*\u000b*\f*\u01e9\u0001*\u0001*\u0001+\u0001+\u0003"+
		"+\u01f0\b+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001"+
		"-\u0001.\u0003.\u01fc\b.\u0001.\u0001.\u0001.\u0000\u0001D/\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\\u0000\n\u0001\u0000\u0013\u0016\u0002"+
		"\u0000\u0019\u0019GG\u0002\u0000--GG\u0002\u0000\u0018\u0018GG\u0001\u0000"+
		"\u001d,\u0001\u00009<\u0001\u000078\u0001\u0000?@\u0002\u0000=>AA\u0001"+
		"\u000014\u0221\u0000a\u0001\u0000\u0000\u0000\u0002o\u0001\u0000\u0000"+
		"\u0000\u0004s\u0001\u0000\u0000\u0000\u0006\u0083\u0001\u0000\u0000\u0000"+
		"\b\u0090\u0001\u0000\u0000\u0000\n\u0098\u0001\u0000\u0000\u0000\f\u009b"+
		"\u0001\u0000\u0000\u0000\u000e\u009f\u0001\u0000\u0000\u0000\u0010\u00b8"+
		"\u0001\u0000\u0000\u0000\u0012\u00ba\u0001\u0000\u0000\u0000\u0014\u00be"+
		"\u0001\u0000\u0000\u0000\u0016\u00c0\u0001\u0000\u0000\u0000\u0018\u00f3"+
		"\u0001\u0000\u0000\u0000\u001a\u00f5\u0001\u0000\u0000\u0000\u001c\u00f7"+
		"\u0001\u0000\u0000\u0000\u001e\u00fb\u0001\u0000\u0000\u0000 \u0107\u0001"+
		"\u0000\u0000\u0000\"\u0109\u0001\u0000\u0000\u0000$\u011f\u0001\u0000"+
		"\u0000\u0000&\u0124\u0001\u0000\u0000\u0000(\u012a\u0001\u0000\u0000\u0000"+
		"*\u0138\u0001\u0000\u0000\u0000,\u0154\u0001\u0000\u0000\u0000.\u0159"+
		"\u0001\u0000\u0000\u00000\u015d\u0001\u0000\u0000\u00002\u016b\u0001\u0000"+
		"\u0000\u00004\u0174\u0001\u0000\u0000\u00006\u017b\u0001\u0000\u0000\u0000"+
		"8\u017f\u0001\u0000\u0000\u0000:\u0181\u0001\u0000\u0000\u0000<\u0184"+
		"\u0001\u0000\u0000\u0000>\u0187\u0001\u0000\u0000\u0000@\u0194\u0001\u0000"+
		"\u0000\u0000B\u019c\u0001\u0000\u0000\u0000D\u01b6\u0001\u0000\u0000\u0000"+
		"F\u01d5\u0001\u0000\u0000\u0000H\u01d7\u0001\u0000\u0000\u0000J\u01d9"+
		"\u0001\u0000\u0000\u0000L\u01db\u0001\u0000\u0000\u0000N\u01dd\u0001\u0000"+
		"\u0000\u0000P\u01df\u0001\u0000\u0000\u0000R\u01e1\u0001\u0000\u0000\u0000"+
		"T\u01e3\u0001\u0000\u0000\u0000V\u01ef\u0001\u0000\u0000\u0000X\u01f1"+
		"\u0001\u0000\u0000\u0000Z\u01f6\u0001\u0000\u0000\u0000\\\u01fb\u0001"+
		"\u0000\u0000\u0000^`\u0003\u0002\u0001\u0000_^\u0001\u0000\u0000\u0000"+
		"`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000bg\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000df\u0003\u0004"+
		"\u0002\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001"+
		"\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000"+
		"ig\u0001\u0000\u0000\u0000jl\u0003\u0006\u0003\u0000kj\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0005\u0000"+
		"\u0000\u0001n\u0001\u0001\u0000\u0000\u0000op\u0005\u0012\u0000\u0000"+
		"pq\u0005\u001b\u0000\u0000qr\u0005I\u0000\u0000r\u0003\u0001\u0000\u0000"+
		"\u0000st\u0005\u0001\u0000\u0000tu\u0005G\u0000\u0000uw\u00055\u0000\u0000"+
		"vx\u0003\b\u0004\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000"+
		"xy\u0001\u0000\u0000\u0000yz\u00056\u0000\u0000z~\u0005\u0002\u0000\u0000"+
		"{}\u0003\u0010\b\u0000|{\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000"+
		"\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f"+
		"\u0081\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0005\u0003\u0000\u0000\u0082\u0005\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0005\u0001\u0000\u0000\u0084\u0085\u0005\u0004\u0000\u0000\u0085\u0086"+
		"\u00055\u0000\u0000\u0086\u0087\u00056\u0000\u0000\u0087\u008b\u0005\u0002"+
		"\u0000\u0000\u0088\u008a\u0003\u000e\u0007\u0000\u0089\u0088\u0001\u0000"+
		"\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008e\u0001\u0000"+
		"\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0005\u0003"+
		"\u0000\u0000\u008f\u0007\u0001\u0000\u0000\u0000\u0090\u0095\u0003\n\u0005"+
		"\u0000\u0091\u0092\u0005\u0005\u0000\u0000\u0092\u0094\u0003\n\u0005\u0000"+
		"\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000"+
		"\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\t\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0003\f\u0006\u0000\u0099\u009a\u0005G\u0000\u0000\u009a\u000b"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0007\u0000\u0000\u0000\u009c\r\u0001"+
		"\u0000\u0000\u0000\u009d\u00a0\u0003\u0010\b\u0000\u009e\u00a0\u0003V"+
		"+\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u009e\u0001\u0000\u0000"+
		"\u0000\u00a0\u000f\u0001\u0000\u0000\u0000\u00a1\u00b9\u0003\u0004\u0002"+
		"\u0000\u00a2\u00a3\u0003\u001c\u000e\u0000\u00a3\u00a4\u0005I\u0000\u0000"+
		"\u00a4\u00b9\u0001\u0000\u0000\u0000\u00a5\u00a6\u0003\u0016\u000b\u0000"+
		"\u00a6\u00a7\u0005I\u0000\u0000\u00a7\u00b9\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0003 \u0010\u0000\u00a9\u00aa\u0005I\u0000\u0000\u00aa\u00b9\u0001"+
		"\u0000\u0000\u0000\u00ab\u00ac\u0003\"\u0011\u0000\u00ac\u00ad\u0005I"+
		"\u0000\u0000\u00ad\u00b9\u0001\u0000\u0000\u0000\u00ae\u00af\u0003(\u0014"+
		"\u0000\u00af\u00b0\u0005I\u0000\u0000\u00b0\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b9\u0003*\u0015\u0000\u00b2\u00b3\u0003\u0014\n\u0000\u00b3"+
		"\u00b4\u0005I\u0000\u0000\u00b4\u00b9\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0003\u0012\t\u0000\u00b6\u00b7\u0005I\u0000\u0000\u00b7\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b8\u00a1\u0001\u0000\u0000\u0000\u00b8\u00a2\u0001"+
		"\u0000\u0000\u0000\u00b8\u00a5\u0001\u0000\u0000\u0000\u00b8\u00a8\u0001"+
		"\u0000\u0000\u0000\u00b8\u00ab\u0001\u0000\u0000\u0000\u00b8\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b1\u0001\u0000\u0000\u0000\u00b8\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b5\u0001\u0000\u0000\u0000\u00b9\u0011\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bc\u0005\u0006\u0000\u0000\u00bb\u00bd\u0003"+
		"D\"\u0000\u00bc\u00bb\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bd\u0013\u0001\u0000\u0000\u0000\u00be\u00bf\u0003D\""+
		"\u0000\u00bf\u0015\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005.\u0000\u0000"+
		"\u00c1\u00c2\u0003\u0018\f\u0000\u00c2\u0017\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0005\u001d\u0000\u0000\u00c4\u00c5\u0005\u0007\u0000\u0000\u00c5"+
		"\u00f4\u0007\u0001\u0000\u0000\u00c6\u00c7\u0005#\u0000\u0000\u00c7\u00c8"+
		"\u0005\u0007\u0000\u0000\u00c8\u00f4\u0007\u0001\u0000\u0000\u00c9\u00ca"+
		"\u0005\"\u0000\u0000\u00ca\u00cb\u0005\u0007\u0000\u0000\u00cb\u00f4\u0007"+
		"\u0002\u0000\u0000\u00cc\u00cd\u0005\u001e\u0000\u0000\u00cd\u00ce\u0005"+
		"\u0007\u0000\u0000\u00ce\u00f4\u0007\u0001\u0000\u0000\u00cf\u00d0\u0005"+
		" \u0000\u0000\u00d0\u00d1\u0005\u0007\u0000\u0000\u00d1\u00f4\u0007\u0003"+
		"\u0000\u0000\u00d2\u00d3\u0005!\u0000\u0000\u00d3\u00d4\u0005\u0007\u0000"+
		"\u0000\u00d4\u00f4\u0007\u0003\u0000\u0000\u00d5\u00d6\u0005\u001f\u0000"+
		"\u0000\u00d6\u00d7\u0005\u0007\u0000\u0000\u00d7\u00f4\u0007\u0001\u0000"+
		"\u0000\u00d8\u00d9\u0005$\u0000\u0000\u00d9\u00da\u0005\u0007\u0000\u0000"+
		"\u00da\u00f4\u0007\u0001\u0000\u0000\u00db\u00dc\u0005%\u0000\u0000\u00dc"+
		"\u00dd\u0005\u0007\u0000\u0000\u00dd\u00f4\u0007\u0001\u0000\u0000\u00de"+
		"\u00df\u0005&\u0000\u0000\u00df\u00e0\u0005\u0007\u0000\u0000\u00e0\u00f4"+
		"\u0007\u0001\u0000\u0000\u00e1\u00e2\u0005\'\u0000\u0000\u00e2\u00e3\u0005"+
		"\u0007\u0000\u0000\u00e3\u00f4\u0007\u0001\u0000\u0000\u00e4\u00e5\u0005"+
		"(\u0000\u0000\u00e5\u00e6\u0005\u0007\u0000\u0000\u00e6\u00f4\u0007\u0001"+
		"\u0000\u0000\u00e7\u00e8\u0005)\u0000\u0000\u00e8\u00e9\u0005\u0007\u0000"+
		"\u0000\u00e9\u00f4\u0007\u0001\u0000\u0000\u00ea\u00eb\u0005*\u0000\u0000"+
		"\u00eb\u00ec\u0005\u0007\u0000\u0000\u00ec\u00f4\u0007\u0001\u0000\u0000"+
		"\u00ed\u00ee\u0005+\u0000\u0000\u00ee\u00ef\u0005\u0007\u0000\u0000\u00ef"+
		"\u00f4\u0007\u0001\u0000\u0000\u00f0\u00f1\u0005,\u0000\u0000\u00f1\u00f2"+
		"\u0005\u0007\u0000\u0000\u00f2\u00f4\u0007\u0001\u0000\u0000\u00f3\u00c3"+
		"\u0001\u0000\u0000\u0000\u00f3\u00c6\u0001\u0000\u0000\u0000\u00f3\u00c9"+
		"\u0001\u0000\u0000\u0000\u00f3\u00cc\u0001\u0000\u0000\u0000\u00f3\u00cf"+
		"\u0001\u0000\u0000\u0000\u00f3\u00d2\u0001\u0000\u0000\u0000\u00f3\u00d5"+
		"\u0001\u0000\u0000\u0000\u00f3\u00d8\u0001\u0000\u0000\u0000\u00f3\u00db"+
		"\u0001\u0000\u0000\u0000\u00f3\u00de\u0001\u0000\u0000\u0000\u00f3\u00e1"+
		"\u0001\u0000\u0000\u0000\u00f3\u00e4\u0001\u0000\u0000\u0000\u00f3\u00e7"+
		"\u0001\u0000\u0000\u0000\u00f3\u00ea\u0001\u0000\u0000\u0000\u00f3\u00ed"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f0\u0001\u0000\u0000\u0000\u00f4\u0019"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f6\u0007\u0004\u0000\u0000\u00f6\u001b"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005G\u0000\u0000\u00f8\u00f9\u0005"+
		"\u0007\u0000\u0000\u00f9\u00fa\u0003D\"\u0000\u00fa\u001d\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fc\u0005G\u0000\u0000\u00fc\u00fd\u0003R)\u0000"+
		"\u00fd\u00fe\u0003D\"\u0000\u00fe\u001f\u0001\u0000\u0000\u0000\u00ff"+
		"\u0100\u0003\f\u0006\u0000\u0100\u0101\u0005G\u0000\u0000\u0101\u0102"+
		"\u0005\u0007\u0000\u0000\u0102\u0103\u0003D\"\u0000\u0103\u0108\u0001"+
		"\u0000\u0000\u0000\u0104\u0105\u0003\f\u0006\u0000\u0105\u0106\u0005G"+
		"\u0000\u0000\u0106\u0108\u0001\u0000\u0000\u0000\u0107\u00ff\u0001\u0000"+
		"\u0000\u0000\u0107\u0104\u0001\u0000\u0000\u0000\u0108!\u0001\u0000\u0000"+
		"\u0000\u0109\u010a\u0005/\u0000\u0000\u010a\u010b\u0003$\u0012\u0000\u010b"+
		"#\u0001\u0000\u0000\u0000\u010c\u010d\u0005\u001a\u0000\u0000\u010d\u0120"+
		"\u0007\u0001\u0000\u0000\u010e\u010f\u0003T*\u0000\u010f\u0110\u0007\u0001"+
		"\u0000\u0000\u0110\u0120\u0001\u0000\u0000\u0000\u0111\u0114\u0003>\u001f"+
		"\u0000\u0112\u0113\u0005\b\u0000\u0000\u0113\u0115\u0005G\u0000\u0000"+
		"\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000"+
		"\u0115\u0120\u0001\u0000\u0000\u0000\u0116\u0118\u0005G\u0000\u0000\u0117"+
		"\u0119\u0007\u0001\u0000\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0118"+
		"\u0119\u0001\u0000\u0000\u0000\u0119\u0120\u0001\u0000\u0000\u0000\u011a"+
		"\u011c\u0003&\u0013\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011c\u011d"+
		"\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011d\u011e"+
		"\u0001\u0000\u0000\u0000\u011e\u0120\u0001\u0000\u0000\u0000\u011f\u010c"+
		"\u0001\u0000\u0000\u0000\u011f\u010e\u0001\u0000\u0000\u0000\u011f\u0111"+
		"\u0001\u0000\u0000\u0000\u011f\u0116\u0001\u0000\u0000\u0000\u011f\u011b"+
		"\u0001\u0000\u0000\u0000\u0120%\u0001\u0000\u0000\u0000\u0121\u0125\u0005"+
		"\u001a\u0000\u0000\u0122\u0125\u0003T*\u0000\u0123\u0125\u0005G\u0000"+
		"\u0000\u0124\u0121\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000"+
		"\u0000\u0124\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000"+
		"\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000"+
		"\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u0129\u0007\u0001\u0000"+
		"\u0000\u0129\'\u0001\u0000\u0000\u0000\u012a\u012b\u00050\u0000\u0000"+
		"\u012b\u012c\u0007\u0001\u0000\u0000\u012c)\u0001\u0000\u0000\u0000\u012d"+
		"\u0139\u0003,\u0016\u0000\u012e\u0132\u00030\u0018\u0000\u012f\u0131\u0003"+
		"2\u0019\u0000\u0130\u012f\u0001\u0000\u0000\u0000\u0131\u0134\u0001\u0000"+
		"\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000"+
		"\u0000\u0000\u0133\u0136\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000"+
		"\u0000\u0000\u0135\u0137\u00034\u001a\u0000\u0136\u0135\u0001\u0000\u0000"+
		"\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137\u0139\u0001\u0000\u0000"+
		"\u0000\u0138\u012d\u0001\u0000\u0000\u0000\u0138\u012e\u0001\u0000\u0000"+
		"\u0000\u0139+\u0001\u0000\u0000\u0000\u013a\u013b\u0005\t\u0000\u0000"+
		"\u013b\u013c\u00055\u0000\u0000\u013c\u013d\u0003D\"\u0000\u013d\u013e"+
		"\u00056\u0000\u0000\u013e\u013f\u0005\u0002\u0000\u0000\u013f\u0140\u0003"+
		".\u0017\u0000\u0140\u0141\u0005\u0003\u0000\u0000\u0141\u0155\u0001\u0000"+
		"\u0000\u0000\u0142\u0143\u0005\n\u0000\u0000\u0143\u0145\u00055\u0000"+
		"\u0000\u0144\u0146\u0003 \u0010\u0000\u0145\u0144\u0001\u0000\u0000\u0000"+
		"\u0145\u0146\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000"+
		"\u0147\u0149\u0005I\u0000\u0000\u0148\u014a\u0003D\"\u0000\u0149\u0148"+
		"\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014b"+
		"\u0001\u0000\u0000\u0000\u014b\u014d\u0005I\u0000\u0000\u014c\u014e\u0003"+
		"6\u001b\u0000\u014d\u014c\u0001\u0000\u0000\u0000\u014d\u014e\u0001\u0000"+
		"\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f\u0150\u00056\u0000"+
		"\u0000\u0150\u0151\u0005\u0002\u0000\u0000\u0151\u0152\u0003.\u0017\u0000"+
		"\u0152\u0153\u0005\u0003\u0000\u0000\u0153\u0155\u0001\u0000\u0000\u0000"+
		"\u0154\u013a\u0001\u0000\u0000\u0000\u0154\u0142\u0001\u0000\u0000\u0000"+
		"\u0155-\u0001\u0000\u0000\u0000\u0156\u015a\u0003\u0010\b\u0000\u0157"+
		"\u015a\u0003:\u001d\u0000\u0158\u015a\u0003<\u001e\u0000\u0159\u0156\u0001"+
		"\u0000\u0000\u0000\u0159\u0157\u0001\u0000\u0000\u0000\u0159\u0158\u0001"+
		"\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u0159\u0001"+
		"\u0000\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c/\u0001\u0000"+
		"\u0000\u0000\u015d\u015e\u0005\u000b\u0000\u0000\u015e\u015f\u00055\u0000"+
		"\u0000\u015f\u0160\u0003D\"\u0000\u0160\u0161\u00056\u0000\u0000\u0161"+
		"\u0165\u0005\u0002\u0000\u0000\u0162\u0166\u0003\u0010\b\u0000\u0163\u0166"+
		"\u0003:\u001d\u0000\u0164\u0166\u0003<\u001e\u0000\u0165\u0162\u0001\u0000"+
		"\u0000\u0000\u0165\u0163\u0001\u0000\u0000\u0000\u0165\u0164\u0001\u0000"+
		"\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000"+
		"\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u0169\u0001\u0000"+
		"\u0000\u0000\u0169\u016a\u0005\u0003\u0000\u0000\u016a1\u0001\u0000\u0000"+
		"\u0000\u016b\u016c\u0005\f\u0000\u0000\u016c\u016d\u0005\u000b\u0000\u0000"+
		"\u016d\u016e\u00055\u0000\u0000\u016e\u016f\u0003D\"\u0000\u016f\u0170"+
		"\u00056\u0000\u0000\u0170\u0171\u0005\u0002\u0000\u0000\u0171\u0172\u0003"+
		".\u0017\u0000\u0172\u0173\u0005\u0003\u0000\u0000\u01733\u0001\u0000\u0000"+
		"\u0000\u0174\u0175\u0005\f\u0000\u0000\u0175\u0176\u0005\u0002\u0000\u0000"+
		"\u0176\u0177\u0003.\u0017\u0000\u0177\u0178\u0005\u0003\u0000\u0000\u0178"+
		"5\u0001\u0000\u0000\u0000\u0179\u017c\u0003\"\u0011\u0000\u017a\u017c"+
		"\u00038\u001c\u0000\u017b\u0179\u0001\u0000\u0000\u0000\u017b\u017a\u0001"+
		"\u0000\u0000\u0000\u017c7\u0001\u0000\u0000\u0000\u017d\u0180\u0003\u001c"+
		"\u000e\u0000\u017e\u0180\u0003\u001e\u000f\u0000\u017f\u017d\u0001\u0000"+
		"\u0000\u0000\u017f\u017e\u0001\u0000\u0000\u0000\u01809\u0001\u0000\u0000"+
		"\u0000\u0181\u0182\u0005\r\u0000\u0000\u0182\u0183\u0005I\u0000\u0000"+
		"\u0183;\u0001\u0000\u0000\u0000\u0184\u0185\u0005\u000e\u0000\u0000\u0185"+
		"\u0186\u0005I\u0000\u0000\u0186=\u0001\u0000\u0000\u0000\u0187\u0188\u0005"+
		"G\u0000\u0000\u0188\u018a\u00055\u0000\u0000\u0189\u018b\u0003@ \u0000"+
		"\u018a\u0189\u0001\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000\u0000"+
		"\u018b\u018d\u0001\u0000\u0000\u0000\u018c\u018e\u0005\u0005\u0000\u0000"+
		"\u018d\u018c\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000"+
		"\u018e\u0190\u0001\u0000\u0000\u0000\u018f\u0191\u0003B!\u0000\u0190\u018f"+
		"\u0001\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000\u0000\u0191\u0192"+
		"\u0001\u0000\u0000\u0000\u0192\u0193\u00056\u0000\u0000\u0193?\u0001\u0000"+
		"\u0000\u0000\u0194\u0199\u0003D\"\u0000\u0195\u0196\u0005\u0005\u0000"+
		"\u0000\u0196\u0198\u0003D\"\u0000\u0197\u0195\u0001\u0000\u0000\u0000"+
		"\u0198\u019b\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000"+
		"\u0199\u019a\u0001\u0000\u0000\u0000\u019aA\u0001\u0000\u0000\u0000\u019b"+
		"\u0199\u0001\u0000\u0000\u0000\u019c\u01a1\u0003\u0018\f\u0000\u019d\u019e"+
		"\u0005\u0005\u0000\u0000\u019e\u01a0\u0003\u0018\f\u0000\u019f\u019d\u0001"+
		"\u0000\u0000\u0000\u01a0\u01a3\u0001\u0000\u0000\u0000\u01a1\u019f\u0001"+
		"\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000\u0000\u01a2C\u0001\u0000"+
		"\u0000\u0000\u01a3\u01a1\u0001\u0000\u0000\u0000\u01a4\u01a5\u0006\"\uffff"+
		"\uffff\u0000\u01a5\u01b7\u0003\u001e\u000f\u0000\u01a6\u01a7\u00055\u0000"+
		"\u0000\u01a7\u01a8\u0003D\"\u0000\u01a8\u01a9\u00056\u0000\u0000\u01a9"+
		"\u01b7\u0001\u0000\u0000\u0000\u01aa\u01ab\u0005D\u0000\u0000\u01ab\u01b7"+
		"\u0003D\"\u000e\u01ac\u01ad\u0005\"\u0000\u0000\u01ad\u01ae\u0003H$\u0000"+
		"\u01ae\u01af\u0005-\u0000\u0000\u01af\u01b7\u0001\u0000\u0000\u0000\u01b0"+
		"\u01b7\u0003T*\u0000\u01b1\u01b7\u0003\u001a\r\u0000\u01b2\u01b7\u0003"+
		"\\.\u0000\u01b3\u01b7\u0005\u0018\u0000\u0000\u01b4\u01b7\u0005\u001a"+
		"\u0000\u0000\u01b5\u01b7\u0005G\u0000\u0000\u01b6\u01a4\u0001\u0000\u0000"+
		"\u0000\u01b6\u01a6\u0001\u0000\u0000\u0000\u01b6\u01aa\u0001\u0000\u0000"+
		"\u0000\u01b6\u01ac\u0001\u0000\u0000\u0000\u01b6\u01b0\u0001\u0000\u0000"+
		"\u0000\u01b6\u01b1\u0001\u0000\u0000\u0000\u01b6\u01b2\u0001\u0000\u0000"+
		"\u0000\u01b6\u01b3\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000"+
		"\u0000\u01b6\u01b5\u0001\u0000\u0000\u0000\u01b7\u01d2\u0001\u0000\u0000"+
		"\u0000\u01b8\u01b9\n\r\u0000\u0000\u01b9\u01ba\u0003P(\u0000\u01ba\u01bb"+
		"\u0003D\"\u000e\u01bb\u01d1\u0001\u0000\u0000\u0000\u01bc\u01bd\n\f\u0000"+
		"\u0000\u01bd\u01be\u0003N\'\u0000\u01be\u01bf\u0003D\"\r\u01bf\u01d1\u0001"+
		"\u0000\u0000\u0000\u01c0\u01c1\n\u000b\u0000\u0000\u01c1\u01c2\u0003F"+
		"#\u0000\u01c2\u01c3\u0003D\"\f\u01c3\u01d1\u0001\u0000\u0000\u0000\u01c4"+
		"\u01c5\n\n\u0000\u0000\u01c5\u01c6\u0003H$\u0000\u01c6\u01c7\u0003D\""+
		"\u000b\u01c7\u01d1\u0001\u0000\u0000\u0000\u01c8\u01c9\n\t\u0000\u0000"+
		"\u01c9\u01ca\u0003J%\u0000\u01ca\u01cb\u0003D\"\n\u01cb\u01d1\u0001\u0000"+
		"\u0000\u0000\u01cc\u01cd\n\b\u0000\u0000\u01cd\u01ce\u0003L&\u0000\u01ce"+
		"\u01cf\u0003D\"\t\u01cf\u01d1\u0001\u0000\u0000\u0000\u01d0\u01b8\u0001"+
		"\u0000\u0000\u0000\u01d0\u01bc\u0001\u0000\u0000\u0000\u01d0\u01c0\u0001"+
		"\u0000\u0000\u0000\u01d0\u01c4\u0001\u0000\u0000\u0000\u01d0\u01c8\u0001"+
		"\u0000\u0000\u0000\u01d0\u01cc\u0001\u0000\u0000\u0000\u01d1\u01d4\u0001"+
		"\u0000\u0000\u0000\u01d2\u01d0\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001"+
		"\u0000\u0000\u0000\u01d3E\u0001\u0000\u0000\u0000\u01d4\u01d2\u0001\u0000"+
		"\u0000\u0000\u01d5\u01d6\u0007\u0005\u0000\u0000\u01d6G\u0001\u0000\u0000"+
		"\u0000\u01d7\u01d8\u0007\u0006\u0000\u0000\u01d8I\u0001\u0000\u0000\u0000"+
		"\u01d9\u01da\u0005B\u0000\u0000\u01daK\u0001\u0000\u0000\u0000\u01db\u01dc"+
		"\u0005C\u0000\u0000\u01dcM\u0001\u0000\u0000\u0000\u01dd\u01de\u0007\u0007"+
		"\u0000\u0000\u01deO\u0001\u0000\u0000\u0000\u01df\u01e0\u0007\b\u0000"+
		"\u0000\u01e0Q\u0001\u0000\u0000\u0000\u01e1\u01e2\u0007\t\u0000\u0000"+
		"\u01e2S\u0001\u0000\u0000\u0000\u01e3\u01e4\u0005\u000f\u0000\u0000\u01e4"+
		"\u01e7\u0005\u001a\u0000\u0000\u01e5\u01e6\u0005\u0005\u0000\u0000\u01e6"+
		"\u01e8\u0005\u001a\u0000\u0000\u01e7\u01e5\u0001\u0000\u0000\u0000\u01e8"+
		"\u01e9\u0001\u0000\u0000\u0000\u01e9\u01e7\u0001\u0000\u0000\u0000\u01e9"+
		"\u01ea\u0001\u0000\u0000\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000\u01eb"+
		"\u01ec\u0005\u0010\u0000\u0000\u01ecU\u0001\u0000\u0000\u0000\u01ed\u01f0"+
		"\u0003X,\u0000\u01ee\u01f0\u0003Z-\u0000\u01ef\u01ed\u0001\u0000\u0000"+
		"\u0000\u01ef\u01ee\u0001\u0000\u0000\u0000\u01f0W\u0001\u0000\u0000\u0000"+
		"\u01f1\u01f2\u0005G\u0000\u0000\u01f2\u01f3\u0005\u0011\u0000\u0000\u01f3"+
		"\u01f4\u0003>\u001f\u0000\u01f4\u01f5\u0005I\u0000\u0000\u01f5Y\u0001"+
		"\u0000\u0000\u0000\u01f6\u01f7\u0005\u0017\u0000\u0000\u01f7\u01f8\u0005"+
		"G\u0000\u0000\u01f8\u01f9\u0005I\u0000\u0000\u01f9[\u0001\u0000\u0000"+
		"\u0000\u01fa\u01fc\u0007\u0007\u0000\u0000\u01fb\u01fa\u0001\u0000\u0000"+
		"\u0000\u01fb\u01fc\u0001\u0000\u0000\u0000\u01fc\u01fd\u0001\u0000\u0000"+
		"\u0000\u01fd\u01fe\u0005\u0019\u0000\u0000\u01fe]\u0001\u0000\u0000\u0000"+
		"*agkw~\u008b\u0095\u009f\u00b8\u00bc\u00f3\u0107\u0114\u0118\u011d\u011f"+
		"\u0124\u0126\u0132\u0136\u0138\u0145\u0149\u014d\u0154\u0159\u015b\u0165"+
		"\u0167\u017b\u017f\u018a\u018d\u0190\u0199\u01a1\u01b6\u01d0\u01d2\u01e9"+
		"\u01ef\u01fb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}