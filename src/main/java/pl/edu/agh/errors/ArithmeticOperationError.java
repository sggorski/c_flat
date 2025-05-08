package pl.edu.agh.errors;

import pl.edu.agh.utils.LineOrigin;

public class ArithmeticOperationError extends RuntimeException {
    public ArithmeticOperationError(String message, LineOrigin origin, int column) {
        super();
        this.lineOrigin = origin;
        this.column = column;
        this.message = "Arithmetic Operation Error at line: " + lineOrigin.getOriginalLine() + " character: " + column + " file: " + lineOrigin.getFileName() + " " + message;
    }

    private final LineOrigin lineOrigin;
    private final int column;
    private final String message;

    @Override
    public String getMessage(){
        return message;
    }

    public int getLine(){
        return this.lineOrigin.getOriginalLine();
    }

    public int getColumn(){
        return column;
    }

}
