package pl.edu.agh;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import pl.edu.agh.musicUtils.Effect;
import pl.edu.agh.musicUtils.Instrument;
import pl.edu.agh.musicUtils.Music;
import pl.edu.agh.utils.*;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.*;

import static pl.edu.agh.musicUtils.Instrument.DRUMS;

public class Melody {

    public Instrument instrument=Instrument.PIANO;
    public HashMap<Effect, Value> effects = new HashMap<>();
    public String name;
    public HashMap<String, VarInfo> memory = new HashMap<>();
    public HashMap<Integer, VarInfo> parameters = new HashMap<>();
    public List<MusicParser.StatementContext> body;
    public List<MusicParser.MainStatementContext> mainBody;
    public ArrayList<Scope> scopes = new ArrayList<>();
    public Scope previous_scope;
    public String forInit;
    Synthesizer synth;
    public MidiChannel[] channels;


    public Melody()  {
        try {
            this.synth = MidiSystem.getSynthesizer();
            this.synth.open();
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
        this.channels = this.synth.getChannels();
        this.channels[0].programChange(0);
        Music.setUpEffects(this.effects);
    }

    public boolean setInstrument(Instrument instrument){
        this.instrument = instrument;
        return Music.setChannelForInstrument(instrument,this.channels);
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
        copy.forInit = original.forInit != null ? new String(original.forInit) : null;
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
        copy.scopes = new ArrayList<>();
        for(Scope scope : original.scopes) {
            copy.scopes.add(Scope.deepCopyScopeStructure(scope, copy, null));
        }
        copy.name = original.name;
        return copy;
    }

    public void copyEffects(HashMap<Effect, Value> effects){
        this.effects = new HashMap<>();
        for (Map.Entry<Effect, Value> entry : effects.entrySet()) {
            Music.editEffectMidi(entry.getKey(), entry.getValue(),this.effects,instrument,channels);
        }
    }

}