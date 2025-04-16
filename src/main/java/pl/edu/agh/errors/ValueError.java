package pl.edu.agh.errors;

public class ValueError extends RuntimeException {
    private final int line;
    private final int column;
    private final String message;

    public ValueError(String message, int  line, int column) {
        super();
        this.message = "Value Error at line:  " + line + " character: " + column + " " +  message;
        this.line = line;
        this.column = column;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
