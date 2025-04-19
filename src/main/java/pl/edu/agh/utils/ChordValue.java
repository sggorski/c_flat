package pl.edu.agh.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public BoolValue equals(Value value) {
        ChordValue other = (ChordValue) value;
        Set<Value> thisSet = new HashSet<>(this.notes);
        Set<Value> otherSet = new HashSet<>(other.notes);
        return new BoolValue(thisSet.equals(otherSet));
    }
}
