package pl.edu.agh.utils;

public class ContinueError extends RuntimeException {
    private final LineOrigin lineOrigin;
    private final int column;
    private final String message;

    public ContinueError(String message, LineOrigin origin, int column) {
        super();
        this.lineOrigin = origin;
        this.message = "Statement Error at line:  " + lineOrigin.getOriginalLine() + " character: " + column + " file: " + lineOrigin.getFileName() + " " +  message;
        this.column = column;
    }

    public int getLine() {
        return this.lineOrigin.getOriginalLine();
    }
    public int getColumn() {
        return column;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
