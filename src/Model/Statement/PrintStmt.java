package Model.Statement;

import Model.Exceptions.ToyException;
import Model.Expression.Expr;
import Model.PrgState;

public class PrintStmt implements IStmt {
    private Expr expression;

    public PrintStmt(Expr expr){ expression = expr; }

    public PrgState execute(PrgState state) throws ToyException{
        try {
            state.setOut(expression.eval(state.getSymTable(), state.getHeap()));
        }
        catch (ToyException e) { throw new ToyException(e.getMessage()); }
        return state;
    }

    @Override
    public String toString() {
        return "print(" + expression.toString() + ")";
    }
}
