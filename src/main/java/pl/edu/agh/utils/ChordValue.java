package pl.edu.agh.utils;

import java.util.List;

public class ChordValue implements Value {
    public final List<NoteValue> notes;
    public ChordValue(List<NoteValue> notes) { this.notes = notes; }
}
