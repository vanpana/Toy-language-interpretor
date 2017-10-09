package Model.Statement;

import Model.ADT.Interfaces.MyIStack;
import Model.PrgState;

public class CompStmt implements IStmt{
    private IStmt first;
    private IStmt second;
    public PrgState execute(PrgState state){
        MyIStack<IStmt> stack = state.getStack();
        stack.push(second);
        stack.push(first);
        return state;
    }
}