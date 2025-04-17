package pl.edu.agh.utils;

import java.util.List;

public class ChordValue implements Value {
    public Type type = Type.CHORD;
    public  List<NoteValue> notes;
    public ChordValue(List<NoteValue> notes) { this.notes = notes; }
    public Type getType() { return type; }
    public void setValue(ChordValue value) { this.notes = value.notes; }

    @Override
    public String toString() {
        return "ChordValue{" +
                "type=" + type +
                ", notes=" + notes +
                '}';
    }
}
