package pl.edu.agh;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pl.edu.agh.utils.*;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrackHandler {

    public static String generateNewCode(String originalCode, String funcName, List<Value> args,
                                         HashMap<Effect,Value> effects, Instrument instrument){
        String withoutMain = originalCode.replaceAll("melody\\s+main\\s*\\(\\)\\s*\\{[\\s\\S]*}", "");
        String newMain = "melody main() {\n";
        int count = 0;
        if(args!=null){
            for(Value arg: args){
                Type type = arg.getType();
                switch(type){
                    case NOTE:
                        NoteValue noteVal = (NoteValue)arg;
                        newMain += "Note var" + count+ " = " + noteVal.note + ";\n";
                        break;
                    case INT:
                        IntValue intVal = (IntValue)arg;
                        newMain += "int var" + count+ " = " + intVal.value + ";\n";
                        break;
                    case BOOL:
                        BoolValue boolVal = (BoolValue)arg;
                        newMain += "bool var" + count+ " = " + boolVal.value + ";\n";
                        break;
                    case CHORD:
                        ChordValue chordVal = (ChordValue)arg;
                        newMain += "Chord var" + count+ " = [";
                        for(NoteValue note: chordVal.notes){
                            newMain += note.note + ",";
                        }
                        newMain = newMain.substring(0, newMain.length() - 1);
                        newMain += "];\n";
                        break;
                }
                count +=1;
            }
        }
        if(instrument!= null) newMain += "SET INSTRUMENT = " + instrument.toString() + ";\n";
        if(effects!=null){
            for(Effect effect: effects.keySet()){
                newMain+= "SET " + effect.toString() + " = ";
                Type type = effects.get(effect).getType();
                switch(type){
                    case INT:
                        IntValue intVal = (IntValue)effects.get(effect);
                        newMain += intVal.value + ";\n";
                        break;
                    case BOOL:
                        BoolValue boolVal = (BoolValue)effects.get(effect);
                        newMain += boolVal.value + ";\n";
                        break;
                }
            }
        }
        newMain += "PLAY " + funcName + "(";
        for(int i=0; i<count; i++){
            newMain += "var" + i + ",";
        }
        newMain = newMain.substring(0, newMain.length() - 1);
        newMain += ");\n";
        newMain += "}";
        return withoutMain + newMain;
    }

    public static AbstractMap.SimpleEntry<MusicSuperVisitor, MusicParser.ProgramContext> prepareVisitor(String code, Map<Integer, LineOrigin> lineMap){
        HashMap<String,Melody> melodyMemory = new HashMap<>();
        CharStream stream = CharStreams.fromString(code);
        MusicLexer lexer = new MusicLexer(stream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new MusicErrorListener(lineMap));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MusicParser parser = new MusicParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new MusicErrorListener(lineMap));
        MusicParser.ProgramContext program = parser.program();
        MusicSuperListener listener = new MusicSuperListener(melodyMemory, lexer, lineMap);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, program);
        MusicSuperVisitor visitor = new MusicSuperVisitor(melodyMemory, lineMap,null);
        return new AbstractMap.SimpleEntry<>(visitor, program);
    }
}
