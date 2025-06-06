package pl.edu.agh.errors;

import pl.edu.agh.utils.LineOrigin;

public class UndefinedError extends RuntimeException {
    public UndefinedError(String message, LineOrigin origin, int column) {
        super();
        this.lineOrigin = origin;
        this.message = "Undefined error at line: " + lineOrigin.getOriginalLine() + " character: " + column + " file: " + lineOrigin.getFileName() + " " + message;
        this.column = column ;
    }

    public UndefinedError(String message, LineOrigin origin, int column, String proposal) {
        super();
        this.lineOrigin = origin;
        if(proposal == null){
            this.message = "Undefined error at line: " + lineOrigin.getOriginalLine() + " character: " + column + " file: " + lineOrigin.getFileName() + " " + message;
        }else{
            this.message = "Undefined error at line: " + lineOrigin.getOriginalLine() + " character: " + column + " file: " + lineOrigin.getFileName() + " " + message + " Did you mean: " + proposal;
        }
        this.column = column ;
    }

    private final LineOrigin lineOrigin;
    private final int column;
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }

    public int getLine() {
        return lineOrigin.getOriginalLine();
    }

    public int getColumn() {
        return column;
    }

}
