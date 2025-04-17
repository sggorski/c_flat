package pl.edu.agh.utils;

public class NoteValue implements Value {
    public Type type = Type.NOTE;
    public  Note note; // np. C4, D#5
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
}
