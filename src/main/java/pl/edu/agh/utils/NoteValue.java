package pl.edu.agh.utils;

import pl.edu.agh.musicUtils.Note;

import java.util.Objects;

public class NoteValue implements Value {
    public Type type = Type.NOTE;
    public Note note; // np. C4, D#5
    public NoteValue(Note note) { this.note = note; }
    public Type getType() { return type; }
    public void setValue(Note value) { this.note = value; }

    @Override
    public String toString() {
        return "NoteValue{" +
                "type=" + type +
                ", note=" + note +
                '}';
    }
    @Override
    public BoolValue equals(Value value) {
        NoteValue other = (NoteValue) value;
        return new BoolValue(NoteMap.notes.get(this.note)==NoteMap.notes.get(other.note));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteValue noteValue = (NoteValue) o;
        return type == noteValue.type && NoteMap.notes.get(note) == NoteMap.notes.get(noteValue.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, NoteMap.notes.get(note));
    }
}
