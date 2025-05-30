// Generated from C:/Users/kacpe/IdeaProjects/c_flat/src/main/java/pl/edu/agh/grammar/Music.g4 by ANTLR 4.13.2
package pl.edu.agh;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MusicParser}.
 */
public interface MusicListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MusicParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MusicParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MusicParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#globalVars}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVars(MusicParser.GlobalVarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#globalVars}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVars(MusicParser.GlobalVarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#includes}.
	 * @param ctx the parse tree
	 */
	void enterIncludes(MusicParser.IncludesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#includes}.
	 * @param ctx the parse tree
	 */
	void exitIncludes(MusicParser.IncludesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(MusicParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(MusicParser.ImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(MusicParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(MusicParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#mainDecl}.
	 * @param ctx the parse tree
	 */
	void enterMainDecl(MusicParser.MainDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#mainDecl}.
	 * @param ctx the parse tree
	 */
	void exitMainDecl(MusicParser.MainDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(MusicParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(MusicParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MusicParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MusicParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MusicParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MusicParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#mainStatement}.
	 * @param ctx the parse tree
	 */
	void enterMainStatement(MusicParser.MainStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#mainStatement}.
	 * @param ctx the parse tree
	 */
	void exitMainStatement(MusicParser.MainStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MusicParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MusicParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(MusicParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(MusicParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MusicParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MusicParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#exprStatement}.
	 * @param ctx the parse tree
	 */
	void enterExprStatement(MusicParser.ExprStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#exprStatement}.
	 * @param ctx the parse tree
	 */
	void exitExprStatement(MusicParser.ExprStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#settings}.
	 * @param ctx the parse tree
	 */
	void enterSettings(MusicParser.SettingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#settings}.
	 * @param ctx the parse tree
	 */
	void exitSettings(MusicParser.SettingsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pace}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterPace(MusicParser.PaceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pace}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitPace(MusicParser.PaceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sustain}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterSustain(MusicParser.SustainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sustain}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitSustain(MusicParser.SustainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instrument}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterInstrument(MusicParser.InstrumentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instrument}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitInstrument(MusicParser.InstrumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code distortion}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterDistortion(MusicParser.DistortionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code distortion}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitDistortion(MusicParser.DistortionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jazz}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterJazz(MusicParser.JazzContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jazz}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitJazz(MusicParser.JazzContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blues}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterBlues(MusicParser.BluesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blues}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitBlues(MusicParser.BluesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code volume}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterVolume(MusicParser.VolumeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code volume}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitVolume(MusicParser.VolumeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vibrato}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterVibrato(MusicParser.VibratoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vibrato}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitVibrato(MusicParser.VibratoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code balance}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterBalance(MusicParser.BalanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code balance}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitBalance(MusicParser.BalanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sostenutoPedal}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterSostenutoPedal(MusicParser.SostenutoPedalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sostenutoPedal}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitSostenutoPedal(MusicParser.SostenutoPedalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code softPedal}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterSoftPedal(MusicParser.SoftPedalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code softPedal}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitSoftPedal(MusicParser.SoftPedalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code resonance}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterResonance(MusicParser.ResonanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code resonance}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitResonance(MusicParser.ResonanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code reverb}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterReverb(MusicParser.ReverbContext ctx);
	/**
	 * Exit a parse tree produced by the {@code reverb}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitReverb(MusicParser.ReverbContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tremolo}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterTremolo(MusicParser.TremoloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tremolo}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitTremolo(MusicParser.TremoloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code chorus}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterChorus(MusicParser.ChorusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code chorus}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitChorus(MusicParser.ChorusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code phraser}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterPhraser(MusicParser.PhraserContext ctx);
	/**
	 * Exit a parse tree produced by the {@code phraser}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitPhraser(MusicParser.PhraserContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#settingsValues}.
	 * @param ctx the parse tree
	 */
	void enterSettingsValues(MusicParser.SettingsValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#settingsValues}.
	 * @param ctx the parse tree
	 */
	void exitSettingsValues(MusicParser.SettingsValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MusicParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MusicParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#selfAssignment}.
	 * @param ctx the parse tree
	 */
	void enterSelfAssignment(MusicParser.SelfAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#selfAssignment}.
	 * @param ctx the parse tree
	 */
	void exitSelfAssignment(MusicParser.SelfAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclWithARg}
	 * labeled alternative in {@link MusicParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclWithARg(MusicParser.VarDeclWithARgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclWithARg}
	 * labeled alternative in {@link MusicParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclWithARg(MusicParser.VarDeclWithARgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclWithoutArg}
	 * labeled alternative in {@link MusicParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclWithoutArg(MusicParser.VarDeclWithoutArgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclWithoutArg}
	 * labeled alternative in {@link MusicParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclWithoutArg(MusicParser.VarDeclWithoutArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 */
	void enterPlayStatement(MusicParser.PlayStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 */
	void exitPlayStatement(MusicParser.PlayStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code playNote}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 */
	void enterPlayNote(MusicParser.PlayNoteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code playNote}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 */
	void exitPlayNote(MusicParser.PlayNoteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code playChord}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 */
	void enterPlayChord(MusicParser.PlayChordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code playChord}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 */
	void exitPlayChord(MusicParser.PlayChordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code playFunc}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 */
	void enterPlayFunc(MusicParser.PlayFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code playFunc}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 */
	void exitPlayFunc(MusicParser.PlayFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code playIDVariants}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 */
	void enterPlayIDVariants(MusicParser.PlayIDVariantsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code playIDVariants}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 */
	void exitPlayIDVariants(MusicParser.PlayIDVariantsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code playMulti}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 */
	void enterPlayMulti(MusicParser.PlayMultiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code playMulti}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 */
	void exitPlayMulti(MusicParser.PlayMultiContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#multiPlayValues}.
	 * @param ctx the parse tree
	 */
	void enterMultiPlayValues(MusicParser.MultiPlayValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#multiPlayValues}.
	 * @param ctx the parse tree
	 */
	void exitMultiPlayValues(MusicParser.MultiPlayValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#pauseStatement}.
	 * @param ctx the parse tree
	 */
	void enterPauseStatement(MusicParser.PauseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#pauseStatement}.
	 * @param ctx the parse tree
	 */
	void exitPauseStatement(MusicParser.PauseStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loopStatement}
	 * labeled alternative in {@link MusicParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(MusicParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loopStatement}
	 * labeled alternative in {@link MusicParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(MusicParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link MusicParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MusicParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link MusicParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MusicParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(MusicParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(MusicParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#parent}.
	 * @param ctx the parse tree
	 */
	void enterParent(MusicParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#parent}.
	 * @param ctx the parse tree
	 */
	void exitParent(MusicParser.ParentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#parentID}.
	 * @param ctx the parse tree
	 */
	void enterParentID(MusicParser.ParentIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#parentID}.
	 * @param ctx the parse tree
	 */
	void exitParentID(MusicParser.ParentIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link MusicParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(MusicParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link MusicParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(MusicParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link MusicParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(MusicParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link MusicParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(MusicParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#loopBody}.
	 * @param ctx the parse tree
	 */
	void enterLoopBody(MusicParser.LoopBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#loopBody}.
	 * @param ctx the parse tree
	 */
	void exitLoopBody(MusicParser.LoopBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(MusicParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(MusicParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#elseif}.
	 * @param ctx the parse tree
	 */
	void enterElseif(MusicParser.ElseifContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#elseif}.
	 * @param ctx the parse tree
	 */
	void exitElseif(MusicParser.ElseifContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(MusicParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(MusicParser.ElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(MusicParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(MusicParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(MusicParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(MusicParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#forAssignment}.
	 * @param ctx the parse tree
	 */
	void enterForAssignment(MusicParser.ForAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#forAssignment}.
	 * @param ctx the parse tree
	 */
	void exitForAssignment(MusicParser.ForAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(MusicParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(MusicParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(MusicParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(MusicParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MusicParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MusicParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(MusicParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(MusicParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#settingsList}.
	 * @param ctx the parse tree
	 */
	void enterSettingsList(MusicParser.SettingsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#settingsList}.
	 * @param ctx the parse tree
	 */
	void exitSettingsList(MusicParser.SettingsListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(MusicParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(MusicParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCastExpr(MusicParser.CastExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code castExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCastExpr(MusicParser.CastExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqOperatorExpr(MusicParser.EqOperatorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqOperatorExpr(MusicParser.EqOperatorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code settingsExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSettingsExpr(MusicParser.SettingsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code settingsExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSettingsExpr(MusicParser.SettingsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paranthesesExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParanthesesExpr(MusicParser.ParanthesesExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paranthesesExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParanthesesExpr(MusicParser.ParanthesesExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noteExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNoteExpr(MusicParser.NoteExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noteExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNoteExpr(MusicParser.NoteExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrOperatorExpr(MusicParser.OrOperatorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrOperatorExpr(MusicParser.OrOperatorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(MusicParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(MusicParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orderOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrderOperatorExpr(MusicParser.OrderOperatorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orderOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrderOperatorExpr(MusicParser.OrderOperatorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instrumentOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInstrumentOperatorExpr(MusicParser.InstrumentOperatorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instrumentOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInstrumentOperatorExpr(MusicParser.InstrumentOperatorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubOperatorExpr(MusicParser.AddSubOperatorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubOperatorExpr(MusicParser.AddSubOperatorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndOperatorExpr(MusicParser.AndOperatorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndOperatorExpr(MusicParser.AndOperatorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mullDivOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMullDivOperatorExpr(MusicParser.MullDivOperatorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mullDivOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMullDivOperatorExpr(MusicParser.MullDivOperatorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(MusicParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(MusicParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code chordExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterChordExpr(MusicParser.ChordExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code chordExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitChordExpr(MusicParser.ChordExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(MusicParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(MusicParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#orderOp}.
	 * @param ctx the parse tree
	 */
	void enterOrderOp(MusicParser.OrderOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#orderOp}.
	 * @param ctx the parse tree
	 */
	void exitOrderOp(MusicParser.OrderOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#eqOp}.
	 * @param ctx the parse tree
	 */
	void enterEqOp(MusicParser.EqOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#eqOp}.
	 * @param ctx the parse tree
	 */
	void exitEqOp(MusicParser.EqOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#andOp}.
	 * @param ctx the parse tree
	 */
	void enterAndOp(MusicParser.AndOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#andOp}.
	 * @param ctx the parse tree
	 */
	void exitAndOp(MusicParser.AndOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#orOp}.
	 * @param ctx the parse tree
	 */
	void enterOrOp(MusicParser.OrOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#orOp}.
	 * @param ctx the parse tree
	 */
	void exitOrOp(MusicParser.OrOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#addSubOp}.
	 * @param ctx the parse tree
	 */
	void enterAddSubOp(MusicParser.AddSubOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#addSubOp}.
	 * @param ctx the parse tree
	 */
	void exitAddSubOp(MusicParser.AddSubOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#mullDivOp}.
	 * @param ctx the parse tree
	 */
	void enterMullDivOp(MusicParser.MullDivOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#mullDivOp}.
	 * @param ctx the parse tree
	 */
	void exitMullDivOp(MusicParser.MullDivOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#assOp}.
	 * @param ctx the parse tree
	 */
	void enterAssOp(MusicParser.AssOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#assOp}.
	 * @param ctx the parse tree
	 */
	void exitAssOp(MusicParser.AssOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#chord}.
	 * @param ctx the parse tree
	 */
	void enterChord(MusicParser.ChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#chord}.
	 * @param ctx the parse tree
	 */
	void exitChord(MusicParser.ChordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trackAdd}
	 * labeled alternative in {@link MusicParser#trackStatements}.
	 * @param ctx the parse tree
	 */
	void enterTrackAdd(MusicParser.TrackAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trackAdd}
	 * labeled alternative in {@link MusicParser#trackStatements}.
	 * @param ctx the parse tree
	 */
	void exitTrackAdd(MusicParser.TrackAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trackDeclare}
	 * labeled alternative in {@link MusicParser#trackStatements}.
	 * @param ctx the parse tree
	 */
	void enterTrackDeclare(MusicParser.TrackDeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trackDeclare}
	 * labeled alternative in {@link MusicParser#trackStatements}.
	 * @param ctx the parse tree
	 */
	void exitTrackDeclare(MusicParser.TrackDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#trackStatement}.
	 * @param ctx the parse tree
	 */
	void enterTrackStatement(MusicParser.TrackStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#trackStatement}.
	 * @param ctx the parse tree
	 */
	void exitTrackStatement(MusicParser.TrackStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#trackDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTrackDeclaration(MusicParser.TrackDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#trackDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTrackDeclaration(MusicParser.TrackDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#intVal}.
	 * @param ctx the parse tree
	 */
	void enterIntVal(MusicParser.IntValContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#intVal}.
	 * @param ctx the parse tree
	 */
	void exitIntVal(MusicParser.IntValContext ctx);
}