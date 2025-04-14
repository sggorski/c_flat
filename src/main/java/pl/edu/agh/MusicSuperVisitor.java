// Generated from C:/Users/kacpe/IdeaProjects/c_flat/src/main/java/pl/edu/agh/grammar/Music.g4 by ANTLR 4.13.2
package pl.edu.agh;
import org.antlr.v4.runtime.tree.TerminalNode;
import pl.edu.agh.utils.*;
import pl.edu.agh.utils.Instrument;

import javax.sound.midi.*;

import java.util.ArrayList;
import java.util.List;

import static pl.edu.agh.utils.Instrument.*;


@SuppressWarnings("CheckReturnValue")
public class MusicSuperVisitor<T> extends MusicBaseVisitor<T> implements MusicVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	MainMelody main;
	MusicParser.MainDeclContext mainCtx = null;
	MusicParser.FunctionDeclContext funcCtx = null;

	@Override public T visitProgram(MusicParser.ProgramContext ctx) {
		try{
			main = new MainMelody();
			main.synth = MidiSystem.getSynthesizer();
			main.synth.open();
			main.channels = main.synth.getChannels();
			main.channels[0].programChange(0);
		}catch (Exception e){
			e.printStackTrace();
		}

		return visitChildren(ctx); }

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitImports(MusicParser.ImportsContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFunctionDecl(MusicParser.FunctionDeclContext ctx) {
		funcCtx = ctx;
		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitMainDecl(MusicParser.MainDeclContext ctx) {
		mainCtx = ctx;
		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitParameters(MusicParser.ParametersContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitParameter(MusicParser.ParameterContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitType(MusicParser.TypeContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStatement(MusicParser.StatementContext ctx) { return visitChildren(ctx); }

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitLoopStatement(MusicParser.LoopStatementContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSettings(MusicParser.SettingsContext ctx) {return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPace(MusicParser.PaceContext ctx) throws Exception {
		if(mainCtx!=null){
            if(ctx.INT_VAL() != null) main.pace= Integer.parseInt(ctx.INT_VAL().getText());
			else if (ctx.ID() != null) {
				VarInfo var = main.memory.get(ctx.ID().getText());
				if(var==null) throw new Exception("Variable not definied: " + ctx.ID().getText());
				if(var.type != Type.INT) throw new Exception("Incorrect type of variable: " + ctx.ID().getText());
				IntValue varInt = (IntValue)var.valueObj;
				main.pace = varInt.value;
			}
		}

		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSustain(MusicParser.SustainContext ctx) throws Exception {
		if(mainCtx!=null){
			if(ctx.INT_VAL() != null) main.sustain= Integer.parseInt(ctx.INT_VAL().getText());
			else if (ctx.ID() != null) {
				VarInfo var = main.memory.get(ctx.ID().getText());
				if(var==null) throw new Exception("Variable not definied: " + ctx.ID().getText());
				if(var.type != Type.INT) throw new Exception("Incorrect type of variable: " + ctx.ID().getText());
				IntValue varInt = (IntValue)var.valueObj;
				if(main.instrument==DRUMS) main.channels[9].controlChange(64, varInt.value);
				else main.channels[0].controlChange(64, varInt.value);
			}
		}

		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitInstrument(MusicParser.InstrumentContext ctx) throws Exception {
		if(main!=null){
			if(ctx.INSTRUMENT_VALUE() == null) throw new Exception("Invalid instrument!");
			String instrumentName = ctx.INSTRUMENT_VALUE().getText();
			Instrument instrument = valueOf(instrumentName);
			main.instrument = instrument;
			switch (instrument) {
				case PIANO:
					main.channels[0].programChange(0);
					break;
				case HARP:
					main.channels[0].programChange(46);
					break;
				case VIOLIN:
					main.channels[0].programChange(40);
					break;
				case DRUMS:
					main.channels[9].programChange(35);
					break;
				default:
					throw new Exception("Invalid instrument!");
			}
		}
		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDistortion(MusicParser.DistortionContext ctx) throws Exception {
		if(mainCtx!=null) {
			if (ctx.INT_VAL() != null) main.distortion = Integer.parseInt(ctx.INT_VAL().getText());
			else if (ctx.ID() != null) {
				VarInfo var = main.memory.get(ctx.ID().getText());
				if (var == null) throw new Exception("Variable not definied: " + ctx.ID().getText());
				if (var.type != Type.INT) throw new Exception("Incorrect type of variable: " + ctx.ID().getText());
				IntValue varInt = (IntValue) var.valueObj;
				if (main.instrument == DRUMS) main.channels[9].controlChange(93, varInt.value);
				else main.channels[0].controlChange(93, varInt.value);
			}
		}

		return visitChildren(ctx);

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitJazz(MusicParser.JazzContext ctx) throws Exception {
		if(mainCtx!=null){
            if(ctx.BOOL_VAL() != null) main.jazz= ctx.BOOL_VAL().getText().equals("true");
			else if(ctx.ID() != null){
				VarInfo var = main.memory.get(ctx.ID().getText());
				if (var == null) throw new Exception("Variable not definied: " + ctx.ID().getText());
				if (var.type != Type.BOOL) throw new Exception("Incorrect type of variable: " + ctx.ID().getText());
				BoolValue varBool = (BoolValue) var.valueObj;
				main.jazz = varBool.value;
			}
		}
		return visitChildren(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBlues(MusicParser.BluesContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitVolume(MusicParser.VolumeContext ctx) throws Exception {
		if(mainCtx!=null){
			if(ctx.INT_VAL() != null) main.volume= Integer.parseInt(ctx.INT_VAL().getText());
			else if (ctx.ID() != null) {
				VarInfo var = main.memory.get(ctx.ID().getText());
				if(var==null) throw new Exception("Variable not definied: " + ctx.ID().getText());
				if(var.type != Type.INT) throw new Exception("Incorrect type of variable: " + ctx.ID().getText());
				IntValue varInt = (IntValue)var.valueObj;
				main.volume = varInt.value;
			}
		}
		return visitChildren(ctx);
	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitSettingsValues(MusicParser.SettingsValuesContext ctx) {
		return visitChildren(ctx);	}


	@Override public T visitAssignment(MusicParser.AssignmentContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSelfAssignment(MusicParser.SelfAssignmentContext ctx) { return visitChildren(ctx); }

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitVarDeclWithARg(MusicParser.VarDeclWithARgContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitVarDeclWithoutArg(MusicParser.VarDeclWithoutArgContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */

	@Override public T visitPlayNote(MusicParser.PlayNoteContext ctx) throws Exception {

        try {
			int duration = 0;
			if(ctx.INT_VAL() != null)  duration = Integer.parseInt(ctx.INT_VAL().getText());
			else if(ctx.ID() != null){
				VarInfo var = main.memory.get(ctx.ID().getText());
				if(var==null) throw new Exception("Variable not definied: " + ctx.ID().getText());
				if(var.type != Type.INT) throw new Exception("Incorrect type of variable: " + ctx.ID().getText());
				IntValue varInt = (IntValue)var.valueObj;
				duration = varInt.value;
			}
			Note note = Note.valueOf(ctx.NOTE_VAL().getText().replace('#', 's').replace('-', 'm'));
			if(main.instrument==DRUMS){
				main.playNote(main.channels[9],main.notes.get(note),duration,main.volume);
			}
			else{
				main.playNote(main.channels[0],main.notes.get(note),duration,main.volume);
			}
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPlayChord(MusicParser.PlayChordContext ctx) throws Exception {
		ChordValue chord = (ChordValue) visit(ctx.chord());
		List<Integer> notes = new ArrayList<>();
		for(NoteValue noteVal: chord.notes){
			notes.add(main.notes.get(noteVal.note));
		}
		int duration = 0;
		if(ctx.INT_VAL()!=null) duration = Integer.parseInt(ctx.INT_VAL().getText());
		else if(ctx.ID() != null){
			VarInfo var = main.memory.get(ctx.ID().getText());
			if(var==null) throw new Exception("Variable not definied: " + ctx.ID().getText());
			if(var.type != Type.INT) throw new Exception("Incorrect type of variable: " + ctx.ID().getText());
			IntValue varInt = (IntValue)var.valueObj;
			duration = varInt.value;

		}
		if(main.instrument==DRUMS){
			main.playChord(main.channels[9],notes,duration,main.volume);
		}
		else{
			main.playChord(main.channels[0],notes,duration,main.volume);
		}
		return visitChildren(ctx);

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPlayFunc(MusicParser.PlayFuncContext ctx) { return visitChildren(ctx); }

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitPlayVariables(MusicParser.PlayVariablesContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPlayTrack(MusicParser.PlayTrackContext ctx) { return visitChildren(ctx); }

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitPlayMulti(MusicParser.PlayMultiContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitPauseStatement(MusicParser.PauseStatementContext ctx) {
		if(mainCtx!=null){
			/*
			try{

				int sleep = 0;
				if(ctx.INT_VAL() != null) sleep = Integer.parseInt(ctx.INT_VAL().getText());
				else if(ctx.ID() != null ){
					VarInfo var = main.memory.get(ctx.ID().getText());
					if(var==null) throw new Exception("Variable not definied: " + ctx.ID().getText());
					if(var.type != Type.INT) throw new Exception("Incorrect type of variable: " + ctx.ID().getText());
					IntValue varInt = (IntValue)var.valueObj;
					sleep = varInt.value;
				}
				Thread.sleep(sleep);
			}catch (Exception e){
				e.printStackTrace();
			}*/
		}
		return visitChildren(ctx);
	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitWhileLoop(MusicParser.WhileLoopContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitIf(MusicParser.IfContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitForLoop(MusicParser.ForLoopContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */

	@Override public T visitForInit(MusicParser.ForInitContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitForUpdate(MusicParser.ForUpdateContext ctx) { return visitChildren(ctx); }

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitForAssignment(MusicParser.ForAssignmentContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBreakStatement(MusicParser.BreakStatementContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitContinueStatement(MusicParser.ContinueStatementContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFunctionCall(MusicParser.FunctionCallContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitArguments(MusicParser.ArgumentsContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSettingsList(MusicParser.SettingsListContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitNoteExpr(MusicParser.NoteExprContext ctx) { return visitChildren(ctx); }

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitOrOperatorExpr(MusicParser.OrOperatorExprContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitNotExpr(MusicParser.NotExprContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitOrderOperatorExpr(MusicParser.OrderOperatorExprContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitAddSubOperatorExpr(MusicParser.AddSubOperatorExprContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitAndOperatorExpr(MusicParser.AndOperatorExprContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitMullDivOperatorExpr(MusicParser.MullDivOperatorExprContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBoolExpr(MusicParser.BoolExprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitParanthesesExpr(MusicParser.ParanthesesExprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIdExpr(MusicParser.IdExprContext ctx) { return visitChildren(ctx); }

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitOrderOp(MusicParser.OrderOpContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitEqOp(MusicParser.EqOpContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitAndOp(MusicParser.AndOpContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitOrOp(MusicParser.OrOpContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitAddSubOp(MusicParser.AddSubOpContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitMullDivOp(MusicParser.MullDivOpContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public T visitIntExpr(MusicParser.IntExprContext ctx) { return visitChildren(ctx); }

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitEqOperatorExpr(MusicParser.EqOperatorExprContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * @param ctx the parse tree
	 * @return
	 */
	@Override
	public T visitSettingsExpr(MusicParser.SettingsExprContext ctx) {
		return visitChildren(ctx);	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitChordExpr(MusicParser.ChordExprContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */


	@Override public T visitAssOp(MusicParser.AssOpContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitChord(MusicParser.ChordContext ctx) {
		List<NoteValue> notes = new ArrayList<>();
		for(TerminalNode node : ctx.NOTE_VAL()){
			Note note = Note.valueOf(node.getText().replace('#', 's').replace('-', 'm'));
			notes.add(new NoteValue(note));
		}
		return (T)(new ChordValue(notes));

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTrackStatement(MusicParser.TrackStatementContext ctx) { return visitChildren(ctx); }
}