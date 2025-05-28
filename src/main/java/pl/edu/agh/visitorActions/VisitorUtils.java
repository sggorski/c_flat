package pl.edu.agh.visitorActions;

import pl.edu.agh.utils.*;

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
}
