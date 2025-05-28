package pl.edu.agh.visitorActions;

import pl.edu.agh.Melody;
import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.ScopeError;
import pl.edu.agh.errors.SyntaxError;
import pl.edu.agh.errors.UndefinedError;
import pl.edu.agh.musicUtils.Music;
import pl.edu.agh.utils.*;

import java.util.HashMap;

public class PlayIDVariants {

    /**
     * Plays a note, chord, or track based on the given context.
     * If the context refers to an ID variant (note or chord), it retrieves the variable,
     * determines the duration (either literal or from another variable),
     * and plays the note or chord accordingly.
     * If the context refers to a track, it checks that it is executed within the "main" melody,
     * verifies the track exists, and plays it.
     * Throws appropriate exceptions for undefined variables, scope errors, or incorrect usage.
     */
    public static void play(MusicParser.PlayIDVariantsContext ctx, Melody melody, Scope currentScope,
                            HashMap<String,VarInfo> globalScope, HashMap<String,Track> tracks, LineOrigin origin, int col){
        //playing ID variants
        if (ctx.INT_VAL() != null || ctx.parentID(1) != null) {
            VarInfo varInfo;
            String varName = ctx.parentID(0).ID().getText();
            varInfo = VisitorUtils.findVar(varName, ctx.parentID(0).parent(), melody, currentScope, globalScope, origin,col);
            if (varInfo == null)
                throw new ScopeError("Variable not defined: " + varName, origin,col);
            int duration = 0;
            if (ctx.INT_VAL() != null) duration = Integer.parseInt(ctx.INT_VAL().getText());
            else if (ctx.parentID(1) != null) {
                IntValue varInt = (IntValue) VisitorUtils.extractVariable(ctx.parentID(1).ID(), Type.INT, ctx.parentID(1).parent(),melody,currentScope,globalScope, origin,col).valueObj;
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
                throw new SyntaxError("Track cannot be played outside of a main melody",  origin,col);
            String trackName = ctx.parentID(0).ID().getText();
            if (!tracks.containsKey(trackName)) {
                throw new UndefinedError("Undefined track variable: " + " " + trackName,  origin,col);
            }
            Track track = tracks.get(trackName);
            try {
                track.play();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
