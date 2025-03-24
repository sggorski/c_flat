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
	 * Enter a parse tree produced by the {@code key}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void enterKey(MusicParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code key}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 */
	void exitKey(MusicParser.KeyContext ctx);
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
	 * Enter a parse tree produced by {@link MusicParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MusicParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MusicParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code playNote}
	 * labeled alternative in {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 */
	void enterPlayNote(MusicParser.PlayNoteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code playNote}
	 * labeled alternative in {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 */
	void exitPlayNote(MusicParser.PlayNoteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code playChord}
	 * labeled alternative in {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 */
	void enterPlayChord(MusicParser.PlayChordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code playChord}
	 * labeled alternative in {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 */
	void exitPlayChord(MusicParser.PlayChordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code playFunc}
	 * labeled alternative in {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 */
	void enterPlayFunc(MusicParser.PlayFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code playFunc}
	 * labeled alternative in {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 */
	void exitPlayFunc(MusicParser.PlayFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code playTrack}
	 * labeled alternative in {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 */
	void enterPlayTrack(MusicParser.PlayTrackContext ctx);
	/**
	 * Exit a parse tree produced by the {@code playTrack}
	 * labeled alternative in {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 */
	void exitPlayTrack(MusicParser.PlayTrackContext ctx);
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
	 * Enter a parse tree produced by {@link MusicParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void enterControlStatement(MusicParser.ControlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void exitControlStatement(MusicParser.ControlStatementContext ctx);
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
	 * Enter a parse tree produced by the {@code note}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNote(MusicParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code note}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNote(MusicParser.NoteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBool(MusicParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBool(MusicParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parantheses}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParantheses(MusicParser.ParanthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parantheses}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParantheses(MusicParser.ParanthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(MusicParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(MusicParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(MusicParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(MusicParser.IntContext ctx);
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
	 * Enter a parse tree produced by the {@code operator}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOperator(MusicParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code operator}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOperator(MusicParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(MusicParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(MusicParser.OpContext ctx);
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
	 * Enter a parse tree produced by {@link MusicParser#trackStatement}.
	 * @param ctx the parse tree
	 */
	void enterTrackStatement(MusicParser.TrackStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicParser#trackStatement}.
	 * @param ctx the parse tree
	 */
	void exitTrackStatement(MusicParser.TrackStatementContext ctx);
}