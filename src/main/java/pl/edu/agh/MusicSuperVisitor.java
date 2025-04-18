package pl.edu.agh;


import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import pl.edu.agh.errors.*;
import pl.edu.agh.utils.*;
import pl.edu.agh.utils.Instrument;

import javax.sound.midi.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public T visitProgram(MusicParser.ProgramContext ctx) throws RuntimeException {
        try {
            main = new MainMelody();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return visitChildren(ctx);
    }

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
    @Override
    public T visitFunctionDecl(MusicParser.FunctionDeclContext ctx) {
        funcCtx = ctx;
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitMainDecl(MusicParser.MainDeclContext ctx) {
        mainCtx = ctx;
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitParameters(MusicParser.ParametersContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitParameter(MusicParser.ParameterContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitType(MusicParser.TypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitMainStatement(MusicParser.MainStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitStatement(MusicParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitLoopStatement(MusicParser.LoopStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitSettings(MusicParser.SettingsContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitPace(MusicParser.PaceContext ctx) {
        if (mainCtx != null) {
            if (ctx.INT_VAL() != null) main.pace = Integer.parseInt(ctx.INT_VAL().getText());
            else if (ctx.ID() != null) {
                VarInfo var = main.memory.get(ctx.ID().getText());
                if (var == null)
                    throw new ScopeError("Variable not defined: " + ctx.ID().getText(), getLine(ctx), getCol(ctx));
                if (var.type != Type.INT)
                    throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + "Type " + var.type + "not int", getLine(ctx), getCol(ctx));
                IntValue varInt = (IntValue) var.valueObj;
                main.pace = varInt.value;
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
    @Override
    public T visitSustain(MusicParser.SustainContext ctx) {
        if (mainCtx != null) {
            if (ctx.INT_VAL() != null) main.sustain = Integer.parseInt(ctx.INT_VAL().getText());
            else if (ctx.ID() != null) {
                VarInfo var = main.memory.get(ctx.ID().getText());
                if (var == null)
                    throw new ScopeError("Variable not defined: " + ctx.ID().getText(), getLine(ctx), getCol(ctx));
                if (var.type != Type.INT)
                    throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + "Type " + var.type + "not int", getLine(ctx), getCol(ctx));
                IntValue varInt = (IntValue) var.valueObj;
                main.sustain = varInt.value;
            }
            if (main.instrument == DRUMS) main.channels[9].controlChange(64, main.sustain);
            else main.channels[0].controlChange(64, main.sustain);
        }

        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitInstrument(MusicParser.InstrumentContext ctx) {
        if (main != null) {
            // If not Instrument_Value then it is recognised as ID, if not then it should be a lexer error
            if (ctx.INSTRUMENT_VALUE() == null)
                throw new ValueError(ctx.ID() + " is not valid INSTRUMENT", getLine(ctx), getCol(ctx));
            ;
            String instrumentName = ctx.INSTRUMENT_VALUE().getText();
            Instrument instrument = valueOf(instrumentName);
            main.instrument = instrument;
            switch (instrument) {
                case PIANO:
                    main.channels[0].programChange(0);
                    break;
                case HARPSICHORD:
                    main.channels[0].programChange(6);
                    break;
                case XYLOPHONE:
                    main.channels[0].programChange(13);
                    break;
                case ORGAN:
                    main.channels[0].programChange(16);
                    break;
                case CHURCH_ORGAN:
                    main.channels[0].programChange(19);
                    break;
                case ACCORDION:
                    main.channels[0].programChange(21);
                    break;
                case HARMONICA:
                    main.channels[0].programChange(22);
                    break;
                case GUITAR:
                    main.channels[0].programChange(25);
                    break;
                case ELECTRIC_GUITAR:
                    main.channels[0].programChange(27);
                    break;
                case BASS:
                    main.channels[0].programChange(33);
                    break;
                case VIOLIN:
                    main.channels[0].programChange(40);
                    break;
                case VIOLA:
                    main.channels[0].programChange(41);
                    break;
                case CELLO:
                    main.channels[0].programChange(42);
                    break;
                case CONTRABASS:
                    main.channels[0].programChange(43);
                    break;
                case HARP:
                    main.channels[0].programChange(46);
                    break;
                case TRUMPET:
                    main.channels[0].programChange(56);
                    break;
                case TROMBONE:
                    main.channels[0].programChange(57);
                    break;
                case TUBA:
                    main.channels[0].programChange(58);
                    break;
                case SAXOPHONE:
                    main.channels[0].programChange(65);
                    break;
                case OBOE:
                    main.channels[0].programChange(68);
                    break;
                case ENGLISH_HORN:
                    main.channels[0].programChange(69);
                    break;
                case BASSOON:
                    main.channels[0].programChange(70);
                    break;
                case CLARINET:
                    main.channels[0].programChange(71);
                    break;
                case FLUTE:
                    main.channels[0].programChange(73);
                    break;
                case DRUMS:
                    main.channels[9].programChange(35);
                    break;
                default:
                    throw new ValueError(instrument + "is not valid INSTRUMENT", getLine(ctx), getCol(ctx));
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
    @Override
    public T visitDistortion(MusicParser.DistortionContext ctx) {
        if (mainCtx != null) {
            if (ctx.INT_VAL() != null) {
                main.distortion = Integer.parseInt(ctx.INT_VAL().getText());
                if (main.instrument == DRUMS) main.channels[9].controlChange(93, main.distortion);
                else main.channels[0].controlChange(93, main.distortion);
            } else if (ctx.ID() != null) {
                VarInfo var = main.memory.get(ctx.ID().getText());
                if (var == null)
                    throw new ScopeError("Variable not definied: " + ctx.ID().getText(), getLine(ctx), getCol(ctx));
                if (var.type != Type.INT)
                    throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + "Type " + var.type + "not int", getLine(ctx), getCol(ctx));
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
    @Override
    public T visitJazz(MusicParser.JazzContext ctx) {
        if (mainCtx != null) {
            if (ctx.BOOL_VAL() != null) main.jazz = ctx.BOOL_VAL().getText().equals("true");
            else if (ctx.ID() != null) {
                VarInfo var = main.memory.get(ctx.ID().getText());
                if (var == null)
                    throw new ScopeError("Variable not definied: " + ctx.ID().getText(), getLine(ctx), getCol(ctx));
                if (var.type != Type.BOOL)
                    throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + "Type " + var.type + "not int", getLine(ctx), getCol(ctx));
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
    @Override
    public T visitBlues(MusicParser.BluesContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitVolume(MusicParser.VolumeContext ctx) {
        if (mainCtx != null) {
            if (ctx.INT_VAL() != null) main.volume = Integer.parseInt(ctx.INT_VAL().getText());
            else if (ctx.ID() != null) {
                VarInfo var = main.memory.get(ctx.ID().getText());
                if (var == null)
                    throw new ScopeError("Variable not definied: " + ctx.ID().getText(), getLine(ctx), getCol(ctx));
                if (var.type != Type.INT)
                    throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + "Type " + var.type + "not int", getLine(ctx), getCol(ctx));
                IntValue varInt = (IntValue) var.valueObj;
                main.volume = varInt.value;
            }
        }
        return visitChildren(ctx);
    }

    @Override
    public T visitVibrato(MusicParser.VibratoContext ctx) {
        return null;
    }

    @Override
    public T visitBalance(MusicParser.BalanceContext ctx) {
        return null;
    }

    @Override
    public T visitSostenutoPedal(MusicParser.SostenutoPedalContext ctx) {
        return null;
    }

    @Override
    public T visitSoftPedal(MusicParser.SoftPedalContext ctx) {
        return null;
    }

    @Override
    public T visitResonance(MusicParser.ResonanceContext ctx) {
        return null;
    }

    @Override
    public T visitReverb(MusicParser.ReverbContext ctx) {
        return null;
    }

    @Override
    public T visitTremolo(MusicParser.TremoloContext ctx) {
        return null;
    }

    @Override
    public T visitChorus(MusicParser.ChorusContext ctx) {
        return null;
    }

    @Override
    public T visitPhraser(MusicParser.PhraserContext ctx) {
        return null;
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public T visitSettingsValues(MusicParser.SettingsValuesContext ctx) {
        if(ctx.BLUES() != null) return (T)(new BoolValue(main.blues));
        if(ctx.JAZZ() != null) return (T)(new BoolValue(main.jazz));
        if(ctx.SUSTAIN() != null) return (T)(new IntValue(main.sustain));
        if(ctx.DISTORTION() != null) return (T)(new IntValue(main.distortion));
        if(ctx.PACE() != null) return (T)(new IntValue(main.pace));
        if(ctx.VOLUME() != null) return (T)(new IntValue(main.volume));
        if(ctx.INSTRUMENT() != null) return (T)(main.instrument);
        else throw new SyntaxError("Syntax error", getLine(ctx), getCol(ctx));
    }


    @Override
    public T visitAssignment(MusicParser.AssignmentContext ctx) {
        VarInfo varInfo =null;
        if(ctx.ID() != null)  varInfo = main.memory.get(ctx.ID().getText());
        if(varInfo==null) throw new ScopeError("Variable not definied: " + ctx.ID().getText(), getLine(ctx), getCol(ctx));
        Value exprValue = (Value) visit(ctx.expr());
        if(exprValue.getType()!=varInfo.type){
            throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + "Type " + varInfo.type + "not: " + exprValue.getType(), getLine(ctx), getCol(ctx));
        }
        varInfo.valueObj = exprValue;

        //To check if everything is okey, will be deleted in a future
        System.out.println(main.memory.get(varInfo.name).toString());

        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitSelfAssignment(MusicParser.SelfAssignmentContext ctx) {
        return visitChildren(ctx);
    }

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
        return visitChildren(ctx);
    }

    @Override
    public T visitPlayStatement(MusicParser.PlayStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override
    public T visitPlayNote(MusicParser.PlayNoteContext ctx) {


        int duration = 0;
        if (ctx.INT_VAL() != null) duration = Integer.parseInt(ctx.INT_VAL().getText());
        else if (ctx.ID() != null) {
            VarInfo var = main.memory.get(ctx.ID().getText());
            if (var == null)
                throw new ScopeError("Variable not definied: " + ctx.ID().getText(), getLine(ctx), getCol(ctx));
            if (var.type != Type.INT)
                throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + "Type " + var.type + "not int", getLine(ctx), getCol(ctx));
            IntValue varInt = (IntValue) var.valueObj;
            duration = varInt.value;
        }
        Note note = Note.valueOf(ctx.NOTE_VAL().getText().replace('#', 's').replace('-', 'm'));
        playNote(note, duration);
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitPlayChord(MusicParser.PlayChordContext ctx) {
        ChordValue chord = (ChordValue) visit(ctx.chord());
        int duration = 0;
        if (ctx.INT_VAL() != null) duration = Integer.parseInt(ctx.INT_VAL().getText());
        else if (ctx.ID() != null) {
            VarInfo var = main.memory.get(ctx.ID().getText());
            if (var == null)
                throw new ScopeError("Variable not definied: " + ctx.ID().getText(), getLine(ctx), getCol(ctx));
            if (var.type != Type.INT)
                throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + "Type " + var.type + "not int", getLine(ctx), getCol(ctx));
            IntValue varInt = (IntValue) var.valueObj;
            duration = varInt.value;

        }
        playChord(chord.notes, duration);

        return visitChildren(ctx);

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitPlayFunc(MusicParser.PlayFuncContext ctx) {
        return visitChildren(ctx);
    }


    /**
     * Function for handling playing an id which requires setting up length for it
     * or playing a track which does not require that
     * Just check whether it has any id/int_val that is after the first appearance of the id
     */
    @Override
    public T visitPlayIDVariants(MusicParser.PlayIDVariantsContext ctx) {
        //playing note
        if(ctx.INT_VAL() !=null || ctx.ID(1)!=null){
            VarInfo noteInfo = main.memory.get(ctx.ID(0).getText());
            if (noteInfo == null)
                throw new ScopeError("Variable not definied: " + ctx.ID(0).getText(), getLine(ctx), getCol(ctx));
            NoteValue noteVal = (NoteValue) noteInfo.valueObj;
            int duration = 0;
            if (ctx.INT_VAL() != null) duration = Integer.parseInt(ctx.INT_VAL().getText());
            else if (ctx.ID(1) != null) {
                VarInfo var = main.memory.get(ctx.ID(0).getText());
                if (var == null)
                    throw new ScopeError("Variable not definied: " + ctx.ID(1).getText(), getLine(ctx), getCol(ctx));
                if (var.type != Type.INT)
                    throw new ValueError("Incorrect type of variable: " + ctx.ID(1).getText() + "Type " + var.type + "not int", getLine(ctx), getCol(ctx));
                IntValue varInt = (IntValue) var.valueObj;
                duration = varInt.value;
            }
            playNote(noteVal.note, duration);
        }
        return visitChildren(ctx);
    }


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override
    public T visitPlayMulti(MusicParser.PlayMultiContext ctx) {
        for (MusicParser.MultiPlayValuesContext multi : ctx.multiPlayValues()) {
            visit(multi);
        }
        return null;
    }

    @Override
    public T visitMultiPlayValues(MusicParser.MultiPlayValuesContext ctx) {
        int duration = 0;
        int lastId = ctx.ID().size() - 1;

        if (ctx.INT_VAL() != null) {
            duration = Integer.parseInt(ctx.INT_VAL().getText());
        } else if (ctx.ID(lastId) != null) {
            VarInfo var = main.memory.get(ctx.ID(lastId).getText());
            if (var == null) throw new ScopeError("Variable not definied: ", getLine(ctx), getCol(ctx));
            if (var.type != Type.INT)
                throw new ValueError("Incorrect type of variable: " + ctx.ID(lastId).getText() + "Type " + var.type + "not int", getLine(ctx), getCol(ctx));
            duration = ((IntValue) var.valueObj).value;
        }

        for (int i = 0; i < ctx.getChildCount() - 1; i++) {
            ParseTree child = ctx.getChild(i);
            if (visit(child) instanceof ChordValue) {
                ChordValue chord = (ChordValue) visit(child);
                playChord(chord.notes, duration);
            } else if (visit(child) instanceof NoteValue) {
                NoteValue note = (NoteValue) visit(child);
                playNote(note.note, duration);
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
    @Override
    public T visitPauseStatement(MusicParser.PauseStatementContext ctx) {
        if (mainCtx != null) {
            try {

                int sleep = 0;
                if (ctx.INT_VAL() != null) sleep = Integer.parseInt(ctx.INT_VAL().getText());
                else if (ctx.ID() != null) {
                    VarInfo var = main.memory.get(ctx.ID().getText());
                    if (var == null)
                        throw new ScopeError("Variable not definied: " + ctx.ID().getText(), getLine(ctx), getCol(ctx));
                    if (var.type != Type.INT)
                        throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + "Type " + var.type + "not int", getLine(ctx), getCol(ctx));
                    IntValue varInt = (IntValue) var.valueObj;
                    sleep = varInt.value;
                }
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
        return visitChildren(ctx);
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitForLoop(MusicParser.ForLoopContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override
    public T visitForInit(MusicParser.ForInitContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitForUpdate(MusicParser.ForUpdateContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitForAssignment(MusicParser.ForAssignmentContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitBreakStatement(MusicParser.BreakStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitContinueStatement(MusicParser.ContinueStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitFunctionCall(MusicParser.FunctionCallContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitArguments(MusicParser.ArgumentsContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitSettingsList(MusicParser.SettingsListContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitNoteExpr(MusicParser.NoteExprContext ctx) {
        return (T) parseNote(ctx.NOTE_VAL().getText());
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitOrOperatorExpr(MusicParser.OrOperatorExprContext ctx) {
        Value firstValue = (Value) visit(ctx.expr(0));
        Value secondValue = (Value) visit(ctx.expr(1));
        if(firstValue == null || secondValue == null){
            throw new ValueError("Incorrect type of expression: INSTRUMENT not BOOL", getLine(ctx), getCol(ctx));
        }
        if(firstValue instanceof BoolValue && secondValue instanceof BoolValue) {
            BoolValue boolExpr1 = (BoolValue) firstValue;
            BoolValue boolExpr2 = (BoolValue) secondValue;
            return (T)(new BoolValue(boolExpr1.value || boolExpr2.value));
        }
        else if(firstValue instanceof BoolValue)
            throw new ValueError("Incorrect type of expression: "   +secondValue.getType() + " not BOOL", getLine(ctx), getCol(ctx));
        else
            throw new ValueError("Incorrect type of expression: "   +firstValue.getType() + " not BOOL", getLine(ctx), getCol(ctx));
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitNotExpr(MusicParser.NotExprContext ctx) {
        Value expr = (Value)visit(ctx.expr());
        if(expr == null)
            throw new ValueError("Incorrect type of expression: INSTRUMENT not BOOL", getLine(ctx), getCol(ctx));
        if (expr instanceof BoolValue) {
            BoolValue boolExpr = (BoolValue) expr;
            boolExpr.value = !boolExpr.value;
            return (T) boolExpr;
        }
        else throw new  ValueError("Incorrect type of expression: "   +expr.getType() + " not BOOL", getLine(ctx), getCol(ctx));
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitOrderOperatorExpr(MusicParser.OrderOperatorExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitInstrumentOperatorExpr(MusicParser.InstrumentOperatorExprContext ctx) {
        return null;
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitAddSubOperatorExpr(MusicParser.AddSubOperatorExprContext ctx) {
        Value firstValue = (Value) visit(ctx.expr(0));
        Value secondValue = (Value) visit(ctx.expr(1));
        if(firstValue == null || secondValue == null){
            //That means it's INSTRUMENT in expr which is prohibited
            //TODO
            throw new ArithmeticException("Cannot interpret instrument value in add/sub operation");
        }
        if(firstValue.getType()==Type.INT && secondValue.getType()==Type.INT ) {
            int firstInt = ((IntValue)firstValue).value;
            int secondInt = ((IntValue)secondValue).value;
            int resultInt = 0;
            if(ctx.addSubOp().SUB() != null) resultInt = firstInt - secondInt;
            else resultInt = firstInt + secondInt;
            Value result = new IntValue(resultInt);
            return (T) result;
        }
        if(firstValue.getType()==Type.NOTE && secondValue.getType()==Type.INT ){
            Note note = ((NoteValue)firstValue).note;
            int intVal = ((IntValue)secondValue).value;
            int noteIntVal = main.notes.get(note);
            if(ctx.addSubOp().SUB() != null) noteIntVal -= intVal;
            else noteIntVal +=  intVal;
            if(noteIntVal<0 || noteIntVal >84) throw new ArithmeticException("Note's limit exceeded"); //TODO
            int finalNoteIntVal = noteIntVal;
            Note newNote = main.notes.entrySet().stream()
                    .filter(pair -> pair.getValue().equals(finalNoteIntVal))
                    .findFirst()
                    .map(Map.Entry::getKey).orElse(null);
            if(newNote == null) throw new RuntimeException(); //TODO
            Value result = new NoteValue(newNote);
            return (T) result;
        }
        else throw new ArithmeticException("Invalid arguments for add/subtract operation"); //TODO: create new exception
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitAndOperatorExpr(MusicParser.AndOperatorExprContext ctx) {
        Value firstValue = (Value) visit(ctx.expr(0));
        Value secondValue = (Value) visit(ctx.expr(1));
        if(firstValue == null || secondValue == null){
            throw new ValueError("Incorrect type of expression: INSTRUMENT not BOOL", getLine(ctx), getCol(ctx));
        }
        if(firstValue instanceof BoolValue && secondValue instanceof BoolValue) {
            BoolValue boolExpr1 = (BoolValue) firstValue;
            BoolValue boolExpr2 = (BoolValue) secondValue;
            return (T)(new BoolValue(boolExpr1.value && boolExpr2.value));
        }
        else if(firstValue instanceof BoolValue)
            throw new ValueError("Incorrect type of expression: "   +secondValue.getType() + " not BOOL", getLine(ctx), getCol(ctx));
        else
            throw new ValueError("Incorrect type of expression: "   +firstValue.getType() + " not BOOL", getLine(ctx), getCol(ctx));
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitMullDivOperatorExpr(MusicParser.MullDivOperatorExprContext ctx) {
        Value firstValue = (Value) visit(ctx.expr(0));
        Value secondValue = (Value) visit(ctx.expr(1));
        if(firstValue == null || secondValue == null){
            //That means it's INSTRUMENT in expr which is prohibited
            //TODO
            throw new ArithmeticException("Cannot interpret instrument value in add/sub operation");
        }
        if(firstValue.getType()==Type.INT && secondValue.getType()==Type.INT ) {
            int firstInt = ((IntValue)firstValue).value;
            int secondInt = ((IntValue)secondValue).value;
            int resultInt = 0;

            if(ctx.mullDivOp().MUL() != null) resultInt = firstInt * secondInt;
            else if(secondInt !=0) resultInt = firstInt / secondInt;
            else throw new ArithmeticException("Division by zero!"); //TODO
            Value result = new IntValue(resultInt);
            return (T) result;
        }
        if(firstValue.getType()==Type.NOTE && secondValue.getType()==Type.INT ){
            Note note = ((NoteValue)firstValue).note;
            int intVal = ((IntValue)secondValue).value;
            int noteIntVal = main.notes.get(note);
            if(noteIntVal<1) throw new ArithmeticException("Invalid operation"); //TODO

            if(ctx.mullDivOp().MUL() != null) noteIntVal += (intVal-1)*12;
            else noteIntVal -=  (intVal-1)*12;
            noteIntVal = Math.abs(noteIntVal)%85;

            int finalNoteIntVal = noteIntVal;
            Note newNote = main.notes.entrySet().stream()
                    .filter(pair -> pair.getValue().equals(finalNoteIntVal))
                    .findFirst()
                    .map(Map.Entry::getKey).orElse(null);
            if(newNote == null) throw new RuntimeException(); //TODO
            Value result = new NoteValue(newNote);
            return (T) result;
        }
        else throw new ArithmeticException("Invalid arguments for mull/div operation"); //TODO: create new exception
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitBoolExpr(MusicParser.BoolExprContext ctx) {
        if(ctx.BOOL_VAL()!=null){
            BoolValue result = new BoolValue(ctx.BOOL_VAL().getText().equals("true"));
            return (T) result;
        }
        throw new SyntaxError("Bool value not found", getLine(ctx), getCol(ctx));
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitParanthesesExpr(MusicParser.ParanthesesExprContext ctx) {
        return visit(ctx.expr());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitIdExpr(MusicParser.IdExprContext ctx) {
        VarInfo varInfo = main.memory.get(ctx.ID().getText());
        if(varInfo == null) throw new RuntimeException("No such variable defined"); //TODO
        return (T)varInfo.valueObj;
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitOrderOp(MusicParser.OrderOpContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitEqOp(MusicParser.EqOpContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitAndOp(MusicParser.AndOpContext ctx) {
        return visitChildren(ctx);
    }

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
        return visitChildren(ctx);
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitMullDivOp(MusicParser.MullDivOpContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitIntExpr(MusicParser.IntExprContext ctx) {
        return visit(ctx.intVal());
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitEqOperatorExpr(MusicParser.EqOperatorExprContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitSettingsExpr(MusicParser.SettingsExprContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitChordExpr(MusicParser.ChordExprContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override
    public T visitAssOp(MusicParser.AssOpContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitChord(MusicParser.ChordContext ctx) {
        List<NoteValue> notes = new ArrayList<>();
        for (TerminalNode node : ctx.NOTE_VAL()) {
            Note note = Note.valueOf(node.getText().replace('#', 's').replace('-', 'm'));
            notes.add(new NoteValue(note));
        }
        return (T) (new ChordValue(notes));

    }

    @Override
    public T visitTrackAdd(MusicParser.TrackAddContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitTrackDeclare(MusicParser.TrackDeclareContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitTrackStatement(MusicParser.TrackStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitTrackDeclaration(MusicParser.TrackDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitIntVal(MusicParser.IntValContext ctx) {
        IntValue valueInt = new IntValue(Integer.parseInt(ctx.INT_VAL().getText()));
        if(ctx.SUB() != null) valueInt.value *= -1;
        return (T) valueInt;
    }

    /**
     * This function is invoked when visiting Terminal Nodes
     * for now it only tries to parse it as Note
     */
    @Override
    public T visitTerminal(TerminalNode node) {
        if (parseNote(node.getText()) != null) {
            return (T) parseNote(node.getText());
        }
        return (T) node;
    }

    private NoteValue parseNote(String noteText) {
        try {
            Note note = Note.valueOf(noteText.replace('#', 's').replace('-', 'm'));
            return new NoteValue(note);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private int getLine(ParserRuleContext ctx) {
        return ctx.getStart().getLine();
    }

    private int getCol(ParserRuleContext ctx) {
        return ctx.getStart().getCharPositionInLine();
    }

    private void playChord(List<NoteValue> notes, Integer duration) {
        List<Integer> notesInt = new ArrayList<>();
        for (NoteValue note : notes) {
            notesInt.add(main.notes.get(note.note));
        }

        try {
            if (main.instrument == DRUMS) {
                main.playChord(main.channels[9], notesInt, duration, main.volume);
            } else {
                main.playChord(main.channels[0], notesInt, duration, main.volume);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void playNote(Note note, Integer duration) {
        Integer noteInt = main.notes.get(note);
        try {
            if (main.instrument == DRUMS) {
                main.playNote(main.channels[9], noteInt, duration, main.volume);
            } else {
                main.playNote(main.channels[0], noteInt, duration, main.volume);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}