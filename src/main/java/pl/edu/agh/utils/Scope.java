package pl.edu.agh.utils;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import pl.edu.agh.Melody;
import pl.edu.agh.MusicParser;
import pl.edu.agh.MusicSuperVisitor;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.*;

import static pl.edu.agh.utils.Instrument.DRUMS;

public class Scope {


    public Instrument instrument = Instrument.PIANO;

    public HashMap<Effect, Value> effects = new HashMap<>();
    public HashMap<Effect, Integer> effectControllers = new HashMap<>();
    public HashMap<String, VarInfo> memory = new HashMap<>();
    public ScopeType scopeType;
    public ArrayList<Scope> scopes = new ArrayList<>();
    public ArrayList<Scope> scopesForCopy = new ArrayList<>();
    public Scope parent = null;
    public Melody melodyParent = null;
    public boolean toBreak = false;
    public String forInit = null;

    Synthesizer synth;
    public MidiChannel[] channels;


    public Scope() {
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

        memory = new HashMap<>();

    }

    public int getJazzNote(int note) {
        Random random = new Random();
        int sign = random.nextInt(2);
        int howMuch = random.nextInt(5);
        if (sign == 0) note += howMuch;
        else note -= howMuch;
        return note;
    }

    public void playNote(MidiChannel channel, int note, int duration, int volume) throws InterruptedException {
        int adjustedDuration = (60000 / ((IntValue) this.effects.get(Effect.PACE)).value) * duration / 100;
        if (((BoolValue) this.effects.get(Effect.JAZZ)).value) note = getJazzNote(note);
        channel.noteOn(note, volume);
        Thread.sleep(adjustedDuration);
        channel.noteOff(note);
    }

    public void playChord(MidiChannel channel, List<Integer> chord, int duration, int volume) throws InterruptedException {
        int adjustedDuration = (60000 / ((IntValue) this.effects.get(Effect.PACE)).value) * duration / 100;
        for (int note : chord) {
            if (((BoolValue) this.effects.get(Effect.JAZZ)).value) note = getJazzNote(note);
            channel.noteOn(note, volume);
        }
        Thread.sleep(adjustedDuration);
        for (int note : chord) {
            channel.noteOff(note);
        }
    }

    public void editEffect(MusicParser.SettingsAssigmentContext ctx, Effect effect, MusicSuperVisitor msv, List<MusicParser.ParentContext> parents) {
        ParseTree lastChild = ctx.children.get(ctx.children.size() - 1);
        if (effect == Effect.PACE || effect == Effect.VOLUME) {
            if (lastChild != null && isNumeric(String.valueOf(lastChild)))
                this.effects.put(effect, new IntValue(Integer.parseInt(String.valueOf(lastChild))));
            else if (lastChild != null) {
                IntValue varInt = (IntValue) msv.extractVariable(ctx, (TerminalNode) lastChild, Type.INT, parents).valueObj;
                this.effects.put(effect, varInt);
            }

        } else if (effect == Effect.JAZZ || effect == Effect.BLUES) {
            if (lastChild != null && isBoolean(String.valueOf(lastChild)))
                this.effects.put(effect, new BoolValue(Boolean.parseBoolean(String.valueOf(lastChild))));
            else if (lastChild != null) {
                BoolValue varBool = (BoolValue) msv.extractVariable(ctx, (TerminalNode) lastChild, Type.BOOL, parents).valueObj;
                this.effects.put(effect, varBool);
            }
        } else {
            if (lastChild != null && isNumeric(String.valueOf(lastChild))) {
                this.effects.put(effect, new IntValue(Integer.parseInt(String.valueOf(lastChild))));
                if (this.instrument == DRUMS)
                    this.channels[9].controlChange(this.effectControllers.get(effect), ((IntValue) this.effects.get(effect)).value);
                else
                    this.channels[0].controlChange(this.effectControllers.get(effect), ((IntValue) this.effects.get(effect)).value);
            } else if (lastChild != null) {
                IntValue varInt = (IntValue) msv.extractVariable(ctx, (TerminalNode) lastChild, Type.INT, parents).valueObj;
                if (this.instrument == DRUMS)
                    this.channels[9].controlChange(this.effectControllers.get(effect), varInt.value);
                else
                    this.channels[0].controlChange(this.effectControllers.get(effect), varInt.value);
            }
        }
    }

    public void editEffectPlain(Effect effect, Value value) {
        if (effect == Effect.PACE || effect == Effect.VOLUME) {
            if (value instanceof IntValue) {
                IntValue varInt = (IntValue) value;
                this.effects.put(effect, new IntValue(varInt.value));
            }
        } else if (effect == Effect.JAZZ || effect == Effect.BLUES) {
            if (value instanceof BoolValue) {
                BoolValue varBool = (BoolValue) value;
                this.effects.put(effect, new BoolValue(varBool.value));
            }
        } else {
            if (value instanceof IntValue) {
                IntValue varInt = (IntValue) value;
                this.effects.put(effect, new IntValue(varInt.value));
                if (this.instrument == DRUMS)
                    this.channels[9].controlChange(this.effectControllers.get(effect), ((IntValue) this.effects.get(effect)).value);
                else
                    this.channels[0].controlChange(this.effectControllers.get(effect), ((IntValue) this.effects.get(effect)).value);
            }
        }
    }

    public boolean setInstrument(Instrument instrument) {
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
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBoolean(String str) {
        try {
            Boolean.parseBoolean(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

//    /**
//     * Creates a shallow copy of Melody class memory
//     *
//     * @param original
//     * @return
//     */

//    public static Scope shallowCopyScope(Melody original) {
//        Scope copy = new Scope();
//        copy.memory = new HashMap<>();
//        copy.memory.putAll(original.memory);
//        return copy;
//    }

//    /**
//     * Creates a shallow copy of Scope class memory
//     *
//     * @param original
//     * @return
//     */

//    public static Scope shallowCopyScope(Scope original) {
//        Scope copy = new Scope();
//        copy.memory = new HashMap<>();
//        copy.memory.putAll(original.memory);
//        return copy;
//    }

    public void copyEffects(HashMap<Effect, Value> effects) {
        this.effects = new HashMap<>();
        for (Map.Entry<Effect, Value> entry : effects.entrySet()) {
            this.editEffectPlain(entry.getKey(), entry.getValue());
        }
    }

    public static Scope deepCopyScope(Scope original, Melody melodyParent, Scope parentScope) {
        Scope copy = new Scope();
        copy.scopeType = original.scopeType;
        copy.memory = new HashMap<>();
        copy.melodyParent = melodyParent;
        copy.parent = parentScope;
        copy.scopes = new ArrayList<>();
        //Copying settings from original scope
        copy.copyEffects(original.effects);
        copy.setInstrument(original.instrument);
        copyMemory(copy, original.memory);
        copy.forInit = original.forInit != null ? new String(original.forInit) : null;


        return copy;
    }

    public static Scope deepCopyScopeStructure(Scope original, Melody melodyParent, Scope parentScope) {
        Scope copy = deepCopyScope(original, melodyParent, parentScope);

        for (Scope scope : original.scopes) {
            copy.scopes.add(deepCopyScopeStructure(scope, null, copy));
        }

        return copy;
    }

//    public static Scope deepCopyFromParent(Scope parent, Melody melodyParent) {
//        Scope scope = new Scope();
//        if (parent != null) {
//            copyMemory(scope, parent.memory);
//        } else {
//            copyMemory(scope, melodyParent.memory);
//        }
//        return scope;
//    }

    public static void addMemoryFromParams(Melody melody, Scope scope) {
        for (Map.Entry<Integer, VarInfo> entry : melody.parameters.entrySet()) {
            String varName = entry.getValue().name;
            if(!scope.memory.containsKey(varName)) {
                copyMemElement(scope, varName, entry.getValue());
            }
        }
        for (Scope scopeChild : scope.scopes) {
            addMemoryFromParams(melody, scopeChild);
        }
    }

    public static void addMemoryFromMemory(Scope copyTo, Scope parent, Melody melodyParent){
        if (parent != null) {
            for (Map.Entry<String, VarInfo> entry : parent.memory.entrySet()) {
                if(!copyTo.memory.containsKey(entry.getKey())) {
                    copyMemElement(copyTo, entry.getKey(), entry.getValue());
                }
            }
        }else {
            for (Map.Entry<String, VarInfo> entry : melodyParent.memory.entrySet()) {
                if(!copyTo.memory.containsKey(entry.getKey())) {
                    copyMemElement(copyTo, entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void copyChildren(Scope copyTo, ArrayList<Scope> copyFrom){
        copyTo.scopes = new ArrayList<>(copyFrom);
    }

    public static void copyMemory(Scope scope, HashMap<String, VarInfo> memory) {
        for (Map.Entry<String, VarInfo> entry : memory.entrySet()) {
            copyMemElement(scope, entry.getKey(), entry.getValue());
        }
    }

    private static void copyMemElement(Scope scope, String name, VarInfo varInfo) {
        Type type = varInfo.type;
        switch (type) {
            case INT:
                scope.memory.put(name, new VarInfo(
                        varInfo.name,
                        varInfo.type,
                        varInfo.line,
                        varInfo.valueObj != null ? new IntValue(((IntValue) varInfo.valueObj).value) : null));
                break;
            case BOOL:
                scope.memory.put(name, new VarInfo(
                        varInfo.name,
                        varInfo.type,
                        varInfo.line,
                        varInfo.valueObj != null ? new BoolValue(((BoolValue) varInfo.valueObj).value) : null));
                break;
            case NOTE:
                scope.memory.put(name, new VarInfo(
                        varInfo.name,
                        varInfo.type,
                        varInfo.line,
                        varInfo.valueObj != null ? new NoteValue(((NoteValue) varInfo.valueObj).note) : null));
                break;
            case CHORD:
                scope.memory.put(name, new VarInfo(
                        varInfo.name,
                        varInfo.type,
                        varInfo.line,
                        varInfo.valueObj != null ? new ChordValue(((ChordValue) varInfo.valueObj).notes) : null));
                break;
        }
    }

    public Scope getChild(){
        return this.scopes.get(0);
    }

}
