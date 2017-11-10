package Model;

import Model.ADT.Classes.MyDictionary;
import Model.ADT.Classes.MyFileReader;
import Model.ADT.Classes.MyList;
import Model.ADT.Classes.MyStack;
import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIList;
import Model.ADT.Interfaces.MyIStack;
import Model.Statement.IStmt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Integer> symTable;
    private MyIList<Integer> out;
    private MyIDictionary<Integer, MyFileReader> fileTable;
    private MyIDictionary<Integer, Integer> heap;
    private IStmt originalProgram;

    public PrgState(IStmt program){
        exeStack = new MyStack<>(new ArrayDeque<>());
        symTable = new MyDictionary<>(new HashMap<>());
        out = new MyList<>(new ArrayList<>());
        fileTable = new MyDictionary<>(new HashMap<>());
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

    public MyIDictionary<Integer, MyFileReader> getFileTable() { return fileTable; }

    public IStmt getOriginalProgram() {
        return originalProgram;
    }

    public MyIDictionary<Integer, Integer> getHeap() {
        return heap;
    }

    //TODO: setters for PrgState


    public void setOut(Integer number) {
        this.out.add(number);
    }

    @Override
    public String toString() {
        return "==============PrgState==============" +
                "\n==============exeStack==============\n" + exeStack +
                "\n==============symTable==============\n" + symTable +
                "\n==============out==============\n" + out +
                "\n==============FileTable==============\n" + fileTable +
                '\n';
    }
}
