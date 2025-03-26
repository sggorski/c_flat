package pl.edu.agh;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.Synthesizer;
import java.util.HashMap;
public class MainMelody {
    public int sustain = 0;
    public int volume = 100;
    public int pace = 100;
    public int distortion = 0;
    public boolean jazz = false;
    public boolean blues = false;
    public Key key;
    public Instrument instrument;

    //hashmapy dla nut i kluczy
    public HashMap<Note,Integer> notes;
    public HashMap<Key,Integer> keys;

    Synthesizer synth;
    MidiChannel[] channels;


    public MainMelody(){}

    public  void playNote(MidiChannel channel, int note, int duration, int volume) throws InterruptedException {
        channel.noteOn(note, volume);
        Thread.sleep(duration);
        channel.noteOff(note);
    }

    public  void playChord(MidiChannel channel, int[] chord, int duration, int volume) throws InterruptedException {
        for (int note : chord) {
            channel.noteOn(note, volume);
        }
        Thread.sleep(duration);
        for (int note : chord) {
            channel.noteOff(note);
        }
    }
}
