package pl.edu.agh;

import pl.edu.agh.utils.*;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.HashMap;
import java.util.List;
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

    // hashmapy dla nut i kluczy
    public HashMap<Note,Integer> notes = new HashMap<>();
    public HashMap<Key,Integer> keys = new HashMap<>();
    public HashMap<String, VarInfo> memory = new HashMap<>();


    Synthesizer synth;
    MidiChannel[] channels;


    public MainMelody() throws MidiUnavailableException {
        //start up
        this.synth = MidiSystem.getSynthesizer();
        this.synth.open();
        this.channels = this.synth.getChannels();
        this.channels[0].programChange(0);
        //variable registration, just for debugging
        this.memory.put("zmienna1",new VarInfo("zmienna1", Type.NOTE, 2,new NoteValue(null)));
        this.memory.put("zmienna2",new VarInfo("zmienna2", Type.CHORD, 2,new ChordValue(null)));
        this.memory.put("zmienna3",new VarInfo("zmienna3", Type.INT, 2,new IntValue(0)));
        this.memory.put("zmienna4",new VarInfo("zmienna4", Type.BOOL, 2,new BoolValue(false)));
        this.notes.put(Note.Cbm2, 0);
        this.notes.put(Note.Cm2, 0);
        this.notes.put(Note.Csm2, 1);
        this.notes.put(Note.Dbm2, 1);
        this.notes.put(Note.Dm2, 2);
        this.notes.put(Note.Dsm2, 3);
        this.notes.put(Note.Ebm2, 3);
        this.notes.put(Note.Em2, 4);
        this.notes.put(Note.Fbm2, 4);
        this.notes.put(Note.Esm2, 5);
        this.notes.put(Note.Fm2, 5);
        this.notes.put(Note.Fsm2, 6);
        this.notes.put(Note.Gbm2, 6);
        this.notes.put(Note.Gm2, 7);
        this.notes.put(Note.Gsm2, 8);
        this.notes.put(Note.Abm2, 8);
        this.notes.put(Note.Am2, 9);
        this.notes.put(Note.Bbm2, 9);
        this.notes.put(Note.Asm2, 10);
        this.notes.put(Note.Bm2, 10);
        this.notes.put(Note.Hbm2, 10);
        this.notes.put(Note.Bsm2, 11);
        this.notes.put(Note.Hm2, 11);
        this.notes.put(Note.Hsm2, 12);

        this.notes.put(Note.Cbm1, 11);
        this.notes.put(Note.Cm1, 12);
        this.notes.put(Note.Csm1, 13);
        this.notes.put(Note.Dbm1, 13);
        this.notes.put(Note.Dm1, 14);
        this.notes.put(Note.Dsm1, 15);
        this.notes.put(Note.Ebm1, 15);
        this.notes.put(Note.Em1, 16);
        this.notes.put(Note.Fbm1, 16);
        this.notes.put(Note.Esm1, 17);
        this.notes.put(Note.Fm1, 17);
        this.notes.put(Note.Fsm1, 18);
        this.notes.put(Note.Gbm1, 18);
        this.notes.put(Note.Gm1, 19);
        this.notes.put(Note.Gsm1, 20);
        this.notes.put(Note.Abm1, 20);
        this.notes.put(Note.Am1, 21);
        this.notes.put(Note.Bbm1, 21);
        this.notes.put(Note.Asm1, 22);
        this.notes.put(Note.Bm1, 22);
        this.notes.put(Note.Hbm1, 22);
        this.notes.put(Note.Bsm1, 23);
        this.notes.put(Note.Hm1, 23);
        this.notes.put(Note.Hsm1, 24);

        this.notes.put(Note.Cb0, 23);
        this.notes.put(Note.C0, 24);
        this.notes.put(Note.Cs0, 25);
        this.notes.put(Note.Db0, 25);
        this.notes.put(Note.D0, 26);
        this.notes.put(Note.Ds0, 27);
        this.notes.put(Note.Eb0, 27);
        this.notes.put(Note.E0, 28);
        this.notes.put(Note.Fb0, 28);
        this.notes.put(Note.Es0, 29);
        this.notes.put(Note.F0, 29);
        this.notes.put(Note.Fs0, 30);
        this.notes.put(Note.Gb0, 30);
        this.notes.put(Note.G0, 31);
        this.notes.put(Note.Gs0, 32);
        this.notes.put(Note.Ab0, 32);
        this.notes.put(Note.A0, 33);
        this.notes.put(Note.Bb0, 33);
        this.notes.put(Note.As0, 34);
        this.notes.put(Note.B0, 34);
        this.notes.put(Note.Hb0, 34);
        this.notes.put(Note.Bs0, 35);
        this.notes.put(Note.H0, 35);
        this.notes.put(Note.Hs0, 36);

        this.notes.put(Note.Cb1, 35);
        this.notes.put(Note.C1, 36);
        this.notes.put(Note.Cs1, 37);
        this.notes.put(Note.Db1, 37);
        this.notes.put(Note.D1, 38);
        this.notes.put(Note.Ds1, 39);
        this.notes.put(Note.Eb1, 39);
        this.notes.put(Note.E1, 40);
        this.notes.put(Note.Fb1, 40);
        this.notes.put(Note.Es1, 41);
        this.notes.put(Note.F1, 41);
        this.notes.put(Note.Fs1, 42);
        this.notes.put(Note.Gb1, 42);
        this.notes.put(Note.G1, 43);
        this.notes.put(Note.Gs1, 44);
        this.notes.put(Note.Ab1, 44);
        this.notes.put(Note.A1, 45);
        this.notes.put(Note.Bb1, 45);
        this.notes.put(Note.As1, 46);
        this.notes.put(Note.B1, 46);
        this.notes.put(Note.Hb1, 46);
        this.notes.put(Note.Bs1, 47);
        this.notes.put(Note.H1, 47);
        this.notes.put(Note.Hs1, 48);

        this.notes.put(Note.Cb2, 47);
        this.notes.put(Note.C2, 48);
        this.notes.put(Note.Cs2, 49);
        this.notes.put(Note.Db2, 49);
        this.notes.put(Note.D2, 50);
        this.notes.put(Note.Ds2, 51);
        this.notes.put(Note.Eb2, 51);
        this.notes.put(Note.E2, 52);
        this.notes.put(Note.Fb2, 52);
        this.notes.put(Note.Es2, 53);
        this.notes.put(Note.F2, 53);
        this.notes.put(Note.Fs2, 54);
        this.notes.put(Note.Gb2, 54);
        this.notes.put(Note.G2, 55);
        this.notes.put(Note.Gs2, 56);
        this.notes.put(Note.Ab2, 56);
        this.notes.put(Note.A2, 57);
        this.notes.put(Note.Bb2, 57);
        this.notes.put(Note.As2, 58);
        this.notes.put(Note.B2, 58);
        this.notes.put(Note.Hb2, 58);
        this.notes.put(Note.Bs2, 59);
        this.notes.put(Note.H2, 59);
        this.notes.put(Note.Hs2, 60);

        this.notes.put(Note.Cb3, 59);
        this.notes.put(Note.C3, 60);
        this.notes.put(Note.Cs3, 61);
        this.notes.put(Note.Db3, 61);
        this.notes.put(Note.D3, 62);
        this.notes.put(Note.Ds3, 63);
        this.notes.put(Note.Eb3, 63);
        this.notes.put(Note.E3, 64);
        this.notes.put(Note.Fb3, 64);
        this.notes.put(Note.Es3, 65);
        this.notes.put(Note.F3, 65);
        this.notes.put(Note.Fs3, 66);
        this.notes.put(Note.Gb3, 66);
        this.notes.put(Note.G3, 67);
        this.notes.put(Note.Gs3, 68);
        this.notes.put(Note.Ab3, 68);
        this.notes.put(Note.A3, 69);
        this.notes.put(Note.Bb3, 69);
        this.notes.put(Note.As3, 70);
        this.notes.put(Note.B3, 70);
        this.notes.put(Note.Hb3, 70);
        this.notes.put(Note.Bs3, 71);
        this.notes.put(Note.H3, 71);
        this.notes.put(Note.Hs3, 72);

        this.notes.put(Note.Cb4, 71);
        this.notes.put(Note.C4, 72);
        this.notes.put(Note.Cs4, 73);
        this.notes.put(Note.Db4, 73);
        this.notes.put(Note.D4, 74);
        this.notes.put(Note.Ds4, 75);
        this.notes.put(Note.Eb4, 75);
        this.notes.put(Note.E4, 76);
        this.notes.put(Note.Fb4, 76);
        this.notes.put(Note.Es4, 77);
        this.notes.put(Note.F4, 77);
        this.notes.put(Note.Fs4, 78);
        this.notes.put(Note.Gb4, 78);
        this.notes.put(Note.G4, 79);
        this.notes.put(Note.Gs4, 80);
        this.notes.put(Note.Ab4, 80);
        this.notes.put(Note.A4, 81);
        this.notes.put(Note.Bb4, 81);
        this.notes.put(Note.As4, 82);
        this.notes.put(Note.B4, 82);
        this.notes.put(Note.Hb4, 82);
        this.notes.put(Note.Bs4, 83);
        this.notes.put(Note.H4, 83);
        this.notes.put(Note.Hs4, 84);


        this.keys.put(Key.G, -6827);
        this.keys.put(Key.Ab, -5461);
        this.keys.put(Key.A, -4096);
        this.keys.put(Key.B, -2731);
        this.keys.put(Key.H, -1365);
        this.keys.put(Key.C, 0);
        this.keys.put(Key.Cs, 1365);
        this.keys.put(Key.D, 2731);
        this.keys.put(Key.Eb, 4096);
        this.keys.put(Key.E, 5461);
        this.keys.put(Key.F, 6827);
        this.keys.put(Key.Fs, 8191);

        this.keys.put(Key.Em, -6827);
        this.keys.put(Key.Fm, -5461);
        this.keys.put(Key.Fsm, -4096);
        this.keys.put(Key.Gm, -2731);
        this.keys.put(Key.Gsm, -1365);
        this.keys.put(Key.Am, 0);
        this.keys.put(Key.Bm, 1365);
        this.keys.put(Key.Hm, 2731);
        this.keys.put(Key.Cm, 4096);
        this.keys.put(Key.Csm, 5461);
        this.keys.put(Key.Dm, 6827);
        this.keys.put(Key.Ebm, 8191);
    }

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

    public  void playChord(MidiChannel channel, List<Integer> chord, int duration, int volume) throws InterruptedException {
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
