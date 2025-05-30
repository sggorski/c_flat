package pl.edu.agh.visitorActions;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import pl.edu.agh.Melody;
import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.ScopeError;
import pl.edu.agh.errors.UndefinedError;
import pl.edu.agh.errors.ValueError;
import pl.edu.agh.musicUtils.Effect;
import pl.edu.agh.musicUtils.Instrument;
import pl.edu.agh.musicUtils.Music;
import pl.edu.agh.utils.*;

import javax.sound.midi.MidiChannel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static pl.edu.agh.musicUtils.Instrument.*;

public class VisitorUtils {

    /**
     * Creates and returns a deep copy of the given Value object.
     * Supports the following types: INT, BOOL, NOTE, and CHORD.
     * Returns null if the Value type is unrecognized.
     *
     * @param value the Value object to copy
     * @return a deep copy of the given Value, or null if type is unknown
     */
    public static Value copyValue(Value value){
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

    /**
     * Finds the new active Scope when visiting if or any other IfStatement
     * which translates to finding the first child Scope of the previous currentScope
     * or first child of the Melody if there is no active Scope at the moment -> currentScope is null
     */
    public static Scope getCurrScope(Melody melody,Scope currentScope) {
        Scope firstScope;
        if (melody == null) throw new RuntimeException("Stack is empty!");
        if (melody.scopes.isEmpty()) return null;
        if (currentScope != null) {
            firstScope = currentScope.scopes.get(0);
            firstScope.copyEffects(currentScope.effects);
            firstScope.setInstrument(currentScope.instrument);
        } else {
            firstScope = melody.scopes.get(0);
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
    public static Scope changeScope(Melody topMelody, Scope currentScope) {
        if (currentScope != null) {
            currentScope = currentScope.parent;
            if (currentScope == null) {
                if (topMelody != null) {
                    topMelody.scopes.remove(0);
                } else throw new RuntimeException("Stack is empty!");
            } else {
                currentScope.scopes.remove(0);
            }
        }
        return currentScope;
    }

    /**
     * Resets the first inner scope of the given currentScope or melody to the provided temp scope.
     * If currentScope is null, modifies the root scope of the melody.
     * Throws a RuntimeException if both currentScope and melody are null.
     */
    public static  void resetCurrScope(Scope temp, Melody melody, Scope currentScope) {
        if (currentScope == null) {
            if (melody== null) {
                throw new RuntimeException("Stack is empty!");
            }
            melody.scopes.set(0, temp);
        } else {
            currentScope.scopes.set(0, temp);
        }
    }

    /**
     * Skips to the next scope by retrieving the current scope
     * and applying a scope change operation.
     */
    public static Scope skipScope(Scope currentScope, Melody melody ) {
        currentScope = getCurrScope(melody, currentScope);
        currentScope = changeScope(melody, currentScope);
        return currentScope;
    }


    /**
     * The order is like this:
     * current scope is not null then we first look for the first scope after up: statement
     * then we check whether this scope has for scope with declared variable inside () of for
     * then we check this and higher scopes memory (we dont want to check other scopes forInit because if the scope has variable in forInit
     * then it child also has this variable)
     * lastly we check the main memory
     * if current scope is null then we only check main forInit and memory
     */
    public static  VarInfo findVar(String varName, List<MusicParser.ParentContext> parentContexts, Melody melody,
                            Scope currentScope, HashMap<String,VarInfo> globalScope, LineOrigin origin, int col) {


        HashSet<String> gatheredVars = new HashSet<>();
        FindPossibleVar.copyForProposal(globalScope.keySet(), gatheredVars);


        if (currentScope != null) {
            Scope current = currentScope;
            for (int i = 0; i < parentContexts.size(); i++) {
                current = current.parent;
                parentContexts.remove(0);
                if (current == null) break;
            }
            if (parentContexts.size() > 1){
                throw new ScopeError("There is no higher scope!", origin, col);
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
                gatheredVars.add(current.forInit);
            } else {
                if (melody != null && melody.forInit != null && melody.forInit.equals(varName)) {
                    return melody.scopes.get(0).memory.get(varName);
                }
                gatheredVars.add(melody.forInit);
            }

            while (current != null) {
                if (!current.memory.containsKey(varName) || current.memory.get(varName) == null) {
                    FindPossibleVar.copyForProposal(current.memory.keySet(), gatheredVars);
                    current = current.parent;
                } else {
                    return current.memory.get(varName);
                }
            }


            if (melody != null && (melody.memory.containsKey(varName) || melody.memory.get(varName) != null))  {
                if(parentContexts.isEmpty()){
                    return melody.memory.get(varName);
                }
                FindPossibleVar.copyForProposal(melody.memory.keySet(), gatheredVars);
            } else if (globalScope.containsKey(varName) || globalScope.get(varName) != null) {
                return globalScope.get(varName);
            }

            String proposal = FindPossibleVar.returnProposal(varName, gatheredVars);

            throw new UndefinedError("Variable not defined: " + varName, origin, col, proposal);

        } else if (melody != null) {

            if (parentContexts == null || parentContexts.isEmpty()) {
                FindPossibleVar.copyForProposal(melody.memory.keySet(), gatheredVars);
                if (varName.equals(melody.forInit)) {
                    return melody.scopes.get(0).memory.get(varName);
                } else if (melody.memory.containsKey(varName) && melody.memory.get(varName) != null) {
                    return melody.memory.get(varName);
                } else if (globalScope.containsKey(varName) && globalScope.get(varName) != null) {
                    return globalScope.get(varName);
                }
                throw new UndefinedError("Variable not defined: " + varName, origin, col, FindPossibleVar.returnProposal(varName, gatheredVars));
            } else if (parentContexts.size() == 1) {
                if (globalScope.containsKey(varName) && globalScope.get(varName) != null) {
                    return globalScope.get(varName);
                }
                throw new UndefinedError("Variable not defined: " + varName, origin, col, FindPossibleVar.returnProposal(varName, gatheredVars));
            }else {
                throw new ScopeError("There is no higher scope!", origin, col);
            }
        } else {
            if(parentContexts != null && !parentContexts.isEmpty()) {
                throw new ScopeError("There is no higher scope!", origin, col);
            }
            if(globalScope.containsKey(varName)) {
                return globalScope.get(varName);
            }else throw new UndefinedError("Variable not defined: " + varName, origin, col, FindPossibleVar.returnProposal(varName, gatheredVars));
        }
    }

    /**
     * Extracts a variable by name from the current scope, parent contexts, or global scope.
     * Validates the variable's existence and optionally its type.
     */
    public static VarInfo extractVariable(TerminalNode id, Type type, List<MusicParser.ParentContext> parents, Melody melody,
                                   Scope currentScope, HashMap<String,VarInfo> globalScope, LineOrigin origin, int col) {

        if (melody == null) throw new RuntimeException("Stack is empty!");
        VarInfo var;
        String varName = id.getText();
        var = findVar(varName, parents, melody,currentScope,globalScope,origin,col);
        if (var == null)
            throw new UndefinedError("Variable not defined: " + id.getText(), origin,col);
        if (type == null) return var;
        if (var.type != type)
            throw new ValueError("Incorrect type of variable: " + id.getText() + "Type " + var.type + " not " + type, origin,col);
        return var;
    }

    /**
     * Declares var saved in memory of scope or melody
     * if parent of declaration is For loop then we declare the value in
     * the child scope because this declaration happens BEFORE we jump into FOR scope
     */
    public static VarInfo declareVar(String varName, Melody melody, Scope current, HashMap<String,VarInfo> globalScope, LineOrigin origin, int col) {

        HashSet<String> gatheredVars = new HashSet<>();
        FindPossibleVar.copyForProposal(globalScope.keySet(), gatheredVars);
        FindPossibleVar.copyForProposal(melody.memory.keySet(), gatheredVars);
        gatheredVars.add(melody.forInit);

        while (current != null) {
            if (!current.memory.containsKey(varName)) {
                FindPossibleVar.copyForProposal(current.memory.keySet(), gatheredVars);
                gatheredVars.add(current.forInit);
                current = current.parent;
            } else return current.memory.get(varName);
        }

        if (melody != null && melody.memory.containsKey(varName)) {
            return melody.memory.get(varName);
        } else if (globalScope.containsKey(varName)) {
            return globalScope.get(varName);
        }
        throw new UndefinedError("Variable not defined: " + varName, origin, col, FindPossibleVar.returnProposal(varName, gatheredVars));

    }


    /**
     * Allows us to get settings from a proper place, scope or melody
     */
    public static Value getSettings(Effect effect, Melody melody, Scope currentScope){
        if (currentScope != null) {
            return currentScope.effects.get(effect);
        } else if (melody != null) return melody.effects.get(effect);
        return null;
    }

    /**
     * Edits the specified musical effect by evaluating the value from the assignment context.
     * Depending on the effect type, it supports integer or boolean values, either directly or via variable lookup.
     * Applies the effect to the corresponding MIDI channel if needed.
     */
    public static void editEffect(MusicParser.SettingsAssigmentContext ctx, Effect effect, List<MusicParser.ParentContext> parents,
                           HashMap<Effect,Value> effects, Instrument instrument, MidiChannel[] channels, Melody melody,
                           Scope currentScope, HashMap<String, VarInfo> globalScope, LineOrigin origin, int col) {

        ParseTree lastChild = ctx.children.get(ctx.children.size() - 1);
        if (effect == Effect.PACE || effect == Effect.VOLUME) {
            if (lastChild != null && isNumeric(String.valueOf(lastChild)))
                effects.put(effect, new IntValue(Integer.parseInt(String.valueOf(lastChild))));
            else if (lastChild != null) {
                IntValue varInt = (IntValue) VisitorUtils.extractVariable((TerminalNode) lastChild, Type.INT, parents,melody,currentScope,globalScope,origin, col).valueObj;
                effects.put(effect, varInt);
            }

        } else if (effect == Effect.JAZZ || effect == Effect.BLUES) {
            if (lastChild != null && isBoolean(String.valueOf(lastChild)))
                effects.put(effect, new BoolValue(Boolean.parseBoolean(String.valueOf(lastChild))));
            else if (lastChild != null) {
                BoolValue varBool = (BoolValue) VisitorUtils.extractVariable((TerminalNode) lastChild, Type.BOOL, parents,melody,currentScope,globalScope,origin, col).valueObj;
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
                IntValue varInt = (IntValue) VisitorUtils.extractVariable((TerminalNode) lastChild, Type.INT, parents,melody,currentScope,globalScope,origin,col).valueObj;
                if (instrument == DRUMS)
                    channels[9].controlChange(Music.effectControllers.get(effect), varInt.value);
                else
                    channels[0].controlChange(Music.effectControllers.get(effect), varInt.value);
            }
        }
    }

    /**
     * Utility method used in editEffect()
     */
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Utility method editEffect()
     */
    private static boolean isBoolean(String str) {
        try {
            Boolean.parseBoolean(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
