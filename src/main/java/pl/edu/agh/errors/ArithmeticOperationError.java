package pl.edu.agh.errors;

public class ArithmeticOperationError extends RuntimeException {
    public ArithmeticOperationError(String message, int line, int column) {
        super();
        this.line = line;
        this.column = column;
        this.message = "Arithmetic Operation Error at line: " + line + " character: " + column + " " + message ;
    }

    private final int line;
    private final int column;
    private final String message;

    @Override
    public String getMessage(){
        return message;
    }

    public int getLine(){
        return line;
    }

    public int getColumn(){
        return column;
    }

}
