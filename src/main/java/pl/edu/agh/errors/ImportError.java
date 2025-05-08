package pl.edu.agh.errors;

public class ImportError extends RuntimeException {
    private final String message;

    public ImportError(String message) {
        super();
        this.message = "Import error: " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
