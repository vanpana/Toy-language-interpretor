package Model;

import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIList;
import Model.ADT.Interfaces.MyIStack;
import Model.Statement.IStmt;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Integer> symTable;
    private MyIList<Integer> out;
    private IStmt originalProgram;

    public PrgState(MyIStack<IStmt> stack, MyIDictionary<String, Integer> symTbl,
                    MyIList<Integer> outlist, IStmt program){
        exeStack = stack;
        symTable = symTbl;
        out = outlist;
        originalProgram = program;
        exeStack.push(program);
    }

    //getters
    public MyIStack<IStmt> getStack() {
        return exeStack;
    }

    public MyIDictionary<String, Integer> getSymTable() {
        return symTable;
    }

    public MyIList<Integer> getOut() {
        return out;
    }

    public IStmt getOriginalProgram() {
        return originalProgram;
    }


    //TODO: setters for PrgState

    //TODO: override PrgState toString

    @Override
    public String toString() {
        return "==============PrgState==============" +
                "\n==============exeStack==============\n" + exeStack +
                "\n==============symTable==============\n" + symTable +
                "\n==============out==============\n" + out +
                '\n';
    }
}
