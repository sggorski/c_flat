package pl.edu.agh;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import pl.edu.agh.errors.*;
import pl.edu.agh.utils.*;
import pl.edu.agh.utils.Instrument;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

import static pl.edu.agh.utils.Instrument.*;


@SuppressWarnings("CheckReturnValue")
public class MusicSuperVisitor<T> extends MusicBaseVisitor<T> implements MusicVisitor<T> {
    MainMelody main;
    MusicParser.MainDeclContext mainCtx = null;
    MusicParser.FunctionDeclContext funcCtx = null;

    public MusicSuperVisitor(MainMelody main) {
        this.main = main;
    }

    @Override
    public T visitProgram(MusicParser.ProgramContext ctx) throws RuntimeException {
        return visitChildren(ctx);
    }

    @Override
    public T visitImports(MusicParser.ImportsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitFunctionDecl(MusicParser.FunctionDeclContext ctx) {
        funcCtx = ctx;
        return visitChildren(ctx);
    }

    @Override
    public T visitMainDecl(MusicParser.MainDeclContext ctx) {
        mainCtx = ctx;
        return visitChildren(ctx);
    }

    @Override
    public T visitParameters(MusicParser.ParametersContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitParameter(MusicParser.ParameterContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitType(MusicParser.TypeContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitMainStatement(MusicParser.MainStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitStatement(MusicParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitLoopStatement(MusicParser.LoopStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitSettings(MusicParser.SettingsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitPace(MusicParser.PaceContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.PACE, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitSustain(MusicParser.SustainContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.SUSTAIN, this);
        return visitChildren(ctx);
    }


    @Override
    public T visitInstrument(MusicParser.InstrumentContext ctx) {
        if (main != null) {
            // If not Instrument_Value then it is recognised as ID, if not then it should be a lexer error
            if (ctx.INSTRUMENT_VALUE() == null)
                throw new ValueError(ctx.ID() + " is not valid INSTRUMENT", getLine(ctx), getCol(ctx));
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


    @Override
    public T visitDistortion(MusicParser.DistortionContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.DISTORTION, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitJazz(MusicParser.JazzContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.JAZZ, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitBlues(MusicParser.BluesContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.BLUES, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitVolume(MusicParser.VolumeContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.VOLUME, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitVibrato(MusicParser.VibratoContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.VIBRATO, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitBalance(MusicParser.BalanceContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.BALANCE, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitSostenutoPedal(MusicParser.SostenutoPedalContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.SOSTENUTO, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitSoftPedal(MusicParser.SoftPedalContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.SOFT, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitResonance(MusicParser.ResonanceContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.RESONANCE, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitReverb(MusicParser.ReverbContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.REVERB, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitTremolo(MusicParser.TremoloContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.TREMOLO, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitChorus(MusicParser.ChorusContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.CHORUS, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitPhraser(MusicParser.PhraserContext ctx) {
        this.main.editEffect(mainCtx, ctx, Effect.PHRASER, this);
        return visitChildren(ctx);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitSettingsValues(MusicParser.SettingsValuesContext ctx) {
        if(ctx.BLUES() != null) return (T)(main.effects.get(Effect.BLUES));
        if(ctx.JAZZ() != null) return (T)(main.effects.get(Effect.JAZZ));
        if(ctx.SUSTAIN() != null) return (T)(main.effects.get(Effect.SUSTAIN));
        if(ctx.DISTORTION() != null) return (T)(main.effects.get(Effect.DISTORTION));
        if(ctx.PACE() != null) return (T)(main.effects.get(Effect.PACE));
        if(ctx.VOLUME() != null) return (T)(main.effects.get(Effect.VOLUME));
        if(ctx.VIBRATO() != null) return (T)(main.effects.get(Effect.VIBRATO));
        if(ctx.BALANCE() != null) return (T)(main.effects.get(Effect.BALANCE));
        if(ctx.SOSTENUTO() != null) return (T)(main.effects.get(Effect.SOSTENUTO));
        if(ctx.SOFT() != null) return (T)(main.effects.get(Effect.SOFT));
        if(ctx.RESONANCE() != null) return (T)(main.effects.get(Effect.RESONANCE));
        if(ctx.REVERB() != null) return (T)(main.effects.get(Effect.REVERB));
        if(ctx.TREMOLO() != null) return (T)(main.effects.get(Effect.TREMOLO));
        if(ctx.CHORUS() != null) return (T)(main.effects.get(Effect.CHORUS));
        if(ctx.PHRASER() != null) return (T)(main.effects.get(Effect.PHRASER));
        if(ctx.INSTRUMENT() != null) return (T)(main.instrument);
        else throw new SyntaxError("Syntax error", getLine(ctx), getCol(ctx));
    }

    @Override
    public T visitAssignment(MusicParser.AssignmentContext ctx) {
        VarInfo varInfo = extractVariable(ctx, ctx.ID(),null);
        Value exprValue = tryCasting(ctx.expr());
        if(exprValue.getType()!=varInfo.type){
            throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + " Type " + varInfo.type + " not: " + exprValue.getType(), getLine(ctx), getCol(ctx));
        }
        varInfo.valueObj = exprValue;

        //To check if everything is ok, will be deleted in a future
        System.out.println(main.memory.get(varInfo.name).toString());
        return visitChildren(ctx);
    }


    @Override
    public T visitSelfAssignment(MusicParser.SelfAssignmentContext ctx) {
        VarInfo varInfo = extractVariable(ctx,ctx.ID(),null);
        Value exprValue = tryCasting(ctx.expr());
        if(varInfo.type == Type.INT && exprValue.getType()==Type.INT){
            IntValue intValue = (IntValue)exprValue;
            IntValue intVar = (IntValue)varInfo.valueObj;
            if(ctx.assOp().SUMIS() != null) intVar.value += intValue.value;
            else if(ctx.assOp().SUBIS() != null) intVar.value -= intValue.value;
            else if (ctx.assOp().MULIS() != null) intVar.value *= intValue.value;
            else if (ctx.assOp().DIVIS() != null && intValue.value!=0) intVar.value /= intValue.value;
            else throw new ArithmeticOperationError("Division by zero", getLine(ctx), getCol(ctx));
        }
        else if (varInfo.type == Type.NOTE && exprValue.getType()==Type.INT){
            IntValue intValue = (IntValue)exprValue;
            NoteValue noteValue = (NoteValue)varInfo.valueObj;
            int newNoteValue;
            int oldNoteValue = NoteMap.notes.get(noteValue.note);
            if(ctx.assOp().SUMIS() != null) newNoteValue = oldNoteValue + intValue.value;
            else if(ctx.assOp().SUBIS() != null) newNoteValue = oldNoteValue - intValue.value;
            else if(ctx.assOp().MULIS() != null && intValue.value>=1) newNoteValue = oldNoteValue + (intValue.value-1)*12;
            else if(ctx.assOp().DIVIS() != null && intValue.value>=1) newNoteValue = oldNoteValue - (intValue.value-1)*12;
            else throw new ArithmeticOperationError("Invalid operation with notes", getLine(ctx), getCol(ctx));
            newNoteValue = Math.abs(newNoteValue)%85;
            noteValue.note = findNote(newNoteValue);
        }
        else if(varInfo.type == Type.CHORD && exprValue.getType()==Type.NOTE){
            NoteValue noteValue = (NoteValue)exprValue;
            ChordValue chordValue = (ChordValue)varInfo.valueObj;
            if(ctx.assOp().SUMIS() != null ) chordValue.notes.add(noteValue);
            else if(ctx.assOp().SUBIS() != null){
                if(chordValue.notes.size()<=2) throw new ArithmeticOperationError("Invalid operation with chords", getLine(ctx), getCol(ctx));
                chordValue.notes.remove(noteValue);
            }
            else throw new ArithmeticOperationError("Invalid operation with chords", getLine(ctx), getCol(ctx));
        }
        else throw new ArithmeticOperationError("Invalid operation", getLine(ctx), getCol(ctx));
        System.out.println(varInfo);
        return visitChildren(ctx);
    }


    @Override
    public T visitVarDeclWithARg(MusicParser.VarDeclWithARgContext ctx) {
        String varName = ctx.ID().getText();
        VarInfo varInfo = this.main.memory.get(varName);

        Value val = tryCasting(ctx.expr());



        if(val.getType()!=varInfo.type) {
            throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + " Type " + varInfo.type + " not: " + val.getType(), getLine(ctx), getCol(ctx));
        }
        varInfo.valueObj = val;

        System.out.println(main.memory.get(varInfo.name).toString());
        return visitChildren(ctx);
    }


    @Override
    public T visitVarDeclWithoutArg(MusicParser.VarDeclWithoutArgContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitPlayStatement(MusicParser.PlayStatementContext ctx) {
        return visitChildren(ctx);
    }



    @Override
    public T visitPlayNote(MusicParser.PlayNoteContext ctx) {
        int duration;
        if (ctx.INT_VAL() != null) duration = Integer.parseInt(ctx.INT_VAL().getText());
        else {
            IntValue varInt = (IntValue) extractVariable(ctx,ctx.ID(),Type.INT).valueObj;
            duration = varInt.value;
        }
        Note note = Note.valueOf(ctx.NOTE_VAL().getText().replace('#', 's').replace('-', 'm'));
        playNote(note, duration);
        return visitChildren(ctx);
    }


    @Override
    public T visitPlayChord(MusicParser.PlayChordContext ctx) {
        ChordValue chord = (ChordValue) visit(ctx.chord());
        int duration = 0;
        if (ctx.INT_VAL() != null) duration = Integer.parseInt(ctx.INT_VAL().getText());
        else if (ctx.ID() != null) {
            IntValue varInt = (IntValue) extractVariable(ctx,ctx.ID(),Type.INT).valueObj;
            duration = varInt.value;
        }
        playChord(chord.notes, duration);
        return visitChildren(ctx);

    }

    @Override
    public T visitPlayFunc(MusicParser.PlayFuncContext ctx) {
        return visitChildren(ctx);
    }



    @Override
    public T visitPlayIDVariants(MusicParser.PlayIDVariantsContext ctx) {
        //playing note or chord
        if(ctx.INT_VAL() !=null || ctx.ID(1)!=null){
            VarInfo varInfo = main.memory.get(ctx.ID(0).getText());
            if (varInfo == null)
                throw new ScopeError("Variable not defined: " + ctx.ID(0).getText(), getLine(ctx), getCol(ctx));
            int duration = 0;
            if (ctx.INT_VAL() != null) duration = Integer.parseInt(ctx.INT_VAL().getText());
            else if (ctx.ID(1) != null) {
                IntValue varInt = (IntValue) extractVariable(ctx,ctx.ID(1),Type.INT).valueObj;
                duration = varInt.value;
            }
            if(varInfo.type==Type.NOTE){
                NoteValue noteVal = (NoteValue) varInfo.valueObj;
                playNote(noteVal.note, duration);
            }
            else{
                ChordValue chordVal = (ChordValue) varInfo.valueObj;
                playChord(chordVal.notes, duration);
            }
        }
        return visitChildren(ctx);
    }



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
            if (var == null) throw new ScopeError("Variable not defined: ", getLine(ctx), getCol(ctx));
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
            else {
                VarInfo varInfo = main.memory.get(ctx.ID(i).getText());
                if(varInfo.type==Type.NOTE){
                    NoteValue noteVal = (NoteValue) varInfo.valueObj;
                    playNote(noteVal.note, duration);
                }
                else{
                    ChordValue chordVal = (ChordValue) varInfo.valueObj;
                    playChord(chordVal.notes, duration);
                }
            }
        }
        return visitChildren(ctx);
    }


    @Override
    public T visitPauseStatement(MusicParser.PauseStatementContext ctx) {
        if (mainCtx != null) {
            try {
                int sleep = 0;
                if (ctx.INT_VAL() != null) sleep = Integer.parseInt(ctx.INT_VAL().getText());
                else if (ctx.ID() != null) {
                    VarInfo var = main.memory.get(ctx.ID().getText());
                    if (var == null)
                        throw new ScopeError("Variable not defined: " + ctx.ID().getText(), getLine(ctx), getCol(ctx));
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


    @Override
    public T visitWhileLoop(MusicParser.WhileLoopContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitIf(MusicParser.IfContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitForLoop(MusicParser.ForLoopContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitForInit(MusicParser.ForInitContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitForUpdate(MusicParser.ForUpdateContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitForAssignment(MusicParser.ForAssignmentContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitBreakStatement(MusicParser.BreakStatementContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitContinueStatement(MusicParser.ContinueStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitFunctionCall(MusicParser.FunctionCallContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitArguments(MusicParser.ArgumentsContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitSettingsList(MusicParser.SettingsListContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitNoteExpr(MusicParser.NoteExprContext ctx) {
        return (T) parseNote(ctx.NOTE_VAL().getText());
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitOrOperatorExpr(MusicParser.OrOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));

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


    @Override
    @SuppressWarnings("unchecked")
    public T visitNotExpr(MusicParser.NotExprContext ctx) {
        Value expr = tryCasting(ctx.expr());
        if (expr instanceof BoolValue) {
            BoolValue boolExpr = (BoolValue) expr;
            boolExpr.value = !boolExpr.value;
            return (T) boolExpr;
        }
        else throw new  ValueError("Incorrect type of expression: "   +expr.getType() + " not BOOL", getLine(ctx), getCol(ctx));
    }


    @Override
    @SuppressWarnings("unchecked")
    public T visitOrderOperatorExpr(MusicParser.OrderOperatorExprContext ctx) {
        Value firstValue =  tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));

        BiPredicate<Integer, Integer> predicate = (x,y) -> false;
        if(ctx.orderOp().GT() != null) predicate = (x,y) -> x > y;
        if(ctx.orderOp().LT() != null) predicate = (x,y) -> x < y;
        if(ctx.orderOp().GEQ() != null) predicate = (x,y) -> x >= y;
        if(ctx.orderOp().LEQ() != null) predicate = (x,y) -> x <= y;

        if(firstValue instanceof IntValue && secondValue instanceof IntValue) {
            return (T) new BoolValue(predicate.test(((IntValue) firstValue).value, ((IntValue) secondValue).value));
        }
        else if(firstValue instanceof NoteValue && secondValue instanceof NoteValue) {
            return (T) new BoolValue(predicate.test(NoteMap.notes.get(((NoteValue) firstValue).note), NoteMap.notes.get(((NoteValue) secondValue).note)));
        }
        else throw new ArithmeticOperationError("Incorrect type of comparison!", getLine(ctx), getCol(ctx));
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitInstrumentOperatorExpr(MusicParser.InstrumentOperatorExprContext ctx) {
        return (T)new BoolValue(main.instrument.toString().equals(ctx.INSTRUMENT_VALUE().getText()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitAddSubOperatorExpr(MusicParser.AddSubOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));

        if(firstValue.getType()==Type.INT && secondValue.getType()==Type.INT ) {
            int firstInt = ((IntValue)firstValue).value;
            int secondInt = ((IntValue)secondValue).value;
            int resultInt;
            if(ctx.addSubOp().SUB() != null)
                resultInt = firstInt - secondInt;
            else
                resultInt = firstInt + secondInt;
            Value result = new IntValue(resultInt);
            return (T) result;
        }
        if(firstValue.getType()==Type.NOTE && secondValue.getType()==Type.INT ){
            Note note = ((NoteValue)firstValue).note;
            int intVal = ((IntValue)secondValue).value;
            int noteIntVal = NoteMap.notes.get(note);

            if(ctx.addSubOp().SUB() != null) noteIntVal -= intVal;
            else noteIntVal +=  intVal;

            if(noteIntVal<0 || noteIntVal >84)
                throw new ArithmeticOperationError("Note's limit exceeded", getLine(ctx), getCol(ctx));

            Value result = new NoteValue(findNote(noteIntVal));
            return (T) result;
        }
        else throw new ArithmeticOperationError("Invalid arguments for add/subtract operation", getLine(ctx), getCol(ctx));
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitAndOperatorExpr(MusicParser.AndOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));
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


    @Override
    @SuppressWarnings("unchecked")
    public T visitMullDivOperatorExpr(MusicParser.MullDivOperatorExprContext ctx) {
        Value firstValue =  tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));

        if(firstValue.getType()==Type.INT && secondValue.getType()==Type.INT ) {
            int firstInt = ((IntValue)firstValue).value;
            int secondInt = ((IntValue)secondValue).value;
            int resultInt;

            if(ctx.mullDivOp().MUL() != null) resultInt = firstInt * secondInt;
            else if(ctx.mullDivOp().PER() != null) resultInt = firstInt % secondInt;
            else if(secondInt !=0) resultInt = firstInt / secondInt;
            else throw new ArithmeticOperationError("Division by zero!", getLine(ctx), getCol(ctx));
            Value result = new IntValue(resultInt);
            return (T) result;
        }
        if(firstValue.getType()==Type.NOTE && secondValue.getType()==Type.INT ){
            Note note = ((NoteValue)firstValue).note;
            int intVal = ((IntValue)secondValue).value;
            int noteIntVal = NoteMap.notes.get(note);

            if(noteIntVal<1)
                throw new ArithmeticOperationError("Invalid operation", getLine(ctx), getCol(ctx));
            if(ctx.mullDivOp().MUL() != null)
                noteIntVal += (intVal-1)*12;
            else if(ctx.mullDivOp().DIV() !=null ) noteIntVal -=  (intVal-1)*12;
            else throw new ArithmeticOperationError("Invalid operation. % cannot be used with notes", getLine(ctx), getCol(ctx));
            noteIntVal = Math.abs(noteIntVal)%85;
            Value result = new NoteValue(findNote(noteIntVal));
            return (T) result;
        }
        else throw new ArithmeticOperationError("Invalid arguments for mull/div operation", getLine(ctx), getCol(ctx));
    }


    @Override
    @SuppressWarnings("unchecked")
    public T visitBoolExpr(MusicParser.BoolExprContext ctx) {
        if(ctx.BOOL_VAL()!=null){
            BoolValue result = new BoolValue(ctx.BOOL_VAL().getText().equals("true"));
            return (T) result;
        }
        throw new SyntaxError("Bool value not found", getLine(ctx), getCol(ctx));
    }


    @Override
    public T visitParanthesesExpr(MusicParser.ParanthesesExprContext ctx) {
        return visit(ctx.expr());
    }


    @Override
    @SuppressWarnings("unchecked")
    public T visitIdExpr(MusicParser.IdExprContext ctx) {
        VarInfo varInfo = main.memory.get(ctx.ID().getText());
        if(varInfo == null) throw new UndefinedError("No such variable defined", getLine(ctx), getCol(ctx));
        return (T)varInfo.valueObj;
    }


    @Override
    public T visitOrderOp(MusicParser.OrderOpContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitEqOp(MusicParser.EqOpContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitAndOp(MusicParser.AndOpContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitOrOp(MusicParser.OrOpContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitAddSubOp(MusicParser.AddSubOpContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitMullDivOp(MusicParser.MullDivOpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitIntExpr(MusicParser.IntExprContext ctx) {
        return visit(ctx.intVal());
    }


    @Override
    @SuppressWarnings("unchecked")
    public T visitEqOperatorExpr(MusicParser.EqOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));

        if(firstValue.getType()!=secondValue.getType()) {
            return  (T) new BoolValue(false);
        }
        BoolValue result = firstValue.equals(secondValue);
        if(ctx.eqOp().EQ() != null) return (T) result;
        else{
            if(result.value) return (T) new BoolValue(false);
            else return (T) new BoolValue(true);
        }
    }


    @Override
    public T visitSettingsExpr(MusicParser.SettingsExprContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitChordExpr(MusicParser.ChordExprContext ctx) {
        List<NoteValue> notes = new ArrayList<>();
        for (TerminalNode node : ctx.chord().NOTE_VAL()) {
            Note note = Note.valueOf(node.getText().replace('#', 's').replace('-', 'm'));
            notes.add(new NoteValue(note));
        }
        return (T) (new ChordValue(notes));
    }


    @Override
    public T visitAssOp(MusicParser.AssOpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    @SuppressWarnings("unchecked")
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

    @Override
    public T visitTrackStatement(MusicParser.TrackStatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitTrackDeclaration(MusicParser.TrackDeclarationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitIntVal(MusicParser.IntValContext ctx) {
        IntValue valueInt = new IntValue(Integer.parseInt(ctx.INT_VAL().getText()));
        if(ctx.SUB() != null) valueInt.value *= -1;
        return (T) valueInt;
    }

    @Override
    @SuppressWarnings("unchecked")
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
            notesInt.add(NoteMap.notes.get(note.note));
        }

        try {
            if (main.instrument == DRUMS) {
                main.playChord(main.channels[9], notesInt, duration, ((IntValue)main.effects.get(Effect.VOLUME)).value);
            } else {
                main.playChord(main.channels[0], notesInt, duration, ((IntValue)main.effects.get(Effect.VOLUME)).value);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void playNote(Note note, Integer duration) {
        Integer noteInt = NoteMap.notes.get(note);
        try {
            if (main.instrument == DRUMS) {
                main.playNote(main.channels[9], noteInt, duration, ((IntValue)main.effects.get(Effect.VOLUME)).value);
            } else {
                main.playNote(main.channels[0], noteInt, duration, ((IntValue)main.effects.get(Effect.VOLUME)).value);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public VarInfo extractVariable(ParserRuleContext ctx, TerminalNode id, Type type) {
        VarInfo var = main.memory.get(id.getText());
        if (var == null)
            throw new UndefinedError("Variable not defined: " + id.getText(), getLine(ctx), getCol(ctx));
        if(type == null){
            return var;
        }
        if (var.type != type)
            throw new ValueError("Incorrect type of variable: " + id.getText() + "Type " + var.type + " not " + type, getLine(ctx), getCol(ctx));
        return var;
    }

    private Note findNote(int value){
        Note newNote = NoteMap.notes.entrySet().stream()
                .filter(pair -> pair.getValue().equals(value))
                .findFirst()
                .map(Map.Entry::getKey).orElse(null);
        if(newNote == null) throw new RuntimeException(); //TODO
        return newNote;
    }

    private Value tryCasting(MusicParser.ExprContext expr){
        if(visit(expr) == null){
            throw new UndefinedError("Undefined variable: " + " " + expr.getText(), getLine(expr), getCol(expr));
        }
        if(visit(expr) instanceof Instrument){
            throw new ValueError("Incorrect type of expression: INSTRUMENT not allowed here", getLine(expr), getCol(expr));
        }
        return (Value) visit(expr);
    }
}