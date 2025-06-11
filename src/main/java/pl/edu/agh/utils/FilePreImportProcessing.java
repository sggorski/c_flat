package pl.edu.agh.utils;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import pl.edu.agh.MusicErrorListener;
import pl.edu.agh.MusicLexer;
import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.SyntaxError;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FilePreImportProcessing {
    public void analiseFile(String filename) throws SyntaxError, IOException {
        CharStream startStream = CharStreams.fromFileName(filename);
        Map<Integer, LineOrigin> startLineMap = new HashMap<>();
        for(int i = 1; i<= countLines(filename); ++i) {
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

    public static int countLines(String filePath) {
        int lines = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
            }

            if (new java.io.RandomAccessFile(filePath, "r").length() > 0) {
                java.nio.file.Path path = java.nio.file.Paths.get(filePath);
                byte[] bytes = java.nio.file.Files.readAllBytes(path);
                if (bytes[bytes.length - 1] == '\n' || bytes[bytes.length - 1] == '\r') {
                    lines++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
