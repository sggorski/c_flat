package pl.edu.agh.visitorActions;

import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.ArithmeticOperationError;
import pl.edu.agh.musicUtils.NoteMap;
import pl.edu.agh.utils.*;

import java.util.function.BiPredicate;

public class OrderOperatorExpr {

    /**
     * Evaluates an order comparison (>, <, >=, <=) between two values.
     * Supports comparisons between integers and musical notes.
     */
    public static BoolValue evaluate(MusicParser.OrderOperatorExprContext ctx, Value firstValue, Value secondValue, LineOrigin origin, int col){
        BiPredicate<Integer, Integer> predicate = (x, y) -> false;
        if (ctx.orderOp().GT() != null) predicate = (x, y) -> x > y;
        if (ctx.orderOp().LT() != null) predicate = (x, y) -> x < y;
        if (ctx.orderOp().GEQ() != null) predicate = (x, y) -> x >= y;
        if (ctx.orderOp().LEQ() != null) predicate = (x, y) -> x <= y;
        if (firstValue instanceof IntValue && secondValue instanceof IntValue) {
            return new BoolValue(predicate.test(((IntValue) firstValue).value, ((IntValue) secondValue).value));
        } else if (firstValue instanceof NoteValue && secondValue instanceof NoteValue) {
            return new BoolValue(predicate.test(NoteMap.notes.get(((NoteValue) firstValue).note), NoteMap.notes.get(((NoteValue) secondValue).note)));
        } else
            throw new ArithmeticOperationError("Incorrect type of comparison!", origin, col);
    }
}
