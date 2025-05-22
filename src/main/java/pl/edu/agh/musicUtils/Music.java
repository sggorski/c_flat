package pl.edu.agh.musicUtils;

import pl.edu.agh.Melody;
import pl.edu.agh.utils.*;

import javax.sound.midi.MidiChannel;
import java.util.*;

import static pl.edu.agh.musicUtils.Instrument.DRUMS;

public class Music {

    /**
     * Hashmap with integer values for changing MIDI channel settings for various effects
     */
    public static HashMap<Effect,Integer> effectControllers;

    /**
     * Converts a note string (e.g. "C#", "A2", etc.) into a NoteValue object.
     * Returns null if the input is invalid.
     */
    public static NoteValue parseNote(String noteText) {
        try {
            Note note = Note.valueOf(noteText.replace('#', 's').replace('-', 'm'));
            return new NoteValue(note);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * Finds the Note enum value corresponding to a given MIDI integer value.
     * Throws RuntimeException if the note is not found.
     */
    public static Note findNote(int value) {
        Note newNote = NoteMap.notes.entrySet().stream()
                .filter(pair -> pair.getValue().equals(value))
                .findFirst()
                .map(Map.Entry::getKey).orElse(null);
        if (newNote == null) throw new RuntimeException("Note not found");
        return newNote;
    }

    /**
     * Plays a chord consisting of multiple notes for a specified duration.
     * Uses either the current scope or the default melody settings for playback.
     */
    public static void playChord(List<NoteValue> notes, Integer duration, Melody melody, Scope currentScope) {
        List<Integer> notesInt = new ArrayList<>();
        for (NoteValue note : notes) {
            notesInt.add(NoteMap.notes.get(note.note));
        }
        try {
            if (currentScope != null) {
                if (currentScope.instrument == DRUMS) {
                    playChordMidi(currentScope.channels[9], notesInt, duration, ((IntValue) currentScope.effects.get(Effect.VOLUME)).value,currentScope.effects);
                } else {
                    playChordMidi(currentScope.channels[0], notesInt, duration, ((IntValue) currentScope.effects.get(Effect.VOLUME)).value,currentScope.effects);
                }
            } else {
                if (melody.instrument == DRUMS) {
                    playChordMidi(melody.channels[9], notesInt, duration, ((IntValue) melody.effects.get(Effect.VOLUME)).value,melody.effects);
                } else {
                    playChordMidi(melody.channels[0], notesInt, duration, ((IntValue) melody.effects.get(Effect.VOLUME)).value,melody.effects);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Plays a single note for a specified duration.
     * Uses either the current scope or the default melody settings for playback.
     */
    public static void playNote(Note note, Integer duration, Melody melody, Scope currentScope) {
        Integer noteInt = NoteMap.notes.get(note);
        try {
            if (currentScope != null) {
                if (currentScope.instrument == DRUMS) {
                    playNoteMidi(currentScope.channels[9], noteInt, duration, ((IntValue) currentScope.effects.get(Effect.VOLUME)).value,currentScope.effects);
                } else {
                    playNoteMidi(currentScope.channels[0], noteInt, duration, ((IntValue) currentScope.effects.get(Effect.VOLUME)).value,currentScope.effects);
                }
            } else {
                if (melody.instrument == DRUMS) {
                    playNoteMidi(melody.channels[9], noteInt, duration, ((IntValue) melody.effects.get(Effect.VOLUME)).value, melody.effects);
                } else {
                    playNoteMidi(melody.channels[0], noteInt, duration, ((IntValue) melody.effects.get(Effect.VOLUME)).value,melody.effects);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Applies a random pitch variation to a note to simulate a "jazz" effect.
     * Shifts the note up or down by up to 4 semitones.
     */
    public static int getJazzNote(int note) {
        Random random = new Random();
        int sign = random.nextInt(2);
        int howMuch = random.nextInt(5);
        if (sign == 0) note += howMuch;
        else note -= howMuch;
        return note;
    }

    /**
     * Plays a single MIDI note on the given channel, applying duration and jazz effect if enabled.
     */
    public static void playNoteMidi(MidiChannel channel, int note, int duration, int volume, HashMap<Effect,Value> effects) throws InterruptedException {
        int adjustedDuration = (60000 / ((IntValue) effects.get(Effect.PACE)).value) * duration / 100;
        if (((BoolValue) effects.get(Effect.JAZZ)).value) note = getJazzNote(note);
        channel.noteOn(note, volume);
        Thread.sleep(adjustedDuration);
        channel.noteOff(note);
    }

    /**
     * Plays a chord (multiple MIDI notes) on the given channel, applying duration and jazz effect to each note if enabled.
     */
    public static void playChordMidi(MidiChannel channel, List<Integer> chord, int duration, int volume, HashMap<Effect,Value> effects) throws InterruptedException {
        int adjustedDuration = (60000 / ((IntValue) effects.get(Effect.PACE)).value) * duration / 100;
        for (int note : chord) {
            if (((BoolValue) effects.get(Effect.JAZZ)).value) note = getJazzNote(note);
            channel.noteOn(note, volume);
        }
        Thread.sleep(adjustedDuration);
        for (int note : chord) {
            channel.noteOff(note);
        }
    }

    /**
     * Function sets up default value for all the effects & prepares controller values
     */
    public static void setUpEffects(HashMap<Effect, Value> effects){
        effects.put(Effect.PACE, new IntValue(600));
        effects.put(Effect.VOLUME, new IntValue(100));
        effects.put(Effect.JAZZ, new BoolValue(false));
        effects.put(Effect.BLUES, new BoolValue(false));
        effects.put(Effect.SUSTAIN, new IntValue(0));
        effects.put(Effect.SOSTENUTO, new IntValue(0));
        effects.put(Effect.SOFT, new IntValue(0));
        effects.put(Effect.DISTORTION, new IntValue(0));
        effects.put(Effect.VIBRATO, new IntValue(0));
        effects.put(Effect.BALANCE, new IntValue(0));
        effects.put(Effect.RESONANCE, new IntValue(0));
        effects.put(Effect.REVERB, new IntValue(0));
        effects.put(Effect.TREMOLO, new IntValue(0));
        effects.put(Effect.CHORUS, new IntValue(0));
        effects.put(Effect.PHRASER, new IntValue(0));

        effectControllers = new HashMap<>();
        effectControllers.put(Effect.SUSTAIN, 64);
        effectControllers.put(Effect.SOSTENUTO, 66);
        effectControllers.put(Effect.SOFT, 67);
        effectControllers.put(Effect.DISTORTION, 93);
        effectControllers.put(Effect.VIBRATO, 1);
        effectControllers.put(Effect.BALANCE, 10);
        effectControllers.put(Effect.RESONANCE, 71);
        effectControllers.put(Effect.REVERB, 91);
        effectControllers.put(Effect.TREMOLO, 92);
        effectControllers.put(Effect.CHORUS, 93);
        effectControllers.put(Effect.PHRASER, 95);
    }

    /**
     * Function sets up proper program for channels based on a instrument
     */
    public static boolean setChannelForInstrument(Instrument instrument, MidiChannel[] channels) {
        switch (instrument) {
            case PIANO:
                channels[0].programChange(0);
                break;
            case HARPSICHORD:
                channels[0].programChange(6);
                break;
            case XYLOPHONE:
                channels[0].programChange(13);
                break;
            case ORGAN:
                channels[0].programChange(16);
                break;
            case CHURCH_ORGAN:
                channels[0].programChange(19);
                break;
            case ACCORDION:
                channels[0].programChange(21);
                break;
            case HARMONICA:
                channels[0].programChange(22);
                break;
            case GUITAR:
                channels[0].programChange(25);
                break;
            case ELECTRIC_GUITAR:
                channels[0].programChange(27);
                break;
            case BASS:
                channels[0].programChange(33);
                break;
            case VIOLIN:
                channels[0].programChange(40);
                break;
            case VIOLA:
                channels[0].programChange(41);
                break;
            case CELLO:
                channels[0].programChange(42);
                break;
            case CONTRABASS:
                channels[0].programChange(43);
                break;
            case HARP:
                channels[0].programChange(46);
                break;
            case TRUMPET:
                channels[0].programChange(56);
                break;
            case TROMBONE:
                channels[0].programChange(57);
                break;
            case TUBA:
                channels[0].programChange(58);
                break;
            case SAXOPHONE:
                channels[0].programChange(65);
                break;
            case OBOE:
                channels[0].programChange(68);
                break;
            case ENGLISH_HORN:
                channels[0].programChange(69);
                break;
            case BASSOON:
                channels[0].programChange(70);
                break;
            case CLARINET:
                channels[0].programChange(71);
                break;
            case FLUTE:
                channels[0].programChange(73);
                break;
            case DRUMS:
                channels[9].programChange(35);
                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * Function allows to change effects and appropriate midi channel settings
     */
    public static void editEffectMidi(Effect effect, Value value, HashMap<Effect,Value> effects, Instrument instrument, MidiChannel[] channels) {
        if (effect == Effect.PACE || effect == Effect.VOLUME) {
            if (value instanceof IntValue) {
                IntValue varInt = (IntValue) value;
                effects.put(effect, new IntValue(varInt.value));
            }
        } else if (effect == Effect.JAZZ || effect == Effect.BLUES) {
            if (value instanceof BoolValue) {
                BoolValue varBool = (BoolValue) value;
                effects.put(effect, new BoolValue(varBool.value));
            }
        } else {
            if (value instanceof IntValue) {
                IntValue varInt = (IntValue) value;
                effects.put(effect, new IntValue(varInt.value));
                if (instrument == DRUMS)
                    channels[9].controlChange(Music.effectControllers.get(effect), ((IntValue) effects.get(effect)).value);
                else
                    channels[0].controlChange(Music.effectControllers.get(effect), ((IntValue) effects.get(effect)).value);
            }
        }
    }
}
