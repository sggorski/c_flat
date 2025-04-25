package pl.edu.agh.errors;

public class VariableDeclarationError extends RuntimeException {
    private final int line;
    private final int column;
    private final String message;

    public VariableDeclarationError(String message, int  line, int column) {
      super();
      this.message = "Variable Declaration Error at line: " + line + " character: " + column + "; " +  message;
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
    }
}
