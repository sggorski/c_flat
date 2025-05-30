package pl.edu.agh;

import pl.edu.agh.errors.ImportError;
import pl.edu.agh.errors.IncludeError;
import pl.edu.agh.utils.LineOrigin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ImportHandler {
    private static int currentSuperLine = 1;
    private final Set<String> alreadyImported = new HashSet<>();
    private final Set<String> alreadyIncluded = new HashSet<>();
    private int mainsCount = 0;
    private final String mainFile;
    private final Map<Integer, LineOrigin> lineMap = new HashMap<>();

    public Map<Integer, LineOrigin> getLineMap() {
        return lineMap;
    }

    public ImportHandler(String mainFile) {
        this.mainFile = mainFile;
    }

    public String resolveImports(String filename) throws ImportError {
        try {
            String combinedFile = resolveImportsHelper(filename);
            if(this.mainsCount == 0)
                throw new ImportError("no main melody declaration found");
            return combinedFile;
        } catch (IOException e) {
            throw new ImportError("cannot open file: " + e.getMessage());
        }
    }

    private String resolveImportsHelper(String filename) throws IOException {
        if (alreadyImported.contains(filename)) {
            return "";
        }
        alreadyImported.add(filename);

        StringBuilder result = new StringBuilder();
        List<String> lines = Files.readAllLines(Paths.get(filename));

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.matches("melody main\\(.*\\).*")) {
                if(!filename.equals(this.mainFile))
                    throw new ImportError("main melody declaration out of main file - in file " + filename);

                this.mainsCount++;
                if (this.mainsCount > 1)
                    throw new ImportError("too many main methods: " + this.mainsCount + " in file: " + this.mainFile);
            }

            if (line.startsWith("import")) {
                String importedFile = extractFilename(line);
                result.append(resolveImportsHelper(importedFile));
            } else if (line.matches("^include [a-z]+;$")) {
                //TODO
            } else if (line.matches("^include [a-z]+\\.[a-zA-Z_0-9]+;$")) {
                result.append(resolveIncludesHelper(line));
            } else {
                result.append(line).append("\n");
                lineMap.put(currentSuperLine, new LineOrigin(filename, i + 1));
                currentSuperLine++;
            }
        }

        return result.toString();
    }

    private String resolveIncludesHelper(String originalLine) {
        String[] split = originalLine.split(" ");
        String resourcePath = "libs/" + split[1].replace('.', '/').replace(';', ' ').trim() + ".cb";

        if (alreadyIncluded.contains(resourcePath)) {
            return "";
        }
        alreadyIncluded.add(resourcePath);

        InputStream inputStream = ImportHandler.class.getClassLoader().getResourceAsStream(resourcePath);
        if(inputStream == null)
            throw new IncludeError("cannot find resource: " + resourcePath);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        List<String> entireFileInLines = reader.lines().collect(Collectors.toList());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < entireFileInLines.size(); i++) {
            String line = entireFileInLines.get(i);
            if (line.matches("^include [a-z]+\\.[a-zA-Z_0-9]+;$")) {
                result.append(resolveIncludesHelper(line));
            } else {
                result.append(line).append("\n");
                lineMap.put(currentSuperLine, new LineOrigin(resourcePath, i + 1));
                currentSuperLine++;
            }
        }

        return result.toString();
    }

    private String extractFilename(String importLine) {
        int start = importLine.indexOf('"') + 1;
        int end = importLine.lastIndexOf('"');
        return importLine.substring(start, end);
    }
}
