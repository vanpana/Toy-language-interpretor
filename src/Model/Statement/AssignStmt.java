package Model.Statement;

public class AssignStmt implements IStmt {
    String id;
    Expr expression;

    //override toString
    PrgState execute(PrgState state){
        MyIStack<IStmt> stack = state.getStack();
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        int val = exp.eval(symTable);
        if (symTable.isDefined(id)) symTable.update(id, val);
        else symTable.add(id, val);
        return state;
    }
}
