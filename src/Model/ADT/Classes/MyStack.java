package Model.ADT.Classes;

import Model.ADT.Interfaces.MyIStack;
import Model.Exceptions.ADTEmptyException;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<T> implements MyIStack<T> {
    private ArrayDeque<T> stack;

    public MyStack(ArrayDeque<T> stk) { stack = stk; }
    @Override
    public T pop() throws ADTEmptyException {
        if (stack.isEmpty()) throw new ADTEmptyException("List is empty");
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
