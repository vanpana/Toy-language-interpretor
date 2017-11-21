import Controller.Controller;
import Model.ADT.Classes.MyList;
import Model.Expression.*;
import Model.Statement.*;
import Repository.IRepository;
import Repository.Repository;
import View.Console;

import java.util.ArrayList;

import static Model.Expression.Operation.MULTIPLY;
import static Model.Expression.Operation.PLUS;

public class Main {
    private static MyList<IStmt> getStatements() {
        IStmt ex1 = new CompStmt(new AssignStmt("v", new ConstExpr(2)),
                new PrintStmt(new VarExpr("v")));

        IStmt ex2 =  new CompStmt(new AssignStmt("a", new ArithExpr(PLUS, new ConstExpr(2), new
                ArithExpr(Operation.MULTIPLY, new ConstExpr(3), new ConstExpr(5)))),
                new CompStmt(new AssignStmt("b", new ArithExpr(PLUS, new VarExpr("a"), new
                        ConstExpr(1))), new PrintStmt(new VarExpr("b"))));

        IStmt ex3 = new CompStmt(new AssignStmt("a", new ArithExpr(Operation.MINUS,new ConstExpr(2), new ConstExpr(2))),
                new CompStmt(new IfStmt(new VarExpr("a"),new AssignStmt("v",new ConstExpr(2)),
                        new AssignStmt("v", new ConstExpr(3))), new PrintStmt(new VarExpr("v"))));


        IStmt ex4 = new CompStmt(
                new openRFile("var_f", "test.in"),
                new CompStmt(
                    new CompStmt(
                            new readFile(new VarExpr("var_f"), "var_c"),
                            new PrintStmt(new VarExpr("var_c"))),
                    new CompStmt(
                            new IfStmt(new VarExpr("var_c"),
                                    new CompStmt( //then
                                            new readFile(new VarExpr("var_f"), "var_c"),
                                            new PrintStmt(new VarExpr("var_c"))),
                                    new PrintStmt(new ConstExpr(1)) //else
                                    ),
                            new closeRFile(new VarExpr("var_f"))
                    )

        )
        );

//        v=10; new(v,20); new(a,22); wH(a,30); print(a); print(rH(a));a=0
        IStmt ex5 = new CompStmt(
                new AssignStmt("v", new ConstExpr(10)),
                new CompStmt(
                        new NewStmt("v", new ConstExpr(20)),
                        new CompStmt(
                                new NewStmt("a", new ConstExpr(22)),
                                new CompStmt(
                                        new HeapWritingStmt("a", new ConstExpr(30)),
                                        new CompStmt(
                                                new PrintStmt(new VarExpr("a")),
                                                new CompStmt(
                                                        new PrintStmt(new HeapReadingExpr("a")),
                                                        new AssignStmt("a", new ConstExpr(0))
                                                )
                                        )
                                )
                        )
                )
        );

//        10 + (2<6) evaluates to 11

        IStmt ex6 = new CompStmt(
                new AssignStmt("sum", new ArithExpr(
                        Operation.PLUS,
                        new ConstExpr(10),
                        new BoolExpr(new ConstExpr(2), new ConstExpr(6), "<"))),
                new PrintStmt(new VarExpr("sum")));

//        v=6; (while (v-4) print(v);v=v-1);print(v)
        IStmt ex7 = new CompStmt(
                new AssignStmt("v", new ConstExpr(6)),
                new CompStmt(
                        new WhileStmt(new ArithExpr(Operation.MINUS, new VarExpr("v"), new ConstExpr(4)),
                                new CompStmt(new PrintStmt(new VarExpr("v")),
                                        new AssignStmt("v", new ArithExpr(Operation.MINUS, new VarExpr("v"), new ConstExpr(1))))),
                                new PrintStmt(new VarExpr("v"))
                )
        );

        MyList<IStmt> stmtlst = new MyList<>(new ArrayList<>());
        stmtlst.add(ex1);
        stmtlst.add(ex2);
        stmtlst.add(ex3);
        stmtlst.add(ex4);
        stmtlst.add(ex5);
        stmtlst.add(ex6);
        stmtlst.add(ex7);


        return stmtlst;
    }

    public static void main(String[] args){
        IRepository repo = new Repository("log.txt");
        Controller ctrl = new Controller(repo);
        Console console = new Console(ctrl, getStatements());

        console.runApp();
    }
}
