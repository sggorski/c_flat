package pl.edu.agh.visitorActions;

import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.IncomparableError;
import pl.edu.agh.utils.BoolValue;
import pl.edu.agh.utils.LineOrigin;
import pl.edu.agh.utils.Value;

public class EqOperatorExpr {

    /**
     * Evaluates equality or inequality between two values.
     * Throws error if types differ.
     * Returns BoolValue with result of comparison.
     */
    public static BoolValue evaluate(MusicParser.EqOperatorExprContext ctx, Value firstValue, Value secondValue, LineOrigin origin, int col){
        if (firstValue.getType() != secondValue.getType()) {
            throw new IncomparableError("Types are not the same: " + firstValue + " != " + secondValue, origin, col);
        }
        BoolValue result = firstValue.equals(secondValue);
        if (ctx.eqOp().EQ() != null) return result;
        else {
            if (result.value) return new BoolValue(false);
            else return new BoolValue(true);
        }
    }
}
