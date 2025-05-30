package pl.edu.agh.utils;

import java.util.HashMap;
import java.util.Map;

public class MappedGrammar {
    static public HashMap<String, String> tokensToUser = new HashMap<>();

    static {
        tokensToUser.put("ID" , "Variable");
        tokensToUser.put("[" , "Chord");
        tokensToUser.put("NOTE_VAL", "Note");
        tokensToUser.put("INT_VAL", "Integer");
        tokensToUser.put("BOOL_VAL", "Boolean");
        tokensToUser.put("STRING_VAL", "String");
        tokensToUser.put("INSTRUMENT_VAL", "Instrument");
    }


}
