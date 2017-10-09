package Model.ADT.Interfaces;

import java.util.Deque;

public interface MyIStack<T> {
    T pop();
    void push(T item);
    String toString();
}
