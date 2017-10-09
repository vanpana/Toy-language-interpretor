package Model.Statement;

import Model.ADT.Interfaces.MyIList;
import Model.Expression.Expr;
import Model.PrgState;

public class PrintStmt implements IStmt {
    private Expr expression;

    public PrintStmt(Expr expr){ expression = expr; }

    public PrgState execute(PrgState state){
        //state.getOut().add(expression.eval(state.getSymTable()));
        state.setOut(expression.eval(state.getSymTable()));
        return state;
    }

    @Override
    public String toString() {
        return "print(" + expression.toString() + ")";
    }
}
