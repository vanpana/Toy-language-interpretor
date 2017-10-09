import Controller.Controller;
import Model.Exceptions.MyStmtExecException;
import Model.Expression.ArithExpr;
import Model.Expression.ConstExpr;
import Model.Expression.Operation;
import Model.Expression.VarExpr;
import Model.PrgState;
import Model.Statement.AssignStmt;
import Model.Statement.CompStmt;
import Model.Statement.IStmt;
import Model.Statement.PrintStmt;
import Repository.IRepository;
import Repository.Repository;

public class main {
    public static void main(String[] args){
        System.out.println("Hello World!");
        IStmt ex1 = new CompStmt(new AssignStmt("v", new ConstExpr(2)),
            new PrintStmt(new VarExpr("v")));

        IStmt ex2 =  new CompStmt(new AssignStmt("a", new ArithExpr(Operation.PLUS, new ConstExpr(2), new
                ArithExpr(Operation.MULTIPLY, new ConstExpr(3), new ConstExpr(5)))),
                new CompStmt(new AssignStmt("b", new ArithExpr(Operation.PLUS, new VarExpr("a"), new
                        ConstExpr(1))), new PrintStmt(new VarExpr("b"))));

        //PrgState prg = new PrgState(ex1);
        IRepository repo = new Repository();
        Controller ctrl = new Controller(repo);
        ctrl.setMain(new PrgState(ex2));
        try
        {
            ctrl.allSteps();
        }
        catch (MyStmtExecException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
