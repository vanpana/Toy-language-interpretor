package Model.Statement;

import Model.Exceptions.HeapException;
import Model.Exceptions.ToyException;
import Model.Expression.Expr;
import Model.PrgState;

public class HeapWritingStmt implements IStmt {
    private String var_name;
    private Expr expr;

    public HeapWritingStmt(String var_name, Expr expr) {
        this.var_name = var_name;
        this.expr = expr;
    }

    @Override
    public PrgState execute(PrgState state) throws ToyException {
        try{
            int location = state.getSymTable().get(var_name);
            if (state.getHeap().isDefined(location))
                state.getHeap().put(location, expr.eval(state.getSymTable(), state.getHeap()));
            else throw new HeapException("Value is not found!");
            return null;
        }
        catch (ToyException e){
            throw new HeapException(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Write " + expr + " to " + var_name + " on heap";
    }
}
