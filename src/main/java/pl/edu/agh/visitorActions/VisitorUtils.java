package pl.edu.agh.visitorActions;

import org.antlr.v4.runtime.tree.TerminalNode;
import pl.edu.agh.Melody;
import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.ScopeError;
import pl.edu.agh.errors.UndefinedError;
import pl.edu.agh.errors.ValueError;
import pl.edu.agh.musicUtils.Effect;
import pl.edu.agh.utils.*;

import java.util.HashMap;
import java.util.List;

public class VisitorUtils {
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
     *
     * @param melody
     * @return
     */
    public static Scope getCurrScope(Melody melody,Scope currentScope) {
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
            throw new UndefinedError("Variable not defined: " + varName, origin, col);

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
                throw new UndefinedError("Variable not defined: " + varName, origin, col);
            } else if (parentContexts.size() == 1) {
                if (globalScope.containsKey(varName) && globalScope.get(varName) != null) {
                    return globalScope.get(varName);
                }
                throw new UndefinedError("Variable not defined: " + varName, origin, col);
            }else {
                throw new ScopeError("There is no higher scope!", origin, col);
            }
        } else {
            if(parentContexts != null && !parentContexts.isEmpty()) {
                throw new ScopeError("There is no higher scope!", origin, col);
            }
            if(globalScope.containsKey(varName)) {
                return globalScope.get(varName);
            }else throw new UndefinedError("Variable not defined: " + varName, origin, col);
        }
    }

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
        while (current != null) {
            if (!current.memory.containsKey(varName)) {
                current = current.parent;
            } else return current.memory.get(varName);
        }

        if (melody != null && melody.memory.containsKey(varName)) {
            return melody.memory.get(varName);
        } else if (globalScope.containsKey(varName)) {
            return globalScope.get(varName);
        }
        throw new UndefinedError("Variable not defined: " + varName, origin, col);

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

}
