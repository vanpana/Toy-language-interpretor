package Model.Statement;

import Model.ADT.Interfaces.MyIStack;
import Model.Exceptions.ToyException;
import Model.Expression.Expr;
import Model.PrgState;

public class IfStmt implements IStmt{
    private final Expr expression;
    private final IStmt thenS;
    private final IStmt elseS;

    public IfStmt(Expr e, IStmt then, IStmt els){
        expression = e;
        thenS = then;
        elseS = els;
    }

    public PrgState execute(PrgState state) throws ToyException{
        MyIStack<IStmt> stack = state.getStack();
        int val;
        try {
            val = expression.eval(state.getSymTable(), state.getHeap());
        }
        catch (ToyException e){
            throw new ToyException(e.getMessage());
        }

        if (val != 0) stack.push(thenS);
        else stack.push(elseS);
        return null;
    }

    @Override
    public String toString() {
        return "if(" + expression.toString() +
                ") then " +
                thenS.toString() + " else " +
                elseS.toString();
    }
}
