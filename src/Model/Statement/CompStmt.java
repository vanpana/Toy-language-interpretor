package Model.Statement;

import Model.ADT.Interfaces.MyIStack;
import Model.PrgState;

public class CompStmt implements IStmt{
    private IStmt first;
    private IStmt second;

    public CompStmt(IStmt first, IStmt second) {
        this.first = first;
        this.second = second;
    }

    public PrgState execute(PrgState state){
        MyIStack<IStmt> stack = state.getStack();
        stack.push(second);
        stack.push(first);
        return state;
    }

    @Override
    public String toString() {
        return first.toString() + "; " + second.toString();
    }
}
