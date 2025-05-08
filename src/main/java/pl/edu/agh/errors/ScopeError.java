package pl.edu.agh.errors;

import pl.edu.agh.utils.LineOrigin;

public class ScopeError extends RuntimeException {
    private final LineOrigin lineOrigin;
    private final int column;
    private final String message;

    public ScopeError(String message, LineOrigin origin, int column) {
        super();
        this.lineOrigin = origin;
        this.message = "Scope error at line: " + lineOrigin.getOriginalLine() + " character: " + column + " file: " + lineOrigin.getFileName() + " " + message;
        this.column = column;
    }

    public int getLine() {
        return lineOrigin.getOriginalLine();
    }
    public int getColumn() {
        return column;
    }

    @Override
    public String getMessage() {
        return message;
    }}
