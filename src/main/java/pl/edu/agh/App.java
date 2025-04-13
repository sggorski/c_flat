package pl.edu.agh;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javax.xml.transform.ErrorListener;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        //System.out.println( "Hello World!" );
        CharStream stream;
        try{
            stream = CharStreams.fromFileName(String.format("src/main/java/pl/edu/agh/grammar/hello_worlds/hello_world_%s.txt",args[0]));
        }
        catch(Exception e){
            System.out.println("No such melody!");
            return;
        }
        MusicLexer lexer = new MusicLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MusicParser parser = new MusicParser(tokens);

        try{
            parser.removeErrorListeners();

            MusicSuperListener listener = new MusicSuperListener();
            parser.addParseListener(listener);

            MusicParser.ProgramContext program = parser.program();

            MusicSuperVisitor visitor = new MusicSuperVisitor();
            visitor.visitProgram(program);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
