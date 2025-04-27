package pl.edu.agh.errors;

public class UndefinedError extends RuntimeException {
    public UndefinedError(String message, int line, int column) {
        super();
        this.message = "Undefined error at: " + line + " character: " + column + " " + message;
        this.line = line;
        this.column = column ;
    }
    private final int line;
    private final int column;
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

}
