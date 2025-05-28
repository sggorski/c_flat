package pl.edu.agh.utils;

import pl.edu.agh.Melody;
import pl.edu.agh.musicUtils.Effect;
import pl.edu.agh.musicUtils.Instrument;
import pl.edu.agh.musicUtils.Music;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.*;

public class Scope {


    public Instrument instrument = Instrument.PIANO;

    public HashMap<Effect, Value> effects = new HashMap<>();
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

        try {
            this.synth = MidiSystem.getSynthesizer();
            this.synth.open();
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }

        this.channels = this.synth.getChannels();
        this.channels[0].programChange(0);
        Music.setUpEffects(this.effects);
        memory = new HashMap<>();

    }

    public boolean setInstrument(Instrument instrument) {
        this.instrument = instrument;
        return Music.setChannelForInstrument(instrument,this.channels);
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
            Music.editEffectMidi(entry.getKey(), entry.getValue(),this.effects,instrument,channels);
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
