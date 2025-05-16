package pl.edu.agh;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pl.edu.agh.errors.*;
import pl.edu.agh.utils.LineOrigin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static HashMap<String,Melody> melodyMemory = new HashMap<>();

    public static void main(String[] args) throws IOException {

        ImportHandler resolver = new ImportHandler();
        String mergedSource;
        try {
            mergedSource = resolver.resolveImports("src/main/java/pl/edu/agh/grammar/tests/test19_functions_advanced.cb");
        } catch (ImportError e) {
            System.err.println(e.getMessage());
            return;
        } catch(Exception e) {
            System.err.println("No such melody!");
            return;
        }

        Map<Integer, LineOrigin> lineMap = resolver.getLineMap();
        CharStream stream = CharStreams.fromString(mergedSource);
        try {
            MusicLexer lexer = new MusicLexer(stream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MusicErrorListener(lineMap));

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            MusicParser parser = new MusicParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(new MusicErrorListener(lineMap));

            Melody main = new Melody();
            MusicParser.ProgramContext program = parser.program();

            MusicSuperListener listener = new MusicSuperListener(melodyMemory, lexer, lineMap);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, program);
            System.out.println(melodyMemory.toString());
            MusicSuperVisitor visitor = new MusicSuperVisitor(melodyMemory, lineMap, mergedSource);
            visitor.visitProgram(program);

        } catch (ParseCancellationException e) {
            System.err.println(e.getMessage() /*+ " ParseCancel"*/);
        } catch (RecognitionException e) {
            System.err.println(e.getMessage() /*+ " Recognition"*/);
        } catch (UndefinedError e) {
            System.err.println(e.getMessage() /*+ " Undefined Variable"*/);
        } catch (SyntaxError | ValueError | ScopeError | VariableDeclarationError | StackOverflow e) {
            System.err.println(e.getMessage() /*+ " Errors"*/);
        }
        catch (Exception e) {
            System.err.println(/*"Error: +"*/ e.getMessage());
        }
    }
}