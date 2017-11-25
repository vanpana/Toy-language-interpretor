package Model.Statement;

import Model.ADT.Interfaces.MyIStack;
import Model.Exceptions.ToyException;
import Model.Expression.Expr;
import Model.PrgState;

public class WhileStmt implements IStmt{
    private Expr expr;
    private IStmt stmt;

    public WhileStmt(Expr expr, IStmt stmt) {
        this.expr = expr;
        this.stmt = stmt;
    }

    @Override
    public PrgState execute(PrgState state) throws ToyException {
        if (expr.eval(state.getSymTable(), state.getHeap()) != 0) {
            state.getStack().push(this);
            state.getStack().push(stmt);
        }
        return null;
    }

    @Override
    public String toString() {
        return "While (" + this.expr.toString() + ") {" + this.stmt.toString() + "}";
    }
}
