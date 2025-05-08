package pl.edu.agh.errors;

import pl.edu.agh.utils.LineOrigin;

public class ValueError extends RuntimeException {
    private final LineOrigin lineOrigin;
    private final int column;
    private final String message;

    public ValueError(String message, LineOrigin origin, int column) {
        super();
        this.lineOrigin = origin;
        this.message = "Value Error at line:  " + lineOrigin.getOriginalLine() + " character: " + column + " file: " + lineOrigin.getFileName() + " " +  message;
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
