package pl.edu.agh.errors;

public class ScopeError extends RuntimeException {
    private final int line;
    private final int column;
    private final String message;

    public ScopeError(String message, int line, int column) {
        super();
        this.message = "Scope error at line: " + line + " character: " + column + " " + message;
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }
    public int getColumn() {
        return column;
    }

    @Override
    public String getMessage() {
        return message;
    }}
