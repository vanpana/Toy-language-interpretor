package Model.Statement;

import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIStack;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.ExpressionException;
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
        MyIStack<IStmt> stack = state.getStack();
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        int val = 0;
        try {
            val = expression.eval(symTable);
        }
        catch (ToyException e)
        {
            throw new ToyException(e.getMessage());
        }
//        if (symTable.isDefined(id)) symTable.put(id, val);
//        else symTable.add(id, val);
        symTable.put(id, val);
        return state;
    }

    @Override
    public String toString() {
        return id + " = " + expression.toString();
    }
}
