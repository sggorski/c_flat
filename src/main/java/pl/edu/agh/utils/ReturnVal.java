package pl.edu.agh.utils;

public class ReturnVal {
    public Value value;
    public Value getValue(){
        return value;
    }

    public ReturnVal(Value v){
        value = v;
    }
}
