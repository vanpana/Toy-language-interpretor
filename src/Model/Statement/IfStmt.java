package Model.Statement;

import Model.ADT.Interfaces.MyIStack;
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

    public PrgState execute(PrgState state){
        MyIStack<IStmt> stack = state.getStack();
        int val = expression.eval(state.getSymTable());

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
