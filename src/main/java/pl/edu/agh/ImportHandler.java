package pl.edu.agh;

import pl.edu.agh.errors.ImportError;
import pl.edu.agh.utils.LineOrigin;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ImportHandler {
    private static int currentSuperLine = 1;
    private final Set<String> alreadyImported = new HashSet<>();
    private int mainsCount = 0;
    private final Set<String> mainsFiles = new HashSet<>();
    private final Map<Integer, LineOrigin> lineMap = new HashMap<>();

    public Map<Integer, LineOrigin> getLineMap() {
        return lineMap;
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
                this.mainsCount++;
                if (this.mainsCount > 1)
                    throw new ImportError("too many main methods: " + this.mainsCount + " in files: " + filename + " " + this.mainsFiles.iterator().next());
                this.mainsFiles.add(filename);
            }

            if (line.startsWith("import")) {
                String importedFile = extractFilename(line);
                result.append(resolveImportsHelper(importedFile));
            } else {
                result.append(line).append("\n");
                lineMap.put(currentSuperLine, new LineOrigin(filename, i + 1));
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
