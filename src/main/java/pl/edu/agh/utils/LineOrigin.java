package pl.edu.agh.utils;

public class LineOrigin {
    private final String fileName;
    private final int originalLine;

    public LineOrigin(String fileName, int originalLine) {
        this.fileName = fileName;
        this.originalLine = originalLine;
    }

    @Override
    public String toString() {
        return "File: " + fileName + ", Line: " + originalLine;
    }

    public String getFileName() {
        return fileName;
    }

    public int getOriginalLine() {
        return originalLine;
    }
}
