package pl.edu.agh.utils;

public class IntValue implements Value {
    public Type type = Type.INT;
    public  int value;
    public IntValue(int value) { this.value = value; }
    public Type getType() { return type; }
    public void setValue(int value) { this.value = value; }

    @Override
    public String toString() {
        return "IntValue{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }

    @Override
    public BoolValue equals(Value value) {
        IntValue other = (IntValue) value;
        return new BoolValue(this.value == other.value);
    }
}
