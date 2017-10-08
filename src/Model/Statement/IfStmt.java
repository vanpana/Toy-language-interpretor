package Model.Statement;

public class IfStmt implements IStmt{
    Expr expression;
    IStmt thenS;
    IStmt elseS;

    IfStmt(Expr e, IStmt then, IStmt els){
        expr = e;
        thenS = then;
        elseS = els;
    }

    //override toString

    PrgState execute(PrgState state){
        //execute
        return state;
    }
}
