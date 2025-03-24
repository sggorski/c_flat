// Generated from C:/Users/kacpe/IdeaProjects/c_flat/src/main/java/pl/edu/agh/grammar/Music.g4 by ANTLR 4.13.2
package pl.edu.agh;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MusicParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MusicVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MusicParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MusicParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(MusicParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#mainDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDecl(MusicParser.MainDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(MusicParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MusicParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MusicParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MusicParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#settings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSettings(MusicParser.SettingsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pace}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPace(MusicParser.PaceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sustain}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSustain(MusicParser.SustainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instrument}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrument(MusicParser.InstrumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code distortion}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDistortion(MusicParser.DistortionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jazz}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJazz(MusicParser.JazzContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blues}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlues(MusicParser.BluesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code volume}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVolume(MusicParser.VolumeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code key}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(MusicParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MusicParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#selfAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfAssignment(MusicParser.SelfAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(MusicParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code playNote}
	 * labeled alternative in {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayNote(MusicParser.PlayNoteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code playChord}
	 * labeled alternative in {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayChord(MusicParser.PlayChordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code playFunc}
	 * labeled alternative in {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayFunc(MusicParser.PlayFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code playTrack}
	 * labeled alternative in {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayTrack(MusicParser.PlayTrackContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#pauseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPauseStatement(MusicParser.PauseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#controlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStatement(MusicParser.ControlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(MusicParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(MusicParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(MusicParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(MusicParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(MusicParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(MusicParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#settingsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSettingsList(MusicParser.SettingsListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code note}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(MusicParser.NoteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(MusicParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parantheses}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParantheses(MusicParser.ParanthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(MusicParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(MusicParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code chordExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChordExpr(MusicParser.ChordExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code operator}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(MusicParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(MusicParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#assOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssOp(MusicParser.AssOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#chord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChord(MusicParser.ChordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#trackStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrackStatement(MusicParser.TrackStatementContext ctx);
}