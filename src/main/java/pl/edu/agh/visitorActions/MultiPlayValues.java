package pl.edu.agh.visitorActions;

import org.antlr.runtime.tree.ParseTree;
import pl.edu.agh.Melody;
import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.RuntimeError;
import pl.edu.agh.errors.ScopeError;
import pl.edu.agh.errors.ValueError;
import pl.edu.agh.musicUtils.Music;
import pl.edu.agh.utils.*;

import java.util.HashMap;

public class MultiPlayValues {

    /**
     * Retrieves the duration value from the MultiPlayValuesContext.
     * This method checks if an integer value is directly provided in the context.
     * If not, it attempts to resolve the duration from a variable using the provided scope information.
     * Throws runtime exceptions for invalid or undefined variable references.
     */
    public static int getDuration(MusicParser.MultiPlayValuesContext ctx, Melody melody, Scope currentScope,
                                  HashMap<String,VarInfo> globalScope, LineOrigin origin, int col){
        int duration = 0;
        int lastId = ctx.parentID().size() - 1;
        if (melody == null) throw new RuntimeException("Stack is empty!");
        if (ctx.INT_VAL() != null) {
            duration = Integer.parseInt(ctx.INT_VAL().getText());
        } else if (ctx.parentID(lastId) != null) {
            VarInfo var;
            String varName = ctx.parentID(lastId).ID().getText();
            var = VisitorUtils.findVar(varName, ctx.parentID(lastId).parent(),melody, currentScope, globalScope, origin, col);
            if (var == null)
                throw new ScopeError("Variable not defined: ", origin, col);
            if (var.type != Type.INT)
                throw new ValueError("Incorrect type of variable: " + varName + "Type " + var.type + "not int", origin,col);
            duration = ((IntValue) var.valueObj).value;
        }
        return duration;
    }


    /**
     * Plays a musical variable (Note or Chord) identified by its ID.
     * This method resolves the variable from the given context and scope,
     * then plays it using the specified duration. Supports only NOTE and CHORD types.
     * Throws an error if the variable type is unsupported.
     */
    public static void playVariable(MusicParser.ParentIDContext idContext,Melody melody, Scope currentScope,
                                    HashMap<String,VarInfo> globalScope,HashMap<String,Track> tracks, int duration, LineOrigin origin, int col){
        VarInfo varInfo;
        String varName = idContext.ID().getText();
        if(tracks.containsKey(varName))
            throw new RuntimeError("Variable  " + varName + " of type Track cannot by played here.", origin, col);
        varInfo = VisitorUtils.findVar(varName, idContext.parent(),melody,currentScope,globalScope,origin,col);
        if (varInfo.type == Type.NOTE) {
            NoteValue noteVal = (NoteValue) varInfo.valueObj;
            Music.playNote(noteVal.note, duration,melody,currentScope);
        } else if (varInfo.type == Type.CHORD) {
            ChordValue chordVal = (ChordValue) varInfo.valueObj;
            Music.playChord(chordVal.notes, duration,melody,currentScope);
        } else {
            throw new ValueError("Expecting Note or Chord value, got: " + varInfo, origin,col);
        }
    }



}
