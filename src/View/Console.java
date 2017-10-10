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
        System.out.println("=========Toy Language Interpretor=========");
        for (int i = 0; i < statements.size(); i++){
            System.out.println(String.format("%d: %s", i, statements.get(i).toString()));
        }
    }

    void loop(){

        while (true){
            Scanner scan = new Scanner(System.in);
            printMenu();
            System.out.print("Choose: ");
            int option = -1;
            if (scan.hasNextInt())  option = scan.nextInt();
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
            scan.close();
        }
    }

    public void runApp() { loop(); }
}
