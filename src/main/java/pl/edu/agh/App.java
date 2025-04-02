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
        CharStream stream = CharStreams.fromFileName("src/main/java/pl/edu/agh/grammar/hello_worlds/hello_world_moonlight_sonata.txt");
        MusicLexer lexer = new MusicLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MusicParser parser = new MusicParser(tokens);
        MusicParser.ProgramContext program = parser.program();
        //parser.addParseListener(new MusicSuperListener());
        try{

            MusicSuperListener listener = new MusicSuperListener();
            ParseTreeWalker.DEFAULT.walk(listener, program);

            MusicSuperVisitor visitor = new MusicSuperVisitor();
            visitor.visitProgram(program);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
