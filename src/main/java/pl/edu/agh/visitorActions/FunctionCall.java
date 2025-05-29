package pl.edu.agh.visitorActions;

import pl.edu.agh.Melody;
import pl.edu.agh.errors.RuntimeError;
import pl.edu.agh.utils.LineOrigin;
import pl.edu.agh.utils.Scope;

import java.util.HashMap;

public class FunctionCall {

    public static Melody getMelodyCopy(String name, HashMap<String, Melody> melodyMemory, LineOrigin origin, int col){
        if (name.equals("main"))
            throw new RuntimeError("You cannot call a main melody", origin,col);
        if (!melodyMemory.containsKey(name))
            throw new RuntimeError("Melody " + name + " not declared", origin,col);
        Melody melodyPattern = melodyMemory.get(name);
        return Melody.deepCopyMelody(melodyPattern);
    }

    public static void copyEffects(Melody newMelody, Melody previousMelody, Scope currentScope){
        if(currentScope!=null){
            newMelody.copyEffects(currentScope.effects);
            newMelody.setInstrument(currentScope.instrument);
        }
        else {
            newMelody.copyEffects(previousMelody.effects);
            newMelody.setInstrument(previousMelody.instrument);
        }
    }

}
