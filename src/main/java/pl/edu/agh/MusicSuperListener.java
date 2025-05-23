// Generated from C:/Users/kacpe/IdeaProjects/c_flat/src/main/java/pl/edu/agh/grammar/Music.g4 by ANTLR 4.13.2
package pl.edu.agh;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import pl.edu.agh.errors.ScopeError;
import pl.edu.agh.errors.SyntaxError;
import pl.edu.agh.errors.VariableDeclarationError;
import pl.edu.agh.musicUtils.Instrument;
import pl.edu.agh.musicUtils.Note;
import pl.edu.agh.utils.*;

import java.util.*;

@SuppressWarnings("CheckReturnValue")

/**
 * Tu można zrobić całe sprawdzanie składni oraz czy semantyka jest poprawna
 */

public class MusicSuperListener  implements MusicListener {
    HashMap<String, Melody> melodyMemory;
    MusicLexer lexer;
    String currentMelody;
    Boolean enterMelody = false;
    private final Map<Integer, LineOrigin> lineMap;
    Scope lastScope = null;
    HashMap<String, VarInfo> globalScope = null;

    /**
     * ArrayList of Scope objects designed to create a parent-child relationship with another Scope/Melody
     * When visiting enterIf or any other isStatement it creates a Scope and puts it at the end of this list
     * From now on every variable declaration is put at this Scope's memory
     * If scopes is empty then declared variable goes into currentMelody's memory
     * When visiting exitIf the last scope is popped from the ArrayList and is placed at the end of the next last scope ArrayList of Scopes
     */

    ArrayList<Scope> scopes = new ArrayList<>();

    public MusicSuperListener(HashMap<String, Melody> melodyMemory, MusicLexer musicLexer, Map<Integer, LineOrigin> lines, HashMap<String, VarInfo> globalScope) {
        this.melodyMemory = melodyMemory;
        this.lexer = musicLexer;
        this.lineMap = lines;
        this.globalScope = globalScope;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterProgram(MusicParser.ProgramContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitProgram(MusicParser.ProgramContext ctx) {
    }

    @Override
    public void enterGlobalVars(MusicParser.GlobalVarsContext ctx) {

    }

    @Override
    public void exitGlobalVars(MusicParser.GlobalVarsContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterImports(MusicParser.ImportsContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitImports(MusicParser.ImportsContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFunctionDecl(MusicParser.FunctionDeclContext ctx) {
        if (enterMelody) {
            throw new SyntaxError("Melody: " + ctx.ID().getText() + " is declared inside other melody: " + currentMelody, this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        Melody newMelody = new Melody();
        String name = ctx.ID().getText();
        newMelody.name = name;
        newMelody.body = ctx.statement();
        int order = 0;
        if (ctx.parameters() != null) {
            for (MusicParser.ParameterContext param : ctx.parameters().parameter()) {
                String type = param.type().getText();
                switch (type) {
                    case "int":
                        newMelody.parameters.put(order, new VarInfo(param.ID().getText(), Type.INT, getLine(param), null));
                        break;
                    case "bool":
                        newMelody.parameters.put(order, new VarInfo(param.ID().getText(), Type.BOOL, getLine(param), null));
                        break;
                    case "Note":
                        newMelody.parameters.put(order, new VarInfo(param.ID().getText(), Type.NOTE, getLine(param), null));
                        break;
                    case "Chord":
                        newMelody.parameters.put(order, new VarInfo(param.ID().getText(), Type.CHORD, getLine(param), null));
                        break;
                    default:
                        throw new SyntaxError("Invalid type of parameter in function declaration, variable: " + param.ID().getText(), this.lineMap.get(getLine(param)), getCol(param));
                }
                order += 1;
            }
        }
        melodyMemory.put(name, newMelody);
        currentMelody = name;
        enterMelody = true;

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFunctionDecl(MusicParser.FunctionDeclContext ctx) {
        enterMelody = false;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterMainDecl(MusicParser.MainDeclContext ctx) {
        Melody newMelody = new Melody();
        newMelody.name = "main";
        newMelody.mainBody = ctx.mainStatement();
        melodyMemory.put("main", newMelody);
        currentMelody = "main";
        enterMelody = true;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitMainDecl(MusicParser.MainDeclContext ctx) {
        enterMelody = false;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterParameters(MusicParser.ParametersContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitParameters(MusicParser.ParametersContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterParameter(MusicParser.ParameterContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitParameter(MusicParser.ParameterContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterType(MusicParser.TypeContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitType(MusicParser.TypeContext ctx) {
    }

    @Override
    public void enterMainStatement(MusicParser.MainStatementContext ctx) {

    }

    @Override
    public void exitMainStatement(MusicParser.MainStatementContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterStatement(MusicParser.StatementContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitStatement(MusicParser.StatementContext ctx) {
    }

    @Override
    public void enterPrint(MusicParser.PrintContext ctx) {

    }

    @Override
    public void exitPrint(MusicParser.PrintContext ctx) {

    }

    @Override
    public void enterReturnStatement(MusicParser.ReturnStatementContext ctx) {

    }

    @Override
    public void exitReturnStatement(MusicParser.ReturnStatementContext ctx) {

    }

    @Override
    public void enterExprStatement(MusicParser.ExprStatementContext ctx) {

    }

    @Override
    public void exitExprStatement(MusicParser.ExprStatementContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSettings(MusicParser.SettingsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSettings(MusicParser.SettingsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPace(MusicParser.PaceContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPace(MusicParser.PaceContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSustain(MusicParser.SustainContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSustain(MusicParser.SustainContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterInstrument(MusicParser.InstrumentContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitInstrument(MusicParser.InstrumentContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterDistortion(MusicParser.DistortionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitDistortion(MusicParser.DistortionContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterJazz(MusicParser.JazzContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitJazz(MusicParser.JazzContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBlues(MusicParser.BluesContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBlues(MusicParser.BluesContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterVolume(MusicParser.VolumeContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitVolume(MusicParser.VolumeContext ctx) {
    }

    @Override
    public void enterVibrato(MusicParser.VibratoContext ctx) {

    }

    @Override
    public void exitVibrato(MusicParser.VibratoContext ctx) {

    }

    @Override
    public void enterBalance(MusicParser.BalanceContext ctx) {

    }

    @Override
    public void exitBalance(MusicParser.BalanceContext ctx) {

    }

    @Override
    public void enterSostenutoPedal(MusicParser.SostenutoPedalContext ctx) {

    }

    @Override
    public void exitSostenutoPedal(MusicParser.SostenutoPedalContext ctx) {

    }

    @Override
    public void enterSoftPedal(MusicParser.SoftPedalContext ctx) {

    }

    @Override
    public void exitSoftPedal(MusicParser.SoftPedalContext ctx) {

    }

    @Override
    public void enterResonance(MusicParser.ResonanceContext ctx) {

    }

    @Override
    public void exitResonance(MusicParser.ResonanceContext ctx) {

    }

    @Override
    public void enterReverb(MusicParser.ReverbContext ctx) {

    }

    @Override
    public void exitReverb(MusicParser.ReverbContext ctx) {

    }

    @Override
    public void enterTremolo(MusicParser.TremoloContext ctx) {

    }

    @Override
    public void exitTremolo(MusicParser.TremoloContext ctx) {

    }

    @Override
    public void enterChorus(MusicParser.ChorusContext ctx) {

    }

    @Override
    public void exitChorus(MusicParser.ChorusContext ctx) {

    }

    @Override
    public void enterPhraser(MusicParser.PhraserContext ctx) {

    }

    @Override
    public void exitPhraser(MusicParser.PhraserContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterSettingsValues(MusicParser.SettingsValuesContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitSettingsValues(MusicParser.SettingsValuesContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */

    @Override
    public void enterAssignment(MusicParser.AssignmentContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssignment(MusicParser.AssignmentContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSelfAssignment(MusicParser.SelfAssignmentContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSelfAssignment(MusicParser.SelfAssignmentContext ctx) {
    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterVarDeclWithARg(MusicParser.VarDeclWithARgContext ctx) {

        String varName = ctx.ID().getText();
        if (ctx.parent instanceof MusicParser.ForInitContext) {
            return;
        }
        if (currentMelody == null) {
            fillMemoryWithArg(globalScope, varName, ctx);
        }
        else if (scopes.isEmpty()) {
            Melody melody = melodyMemory.get(currentMelody);
            fillMemoryWithArg(melody.memory, varName, ctx);
        } else {
            Scope scope = scopes.get(scopes.size() - 1);
            fillMemoryWithArg(scope.memory, varName, ctx);
        }
    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitVarDeclWithARg(MusicParser.VarDeclWithARgContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterVarDeclWithoutArg(MusicParser.VarDeclWithoutArgContext ctx) {
        if (ctx.parent instanceof MusicParser.ForInitContext) {
            return;
        }
        String varName = ctx.ID().getText();
        if (currentMelody == null) {
            fillMemoryWithoutArg(globalScope, varName, ctx);
        }
        else if (scopes.isEmpty()) {
            Melody melody = melodyMemory.get(currentMelody);
            fillMemoryWithoutArg(melody.memory, varName, ctx);
        } else {
            Scope scope = scopes.get(scopes.size() - 1);
            fillMemoryWithoutArg(scope.memory, varName, ctx);
        }

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitVarDeclWithoutArg(MusicParser.VarDeclWithoutArgContext ctx) {

    }

    @Override
    public void enterPlayStatement(MusicParser.PlayStatementContext ctx) {

    }

    @Override
    public void exitPlayStatement(MusicParser.PlayStatementContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */

    @Override
    public void enterPlayNote(MusicParser.PlayNoteContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPlayNote(MusicParser.PlayNoteContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPlayChord(MusicParser.PlayChordContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPlayChord(MusicParser.PlayChordContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPlayFunc(MusicParser.PlayFuncContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPlayFunc(MusicParser.PlayFuncContext ctx) {
    }

    @Override
    public void enterPlayIDVariants(MusicParser.PlayIDVariantsContext ctx) {

    }

    @Override
    public void exitPlayIDVariants(MusicParser.PlayIDVariantsContext ctx) {

    }


    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterPlayMulti(MusicParser.PlayMultiContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitPlayMulti(MusicParser.PlayMultiContext ctx) {

    }

    @Override
    public void enterMultiPlayValues(MusicParser.MultiPlayValuesContext ctx) {

    }

    @Override
    public void exitMultiPlayValues(MusicParser.MultiPlayValuesContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPauseStatement(MusicParser.PauseStatementContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPauseStatement(MusicParser.PauseStatementContext ctx) {
    }

    @Override
    public void enterLoopStatement(MusicParser.LoopStatementContext ctx) {

    }

    @Override
    public void exitLoopStatement(MusicParser.LoopStatementContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterWhileLoop(MusicParser.WhileLoopContext ctx) {
    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitWhileLoop(MusicParser.WhileLoopContext ctx) {
    }

    @Override
    public void enterIfStatement(MusicParser.IfStatementContext ctx) {

    }

    @Override
    public void exitIfStatement(MusicParser.IfStatementContext ctx) {

    }

    @Override
    public void enterScope(MusicParser.ScopeContext ctx) {
        createScope();
    }

    @Override
    public void exitScope(MusicParser.ScopeContext ctx) {
        removeScope(ctx);
    }

    @Override
    public void enterParent(MusicParser.ParentContext ctx) {

    }

    @Override
    public void exitParent(MusicParser.ParentContext ctx) {

    }

    @Override
    public void enterParentID(MusicParser.ParentIDContext ctx) {

    }

    @Override
    public void exitParentID(MusicParser.ParentIDContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterIf(MusicParser.IfContext ctx) {
    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitIf(MusicParser.IfContext ctx) {
    }

    @Override
    public void enterElseif(MusicParser.ElseifContext ctx) {

    }

    @Override
    public void exitElseif(MusicParser.ElseifContext ctx) {
    }

    @Override
    public void enterElse(MusicParser.ElseContext ctx) {
    }

    @Override
    public void exitElse(MusicParser.ElseContext ctx) {
    }

    @Override
    public void enterForInit(MusicParser.ForInitContext ctx) {

    }

    @Override
    public void exitForInit(MusicParser.ForInitContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterForLoop(MusicParser.ForLoopContext ctx) {
    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitForLoop(MusicParser.ForLoopContext ctx) {
        Scope scope = lastScope;
        if (ctx.forInit() == null || ctx.forInit().varDecl() == null) {
            return;
        }
        if (ctx.forInit().varDecl() instanceof MusicParser.VarDeclWithARgContext) {
            MusicParser.VarDeclWithARgContext varDecl = (MusicParser.VarDeclWithARgContext) ctx.forInit().varDecl();
            String varName = varDecl.ID().getText();
            if (scope.memory.containsKey(varName))
                throw new VariableDeclarationError("Redeclaration of a variable: " + varName + " previously defined in line " + scope.memory.get(varName).line, this.lineMap.get(getLine(ctx)), getCol(ctx));
            if (Arrays.asList(((VocabularyImpl) this.lexer.getVocabulary()).getLiteralNames()).contains(varName))
                throw new VariableDeclarationError("Variable: " + varName + " is a keyword", this.lineMap.get(getLine(ctx)), getCol(ctx));
            if (isAnInstrument(varName))
                throw new VariableDeclarationError("Variable: " + varName + " is a name of an instrument (keyword)", this.lineMap.get(getLine(ctx)), getCol(ctx));
            if (isANote(varName))
                throw new VariableDeclarationError("Variable: " + varName + " is a name of a note (keyword)", this.lineMap.get(getLine(ctx)), getCol(ctx));

            switch (varDecl.type().getText()) {
                case "int":
                    VarInfo intInfo = new VarInfo(varName, Type.INT, getLine(ctx), null);
                    scope.memory.put(varName, intInfo);
                    break;
                case "bool":
                    VarInfo boolInfo = new VarInfo(varName, Type.BOOL, getLine(ctx), null);
                    scope.memory.put(varName, boolInfo);
                    break;
                case "Note":
                    VarInfo noteInfo = new VarInfo(varName, Type.NOTE, getLine(ctx), null);
                    scope.memory.put(varName, noteInfo);
                    break;
                case "Chord":
                    VarInfo chordInfo = new VarInfo(varName, Type.CHORD, getLine(ctx), null);
                    scope.memory.put(varName, chordInfo);
                    break;
                default:
                    break;
            }
        } else if (ctx.forInit().varDecl() instanceof MusicParser.VarDeclWithoutArgContext) {
            MusicParser.VarDeclWithoutArgContext varDecl = (MusicParser.VarDeclWithoutArgContext) ctx.forInit().varDecl();
            String varName = varDecl.ID().getText();
            if (scope.memory.containsKey(varName))
                throw new VariableDeclarationError("Redeclaration of a variable: " + varName + " previously defined in line " + scope.memory.get(varName).line, this.lineMap.get(getLine(ctx)), getCol(ctx));
            if (Arrays.asList(((VocabularyImpl) this.lexer.getVocabulary()).getLiteralNames()).contains(varName))
                throw new VariableDeclarationError("Variable: " + varName + " is a keyword", this.lineMap.get(getLine(ctx)), getCol(ctx));
            if (isAnInstrument(varName))
                throw new VariableDeclarationError("Variable: " + varName + " is a name of an instrument (keyword)", this.lineMap.get(getLine(ctx)), getCol(ctx));
            if (isANote(varName))
                throw new VariableDeclarationError("Variable: " + varName + " is a name of a note (keyword)", this.lineMap.get(getLine(ctx)), getCol(ctx));

            switch (varDecl.type().getText()) {
                case "int":
                    VarInfo intInfo = new VarInfo(varName, Type.INT, getLine(ctx), new IntValue(0));
                    scope.memory.put(varName, intInfo);
                    break;
                case "bool":
                    VarInfo boolInfo = new VarInfo(varName, Type.BOOL, getLine(ctx), new BoolValue(false));
                    scope.memory.put(varName, boolInfo);
                    break;
                case "Note":
                    VarInfo noteInfo = new VarInfo(varName, Type.NOTE, getLine(ctx), null);
                    scope.memory.put(varName, noteInfo);
                    break;
                case "Chord":
                    VarInfo chordInfo = new VarInfo(varName, Type.CHORD, getLine(ctx), null);
                    scope.memory.put(varName, chordInfo);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void enterLoopBody(MusicParser.LoopBodyContext ctx) {

    }

    @Override
    public void exitLoopBody(MusicParser.LoopBodyContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForUpdate(MusicParser.ForUpdateContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForUpdate(MusicParser.ForUpdateContext ctx) {
    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterForAssignment(MusicParser.ForAssignmentContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitForAssignment(MusicParser.ForAssignmentContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBreakStatement(MusicParser.BreakStatementContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBreakStatement(MusicParser.BreakStatementContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterContinueStatement(MusicParser.ContinueStatementContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitContinueStatement(MusicParser.ContinueStatementContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFunctionCall(MusicParser.FunctionCallContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFunctionCall(MusicParser.FunctionCallContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterArguments(MusicParser.ArgumentsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitArguments(MusicParser.ArgumentsContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterSettingsList(MusicParser.SettingsListContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitSettingsList(MusicParser.SettingsListContext ctx) {
    }


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterNoteExpr(MusicParser.NoteExprContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitNoteExpr(MusicParser.NoteExprContext ctx) {
    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterOrOperatorExpr(MusicParser.OrOperatorExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitOrOperatorExpr(MusicParser.OrOperatorExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterNotExpr(MusicParser.NotExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitNotExpr(MusicParser.NotExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterOrderOperatorExpr(MusicParser.OrderOperatorExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitOrderOperatorExpr(MusicParser.OrderOperatorExprContext ctx) {

    }

    @Override
    public void enterInstrumentOperatorExpr(MusicParser.InstrumentOperatorExprContext ctx) {

    }

    @Override
    public void exitInstrumentOperatorExpr(MusicParser.InstrumentOperatorExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterAddSubOperatorExpr(MusicParser.AddSubOperatorExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitAddSubOperatorExpr(MusicParser.AddSubOperatorExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterAndOperatorExpr(MusicParser.AndOperatorExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitAndOperatorExpr(MusicParser.AndOperatorExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterMullDivOperatorExpr(MusicParser.MullDivOperatorExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitMullDivOperatorExpr(MusicParser.MullDivOperatorExprContext ctx) {

    }

    @Override
    public void enterBoolExpr(MusicParser.BoolExprContext ctx) {
    }

    @Override
    public void exitBoolExpr(MusicParser.BoolExprContext ctx) {
    }

    @Override
    public void enterParanthesesExpr(MusicParser.ParanthesesExprContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitParanthesesExpr(MusicParser.ParanthesesExprContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterIdExpr(MusicParser.IdExprContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitIdExpr(MusicParser.IdExprContext ctx) {
    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterOrderOp(MusicParser.OrderOpContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitOrderOp(MusicParser.OrderOpContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterEqOp(MusicParser.EqOpContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitEqOp(MusicParser.EqOpContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterAndOp(MusicParser.AndOpContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitAndOp(MusicParser.AndOpContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterOrOp(MusicParser.OrOpContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitOrOp(MusicParser.OrOpContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterAddSubOp(MusicParser.AddSubOpContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitAddSubOp(MusicParser.AddSubOpContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterMullDivOp(MusicParser.MullDivOpContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitMullDivOp(MusicParser.MullDivOpContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterIntExpr(MusicParser.IntExprContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitIntExpr(MusicParser.IntExprContext ctx) {
    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterEqOperatorExpr(MusicParser.EqOperatorExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitEqOperatorExpr(MusicParser.EqOperatorExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void enterSettingsExpr(MusicParser.SettingsExprContext ctx) {

    }

    /**
     * @param ctx the parse tree
     */
    @Override
    public void exitSettingsExpr(MusicParser.SettingsExprContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterChordExpr(MusicParser.ChordExprContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitChordExpr(MusicParser.ChordExprContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAssOp(MusicParser.AssOpContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssOp(MusicParser.AssOpContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterChord(MusicParser.ChordContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitChord(MusicParser.ChordContext ctx) {
    }

    @Override
    public void enterTrackAdd(MusicParser.TrackAddContext ctx) {

    }

    @Override
    public void exitTrackAdd(MusicParser.TrackAddContext ctx) {

    }

    @Override
    public void enterTrackDeclare(MusicParser.TrackDeclareContext ctx) {

    }

    @Override
    public void exitTrackDeclare(MusicParser.TrackDeclareContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterTrackStatement(MusicParser.TrackStatementContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitTrackStatement(MusicParser.TrackStatementContext ctx) {
    }

    @Override
    public void enterTrackDeclaration(MusicParser.TrackDeclarationContext ctx) {

    }

    @Override
    public void exitTrackDeclaration(MusicParser.TrackDeclarationContext ctx) {

    }

    @Override
    public void enterIntVal(MusicParser.IntValContext ctx) {

    }

    @Override
    public void exitIntVal(MusicParser.IntValContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitTerminal(TerminalNode node) {
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitErrorNode(ErrorNode node) {
        throw new RuntimeException("An error has occurred");
    }


    private int getLine(ParserRuleContext ctx) {
        return ctx.getStart().getLine();
    }

    private int getCol(ParserRuleContext ctx) {
        return ctx.getStart().getCharPositionInLine();
    }

    private static boolean isAnInstrument(String value) {
        for (Instrument i : Instrument.values()) {
            if (i.name().equals(value)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isANote(String value) {
        for (Note n : Note.values()) {
            if (n.name().equals(value)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Creates Scope object by copying the memory of the last active Scope of the scopes ArrayList
     * or the currentMelody memory if ArrayList of active scopes if empty (meaning we are not in any ifStatement)
     * Additionally sets the parent of the newly created Scope
     */

    public void createScope() {
        Scope scope = new Scope();
        if (scopes.isEmpty()) {
            //scope = Scope.deepCopyFromParent(null, currMelody);
            scope.melodyParent = melodyMemory.get(currentMelody);
        } else {
            //scope = Scope.deepCopyFromParent(currScope, null);
            scope.parent = scopes.get(scopes.size() - 1);
        }
        scopes.add(scope);
    }

    /**
     * Removes last Scope from the list of active Scopes (ArrayList scopes)
     * Then puts it at the end of the next last Scope in ArrayList scopes
     * Meaning that the popped Scope is a child of this Scope
     *
     * @param ctx
     */

    public void removeScope(ParserRuleContext ctx) {

        if (scopes.isEmpty()) {
            throw new ScopeError("Out of scope!", this.lineMap.get(getLine(ctx)), getCol(ctx));
        }
        Scope scope = scopes.get(scopes.size() - 1);
        scopes.remove(scope);
        lastScope = scope;
        if (scope.parent != null) {
            //Scope.addMemoryFromMemory(scope, scope.parent, null);
            scope.parent.scopes.add(scope);
        } else if (scope.melodyParent != null) {
            //Scope.addMemoryFromMemory(scope, null, scope.melodyParent);
            scope.melodyParent.scopes.add(scope);
        }
    }


    private void fillMemoryWithArg(HashMap<String, VarInfo> memory, String varName, MusicParser.VarDeclWithARgContext ctx) {
        if (memory.containsKey(varName))
            throw new VariableDeclarationError("Redeclaration of a variable: " + varName + " previously defined in line " + memory.get(varName).line, this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (Arrays.asList(((VocabularyImpl) this.lexer.getVocabulary()).getLiteralNames()).contains(varName))
            throw new VariableDeclarationError("Variable: " + varName + " is a keyword", this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (isAnInstrument(varName))
            throw new VariableDeclarationError("Variable: " + varName + " is a name of an instrument (keyword)", this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (isANote(varName))
            throw new VariableDeclarationError("Variable: " + varName + " is a name of a note (keyword)", this.lineMap.get(getLine(ctx)), getCol(ctx));

        switch (ctx.type().getText()) {
            case "int":
                VarInfo intInfo = new VarInfo(varName, Type.INT, getLine(ctx), null);
                memory.put(varName, intInfo);
                break;
            case "bool":
                VarInfo boolInfo = new VarInfo(varName, Type.BOOL, getLine(ctx), null);
                memory.put(varName, boolInfo);
                break;
            case "Note":
                VarInfo noteInfo = new VarInfo(varName, Type.NOTE, getLine(ctx), null);
                memory.put(varName, noteInfo);
                break;
            case "Chord":
                VarInfo chordInfo = new VarInfo(varName, Type.CHORD, getLine(ctx), null);
                memory.put(varName, chordInfo);
                break;
            default:
                break;
        }
    }

    private void fillMemoryWithoutArg(HashMap<String, VarInfo> memory, String varName, MusicParser.VarDeclWithoutArgContext ctx) {
        if (memory.containsKey(varName))
            throw new VariableDeclarationError("Redeclaration of a variable: " + varName + " previously defined in line " + memory.get(varName).line, this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (Arrays.asList(((VocabularyImpl) this.lexer.getVocabulary()).getLiteralNames()).contains(varName))
            throw new VariableDeclarationError("Variable: " + varName + " is a keyword", this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (isAnInstrument(varName))
            throw new VariableDeclarationError("Variable: " + varName + " is a name of an instrument (keyword)", this.lineMap.get(getLine(ctx)), getCol(ctx));
        if (isANote(varName))
            throw new VariableDeclarationError("Variable: " + varName + " is a name of a note (keyword)", this.lineMap.get(getLine(ctx)), getCol(ctx));

        switch (ctx.type().getText()) {
            case "int":
                VarInfo intInfo = new VarInfo(varName, Type.INT, getLine(ctx), new IntValue(0));
                memory.put(varName, intInfo);
                break;
            case "bool":
                VarInfo boolInfo = new VarInfo(varName, Type.BOOL, getLine(ctx), new BoolValue(false));
                memory.put(varName, boolInfo);
                break;
            case "Note":
                VarInfo noteInfo = new VarInfo(varName, Type.NOTE, getLine(ctx), null);
                memory.put(varName, noteInfo);
                break;
            case "Chord":
                VarInfo chordInfo = new VarInfo(varName, Type.CHORD, getLine(ctx), null);
                memory.put(varName, chordInfo);
                break;
            default:
                break;
        }
    }


}

