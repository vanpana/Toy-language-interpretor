package Model.Statement;

import Model.Exceptions.ToyException;
import Model.Expression.Expr;
import Model.PrgState;

public class AssignStmt implements IStmt {
    private String id;
    private Expr expression;

    public AssignStmt(String id, Expr expression) {
        this.id = id;
        this.expression = expression;
    }

    public PrgState execute(PrgState state) throws ToyException {
        int val;
        try {
            val = expression.eval(state.getSymTable(), state.getHeap());
        }
        catch (ToyException e)
        {
            throw new ToyException(e.getMessage());
        }
        state.getSymTable().put(id, val);
        return null;
    }

    @Override
    public String toString() {
        return id + " = " + expression.toString();
    }
}
