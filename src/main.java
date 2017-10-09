import Controller.Controller;
import Model.Exceptions.MyStmtExecException;
import Model.Expression.ConstExpr;
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

        //PrgState prg = new PrgState(ex1);
        IRepository repo = new Repository();
        Controller ctrl = new Controller(repo);
        ctrl.setMain(new PrgState(ex1));
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
