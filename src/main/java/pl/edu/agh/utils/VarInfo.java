package pl.edu.agh.utils;

public class VarInfo {
    public int line;
    public String name;
    public Value valueObj;
    public Type type;

    public VarInfo(String name, Type type, int line, Value val) {
        this.name = name;
        this.line = line;
        this.type = type;
        this.valueObj = val;
    }
}
