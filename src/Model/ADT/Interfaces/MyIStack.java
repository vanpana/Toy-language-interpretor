package Model.ADT.Interfaces;

import Model.Exceptions.ADTEmptyException;

public interface MyIStack<T> {
    T pop() throws ADTEmptyException;
    void push(T item);
    boolean isEmpty();
    String toString();
}
