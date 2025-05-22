package pl.edu.agh;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import pl.edu.agh.errors.*;
import pl.edu.agh.utils.*;
import pl.edu.agh.musicUtils.Instrument;
import pl.edu.agh.musicUtils.*;

import javax.sound.midi.MidiChannel;
import java.util.*;
import java.util.function.BiPredicate;

import static pl.edu.agh.musicUtils.Instrument.*;


@SuppressWarnings("CheckReturnValue")
public class MusicSuperVisitor<T> extends MusicBaseVisitor<T> implements MusicVisitor<T> {
    HashMap<String, Melody> melodyMemory;
    Deque<Melody> stack = new ArrayDeque<>();
    Scope currentScope = null;
    private final Map<Integer, LineOrigin> lineMap;
    HashMap<String, Track> tracks = new HashMap<>();
    String code;
    HashMap<String, VarInfo> globalScope;


    public MusicSuperVisitor(HashMap<String, Melody> melodyMemory, Map<Integer, LineOrigin> lines, String code, HashMap<String, VarInfo> globalScope) {
        this.melodyMemory = melodyMemory;
        this.lineMap = lines;
        this.code = code;
        this.globalScope = globalScope;
        //to finish program when error occurrs in thread
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.err.println(throwable.getMessage());
            System.exit(1);
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitProgram(MusicParser.ProgramContext ctx) throws RuntimeException {
        if(ctx.globalVars() != null) {
            visit(ctx.globalVars());
        }
        if (!melodyMemory.containsKey("main"))
            throw new SyntaxError("No main melody declaration found!", this.lineMap.get(getLine(ctx)), getCol(ctx));
        stack.push(melodyMemory.get("main"));
        for (MusicParser.MainStatementContext statement : melodyMemory.get("main").mainBody) {
            visit(statement);
        }
        //System.out.println(melodyMemory.values().stream().map(e -> e.toString()).collect(Collectors.joining(" ")));
        return (T) (new BoolValue(true)); //everything went ok
    }

    @Override
    public T visitGlobalVars(MusicParser.GlobalVarsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitImports(MusicParser.ImportsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitFunctionDecl(MusicParser.FunctionDeclContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitMainDecl(MusicParser.MainDeclContext ctx) {
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
    public T visitPrint(MusicParser.PrintContext ctx) {
        Value value = tryCasting(ctx.expr());
        int line = getLine(ctx);
        System.out.println("LINE " + line + " :" + value);
        return null;
    }

    @Override
    public T visitReturnStatement(MusicParser.ReturnStatementContext ctx) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        if (ctx.expr() == null) {
            stack.pop();
            currentScope = melody.previous_scope;
            throw new ReturnValue(null);
        }
        Value value = tryCasting(ctx.expr());
        if (melody.name.equals("main")) {
            if (value instanceof BoolValue) {
                BoolValue boolValue = (BoolValue) value;
                System.out.println("MAIN RETURNED: " + boolValue);
            } else if (value instanceof IntValue) {
                IntValue intValue = (IntValue) value;
                System.out.println("MAIN RETURNED: " + intValue);
            } else if (value instanceof NoteValue) {
                NoteValue noteValue = (NoteValue) value;
                System.out.println("MAIN RETURNED: " + noteValue);
            } else if (value instanceof ChordValue) {
                ChordValue chordValue = (ChordValue) value;
                System.out.println("MAIN RETURNED: " + chordValue);
            }
            System.exit(0);
        } else {
            stack.pop();
            currentScope = melody.previous_scope;
            throw new ReturnValue(value);
        }
        return null;
    }

    @Override
    public T visitExprStatement(MusicParser.ExprStatementContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitSettings(MusicParser.SettingsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public T visitPace(MusicParser.PaceContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.PACE, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.PACE,null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitSustain(MusicParser.SustainContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.SUSTAIN, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.SUSTAIN, null, melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }


    @Override
    public T visitInstrument(MusicParser.InstrumentContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) {
            // If not Instrument_Value then it is recognised as ID, if not then it should be a lexer error
            if (ctx.INSTRUMENT_VALUE() == null)
                throw new ValueError(ctx.ID() + " is not valid INSTRUMENT", this.lineMap.get(getLine(ctx)), getCol(ctx));
            String instrumentName = ctx.INSTRUMENT_VALUE().getText();
            Instrument instrument = valueOf(instrumentName);
            if (currentScope != null) {
                if (!currentScope.setInstrument(instrument))
                    throw new ValueError(instrument + "is not valid INSTRUMENT", this.lineMap.get(getLine(ctx)), getCol(ctx));
            } else if (!melody.setInstrument(instrument))
                throw new ValueError(instrument + "is not valid INSTRUMENT", this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        return visitChildren(ctx);
    }


    @Override
    public T visitDistortion(MusicParser.DistortionContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.DISTORTION, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.DISTORTION, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitJazz(MusicParser.JazzContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.JAZZ, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.JAZZ, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitBlues(MusicParser.BluesContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.BLUES, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.BLUES, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitVolume(MusicParser.VolumeContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.VOLUME, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.VOLUME, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitVibrato(MusicParser.VibratoContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.VIBRATO, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.VIBRATO, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitBalance(MusicParser.BalanceContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
           editEffect(ctx, Effect.BALANCE, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.BALANCE, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitSostenutoPedal(MusicParser.SostenutoPedalContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.SOSTENUTO, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.SOSTENUTO, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitSoftPedal(MusicParser.SoftPedalContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.SOFT, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.SOFT, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitResonance(MusicParser.ResonanceContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.RESONANCE, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.RESONANCE, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitReverb(MusicParser.ReverbContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.REVERB, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.REVERB, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitTremolo(MusicParser.TremoloContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.TREMOLO, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.TREMOLO, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitChorus(MusicParser.ChorusContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
           editEffect(ctx, Effect.CHORUS, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.CHORUS, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    public T visitPhraser(MusicParser.PhraserContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            editEffect(ctx, Effect.PHRASER, ctx.parent(),currentScope.effects,currentScope.instrument,currentScope.channels);
        } else if (melody != null) editEffect(ctx, Effect.PHRASER, null,melody.effects,melody.instrument,melody.channels);
        return visitChildren(ctx);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitSettingsValues(MusicParser.SettingsValuesContext ctx) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty");
        if (ctx.BLUES() != null) return (T) (getSettings(Effect.BLUES));
        if (ctx.JAZZ() != null) return (T) (getSettings(Effect.JAZZ));
        if (ctx.SUSTAIN() != null) return (T) (getSettings(Effect.SUSTAIN));
        if (ctx.DISTORTION() != null) return (T) (getSettings(Effect.DISTORTION));
        if (ctx.PACE() != null) return (T) (getSettings(Effect.PACE));
        if (ctx.VOLUME() != null) return (T) (getSettings(Effect.VOLUME));
        if (ctx.VIBRATO() != null) return (T) (getSettings(Effect.VIBRATO));
        if (ctx.BALANCE() != null) return (T) (getSettings(Effect.BALANCE));
        if (ctx.SOSTENUTO() != null) return (T) getSettings(Effect.SOSTENUTO);
        if (ctx.SOFT() != null) return (T) (getSettings(Effect.SOFT));
        if (ctx.RESONANCE() != null) return (T) (getSettings(Effect.RESONANCE));
        if (ctx.REVERB() != null) return (T) (getSettings(Effect.REVERB));
        if (ctx.TREMOLO() != null) return (T) (getSettings(Effect.TREMOLO));
        if (ctx.CHORUS() != null) return (T) (getSettings(Effect.CHORUS));
        if (ctx.PHRASER() != null) return (T) (getSettings(Effect.PHRASER));
        if (ctx.INSTRUMENT() != null) return (T) (melody.instrument);
        else throw new SyntaxError("Syntax error", this.lineMap.get(getLine(ctx)), getCol(ctx));

    }

    @Override
    public T visitAssignment(MusicParser.AssignmentContext ctx) {
        VarInfo varInfo = extractVariable(ctx, ctx.ID(), null, ctx.parent());
        Value exprValue = tryCasting(ctx.expr());
        if (exprValue.getType() != varInfo.type) {
            throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + " Type " + varInfo.type + " not: " + exprValue.getType(), this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        varInfo.valueObj = copyValue(exprValue);

        //To check if everything is ok, will be deleted in a future
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        //System.out.println(melody.memory.get(varInfo.name).toString());
        //TODO println throws null pointer exception cuz it tries to get it from melody memory
        return visitChildren(ctx);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitSelfAssignment(MusicParser.SelfAssignmentContext ctx) {
        VarInfo varInfo = extractVariable(ctx, ctx.ID(), null, ctx.parent());
        Value exprValue = tryCasting(ctx.expr());
        if (varInfo.type == Type.INT && exprValue.getType() == Type.INT) {
            IntValue intValue = (IntValue) exprValue;
            IntValue intVar = (IntValue) varInfo.valueObj;
            if (ctx.assOp().SUMIS() != null) intVar.value += intValue.value;
            else if (ctx.assOp().SUBIS() != null) intVar.value -= intValue.value;
            else if (ctx.assOp().MULIS() != null) intVar.value *= intValue.value;
            else if (ctx.assOp().DIVIS() != null && intValue.value != 0) intVar.value /= intValue.value;
            else throw new ArithmeticOperationError("Division by zero", this.lineMap.get(getLine(ctx)), getCol(ctx));
            //System.out.println(varInfo);
            return (T) new IntValue(intVar.value);
        } else if (varInfo.type == Type.NOTE && exprValue.getType() == Type.INT) {
            IntValue intValue = (IntValue) exprValue;
            NoteValue noteValue = (NoteValue) varInfo.valueObj;
            int newNoteValue;
            int oldNoteValue = NoteMap.notes.get(noteValue.note);
            if (ctx.assOp().SUMIS() != null) newNoteValue = oldNoteValue + intValue.value;
            else if (ctx.assOp().SUBIS() != null) newNoteValue = oldNoteValue - intValue.value;
            else if (ctx.assOp().MULIS() != null && intValue.value >= 1)
                newNoteValue = oldNoteValue + (intValue.value - 1) * 12;
            else if (ctx.assOp().DIVIS() != null && intValue.value >= 1)
                newNoteValue = oldNoteValue - (intValue.value - 1) * 12;
            else
                throw new ArithmeticOperationError("Invalid operation with notes", this.lineMap.get(getLine(ctx)), getCol(ctx));
            newNoteValue = Math.abs(newNoteValue) % 85;
            noteValue.note = Music.findNote(newNoteValue);
            return (T) new NoteValue(noteValue.note);
        } else if (varInfo.type == Type.CHORD && exprValue.getType() == Type.NOTE) {
            NoteValue noteValue = (NoteValue) exprValue;
            ChordValue chordValue = (ChordValue) varInfo.valueObj;
            if (ctx.assOp().SUMIS() != null) {
                if (!chordValue.notes.contains(noteValue)) chordValue.notes.add(noteValue);
            } else if (ctx.assOp().SUBIS() != null) {
                if (chordValue.notes.size() <= 2)
                    throw new ArithmeticOperationError("Invalid operation with chords", this.lineMap.get(getLine(ctx)), getCol(ctx));
                chordValue.notes.remove(noteValue);
            } else
                throw new ArithmeticOperationError("Invalid operation with chords", this.lineMap.get(getLine(ctx)), getCol(ctx));
            //System.out.println(varInfo);
            return (T) new ChordValue(chordValue.notes);
        } else if (varInfo.type == Type.CHORD && exprValue.getType() == Type.CHORD) {
            ChordValue chordValue = (ChordValue) exprValue;
            ChordValue chordModified = (ChordValue) varInfo.valueObj;
            if (ctx.assOp().SUMIS() != null) {
                Set<NoteValue> setNotes = new HashSet<>();
                setNotes.addAll(chordModified.notes);
                setNotes.addAll(chordValue.notes);
                chordModified.notes = new ArrayList<>(setNotes);
            } else {
                List<NoteValue> listNotes = new ArrayList<>();
                for (NoteValue note : chordModified.notes)
                    if (!chordValue.notes.contains(note)) listNotes.add(note);
                if (listNotes.size() <= 1)
                    throw new ArithmeticOperationError("Invalid operation with chords: less than 2 notes left in a chord", this.lineMap.get(getLine(ctx)), getCol(ctx));
                chordModified.notes = listNotes;
            }
            //System.out.println(varInfo);
            return (T) new ChordValue(chordModified.notes);
        } else throw new ArithmeticOperationError("Invalid operation", this.lineMap.get(getLine(ctx)), getCol(ctx));
    }


    @Override
    public T visitVarDeclWithARg(MusicParser.VarDeclWithARgContext ctx) {
        Melody melody = stack.peek();
        String varName = ctx.ID().getText();
        VarInfo varInfo;

        varInfo = declareVar(varName, ctx);

        Value val = tryCasting(ctx.expr());


        if (val.getType() != varInfo.type) {
            throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + " Type " + varInfo.type + " not: " + val.getType(), this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        varInfo.valueObj = copyValue(val);
        if (currentScope != null) {
            //System.out.println(currentScope.memory.get(varInfo.name).toString());
        } else {
            if(melody != null){
                //System.out.println(melody.memory.get(varInfo.name).toString());
            }
        }


        return null;
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
            IntValue varInt = (IntValue) extractVariable(ctx, ctx.ID(), Type.INT, ctx.parent()).valueObj;
            duration = varInt.value;
        }
        Note note = Note.valueOf(ctx.NOTE_VAL().getText().replace('#', 's').replace('-', 'm'));
        Music.playNote(note, duration,stack.peek(),currentScope);
        return visitChildren(ctx);
    }


    @Override
    public T visitPlayChord(MusicParser.PlayChordContext ctx) {
        ChordValue chord = (ChordValue) visit(ctx.chord());
        int duration = 0;
        if (ctx.INT_VAL() != null) duration = Integer.parseInt(ctx.INT_VAL().getText());
        else if (ctx.ID() != null) {
            IntValue varInt = (IntValue) extractVariable(ctx, ctx.ID(), Type.INT, ctx.parent()).valueObj;
            duration = varInt.value;
        }
        Music.playChord(chord.notes, duration,stack.peek(),currentScope);
        return visitChildren(ctx);

    }

    @Override
    public T visitPlayFunc(MusicParser.PlayFuncContext ctx) {
        String name = null;
        VarInfo var = null;
        if (ctx.ID() != null) {
            name = ctx.ID().getText();
            var = extractVariable(ctx, ctx.ID(), null, ctx.parent());
        }

        try {
            visit(ctx.functionCall());
        } catch (ReturnValue returnValue) {
            if (returnValue.getValue() == null) return null;
            else if (name == null) return null;
            else if (var.type != returnValue.getValue().getType())
                throw new ValueError("Function returned: " + returnValue.getValue().getType() + " which was assigned to: " + var.type, this.lineMap.get(getLine(ctx)), getCol(ctx));
            else var.valueObj = returnValue.getValue();
        }
        return null;
    }


    @Override
    public T visitPlayIDVariants(MusicParser.PlayIDVariantsContext ctx) { //TODO trzeba zmienić tu używanie parentów bo może być wiele ID
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        //playing note or chord
        if (ctx.INT_VAL() != null || ctx.parentID(1) != null) {
            VarInfo varInfo;
            String varName = ctx.parentID(0).ID().getText();

            varInfo = findVar(varName, ctx, ctx.parentID(0).parent());


            if (varInfo == null)
                throw new ScopeError("Variable not defined: " + varName, this.lineMap.get(getLine(ctx)), getCol(ctx));
            int duration = 0;
            if (ctx.INT_VAL() != null) duration = Integer.parseInt(ctx.INT_VAL().getText());
            else if (ctx.parentID(1) != null) {
                IntValue varInt = (IntValue) extractVariable(ctx, ctx.parentID(1).ID(), Type.INT, ctx.parentID(1).parent()).valueObj;
                duration = varInt.value;
            }
            if (varInfo.type == Type.NOTE) {
                NoteValue noteVal = (NoteValue) varInfo.valueObj;
                Music.playNote(noteVal.note, duration,melody,currentScope);
            } else {
                ChordValue chordVal = (ChordValue) varInfo.valueObj;
                Music.playChord(chordVal.notes, duration,melody,currentScope);
            }
        }
        //playing track
        else {
            if (!melody.name.equals("main"))
                throw new SyntaxError("Track cannot be played outside of a main melody", this.lineMap.get(getLine(ctx)), getCol(ctx));
            String trackName = ctx.parentID(0).ID().getText();
            if (!tracks.containsKey(trackName)) {
                throw new UndefinedError("Undefined track variable: " + " " + trackName, this.lineMap.get(getLine(ctx)), getCol(ctx));
            }
            Track track = tracks.get(trackName);
            try {
                track.play();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
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
    public T visitMultiPlayValues(MusicParser.MultiPlayValuesContext ctx) { //TODO trzeba zmienić tu używanie parentów bo może być wiele ID
        int duration = 0;
        int lastId = ctx.parentID().size() - 1;
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        if (ctx.INT_VAL() != null) {
            duration = Integer.parseInt(ctx.INT_VAL().getText());
        } else if (ctx.parentID(lastId) != null) {
            VarInfo var;
            String varName = ctx.parentID(lastId).ID().getText();

            var = findVar(varName, ctx, ctx.parentID(lastId).parent());

            if (var == null)
                throw new ScopeError("Variable not defined: ", this.lineMap.get(getLine(ctx)), getCol(ctx));
            if (var.type != Type.INT)
                throw new ValueError("Incorrect type of variable: " + varName + "Type " + var.type + "not int", this.lineMap.get(getLine(ctx)), getCol(ctx));
            duration = ((IntValue) var.valueObj).value;
        }

        for (int i = 0; i < ctx.getChildCount() - 1; i++) {
            ParseTree child = ctx.getChild(i);
            if (visit(child) instanceof ChordValue) {
                ChordValue chord = (ChordValue) visit(child);
                Music.playChord(chord.notes, duration,melody,currentScope);
            } else if (visit(child) instanceof NoteValue) {
                NoteValue note = (NoteValue) visit(child);
                Music.playNote(note.note, duration,melody,currentScope);
            } else {
                MusicParser.ParentIDContext idContext = (MusicParser.ParentIDContext) child;
                VarInfo varInfo;
                String varName = idContext.ID().getText();

                varInfo = findVar(varName, ctx, idContext.parent());

                if (varInfo.type == Type.NOTE) {
                    NoteValue noteVal = (NoteValue) varInfo.valueObj;
                    Music.playNote(noteVal.note, duration,melody,currentScope);
                } else if (varInfo.type == Type.CHORD) {
                    ChordValue chordVal = (ChordValue) varInfo.valueObj;
                    Music.playChord(chordVal.notes, duration,melody,currentScope);
                } else {
                    throw new ValueError("Expecting Note or Chord value, got: " + varInfo, this.lineMap.get(getLine(ctx)), getCol(ctx));
                }
            }
        }
        return visitChildren(ctx);
    }


    @Override
    public T visitPauseStatement(MusicParser.PauseStatementContext ctx) {
        try {
            int sleep = 0;
            if (ctx.INT_VAL() != null) sleep = Integer.parseInt(ctx.INT_VAL().getText());
            else if (ctx.ID() != null) {
                Melody melody = stack.peek();
                if (melody == null) throw new RuntimeException("Stack is empty!");
                VarInfo var;
                String varName = ctx.ID().getText();

                var = findVar(varName, ctx, ctx.parent());

                if (var == null)
                    throw new ScopeError("Variable not defined: " + varName, this.lineMap.get(getLine(ctx)), getCol(ctx));
                if (var.type != Type.INT)
                    throw new ValueError("Incorrect type of variable: " + varName + "Type " + var.type + "not int", this.lineMap.get(getLine(ctx)), getCol(ctx));
                IntValue varInt = (IntValue) var.valueObj;
                sleep = varInt.value;
            }
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return visitChildren(ctx);
    }

    @Override
    public T visitLoopStatement(MusicParser.LoopStatementContext ctx) {
        return visitChildren(ctx);
    }


    @Override
    public T visitWhileLoop(MusicParser.WhileLoopContext ctx) {
        Scope callbackScope = currentScope;
        Scope temp;

        if (currentScope == null) {
            temp = Scope.deepCopyScopeStructure(stack.peek().scopes.get(0), stack.peek(), null);
        } else {
            temp = Scope.deepCopyScopeStructure(currentScope.getChild(), null, currentScope);
        }

        if (((BoolValue) visit(ctx.expr())).value) {
            try {
                visit(ctx.scope());
            } catch (BreakError b) {
                currentScope = callbackScope;
                skipScope();
                return null;
            } catch (ContinueError ignored) {
                currentScope = callbackScope;
                resetCurrScope(temp);
            }
            visit(ctx);
        } else {
            skipScope();
        }
        return null;
    }


    /**
     * This function creates variable status to check which statement is to be executed
     * It iterates over every IF/ELSE/ELSEIF ctx and visits it to check if its expression is true or false
     * The first found expr that return True is executed and the remaining statements are deleted from currentScope's list of Child Scopes
     * (because changeScope brings us back to the parent Scope not the Scope of the IF/ELSE/ELSEIF we are entering)
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitIfStatement(MusicParser.IfStatementContext ctx) {
        Boolean status = false;
        for (ParseTree child : ctx.children) {
            if (child instanceof MusicParser.IfContext || child instanceof MusicParser.ElseifContext) {
                if (!status) {
                    status = (Boolean) visit(child);
                } else {
                    skipScope();
                }
            } else if (child instanceof MusicParser.ElseContext && !status) {
                visit(child);
            }
        }
        return null;
    }

    @Override
    public T visitScope(MusicParser.ScopeContext ctx) {
        Scope temp = null;
        currentScope = getCurrScope(stack.peek());
        if (ctx.parent instanceof MusicParser.WhileLoopContext || ctx.parent instanceof MusicParser.ForLoopContext) {
            temp = Scope.deepCopyScopeStructure(currentScope, currentScope.melodyParent, currentScope.parent);
        }
        visitChildren(ctx);
        if (temp != null) {
            currentScope = currentScope.parent;
            resetCurrScope(temp);
        } else {
            changeScope();
        }
        return null;
    }

    @Override
    public T visitParent(MusicParser.ParentContext ctx) {
        return null;
    }

    @Override
    public T visitParentID(MusicParser.ParentIDContext ctx) {
        return null;
    }


    /**
     * This function checks whether the Expression is True or False - if it's False then we skip it and return False
     * else we execute it (we are not worried about checking if we should execute this IF when expression is True
     * because after executing the first IF with expr == True we delete remaining IF/ELSE/ELSEIF that weren't checked)
     * getCurrentScope enters this IF Scope and changeScope leaves this IF's Scope after we visited everything that is in it
     *
     * @param ctx the parse tree
     * @return
     */
    @Override
    public T visitIf(MusicParser.IfContext ctx) {
        Value exprVal = tryCasting(ctx.expr());
        if (exprVal instanceof BoolValue) {
            if (((BoolValue) exprVal).value) {
                visit(ctx.scope());
                return (T) new Boolean(true);
            } else {
                skipScope();
                return (T) new Boolean(false);
            }
        } else
            throw new ValueError("Expression is not of type BOOLEAN, got type: " + exprVal.getClass().getName(), this.lineMap.get(getLine(ctx)), getCol(ctx));
    }

    @Override
    public T visitElseif(MusicParser.ElseifContext ctx) {
        Value exprVal = tryCasting(ctx.expr());
        if (exprVal instanceof BoolValue) {
            if (((BoolValue) exprVal).value) {
                visit(ctx.scope());
                //System.out.println("Exiting elseif, elseif memory: " + currentScope.memory.values().stream().map(e -> e.toString()).collect(Collectors.joining(" ")));
                return (T) new Boolean(true);
            } else {
                skipScope();
                return (T) new Boolean(false);
            }
        } else
            throw new ValueError("Expression is not of type BOOLEAN, got type: " + exprVal.getClass().getName(), this.lineMap.get(getLine(ctx)), getCol(ctx));
    }

    @Override
    public T visitElse(MusicParser.ElseContext ctx) {
        //System.out.println("Exiting else, else memory: " + currentScope.memory.values().stream().map(e -> e.toString()).collect(Collectors.joining(" ")));
        visit(ctx.scope());
        return null;
    }

    @Override
    public T visitForInit(MusicParser.ForInitContext ctx) {
        if (ctx.varDecl() != null) {
            currentScope = getCurrScope(stack.peek());
            visit(ctx.varDecl());
            currentScope = currentScope.parent;

            /**
             * if ForInit is Declaration then the variable goes to the scope representing For and
             * information about declared variable in () goes to the parent Scope
             */

            if (ctx.varDecl() instanceof MusicParser.VarDeclWithARgContext) {
                if (currentScope != null) {
                    currentScope.forInit = ((MusicParser.VarDeclWithARgContext) ctx.varDecl()).ID().getText();
                } else {
                    if (stack.peek() == null) {
                        throw new RuntimeException("Stack is empty!");
                    }
                    stack.peek().forInit = ((MusicParser.VarDeclWithARgContext) ctx.varDecl()).ID().getText();
                }
            } else {
                if (currentScope != null) {
                    currentScope.forInit = ((MusicParser.VarDeclWithoutArgContext) ctx.varDecl()).ID().getText();
                } else {
                    if (stack.peek() == null) {
                        throw new RuntimeException("Stack is empty!");
                    }
                    stack.peek().forInit = ((MusicParser.VarDeclWithoutArgContext) ctx.varDecl()).ID().getText();
                }
            }

        } else {
            visit(ctx.assignment());
        }
        return null;
    }


    @Override
    public T visitForLoop(MusicParser.ForLoopContext ctx) {
        if (ctx.forInit() != null) {
            visit(ctx.forInit());
        }

        /**
         * For expr is outside for Scope to prevent something like this
         *  main melody(){
         *  for(int k = 2; i * k < 4; k +=1 ){
         *      int i = 8;
         *      ...
         *      }
         *  }
         *  This would produce wrong Exception type if we were inside for loop at that time
         *
         */

        if (ctx.expr() == null || checkForExpr(ctx)) {
            while (ctx.expr() == null || checkForExpr(ctx)) {
                Scope temp;
                if (currentScope == null) {
                    temp = Scope.deepCopyScopeStructure(stack.peek().scopes.get(0), stack.peek(), null);
                } else {
                    temp = Scope.deepCopyScopeStructure(currentScope.getChild(), null, currentScope);
                }
                Scope callbackScope = currentScope;
                try {
                    visit(ctx.scope());
                } catch (BreakError b) {
                    currentScope = callbackScope;
                    skipScope();
                    if (currentScope != null) {
                        currentScope.forInit = null;
                    } else {
                        if (stack.peek() == null) {
                            throw new RuntimeException("Stack is empty!");
                        }
                        stack.peek().forInit = null;
                    }
                    return null;
                } catch (ContinueError ignored) {
                    currentScope = callbackScope;
                    resetCurrScope(temp);
                }
                if (ctx.forUpdate() != null) {
                    visit(ctx.forUpdate());
                }
            }
            skipScope();
        } else {
            skipScope();
        }
        if (currentScope != null) {
            currentScope.forInit = null;
        } else {
            if (stack.peek() == null) {
                throw new RuntimeException("Stack is empty!");
            }
            stack.peek().forInit = null;
        }
        return null;
    }

    @Override
    public T visitLoopBody(MusicParser.LoopBodyContext ctx) {
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
        throw new BreakError("Break statement cannot be used here!", this.lineMap.get(getLine(ctx)), getCol(ctx));
    }


    @Override
    public T visitContinueStatement(MusicParser.ContinueStatementContext ctx) {
        throw new ContinueError("Continue statement cannot be used here!", this.lineMap.get(getLine(ctx)), getCol(ctx));
    }

    @Override
    public T visitFunctionCall(MusicParser.FunctionCallContext ctx) {

        String name = ctx.ID().getText();
        if (name.equals("main"))
            throw new RuntimeError("You cannot call a main melody", this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (!melodyMemory.containsKey(name))
            throw new RuntimeError("Melody " + name + " not declared", this.lineMap.get(getLine(ctx)), getCol(ctx));

        Melody melodyPattern = melodyMemory.get(name);
        Melody melody = Melody.deepCopyMelody(melodyPattern);
        if(currentScope!=null){
            melody.copyEffects(currentScope.effects);
            melody.setInstrument(currentScope.instrument);
        }
        else {
            melody.copyEffects(stack.peek().effects);
            melody.setInstrument(stack.peek().instrument);
        }
        if (ctx.arguments() == null && !melody.parameters.isEmpty())
            throw new RuntimeError("Invalid number of arguments: 0" + " instead of: " + melody.parameters.size(), this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (ctx.arguments() != null) {
            if (melody.parameters.size() != ctx.arguments().expr().size())
                throw new RuntimeError("Invalid number of arguments: " + ctx.arguments().expr().size() + " instead of: " + melody.parameters.size(), this.lineMap.get(getLine(ctx)), getCol(ctx));
            int size = melody.parameters.size();
            for (int i = 0; i < size; i++) {
                VarInfo par = melody.parameters.get(i);
                Value arg = tryCasting(ctx.arguments().expr(i));
                if (par.type != arg.getType())
                    throw new RuntimeError("Invalid type of argument with index: " + (i + 1) + " : " + arg.getType() + " instead of: " + par.type, this.lineMap.get(getLine(ctx)), getCol(ctx));
                par.valueObj = copyValue(arg);
            }
        }
        for (Map.Entry<Integer, VarInfo> param : melody.parameters.entrySet()) {
            if (melody.memory.containsKey(param.getValue().name))
                throw new RuntimeError("Redeclaration in line: " + melody.memory.get(param.getValue().name).line + " of a melody parameter inside melody's body: " + param.getValue().name, this.lineMap.get(getLine(ctx.arguments())), getCol(ctx.arguments()));
            melody.memory.put(param.getValue().name, param.getValue());

        }

//        for (Scope scope : melody.scopes) {
//            Scope.addMemoryFromParams(melody, scope);
//        }

        melody.previous_scope = currentScope;
        currentScope = null;
        stack.push(melody);
        if (stack.size() > 100) throw new StackOverflow(name);

        if (ctx.settingsList() != null) {
            for (MusicParser.SettingsAssigmentContext set : ctx.settingsList().settingsAssigment())
                visit(set);
        }
        for (MusicParser.StatementContext statement : melody.body) {
            visit(statement);
        }
        stack.pop();
        currentScope = melody.previous_scope;
        return null;
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
        return (T) Music.parseNote(ctx.NOTE_VAL().getText());
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitOrOperatorExpr(MusicParser.OrOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));

        if (firstValue instanceof BoolValue && secondValue instanceof BoolValue) {
            BoolValue boolExpr1 = (BoolValue) firstValue;
            BoolValue boolExpr2 = (BoolValue) secondValue;
            return (T) (new BoolValue(boolExpr1.value || boolExpr2.value));
        } else if (firstValue instanceof BoolValue)
            throw new ValueError("Incorrect type of expression: " + secondValue.getType() + " not BOOL", this.lineMap.get(getLine(ctx)), getCol(ctx));
        else
            throw new ValueError("Incorrect type of expression: " + firstValue.getType() + " not BOOL", this.lineMap.get(getLine(ctx)), getCol(ctx));
    }


    @Override
    @SuppressWarnings("unchecked")
    public T visitNotExpr(MusicParser.NotExprContext ctx) {
        Value expr = tryCasting(ctx.expr());
        if (expr instanceof BoolValue) {
            BoolValue boolExpr = (BoolValue) expr;
            return (T) new BoolValue(!boolExpr.value);
        } else
            throw new ValueError("Incorrect type of expression: " + expr.getType() + " not BOOL", this.lineMap.get(getLine(ctx)), getCol(ctx));
    }


    @Override
    @SuppressWarnings("unchecked")
    public T visitOrderOperatorExpr(MusicParser.OrderOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));

        BiPredicate<Integer, Integer> predicate = (x, y) -> false;
        if (ctx.orderOp().GT() != null) predicate = (x, y) -> x > y;
        if (ctx.orderOp().LT() != null) predicate = (x, y) -> x < y;
        if (ctx.orderOp().GEQ() != null) predicate = (x, y) -> x >= y;
        if (ctx.orderOp().LEQ() != null) predicate = (x, y) -> x <= y;

        if (firstValue instanceof IntValue && secondValue instanceof IntValue) {
            return (T) new BoolValue(predicate.test(((IntValue) firstValue).value, ((IntValue) secondValue).value));
        } else if (firstValue instanceof NoteValue && secondValue instanceof NoteValue) {
            return (T) new BoolValue(predicate.test(NoteMap.notes.get(((NoteValue) firstValue).note), NoteMap.notes.get(((NoteValue) secondValue).note)));
        } else
            throw new ArithmeticOperationError("Incorrect type of comparison!", this.lineMap.get(getLine(ctx)), getCol(ctx));
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitInstrumentOperatorExpr(MusicParser.InstrumentOperatorExprContext ctx) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        return (T) new BoolValue(melody.instrument.toString().equals(ctx.INSTRUMENT_VALUE().getText()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitAddSubOperatorExpr(MusicParser.AddSubOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));

        if (firstValue.getType() == Type.INT && secondValue.getType() == Type.INT) {
            int firstInt = ((IntValue) firstValue).value;
            int secondInt = ((IntValue) secondValue).value;
            int resultInt;
            if (ctx.addSubOp().SUB() != null)
                resultInt = firstInt - secondInt;
            else
                resultInt = firstInt + secondInt;
            Value result = new IntValue(resultInt);
            return (T) result;
        } else if (firstValue.getType() == Type.NOTE && secondValue.getType() == Type.INT) {
            Note note = ((NoteValue) firstValue).note;
            int intVal = ((IntValue) secondValue).value;
            int noteIntVal = NoteMap.notes.get(note);

            if (ctx.addSubOp().SUB() != null) noteIntVal -= intVal;
            else noteIntVal += intVal;
            noteIntVal = Math.abs(noteIntVal) % 85;
            Value result = new NoteValue(Music.findNote(noteIntVal));
            return (T) result;
        } else if (firstValue.getType() == Type.CHORD && secondValue.getType() == Type.NOTE) {
            NoteValue noteValue = (NoteValue) secondValue;
            ChordValue chordValue = (ChordValue) firstValue;
            ChordValue result;
            if (ctx.addSubOp().ADD() != null) {
                result = new ChordValue(chordValue.notes);
                if (!chordValue.notes.contains(noteValue)) result.notes.add(noteValue);
            } else {
                if (chordValue.notes.size() <= 2 && chordValue.notes.contains(noteValue))
                    throw new ArithmeticOperationError("Invalid operation with chords", this.lineMap.get(getLine(ctx)), getCol(ctx));
                result = new ChordValue(chordValue.notes);
                result.notes.remove(noteValue);
            }
            return (T) result;
        } else if (firstValue.getType() == Type.CHORD && secondValue.getType() == Type.CHORD) {
            ChordValue chordValue2 = (ChordValue) secondValue;
            ChordValue chordValue1 = (ChordValue) firstValue;
            ChordValue result;
            if (ctx.addSubOp().ADD() != null) {
                Set<NoteValue> setNotes = new HashSet<>();
                setNotes.addAll(chordValue1.notes);
                setNotes.addAll(chordValue2.notes);
                result = new ChordValue(new ArrayList<>(setNotes));
            } else {
                List<NoteValue> listNotes = new ArrayList<>();
                for (NoteValue note : chordValue1.notes)
                    if (!chordValue2.notes.contains(note)) listNotes.add(note);
                if (listNotes.size() <= 1)
                    throw new ArithmeticOperationError("Invalid operation with chords: less than 2 notes left in a chord", this.lineMap.get(getLine(ctx)), getCol(ctx));
                result = new ChordValue(listNotes);
            }
            return (T) result;

        } else
            throw new ArithmeticOperationError("Invalid arguments for add/subtract operation", this.lineMap.get(getLine(ctx)), getCol(ctx));

    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitAndOperatorExpr(MusicParser.AndOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));
        if (firstValue instanceof BoolValue && secondValue instanceof BoolValue) {
            BoolValue boolExpr1 = (BoolValue) firstValue;
            BoolValue boolExpr2 = (BoolValue) secondValue;
            return (T) (new BoolValue(boolExpr1.value && boolExpr2.value));
        } else if (firstValue instanceof BoolValue)
            throw new ValueError("Incorrect type of expression: " + secondValue.getType() + " not BOOL", this.lineMap.get(getLine(ctx)), getCol(ctx));
        else
            throw new ValueError("Incorrect type of expression: " + firstValue.getType() + " not BOOL", this.lineMap.get(getLine(ctx)), getCol(ctx));
    }


    @Override
    @SuppressWarnings("unchecked")
    public T visitMullDivOperatorExpr(MusicParser.MullDivOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));

        if (firstValue.getType() == Type.INT && secondValue.getType() == Type.INT) {
            int firstInt = ((IntValue) firstValue).value;
            int secondInt = ((IntValue) secondValue).value;
            int resultInt;

            if (ctx.mullDivOp().MUL() != null) resultInt = firstInt * secondInt;
            else if (ctx.mullDivOp().PER() != null) resultInt = firstInt % secondInt;
            else if (secondInt != 0) resultInt = firstInt / secondInt;
            else throw new ArithmeticOperationError("Division by zero!", this.lineMap.get(getLine(ctx)), getCol(ctx));
            Value result = new IntValue(resultInt);
            return (T) result;
        }
        if (firstValue.getType() == Type.NOTE && secondValue.getType() == Type.INT) {
            Note note = ((NoteValue) firstValue).note;
            int intVal = ((IntValue) secondValue).value;
            int noteIntVal = NoteMap.notes.get(note);

            if (noteIntVal < 1)
                throw new ArithmeticOperationError("Invalid operation", this.lineMap.get(getLine(ctx)), getCol(ctx));
            if (ctx.mullDivOp().MUL() != null)
                noteIntVal += (intVal - 1) * 12;
            else if (ctx.mullDivOp().DIV() != null) noteIntVal -= (intVal - 1) * 12;
            else
                throw new ArithmeticOperationError("Invalid operation. % cannot be used with notes", this.lineMap.get(getLine(ctx)), getCol(ctx));
            noteIntVal = Math.abs(noteIntVal) % 85;
            Value result = new NoteValue(Music.findNote(noteIntVal));
            return (T) result;
        } else
            throw new ArithmeticOperationError("Invalid arguments for mull/div operation", this.lineMap.get(getLine(ctx)), getCol(ctx));
    }


    @Override
    @SuppressWarnings("unchecked")
    public T visitBoolExpr(MusicParser.BoolExprContext ctx) {
        if (ctx.BOOL_VAL() != null) {
            BoolValue result = new BoolValue(ctx.BOOL_VAL().getText().equals("true"));
            return (T) result;
        }
        throw new SyntaxError("Bool value not found", this.lineMap.get(getLine(ctx)), getCol(ctx));
    }


    @Override
    public T visitParanthesesExpr(MusicParser.ParanthesesExprContext ctx) {
        return visit(ctx.expr());
    }


    @Override
    @SuppressWarnings("unchecked")
    public T visitIdExpr(MusicParser.IdExprContext ctx) {

        VarInfo varInfo;
        String varName = ctx.ID().getText();

        varInfo = findVar(varName, ctx, ctx.parent());

        if (varInfo == null)
            throw new UndefinedError("No such variable defined: " + varName, this.lineMap.get(getLine(ctx)), getCol(ctx));
        return (T) varInfo.valueObj;
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

        if (firstValue.getType() != secondValue.getType()) {
            throw new IncomparableError("Types are not the same: " + firstValue + " != " + secondValue, this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        BoolValue result = firstValue.equals(secondValue);
        if (ctx.eqOp().EQ() != null) return (T) result;
        else {
            if (result.value) return (T) new BoolValue(false);
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
            NoteValue newNote = new NoteValue(note);
            if (!notes.contains(newNote)) notes.add(newNote);
        }
        if (notes.size() < 2)
            throw new ValueError("Invalid operation with chords: same note repeated", this.lineMap.get(getLine(ctx)), getCol(ctx));
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
        String name = ctx.trackStatement().ID().getText();
        if (!tracks.containsKey(name)) {
            throw new UndefinedError("Undefined track variable: " + " " + name, this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        Track track = tracks.get(name);
        String funcName = ctx.trackStatement().functionCall().ID().getText();
        if (!melodyMemory.containsKey(funcName))
            throw new RuntimeError("Melody " + funcName + " not declared", this.lineMap.get(getLine(ctx)), getCol(ctx));
        Melody melody = melodyMemory.get(funcName);
        List<Value> argsOut = new ArrayList<>();
        MusicParser.ArgumentsContext args = ctx.trackStatement().functionCall().arguments();
        if (args == null && !melody.parameters.isEmpty())
            throw new RuntimeError("Invalid number of arguments: 0 instead of: " + melody.parameters.size(), this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (args != null) {
            if (melody.parameters.size() != args.expr().size())
                throw new RuntimeError("Invalid number of arguments: " + args.expr().size() + " instead of: " + melody.parameters.size(), this.lineMap.get(getLine(ctx)), getCol(ctx));
            int size = melody.parameters.size();
            for (int i = 0; i < size; i++) {
                VarInfo par = melody.parameters.get(i);
                Value arg = tryCasting(args.expr(i));
                if (par.type != arg.getType())
                    throw new RuntimeError("Invalid type of argument with index: " + (i + 1) + " : " + arg.getType() + " instead of: " + par.type, this.lineMap.get(getLine(ctx)), getCol(ctx));
                argsOut.add(arg);
            }
        }
        MusicParser.SettingsListContext settings = ctx.trackStatement().functionCall().settingsList();
        //fake melody just to get settings without any effort
        Melody main = stack.peek();
        Melody fakeMelody = Melody.deepCopyMelody(main);
        fakeMelody.copyEffects(main.effects);
        stack.push(fakeMelody);
        if (settings != null) {
            for (MusicParser.SettingsAssigmentContext set : settings.settingsAssigment())
                visit(set);
        }
        stack.pop();
        String newCode = TrackHandler.generateNewCode(this.code, funcName, argsOut, fakeMelody.effects, fakeMelody.instrument);
        AbstractMap.SimpleEntry<MusicSuperVisitor, MusicParser.ProgramContext> msv_prog = TrackHandler.prepareVisitor(newCode, this.lineMap);
        TrackComponent newComponent = new TrackComponent(msv_prog.getKey(), msv_prog.getValue());
        track.add(newComponent);

        return null;
    }

    @Override
    public T visitTrackDeclare(MusicParser.TrackDeclareContext ctx) {

        String name = ctx.trackDeclaration().ID().getText();
        if (tracks.containsKey(name)) {
            throw new VariableDeclarationError("Redeclaration of a track variable: " + name + " previously defined in line " + tracks.get(name).line, this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        Track newTrack = new Track(name, getLine(ctx));
        tracks.put(name, newTrack);
        return null;
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
        if (ctx.SUB() != null) valueInt.value *= -1;
        return (T) valueInt;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitTerminal(TerminalNode node) {
        if (Music.parseNote(node.getText()) != null) {
            return (T) Music.parseNote(node.getText());
        }
        return (T) node;
    }


    private int getLine(ParserRuleContext ctx) {
        return ctx.getStart().getLine();
    }

    private int getCol(ParserRuleContext ctx) {
        return ctx.getStart().getCharPositionInLine();
    }

    public VarInfo extractVariable(ParserRuleContext ctx, TerminalNode id, Type type, List<MusicParser.ParentContext> parents) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        VarInfo var;
        String varName = id.getText();

        var = findVar(varName, ctx, parents);

        if (var == null)
            throw new UndefinedError("Variable not defined: " + id.getText(), this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (type == null) {
            return var;
        }
        if (var.type != type)
            throw new ValueError("Incorrect type of variable: " + id.getText() + "Type " + var.type + " not " + type, this.lineMap.get(getLine(ctx)), getCol(ctx));
        return var;
    }


    private Value tryCasting(MusicParser.ExprContext expr) {
        T value = visit(expr);
        if (value == null) {
            throw new UndefinedError("Undefined variable: " + " " + expr.getText(), this.lineMap.get(getLine(expr)), getCol(expr));
        }
        if (value instanceof Instrument) {
            throw new ValueError("Incorrect type of expression: INSTRUMENT not allowed here", this.lineMap.get(getLine(expr)), getCol(expr));
        }
        return (Value) value;
    }


    /**
     * Finds the new active Scope when visiting if or any other IfStatement
     * which translates to finding the first child Scope of the previous currentScope
     * or first child of the Melody if there is no active Scope at the moment -> currentScope is null
     *
     * @param melody
     * @return
     */

    private Scope getCurrScope(Melody melody) {
        Scope firstScope;
        if (melody == null) throw new RuntimeException("Stack is empty!");
        if (melody.scopes.isEmpty()) return null;
        if (currentScope != null) {
            firstScope = currentScope.scopes.get(0);
            //Copying settings from parent scope
            firstScope.copyEffects(currentScope.effects);
            firstScope.setInstrument(currentScope.instrument);
        } else {
            firstScope = melody.scopes.get(0);
            //Copying settings from parent melody
            firstScope.setInstrument(melody.instrument);
            firstScope.copyEffects(melody.effects);
        }
        return firstScope;
    }


    /**
     * Function that exits the current Scope meaning it has ended thus changing
     * the currentScope to it's parent:
     * <p>
     * if(true){ THIS IS PARENT
     * if(true){ THIS IS CHILD
     * <p>
     * } HERE WE EXIT THIS IF SO WE NEED TO CHANGE CURRENT SCOPE TO IT'S PARENT
     * }
     * <p>
     * After changing the scope we delete that exited Scope from the Parent's list of Scopes
     */
    private void changeScope() {
        if (currentScope != null) {
            currentScope = currentScope.parent;
            if (currentScope == null) {
                if (stack.peek() != null) {
                    stack.peek().scopes.remove(0);
                } else throw new RuntimeException("Stack is empty!");
            } else {
                currentScope.scopes.remove(0);
            }
        }
        return;
    }

    /**
     * The order is like this:
     * current scope is not null then we first look for the first scope after up: statement
     * then we check whether this scope has for scope with declared variable inside () of for
     * then we check this and higher scopes memory (we dont want to check other scopes forInit because if the scope has variable in forInit
     * then it child also has this variable)
     * lastly we check the main memory
     * if current scope is null then we only check main forInit and memory
     *
     * @param varName
     * @param ctx
     * @param parentContexts
     * @return
     */
    private VarInfo findVar(String varName, ParserRuleContext ctx, List<MusicParser.ParentContext> parentContexts) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            Scope current = currentScope;
            for (int i = 0; i < parentContexts.size(); i++) {
                current = current.parent;
                parentContexts.remove(0);
                if (current == null) break;
            }
            if (parentContexts.size() > 1){
                throw new ScopeError("There is no higher scope!", this.lineMap.get(getLine(ctx)), getCol(ctx));
            }

            /**
             * After finding proper scope we check whether his forInit lines up with varName - if so we need to go back
             * and pull out the variable from child memory (because child Scope representing for has varDecl of for inside)
             * Only works for for loops, or should
             */

            if (current != null) {
                if (varName.equals(current.forInit)) {
                    return current.scopes.get(0).memory.get(varName);
                }
            } else {
                if (melody != null && melody.forInit != null && melody.forInit.equals(varName)) {
                    return melody.scopes.get(0).memory.get(varName);
                }
            }

            while (current != null) {
                if (!current.memory.containsKey(varName) || current.memory.get(varName) == null) {
                    current = current.parent;
                } else {
                    return current.memory.get(varName);
                }
            }

            //if (stack.isEmpty()) throw new RuntimeException("Stack is empty!");

            if (melody != null && (melody.memory.containsKey(varName) || melody.memory.get(varName) != null))  {
                if(parentContexts.isEmpty()){
                    return melody.memory.get(varName);
                }
            } else if (globalScope.containsKey(varName) || globalScope.get(varName) != null) {
                return globalScope.get(varName);
            }
            throw new UndefinedError("Variable not defined: " + varName, this.lineMap.get(getLine(ctx)), getCol(ctx));

            /**
             * This section looks bad, don't worry
             * will be changed in my spare time
             */

        } else if (melody != null) {

            if (parentContexts == null || parentContexts.isEmpty()) {
                if (varName.equals(melody.forInit)) {
                    return melody.scopes.get(0).memory.get(varName);
                } else if (melody.memory.containsKey(varName) && melody.memory.get(varName) != null) {
                    return melody.memory.get(varName);
                } else if (globalScope.containsKey(varName) && globalScope.get(varName) != null) {
                    return globalScope.get(varName);
                }
                throw new UndefinedError("Variable not defined: " + varName, this.lineMap.get(getLine(ctx)), getCol(ctx));
            } else if (parentContexts.size() == 1) {
                if (globalScope.containsKey(varName) && globalScope.get(varName) != null) {
                    return globalScope.get(varName);
                }
                throw new UndefinedError("Variable not defined: " + varName, this.lineMap.get(getLine(ctx)), getCol(ctx));
            }else {
                throw new ScopeError("There is no higher scope!", this.lineMap.get(getLine(ctx)), getCol(ctx));
            }
        } else {
            if(parentContexts != null && !parentContexts.isEmpty()) {
                throw new ScopeError("There is no higher scope!", this.lineMap.get(getLine(ctx)), getCol(ctx));
            }
            if(globalScope.containsKey(varName)) {
                return globalScope.get(varName);
            }else throw new UndefinedError("Variable not defined: " + varName, this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
    }

    /**
     * Declares var saved in memory of scope or melody
     * if parent of declaration is For loop then we declare the value in
     * the child scope because this declaration happens BEFORE we jump into FOR scope
     *
     * @param varName
     * @param ctx
     * @return
     */
    private VarInfo declareVar(String varName, ParserRuleContext ctx) {
        Scope current = currentScope;

        while (current != null) {
            if (!current.memory.containsKey(varName)) {
                current = current.parent;
            } else return current.memory.get(varName);
        }

        if (!stack.isEmpty() && stack.peek().memory.containsKey(varName)) {
            return stack.peek().memory.get(varName);
        } else if (globalScope.containsKey(varName)) {
            return globalScope.get(varName);
        }
        throw new UndefinedError("Variable not defined: " + varName, this.lineMap.get(getLine(ctx)), getCol(ctx));

    }

    public Scope findLoopScope() {
        if (currentScope == null) throw new RuntimeException("Stack is empty!");
        Scope temp = currentScope;
        while (temp != null && temp.scopeType != ScopeType.FOR && temp.scopeType != ScopeType.WHILE) {
            temp = temp.parent;
        }
        if (temp != null) return temp;
        else throw new RuntimeException("Statement used not in loop!");
    }

    private void setScopeType(Scope scope, ScopeType type) {
        if (scope != null) {
            scope.scopeType = type;
        }
    }

    private void skipScope() {
        currentScope = getCurrScope(stack.peek());
        changeScope();
    }

    private boolean checkForExpr(MusicParser.ForLoopContext ctx) {

        if (((BoolValue) visit(ctx.expr())).value) {
            return true;
        } else {
            return false;
        }
    }

    private void resetCurrScope(Scope temp) {
        if (currentScope == null) {
            if (stack.peek() == null) {
                throw new RuntimeException("Stack is empty!");
            }
            stack.peek().scopes.set(0, temp);
        } else {
            currentScope.scopes.set(0, temp);
        }
    }

    /**
     * Allows us to get settings from a proper place, scope or melody
     */
    private Value getSettings(Effect effect){
        Melody melody = stack.peek();
        if (currentScope != null) {
            return currentScope.effects.get(effect);
        } else if (melody != null) return melody.effects.get(effect);
        return null;
    }

    private Value copyValue(Value value){
        Type type = value.getType();
        switch(type){
            case INT:
                IntValue valInt = (IntValue) value;
                return new IntValue(valInt.value);
            case BOOL:
                BoolValue valBool = (BoolValue) value;
                return new BoolValue(valBool.value);
            case NOTE:
                NoteValue valNote = (NoteValue) value;
                return new NoteValue(valNote.note);
            case CHORD:
                ChordValue val = (ChordValue) value;
                return new ChordValue(val.notes);
        }
        return null;
    }

    public void editEffect(MusicParser.SettingsAssigmentContext ctx, Effect effect, List<MusicParser.ParentContext> parents,
                           HashMap<Effect,Value> effects, Instrument instrument, MidiChannel[] channels) {
        ParseTree lastChild = ctx.children.get(ctx.children.size() - 1);
        if (effect == Effect.PACE || effect == Effect.VOLUME) {
            if (lastChild != null && isNumeric(String.valueOf(lastChild)))
                effects.put(effect, new IntValue(Integer.parseInt(String.valueOf(lastChild))));
            else if (lastChild != null) {
                IntValue varInt = (IntValue) this.extractVariable(ctx, (TerminalNode) lastChild, Type.INT, parents).valueObj;
                effects.put(effect, varInt);
            }

        } else if (effect == Effect.JAZZ || effect == Effect.BLUES) {
            if (lastChild != null && isBoolean(String.valueOf(lastChild)))
                effects.put(effect, new BoolValue(Boolean.parseBoolean(String.valueOf(lastChild))));
            else if (lastChild != null) {
                BoolValue varBool = (BoolValue) this.extractVariable(ctx, (TerminalNode) lastChild, Type.BOOL, parents).valueObj;
                effects.put(effect, varBool);
            }
        } else {
            if (lastChild != null && isNumeric(String.valueOf(lastChild))) {
                effects.put(effect, new IntValue(Integer.parseInt(String.valueOf(lastChild))));
                if (instrument == DRUMS)
                    channels[9].controlChange(Music.effectControllers.get(effect), ((IntValue) effects.get(effect)).value);
                else
                    channels[0].controlChange(Music.effectControllers.get(effect), ((IntValue) effects.get(effect)).value);
            } else if (lastChild != null) {
                IntValue varInt = (IntValue) this.extractVariable(ctx, (TerminalNode) lastChild, Type.INT, parents).valueObj;
                if (instrument == DRUMS)
                    channels[9].controlChange(Music.effectControllers.get(effect), varInt.value);
                else
                    channels[0].controlChange(Music.effectControllers.get(effect), varInt.value);
            }
        }
    }
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBoolean(String str) {
        try {
            Boolean.parseBoolean(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }




}