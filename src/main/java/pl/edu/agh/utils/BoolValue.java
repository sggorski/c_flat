package pl.edu.agh.utils;

import pl.edu.agh.errors.ValueError;

public class BoolValue implements Value {
    public Type type = Type.BOOL;
    public  boolean value;
    public BoolValue(boolean value) { this.value = value; }
    public Type getType() { return type; }
    public void setValue(boolean value) { this.value = value; }

    @Override
    public String toString() {
        return "BoolValue{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }

    @Override
    public BoolValue equals(Value value) {
        BoolValue other = (BoolValue) value;
        return new BoolValue(other.value== this.value);
    }
}
