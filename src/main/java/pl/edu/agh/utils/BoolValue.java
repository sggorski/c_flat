package pl.edu.agh.utils;

public class BoolValue implements Value {
    public Type type = Type.BOOL;
    public  Boolean value;
    public BoolValue(Boolean value) { this.value = value; }
    public Type getType() { return type; }
    public void setValue(Boolean value) { this.value = value; }

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
