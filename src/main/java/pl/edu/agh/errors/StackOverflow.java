package pl.edu.agh.errors;

public class StackOverflow extends RuntimeException {
    private final String message;
    private final String function;

    public StackOverflow(String function) {
        this.message = "StackOverflow error caused by function: " + function;
        this.function = function;
    }

    @Override
    public String getMessage() {
      return message;
    }
    public String getFunction() {
    return function;
  }
}
