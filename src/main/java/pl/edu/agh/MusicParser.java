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
		T__17=18, T__18=19, T__19=20, IMPORT=21, INCLUDE=22, INT=23, BOOL=24, 
		CHORD=25, NOTE=26, TRACK=27, BOOL_VAL=28, INT_VAL=29, NOTE_VAL=30, STRING_VAL=31, 
		ESC=32, LIB_VAL=33, PACE=34, DISTORTION=35, VOLUME=36, JAZZ=37, BLUES=38, 
		INSTRUMENT=39, SUSTAIN=40, VIBRATO=41, BALANCE=42, SOSTENUTO=43, SOFT=44, 
		RESONANCE=45, REVERB=46, TREMOLO=47, CHORUS=48, PHRASER=49, INSTRUMENT_VALUE=50, 
		SET=51, PLAY=52, PAUSE=53, SUMIS=54, DIVIS=55, MULIS=56, SUBIS=57, LP=58, 
		RP=59, EQ=60, NEQ=61, GT=62, LT=63, GEQ=64, LEQ=65, DIV=66, MUL=67, ADD=68, 
		SUB=69, PER=70, AND=71, OR=72, NOT=73, PARENT=74, LINE_COMMENT=75, BLOCK_COMMENT=76, 
		ID=77, WS=78, SEMICOLON=79;
	public static final int
		RULE_program = 0, RULE_globalVars = 1, RULE_includes = 2, RULE_imports = 3, 
		RULE_functionDecl = 4, RULE_mainDecl = 5, RULE_parameters = 6, RULE_parameter = 7, 
		RULE_type = 8, RULE_mainStatement = 9, RULE_statement = 10, RULE_print = 11, 
		RULE_returnStatement = 12, RULE_exprStatement = 13, RULE_settings = 14, 
		RULE_settingsAssigment = 15, RULE_settingsValues = 16, RULE_assignment = 17, 
		RULE_selfAssignment = 18, RULE_varDecl = 19, RULE_playStatement = 20, 
		RULE_playValues = 21, RULE_multiPlayValues = 22, RULE_pauseStatement = 23, 
		RULE_controlStatement = 24, RULE_scope = 25, RULE_parent = 26, RULE_parentID = 27, 
		RULE_loop = 28, RULE_loopBody = 29, RULE_if = 30, RULE_elseif = 31, RULE_else = 32, 
		RULE_forInit = 33, RULE_forUpdate = 34, RULE_forAssignment = 35, RULE_breakStatement = 36, 
		RULE_continueStatement = 37, RULE_functionCall = 38, RULE_arguments = 39, 
		RULE_settingsList = 40, RULE_expr = 41, RULE_orderOp = 42, RULE_eqOp = 43, 
		RULE_andOp = 44, RULE_orOp = 45, RULE_addSubOp = 46, RULE_mullDivOp = 47, 
		RULE_assOp = 48, RULE_chord = 49, RULE_trackStatements = 50, RULE_trackStatement = 51, 
		RULE_trackDeclaration = 52, RULE_intVal = 53;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "globalVars", "includes", "imports", "functionDecl", "mainDecl", 
			"parameters", "parameter", "type", "mainStatement", "statement", "print", 
			"returnStatement", "exprStatement", "settings", "settingsAssigment", 
			"settingsValues", "assignment", "selfAssignment", "varDecl", "playStatement", 
			"playValues", "multiPlayValues", "pauseStatement", "controlStatement", 
			"scope", "parent", "parentID", "loop", "loopBody", "if", "elseif", "else", 
			"forInit", "forUpdate", "forAssignment", "breakStatement", "continueStatement", 
			"functionCall", "arguments", "settingsList", "expr", "orderOp", "eqOp", 
			"andOp", "orOp", "addSubOp", "mullDivOp", "assOp", "chord", "trackStatements", 
			"trackStatement", "trackDeclaration", "intVal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'melody'", "'{'", "'}'", "'main'", "','", "'PRINT'", "'RETURN'", 
			"'='", "'OUT'", "':'", "'while'", "'for'", "'if'", "'else'", "'break'", 
			"'continue'", "'['", "']'", "'ADD'", "'import'", "'include'", "'int'", 
			"'bool'", "'Chord'", "'Note'", "'Track'", null, null, null, null, null, 
			null, "'PACE'", "'DISTORTION'", "'VOLUME'", "'JAZZ'", "'BLUES'", "'INSTRUMENT'", 
			"'SUSTAIN'", "'VIBRATO'", "'BALANCE'", "'SOSTENUTO'", "'SOFT'", "'RESONANCE'", 
			"'REVERB'", "'TREMOLO'", "'CHORUS'", "'PHRASER'", null, "'SET'", "'PLAY'", 
			"'PAUSE'", "'+='", "'/='", "'*='", "'-='", "'('", "')'", "'=='", "'!='", 
			"'>'", "'<'", "'>='", "'<='", "'/'", "'*'", "'+'", "'-'", "'%'", "'AND'", 
			"'OR'", "'NOT'", "'up'", null, null, null, null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "IMPORT", "INCLUDE", 
			"INT", "BOOL", "CHORD", "NOTE", "TRACK", "BOOL_VAL", "INT_VAL", "NOTE_VAL", 
			"STRING_VAL", "ESC", "LIB_VAL", "PACE", "DISTORTION", "VOLUME", "JAZZ", 
			"BLUES", "INSTRUMENT", "SUSTAIN", "VIBRATO", "BALANCE", "SOSTENUTO", 
			"SOFT", "RESONANCE", "REVERB", "TREMOLO", "CHORUS", "PHRASER", "INSTRUMENT_VALUE", 
			"SET", "PLAY", "PAUSE", "SUMIS", "DIVIS", "MULIS", "SUBIS", "LP", "RP", 
			"EQ", "NEQ", "GT", "LT", "GEQ", "LEQ", "DIV", "MUL", "ADD", "SUB", "PER", 
			"AND", "OR", "NOT", "PARENT", "LINE_COMMENT", "BLOCK_COMMENT", "ID", 
			"WS", "SEMICOLON"
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
		public List<IncludesContext> includes() {
			return getRuleContexts(IncludesContext.class);
		}
		public IncludesContext includes(int i) {
			return getRuleContext(IncludesContext.class,i);
		}
		public List<ImportsContext> imports() {
			return getRuleContexts(ImportsContext.class);
		}
		public ImportsContext imports(int i) {
			return getRuleContext(ImportsContext.class,i);
		}
		public GlobalVarsContext globalVars() {
			return getRuleContext(GlobalVarsContext.class,0);
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
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INCLUDE) {
				{
				{
				setState(108);
				includes();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(114);
				imports();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) {
				{
				setState(120);
				globalVars();
				}
			}

			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(123);
					functionDecl();
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(129);
				mainDecl();
				}
			}

			setState(132);
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
	public static class GlobalVarsContext extends ParserRuleContext {
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MusicParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MusicParser.SEMICOLON, i);
		}
		public GlobalVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterGlobalVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitGlobalVars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitGlobalVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalVarsContext globalVars() throws RecognitionException {
		GlobalVarsContext _localctx = new GlobalVarsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalVars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(134);
				varDecl();
				setState(135);
				match(SEMICOLON);
				}
				}
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0) );
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
	public static class IncludesContext extends ParserRuleContext {
		public TerminalNode INCLUDE() { return getToken(MusicParser.INCLUDE, 0); }
		public TerminalNode LIB_VAL() { return getToken(MusicParser.LIB_VAL, 0); }
		public TerminalNode SEMICOLON() { return getToken(MusicParser.SEMICOLON, 0); }
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public IncludesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterIncludes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitIncludes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitIncludes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludesContext includes() throws RecognitionException {
		IncludesContext _localctx = new IncludesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_includes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(INCLUDE);
			setState(142);
			match(LIB_VAL);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(143);
				match(T__0);
				setState(144);
				match(ID);
				}
			}

			setState(147);
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
		enterRule(_localctx, 6, RULE_imports);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(IMPORT);
			setState(150);
			match(STRING_VAL);
			setState(151);
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
		enterRule(_localctx, 8, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__1);
			setState(154);
			match(ID);
			setState(155);
			match(LP);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) {
				{
				setState(156);
				parameters();
				}
			}

			setState(159);
			match(RP);
			setState(160);
			match(T__2);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 305118859579847052L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 611L) != 0)) {
				{
				{
				setState(161);
				statement();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167);
			match(T__3);
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
		enterRule(_localctx, 10, RULE_mainDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__1);
			setState(170);
			match(T__4);
			setState(171);
			match(LP);
			setState(172);
			match(RP);
			setState(173);
			match(T__2);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 305118859714064780L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 611L) != 0)) {
				{
				{
				setState(174);
				mainStatement();
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180);
			match(T__3);
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
		enterRule(_localctx, 12, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			parameter();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(183);
				match(T__5);
				setState(184);
				parameter();
				}
				}
				setState(189);
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
		enterRule(_localctx, 14, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			type();
			setState(191);
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
		enterRule(_localctx, 16, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 125829120L) != 0)) ) {
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
		enterRule(_localctx, 18, RULE_mainStatement);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
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
		public ExprStatementContext exprStatement() {
			return getRuleContext(ExprStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
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
		enterRule(_localctx, 20, RULE_statement);
		try {
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				functionDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				assignment();
				setState(201);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				selfAssignment();
				setState(204);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(206);
				settings();
				setState(207);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(209);
				varDecl();
				setState(210);
				match(SEMICOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(212);
				playStatement();
				setState(213);
				match(SEMICOLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(215);
				pauseStatement();
				setState(216);
				match(SEMICOLON);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(218);
				controlStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(219);
				exprStatement();
				setState(220);
				match(SEMICOLON);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(222);
				returnStatement();
				setState(223);
				match(SEMICOLON);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(225);
				continueStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(226);
				breakStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(227);
				scope();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(228);
				print();
				setState(229);
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
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(MusicParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(MusicParser.RP, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(T__6);
			setState(234);
			match(LP);
			setState(235);
			expr(0);
			setState(236);
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
		enterRule(_localctx, 24, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(T__7);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & 687925946887379969L) != 0)) {
				{
				setState(239);
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
		enterRule(_localctx, 26, RULE_exprStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
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
		enterRule(_localctx, 28, RULE_settings);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(SET);
			setState(245);
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		enterRule(_localctx, 30, RULE_settingsAssigment);
		int _la;
		try {
			setState(439);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PACE:
				_localctx = new PaceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				match(PACE);
				setState(248);
				match(T__8);
				setState(257);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(249);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(250);
						parent();
						}
						}
						setState(255);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(256);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case SUSTAIN:
				_localctx = new SustainContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				match(SUSTAIN);
				setState(260);
				match(T__8);
				setState(269);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(261);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(265);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(262);
						parent();
						}
						}
						setState(267);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(268);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case INSTRUMENT:
				_localctx = new InstrumentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(271);
				match(INSTRUMENT);
				setState(272);
				match(T__8);
				setState(281);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INSTRUMENT_VALUE:
					{
					setState(273);
					match(INSTRUMENT_VALUE);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(274);
						parent();
						}
						}
						setState(279);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(280);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case DISTORTION:
				_localctx = new DistortionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(283);
				match(DISTORTION);
				setState(284);
				match(T__8);
				setState(293);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(285);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(286);
						parent();
						}
						}
						setState(291);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(292);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case JAZZ:
				_localctx = new JazzContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(295);
				match(JAZZ);
				setState(296);
				match(T__8);
				setState(305);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_VAL:
					{
					setState(297);
					match(BOOL_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(301);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(298);
						parent();
						}
						}
						setState(303);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(304);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case BLUES:
				_localctx = new BluesContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(307);
				match(BLUES);
				setState(308);
				match(T__8);
				setState(317);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL_VAL:
					{
					setState(309);
					match(BOOL_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(313);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(310);
						parent();
						}
						}
						setState(315);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(316);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case VOLUME:
				_localctx = new VolumeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(319);
				match(VOLUME);
				setState(320);
				match(T__8);
				setState(329);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(321);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(325);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(322);
						parent();
						}
						}
						setState(327);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(328);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case VIBRATO:
				_localctx = new VibratoContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(331);
				match(VIBRATO);
				setState(332);
				match(T__8);
				setState(341);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(333);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(334);
						parent();
						}
						}
						setState(339);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(340);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case BALANCE:
				_localctx = new BalanceContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(343);
				match(BALANCE);
				setState(344);
				match(T__8);
				setState(353);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(345);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(349);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(346);
						parent();
						}
						}
						setState(351);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(352);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case SOSTENUTO:
				_localctx = new SostenutoPedalContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(355);
				match(SOSTENUTO);
				setState(356);
				match(T__8);
				setState(365);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(357);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(361);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(358);
						parent();
						}
						}
						setState(363);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(364);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case SOFT:
				_localctx = new SoftPedalContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(367);
				match(SOFT);
				setState(368);
				match(T__8);
				setState(377);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(369);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(373);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(370);
						parent();
						}
						}
						setState(375);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(376);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case RESONANCE:
				_localctx = new ResonanceContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(379);
				match(RESONANCE);
				setState(380);
				match(T__8);
				setState(389);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(381);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(385);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(382);
						parent();
						}
						}
						setState(387);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(388);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case REVERB:
				_localctx = new ReverbContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(391);
				match(REVERB);
				setState(392);
				match(T__8);
				setState(401);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(393);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(397);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(394);
						parent();
						}
						}
						setState(399);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(400);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case TREMOLO:
				_localctx = new TremoloContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(403);
				match(TREMOLO);
				setState(404);
				match(T__8);
				setState(413);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(405);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(409);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(406);
						parent();
						}
						}
						setState(411);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(412);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case CHORUS:
				_localctx = new ChorusContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(415);
				match(CHORUS);
				setState(416);
				match(T__8);
				setState(425);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(417);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(421);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(418);
						parent();
						}
						}
						setState(423);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(424);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case PHRASER:
				_localctx = new PhraserContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(427);
				match(PHRASER);
				setState(428);
				match(T__8);
				setState(437);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(429);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(433);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(430);
						parent();
						}
						}
						setState(435);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(436);
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
		enterRule(_localctx, 32, RULE_settingsValues);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125882726973440L) != 0)) ) {
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
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
		enterRule(_localctx, 34, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PARENT) {
				{
				{
				setState(443);
				parent();
				}
				}
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(449);
			match(ID);
			setState(450);
			match(T__8);
			setState(451);
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
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
		enterRule(_localctx, 36, RULE_selfAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PARENT) {
				{
				{
				setState(453);
				parent();
				}
				}
				setState(458);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(459);
			match(ID);
			setState(460);
			assOp();
			setState(461);
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
		enterRule(_localctx, 38, RULE_varDecl);
		try {
			setState(471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				_localctx = new VarDeclWithARgContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(463);
				type();
				setState(464);
				match(ID);
				setState(465);
				match(T__8);
				setState(466);
				expr(0);
				}
				break;
			case 2:
				_localctx = new VarDeclWithoutArgContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
				type();
				setState(469);
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
		enterRule(_localctx, 40, RULE_playStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			match(PLAY);
			setState(474);
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
		public List<ParentIDContext> parentID() {
			return getRuleContexts(ParentIDContext.class);
		}
		public ParentIDContext parentID(int i) {
			return getRuleContext(ParentIDContext.class,i);
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		enterRule(_localctx, 42, RULE_playValues);
		int _la;
		try {
			setState(519);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				_localctx = new PlayNoteContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(476);
				match(NOTE_VAL);
				setState(485);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(477);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(481);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(478);
						parent();
						}
						}
						setState(483);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(484);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				_localctx = new PlayChordContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(487);
				chord();
				setState(496);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(488);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(492);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(489);
						parent();
						}
						}
						setState(494);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(495);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				_localctx = new PlayFuncContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(498);
				functionCall();
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(499);
					match(T__9);
					setState(503);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(500);
						parent();
						}
						}
						setState(505);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(506);
					match(ID);
					}
				}

				}
				break;
			case 4:
				_localctx = new PlayIDVariantsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(509);
				parentID();
				setState(512);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_VAL:
					{
					setState(510);
					match(INT_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(511);
					parentID();
					}
					break;
				case RP:
				case SEMICOLON:
					break;
				default:
					break;
				}
				}
				break;
			case 5:
				_localctx = new PlayMultiContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(515); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(514);
					multiPlayValues();
					}
					}
					setState(517); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & 648518346341355521L) != 0) );
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
		public List<ParentIDContext> parentID() {
			return getRuleContexts(ParentIDContext.class);
		}
		public ParentIDContext parentID(int i) {
			return getRuleContext(ParentIDContext.class,i);
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
		enterRule(_localctx, 44, RULE_multiPlayValues);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(524); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(524);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NOTE_VAL:
						{
						setState(521);
						match(NOTE_VAL);
						}
						break;
					case T__17:
						{
						setState(522);
						chord();
						}
						break;
					case PARENT:
					case ID:
						{
						setState(523);
						parentID();
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
				setState(526); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(530);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAL:
				{
				setState(528);
				match(INT_VAL);
				}
				break;
			case PARENT:
			case ID:
				{
				setState(529);
				parentID();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		enterRule(_localctx, 46, RULE_pauseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			match(PAUSE);
			setState(541);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_VAL:
				{
				setState(533);
				match(INT_VAL);
				}
				break;
			case PARENT:
			case ID:
				{
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PARENT) {
					{
					{
					setState(534);
					parent();
					}
					}
					setState(539);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(540);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 48, RULE_controlStatement);
		int _la;
		try {
			int _alt;
			setState(554);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__12:
				_localctx = new LoopStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(543);
				loop();
				}
				break;
			case T__13:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(544);
				if_();
				setState(548);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(545);
						elseif();
						}
						} 
					}
					setState(550);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				}
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(551);
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
	public static class ScopeContext extends ParserRuleContext {
		public LoopBodyContext loopBody() {
			return getRuleContext(LoopBodyContext.class,0);
		}
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_scope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			match(T__2);
			setState(557);
			loopBody();
			setState(558);
			match(T__3);
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
	public static class ParentContext extends ParserRuleContext {
		public TerminalNode PARENT() { return getToken(MusicParser.PARENT, 0); }
		public ParentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitParent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitParent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParentContext parent() throws RecognitionException {
		ParentContext _localctx = new ParentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_parent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			match(PARENT);
			setState(561);
			match(T__10);
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
	public static class ParentIDContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MusicParser.ID, 0); }
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
		public ParentIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterParentID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitParentID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitParentID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParentIDContext parentID() throws RecognitionException {
		ParentIDContext _localctx = new ParentIDContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_parentID);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PARENT) {
				{
				{
				setState(563);
				parent();
				}
				}
				setState(568);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(569);
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
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
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
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
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
		enterRule(_localctx, 56, RULE_loop);
		int _la;
		try {
			setState(592);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(571);
				match(T__11);
				setState(572);
				match(LP);
				setState(573);
				expr(0);
				setState(574);
				match(RP);
				setState(575);
				scope();
				}
				break;
			case T__12:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(577);
				match(T__12);
				setState(578);
				match(LP);
				setState(580);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & 20266198323167247L) != 0)) {
					{
					setState(579);
					forInit();
					}
				}

				setState(582);
				match(SEMICOLON);
				setState(584);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & 687925946887379969L) != 0)) {
					{
					setState(583);
					expr(0);
					}
				}

				setState(586);
				match(SEMICOLON);
				setState(588);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & 37748737L) != 0)) {
					{
					setState(587);
					forUpdate();
					}
				}

				setState(590);
				match(RP);
				setState(591);
				scope();
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
		enterRule(_localctx, 58, RULE_loopBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(594);
				statement();
				}
				}
				setState(597); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 305118859579847052L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 611L) != 0) );
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
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
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
		enterRule(_localctx, 60, RULE_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			match(T__13);
			setState(600);
			match(LP);
			setState(601);
			expr(0);
			setState(602);
			match(RP);
			setState(603);
			scope();
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
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
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
		enterRule(_localctx, 62, RULE_elseif);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			match(T__14);
			setState(606);
			match(T__13);
			setState(607);
			match(LP);
			setState(608);
			expr(0);
			setState(609);
			match(RP);
			setState(610);
			scope();
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
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
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
		enterRule(_localctx, 64, RULE_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			match(T__14);
			setState(613);
			scope();
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
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
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
		enterRule(_localctx, 66, RULE_forInit);
		try {
			setState(617);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARENT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(615);
				assignment();
				}
				break;
			case INT:
			case BOOL:
			case CHORD:
			case NOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(616);
				varDecl();
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
		enterRule(_localctx, 68, RULE_forUpdate);
		try {
			setState(621);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLAY:
				enterOuterAlt(_localctx, 1);
				{
				setState(619);
				playStatement();
				}
				break;
			case PARENT:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(620);
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
		enterRule(_localctx, 70, RULE_forAssignment);
		try {
			setState(625);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(623);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(624);
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
		enterRule(_localctx, 72, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			match(T__15);
			setState(628);
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
		enterRule(_localctx, 74, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			match(T__16);
			setState(631);
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
		enterRule(_localctx, 76, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			match(ID);
			setState(634);
			match(LP);
			setState(636);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				setState(635);
				arguments();
				}
				break;
			}
			setState(639);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(638);
				match(T__5);
				}
			}

			setState(642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125882726973440L) != 0)) {
				{
				setState(641);
				settingsList();
				}
			}

			setState(644);
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
		enterRule(_localctx, 78, RULE_arguments);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			expr(0);
			setState(651);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(647);
					match(T__5);
					setState(648);
					expr(0);
					}
					} 
				}
				setState(653);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
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
		enterRule(_localctx, 80, RULE_settingsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(654);
			settingsAssigment();
			setState(659);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(655);
				match(T__5);
				setState(656);
				settingsAssigment();
				}
				}
				setState(661);
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
	public static class CastExprContext extends ExprContext {
		public TerminalNode LP() { return getToken(MusicParser.LP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RP() { return getToken(MusicParser.RP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CastExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).enterCastExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicListener ) ((MusicListener)listener).exitCastExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicVisitor ) return ((MusicVisitor<? extends T>)visitor).visitCastExpr(this);
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
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
		}
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
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				{
				_localctx = new ParanthesesExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(663);
				match(LP);
				setState(664);
				expr(0);
				setState(665);
				match(RP);
				}
				break;
			case 2:
				{
				_localctx = new CastExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(667);
				match(LP);
				setState(668);
				type();
				setState(669);
				match(RP);
				setState(670);
				expr(15);
				}
				break;
			case 3:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(672);
				match(NOT);
				setState(673);
				expr(14);
				}
				break;
			case 4:
				{
				_localctx = new InstrumentOperatorExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(674);
				match(INSTRUMENT);
				setState(675);
				eqOp();
				setState(676);
				match(INSTRUMENT_VALUE);
				}
				break;
			case 5:
				{
				_localctx = new ChordExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(678);
				chord();
				}
				break;
			case 6:
				{
				_localctx = new SettingsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(679);
				settingsValues();
				}
				break;
			case 7:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(680);
				intVal();
				}
				break;
			case 8:
				{
				_localctx = new BoolExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(681);
				match(BOOL_VAL);
				}
				break;
			case 9:
				{
				_localctx = new NoteExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(682);
				match(NOTE_VAL);
				}
				break;
			case 10:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(686);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PARENT) {
					{
					{
					setState(683);
					parent();
					}
					}
					setState(688);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(689);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(718);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(716);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
					case 1:
						{
						_localctx = new MullDivOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(692);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(693);
						mullDivOp();
						setState(694);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new AddSubOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(696);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(697);
						addSubOp();
						setState(698);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new OrderOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(700);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(701);
						orderOp();
						setState(702);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new EqOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(704);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(705);
						eqOp();
						setState(706);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new AndOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(708);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(709);
						andOp();
						setState(710);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new OrOperatorExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(712);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(713);
						orOp();
						setState(714);
						expr(9);
						}
						break;
					}
					} 
				}
				setState(720);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
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
		enterRule(_localctx, 84, RULE_orderOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
			_la = _input.LA(1);
			if ( !(((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & 15L) != 0)) ) {
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
		enterRule(_localctx, 86, RULE_eqOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(723);
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
		enterRule(_localctx, 88, RULE_andOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
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
		enterRule(_localctx, 90, RULE_orOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(727);
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
		enterRule(_localctx, 92, RULE_addSubOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729);
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
		enterRule(_localctx, 94, RULE_mullDivOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
			_la = _input.LA(1);
			if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 19L) != 0)) ) {
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
		enterRule(_localctx, 96, RULE_assOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(733);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 270215977642229760L) != 0)) ) {
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
		public List<TerminalNode> ID() { return getTokens(MusicParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MusicParser.ID, i);
		}
		public List<ParentContext> parent() {
			return getRuleContexts(ParentContext.class);
		}
		public ParentContext parent(int i) {
			return getRuleContext(ParentContext.class,i);
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
		enterRule(_localctx, 98, RULE_chord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			match(T__17);
			setState(744);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTE_VAL:
				{
				setState(736);
				match(NOTE_VAL);
				}
				break;
			case PARENT:
			case ID:
				{
				setState(740);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==PARENT) {
					{
					{
					setState(737);
					parent();
					}
					}
					setState(742);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(743);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(757); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(746);
				match(T__5);
				setState(755);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOTE_VAL:
					{
					setState(747);
					match(NOTE_VAL);
					}
					break;
				case PARENT:
				case ID:
					{
					setState(751);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==PARENT) {
						{
						{
						setState(748);
						parent();
						}
						}
						setState(753);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(754);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(759); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__5 );
			setState(761);
			match(T__18);
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
		enterRule(_localctx, 100, RULE_trackStatements);
		try {
			setState(765);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new TrackAddContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(763);
				trackStatement();
				}
				break;
			case TRACK:
				_localctx = new TrackDeclareContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(764);
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
		enterRule(_localctx, 102, RULE_trackStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			match(ID);
			setState(768);
			match(T__19);
			setState(769);
			functionCall();
			setState(770);
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
		enterRule(_localctx, 104, RULE_trackDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772);
			match(TRACK);
			setState(773);
			match(ID);
			setState(774);
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
		enterRule(_localctx, 106, RULE_intVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(777);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD || _la==SUB) {
				{
				setState(776);
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

			setState(779);
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
		case 41:
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
		"\u0004\u0001O\u030e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u0001\u0000\u0005\u0000"+
		"n\b\u0000\n\u0000\f\u0000q\t\u0000\u0001\u0000\u0005\u0000t\b\u0000\n"+
		"\u0000\f\u0000w\t\u0000\u0001\u0000\u0003\u0000z\b\u0000\u0001\u0000\u0005"+
		"\u0000}\b\u0000\n\u0000\f\u0000\u0080\t\u0000\u0001\u0000\u0003\u0000"+
		"\u0083\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0004\u0001\u008a\b\u0001\u000b\u0001\f\u0001\u008b\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0092\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u009e\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004\u00a3\b\u0004\n\u0004\f\u0004\u00a6\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u00b0\b\u0005\n\u0005\f\u0005\u00b3"+
		"\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u00ba\b\u0006\n\u0006\f\u0006\u00bd\t\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u00c6\b\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00e8\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0003\f\u00f1"+
		"\b\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00fc\b\u000f\n\u000f\f\u000f"+
		"\u00ff\t\u000f\u0001\u000f\u0003\u000f\u0102\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0108\b\u000f\n\u000f\f\u000f"+
		"\u010b\t\u000f\u0001\u000f\u0003\u000f\u010e\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0114\b\u000f\n\u000f\f\u000f"+
		"\u0117\t\u000f\u0001\u000f\u0003\u000f\u011a\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0120\b\u000f\n\u000f\f\u000f"+
		"\u0123\t\u000f\u0001\u000f\u0003\u000f\u0126\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u012c\b\u000f\n\u000f\f\u000f"+
		"\u012f\t\u000f\u0001\u000f\u0003\u000f\u0132\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0138\b\u000f\n\u000f\f\u000f"+
		"\u013b\t\u000f\u0001\u000f\u0003\u000f\u013e\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0144\b\u000f\n\u000f\f\u000f"+
		"\u0147\t\u000f\u0001\u000f\u0003\u000f\u014a\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0150\b\u000f\n\u000f\f\u000f"+
		"\u0153\t\u000f\u0001\u000f\u0003\u000f\u0156\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u015c\b\u000f\n\u000f\f\u000f"+
		"\u015f\t\u000f\u0001\u000f\u0003\u000f\u0162\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0168\b\u000f\n\u000f\f\u000f"+
		"\u016b\t\u000f\u0001\u000f\u0003\u000f\u016e\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0174\b\u000f\n\u000f\f\u000f"+
		"\u0177\t\u000f\u0001\u000f\u0003\u000f\u017a\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0180\b\u000f\n\u000f\f\u000f"+
		"\u0183\t\u000f\u0001\u000f\u0003\u000f\u0186\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u018c\b\u000f\n\u000f\f\u000f"+
		"\u018f\t\u000f\u0001\u000f\u0003\u000f\u0192\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0198\b\u000f\n\u000f\f\u000f"+
		"\u019b\t\u000f\u0001\u000f\u0003\u000f\u019e\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u01a4\b\u000f\n\u000f\f\u000f"+
		"\u01a7\t\u000f\u0001\u000f\u0003\u000f\u01aa\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u01b0\b\u000f\n\u000f\f\u000f"+
		"\u01b3\t\u000f\u0001\u000f\u0003\u000f\u01b6\b\u000f\u0003\u000f\u01b8"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0005\u0011\u01bd\b\u0011"+
		"\n\u0011\f\u0011\u01c0\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0005\u0012\u01c7\b\u0012\n\u0012\f\u0012\u01ca\t\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u01d8\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0005\u0015\u01e0\b\u0015\n\u0015\f\u0015\u01e3"+
		"\t\u0015\u0001\u0015\u0003\u0015\u01e6\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0005\u0015\u01eb\b\u0015\n\u0015\f\u0015\u01ee\t\u0015\u0001"+
		"\u0015\u0003\u0015\u01f1\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005"+
		"\u0015\u01f6\b\u0015\n\u0015\f\u0015\u01f9\t\u0015\u0001\u0015\u0003\u0015"+
		"\u01fc\b\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0201\b"+
		"\u0015\u0001\u0015\u0004\u0015\u0204\b\u0015\u000b\u0015\f\u0015\u0205"+
		"\u0003\u0015\u0208\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0004\u0016"+
		"\u020d\b\u0016\u000b\u0016\f\u0016\u020e\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u0213\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0218"+
		"\b\u0017\n\u0017\f\u0017\u021b\t\u0017\u0001\u0017\u0003\u0017\u021e\b"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0223\b\u0018\n"+
		"\u0018\f\u0018\u0226\t\u0018\u0001\u0018\u0003\u0018\u0229\b\u0018\u0003"+
		"\u0018\u022b\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0005\u001b\u0235\b\u001b\n"+
		"\u001b\f\u001b\u0238\t\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u0245\b\u001c\u0001\u001c\u0001\u001c\u0003"+
		"\u001c\u0249\b\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u024d\b\u001c"+
		"\u0001\u001c\u0001\u001c\u0003\u001c\u0251\b\u001c\u0001\u001d\u0004\u001d"+
		"\u0254\b\u001d\u000b\u001d\f\u001d\u0255\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		" \u0001!\u0001!\u0003!\u026a\b!\u0001\"\u0001\"\u0003\"\u026e\b\"\u0001"+
		"#\u0001#\u0003#\u0272\b#\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001"+
		"&\u0001&\u0001&\u0003&\u027d\b&\u0001&\u0003&\u0280\b&\u0001&\u0003&\u0283"+
		"\b&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0005\'\u028a\b\'\n\'\f\'\u028d"+
		"\t\'\u0001(\u0001(\u0001(\u0005(\u0292\b(\n(\f(\u0295\t(\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0005)\u02ad\b)\n)\f)\u02b0\t)\u0001)\u0003)\u02b3\b)\u0001)\u0001)"+
		"\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0005)\u02cd\b)\n)\f)\u02d0\t)\u0001*\u0001*\u0001+\u0001"+
		"+\u0001,\u0001,\u0001-\u0001-\u0001.\u0001.\u0001/\u0001/\u00010\u0001"+
		"0\u00011\u00011\u00011\u00051\u02e3\b1\n1\f1\u02e6\t1\u00011\u00031\u02e9"+
		"\b1\u00011\u00011\u00011\u00051\u02ee\b1\n1\f1\u02f1\t1\u00011\u00031"+
		"\u02f4\b1\u00041\u02f6\b1\u000b1\f1\u02f7\u00011\u00011\u00012\u00012"+
		"\u00032\u02fe\b2\u00013\u00013\u00013\u00013\u00013\u00014\u00014\u0001"+
		"4\u00014\u00015\u00035\u030a\b5\u00015\u00015\u00015\u0000\u0001R6\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhj\u0000\u0007\u0001\u0000"+
		"\u0017\u001a\u0001\u0000\"1\u0001\u0000>A\u0001\u0000<=\u0001\u0000DE"+
		"\u0002\u0000BCFF\u0001\u000069\u035e\u0000o\u0001\u0000\u0000\u0000\u0002"+
		"\u0089\u0001\u0000\u0000\u0000\u0004\u008d\u0001\u0000\u0000\u0000\u0006"+
		"\u0095\u0001\u0000\u0000\u0000\b\u0099\u0001\u0000\u0000\u0000\n\u00a9"+
		"\u0001\u0000\u0000\u0000\f\u00b6\u0001\u0000\u0000\u0000\u000e\u00be\u0001"+
		"\u0000\u0000\u0000\u0010\u00c1\u0001\u0000\u0000\u0000\u0012\u00c5\u0001"+
		"\u0000\u0000\u0000\u0014\u00e7\u0001\u0000\u0000\u0000\u0016\u00e9\u0001"+
		"\u0000\u0000\u0000\u0018\u00ee\u0001\u0000\u0000\u0000\u001a\u00f2\u0001"+
		"\u0000\u0000\u0000\u001c\u00f4\u0001\u0000\u0000\u0000\u001e\u01b7\u0001"+
		"\u0000\u0000\u0000 \u01b9\u0001\u0000\u0000\u0000\"\u01be\u0001\u0000"+
		"\u0000\u0000$\u01c8\u0001\u0000\u0000\u0000&\u01d7\u0001\u0000\u0000\u0000"+
		"(\u01d9\u0001\u0000\u0000\u0000*\u0207\u0001\u0000\u0000\u0000,\u020c"+
		"\u0001\u0000\u0000\u0000.\u0214\u0001\u0000\u0000\u00000\u022a\u0001\u0000"+
		"\u0000\u00002\u022c\u0001\u0000\u0000\u00004\u0230\u0001\u0000\u0000\u0000"+
		"6\u0236\u0001\u0000\u0000\u00008\u0250\u0001\u0000\u0000\u0000:\u0253"+
		"\u0001\u0000\u0000\u0000<\u0257\u0001\u0000\u0000\u0000>\u025d\u0001\u0000"+
		"\u0000\u0000@\u0264\u0001\u0000\u0000\u0000B\u0269\u0001\u0000\u0000\u0000"+
		"D\u026d\u0001\u0000\u0000\u0000F\u0271\u0001\u0000\u0000\u0000H\u0273"+
		"\u0001\u0000\u0000\u0000J\u0276\u0001\u0000\u0000\u0000L\u0279\u0001\u0000"+
		"\u0000\u0000N\u0286\u0001\u0000\u0000\u0000P\u028e\u0001\u0000\u0000\u0000"+
		"R\u02b2\u0001\u0000\u0000\u0000T\u02d1\u0001\u0000\u0000\u0000V\u02d3"+
		"\u0001\u0000\u0000\u0000X\u02d5\u0001\u0000\u0000\u0000Z\u02d7\u0001\u0000"+
		"\u0000\u0000\\\u02d9\u0001\u0000\u0000\u0000^\u02db\u0001\u0000\u0000"+
		"\u0000`\u02dd\u0001\u0000\u0000\u0000b\u02df\u0001\u0000\u0000\u0000d"+
		"\u02fd\u0001\u0000\u0000\u0000f\u02ff\u0001\u0000\u0000\u0000h\u0304\u0001"+
		"\u0000\u0000\u0000j\u0309\u0001\u0000\u0000\u0000ln\u0003\u0004\u0002"+
		"\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000"+
		"\u0000\u0000op\u0001\u0000\u0000\u0000pu\u0001\u0000\u0000\u0000qo\u0001"+
		"\u0000\u0000\u0000rt\u0003\u0006\u0003\u0000sr\u0001\u0000\u0000\u0000"+
		"tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xz\u0003\u0002"+
		"\u0001\u0000yx\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z~\u0001"+
		"\u0000\u0000\u0000{}\u0003\b\u0004\u0000|{\u0001\u0000\u0000\u0000}\u0080"+
		"\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000"+
		"\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000"+
		"\u0000\u0081\u0083\u0003\n\u0005\u0000\u0082\u0081\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0005\u0000\u0000\u0001\u0085\u0001\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0003&\u0013\u0000\u0087\u0088\u0005O\u0000\u0000\u0088\u008a"+
		"\u0001\u0000\u0000\u0000\u0089\u0086\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0001\u0000\u0000\u0000\u008c\u0003\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0005\u0016\u0000\u0000\u008e\u0091\u0005!\u0000\u0000\u008f\u0090\u0005"+
		"\u0001\u0000\u0000\u0090\u0092\u0005M\u0000\u0000\u0091\u008f\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0005O\u0000\u0000\u0094\u0005\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0005\u0015\u0000\u0000\u0096\u0097\u0005\u001f\u0000"+
		"\u0000\u0097\u0098\u0005O\u0000\u0000\u0098\u0007\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0005\u0002\u0000\u0000\u009a\u009b\u0005M\u0000\u0000\u009b"+
		"\u009d\u0005:\u0000\u0000\u009c\u009e\u0003\f\u0006\u0000\u009d\u009c"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0005;\u0000\u0000\u00a0\u00a4\u0005"+
		"\u0003\u0000\u0000\u00a1\u00a3\u0003\u0014\n\u0000\u00a2\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0004"+
		"\u0000\u0000\u00a8\t\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0002\u0000"+
		"\u0000\u00aa\u00ab\u0005\u0005\u0000\u0000\u00ab\u00ac\u0005:\u0000\u0000"+
		"\u00ac\u00ad\u0005;\u0000\u0000\u00ad\u00b1\u0005\u0003\u0000\u0000\u00ae"+
		"\u00b0\u0003\u0012\t\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b4\u0001\u0000\u0000\u0000\u00b3\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005\u0004\u0000\u0000\u00b5\u000b"+
		"\u0001\u0000\u0000\u0000\u00b6\u00bb\u0003\u000e\u0007\u0000\u00b7\u00b8"+
		"\u0005\u0006\u0000\u0000\u00b8\u00ba\u0003\u000e\u0007\u0000\u00b9\u00b7"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000\u00bb\u00b9"+
		"\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\r\u0001"+
		"\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be\u00bf\u0003"+
		"\u0010\b\u0000\u00bf\u00c0\u0005M\u0000\u0000\u00c0\u000f\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0007\u0000\u0000\u0000\u00c2\u0011\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c6\u0003\u0014\n\u0000\u00c4\u00c6\u0003d2\u0000"+
		"\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c6\u0013\u0001\u0000\u0000\u0000\u00c7\u00e8\u0003\b\u0004\u0000\u00c8"+
		"\u00c9\u0003\"\u0011\u0000\u00c9\u00ca\u0005O\u0000\u0000\u00ca\u00e8"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cc\u0003$\u0012\u0000\u00cc\u00cd\u0005"+
		"O\u0000\u0000\u00cd\u00e8\u0001\u0000\u0000\u0000\u00ce\u00cf\u0003\u001c"+
		"\u000e\u0000\u00cf\u00d0\u0005O\u0000\u0000\u00d0\u00e8\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0003&\u0013\u0000\u00d2\u00d3\u0005O\u0000\u0000\u00d3"+
		"\u00e8\u0001\u0000\u0000\u0000\u00d4\u00d5\u0003(\u0014\u0000\u00d5\u00d6"+
		"\u0005O\u0000\u0000\u00d6\u00e8\u0001\u0000\u0000\u0000\u00d7\u00d8\u0003"+
		".\u0017\u0000\u00d8\u00d9\u0005O\u0000\u0000\u00d9\u00e8\u0001\u0000\u0000"+
		"\u0000\u00da\u00e8\u00030\u0018\u0000\u00db\u00dc\u0003\u001a\r\u0000"+
		"\u00dc\u00dd\u0005O\u0000\u0000\u00dd\u00e8\u0001\u0000\u0000\u0000\u00de"+
		"\u00df\u0003\u0018\f\u0000\u00df\u00e0\u0005O\u0000\u0000\u00e0\u00e8"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e8\u0003J%\u0000\u00e2\u00e8\u0003H"+
		"$\u0000\u00e3\u00e8\u00032\u0019\u0000\u00e4\u00e5\u0003\u0016\u000b\u0000"+
		"\u00e5\u00e6\u0005O\u0000\u0000\u00e6\u00e8\u0001\u0000\u0000\u0000\u00e7"+
		"\u00c7\u0001\u0000\u0000\u0000\u00e7\u00c8\u0001\u0000\u0000\u0000\u00e7"+
		"\u00cb\u0001\u0000\u0000\u0000\u00e7\u00ce\u0001\u0000\u0000\u0000\u00e7"+
		"\u00d1\u0001\u0000\u0000\u0000\u00e7\u00d4\u0001\u0000\u0000\u0000\u00e7"+
		"\u00d7\u0001\u0000\u0000\u0000\u00e7\u00da\u0001\u0000\u0000\u0000\u00e7"+
		"\u00db\u0001\u0000\u0000\u0000\u00e7\u00de\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e7\u00e2\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e7\u00e4\u0001\u0000\u0000\u0000\u00e8"+
		"\u0015\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005\u0007\u0000\u0000\u00ea"+
		"\u00eb\u0005:\u0000\u0000\u00eb\u00ec\u0003R)\u0000\u00ec\u00ed\u0005"+
		";\u0000\u0000\u00ed\u0017\u0001\u0000\u0000\u0000\u00ee\u00f0\u0005\b"+
		"\u0000\u0000\u00ef\u00f1\u0003R)\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u0019\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f3\u0003R)\u0000\u00f3\u001b\u0001\u0000\u0000\u0000\u00f4\u00f5"+
		"\u00053\u0000\u0000\u00f5\u00f6\u0003\u001e\u000f\u0000\u00f6\u001d\u0001"+
		"\u0000\u0000\u0000\u00f7\u00f8\u0005\"\u0000\u0000\u00f8\u0101\u0005\t"+
		"\u0000\u0000\u00f9\u0102\u0005\u001d\u0000\u0000\u00fa\u00fc\u00034\u001a"+
		"\u0000\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc\u00ff\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000"+
		"\u0000\u00fe\u0100\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000"+
		"\u0000\u0100\u0102\u0005M\u0000\u0000\u0101\u00f9\u0001\u0000\u0000\u0000"+
		"\u0101\u00fd\u0001\u0000\u0000\u0000\u0102\u01b8\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0005(\u0000\u0000\u0104\u010d\u0005\t\u0000\u0000\u0105"+
		"\u010e\u0005\u001d\u0000\u0000\u0106\u0108\u00034\u001a\u0000\u0107\u0106"+
		"\u0001\u0000\u0000\u0000\u0108\u010b\u0001\u0000\u0000\u0000\u0109\u0107"+
		"\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010c"+
		"\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c\u010e"+
		"\u0005M\u0000\u0000\u010d\u0105\u0001\u0000\u0000\u0000\u010d\u0109\u0001"+
		"\u0000\u0000\u0000\u010e\u01b8\u0001\u0000\u0000\u0000\u010f\u0110\u0005"+
		"\'\u0000\u0000\u0110\u0119\u0005\t\u0000\u0000\u0111\u011a\u00052\u0000"+
		"\u0000\u0112\u0114\u00034\u001a\u0000\u0113\u0112\u0001\u0000\u0000\u0000"+
		"\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0118\u0001\u0000\u0000\u0000"+
		"\u0117\u0115\u0001\u0000\u0000\u0000\u0118\u011a\u0005M\u0000\u0000\u0119"+
		"\u0111\u0001\u0000\u0000\u0000\u0119\u0115\u0001\u0000\u0000\u0000\u011a"+
		"\u01b8\u0001\u0000\u0000\u0000\u011b\u011c\u0005#\u0000\u0000\u011c\u0125"+
		"\u0005\t\u0000\u0000\u011d\u0126\u0005\u001d\u0000\u0000\u011e\u0120\u0003"+
		"4\u001a\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u0120\u0123\u0001\u0000"+
		"\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000"+
		"\u0000\u0000\u0122\u0124\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000"+
		"\u0000\u0000\u0124\u0126\u0005M\u0000\u0000\u0125\u011d\u0001\u0000\u0000"+
		"\u0000\u0125\u0121\u0001\u0000\u0000\u0000\u0126\u01b8\u0001\u0000\u0000"+
		"\u0000\u0127\u0128\u0005%\u0000\u0000\u0128\u0131\u0005\t\u0000\u0000"+
		"\u0129\u0132\u0005\u001c\u0000\u0000\u012a\u012c\u00034\u001a\u0000\u012b"+
		"\u012a\u0001\u0000\u0000\u0000\u012c\u012f\u0001\u0000\u0000\u0000\u012d"+
		"\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e"+
		"\u0130\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u0130"+
		"\u0132\u0005M\u0000\u0000\u0131\u0129\u0001\u0000\u0000\u0000\u0131\u012d"+
		"\u0001\u0000\u0000\u0000\u0132\u01b8\u0001\u0000\u0000\u0000\u0133\u0134"+
		"\u0005&\u0000\u0000\u0134\u013d\u0005\t\u0000\u0000\u0135\u013e\u0005"+
		"\u001c\u0000\u0000\u0136\u0138\u00034\u001a\u0000\u0137\u0136\u0001\u0000"+
		"\u0000\u0000\u0138\u013b\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000"+
		"\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013c\u0001\u0000"+
		"\u0000\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013c\u013e\u0005M\u0000"+
		"\u0000\u013d\u0135\u0001\u0000\u0000\u0000\u013d\u0139\u0001\u0000\u0000"+
		"\u0000\u013e\u01b8\u0001\u0000\u0000\u0000\u013f\u0140\u0005$\u0000\u0000"+
		"\u0140\u0149\u0005\t\u0000\u0000\u0141\u014a\u0005\u001d\u0000\u0000\u0142"+
		"\u0144\u00034\u001a\u0000\u0143\u0142\u0001\u0000\u0000\u0000\u0144\u0147"+
		"\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0145\u0146"+
		"\u0001\u0000\u0000\u0000\u0146\u0148\u0001\u0000\u0000\u0000\u0147\u0145"+
		"\u0001\u0000\u0000\u0000\u0148\u014a\u0005M\u0000\u0000\u0149\u0141\u0001"+
		"\u0000\u0000\u0000\u0149\u0145\u0001\u0000\u0000\u0000\u014a\u01b8\u0001"+
		"\u0000\u0000\u0000\u014b\u014c\u0005)\u0000\u0000\u014c\u0155\u0005\t"+
		"\u0000\u0000\u014d\u0156\u0005\u001d\u0000\u0000\u014e\u0150\u00034\u001a"+
		"\u0000\u014f\u014e\u0001\u0000\u0000\u0000\u0150\u0153\u0001\u0000\u0000"+
		"\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000"+
		"\u0000\u0152\u0154\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000\u0000"+
		"\u0000\u0154\u0156\u0005M\u0000\u0000\u0155\u014d\u0001\u0000\u0000\u0000"+
		"\u0155\u0151\u0001\u0000\u0000\u0000\u0156\u01b8\u0001\u0000\u0000\u0000"+
		"\u0157\u0158\u0005*\u0000\u0000\u0158\u0161\u0005\t\u0000\u0000\u0159"+
		"\u0162\u0005\u001d\u0000\u0000\u015a\u015c\u00034\u001a\u0000\u015b\u015a"+
		"\u0001\u0000\u0000\u0000\u015c\u015f\u0001\u0000\u0000\u0000\u015d\u015b"+
		"\u0001\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u0160"+
		"\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u0160\u0162"+
		"\u0005M\u0000\u0000\u0161\u0159\u0001\u0000\u0000\u0000\u0161\u015d\u0001"+
		"\u0000\u0000\u0000\u0162\u01b8\u0001\u0000\u0000\u0000\u0163\u0164\u0005"+
		"+\u0000\u0000\u0164\u016d\u0005\t\u0000\u0000\u0165\u016e\u0005\u001d"+
		"\u0000\u0000\u0166\u0168\u00034\u001a\u0000\u0167\u0166\u0001\u0000\u0000"+
		"\u0000\u0168\u016b\u0001\u0000\u0000\u0000\u0169\u0167\u0001\u0000\u0000"+
		"\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a\u016c\u0001\u0000\u0000"+
		"\u0000\u016b\u0169\u0001\u0000\u0000\u0000\u016c\u016e\u0005M\u0000\u0000"+
		"\u016d\u0165\u0001\u0000\u0000\u0000\u016d\u0169\u0001\u0000\u0000\u0000"+
		"\u016e\u01b8\u0001\u0000\u0000\u0000\u016f\u0170\u0005,\u0000\u0000\u0170"+
		"\u0179\u0005\t\u0000\u0000\u0171\u017a\u0005\u001d\u0000\u0000\u0172\u0174"+
		"\u00034\u001a\u0000\u0173\u0172\u0001\u0000\u0000\u0000\u0174\u0177\u0001"+
		"\u0000\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0175\u0176\u0001"+
		"\u0000\u0000\u0000\u0176\u0178\u0001\u0000\u0000\u0000\u0177\u0175\u0001"+
		"\u0000\u0000\u0000\u0178\u017a\u0005M\u0000\u0000\u0179\u0171\u0001\u0000"+
		"\u0000\u0000\u0179\u0175\u0001\u0000\u0000\u0000\u017a\u01b8\u0001\u0000"+
		"\u0000\u0000\u017b\u017c\u0005-\u0000\u0000\u017c\u0185\u0005\t\u0000"+
		"\u0000\u017d\u0186\u0005\u001d\u0000\u0000\u017e\u0180\u00034\u001a\u0000"+
		"\u017f\u017e\u0001\u0000\u0000\u0000\u0180\u0183\u0001\u0000\u0000\u0000"+
		"\u0181\u017f\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000\u0000\u0000"+
		"\u0182\u0184\u0001\u0000\u0000\u0000\u0183\u0181\u0001\u0000\u0000\u0000"+
		"\u0184\u0186\u0005M\u0000\u0000\u0185\u017d\u0001\u0000\u0000\u0000\u0185"+
		"\u0181\u0001\u0000\u0000\u0000\u0186\u01b8\u0001\u0000\u0000\u0000\u0187"+
		"\u0188\u0005.\u0000\u0000\u0188\u0191\u0005\t\u0000\u0000\u0189\u0192"+
		"\u0005\u001d\u0000\u0000\u018a\u018c\u00034\u001a\u0000\u018b\u018a\u0001"+
		"\u0000\u0000\u0000\u018c\u018f\u0001\u0000\u0000\u0000\u018d\u018b\u0001"+
		"\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018e\u0190\u0001"+
		"\u0000\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u0190\u0192\u0005"+
		"M\u0000\u0000\u0191\u0189\u0001\u0000\u0000\u0000\u0191\u018d\u0001\u0000"+
		"\u0000\u0000\u0192\u01b8\u0001\u0000\u0000\u0000\u0193\u0194\u0005/\u0000"+
		"\u0000\u0194\u019d\u0005\t\u0000\u0000\u0195\u019e\u0005\u001d\u0000\u0000"+
		"\u0196\u0198\u00034\u001a\u0000\u0197\u0196\u0001\u0000\u0000\u0000\u0198"+
		"\u019b\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u0199"+
		"\u019a\u0001\u0000\u0000\u0000\u019a\u019c\u0001\u0000\u0000\u0000\u019b"+
		"\u0199\u0001\u0000\u0000\u0000\u019c\u019e\u0005M\u0000\u0000\u019d\u0195"+
		"\u0001\u0000\u0000\u0000\u019d\u0199\u0001\u0000\u0000\u0000\u019e\u01b8"+
		"\u0001\u0000\u0000\u0000\u019f\u01a0\u00050\u0000\u0000\u01a0\u01a9\u0005"+
		"\t\u0000\u0000\u01a1\u01aa\u0005\u001d\u0000\u0000\u01a2\u01a4\u00034"+
		"\u001a\u0000\u01a3\u01a2\u0001\u0000\u0000\u0000\u01a4\u01a7\u0001\u0000"+
		"\u0000\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a5\u01a6\u0001\u0000"+
		"\u0000\u0000\u01a6\u01a8\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001\u0000"+
		"\u0000\u0000\u01a8\u01aa\u0005M\u0000\u0000\u01a9\u01a1\u0001\u0000\u0000"+
		"\u0000\u01a9\u01a5\u0001\u0000\u0000\u0000\u01aa\u01b8\u0001\u0000\u0000"+
		"\u0000\u01ab\u01ac\u00051\u0000\u0000\u01ac\u01b5\u0005\t\u0000\u0000"+
		"\u01ad\u01b6\u0005\u001d\u0000\u0000\u01ae\u01b0\u00034\u001a\u0000\u01af"+
		"\u01ae\u0001\u0000\u0000\u0000\u01b0\u01b3\u0001\u0000\u0000\u0000\u01b1"+
		"\u01af\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2"+
		"\u01b4\u0001\u0000\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b4"+
		"\u01b6\u0005M\u0000\u0000\u01b5\u01ad\u0001\u0000\u0000\u0000\u01b5\u01b1"+
		"\u0001\u0000\u0000\u0000\u01b6\u01b8\u0001\u0000\u0000\u0000\u01b7\u00f7"+
		"\u0001\u0000\u0000\u0000\u01b7\u0103\u0001\u0000\u0000\u0000\u01b7\u010f"+
		"\u0001\u0000\u0000\u0000\u01b7\u011b\u0001\u0000\u0000\u0000\u01b7\u0127"+
		"\u0001\u0000\u0000\u0000\u01b7\u0133\u0001\u0000\u0000\u0000\u01b7\u013f"+
		"\u0001\u0000\u0000\u0000\u01b7\u014b\u0001\u0000\u0000\u0000\u01b7\u0157"+
		"\u0001\u0000\u0000\u0000\u01b7\u0163\u0001\u0000\u0000\u0000\u01b7\u016f"+
		"\u0001\u0000\u0000\u0000\u01b7\u017b\u0001\u0000\u0000\u0000\u01b7\u0187"+
		"\u0001\u0000\u0000\u0000\u01b7\u0193\u0001\u0000\u0000\u0000\u01b7\u019f"+
		"\u0001\u0000\u0000\u0000\u01b7\u01ab\u0001\u0000\u0000\u0000\u01b8\u001f"+
		"\u0001\u0000\u0000\u0000\u01b9\u01ba\u0007\u0001\u0000\u0000\u01ba!\u0001"+
		"\u0000\u0000\u0000\u01bb\u01bd\u00034\u001a\u0000\u01bc\u01bb\u0001\u0000"+
		"\u0000\u0000\u01bd\u01c0\u0001\u0000\u0000\u0000\u01be\u01bc\u0001\u0000"+
		"\u0000\u0000\u01be\u01bf\u0001\u0000\u0000\u0000\u01bf\u01c1\u0001\u0000"+
		"\u0000\u0000\u01c0\u01be\u0001\u0000\u0000\u0000\u01c1\u01c2\u0005M\u0000"+
		"\u0000\u01c2\u01c3\u0005\t\u0000\u0000\u01c3\u01c4\u0003R)\u0000\u01c4"+
		"#\u0001\u0000\u0000\u0000\u01c5\u01c7\u00034\u001a\u0000\u01c6\u01c5\u0001"+
		"\u0000\u0000\u0000\u01c7\u01ca\u0001\u0000\u0000\u0000\u01c8\u01c6\u0001"+
		"\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000\u01c9\u01cb\u0001"+
		"\u0000\u0000\u0000\u01ca\u01c8\u0001\u0000\u0000\u0000\u01cb\u01cc\u0005"+
		"M\u0000\u0000\u01cc\u01cd\u0003`0\u0000\u01cd\u01ce\u0003R)\u0000\u01ce"+
		"%\u0001\u0000\u0000\u0000\u01cf\u01d0\u0003\u0010\b\u0000\u01d0\u01d1"+
		"\u0005M\u0000\u0000\u01d1\u01d2\u0005\t\u0000\u0000\u01d2\u01d3\u0003"+
		"R)\u0000\u01d3\u01d8\u0001\u0000\u0000\u0000\u01d4\u01d5\u0003\u0010\b"+
		"\u0000\u01d5\u01d6\u0005M\u0000\u0000\u01d6\u01d8\u0001\u0000\u0000\u0000"+
		"\u01d7\u01cf\u0001\u0000\u0000\u0000\u01d7\u01d4\u0001\u0000\u0000\u0000"+
		"\u01d8\'\u0001\u0000\u0000\u0000\u01d9\u01da\u00054\u0000\u0000\u01da"+
		"\u01db\u0003*\u0015\u0000\u01db)\u0001\u0000\u0000\u0000\u01dc\u01e5\u0005"+
		"\u001e\u0000\u0000\u01dd\u01e6\u0005\u001d\u0000\u0000\u01de\u01e0\u0003"+
		"4\u001a\u0000\u01df\u01de\u0001\u0000\u0000\u0000\u01e0\u01e3\u0001\u0000"+
		"\u0000\u0000\u01e1\u01df\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000"+
		"\u0000\u0000\u01e2\u01e4\u0001\u0000\u0000\u0000\u01e3\u01e1\u0001\u0000"+
		"\u0000\u0000\u01e4\u01e6\u0005M\u0000\u0000\u01e5\u01dd\u0001\u0000\u0000"+
		"\u0000\u01e5\u01e1\u0001\u0000\u0000\u0000\u01e6\u0208\u0001\u0000\u0000"+
		"\u0000\u01e7\u01f0\u0003b1\u0000\u01e8\u01f1\u0005\u001d\u0000\u0000\u01e9"+
		"\u01eb\u00034\u001a\u0000\u01ea\u01e9\u0001\u0000\u0000\u0000\u01eb\u01ee"+
		"\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001\u0000\u0000\u0000\u01ec\u01ed"+
		"\u0001\u0000\u0000\u0000\u01ed\u01ef\u0001\u0000\u0000\u0000\u01ee\u01ec"+
		"\u0001\u0000\u0000\u0000\u01ef\u01f1\u0005M\u0000\u0000\u01f0\u01e8\u0001"+
		"\u0000\u0000\u0000\u01f0\u01ec\u0001\u0000\u0000\u0000\u01f1\u0208\u0001"+
		"\u0000\u0000\u0000\u01f2\u01fb\u0003L&\u0000\u01f3\u01f7\u0005\n\u0000"+
		"\u0000\u01f4\u01f6\u00034\u001a\u0000\u01f5\u01f4\u0001\u0000\u0000\u0000"+
		"\u01f6\u01f9\u0001\u0000\u0000\u0000\u01f7\u01f5\u0001\u0000\u0000\u0000"+
		"\u01f7\u01f8\u0001\u0000\u0000\u0000\u01f8\u01fa\u0001\u0000\u0000\u0000"+
		"\u01f9\u01f7\u0001\u0000\u0000\u0000\u01fa\u01fc\u0005M\u0000\u0000\u01fb"+
		"\u01f3\u0001\u0000\u0000\u0000\u01fb\u01fc\u0001\u0000\u0000\u0000\u01fc"+
		"\u0208\u0001\u0000\u0000\u0000\u01fd\u0200\u00036\u001b\u0000\u01fe\u0201"+
		"\u0005\u001d\u0000\u0000\u01ff\u0201\u00036\u001b\u0000\u0200\u01fe\u0001"+
		"\u0000\u0000\u0000\u0200\u01ff\u0001\u0000\u0000\u0000\u0200\u0201\u0001"+
		"\u0000\u0000\u0000\u0201\u0208\u0001\u0000\u0000\u0000\u0202\u0204\u0003"+
		",\u0016\u0000\u0203\u0202\u0001\u0000\u0000\u0000\u0204\u0205\u0001\u0000"+
		"\u0000\u0000\u0205\u0203\u0001\u0000\u0000\u0000\u0205\u0206\u0001\u0000"+
		"\u0000\u0000\u0206\u0208\u0001\u0000\u0000\u0000\u0207\u01dc\u0001\u0000"+
		"\u0000\u0000\u0207\u01e7\u0001\u0000\u0000\u0000\u0207\u01f2\u0001\u0000"+
		"\u0000\u0000\u0207\u01fd\u0001\u0000\u0000\u0000\u0207\u0203\u0001\u0000"+
		"\u0000\u0000\u0208+\u0001\u0000\u0000\u0000\u0209\u020d\u0005\u001e\u0000"+
		"\u0000\u020a\u020d\u0003b1\u0000\u020b\u020d\u00036\u001b\u0000\u020c"+
		"\u0209\u0001\u0000\u0000\u0000\u020c\u020a\u0001\u0000\u0000\u0000\u020c"+
		"\u020b\u0001\u0000\u0000\u0000\u020d\u020e\u0001\u0000\u0000\u0000\u020e"+
		"\u020c\u0001\u0000\u0000\u0000\u020e\u020f\u0001\u0000\u0000\u0000\u020f"+
		"\u0212\u0001\u0000\u0000\u0000\u0210\u0213\u0005\u001d\u0000\u0000\u0211"+
		"\u0213\u00036\u001b\u0000\u0212\u0210\u0001\u0000\u0000\u0000\u0212\u0211"+
		"\u0001\u0000\u0000\u0000\u0213-\u0001\u0000\u0000\u0000\u0214\u021d\u0005"+
		"5\u0000\u0000\u0215\u021e\u0005\u001d\u0000\u0000\u0216\u0218\u00034\u001a"+
		"\u0000\u0217\u0216\u0001\u0000\u0000\u0000\u0218\u021b\u0001\u0000\u0000"+
		"\u0000\u0219\u0217\u0001\u0000\u0000\u0000\u0219\u021a\u0001\u0000\u0000"+
		"\u0000\u021a\u021c\u0001\u0000\u0000\u0000\u021b\u0219\u0001\u0000\u0000"+
		"\u0000\u021c\u021e\u0005M\u0000\u0000\u021d\u0215\u0001\u0000\u0000\u0000"+
		"\u021d\u0219\u0001\u0000\u0000\u0000\u021e/\u0001\u0000\u0000\u0000\u021f"+
		"\u022b\u00038\u001c\u0000\u0220\u0224\u0003<\u001e\u0000\u0221\u0223\u0003"+
		">\u001f\u0000\u0222\u0221\u0001\u0000\u0000\u0000\u0223\u0226\u0001\u0000"+
		"\u0000\u0000\u0224\u0222\u0001\u0000\u0000\u0000\u0224\u0225\u0001\u0000"+
		"\u0000\u0000\u0225\u0228\u0001\u0000\u0000\u0000\u0226\u0224\u0001\u0000"+
		"\u0000\u0000\u0227\u0229\u0003@ \u0000\u0228\u0227\u0001\u0000\u0000\u0000"+
		"\u0228\u0229\u0001\u0000\u0000\u0000\u0229\u022b\u0001\u0000\u0000\u0000"+
		"\u022a\u021f\u0001\u0000\u0000\u0000\u022a\u0220\u0001\u0000\u0000\u0000"+
		"\u022b1\u0001\u0000\u0000\u0000\u022c\u022d\u0005\u0003\u0000\u0000\u022d"+
		"\u022e\u0003:\u001d\u0000\u022e\u022f\u0005\u0004\u0000\u0000\u022f3\u0001"+
		"\u0000\u0000\u0000\u0230\u0231\u0005J\u0000\u0000\u0231\u0232\u0005\u000b"+
		"\u0000\u0000\u02325\u0001\u0000\u0000\u0000\u0233\u0235\u00034\u001a\u0000"+
		"\u0234\u0233\u0001\u0000\u0000\u0000\u0235\u0238\u0001\u0000\u0000\u0000"+
		"\u0236\u0234\u0001\u0000\u0000\u0000\u0236\u0237\u0001\u0000\u0000\u0000"+
		"\u0237\u0239\u0001\u0000\u0000\u0000\u0238\u0236\u0001\u0000\u0000\u0000"+
		"\u0239\u023a\u0005M\u0000\u0000\u023a7\u0001\u0000\u0000\u0000\u023b\u023c"+
		"\u0005\f\u0000\u0000\u023c\u023d\u0005:\u0000\u0000\u023d\u023e\u0003"+
		"R)\u0000\u023e\u023f\u0005;\u0000\u0000\u023f\u0240\u00032\u0019\u0000"+
		"\u0240\u0251\u0001\u0000\u0000\u0000\u0241\u0242\u0005\r\u0000\u0000\u0242"+
		"\u0244\u0005:\u0000\u0000\u0243\u0245\u0003B!\u0000\u0244\u0243\u0001"+
		"\u0000\u0000\u0000\u0244\u0245\u0001\u0000\u0000\u0000\u0245\u0246\u0001"+
		"\u0000\u0000\u0000\u0246\u0248\u0005O\u0000\u0000\u0247\u0249\u0003R)"+
		"\u0000\u0248\u0247\u0001\u0000\u0000\u0000\u0248\u0249\u0001\u0000\u0000"+
		"\u0000\u0249\u024a\u0001\u0000\u0000\u0000\u024a\u024c\u0005O\u0000\u0000"+
		"\u024b\u024d\u0003D\"\u0000\u024c\u024b\u0001\u0000\u0000\u0000\u024c"+
		"\u024d\u0001\u0000\u0000\u0000\u024d\u024e\u0001\u0000\u0000\u0000\u024e"+
		"\u024f\u0005;\u0000\u0000\u024f\u0251\u00032\u0019\u0000\u0250\u023b\u0001"+
		"\u0000\u0000\u0000\u0250\u0241\u0001\u0000\u0000\u0000\u02519\u0001\u0000"+
		"\u0000\u0000\u0252\u0254\u0003\u0014\n\u0000\u0253\u0252\u0001\u0000\u0000"+
		"\u0000\u0254\u0255\u0001\u0000\u0000\u0000\u0255\u0253\u0001\u0000\u0000"+
		"\u0000\u0255\u0256\u0001\u0000\u0000\u0000\u0256;\u0001\u0000\u0000\u0000"+
		"\u0257\u0258\u0005\u000e\u0000\u0000\u0258\u0259\u0005:\u0000\u0000\u0259"+
		"\u025a\u0003R)\u0000\u025a\u025b\u0005;\u0000\u0000\u025b\u025c\u0003"+
		"2\u0019\u0000\u025c=\u0001\u0000\u0000\u0000\u025d\u025e\u0005\u000f\u0000"+
		"\u0000\u025e\u025f\u0005\u000e\u0000\u0000\u025f\u0260\u0005:\u0000\u0000"+
		"\u0260\u0261\u0003R)\u0000\u0261\u0262\u0005;\u0000\u0000\u0262\u0263"+
		"\u00032\u0019\u0000\u0263?\u0001\u0000\u0000\u0000\u0264\u0265\u0005\u000f"+
		"\u0000\u0000\u0265\u0266\u00032\u0019\u0000\u0266A\u0001\u0000\u0000\u0000"+
		"\u0267\u026a\u0003\"\u0011\u0000\u0268\u026a\u0003&\u0013\u0000\u0269"+
		"\u0267\u0001\u0000\u0000\u0000\u0269\u0268\u0001\u0000\u0000\u0000\u026a"+
		"C\u0001\u0000\u0000\u0000\u026b\u026e\u0003(\u0014\u0000\u026c\u026e\u0003"+
		"F#\u0000\u026d\u026b\u0001\u0000\u0000\u0000\u026d\u026c\u0001\u0000\u0000"+
		"\u0000\u026eE\u0001\u0000\u0000\u0000\u026f\u0272\u0003\"\u0011\u0000"+
		"\u0270\u0272\u0003$\u0012\u0000\u0271\u026f\u0001\u0000\u0000\u0000\u0271"+
		"\u0270\u0001\u0000\u0000\u0000\u0272G\u0001\u0000\u0000\u0000\u0273\u0274"+
		"\u0005\u0010\u0000\u0000\u0274\u0275\u0005O\u0000\u0000\u0275I\u0001\u0000"+
		"\u0000\u0000\u0276\u0277\u0005\u0011\u0000\u0000\u0277\u0278\u0005O\u0000"+
		"\u0000\u0278K\u0001\u0000\u0000\u0000\u0279\u027a\u0005M\u0000\u0000\u027a"+
		"\u027c\u0005:\u0000\u0000\u027b\u027d\u0003N\'\u0000\u027c\u027b\u0001"+
		"\u0000\u0000\u0000\u027c\u027d\u0001\u0000\u0000\u0000\u027d\u027f\u0001"+
		"\u0000\u0000\u0000\u027e\u0280\u0005\u0006\u0000\u0000\u027f\u027e\u0001"+
		"\u0000\u0000\u0000\u027f\u0280\u0001\u0000\u0000\u0000\u0280\u0282\u0001"+
		"\u0000\u0000\u0000\u0281\u0283\u0003P(\u0000\u0282\u0281\u0001\u0000\u0000"+
		"\u0000\u0282\u0283\u0001\u0000\u0000\u0000\u0283\u0284\u0001\u0000\u0000"+
		"\u0000\u0284\u0285\u0005;\u0000\u0000\u0285M\u0001\u0000\u0000\u0000\u0286"+
		"\u028b\u0003R)\u0000\u0287\u0288\u0005\u0006\u0000\u0000\u0288\u028a\u0003"+
		"R)\u0000\u0289\u0287\u0001\u0000\u0000\u0000\u028a\u028d\u0001\u0000\u0000"+
		"\u0000\u028b\u0289\u0001\u0000\u0000\u0000\u028b\u028c\u0001\u0000\u0000"+
		"\u0000\u028cO\u0001\u0000\u0000\u0000\u028d\u028b\u0001\u0000\u0000\u0000"+
		"\u028e\u0293\u0003\u001e\u000f\u0000\u028f\u0290\u0005\u0006\u0000\u0000"+
		"\u0290\u0292\u0003\u001e\u000f\u0000\u0291\u028f\u0001\u0000\u0000\u0000"+
		"\u0292\u0295\u0001\u0000\u0000\u0000\u0293\u0291\u0001\u0000\u0000\u0000"+
		"\u0293\u0294\u0001\u0000\u0000\u0000\u0294Q\u0001\u0000\u0000\u0000\u0295"+
		"\u0293\u0001\u0000\u0000\u0000\u0296\u0297\u0006)\uffff\uffff\u0000\u0297"+
		"\u0298\u0005:\u0000\u0000\u0298\u0299\u0003R)\u0000\u0299\u029a\u0005"+
		";\u0000\u0000\u029a\u02b3\u0001\u0000\u0000\u0000\u029b\u029c\u0005:\u0000"+
		"\u0000\u029c\u029d\u0003\u0010\b\u0000\u029d\u029e\u0005;\u0000\u0000"+
		"\u029e\u029f\u0003R)\u000f\u029f\u02b3\u0001\u0000\u0000\u0000\u02a0\u02a1"+
		"\u0005I\u0000\u0000\u02a1\u02b3\u0003R)\u000e\u02a2\u02a3\u0005\'\u0000"+
		"\u0000\u02a3\u02a4\u0003V+\u0000\u02a4\u02a5\u00052\u0000\u0000\u02a5"+
		"\u02b3\u0001\u0000\u0000\u0000\u02a6\u02b3\u0003b1\u0000\u02a7\u02b3\u0003"+
		" \u0010\u0000\u02a8\u02b3\u0003j5\u0000\u02a9\u02b3\u0005\u001c\u0000"+
		"\u0000\u02aa\u02b3\u0005\u001e\u0000\u0000\u02ab\u02ad\u00034\u001a\u0000"+
		"\u02ac\u02ab\u0001\u0000\u0000\u0000\u02ad\u02b0\u0001\u0000\u0000\u0000"+
		"\u02ae\u02ac\u0001\u0000\u0000\u0000\u02ae\u02af\u0001\u0000\u0000\u0000"+
		"\u02af\u02b1\u0001\u0000\u0000\u0000\u02b0\u02ae\u0001\u0000\u0000\u0000"+
		"\u02b1\u02b3\u0005M\u0000\u0000\u02b2\u0296\u0001\u0000\u0000\u0000\u02b2"+
		"\u029b\u0001\u0000\u0000\u0000\u02b2\u02a0\u0001\u0000\u0000\u0000\u02b2"+
		"\u02a2\u0001\u0000\u0000\u0000\u02b2\u02a6\u0001\u0000\u0000\u0000\u02b2"+
		"\u02a7\u0001\u0000\u0000\u0000\u02b2\u02a8\u0001\u0000\u0000\u0000\u02b2"+
		"\u02a9\u0001\u0000\u0000\u0000\u02b2\u02aa\u0001\u0000\u0000\u0000\u02b2"+
		"\u02ae\u0001\u0000\u0000\u0000\u02b3\u02ce\u0001\u0000\u0000\u0000\u02b4"+
		"\u02b5\n\r\u0000\u0000\u02b5\u02b6\u0003^/\u0000\u02b6\u02b7\u0003R)\u000e"+
		"\u02b7\u02cd\u0001\u0000\u0000\u0000\u02b8\u02b9\n\f\u0000\u0000\u02b9"+
		"\u02ba\u0003\\.\u0000\u02ba\u02bb\u0003R)\r\u02bb\u02cd\u0001\u0000\u0000"+
		"\u0000\u02bc\u02bd\n\u000b\u0000\u0000\u02bd\u02be\u0003T*\u0000\u02be"+
		"\u02bf\u0003R)\f\u02bf\u02cd\u0001\u0000\u0000\u0000\u02c0\u02c1\n\n\u0000"+
		"\u0000\u02c1\u02c2\u0003V+\u0000\u02c2\u02c3\u0003R)\u000b\u02c3\u02cd"+
		"\u0001\u0000\u0000\u0000\u02c4\u02c5\n\t\u0000\u0000\u02c5\u02c6\u0003"+
		"X,\u0000\u02c6\u02c7\u0003R)\n\u02c7\u02cd\u0001\u0000\u0000\u0000\u02c8"+
		"\u02c9\n\b\u0000\u0000\u02c9\u02ca\u0003Z-\u0000\u02ca\u02cb\u0003R)\t"+
		"\u02cb\u02cd\u0001\u0000\u0000\u0000\u02cc\u02b4\u0001\u0000\u0000\u0000"+
		"\u02cc\u02b8\u0001\u0000\u0000\u0000\u02cc\u02bc\u0001\u0000\u0000\u0000"+
		"\u02cc\u02c0\u0001\u0000\u0000\u0000\u02cc\u02c4\u0001\u0000\u0000\u0000"+
		"\u02cc\u02c8\u0001\u0000\u0000\u0000\u02cd\u02d0\u0001\u0000\u0000\u0000"+
		"\u02ce\u02cc\u0001\u0000\u0000\u0000\u02ce\u02cf\u0001\u0000\u0000\u0000"+
		"\u02cfS\u0001\u0000\u0000\u0000\u02d0\u02ce\u0001\u0000\u0000\u0000\u02d1"+
		"\u02d2\u0007\u0002\u0000\u0000\u02d2U\u0001\u0000\u0000\u0000\u02d3\u02d4"+
		"\u0007\u0003\u0000\u0000\u02d4W\u0001\u0000\u0000\u0000\u02d5\u02d6\u0005"+
		"G\u0000\u0000\u02d6Y\u0001\u0000\u0000\u0000\u02d7\u02d8\u0005H\u0000"+
		"\u0000\u02d8[\u0001\u0000\u0000\u0000\u02d9\u02da\u0007\u0004\u0000\u0000"+
		"\u02da]\u0001\u0000\u0000\u0000\u02db\u02dc\u0007\u0005\u0000\u0000\u02dc"+
		"_\u0001\u0000\u0000\u0000\u02dd\u02de\u0007\u0006\u0000\u0000\u02dea\u0001"+
		"\u0000\u0000\u0000\u02df\u02e8\u0005\u0012\u0000\u0000\u02e0\u02e9\u0005"+
		"\u001e\u0000\u0000\u02e1\u02e3\u00034\u001a\u0000\u02e2\u02e1\u0001\u0000"+
		"\u0000\u0000\u02e3\u02e6\u0001\u0000\u0000\u0000\u02e4\u02e2\u0001\u0000"+
		"\u0000\u0000\u02e4\u02e5\u0001\u0000\u0000\u0000\u02e5\u02e7\u0001\u0000"+
		"\u0000\u0000\u02e6\u02e4\u0001\u0000\u0000\u0000\u02e7\u02e9\u0005M\u0000"+
		"\u0000\u02e8\u02e0\u0001\u0000\u0000\u0000\u02e8\u02e4\u0001\u0000\u0000"+
		"\u0000\u02e9\u02f5\u0001\u0000\u0000\u0000\u02ea\u02f3\u0005\u0006\u0000"+
		"\u0000\u02eb\u02f4\u0005\u001e\u0000\u0000\u02ec\u02ee\u00034\u001a\u0000"+
		"\u02ed\u02ec\u0001\u0000\u0000\u0000\u02ee\u02f1\u0001\u0000\u0000\u0000"+
		"\u02ef\u02ed\u0001\u0000\u0000\u0000\u02ef\u02f0\u0001\u0000\u0000\u0000"+
		"\u02f0\u02f2\u0001\u0000\u0000\u0000\u02f1\u02ef\u0001\u0000\u0000\u0000"+
		"\u02f2\u02f4\u0005M\u0000\u0000\u02f3\u02eb\u0001\u0000\u0000\u0000\u02f3"+
		"\u02ef\u0001\u0000\u0000\u0000\u02f4\u02f6\u0001\u0000\u0000\u0000\u02f5"+
		"\u02ea\u0001\u0000\u0000\u0000\u02f6\u02f7\u0001\u0000\u0000\u0000\u02f7"+
		"\u02f5\u0001\u0000\u0000\u0000\u02f7\u02f8\u0001\u0000\u0000\u0000\u02f8"+
		"\u02f9\u0001\u0000\u0000\u0000\u02f9\u02fa\u0005\u0013\u0000\u0000\u02fa"+
		"c\u0001\u0000\u0000\u0000\u02fb\u02fe\u0003f3\u0000\u02fc\u02fe\u0003"+
		"h4\u0000\u02fd\u02fb\u0001\u0000\u0000\u0000\u02fd\u02fc\u0001\u0000\u0000"+
		"\u0000\u02fee\u0001\u0000\u0000\u0000\u02ff\u0300\u0005M\u0000\u0000\u0300"+
		"\u0301\u0005\u0014\u0000\u0000\u0301\u0302\u0003L&\u0000\u0302\u0303\u0005"+
		"O\u0000\u0000\u0303g\u0001\u0000\u0000\u0000\u0304\u0305\u0005\u001b\u0000"+
		"\u0000\u0305\u0306\u0005M\u0000\u0000\u0306\u0307\u0005O\u0000\u0000\u0307"+
		"i\u0001\u0000\u0000\u0000\u0308\u030a\u0007\u0004\u0000\u0000\u0309\u0308"+
		"\u0001\u0000\u0000\u0000\u0309\u030a\u0001\u0000\u0000\u0000\u030a\u030b"+
		"\u0001\u0000\u0000\u0000\u030b\u030c\u0005\u001d\u0000\u0000\u030ck\u0001"+
		"\u0000\u0000\u0000\\ouy~\u0082\u008b\u0091\u009d\u00a4\u00b1\u00bb\u00c5"+
		"\u00e7\u00f0\u00fd\u0101\u0109\u010d\u0115\u0119\u0121\u0125\u012d\u0131"+
		"\u0139\u013d\u0145\u0149\u0151\u0155\u015d\u0161\u0169\u016d\u0175\u0179"+
		"\u0181\u0185\u018d\u0191\u0199\u019d\u01a5\u01a9\u01b1\u01b5\u01b7\u01be"+
		"\u01c8\u01d7\u01e1\u01e5\u01ec\u01f0\u01f7\u01fb\u0200\u0205\u0207\u020c"+
		"\u020e\u0212\u0219\u021d\u0224\u0228\u022a\u0236\u0244\u0248\u024c\u0250"+
		"\u0255\u0269\u026d\u0271\u027c\u027f\u0282\u028b\u0293\u02ae\u02b2\u02cc"+
		"\u02ce\u02e4\u02e8\u02ef\u02f3\u02f7\u02fd\u0309";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}