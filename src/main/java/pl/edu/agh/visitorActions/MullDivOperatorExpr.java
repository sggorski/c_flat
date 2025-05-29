package pl.edu.agh.visitorActions;

import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.ArithmeticOperationError;
import pl.edu.agh.musicUtils.Music;
import pl.edu.agh.musicUtils.Note;
import pl.edu.agh.musicUtils.NoteMap;
import pl.edu.agh.utils.*;

public class MullDivOperatorExpr {

    /**
     * Evaluates multiplication, division, or modulus operations between two values.
     * Supports operations on integers and notes with integer multipliers/divisors.
     */
    public static Value evaluate(MusicParser.MullDivOperatorExprContext ctx, Value firstValue, Value secondValue, LineOrigin origin, int col){
        if (firstValue.getType() == Type.INT && secondValue.getType() == Type.INT) {
            int firstInt = ((IntValue) firstValue).value;
            int secondInt = ((IntValue) secondValue).value;
            int resultInt;
            if (ctx.mullDivOp().MUL() != null) resultInt = firstInt * secondInt;
            else if (ctx.mullDivOp().PER() != null) resultInt = firstInt % secondInt;
            else if (secondInt != 0) resultInt = firstInt / secondInt;
            else throw new ArithmeticOperationError("Division by zero!", origin, col);
            return new IntValue(resultInt);
        }
        if (firstValue.getType() == Type.NOTE && secondValue.getType() == Type.INT) {
            Note note = ((NoteValue) firstValue).note;
            int intVal = ((IntValue) secondValue).value;
            int noteIntVal = NoteMap.notes.get(note);

            if (noteIntVal < 1)
                throw new ArithmeticOperationError("Invalid operation",origin, col);
            if (ctx.mullDivOp().MUL() != null)
                noteIntVal += (intVal - 1) * 12;
            else if (ctx.mullDivOp().DIV() != null) noteIntVal -= (intVal - 1) * 12;
            else
                throw new ArithmeticOperationError("Invalid operation. % cannot be used with notes", origin, col);
            noteIntVal = Math.abs(noteIntVal) % 85;
            return new NoteValue(Music.findNote(noteIntVal));
        } else
            throw new ArithmeticOperationError("Invalid arguments for mull/div operation", origin, col);
    }
}
