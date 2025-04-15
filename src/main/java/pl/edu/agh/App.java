package pl.edu.agh;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pl.edu.agh.errors.ScopeError;
import pl.edu.agh.errors.SyntaxError;

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
            // stream = CharStreams.fromFileName(String.format("src/main/java/pl/edu/agh/grammar/hello_worlds/hello_world_%s.txt",args[0]));
            // stream = CharStreams.fromFileName("src/main/java/pl/edu/agh/grammar/hello_worlds/hello_world_moonlight_sonata.txt");
            stream = CharStreams.fromFileName("src/main/java/pl/edu/agh/grammar/second_stage/turkish_march.txt");
        }
        catch(Exception e){
            System.out.println("No such melody!");
            return;
        }

        try{
            MusicLexer lexer = new MusicLexer(stream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MusicErrorListener());

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            MusicParser parser = new MusicParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(new MusicErrorListener());

            MusicSuperListener listener = new MusicSuperListener();
            parser.addParseListener(listener);

            MusicParser.ProgramContext program = parser.program();

            MusicSuperVisitor visitor = new MusicSuperVisitor();
            visitor.visitProgram(program);

        }catch (ParseCancellationException e){
            System.out.println(e.getMessage() + "ParseCancel");
        }
        catch (RecognitionException e){
            //System.out.println(parser.error);
            System.out.println(e.getMessage() + "Recognition");
        }
        catch (ScopeError e){
            System.out.println(e.getMessage());
        }
        catch (SyntaxError e){
            System.out.println(e.getMessage());
        }



    }
}
