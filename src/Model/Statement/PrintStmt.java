package Model.Statement;

import Model.ADT.Interfaces.MyIList;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.ExpressionException;
import Model.Expression.Expr;
import Model.PrgState;

public class PrintStmt implements IStmt {
    private Expr expression;

    public PrintStmt(Expr expr){ expression = expr; }

    public PrgState execute(PrgState state) throws ExpressionException, ADTEmptyException{
        try {
            state.setOut(expression.eval(state.getSymTable()));
        }
        catch (ADTEmptyException e) { throw new ADTEmptyException(e.getMessage()); }
        catch (ExpressionException e) { throw new ExpressionException(e.getMessage()); }
        return state;
    }

    @Override
    public String toString() {
        return "print(" + expression.toString() + ")";
    }
}
