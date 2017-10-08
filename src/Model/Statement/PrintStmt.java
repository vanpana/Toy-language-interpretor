package Model.Statement;

public class PrintStmt implements IStmt {
    Expr expression;

    //override toString
    PrgState execute(PrgState state){
        //do something
        return state;
    }
}
