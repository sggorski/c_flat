package pl.edu.agh.visitorActions;

import pl.edu.agh.Melody;
import pl.edu.agh.MusicParser;
import pl.edu.agh.errors.ScopeError;
import pl.edu.agh.errors.ValueError;
import pl.edu.agh.musicUtils.Effect;
import pl.edu.agh.utils.*;

import java.util.HashMap;

public class PauseStatement {

    /**
     * Pauses the execution for a specified duration.
     * The duration can be provided directly as an integer value or through a variable lookup.
     * If the variable is not defined or is not of type INT, an appropriate error is thrown.
     * Uses Thread.sleep to introduce the pause.
     */
    public static void pause(MusicParser.PauseStatementContext ctx, Melody melody, Scope currentScope,
                             HashMap<String,VarInfo> globalScope, LineOrigin origin, int col, IntValue pace){
        try {

            int sleep = 0;
            if (ctx.INT_VAL() != null) sleep = Integer.parseInt(ctx.INT_VAL().getText());
            else if (ctx.ID() != null) {
                if (melody == null) throw new RuntimeException("Stack is empty!");
                VarInfo var;
                String varName = ctx.ID().getText();
                var = VisitorUtils.findVar(varName, ctx.parent(),melody,currentScope,globalScope,origin,col);
                if (var == null)
                    throw new ScopeError("Variable not defined: " + varName,origin,col);
                if (var.type != Type.INT)
                    throw new ValueError("Incorrect type of variable: " + varName + "Type " + var.type + "not int",origin,col);
                IntValue varInt = (IntValue) var.valueObj;
                sleep = varInt.value;
            }
            sleep = (60000 / pace.value ) * sleep / 100;
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
