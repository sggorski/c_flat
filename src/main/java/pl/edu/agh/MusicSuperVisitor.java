package pl.edu.agh;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import pl.edu.agh.errors.*;
import pl.edu.agh.utils.*;
import pl.edu.agh.utils.Instrument;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import static pl.edu.agh.utils.Instrument.*;


@SuppressWarnings("CheckReturnValue")
public class MusicSuperVisitor<T> extends MusicBaseVisitor<T> implements MusicVisitor<T> {
    HashMap<String, Melody> melodyMemory;
    Deque<Melody> stack = new ArrayDeque<>();
    Scope currentScope = null;
    private final Map<Integer, LineOrigin> lineMap;
    HashMap<String, Track> tracks = new HashMap<>();
    String code;


    public MusicSuperVisitor(HashMap<String, Melody> melodyMemory, Map<Integer, LineOrigin> lines, String code) {
        this.melodyMemory = melodyMemory;
        this.lineMap = lines;
        this.code = code;
        //to finish program when error occurrs in thread
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.err.println(throwable.getMessage());
            System.exit(1);
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitProgram(MusicParser.ProgramContext ctx) throws RuntimeException {
        if (!melodyMemory.containsKey("main"))
            throw new SyntaxError("No main melody declaration found!", this.lineMap.get(getLine(ctx)), getCol(ctx));
        stack.push(melodyMemory.get("main"));
        for (MusicParser.MainStatementContext statement : melodyMemory.get("main").mainBody) {
            visit(statement);
        }
        System.out.println(melodyMemory.values().stream().map(e -> e.toString()).collect(Collectors.joining(" ")));
        return (T) (new BoolValue(true)); //everything went ok
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
            currentScope.editEffect(ctx, Effect.PACE, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.PACE, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitSustain(MusicParser.SustainContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.SUSTAIN, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.SUSTAIN, this);
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
            currentScope.editEffect(ctx, Effect.DISTORTION, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.DISTORTION, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitJazz(MusicParser.JazzContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.JAZZ, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.JAZZ, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitBlues(MusicParser.BluesContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.BLUES, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.BLUES, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitVolume(MusicParser.VolumeContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.VOLUME, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.VOLUME, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitVibrato(MusicParser.VibratoContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.VIBRATO, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.VIBRATO, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitBalance(MusicParser.BalanceContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.BALANCE, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.BALANCE, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitSostenutoPedal(MusicParser.SostenutoPedalContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.SOSTENUTO, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.SOSTENUTO, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitSoftPedal(MusicParser.SoftPedalContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.SOFT, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.SOFT, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitResonance(MusicParser.ResonanceContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.RESONANCE, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.RESONANCE, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitReverb(MusicParser.ReverbContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.REVERB, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.REVERB, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitTremolo(MusicParser.TremoloContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.TREMOLO, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.TREMOLO, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitChorus(MusicParser.ChorusContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.CHORUS, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.CHORUS, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitPhraser(MusicParser.PhraserContext ctx) {
        Melody melody = stack.peek();
        if (currentScope != null) {
            currentScope.editEffect(ctx, Effect.PHRASER, this, ctx.parent());
        } else if (melody != null) melody.editEffect(ctx, Effect.PHRASER, this);
        return visitChildren(ctx);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitSettingsValues(MusicParser.SettingsValuesContext ctx) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty");
        if (ctx.BLUES() != null) return (T) (melody.effects.get(Effect.BLUES));
        if (ctx.JAZZ() != null) return (T) (melody.effects.get(Effect.JAZZ));
        if (ctx.SUSTAIN() != null) return (T) (melody.effects.get(Effect.SUSTAIN));
        if (ctx.DISTORTION() != null) return (T) (melody.effects.get(Effect.DISTORTION));
        if (ctx.PACE() != null) return (T) (melody.effects.get(Effect.PACE));
        if (ctx.VOLUME() != null) return (T) (melody.effects.get(Effect.VOLUME));
        if (ctx.VIBRATO() != null) return (T) (melody.effects.get(Effect.VIBRATO));
        if (ctx.BALANCE() != null) return (T) (melody.effects.get(Effect.BALANCE));
        if (ctx.SOSTENUTO() != null) return (T) (melody.effects.get(Effect.SOSTENUTO));
        if (ctx.SOFT() != null) return (T) (melody.effects.get(Effect.SOFT));
        if (ctx.RESONANCE() != null) return (T) (melody.effects.get(Effect.RESONANCE));
        if (ctx.REVERB() != null) return (T) (melody.effects.get(Effect.REVERB));
        if (ctx.TREMOLO() != null) return (T) (melody.effects.get(Effect.TREMOLO));
        if (ctx.CHORUS() != null) return (T) (melody.effects.get(Effect.CHORUS));
        if (ctx.PHRASER() != null) return (T) (melody.effects.get(Effect.PHRASER));
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
        varInfo.valueObj = exprValue;

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
            System.out.println(varInfo);
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
            noteValue.note = findNote(newNoteValue);
            System.out.println(varInfo);
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
            System.out.println(varInfo);
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
            System.out.println(varInfo);
            return (T) new ChordValue(chordModified.notes);
        } else throw new ArithmeticOperationError("Invalid operation", this.lineMap.get(getLine(ctx)), getCol(ctx));
    }


    @Override
    public T visitVarDeclWithARg(MusicParser.VarDeclWithARgContext ctx) {
        Melody melody = stack.peek();
        String varName = ctx.ID().getText();
        VarInfo varInfo;
        if (melody == null) throw new RuntimeException("Stack is empty!");

        if (currentScope != null) {
            varInfo = declareVar(varName, ctx);
        } else {
            varInfo = melody.memory.get(varName);
        }

        Value val = tryCasting(ctx.expr());


        if (val.getType() != varInfo.type) {
            throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + " Type " + varInfo.type + " not: " + val.getType(), this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        varInfo.valueObj = val;
        if (currentScope != null) {
            System.out.println(currentScope.memory.get(varInfo.name).toString());
        } else {
            System.out.println(melody.memory.get(varInfo.name).toString());
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
        playNote(note, duration);
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
        playChord(chord.notes, duration);
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
            if (currentScope != null) {
                varInfo = findVar(varName, ctx, ctx.parentID(0).parent());
            } else {
                varInfo = melody.memory.get(varName);
            }

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
                playNote(noteVal.note, duration);
            } else {
                ChordValue chordVal = (ChordValue) varInfo.valueObj;
                playChord(chordVal.notes, duration);
            }
        }
        //playing track
        else{
            if(!melody.name.equals("main"))
                throw new SyntaxError("Track cannot be played outside of a main melody", this.lineMap.get(getLine(ctx)), getCol(ctx));
            String trackName = ctx.parentID(0).ID().getText();
            if(!tracks.containsKey(trackName)){
                throw new UndefinedError("Undefined track variable: " + " " + trackName, this.lineMap.get(getLine(ctx)), getCol(ctx));
            }
            Track track = tracks.get(trackName);
            try{
                track.play();
            }
            catch(InterruptedException e){
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
            if (currentScope != null) {
                var = findVar(varName, ctx, ctx.parentID(lastId).parent());
            } else {
                var = melody.memory.get(varName);
            }
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
                playChord(chord.notes, duration);
            } else if (visit(child) instanceof NoteValue) {
                NoteValue note = (NoteValue) visit(child);
                playNote(note.note, duration);
            } else {
                MusicParser.ParentIDContext idContext = (MusicParser.ParentIDContext) child;
                VarInfo varInfo;
                String varName = idContext.ID().getText();
                if (currentScope != null) {
                    varInfo = findVar(varName, ctx, idContext.parent());
                } else {
                    varInfo = melody.memory.get(varName);
                }
                if (varInfo.type == Type.NOTE) {
                    NoteValue noteVal = (NoteValue) varInfo.valueObj;
                    playNote(noteVal.note, duration);
                } else if(varInfo.type == Type.CHORD) {
                    ChordValue chordVal = (ChordValue) varInfo.valueObj;
                    playChord(chordVal.notes, duration);
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
                if (currentScope != null) {
                    var = findVar(varName, ctx, ctx.parent());
                } else {
                    var = melody.memory.get(varName);
                }
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
        if (((BoolValue) visit(ctx.expr())).value) {
            try {
                visit(ctx.scope());
            }catch (BreakError b){
                currentScope = callbackScope;
                skipScope();
                return null;
            }catch (ContinueError ignored){
                currentScope = callbackScope;
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
        if(ctx.parent instanceof MusicParser.WhileLoopContext || ctx.parent instanceof MusicParser.ForLoopContext) {
            temp = Scope.deepCopyScopeStructure(currentScope, currentScope.melodyParent, currentScope.parent);
        }
        visitChildren(ctx);
        if (temp != null){
            currentScope = currentScope.parent;
            if (currentScope != null){
                currentScope.scopes.set(0, temp);
            }else {
                if(stack.peek() == null){
                    throw new RuntimeException("Stack is empty!");
                }
                stack.peek().scopes.set(0, temp);
            }
        }else {
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
    public T visitForLoop(MusicParser.ForLoopContext ctx) {
        if (ctx.varDecl() != null) {
            visit(ctx.varDecl());
        }
        if (ctx.expr() == null || ((BoolValue) visit(ctx.expr())).value) {
            while (ctx.expr() == null || ((BoolValue) visit(ctx.expr())).value){
                Scope callbackScope = currentScope;
                try {
                    visit(ctx.scope());
                }catch (BreakError b){
                    currentScope = callbackScope;
                    skipScope();
                    return null;
                }catch (ContinueError ignored){
                    currentScope = callbackScope;
                }
                if(ctx.forUpdate() != null) {
                    visit(ctx.forUpdate());
                }

            }
        } else {
            skipScope();
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
        if (name.equals("main")) throw new RuntimeError("You cannot call a main melody", this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (!melodyMemory.containsKey(name)) throw new RuntimeError("Melody " + name + " not declared" , this.lineMap.get(getLine(ctx)), getCol(ctx));

        Melody melodyPattern = melodyMemory.get(name);
        Melody melody = Melody.deepCopyMelody(melodyPattern);

        if (stack.peek() != null) {
            melody.copyEffects(stack.peek().effects);
            melody.setInstrument(stack.peek().instrument);
        }
        if (ctx.arguments() == null && !melody.parameters.isEmpty())
            throw new RuntimeError("Invalid number of arguments: 0"  + " instead of: " + melody.parameters.size(), this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (ctx.arguments() != null) {
            if (melody.parameters.size() != ctx.arguments().expr().size())
                throw new RuntimeError("Invalid number of arguments: " +ctx.arguments().expr().size() + " instead of: " + melody.parameters.size(), this.lineMap.get(getLine(ctx)), getCol(ctx));
            int size = melody.parameters.size();
            for (int i = 0; i < size; i++) {
                VarInfo par = melody.parameters.get(i);
                Value arg = tryCasting(ctx.arguments().expr(i));
                if (par.type != arg.getType())
                    throw new RuntimeError("Invalid type of argument with index: " + (i+1) + " : " +  arg.getType() + " instead of: " + par.type, this.lineMap.get(getLine(ctx)), getCol(ctx));
                par.valueObj = arg;
            }
        }
        for (Map.Entry<Integer, VarInfo> param : melody.parameters.entrySet()) {
            if (melody.memory.containsKey(param.getValue().name))
                throw new RuntimeError("Redeclaration in line: " +melody.memory.get(param.getValue().name).line +  " of a melody parameter inside melody's body: " + param.getValue().name , this.lineMap.get(getLine(ctx.arguments())), getCol(ctx.arguments()));
            melody.memory.put(param.getValue().name, param.getValue());

        }

//        for (Scope scope : melody.scopes) {
//            Scope.addMemoryFromParams(melody, scope);
//        }

        melody.previous_scope = currentScope;
        currentScope = null;
        stack.push(melody);
        if (stack.size() > 100)  throw new StackOverflow(name);

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
        return (T) parseNote(ctx.NOTE_VAL().getText());
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
            Value result = new NoteValue(findNote(noteIntVal));
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
            Value result = new NoteValue(findNote(noteIntVal));
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
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        VarInfo varInfo;
        String varName = ctx.ID().getText();
        if (currentScope != null) {
            varInfo = findVar(varName, ctx, ctx.parent());
        } else if((ctx.parent().isEmpty())) {
            varInfo = melody.memory.get(varName);
        }else {
            throw new ScopeError("There is no higher scope!", this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
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
    public T visitSelfAssignmentExpr(MusicParser.SelfAssignmentExprContext ctx) {
        return visit(ctx.selfAssignment());
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
        if(!tracks.containsKey(name)){
            throw new UndefinedError("Undefined track variable: " + " " + name, this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        Track track = tracks.get(name);
        String funcName = ctx.trackStatement().functionCall().ID().getText();
        if(!melodyMemory.containsKey(funcName)) throw new RuntimeError("Melody " + funcName + " not declared" , this.lineMap.get(getLine(ctx)), getCol(ctx));
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
                    throw new RuntimeError("Invalid type of argument with index: " + (i+1) + " : " +  arg.getType() + " instead of: " + par.type, this.lineMap.get(getLine(ctx)), getCol(ctx));
                argsOut.add(arg);
            }
        }
        MusicParser.SettingsListContext settings = ctx.trackStatement().functionCall().settingsList();
        //fake melody just to get settings without any effort
        Melody fakeMelody = new Melody();
        fakeMelody.memory = stack.peek().memory;
        fakeMelody.effects = stack.peek().effects;
        stack.push(fakeMelody);
        if (settings!= null) {
            for (MusicParser.SettingsAssigmentContext set : settings.settingsAssigment())
                visit(set);
        }
        stack.pop();
        String newCode = TrackHandler.generateNewCode(this.code,funcName,argsOut,fakeMelody.effects,fakeMelody.instrument);
        AbstractMap.SimpleEntry<MusicSuperVisitor, MusicParser.ProgramContext> msv_prog = TrackHandler.prepareVisitor(newCode,this.lineMap);
        TrackComponent newComponent = new TrackComponent(msv_prog.getKey(),msv_prog.getValue());
        track.add(newComponent);

        return null;
    }

    @Override
    public T visitTrackDeclare(MusicParser.TrackDeclareContext ctx) {

        String name = ctx.trackDeclaration().ID().getText();
        if(tracks.containsKey(name)){
            throw new VariableDeclarationError("Redeclaration of a track variable: " + name + " previously defined in line " + tracks.get(name).line, this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        Track newTrack = new Track(name,getLine(ctx));
        tracks.put(name,newTrack);
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
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        List<Integer> notesInt = new ArrayList<>();
        for (NoteValue note : notes) {
            notesInt.add(NoteMap.notes.get(note.note));
        }

        try {
            if (currentScope != null) {
                if (currentScope.instrument == DRUMS) {
                    currentScope.playChord(currentScope.channels[9], notesInt, duration, ((IntValue) currentScope.effects.get(Effect.VOLUME)).value);
                } else {
                    currentScope.playChord(currentScope.channels[0], notesInt, duration, ((IntValue) currentScope.effects.get(Effect.VOLUME)).value);
                }
            } else {
                if (melody.instrument == DRUMS) {
                    melody.playChord(melody.channels[9], notesInt, duration, ((IntValue) melody.effects.get(Effect.VOLUME)).value);
                } else {
                    melody.playChord(melody.channels[0], notesInt, duration, ((IntValue) melody.effects.get(Effect.VOLUME)).value);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void playNote(Note note, Integer duration) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        Integer noteInt = NoteMap.notes.get(note);
        try {
            if (currentScope != null) {
                if (currentScope.instrument == DRUMS) {
                    currentScope.playNote(currentScope.channels[9], noteInt, duration, ((IntValue) currentScope.effects.get(Effect.VOLUME)).value);
                } else {
                    currentScope.playNote(currentScope.channels[0], noteInt, duration, ((IntValue) currentScope.effects.get(Effect.VOLUME)).value);
                }
            } else {
                if (melody.instrument == DRUMS) {
                    melody.playNote(melody.channels[9], noteInt, duration, ((IntValue) melody.effects.get(Effect.VOLUME)).value);
                } else {
                    melody.playNote(melody.channels[0], noteInt, duration, ((IntValue) melody.effects.get(Effect.VOLUME)).value);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public VarInfo extractVariable(ParserRuleContext ctx, TerminalNode id, Type type, List<MusicParser.ParentContext> parents) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        VarInfo var;
        String varName = id.getText();
        if (currentScope != null) {
            var = findVar(varName, ctx, parents);
        } else {
            if (parents != null && !parents.isEmpty()) {
                throw new ScopeError("Higher scope does not exist!", this.lineMap.get(getLine(ctx)), getCol(ctx));
            }
            var = melody.memory.get(varName);
        }
        if (var == null)
            throw new UndefinedError("Variable not defined: " + id.getText(), this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (type == null) {
            return var;
        }
        if (var.type != type)
            throw new ValueError("Incorrect type of variable: " + id.getText() + "Type " + var.type + " not " + type, this.lineMap.get(getLine(ctx)), getCol(ctx));
        return var;
    }

    private Note findNote(int value) {
        Note newNote = NoteMap.notes.entrySet().stream()
                .filter(pair -> pair.getValue().equals(value))
                .findFirst()
                .map(Map.Entry::getKey).orElse(null);
        if (newNote == null) throw new RuntimeException("Note not found");
        return newNote;
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


    private VarInfo findVar(String varName, ParserRuleContext ctx, List<MusicParser.ParentContext> parentContexts) {
        Scope current = currentScope;

        for (int i = 0; i < parentContexts.size(); i++) {
            System.out.println("up");
            current = currentScope.parent;
        }

        while (current != null) {
            if (!current.memory.containsKey(varName) || current.memory.get(varName).valueObj == null) {
                current = current.parent;
            } else return current.memory.get(varName);
        }

        if (stack.isEmpty()) throw new RuntimeException("Stack is empty!");

        if (stack.peek().memory.containsKey(varName)) {
            return stack.peek().memory.get(varName);
        } else
            throw new UndefinedError("Variable not defined: " + varName, this.lineMap.get(getLine(ctx)), getCol(ctx));

    }

    /**
     *
     * Declares var saved in memory of scope or melody
     * if parent of declaration is For loop then we declare the value in
     * the child scope because this declaration happens BEFORE we jump into FOR scope
     *
     *
     * @param varName
     * @param ctx
     * @return
     */
    private VarInfo declareVar(String varName, ParserRuleContext ctx) {
        Scope current = currentScope;
        if(ctx instanceof MusicParser.ForLoopContext){
            if(current == null){
                current = stack.peek().scopes.get(0);
            }else {
                current = current.scopes.get(0);
            }
        }
        while (current != null) {
            if (!current.memory.containsKey(varName)) {
                current = current.parent;
            } else return current.memory.get(varName);
        }

        if (stack.isEmpty()) throw new RuntimeException("Stack is empty!");

        if (stack.peek().memory.containsKey(varName)) {
            return stack.peek().memory.get(varName);
        } else
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

    private void skipScope(){
        currentScope = getCurrScope(stack.peek());
        changeScope();
    }



}