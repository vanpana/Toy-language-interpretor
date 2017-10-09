package Model.Statement;

import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIStack;
import Model.Expression.Expr;
import Model.PrgState;

public class AssignStmt implements IStmt {
    private String id;
    private Expr expression;

    //override toString
    public PrgState execute(PrgState state){
        MyIStack<IStmt> stack = state.getStack();
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        int val = expression.eval(symTable);
//        if (symTable.isDefined(id)) symTable.put(id, val);
//        else symTable.add(id, val);
        symTable.put(id, val);
        return state;
    }
}
