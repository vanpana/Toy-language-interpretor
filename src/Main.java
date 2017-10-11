import Controller.Controller;
import Model.ADT.Classes.MyList;
import Model.Exceptions.MyStmtExecException;
import Model.Expression.ArithExpr;
import Model.Expression.ConstExpr;
import Model.Expression.Operation;
import Model.Expression.VarExpr;
import Model.PrgState;
import Model.Statement.*;
import Repository.IRepository;
import Repository.Repository;
import View.Console;

import java.util.ArrayList;

public class Main {
    private static MyList<IStmt> getStatements()
    {
        IStmt ex1 = new CompStmt(new AssignStmt("v", new ConstExpr(2)),
                new PrintStmt(new VarExpr("v")));

        IStmt ex2 =  new CompStmt(new AssignStmt("a", new ArithExpr(Operation.PLUS, new ConstExpr(2), new
                ArithExpr(Operation.MULTIPLY, new ConstExpr(3), new ConstExpr(5)))),
                new CompStmt(new AssignStmt("b", new ArithExpr(Operation.PLUS, new VarExpr("a"), new
                        ConstExpr(1))), new PrintStmt(new VarExpr("b"))));

        IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExpr(Operation.MINUS,new ConstExpr(2), new ConstExpr(2))),
                new CompStmt(new IfStmt(new VarExpr("a"),new AssignStmt("v",new ConstExpr(2)),
                        new AssignStmt("v", new ConstExpr(3))), new PrintStmt(new VarExpr("v"))));

        MyList<IStmt> stmtlst = new MyList<>(new ArrayList<>());
        stmtlst.add(ex1);
        stmtlst.add(ex2);
        stmtlst.add(ex3);

        return stmtlst;
    }

    public static void main(String[] args){
        System.out.println("Hello World!");

        IRepository repo = new Repository();
        Controller ctrl = new Controller(repo);
        Console console = new Console(ctrl, getStatements());

        console.runApp();
    }
}