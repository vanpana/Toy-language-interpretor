package View;

import Controller.*;
import Model.ADT.Classes.MyList;
import Model.Exceptions.*;
import Model.PrgState;
import Model.Statement.IStmt;

import java.util.Scanner;

public class Console {
    private final Controller ctrl;
    private final MyList<IStmt> statements;

    public Console(Controller ctrl, MyList<IStmt> statements) {
        this.ctrl = ctrl;
        this.statements = statements;
    }

    private void printMenu(){
        System.out.println("\n=========Toy Language Interpretor=========");
        for (int i = 0; i < statements.size(); i++)
            try {
                System.out.println(String.format("%d: %s", i, statements.get(i).toString()));
            } catch (ADTEmptyException e) {
                System.out.println("No statements inserted!");
            }
        System.out.println("-1: Exit.");
    }

    private int getInteger(Scanner scan) throws BadInputException{
        try {
            return Integer.parseInt(scan.nextLine());
        }
        catch (NumberFormatException e){
            throw new BadInputException("Invalid integer: " + e.getMessage().replace("For input string: ", ""));
        }
    }

    private void loop(){
        Scanner scan = new Scanner(System.in);

        while (true){
            printMenu();
            System.out.print("Choose: ");
            int option;
            try {
                option = getInteger(scan);
                if (option == -1) break;
                if (option < statements.size()) {
                    try{
                        ctrl.setMain(new PrgState(statements.get(option)));
                        ctrl.allSteps();
                    }
                    catch (ToyException e) {
                        System.err.println(e.getMessage());
                    }

                }
                else System.out.println("Option not available... YET.");
            }
            catch (BadInputException e){
                System.out.println(e.getMessage());
            }
        }

        scan.close();
    }

    public void runApp() { loop(); }
}
