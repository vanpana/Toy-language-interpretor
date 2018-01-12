package Model.ADT.Interfaces;

import Model.Exceptions.ADTEmptyException;

import java.util.ArrayDeque;
import java.util.ArrayList;

public interface MyIStack<T> {
    T pop() throws ADTEmptyException;
    void push(T item);
    boolean isEmpty();
    String toString();
    ArrayDeque<T> getStack();
}
