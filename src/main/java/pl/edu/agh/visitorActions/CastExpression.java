package pl.edu.agh.visitorActions;

import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.CastError;
import pl.edu.agh.errors.SyntaxError;
import pl.edu.agh.musicUtils.Music;
import pl.edu.agh.musicUtils.NoteMap;
import pl.edu.agh.utils.*;

import static pl.edu.agh.utils.Type.*;

public class CastExpression {

    public static Value cast(Value value, Type type, LineOrigin origin, int col){
        Type valType = value.getType();
        if(valType == type) return VisitorUtils.copyValue(value);
        if(valType == INT && type == NOTE){
            IntValue intVal = (IntValue)value;
            if(intVal.value<0)
                throw new CastError("Negative INT cannot be casted to NOTE", origin, col);
            return new NoteValue(Music.findNote(intVal.value));
        }
        else if(valType == NOTE && type == INT){
            NoteValue noteVal = (NoteValue)value;
            return new IntValue(NoteMap.notes.get(noteVal.note));
        }
        else if(valType == BOOL && type == INT){
            BoolValue boolVal = (BoolValue) value;
            if(boolVal.value) return new IntValue(1);
            else return new IntValue(0);
        }
        else if(valType == INT && type == BOOL){
            IntValue intVal = (IntValue) value;
            if(intVal.value != 0 ) return new BoolValue(true);
            else return new BoolValue(false);
        }
        else
            throw new CastError("Cannot cast " + valType + " to " + type, origin, col);
    }
}
