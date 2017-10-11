package Model.Statement;

import Model.ADT.Interfaces.MyIList;
import Model.Exceptions.ExpressionException;
import Model.Expression.Expr;
import Model.PrgState;

public class PrintStmt implements IStmt {
    private Expr expression;

    public PrintStmt(Expr expr){ expression = expr; }

    public PrgState execute(PrgState state) throws ExpressionException{
        try {
            state.setOut(expression.eval(state.getSymTable()));
        }
        catch (ExpressionException e) { throw new ExpressionException(e.getMessage()); }
        return state;
    }

    @Override
    public String toString() {
        return "print(" + expression.toString() + ")";
    }
}
