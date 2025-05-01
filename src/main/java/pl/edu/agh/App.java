package pl.edu.agh;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pl.edu.agh.errors.ScopeError;
import pl.edu.agh.errors.SyntaxError;
import pl.edu.agh.errors.ValueError;
import pl.edu.agh.errors.VariableDeclarationError;

import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static HashMap<String,Melody> melodyMemory = new HashMap<>();

    public static void main( String[] args ) throws IOException {
        CharStream stream;
        try {
            stream = CharStreams.fromFileName(String.format("src/main/java/pl/edu/agh/grammar/third_stage/test.txt"));

        } catch(Exception e) {
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

            Melody main = new Melody();
            MusicParser.ProgramContext program = parser.program();

            MusicSuperListener listener = new MusicSuperListener(melodyMemory, lexer);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, program);
            System.out.println(melodyMemory.toString());
            MusicSuperVisitor visitor = new MusicSuperVisitor(melodyMemory);
            visitor.visitProgram(program);

        } catch (ParseCancellationException e) {
            System.out.println(e.getMessage() /*+ " ParseCancel"*/);
        } catch (RecognitionException e) {
            System.out.println(e.getMessage() /*+ " Recognition"*/);
        } catch (SyntaxError | ValueError | ScopeError | VariableDeclarationError e) {
            System.out.println(e.getMessage() /*+ " Errors"*/);
        }catch (Exception e) {
            System.out.println(/*"Error: +"*/ e.getMessage());
        }
    }
}