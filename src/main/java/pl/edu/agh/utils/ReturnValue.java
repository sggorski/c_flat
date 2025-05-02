package pl.edu.agh.utils;

public class ReturnValue extends RuntimeException {
    public Value value;

    public ReturnValue(Value value) {
        this.value = value;
    }
    public Value getValue() {
        return value;
    }
}
