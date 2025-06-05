package pl.edu.agh;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pl.edu.agh.errors.*;
import pl.edu.agh.utils.FilePreImportProcessing;
import pl.edu.agh.utils.LineOrigin;
import pl.edu.agh.utils.SuperErrorStrategy;
import pl.edu.agh.utils.VarInfo;

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
    public static HashMap<String, VarInfo> globalScope  = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String file = "src/main/java/pl/edu/agh/grammar/final_stage/coco_jambo.cb";
        FilePreImportProcessing analyser = new FilePreImportProcessing();
        try {
            analyser.analiseFile(file);
        } catch (SyntaxError e) {
            System.err.println(e.getMessage());
            return;
        } catch (IOException e) {
            System.err.println("Cannot open file " + e.getMessage());
            return;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }

        ImportHandler importer = new ImportHandler(file);
        String mergedSource;
        try {
            mergedSource = importer.resolveImports(file);
        } catch (IncludeError | ImportError | SyntaxError e) {
            System.err.println(e.getMessage());
            return;
        } catch(Exception e) {
            System.err.println("No such melody!");
            return;
        }

        CharStream stream = CharStreams.fromString(mergedSource);
        Map<Integer, LineOrigin> lineMap = importer.getLineMap();
        try {
            MusicLexer lexer = new MusicLexer(stream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MusicErrorListener(lineMap));

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            MusicParser parser = new MusicParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(new MusicErrorListener(lineMap));
            parser.setErrorHandler(new SuperErrorStrategy());

            Melody main = new Melody();
            MusicParser.ProgramContext program = parser.program();

            MusicSuperListener listener = new MusicSuperListener(melodyMemory, lexer, lineMap, globalScope);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, program);

            MusicSuperVisitor visitor = new MusicSuperVisitor(melodyMemory, lineMap, mergedSource, globalScope);
            visitor.visitProgram(program);

        }  catch (ParseCancellationException e) {
            System.err.println(e.getMessage() /*+ " ParseCancel"*/);
        } catch (RecognitionException e) {
            System.err.println(e.getMessage() /*+ " Recognition"*/);
        } catch (UndefinedError e) {
            System.err.println(e.getMessage() /*+ " Undefined Variable"*/);
        } catch (SyntaxError | ValueError | ScopeError | VariableDeclarationError | StackOverflow e) {
            System.err.println(e.getMessage() /*+ " Errors"*/);
        } catch (Exception e) {
            System.err.println(/*"Error: +"*/ e.getMessage());
        }
    }
}