package Model.Statement;

public class CompStmt implements IStmt{
    IStmt first;
    IStmt second;
    PrgState execute(PrgState state){
        MyIStack<IStmt> stack = state.getStack();
        stack.push(second);
        stack.push(first);
        return state;
    }
}
