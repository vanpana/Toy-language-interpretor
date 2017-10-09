package Model.Statement;

import Model.Expression.Expr;
import Model.PrgState;

public class PrintStmt implements IStmt {
    private Expr expression;

    //override toString
    public PrgState execute(PrgState state){
        //Todo Print something
        return state;
    }
}
