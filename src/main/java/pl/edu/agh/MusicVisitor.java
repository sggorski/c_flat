// Generated from C:/Users/sggor/Desktop/TKK/c_flat/src/main/java/pl/edu/agh/grammar/Music.g4 by ANTLR 4.13.2
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
	 * Visit a parse tree produced by {@link MusicParser#imports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports(MusicParser.ImportsContext ctx);
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
	 * Visit a parse tree produced by {@link MusicParser#mainStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainStatement(MusicParser.MainStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MusicParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(MusicParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#exprStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStatement(MusicParser.ExprStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(MusicParser.LoopStatementContext ctx);
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
	 * Visit a parse tree produced by the {@code vibrato}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVibrato(MusicParser.VibratoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code balance}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBalance(MusicParser.BalanceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sostenutoPedal}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSostenutoPedal(MusicParser.SostenutoPedalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code softPedal}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSoftPedal(MusicParser.SoftPedalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code resonance}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResonance(MusicParser.ResonanceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code reverb}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReverb(MusicParser.ReverbContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tremolo}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTremolo(MusicParser.TremoloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code chorus}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChorus(MusicParser.ChorusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code phraser}
	 * labeled alternative in {@link MusicParser#settingsAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhraser(MusicParser.PhraserContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#settingsValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSettingsValues(MusicParser.SettingsValuesContext ctx);
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
	 * Visit a parse tree produced by the {@code varDeclWithARg}
	 * labeled alternative in {@link MusicParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclWithARg(MusicParser.VarDeclWithARgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclWithoutArg}
	 * labeled alternative in {@link MusicParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclWithoutArg(MusicParser.VarDeclWithoutArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#playStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayStatement(MusicParser.PlayStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code playNote}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayNote(MusicParser.PlayNoteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code playChord}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayChord(MusicParser.PlayChordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code playFunc}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayFunc(MusicParser.PlayFuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code playIDVariants}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayIDVariants(MusicParser.PlayIDVariantsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code playMulti}
	 * labeled alternative in {@link MusicParser#playValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayMulti(MusicParser.PlayMultiContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#multiPlayValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiPlayValues(MusicParser.MultiPlayValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#pauseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPauseStatement(MusicParser.PauseStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileLoop}
	 * labeled alternative in {@link MusicParser#controlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(MusicParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link MusicParser#controlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(MusicParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forLoop}
	 * labeled alternative in {@link MusicParser#controlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(MusicParser.ForLoopContext ctx);
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
	 * Visit a parse tree produced by {@link MusicParser#forAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForAssignment(MusicParser.ForAssignmentContext ctx);
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
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(MusicParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqOperatorExpr(MusicParser.EqOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code settingsExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSettingsExpr(MusicParser.SettingsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paranthesesExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParanthesesExpr(MusicParser.ParanthesesExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noteExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoteExpr(MusicParser.NoteExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrOperatorExpr(MusicParser.OrOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(MusicParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orderOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderOperatorExpr(MusicParser.OrderOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instrumentOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstrumentOperatorExpr(MusicParser.InstrumentOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubOperatorExpr(MusicParser.AddSubOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOperatorExpr(MusicParser.AndOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mullDivOperatorExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMullDivOperatorExpr(MusicParser.MullDivOperatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(MusicParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code chordExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChordExpr(MusicParser.ChordExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MusicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(MusicParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#orderOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrderOp(MusicParser.OrderOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#eqOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqOp(MusicParser.EqOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#andOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOp(MusicParser.AndOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#orOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrOp(MusicParser.OrOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#addSubOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubOp(MusicParser.AddSubOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#mullDivOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMullDivOp(MusicParser.MullDivOpContext ctx);
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
	 * Visit a parse tree produced by the {@code trackAdd}
	 * labeled alternative in {@link MusicParser#trackStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrackAdd(MusicParser.TrackAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trackDeclare}
	 * labeled alternative in {@link MusicParser#trackStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrackDeclare(MusicParser.TrackDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#trackStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrackStatement(MusicParser.TrackStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#trackDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrackDeclaration(MusicParser.TrackDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicParser#intVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntVal(MusicParser.IntValContext ctx);
}