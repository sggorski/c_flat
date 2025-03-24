package pl.edu.agh;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.Synthesizer;

public class MainMelody {
    public int sustain = 0;
    public int volume = 100;
    public boolean jazz = false;
    public boolean blues = false;
    public int key = 0;
    Synthesizer synth;
    MidiChannel[] channels;


    public MainMelody(){}
}
