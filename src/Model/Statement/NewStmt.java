package Model.Statement;

import Model.Exceptions.ToyException;
import Model.Expression.Expr;
import Model.PrgState;

public class NewStmt implements IStmt{
    private static int location = 1;
    private final String var_name;
    private final Expr expr;

    public NewStmt(String var_name, Expr expr) {
        this.var_name = var_name;
        this.expr = expr;
    }

    @Override
    public PrgState execute(PrgState state) throws ToyException {
        int res = this.expr.eval(state.getSymTable(), state.getHeap());
        state.getHeap().put(location, res);
        state.getSymTable().put(var_name, location++);
        return null;
    }

    @Override
    public String toString() {
        return "new(" + var_name + " = " + expr + ")";
    }
}
