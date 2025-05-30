package pl.edu.agh.utils;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import pl.edu.agh.MusicErrorListener;
import pl.edu.agh.MusicLexer;
import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.SyntaxError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FilePreImportProcessing {
    public void analiseFile(String filename) throws SyntaxError, IOException {
        CharStream startStream = CharStreams.fromFileName(filename);
        Map<Integer, LineOrigin> startLineMap = new HashMap<>();
        for(int i = 1; i<= Files.readAllLines(Paths.get(filename)).size(); ++i) {
            startLineMap.put(i, new LineOrigin(filename, i));
        }

        MusicLexer lexer = new MusicLexer(startStream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new MusicErrorListener(startLineMap));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MusicParser parser = new MusicParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new MusicErrorListener(startLineMap));
        parser.setErrorHandler(new SuperErrorStrategy());
        parser.program();
    }
}
