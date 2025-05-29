package pl.edu.agh.visitorActions;

import pl.edu.agh.errors.ValueError;
import pl.edu.agh.utils.BoolValue;
import pl.edu.agh.utils.LineOrigin;
import pl.edu.agh.utils.Value;

public class AndOperatorExpr {

    /**
     * Evaluates the logical AND operation between two BoolValue operands.
     * Throws ValueError if either operand is not of BOOL type.
     */
    public static BoolValue evaluate(Value firstValue, Value secondValue, LineOrigin origin, int col){
        if (firstValue instanceof BoolValue && secondValue instanceof BoolValue) {
            BoolValue boolExpr1 = (BoolValue) firstValue;
            BoolValue boolExpr2 = (BoolValue) secondValue;
            return new BoolValue(boolExpr1.value && boolExpr2.value);
        } else if (firstValue instanceof BoolValue)
            throw new ValueError("Incorrect type of expression: " + secondValue.getType() + " not BOOL", origin, col);
        else
            throw new ValueError("Incorrect type of expression: " + firstValue.getType() + " not BOOL", origin, col);
    }
}
