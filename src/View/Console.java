package View;

import Controller.*;
import Model.ADT.Classes.MyList;
import Model.Exceptions.MyStmtExecException;
import Model.PrgState;
import Model.Statement.IStmt;

import java.util.Scanner;

public class Console {
    Controller ctrl;
    MyList<IStmt> statements;

    public Console(Controller ctrl, MyList<IStmt> statements) {
        this.ctrl = ctrl;
        this.statements = statements;
    }

    private void printMenu(){
        System.out.println("\n=========Toy Language Interpretor=========");
        for (int i = 0; i < statements.size(); i++){
            System.out.println(String.format("%d: %s", i, statements.get(i).toString()));
        }
        System.out.println("-1: Exit.");
    }

    void loop(){
        Scanner scan = new Scanner(System.in);
        while (true){
            printMenu();
            System.out.print("Choose: ");
            int option = -1;
            if (scan.hasNextInt())  option = scan.nextInt();
            if (option == -1) break;
            if (option < statements.size()) {
                ctrl.setMain(new PrgState(statements.get(option)));
                try{
                    ctrl.allSteps();
                }
                catch (MyStmtExecException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        scan.close();
    }

    public void runApp() { loop(); }
}
