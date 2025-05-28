package pl.edu.agh;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;
import pl.edu.agh.errors.*;
import pl.edu.agh.utils.*;
import pl.edu.agh.musicUtils.Instrument;
import pl.edu.agh.musicUtils.*;
import pl.edu.agh.visitorActions.*;
import pl.edu.agh.visitorActions.VisitorUtils;

import javax.sound.midi.MidiChannel;
import java.util.*;
import java.util.function.BiPredicate;

import static pl.edu.agh.musicUtils.Instrument.*;


@SuppressWarnings("unchecked")
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

        //to finish program when error occurs in thread
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.err.println(throwable.getMessage());
            System.exit(1);
        });
    }

    /**
     * Visits the root of the program parse tree.
     * Executes global variable declarations if present,
     * verifies the presence of a "main" melody, and executes its main body.
     */
    @Override
    @SuppressWarnings("unchecked")
    public T visitProgram(MusicParser.ProgramContext ctx) throws RuntimeException {
        if(ctx.globalVars() != null) visit(ctx.globalVars());
        if (!melodyMemory.containsKey("main"))
            throw new SyntaxError("No main melody declaration found!", this.lineMap.get(getLine(ctx)), getCol(ctx));
        stack.push(melodyMemory.get("main"));
        for (MusicParser.MainStatementContext statement : melodyMemory.get("main").mainBody) visit(statement);
        return (T) (new BoolValue(true));
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

    /**
     * Visits a general statement in the parse tree.
     * If it is a return statement, visits it directly;
     * otherwise, delegates to visiting all child nodes.
     */
    @Override
    public T visitStatement(MusicParser.StatementContext ctx) {
        if(ctx.returnStatement()!=null) return visit(ctx.returnStatement());
        return visitChildren(ctx);
    }

    /**
     * Visits a print statement node in the parse tree.
     * Evaluates the expression, retrieves the current line number,
     * and prints the result to the console.
     */
    @Override
    public T visitPrint(MusicParser.PrintContext ctx) {
        Value value = tryCasting(ctx.expr());
        int line = getLine(ctx);
        System.out.println("LINE " + line + " :" + value);
        return null;
    }

    /**
     * Visits a return statement node in the parse tree.
     * Retrieves the current melody from the stack and evaluates the return expression if present.
     * If the current melody is "main", prints the returned value and exits the program.
     * Otherwise, returns a ReturnVal object wrapping the evaluated value.
     */
    @Override
    public T visitReturnStatement(MusicParser.ReturnStatementContext ctx) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        if (ctx.expr() == null) {
            return (T)new ReturnVal(null);
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
            return (T)new ReturnVal(value);
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
        editProperSettings(ctx,ctx.parent(),Effect.PACE);
        return visitChildren(ctx);
    }

    @Override
    public T visitSustain(MusicParser.SustainContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.SUSTAIN);
        return visitChildren(ctx);
    }

    /**
     * Visits an instrument declaration node.
     * Retrieves the current melody from the stack and validates the instrument value.
     * Sets the instrument in the current scope or melody, throwing an error if invalid.
     */
    @Override
    public T visitInstrument(MusicParser.InstrumentContext ctx) {
        Melody melody = stack.peek();
        if (melody != null) {
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
        editProperSettings(ctx,ctx.parent(),Effect.DISTORTION);
        return visitChildren(ctx);
    }

    @Override
    public T visitJazz(MusicParser.JazzContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.JAZZ);
        return visitChildren(ctx);
    }

    @Override
    public T visitBlues(MusicParser.BluesContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.BLUES);
        return visitChildren(ctx);
    }

    @Override
    public T visitVolume(MusicParser.VolumeContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.VOLUME);
        return visitChildren(ctx);
    }

    @Override
    public T visitVibrato(MusicParser.VibratoContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.VIBRATO);
        return visitChildren(ctx);
    }

    @Override
    public T visitBalance(MusicParser.BalanceContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.BALANCE);
        return visitChildren(ctx);
    }

    @Override
    public T visitSostenutoPedal(MusicParser.SostenutoPedalContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.SOSTENUTO);
        return visitChildren(ctx);
    }

    @Override
    public T visitSoftPedal(MusicParser.SoftPedalContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.SOFT);
        return visitChildren(ctx);
    }

    @Override
    public T visitResonance(MusicParser.ResonanceContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.RESONANCE);
        return visitChildren(ctx);
    }

    @Override
    public T visitReverb(MusicParser.ReverbContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.REVERB);
        return visitChildren(ctx);
    }

    @Override
    public T visitTremolo(MusicParser.TremoloContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.TREMOLO);
        return visitChildren(ctx);
    }

    @Override
    public T visitChorus(MusicParser.ChorusContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.CHORUS);
        return visitChildren(ctx);
    }

    @Override
    public T visitPhraser(MusicParser.PhraserContext ctx) {
        editProperSettings(ctx,ctx.parent(),Effect.PHRASER);
        return visitChildren(ctx);
    }

    /**
     * Visits a settings values node.
     * Retrieves the current melody from the stack and returns the instrument if specified.
     * Otherwise, tries to parse and return the corresponding effect setting.
     */
    @Override
    public T visitSettingsValues(MusicParser.SettingsValuesContext ctx) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty");
        if (ctx.INSTRUMENT() != null) return (T) (melody.instrument);
        Effect effect;
        try{
            effect = Effect.valueOf(ctx.getText());
            return (T) (VisitorUtils.getSettings(effect,melody,currentScope));
        }
        catch(Exception e){
            throw new SyntaxError("Syntax error", this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
    }

    /**
     * Visits an assignment statement node.
     * Extracts the variable info and evaluates the expression.
     * Checks for type compatibility and updates the variable's value.
     */
    @Override
    public T visitAssignment(MusicParser.AssignmentContext ctx) {
        VarInfo varInfo = VisitorUtils.extractVariable(ctx.ID(), null, ctx.parent(),stack.peek(),
                currentScope,globalScope,getOrigin(ctx),getCol(ctx));

        Value exprValue = tryCasting(ctx.expr());
        if (exprValue.getType() != varInfo.type) {
            throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + " Type " + varInfo.type + " not: " + exprValue.getType(),
                    this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        varInfo.valueObj = VisitorUtils.copyValue(exprValue);
        return visitChildren(ctx);
    }

    /**
     * Visits a self-assignment statement node, extracts the variable and expression value,
     * then performs the self-assignment operation (e.g., +=, -=) using the assign method.
     */
    @Override
    public T visitSelfAssignment(MusicParser.SelfAssignmentContext ctx) {
        VarInfo varInfo = VisitorUtils.extractVariable(ctx.ID(), null, ctx.parent(),stack.peek(),currentScope,globalScope,getOrigin(ctx),getCol(ctx));
        Value exprValue = tryCasting(ctx.expr());
        return (T) SelfAssignment.assign(ctx,varInfo,exprValue,getOrigin(ctx),getCol(ctx));
    }

    /**
     * Visits a variable declaration with initialization.
     * Declares a new variable in the current scope and assigns it the value
     * obtained from evaluating the expression. Checks for type consistency.
     */
    @Override
    public T visitVarDeclWithARg(MusicParser.VarDeclWithARgContext ctx) {
        Melody melody = stack.peek();
        String varName = ctx.ID().getText();
        VarInfo varInfo= VisitorUtils.declareVar(varName, melody,currentScope,globalScope,getOrigin(ctx), getCol(ctx));
        Value val = tryCasting(ctx.expr());
        if (val.getType() != varInfo.type) {
            throw new ValueError("Incorrect type of variable: " + ctx.ID().getText() + " Type " + varInfo.type + " not: " + val.getType(), this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        varInfo.valueObj = VisitorUtils.copyValue(val);
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

    /**
     * Plays a musical note for the specified duration.
     * Duration can be provided as an integer literal or retrieved from an integer variable.
     * The note name is converted to the internal format before playing.
     */
    @Override
    public T visitPlayNote(MusicParser.PlayNoteContext ctx) {
        int duration;
        if (ctx.INT_VAL() != null) duration = Integer.parseInt(ctx.INT_VAL().getText());
        else {
            IntValue varInt = (IntValue) VisitorUtils.extractVariable(ctx.ID(), Type.INT, ctx.parent(), stack.peek(),currentScope,globalScope,getOrigin(ctx),getCol(ctx)).valueObj;
            duration = varInt.value;
        }
        Note note = Note.valueOf(ctx.NOTE_VAL().getText().replace('#', 's').replace('-', 'm'));
        Music.playNote(note, duration,stack.peek(),currentScope);
        return visitChildren(ctx);
    }

    /**
     * Plays a chord for the given duration.
     * Duration can be specified directly as an integer or via an integer variable.
     * Retrieves the chord notes and plays them using the current melody and scope.
     */
    @Override
    public T visitPlayChord(MusicParser.PlayChordContext ctx) {
        ChordValue chord = (ChordValue) visit(ctx.chord());
        int duration = 0;
        if (ctx.INT_VAL() != null) duration = Integer.parseInt(ctx.INT_VAL().getText());
        else if (ctx.ID() != null) {
            IntValue varInt = (IntValue) VisitorUtils.extractVariable(ctx.ID(), Type.INT, ctx.parent(),stack.peek(),currentScope,globalScope,getOrigin(ctx),getCol(ctx)).valueObj;
            duration = varInt.value;
        }
        Music.playChord(chord.notes, duration,stack.peek(),currentScope);
        return visitChildren(ctx);
    }

    /**
     * Executes a function call and assigns its return value to a variable if specified.
     * Checks type compatibility between the function's return value and the target variable.
     * Updates the variable's value if types match; otherwise, throws a type error.
     */
    @Override
    public T visitPlayFunc(MusicParser.PlayFuncContext ctx) {
        String name = null;
        VarInfo var = null;
        ReturnVal returnValue = (ReturnVal)visit(ctx.functionCall());
        currentScope = stack.pop().previous_scope;
        if (ctx.ID() != null) {
            name = ctx.ID().getText();
            var = VisitorUtils.extractVariable(ctx.ID(), null, ctx.parent(),stack.peek(),currentScope,globalScope,getOrigin(ctx),getCol(ctx));
        }
        if (returnValue.getValue() == null || name == null) return null;
        else if (var.type != returnValue.getValue().getType())
            throw new ValueError("Function returned: " + returnValue.getValue().getType() + " which was assigned to: " + var.type, this.lineMap.get(getLine(ctx)), getCol(ctx));
        else var.valueObj = VisitorUtils.copyValue(returnValue.getValue());
        return null;
    }

    /**
     * Visits play statements for ID variants (notes, chords, or tracks).
     * Retrieves the current melody from the stack and delegates the play action
     * to the PlayIDVariants utility method.
     */
    @Override
    public T visitPlayIDVariants(MusicParser.PlayIDVariantsContext ctx) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        PlayIDVariants.play(ctx,melody,currentScope,globalScope,tracks,getOrigin(ctx),getCol(ctx));
        return visitChildren(ctx);
    }

    /**
     * Visits and plays multiple values sequentially.
     * Iterates over all MultiPlayValues in the context and visits each one.
     */
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

            var = VisitorUtils.findVar(varName, ctx.parentID(lastId).parent(),stack.peek(), currentScope, globalScope, lineMap.get(getLine(ctx)), getCol(ctx));

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

                varInfo = VisitorUtils.findVar(varName, idContext.parent(),stack.peek(),currentScope,globalScope,lineMap.get(getLine(ctx)),getCol(ctx));

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

                var = VisitorUtils.findVar(varName, ctx.parent(),stack.peek(),currentScope,globalScope,lineMap.get(getLine(ctx)),getCol(ctx));

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
                T result = visit(ctx.scope());
                if (result instanceof ReturnVal) return result;
            } catch (BreakError b) {
                currentScope = callbackScope;
                currentScope = VisitorUtils.skipScope(currentScope,stack.peek());
                return null;
            } catch (ContinueError ignored) {
                currentScope = callbackScope;
                VisitorUtils.resetCurrScope(temp,stack.peek(),currentScope);
            }
            T result = visit(ctx);
            if(result instanceof ReturnVal){
                return result;
            }
        } else {
            currentScope = VisitorUtils.skipScope(currentScope,stack.peek());
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
        for (int childIdx = 0; childIdx < ctx.getChildCount(); childIdx++ ) {
            ParseTree child = ctx.getChild(childIdx);
            if (child instanceof MusicParser.IfContext || child instanceof MusicParser.ElseifContext) {
                if (!status) {
                    T result = visit(child);
                    if(result instanceof ReturnVal) return result;
                    if (result instanceof Boolean) status = (Boolean) result;
                } else {
                    currentScope = VisitorUtils.skipScope(currentScope,stack.peek());
                }
            } else if (child instanceof MusicParser.ElseContext && !status) {
                 T result = visit(child);
                 if(result instanceof  ReturnVal) return result;
            }
        }
        return null;
    }

    @Override
    public T visitScope(MusicParser.ScopeContext ctx) {
        Scope temp = null;
        currentScope = VisitorUtils.getCurrScope(stack.peek(),currentScope);
        if (ctx.parent instanceof MusicParser.WhileLoopContext || ctx.parent instanceof MusicParser.ForLoopContext) {
            temp = Scope.deepCopyScopeStructure(currentScope, currentScope.melodyParent, currentScope.parent);
        }

        T result = visit(ctx.loopBody());
        if(result instanceof ReturnVal){
            currentScope = currentScope.parent;
            return result;
        }

        if (temp != null) {
            currentScope = currentScope.parent;
            VisitorUtils.resetCurrScope(temp,stack.peek(),currentScope);
        } else {
            currentScope = VisitorUtils.changeScope(stack.peek(), currentScope);
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
                T result = visit(ctx.scope());
                if (result instanceof ReturnVal) return result;
                else return (T) new Boolean(true);
            } else {
                currentScope = VisitorUtils.skipScope(currentScope,stack.peek());
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
                T result = visit(ctx.scope());
                if (result instanceof ReturnVal) return result;
                else return (T) new Boolean(true);
            } else {
                currentScope = VisitorUtils.skipScope(currentScope,stack.peek());
                return (T) new Boolean(false);
            }
        } else
            throw new ValueError("Expression is not of type BOOLEAN, got type: " + exprVal.getClass().getName(), this.lineMap.get(getLine(ctx)), getCol(ctx));
    }

    @Override
    public T visitElse(MusicParser.ElseContext ctx) {
        //System.out.println("Exiting else, else memory: " + currentScope.memory.values().stream().map(e -> e.toString()).collect(Collectors.joining(" ")));
        return visit(ctx.scope());
    }

    @Override
    public T visitForInit(MusicParser.ForInitContext ctx) {
        if (ctx.varDecl() != null) {
            currentScope = VisitorUtils.getCurrScope(stack.peek(),currentScope);
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
                    T result = visit(ctx.scope());
                    if (result instanceof ReturnVal) return result;
                } catch (BreakError b) {
                    currentScope = callbackScope;
                    currentScope = VisitorUtils.skipScope(currentScope,stack.peek());
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
                    VisitorUtils.resetCurrScope(temp,stack.peek(),currentScope);
                }
                if (ctx.forUpdate() != null) {
                    visit(ctx.forUpdate());
                }
            }
            currentScope = VisitorUtils.skipScope(currentScope,stack.peek());
        } else {
            currentScope = VisitorUtils.skipScope(currentScope,stack.peek());
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
        for(ParseTree child: ctx.children){
            T result = visit(child);
            if (result instanceof ReturnVal) return result;
        }
        return null;
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
                par.valueObj = VisitorUtils.copyValue(arg);
            }
        }
        for (Map.Entry<Integer, VarInfo> param : melody.parameters.entrySet()) {
            if (melody.memory.containsKey(param.getValue().name))
                throw new RuntimeError("Redeclaration in line: " + melody.memory.get(param.getValue().name).line + " of a melody parameter inside melody's body: " + param.getValue().name, this.lineMap.get(getLine(ctx.arguments())), getCol(ctx.arguments()));
            melody.memory.put(param.getValue().name, param.getValue());

        }

        melody.previous_scope = currentScope;
        currentScope = null;
        stack.push(melody);
        if (stack.size() > 100) throw new StackOverflow(name);

        if (ctx.settingsList() != null) {
            for (MusicParser.SettingsAssigmentContext set : ctx.settingsList().settingsAssigment())
                visit(set);
        }
        /**
         * @Kacper, odwiedzam każdy stmt funckji i sprawdzam czy przyadkiem nie zwraca typu ReturnVal
         * Jeśli tak to przerywam i zwracam dalej ta wartosć -> visitPlayFunc, tam jest zmiana currentScope na melody.previousScope
         * Jeśli nie to pętla dojedzie do końca i zwracam ReturnVal z wartością null
         */
        ReturnVal returnVal = null;
        for (MusicParser.StatementContext statement : melody.body) {
            T result = visit(statement);
            if(result instanceof ReturnVal){
                returnVal = (ReturnVal) result;
                break;
            }
        }
        if(returnVal != null) return  (T)returnVal;
        else{
            return (T) new ReturnVal(null);
        }
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

        varInfo = VisitorUtils.findVar(varName, ctx.parent(), stack.peek(),currentScope,globalScope,lineMap.get(getLine(ctx)),getCol(ctx));

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

    @SuppressWarnings("unchecked")
    @Override public T visitCastExpr(MusicParser.CastExprContext ctx) {
        Value value = tryCasting(ctx.expr());
        Type type = Type.valueOf(ctx.type().getText().toUpperCase());
        return (T) CastExpression.cast(value,type, this.lineMap.get(getLine(ctx)), getCol(ctx));
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
    public T visitChordExpr(MusicParser.ChordExprContext ctx) {
        return visit(ctx.chord());
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
            NoteValue newNote = new NoteValue(note);
            if (!notes.contains(newNote))
                notes.add(newNote);
        }
        for (TerminalNode node : ctx.ID()) {
            NoteValue varNote = (NoteValue) VisitorUtils.extractVariable(node, Type.NOTE, ctx.parent(),stack.peek(),currentScope,globalScope,getOrigin(ctx),getCol(ctx)).valueObj;
            if (!notes.contains(varNote))
                notes.add(varNote);
        }
        if (notes.size() < 2)
            throw new ValueError("Invalid operation with chords: same note repeated", this.lineMap.get(getLine(ctx)), getCol(ctx));
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

    @Override
    public T visitErrorNode(ErrorNode errorNode) {
        return null;
    }


    private int getLine(ParserRuleContext ctx) {
        return ctx.getStart().getLine();
    }

    private LineOrigin getOrigin(ParserRuleContext ctx){
        return lineMap.get(getLine(ctx));
    }

    private int getCol(ParserRuleContext ctx) {
        return ctx.getStart().getCharPositionInLine();
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

    private boolean checkForExpr(MusicParser.ForLoopContext ctx) {
        return ((BoolValue) visit(ctx.expr())).value;
    }

    private void editProperSettings(MusicParser.SettingsAssigmentContext ctx, List<MusicParser.ParentContext> parents, Effect effect){
        Melody melody = stack.peek();
        if (currentScope != null) {
            VisitorUtils.editEffect(ctx, effect, parents,currentScope.effects,currentScope.instrument,
                    currentScope.channels, melody,currentScope,globalScope,getOrigin(ctx),getCol(ctx));
        } else if (stack.peek() != null) VisitorUtils.editEffect(ctx, effect,null,melody.effects,melody.instrument,
                melody.channels,melody,currentScope,globalScope,getOrigin(ctx),getCol(ctx));
    }
}