package pl.edu.agh;

import pl.edu.agh.errors.ImportError;
import pl.edu.agh.errors.IncludeError;
import pl.edu.agh.utils.FilePreImportProcessing;
import pl.edu.agh.utils.LineOrigin;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class ImportHandler {
    private static int currentSuperLine = 1;
    private static long scopeCounter = 0;
    private final Set<String> alreadyImported = new HashSet<>();
    private final Set<String> alreadyIncluded = new HashSet<>();
    private int mainsCount = 0;
    private final String mainFile;
    private final Map<Integer, LineOrigin> lineMap = new HashMap<>();
    private final List<String> globalDeclarations = new ArrayList<>();
    private final List<Integer> globalDeclarationLineNumbers = new ArrayList<>();

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

            return resolveGlobalVariables(combinedFile);
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
                    throw new ImportError("main melody declaration out of main file - in file " + filename + ", line: " + (i+1));

                this.mainsCount++;
                if (this.mainsCount > 1)
                    throw new ImportError("too many main methods: " + this.mainsCount + " in file: " + this.mainFile);
            }

            if (line.startsWith("import")) {
                String importedFile = extractFilename(line);
                FilePreImportProcessing preprocessor = new FilePreImportProcessing();
                preprocessor.analiseFile(importedFile);
                result.append(resolveImportsHelper(importedFile));
            } else if (line.matches("^include [a-z]+;$")) {
                List<String> libFiles = resolveAllIncludes(line);
                for (String libFile : libFiles) {
                    result.append(resolveIncludesHelper(libFile));
                }
            } else if (line.matches("^include [a-z]+\\.[a-zA-Z_0-9]+;$")) {
                result.append(resolveIncludesHelper(line));
            } else {
                long plusScopeCount = line.chars().filter(c -> c == '{').count();
                scopeCounter += plusScopeCount;
                long minusScopeCount = line.chars().filter(c -> c == '}').count();
                scopeCounter -= minusScopeCount;

                if(line.trim().matches("^(int|bool|Note|Track|Chord) *[a-zA-Z_0-9]+.*;$")) {
                    if(scopeCounter == 0) {
                        if(!filename.equals(this.mainFile))
                            throw new ImportError("global variable declaration not allowed outside of main file (found in: " + filename + ", line: " + (i+1) + ")");

                        globalDeclarations.add(line);
                        globalDeclarationLineNumbers.add(i + 1);
                        continue;
                    }
                }

                result.append(line).append("\n");
                lineMap.put(currentSuperLine, new LineOrigin(filename, i + 1));
                currentSuperLine++;
            }
        }

        return result.toString();
    }

    private List<String> resolveAllIncludes(String line) throws UnsupportedEncodingException, IOException {
        String[] split = line.split(" ");
        List<String> libFiles = new ArrayList<>();
        String fullPath = "libs/" + split[1].replace(';', ' ').trim();

        URL url = ImportHandler.class.getClassLoader().getResource(fullPath);
        String jarPath = url.getPath().substring(5, url.getPath().indexOf("!"));

        try (JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"))) {
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String name = entry.getName();
                if (name.startsWith(fullPath) && name.endsWith(".cb") && !entry.isDirectory()) {
                    String originalLineSimulation = "include " + name.substring(5).replace('/', '.').replace(".cb", "") + ';';
                    libFiles.add(originalLineSimulation);
                }
            }
        }

        return libFiles;
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

    private String resolveGlobalVariables(String mergedSoFar) {
        StringBuilder finalResult = new StringBuilder();
        Map<Integer, LineOrigin> newLineMap = new HashMap<>();

        for (int i = 0; i < globalDeclarations.size(); i++) {
            finalResult.append(globalDeclarations.get(i)).append("\n");
            newLineMap.put(i + 1, new LineOrigin(mainFile, globalDeclarationLineNumbers.get(i)));
        }

        int offset = globalDeclarations.size();
        for (Map.Entry<Integer, LineOrigin> entry : lineMap.entrySet()) {
            newLineMap.put(entry.getKey() + offset, entry.getValue());
        }
        lineMap.clear();
        lineMap.putAll(newLineMap);

        finalResult.append(mergedSoFar);
        return finalResult.toString();
    }

    private String extractFilename(String importLine) {
        int start = importLine.indexOf('"') + 1;
        int end = importLine.lastIndexOf('"');
        return importLine.substring(start, end);
    }
}
