package pl.edu.agh;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;
import pl.edu.agh.errors.*;
import pl.edu.agh.utils.*;
import pl.edu.agh.musicUtils.Instrument;
import pl.edu.agh.musicUtils.*;
import pl.edu.agh.visitorActions.*;
import pl.edu.agh.visitorActions.VisitorUtils;
import java.util.*;
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

    /**
     * Visits a MultiPlayValuesContext to play multiple musical elements.
     * Retrieves the duration for playback, then iterates over each child node in the context.
     * Depending on the type of each child (Note, Chord, or variable), it plays the corresponding sound.
     * Falls back to variable resolution if the type is not directly identifiable.
     */
    @Override
    public T visitMultiPlayValues(MusicParser.MultiPlayValuesContext ctx) {
        Melody melody = stack.peek();
        int duration = MultiPlayValues.getDuration(ctx,melody,currentScope,globalScope,getOrigin(ctx),getCol(ctx));
        for (int i = 0; i < ctx.getChildCount() - 1; i++) {
            ParseTree child = ctx.getChild(i);
            T childValue = visit(child);
            if (childValue instanceof ChordValue) {
                ChordValue chord = (ChordValue) childValue;
                Music.playChord(chord.notes, duration,melody,currentScope);
            } else if (childValue instanceof NoteValue) {
                NoteValue note = (NoteValue) childValue;
                Music.playNote(note.note, duration,melody,currentScope);
            } else {
                MusicParser.ParentIDContext idContext = (MusicParser.ParentIDContext) child;
                MultiPlayValues.playVariable(idContext,melody,currentScope,globalScope,duration,getOrigin(ctx),getCol(ctx));
            }
        }
        return visitChildren(ctx);
    }


    /**
     * Visits a PauseStatementContext to pause the execution.
     * Delegates to the PauseStatement.Pause method to determine the duration
     * and perform the thread sleep. Uses the current Melody and scope information
     * to resolve potential variable-based durations.
     */
    @Override
    public T visitPauseStatement(MusicParser.PauseStatementContext ctx) {
        Melody melody = stack.peek();
        PauseStatement.pause(ctx,melody,currentScope,globalScope,getOrigin(ctx),getCol(ctx));
        return visitChildren(ctx);
    }

    @Override
    public T visitLoopStatement(MusicParser.LoopStatementContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visits a WhileLoopContext to execute a while-loop construct.
     * Evaluates the loop condition and, if true, enters the loop's scope.
     * Manages loop control flow, including break and continue statements.
     * Ensures correct handling of scope restoration and variable context during each iteration.
     */
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
            if(result instanceof ReturnVal) return result;
        }
        else currentScope = VisitorUtils.skipScope(currentScope,stack.peek());
        return null;
    }


    /**
     * This function creates variable status to check which statement is to be executed
     * It iterates over every IF/ELSE/ELSEIF ctx and visits it to check if its expression is true or false
     * The first found expr that return True is executed and the remaining statements are deleted from currentScope's list of Child Scopes
     * (because changeScope brings us back to the parent Scope not the Scope of the IF/ELSE/ELSEIF we are entering)
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

    /**
     * Visits a ScopeContext to handle variable scoping within loops or code blocks.
     * Adjusts the current scope based on the parent context (e.g., while or for loops).
     * Ensures proper scope restoration after loop execution or return statements.
     * Uses deep copying of scope structure for loop-related scopes to maintain isolation.
     */
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
        }
        else currentScope = VisitorUtils.changeScope(stack.peek(), currentScope);
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
     */
    @Override
    public T visitIf(MusicParser.IfContext ctx) {
        Value exprVal = tryCasting(ctx.expr());
        if (exprVal instanceof BoolValue) {
            if (((BoolValue) exprVal).value) {
                T result = visit(ctx.scope());
                if (result instanceof ReturnVal) return result;
                else return (T) Boolean.TRUE;
            } else {
                currentScope = VisitorUtils.skipScope(currentScope,stack.peek());
                return (T) Boolean.FALSE;
            }
        } else
            throw new ValueError("Expression is not of type BOOLEAN, got type: " + exprVal.getClass().getName(), this.lineMap.get(getLine(ctx)), getCol(ctx));
    }

    /**
     * Visits an ElseifContext to evaluate and execute an else-if branch.
     * Evaluates the conditional expression; if it resolves to true,
     * the corresponding scope is executed. If false, the scope is skipped.
     * Throws a ValueError if the expression is not of boolean type.
     */
    @Override
    public T visitElseif(MusicParser.ElseifContext ctx) {
        Value exprVal = tryCasting(ctx.expr());
        if (exprVal instanceof BoolValue) {
            if (((BoolValue) exprVal).value) {
                T result = visit(ctx.scope());
                if (result instanceof ReturnVal) return result;
                else return (T) Boolean.TRUE;
            } else {
                currentScope = VisitorUtils.skipScope(currentScope,stack.peek());
                return (T) Boolean.FALSE;
            }
        } else
            throw new ValueError("Expression is not of type BOOLEAN, got type: " + exprVal.getClass().getName(), this.lineMap.get(getLine(ctx)), getCol(ctx));
    }

    @Override
    public T visitElse(MusicParser.ElseContext ctx) {
        return visit(ctx.scope());
    }

    /**
     * Visits a ForInitContext to handle the initialization part of a for-loop.
     * If the initialization is a variable declaration, it visits the declaration
     * and assigns the declared variable's name to the forInit field in the current
     * or parent scope for tracking. If it's an assignment, it simply visits the assignment.
     */
    @Override
    public T visitForInit(MusicParser.ForInitContext ctx) {
        if (ctx.varDecl() != null) {
            currentScope = VisitorUtils.getCurrScope(stack.peek(),currentScope);
            visit(ctx.varDecl());
            currentScope = currentScope.parent;

            /*
             * if ForInit is Declaration then the variable goes to the scope representing For and
             * information about declared variable in () goes to the parent Scope
             */

            if (ctx.varDecl() instanceof MusicParser.VarDeclWithARgContext) {
                if (currentScope != null) {
                    currentScope.forInit = ((MusicParser.VarDeclWithARgContext) ctx.varDecl()).ID().getText();
                } else {
                    if (stack.peek() == null) throw new RuntimeException("Stack is empty!");
                    stack.peek().forInit = ((MusicParser.VarDeclWithARgContext) ctx.varDecl()).ID().getText();
                }
            } else {
                if (currentScope != null) {
                    currentScope.forInit = ((MusicParser.VarDeclWithoutArgContext) ctx.varDecl()).ID().getText();
                } else {
                    if (stack.peek() == null) throw new RuntimeException("Stack is empty!");
                    stack.peek().forInit = ((MusicParser.VarDeclWithoutArgContext) ctx.varDecl()).ID().getText();
                }
            }
        } else visit(ctx.assignment());
        return null;
    }

    /**
     * Visits a ForLoopContext to execute a for-loop construct.
     * Handles initialization, condition checking, loop body execution,
     * and update expressions. Manages scope creation and restoration for each iteration,
     * and correctly handles control flow statements like break and continue.
     * Ensures the forInit variable tracking is cleared after the loop.
     */
    @Override
    public T visitForLoop(MusicParser.ForLoopContext ctx) {
        if (ctx.forInit() != null) {
            visit(ctx.forInit());
        }

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
                    if (currentScope != null) currentScope.forInit = null;
                    else {
                        if (stack.peek() == null) throw new RuntimeException("Stack is empty!");
                        stack.peek().forInit = null;
                    }
                    return null;
                } catch (ContinueError ignored) {
                    currentScope = callbackScope;
                    VisitorUtils.resetCurrScope(temp,stack.peek(),currentScope);
                }
                if (ctx.forUpdate() != null) visit(ctx.forUpdate());
            }
        }
        currentScope = VisitorUtils.skipScope(currentScope,stack.peek());
        if (currentScope != null) currentScope.forInit = null;
        else {
            if (stack.peek() == null) throw new RuntimeException("Stack is empty!");
            stack.peek().forInit = null;
        }
        return null;
    }

    /**
     * Visits a LoopBodyContext to execute all child statements inside a loop body.
     * Iterates through each child node, visiting and executing it.
     * If a ReturnVal is encountered during execution, it immediately returns it.
     */
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

    /**
     * Executes a function call: retrieves the melody, checks argument count and types,
     * assigns parameter values, manages scope and call stack, applies settings,
     * and runs the melody body. Returns the result or null if no return.
     */
    @Override
    public T visitFunctionCall(MusicParser.FunctionCallContext ctx) {
        String name = ctx.ID().getText();
        Melody melody = FunctionCall.getMelodyCopy(name,melodyMemory,getOrigin(ctx),getCol(ctx));
        FunctionCall.copyEffects(melody, stack.peek(),currentScope);
        this.handleParameters(ctx,melody);

        melody.previous_scope = currentScope;
        currentScope = null;
        stack.push(melody);
        if (stack.size() > 100) throw new StackOverflow(name);
        if (ctx.settingsList() != null) {
            for (MusicParser.SettingsAssigmentContext set : ctx.settingsList().settingsAssigment()) visit(set);
        }
        ReturnVal returnVal = null;
        for (MusicParser.StatementContext statement : melody.body) {
            T result = visit(statement);
            if(result instanceof ReturnVal){
                returnVal = (ReturnVal) result;
                break;
            }
        }
        if(returnVal != null) return  (T)returnVal;
        else return (T) new ReturnVal(null);
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
    public T visitNoteExpr(MusicParser.NoteExprContext ctx) {
        return (T) Music.parseNote(ctx.NOTE_VAL().getText());
    }

    /**
     * Visits a logical OR expression node. Casts both operands to boolean values
     * and evaluates the OR operation.
     */
    @Override
    public T visitOrOperatorExpr(MusicParser.OrOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));
        return (T)OrOperatorExpr.evaluate(firstValue,secondValue,getOrigin(ctx),getCol(ctx));
    }

    /**
     * Visits a logical NOT expression. Casts the operand to boolean and negates it.
     */
    @Override
    public T visitNotExpr(MusicParser.NotExprContext ctx) {
        Value expr = tryCasting(ctx.expr());
        if (expr instanceof BoolValue) {
            BoolValue boolExpr = (BoolValue) expr;
            return (T) new BoolValue(!boolExpr.value);
        } else throw new ValueError("Incorrect type of expression: " + expr.getType() + " not BOOL", getOrigin(ctx), getCol(ctx));
    }

    /**
     * Visits an order operator expression (>, <, >=, <=), casts operands,
     * and evaluates the comparison.
     */
    @Override
    public T visitOrderOperatorExpr(MusicParser.OrderOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));
        return (T)OrderOperatorExpr.evaluate(ctx,firstValue,secondValue,getOrigin(ctx), getCol(ctx));
    }

    /**
     * Visits an instrument comparison expression. Checks if the current melody's
     * instrument matches the specified instrument value.
     */
    @Override
    public T visitInstrumentOperatorExpr(MusicParser.InstrumentOperatorExprContext ctx) {
        Melody melody = stack.peek();
        if (melody == null) throw new RuntimeException("Stack is empty!");
        return (T) new BoolValue(melody.instrument.toString().equals(ctx.INSTRUMENT_VALUE().getText()));
    }

    /**
     * Visits an addition or subtraction expression, casts operands,
     * and evaluates the operation using the AddSubOperatorExpr evaluator.
     */
    @Override
    public T visitAddSubOperatorExpr(MusicParser.AddSubOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));
        return (T)AddSubOperatorExpr.evaluate(ctx,firstValue,secondValue,getOrigin(ctx),getCol(ctx));
    }

    /**
     * Visits a logical AND expression, casts operands,
     * and evaluates the AND operation using AndOperatorExpr.evaluate.
     */
    @Override
    public T visitAndOperatorExpr(MusicParser.AndOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));
        return (T) AndOperatorExpr.evaluate(firstValue,secondValue,getOrigin(ctx), getCol(ctx));
    }

    /**
     * Visits and evaluates multiplication, division, or modulus expressions.
     * Casts operands and calls the static evaluate method for computation.
     */
    @Override
    public T visitMullDivOperatorExpr(MusicParser.MullDivOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));
        return (T)MullDivOperatorExpr.evaluate(ctx,firstValue,secondValue,getOrigin(ctx),getCol(ctx));
    }

    /**
     * Visits a boolean expression node.
     * Converts the boolean literal text ("true" or "false") to a BoolValue object.
     * Throws a SyntaxError if no boolean value is found in the context.
     */
    @Override
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

    /**
     * Visits an identifier expression node.
     * Looks up the variable information by name in the current and global scopes.
     * Throws UndefinedError if the variable is not defined.
     */
    @Override
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
    /**
     * Visits a cast expression node.
     * Casts the evaluated value of the expression to the specified type.
     */
    @Override public T visitCastExpr(MusicParser.CastExprContext ctx) {
        Value value = tryCasting(ctx.expr());
        Type type = Type.valueOf(ctx.type().getText().toUpperCase());
        return (T) CastExpression.cast(value,type, this.lineMap.get(getLine(ctx)), getCol(ctx));
    }

    /**
     * Visits the equality operator expression node.
     * Retrieves and casts both operand values,
     * then evaluates equality or inequality.
     */
    @Override
    public T visitEqOperatorExpr(MusicParser.EqOperatorExprContext ctx) {
        Value firstValue = tryCasting(ctx.expr(0));
        Value secondValue = tryCasting(ctx.expr(1));
        return (T)EqOperatorExpr.evaluate(ctx,firstValue,secondValue,getOrigin(ctx), getCol(ctx));
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

    /**
     * Visits a Chord node in the parse tree and returns its ChordValue.
     */
    @Override
    public T visitChord(MusicParser.ChordContext ctx) {
        return (T) Chord.get(ctx,stack.peek(),currentScope,globalScope,getOrigin(ctx), getCol(ctx));
    }

    /**
     * Visits a TrackAdd node, handling the addition of a melody (function call) to a track.
     * It verifies track and melody existence, applies settings, generates new code,
     * creates a new visitor context, and appends the resulting TrackComponent to the track.
     */
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
        MusicParser.ArgumentsContext args = ctx.trackStatement().functionCall().arguments();
        List<Value> argsOut = handleTrackParameters(ctx,args,melody);
        MusicParser.SettingsListContext settings = ctx.trackStatement().functionCall().settingsList();
        Melody main = stack.peek();
        Melody fakeMelody = Melody.deepCopyMelody(main);
        fakeMelody.copyEffects(main.effects);
        stack.push(fakeMelody);
        if (settings != null) for (MusicParser.SettingsAssigmentContext set : settings.settingsAssigment())  visit(set);
        stack.pop();
        String newCode = TrackHandler.generateNewCode(this.code, funcName, argsOut, fakeMelody.effects, fakeMelody.instrument);
        AbstractMap.SimpleEntry<MusicSuperVisitor, MusicParser.ProgramContext> msv_prog = TrackHandler.prepareVisitor(newCode, this.lineMap);
        TrackComponent newComponent = new TrackComponent(msv_prog.getKey(), msv_prog.getValue());
        track.add(newComponent);
        return null;
    }

    /**
     * Visits a TrackDeclare node and declares a new track variable.
     * Ensures that the track name hasn't been declared before to avoid redeclaration.
     */
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

    /**
     * Visits an IntVal node and parses it into an IntValue.
     * Handles optional negation if a minus sign is present before the value.
     */
    @Override
    public T visitIntVal(MusicParser.IntValContext ctx) {
        IntValue valueInt = new IntValue(Integer.parseInt(ctx.INT_VAL().getText()));
        if (ctx.SUB() != null) valueInt.value *= -1;
        return (T) valueInt;
    }


    @Override
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

    /**
     * Attempts to evaluate and cast the given expression into a Value.
     * Throws an error if the result is null (undefined variable) or if the result is of type Instrument,
     * which is not allowed in this context.
     */
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

    /**
     * Applies the settings defined in the given SettingsAssignmentContext to the specified effect.
     * Depending on whether a current scope is active, it applies settings either from the current scope
     * or directly from the melody on top of the stack.
     */
    private void editProperSettings(MusicParser.SettingsAssigmentContext ctx, List<MusicParser.ParentContext> parents, Effect effect){
        Melody melody = stack.peek();
        if (currentScope != null) {
            VisitorUtils.editEffect(ctx, effect, parents,currentScope.effects,currentScope.instrument,
                    currentScope.channels, melody,currentScope,globalScope,getOrigin(ctx),getCol(ctx));
        } else if (stack.peek() != null) VisitorUtils.editEffect(ctx, effect,null,melody.effects,melody.instrument,
                melody.channels,melody,currentScope,globalScope,getOrigin(ctx),getCol(ctx));
    }

    /**
     * Validates and assigns function call arguments to melody parameters.
     * Checks argument count and types, copies argument values,
     * and ensures no parameter re-declarations within the melody's memory.
     */
    private void handleParameters(MusicParser.FunctionCallContext ctx, Melody melody){
        if (ctx.arguments() == null && !melody.parameters.isEmpty())
            throw new RuntimeError("Invalid number of arguments: 0" + " instead of: " + melody.parameters.size(), getOrigin(ctx), getCol(ctx));
        if (ctx.arguments() != null) {
            if (melody.parameters.size() != ctx.arguments().expr().size())
                throw new RuntimeError("Invalid number of arguments: " + ctx.arguments().expr().size() + " instead of: " + melody.parameters.size(), getOrigin(ctx), getCol(ctx));
            int size = melody.parameters.size();
            for (int i = 0; i < size; i++) {
                VarInfo par = melody.parameters.get(i);
                Value arg = tryCasting(ctx.arguments().expr(i));
                if (par.type != arg.getType())
                    throw new RuntimeError("Invalid type of argument with index: " + (i + 1) + " : " + arg.getType() + " instead of: " + par.type,getOrigin(ctx), getCol(ctx));
                par.valueObj = VisitorUtils.copyValue(arg);
            }
        }
        for (Map.Entry<Integer, VarInfo> param : melody.parameters.entrySet()) {
            if (melody.memory.containsKey(param.getValue().name))
                throw new RuntimeError("Redeclaration in line: " + melody.memory.get(param.getValue().name).line + " of a melody parameter inside melody's body: " + param.getValue().name, getOrigin(ctx), getCol(ctx.arguments()));
            melody.memory.put(param.getValue().name, param.getValue());
        }
    }

    /**
     * Handles the evaluation and validation of arguments passed to a track function call.
     * Ensures that the number and types of arguments match the melody's defined parameters.
     */
    private List<Value> handleTrackParameters(MusicParser.TrackAddContext ctx, MusicParser.ArgumentsContext args, Melody melody){
        List<Value> argsOut = new ArrayList<>();
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
        return argsOut;
    }
}