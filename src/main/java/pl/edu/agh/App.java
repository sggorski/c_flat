package pl.edu.agh;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pl.edu.agh.errors.ScopeError;
import pl.edu.agh.errors.SyntaxError;
import pl.edu.agh.errors.ValueError;
import pl.edu.agh.errors.VariableDeclarationError;

import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        CharStream stream;
        try {
            // stream = CharStreams.fromFileName(String.format("src/main/java/pl/edu/agh/grammar/hello_worlds/hello_world_%s.txt",args[0]));
            stream = CharStreams.fromFileName("src/main/java/pl/edu/agh/grammar/second_stage/vivaldi_spring_standard.txt");
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

            MainMelody main = new MainMelody();
            MusicParser.ProgramContext program = parser.program();

            MusicSuperListener listener = new MusicSuperListener(main, lexer);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, program);

            MusicSuperVisitor visitor = new MusicSuperVisitor(main);
            visitor.visitProgram(program);

        } catch (ParseCancellationException e) {
            System.out.println(e.getMessage() + " ParseCancel");
        } catch (RecognitionException e) {
            System.out.println(e.getMessage() + " Recognition");
        } catch (SyntaxError | ValueError | ScopeError | VariableDeclarationError e) {
            System.out.println(e.getMessage() + " Errors");
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Unknown error: " + e.getMessage());
        }
    }
}