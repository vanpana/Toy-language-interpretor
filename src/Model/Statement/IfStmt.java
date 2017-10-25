package Model.Statement;

import Model.ADT.Interfaces.MyIStack;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.DivisionByZero;
import Model.Exceptions.ExpressionException;
import Model.Exceptions.ToyException;
import Model.Expression.Expr;
import Model.PrgState;

public class IfStmt implements IStmt{
    private Expr expression;
    private IStmt thenS;
    private IStmt elseS;

    public IfStmt(Expr e, IStmt then, IStmt els){
        expression = e;
        thenS = then;
        elseS = els;
    }

    public PrgState execute(PrgState state) throws ToyException{
        MyIStack<IStmt> stack = state.getStack();
        int val = 0;
        try {
            val = expression.eval(state.getSymTable());
        }
        catch (ToyException e){
            throw new ToyException(e.getMessage());
        }

        if (val != 0) stack.push(thenS);
        else stack.push(elseS);
        return state;
    }

    @Override
    public String toString() {
        return "if(" + expression.toString() +
                ") then " +
                thenS.toString() + " else " +
                elseS.toString();
    }
}
