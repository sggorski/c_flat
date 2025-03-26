package pl.edu.agh;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.Synthesizer;
import java.util.HashMap;
import java.util.Random;

public class MainMelody {
    public int sustain = 0;
    public int volume = 100;
    public int pace = 600; //default
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

    public int getJazzNote(int note){
        Random random = new Random();
        int sign = random.nextInt(2);
        int howMuch = random.nextInt(5);
        if(sign==0) note+= howMuch;
        else note -=howMuch;
        return note;
    }
    public  void playNote(MidiChannel channel, int note, int duration, int volume) throws InterruptedException {
        int adjustedDuration = (60000/this.pace)*duration/100;
        if(this.jazz) note=getJazzNote(note);
        channel.noteOn(note, volume);
        Thread.sleep(adjustedDuration);
        channel.noteOff(note);
    }

    public  void playChord(MidiChannel channel, int[] chord, int duration, int volume) throws InterruptedException {
        int adjustedDuration = (60000/this.pace)*duration/100;
        for (int note : chord) {
            if(this.jazz) note=getJazzNote(note);
            channel.noteOn(note, volume);
        }
        Thread.sleep(adjustedDuration);
        for (int note : chord) {
            channel.noteOff(note);
        }
    }
}
