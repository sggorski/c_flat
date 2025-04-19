package pl.edu.agh.utils;

public interface Value {
    public Type getType();
    public String toString();
    public BoolValue equals(Value value);
}

