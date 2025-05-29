package pl.edu.agh.visitorActions;

import org.antlr.v4.runtime.tree.TerminalNode;
import pl.edu.agh.Melody;
import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.ValueError;
import pl.edu.agh.musicUtils.Note;
import pl.edu.agh.utils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chord {

    /**
     * Extracts a ChordValue from the given parser context.
     * Collects unique notes from NOTE_VAL tokens and note variables by ID.
     * Throws an error if fewer than two distinct notes are found.
     */
    public static ChordValue get(MusicParser.ChordContext ctx, Melody melody, Scope currentScope,
                            HashMap<String,VarInfo> globalScope, LineOrigin origin, int col){
        List<NoteValue> notes = new ArrayList<>();
        for (TerminalNode node : ctx.NOTE_VAL()) {
            Note note = Note.valueOf(node.getText().replace('#', 's').replace('-', 'm'));
            NoteValue newNote = new NoteValue(note);
            if (!notes.contains(newNote))
                notes.add(newNote);
        }
        for (TerminalNode node : ctx.ID()) {
            NoteValue varNote = (NoteValue) VisitorUtils.extractVariable(node, Type.NOTE, ctx.parent(),melody,currentScope,globalScope,origin,col).valueObj;
            if (!notes.contains(varNote))
                notes.add(varNote);
        }
        if (notes.size() < 2)
            throw new ValueError("Invalid operation with chords: same note repeated", origin, col);
        return new ChordValue(notes);
    }
}
