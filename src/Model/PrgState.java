package Model;

import Model.ADT.Classes.*;
import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIList;
import Model.ADT.Interfaces.MyIStack;
import Model.Exceptions.ToyException;
import Model.Statement.IStmt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class PrgState {
    private int id;
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Integer> symTable;
    private MyIList<Integer> out;
    private MyIDictionary<Integer, MyFileReader> fileTable;
    private MyHeap<Integer> heap;
    //private IStmt originalProgram;

    public PrgState(IStmt program){
        exeStack = new MyStack<>(new ArrayDeque<>());
        symTable = new MyDictionary<>(new HashMap<>());
        heap = new MyHeap<>(new HashMap<>());
        out = new MyList<>(new ArrayList<>());
        fileTable = new MyDictionary<>(new HashMap<>());
        //originalProgram = program;
        exeStack.push(program);
    }

    //getters

    public int getId() {
        return id;
    }

    public MyIList<Integer> getOut() {
        return out;
    }

    public MyIStack<IStmt> getStack() {
        return exeStack;
    }

    public MyIDictionary<String, Integer> getSymTable() {
        return symTable;
    }

    public MyIDictionary<Integer, MyFileReader> getFileTable() { return fileTable; }

    public MyHeap<Integer> getHeap() {
        return heap;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setSymTable(MyIDictionary<String, Integer> symTable) {
        this.symTable = symTable;
    }

    public void setOut(MyIList<Integer> out) {
        this.out = out;
    }

    public void setFileTable(MyIDictionary<Integer, MyFileReader> fileTable) {
        this.fileTable = fileTable;
    }

    public void setHeap(MyHeap<Integer> heap) {
        this.heap = heap;
    }

    public void setOut(Integer number) {
        this.out.add(number);
    }

    public boolean isNotCompleted() { return !exeStack.isEmpty(); }

    public PrgState oneStep() throws ToyException {
        if (exeStack.isEmpty()) throw new ToyException("Stack empty");
        IStmt currentStatement = exeStack.pop();
        return currentStatement.execute(this);
    }

    @Override
    public String toString() {
        return "==============PrgState: id = " + String.valueOf(id) + " ==============" +
                "\n==============exeStack==============\n" + exeStack +
                "\n==============symTable==============\n" + symTable +
                "\n==============heap==============\n" + heap +
                "\n==============out==============\n" + out +
                "\n==============FileTable==============\n" + fileTable +
                '\n';
    }
}
