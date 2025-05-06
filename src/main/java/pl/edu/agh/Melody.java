package pl.edu.agh;

import org.antlr.v4.runtime.tree.TerminalNode;
import pl.edu.agh.errors.ValueError;
import pl.edu.agh.utils.*;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.*;

import static pl.edu.agh.utils.Instrument.DRUMS;

public class Melody {


    public Instrument instrument=Instrument.PIANO;

    public HashMap<Effect, Value> effects = new HashMap<>();
    public HashMap<Effect, Integer> effectControllers = new HashMap<>();
    public String name;
    public HashMap<String, VarInfo> memory = new HashMap<>();
    public HashMap<Integer, VarInfo> parameters = new HashMap<>();
    public List<MusicParser.StatementContext> body;
    public List<MusicParser.MainStatementContext> mainBody;
    public int scopeLevel = 0;
    public ArrayList<Scope> scopes = new ArrayList<>();
    public Scope previous_scope;

    Synthesizer synth;
    MidiChannel[] channels;


    public Melody()  {
        //start up
        try {
            this.synth = MidiSystem.getSynthesizer();
            this.synth.open();
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }

        this.channels = this.synth.getChannels();
        this.channels[0].programChange(0);

        this.effects.put(Effect.PACE, new IntValue(600));
        this.effects.put(Effect.VOLUME, new IntValue(100));
        this.effects.put(Effect.JAZZ, new BoolValue(false));
        this.effects.put(Effect.BLUES, new BoolValue(false));
        this.effects.put(Effect.SUSTAIN, new IntValue(0));
        this.effects.put(Effect.SOSTENUTO, new IntValue(0));
        this.effects.put(Effect.SOFT, new IntValue(0));
        this.effects.put(Effect.DISTORTION, new IntValue(0));
        this.effects.put(Effect.VIBRATO, new IntValue(0));
        this.effects.put(Effect.BALANCE, new IntValue(0));
        this.effects.put(Effect.RESONANCE, new IntValue(0));
        this.effects.put(Effect.REVERB, new IntValue(0));
        this.effects.put(Effect.TREMOLO, new IntValue(0));
        this.effects.put(Effect.CHORUS, new IntValue(0));
        this.effects.put(Effect.PHRASER, new IntValue(0));

        this.effectControllers.put(Effect.SUSTAIN, 64);
        this.effectControllers.put(Effect.SOSTENUTO, 66);
        this.effectControllers.put(Effect.SOFT, 67);
        this.effectControllers.put(Effect.DISTORTION, 93);
        this.effectControllers.put(Effect.VIBRATO, 1);
        this.effectControllers.put(Effect.BALANCE, 10);
        this.effectControllers.put(Effect.RESONANCE, 71);
        this.effectControllers.put(Effect.REVERB, 91);
        this.effectControllers.put(Effect.TREMOLO, 92);
        this.effectControllers.put(Effect.CHORUS, 93);
        this.effectControllers.put(Effect.PHRASER, 95);
    }

    public int getJazzNote(int note){
        Random random = new Random();
        int sign = random.nextInt(2);
        int howMuch = random.nextInt(5);
        if(sign==0) note+= howMuch;
        else note -=howMuch;
        return note;
    }

    public void playNote(MidiChannel channel, int note, int duration, int volume) throws InterruptedException {
        int adjustedDuration = (60000/((IntValue)this.effects.get(Effect.PACE)).value)*duration/100;
        if(((BoolValue)this.effects.get(Effect.JAZZ)).value) note=getJazzNote(note);
        channel.noteOn(note, volume);
        Thread.sleep(adjustedDuration);
        channel.noteOff(note);
    }

    public void playChord(MidiChannel channel, List<Integer> chord, int duration, int volume) throws InterruptedException {
        int adjustedDuration = (60000/((IntValue)this.effects.get(Effect.PACE)).value)*duration/100;
        for (int note : chord) {
            if(((BoolValue)this.effects.get(Effect.JAZZ)).value) note=getJazzNote(note);
            channel.noteOn(note, volume);
        }
        Thread.sleep(adjustedDuration);
        for (int note : chord) {
            channel.noteOff(note);
        }
    }

    public void editEffect(MusicParser.SettingsAssigmentContext ctx, Effect effect, MusicSuperVisitor msv) {
        if (effect == Effect.PACE || effect == Effect.VOLUME) {
            if (ctx.children.get(2) != null && isNumeric(String.valueOf(ctx.children.get(2))))
                this.effects.put(effect, new IntValue(Integer.parseInt(String.valueOf(ctx.children.get(2)))));
            else if (ctx.children.get(2) != null) {
                IntValue varInt = (IntValue) msv.extractVariable(ctx, (TerminalNode) ctx.children.get(2), Type.INT).valueObj;
                this.effects.put(effect, varInt);
            }

        } else if (effect == Effect.JAZZ || effect == Effect.BLUES) {
            if (ctx.children.get(2) != null && isBoolean(String.valueOf(ctx.children.get(2))))
                this.effects.put(effect, new BoolValue(Boolean.parseBoolean(String.valueOf(ctx.children.get(2)))));
            else if (ctx.children.get(2) != null) {
                BoolValue varBool = (BoolValue) msv.extractVariable(ctx, (TerminalNode) ctx.children.get(2), Type.BOOL).valueObj;
                    this.effects.put(effect, varBool);
            }
        } else {
            if (ctx.children.get(2) != null && isNumeric(String.valueOf(ctx.children.get(2)))) {
                this.effects.put(effect, new IntValue(Integer.parseInt(String.valueOf(ctx.children.get(2)))));
                if (this.instrument == DRUMS)
                    this.channels[9].controlChange(this.effectControllers.get(effect), ((IntValue)this.effects.get(effect)).value);
                else
                    this.channels[0].controlChange(this.effectControllers.get(effect), ((IntValue)this.effects.get(effect)).value);
            } else if (ctx.children.get(2) != null) {
                IntValue varInt = (IntValue) msv.extractVariable(ctx, (TerminalNode) ctx.children.get(2), Type.INT).valueObj;
                if (this.instrument == DRUMS)
                    this.channels[9].controlChange(this.effectControllers.get(effect), varInt.value);
                else
                    this.channels[0].controlChange(this.effectControllers.get(effect), varInt.value);
                }
            }
    }
    public void editEffectPlain(Effect effect, Value value){
        if (effect == Effect.PACE || effect == Effect.VOLUME){
            if(value instanceof IntValue){
                IntValue varInt = (IntValue) value;
                this.effects.put(effect, new IntValue(varInt.value));
            }
        }
        else if (effect == Effect.JAZZ || effect == Effect.BLUES){
            if(value instanceof BoolValue){
                BoolValue varBool = (BoolValue) value;
                this.effects.put(effect, new BoolValue(varBool.value));
            }
        }
        else{
            if(value instanceof IntValue){
                IntValue varInt = (IntValue) value;
                this.effects.put(effect, new IntValue(varInt.value));
                if (this.instrument == DRUMS)
                    this.channels[9].controlChange(this.effectControllers.get(effect), ((IntValue)this.effects.get(effect)).value);
                else
                    this.channels[0].controlChange(this.effectControllers.get(effect), ((IntValue)this.effects.get(effect)).value);
            }
        }
    }
    public boolean setInstrument(Instrument instrument){
        this.instrument = instrument;
        switch (instrument) {
            case PIANO:
                this.channels[0].programChange(0);
                break;
            case HARPSICHORD:
                this.channels[0].programChange(6);
                break;
            case XYLOPHONE:
                this.channels[0].programChange(13);
                break;
            case ORGAN:
                this.channels[0].programChange(16);
                break;
            case CHURCH_ORGAN:
                this.channels[0].programChange(19);
                break;
            case ACCORDION:
                this.channels[0].programChange(21);
                break;
            case HARMONICA:
                this.channels[0].programChange(22);
                break;
            case GUITAR:
                this.channels[0].programChange(25);
                break;
            case ELECTRIC_GUITAR:
                this.channels[0].programChange(27);
                break;
            case BASS:
                this.channels[0].programChange(33);
                break;
            case VIOLIN:
                this.channels[0].programChange(40);
                break;
            case VIOLA:
                this.channels[0].programChange(41);
                break;
            case CELLO:
                this.channels[0].programChange(42);
                break;
            case CONTRABASS:
                this.channels[0].programChange(43);
                break;
            case HARP:
                this.channels[0].programChange(46);
                break;
            case TRUMPET:
                this.channels[0].programChange(56);
                break;
            case TROMBONE:
                this.channels[0].programChange(57);
                break;
            case TUBA:
                this.channels[0].programChange(58);
                break;
            case SAXOPHONE:
                this.channels[0].programChange(65);
                break;
            case OBOE:
                this.channels[0].programChange(68);
                break;
            case ENGLISH_HORN:
                this.channels[0].programChange(69);
                break;
            case BASSOON:
                this.channels[0].programChange(70);
                break;
            case CLARINET:
                this.channels[0].programChange(71);
                break;
            case FLUTE:
                this.channels[0].programChange(73);
                break;
            case DRUMS:
                this.channels[9].programChange(35);
                break;
            default:
                return false;
        }
        return true;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static boolean isBoolean(String str) {
        try {
            Boolean.parseBoolean(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    @Override
    public String toString() {
        return "Melody{" +
                "parameters=" + parameters +
                ", memory=" + memory +
                ", name='" + name + '\'' +
                '}';
    }

    public static Melody deepCopyMelody(Melody original) {
        Melody copy = new Melody();
        copy.body = original.body;
        copy.parameters = new HashMap<>();
        for (Map.Entry<Integer, VarInfo> entry : original.parameters.entrySet()) {
            Type type = entry.getValue().type;
            switch (type) {
                case INT:
                    copy.parameters.put(entry.getKey(), new VarInfo(
                            entry.getValue().name,
                            entry.getValue().type,
                            entry.getValue().line,
                            entry.getValue().valueObj!=null ? new IntValue(((IntValue)entry.getValue().valueObj).value) : null));
                    break;
                case BOOL:
                    copy.parameters.put(entry.getKey(), new VarInfo(
                            entry.getValue().name,
                            entry.getValue().type,
                            entry.getValue().line,
                            entry.getValue().valueObj!=null ? new BoolValue(((BoolValue)entry.getValue().valueObj).value) : null));
                    break;
                case NOTE:
                    copy.parameters.put(entry.getKey(), new VarInfo(
                            entry.getValue().name,
                            entry.getValue().type,
                            entry.getValue().line,
                            entry.getValue().valueObj!=null ? new NoteValue(((NoteValue)entry.getValue().valueObj).note) : null));
                    break;
                case CHORD:
                    copy.parameters.put(entry.getKey(), new VarInfo(
                            entry.getValue().name,
                            entry.getValue().type,
                            entry.getValue().line,
                            entry.getValue().valueObj!=null ? new ChordValue(((ChordValue)entry.getValue().valueObj).notes) : null));
                    break;
            }
        }

        copy.memory = new HashMap<>();
        for (Map.Entry<String, VarInfo> entry : original.memory.entrySet()) {
            Type type = entry.getValue().type;
            switch (type) {
                case INT:
                    copy.memory.put(entry.getKey(), new VarInfo(
                            entry.getValue().name,
                            entry.getValue().type,
                            entry.getValue().line,
                            entry.getValue().valueObj!=null ? new IntValue(((IntValue)entry.getValue().valueObj).value) : null));
                    break;
                case BOOL:
                    copy.memory.put(entry.getKey(), new VarInfo(
                            entry.getValue().name,
                            entry.getValue().type,
                            entry.getValue().line,
                            entry.getValue().valueObj!=null ? new BoolValue(((BoolValue)entry.getValue().valueObj).value) : null));
                    break;
                case NOTE:
                    copy.memory.put(entry.getKey(), new VarInfo(
                            entry.getValue().name,
                            entry.getValue().type,
                            entry.getValue().line,
                            entry.getValue().valueObj!=null ? new NoteValue(((NoteValue)entry.getValue().valueObj).note) : null));
                    break;
                case CHORD:
                    copy.memory.put(entry.getKey(), new VarInfo(
                            entry.getValue().name,
                            entry.getValue().type,
                            entry.getValue().line,
                            entry.getValue().valueObj!=null ? new ChordValue(((ChordValue)entry.getValue().valueObj).notes) : null));
                    break;
            }
        }

        copy.name = original.name;
        return copy;
    }
    public void copyEffects(HashMap<Effect, Value> effects){
        this.effects = new HashMap<>();
        for (Map.Entry<Effect, Value> entry : effects.entrySet()) {
            this.editEffectPlain(entry.getKey(), entry.getValue());
        }
    }
}