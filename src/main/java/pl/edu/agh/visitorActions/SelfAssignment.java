package pl.edu.agh.visitorActions;

import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.ArithmeticOperationError;
import pl.edu.agh.musicUtils.Music;
import pl.edu.agh.musicUtils.NoteMap;
import pl.edu.agh.utils.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelfAssignment {

    /**
     * Performs a self-assignment operation (e.g., +=, -=, *=, /=) on a variable.
     * Supports operations on INT, NOTE, and CHORD types with appropriate logic and error handling.
     */
    public static Value assign(MusicParser.SelfAssignmentContext ctx, VarInfo varInfo, Value exprValue, LineOrigin origin, int col){
        if (varInfo.type == Type.INT && exprValue.getType() == Type.INT) {
            IntValue intValue = (IntValue) exprValue;
            IntValue intVar = (IntValue) varInfo.valueObj;
            if (ctx.assOp().SUMIS() != null) intVar.value += intValue.value;
            else if (ctx.assOp().SUBIS() != null) intVar.value -= intValue.value;
            else if (ctx.assOp().MULIS() != null) intVar.value *= intValue.value;
            else if (ctx.assOp().DIVIS() != null && intValue.value != 0) intVar.value /= intValue.value;
            else throw new ArithmeticOperationError("Division by zero", origin,col);
            return  new IntValue(intVar.value);
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
                throw new ArithmeticOperationError("Invalid operation with notes", origin,col);
            newNoteValue = Math.abs(newNoteValue) % 85;
            noteValue.note = Music.findNote(newNoteValue);
            return  new NoteValue(noteValue.note);
        } else if (varInfo.type == Type.CHORD && exprValue.getType() == Type.NOTE) {
            NoteValue noteValue = (NoteValue) exprValue;
            ChordValue chordValue = (ChordValue) varInfo.valueObj;
            if (ctx.assOp().SUMIS() != null) {
                if (!chordValue.notes.contains(noteValue)) chordValue.notes.add(noteValue);
            } else if (ctx.assOp().SUBIS() != null) {
                if (chordValue.notes.size() <= 2)
                    throw new ArithmeticOperationError("Invalid operation with chords", origin,col);
                chordValue.notes.remove(noteValue);
            } else
                throw new ArithmeticOperationError("Invalid operation with chords",origin,col);
            return new ChordValue(chordValue.notes);
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
                    throw new ArithmeticOperationError("Invalid operation with chords: less than 2 notes left in a chord", origin, col);
                chordModified.notes = listNotes;
            }
            return  new ChordValue(chordModified.notes);
        } else throw new ArithmeticOperationError("Invalid operation", origin,col);
    }
}
