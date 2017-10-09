package Model.ADT.Classes;

import Model.ADT.Interfaces.MyIStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<T> implements MyIStack<T> {
    Deque<T> stack;

    MyStack() { stack = new ArrayDeque<T>(); }
    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public void push(T item) {
        stack.push(item);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
