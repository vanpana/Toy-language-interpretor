package Model;

import Model.ADT.Classes.*;
import Model.ADT.Interfaces.MyIDictionary;
import Model.ADT.Interfaces.MyIList;
import Model.ADT.Interfaces.MyIStack;
import Model.Statement.IStmt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class PrgState {
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

    //TODO: setters for PrgState


    public void setOut(Integer number) {
        this.out.add(number);
    }

    @Override
    public String toString() {
        return "==============PrgState==============" +
                "\n==============exeStack==============\n" + exeStack +
                "\n==============symTable==============\n" + symTable +
                "\n==============heap==============\n" + heap +
                "\n==============out==============\n" + out +
                "\n==============FileTable==============\n" + fileTable +
                '\n';
    }
}
