package pl.edu.agh.visitorActions;

import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.ArithmeticOperationError;
import pl.edu.agh.musicUtils.Music;
import pl.edu.agh.musicUtils.Note;
import pl.edu.agh.musicUtils.NoteMap;
import pl.edu.agh.utils.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddSubOperatorExpr {

    /**
     * Evaluates addition or subtraction operations between various musical value types:
     * - INT + INT or INT - INT returns IntValue.
     * - NOTE ± INT returns a shifted NoteValue within valid range.
     * - CHORD + NOTE adds a note to the chord; CHORD - NOTE removes a note, with validation.
     * - CHORD + CHORD merges notes uniquely; CHORD - CHORD removes notes with validation.
     * Throws ArithmeticOperationError for invalid type combinations or invalid chord operations.
     */
    public  static Value evaluate(MusicParser.AddSubOperatorExprContext ctx,Value firstValue, Value secondValue, LineOrigin origin, int col){
        if (firstValue.getType() == Type.INT && secondValue.getType() == Type.INT) {
            int firstInt = ((IntValue) firstValue).value;
            int secondInt = ((IntValue) secondValue).value;
            int resultInt;
            if (ctx.addSubOp().SUB() != null)
                resultInt = firstInt - secondInt;
            else
                resultInt = firstInt + secondInt;
            return new IntValue(resultInt);
        } else if (firstValue.getType() == Type.NOTE && secondValue.getType() == Type.INT) {
            Note note = ((NoteValue) firstValue).note;
            int intVal = ((IntValue) secondValue).value;
            int noteIntVal = NoteMap.notes.get(note);

            if (ctx.addSubOp().SUB() != null) noteIntVal -= intVal;
            else noteIntVal += intVal;
            noteIntVal = Math.abs(noteIntVal) % 85;
            return new NoteValue(Music.findNote(noteIntVal));
        } else if (firstValue.getType() == Type.CHORD && secondValue.getType() == Type.NOTE) {
            NoteValue noteValue = (NoteValue) secondValue;
            ChordValue chordValue = (ChordValue) firstValue;
            ChordValue result;
            if (ctx.addSubOp().ADD() != null) {
                result = new ChordValue(chordValue.notes);
                if (!chordValue.notes.contains(noteValue)) result.notes.add(noteValue);
            } else {
                if (chordValue.notes.size() <= 2 && chordValue.notes.contains(noteValue))
                    throw new ArithmeticOperationError("Invalid operation with chords", origin, col);
                result = new ChordValue(chordValue.notes);
                result.notes.remove(noteValue);
            }
            return result;
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
                    throw new ArithmeticOperationError("Invalid operation with chords: less than 2 notes left in a chord",  origin, col);
                result = new ChordValue(listNotes);
            }
            return result;

        } else
            throw new ArithmeticOperationError("Invalid arguments for add/subtract operation",  origin, col);
    }
}
