package pl.edu.agh.errors;

public class IncludeError extends RuntimeException {
    private final String message;

    public IncludeError(String message) {
        super();
        this.message = "Include error: " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
