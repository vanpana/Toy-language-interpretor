package Model.Statement;

import Model.Expression.Expr;
import Model.PrgState;

public class IfStmt implements IStmt{
    private Expr expression;
    private IStmt thenS;
    private IStmt elseS;

    IfStmt(Expr e, IStmt then, IStmt els){
        expression = e;
        thenS = then;
        elseS = els;
    }

    //override toString

    public PrgState execute(PrgState state){
        //TODO: execute If Statement
        return state;
    }
}
