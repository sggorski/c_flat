package pl.edu.agh;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
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

    public MusicSuperVisitor(HashMap<String, Melody> melodyMemory, Map<Integer, LineOrigin> lines) {
        this.melodyMemory = melodyMemory;
        this.lineMap = lines;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T visitProgram(MusicParser.ProgramContext ctx) throws RuntimeException {
        if (!melodyMemory.containsKey("main"))
            throw new RuntimeException("No main function declaration found!"); //TODO
        stack.push(melodyMemory.get("main"));
        for (MusicParser.MainStatementContext statement : melodyMemory.get("main").mainBody) {
            visit(statement);
        }
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
                throw new RuntimeException("MAIN: " + boolValue); //TODO
            } else if (value instanceof IntValue) {
                IntValue intValue = (IntValue) value;
                throw new RuntimeException("MAIN: " + intValue); //TODO
            } else if (value instanceof NoteValue) {
                NoteValue noteValue = (NoteValue) value;
                throw new RuntimeException("MAIN: " + noteValue);
            } else if (value instanceof ChordValue) {
                ChordValue chordValue = (ChordValue) value;
                throw new RuntimeException("MAIN: " + chordValue);
            }
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
        if (melody != null) melody.editEffect(ctx, Effect.PACE, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitSustain(MusicParser.SustainContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.SUSTAIN, this);
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
            if (!melody.setInstrument(instrument))
                throw new ValueError(instrument + "is not valid INSTRUMENT", this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        return visitChildren(ctx);
    }


    @Override
    public T visitDistortion(MusicParser.DistortionContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.DISTORTION, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitJazz(MusicParser.JazzContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.JAZZ, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitBlues(MusicParser.BluesContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.BLUES, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitVolume(MusicParser.VolumeContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.VOLUME, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitVibrato(MusicParser.VibratoContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.VIBRATO, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitBalance(MusicParser.BalanceContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.BALANCE, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitSostenutoPedal(MusicParser.SostenutoPedalContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.SOSTENUTO, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitSoftPedal(MusicParser.SoftPedalContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.SOFT, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitResonance(MusicParser.ResonanceContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.RESONANCE, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitReverb(MusicParser.ReverbContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.REVERB, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitTremolo(MusicParser.TremoloContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.TREMOLO, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitChorus(MusicParser.ChorusContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.CHORUS, this);
        return visitChildren(ctx);
    }

    @Override
    public T visitPhraser(MusicParser.PhraserContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) melody.editEffect(ctx, Effect.PHRASER, this);
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
        VarInfo varInfo = extractVariable(ctx, ctx.ID(), null);
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
        VarInfo varInfo = extractVariable(ctx, ctx.ID(), null);
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
        //System.out.println(melody.memory.get(varInfo.name).toString());
        //TODO println throws null pointer exception cuz it tries to get it from melody memory

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
            IntValue varInt = (IntValue) extractVariable(ctx, ctx.ID(), Type.INT).valueObj;
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
            IntValue varInt = (IntValue) extractVariable(ctx, ctx.ID(), Type.INT).valueObj;
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
            var = extractVariable(ctx, ctx.ID(), null);
        }

        try {
            visit(ctx.functionCall());
        } catch (ReturnValue returnValue) {
            if (returnValue.getValue() == null) return null;
            else if (name == null) throw new RuntimeException("Function returned value, but it wasn't assigned!");
            else if (var.type != returnValue.getValue().getType())
                throw new RuntimeException("Function returned: " + returnValue.getValue().getType() + "which was assigned to: " + var.type); //TODO
            else var.valueObj = returnValue.getValue();
        }
        return null;
    }


    @Override
    public T visitPlayIDVariants(MusicParser.PlayIDVariantsContext ctx) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        //playing note or chord
        if (ctx.INT_VAL() != null || ctx.ID(1) != null) {
            VarInfo varInfo;
            String varName = ctx.ID(0).getText();
            if (currentScope != null) {
                varInfo = findVar(varName, ctx);
            } else {
                varInfo = melody.memory.get(varName);
            }

            if (varInfo == null)
                throw new ScopeError("Variable not defined: " + varName, this.lineMap.get(getLine(ctx)), getCol(ctx));
            int duration = 0;
            if (ctx.INT_VAL() != null) duration = Integer.parseInt(ctx.INT_VAL().getText());
            else if (ctx.ID(1) != null) {
                IntValue varInt = (IntValue) extractVariable(ctx, ctx.ID(1), Type.INT).valueObj;
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
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        if (ctx.INT_VAL() != null) {
            duration = Integer.parseInt(ctx.INT_VAL().getText());
        } else if (ctx.ID(lastId) != null) {
            VarInfo var;
            String varName = ctx.ID(lastId).getText();
            if (currentScope != null) {
                var = findVar(varName, ctx);
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
                VarInfo varInfo;
                String varName = ctx.ID(lastId).getText();
                if (currentScope != null) {
                    varInfo = findVar(varName, ctx);
                } else {
                    varInfo = melody.memory.get(varName);
                }
                if (varInfo.type == Type.NOTE) {
                    NoteValue noteVal = (NoteValue) varInfo.valueObj;
                    playNote(noteVal.note, duration);
                } else {
                    ChordValue chordVal = (ChordValue) varInfo.valueObj;
                    playChord(chordVal.notes, duration);
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
                    var = findVar(varName, ctx);
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
        if(((BoolValue) visit(ctx.expr())).value) {
            currentScope = getCurrScope(stack.peek());
            Scope tempScope = Scope.deepCopyScopeStructure(currentScope, currentScope.melodyParent, currentScope.parent);
            if(((BoolValue) visit(ctx.loopBody())).value) {
                if(currentScope.parent != null) {
                    currentScope.parent.scopes.set(0,tempScope);
                }else {
                    currentScope.melodyParent.scopes.set(0,tempScope);
                }
                currentScope = tempScope;
                currentScope = currentScope.parent;
                visit(ctx);
                return null;
            }else {
                return null;
            }
        }
        else {
            currentScope = getCurrScope(stack.peek());
            changeScope();
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
                    currentScope = getCurrScope(stack.peek());
                    changeScope();
                }
            } else if (child instanceof MusicParser.ElseContext && !status) {
                visit(child);
            }
        }
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
        currentScope = getCurrScope(stack.peek());
        Value exprVal = tryCasting(ctx.expr());
        if (exprVal instanceof BoolValue) {
            if (((BoolValue) exprVal).value) {
                visitChildren(ctx);
                System.out.println("Exiting if, if memory: " + currentScope.memory.values().stream().map(e -> e.toString()).collect(Collectors.joining(" ")));
                changeScope();
                return (T) new Boolean(true);
            } else {
                changeScope();
                return (T) new Boolean(false);
            }
        } else
            throw new ValueError("Expression is not of type BOOLEAN, got type: " + exprVal.getClass().getName(), this.lineMap.get(getLine(ctx)), getCol(ctx));
    }

    @Override
    public T visitElseif(MusicParser.ElseifContext ctx) {
        Value exprVal = tryCasting(ctx.expr());
        currentScope = getCurrScope(stack.peek());
        if (exprVal instanceof BoolValue) {
            if (((BoolValue) exprVal).value) {
                visitChildren(ctx);
                changeScope();
                return (T) new Boolean(true);
            } else {
                changeScope();
                return (T) new Boolean(false);
            }
        } else
            throw new ValueError("Expression is not of type BOOLEAN, got type: " + exprVal.getClass().getName(), this.lineMap.get(getLine(ctx)), getCol(ctx));
    }

    @Override
    public T visitElse(MusicParser.ElseContext ctx) {
        currentScope = getCurrScope(stack.peek());
        System.out.println("Exiting else, else memory: " + currentScope.memory.values().stream().map(e -> e.toString()).collect(Collectors.joining(" ")));
        visitChildren(ctx);
        changeScope();
        return null;
    }


    @Override
    public T visitForLoop(MusicParser.ForLoopContext ctx) { //TODO Scopes needs to be redefined in grammar as standalone rule
        Scope tempScope = new Scope(ScopeType.FOR);

        if(ctx.varDecl() != null){
            visit(ctx.varDecl());
        }

        if(ctx.expr() == null || ((BoolValue) visit(ctx.expr())).value){
            currentScope = getCurrScope(stack.peek());
            Scope.copyMemory(tempScope, currentScope.memory);
            if (((Boolean) visit(ctx.loopBody()))){
                Scope.copyMemory(currentScope, tempScope.memory);
                currentScope = currentScope.parent;
                if (ctx.forUpdate() != null){
                    visit(ctx.forUpdate());
                }
                visit(ctx);
            }
        }
        else {
            currentScope = getCurrScope(stack.peek());
            changeScope();
        }
        return null;
    }

    @Override
    public T visitLoopBody(MusicParser.LoopBodyContext ctx) {
        for(ParseTree child : ctx.children){
            try {
                visit(child);
            }catch (Break b){
                return (T) new BoolValue(false);
            }catch (Continue c){
                break;
            }
        }
        return (T) new BoolValue(true);
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
        throw new Break("break");
    }


    @Override
    public T visitContinueStatement(MusicParser.ContinueStatementContext ctx) {
        throw new Continue("continue");
    }

    @Override
    public T visitFunctionCall(MusicParser.FunctionCallContext ctx) {

        String name = ctx.ID().getText();
        if (name.equals("main")) throw new RuntimeException("You cannot call main function!");
        if (!melodyMemory.containsKey(name)) throw new RuntimeException("Function not declared!"); //TODO

        Melody melodyPattern = melodyMemory.get(name);
        Melody melody = Melody.deepCopyMelody(melodyPattern);

        if (stack.peek() != null) {
            melody.copyEffects(stack.peek().effects);
            melody.setInstrument(stack.peek().instrument);
        }
        if (ctx.arguments() == null && !melody.parameters.isEmpty())
            throw new RuntimeException("Invalid number of arguments!"); //TODO
        if (ctx.arguments() != null) {
            if (melody.parameters.size() != ctx.arguments().expr().size())
                throw new RuntimeException("Invalid number of arguments!"); //TODO
            int size = melody.parameters.size();
            for (int i = 0; i < size; i++) {
                VarInfo par = melody.parameters.get(i);
                Value arg = tryCasting(ctx.arguments().expr(i));
                if (par.type != arg.getType())
                    throw new RuntimeException("Invalid type for argument with idx: " + i); //TODO
                par.valueObj = arg;
            }
        }
        for (Map.Entry<Integer, VarInfo> param : melody.parameters.entrySet()) {
            if (melody.memory.containsKey(param.getValue().name))
                throw new RuntimeException("Redeclaration of an argument parameter inside function!"); //TODO
            melody.memory.put(param.getValue().name, param.getValue());

        }

//        for (Scope scope : melody.scopes) {
//            Scope.addMemoryFromParams(melody, scope);
//        }

        melody.previous_scope = currentScope;
        currentScope = null;
        stack.push(melody);
        if (stack.size() > 1000) throw new StackOverflowError("StackOverFlow!"); //TODO
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
            boolExpr.value = !boolExpr.value;
            return (T) boolExpr;
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
            varInfo = findVar(varName, ctx);
        } else {
            varInfo = melody.memory.get(varName);
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
            if (melody.instrument == DRUMS) {
                melody.playChord(melody.channels[9], notesInt, duration, ((IntValue) melody.effects.get(Effect.VOLUME)).value);
            } else {
                melody.playChord(melody.channels[0], notesInt, duration, ((IntValue) melody.effects.get(Effect.VOLUME)).value);
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
            if (melody.instrument == DRUMS) {
                melody.playNote(melody.channels[9], noteInt, duration, ((IntValue) melody.effects.get(Effect.VOLUME)).value);
            } else {
                melody.playNote(melody.channels[0], noteInt, duration, ((IntValue) melody.effects.get(Effect.VOLUME)).value);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public VarInfo extractVariable(ParserRuleContext ctx, TerminalNode id, Type type) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        VarInfo var;
        String varName = id.getText();
        if (currentScope != null) {
            var = findVar(varName, ctx);
        } else {
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
        if (newNote == null) throw new RuntimeException(); //TODO
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
        } else {
            firstScope = melody.scopes.get(0);
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


    private VarInfo findVar(String varName, ParserRuleContext ctx) {
        Scope current = currentScope;
        while (current != null) {
            if (!current.memory.containsKey(varName) || current.memory.get(varName).valueObj == null){
                current = current.parent;
            }
            else return current.memory.get(varName);
        }

        if(stack.isEmpty()) throw new RuntimeException("Stack is empty!");

        if(stack.peek().memory.containsKey(varName)) {
            return stack.peek().memory.get(varName);
        }else throw new UndefinedError("Variable not defined: " + varName, this.lineMap.get(getLine(ctx)), getCol(ctx));

    }

    private VarInfo declareVar(String varName, ParserRuleContext ctx) {
        Scope current = currentScope;
        while (current != null) {
            if (!current.memory.containsKey(varName)){
                current = current.parent;
            }
            else return current.memory.get(varName);
        }

        if(stack.isEmpty()) throw new RuntimeException("Stack is empty!");

        if(stack.peek().memory.containsKey(varName)) {
            return stack.peek().memory.get(varName);
        }else throw new UndefinedError("Variable not defined: " + varName, this.lineMap.get(getLine(ctx)), getCol(ctx));

    }

    public Scope findLoopScope(){
        if (currentScope == null) throw new RuntimeException("Stack is empty!");
        Scope temp = currentScope;
        while (temp != null && temp.scopeType != ScopeType.FOR && temp.scopeType != ScopeType.WHILE) {
            temp = temp.parent;
        }
        if(temp != null) return temp;
        else throw new RuntimeException("Statement used not in loop!");
    }

}