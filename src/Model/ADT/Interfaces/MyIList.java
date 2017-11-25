package Model.ADT.Interfaces;

import Model.Exceptions.ADTEmptyException;

public interface MyIList<T> {
    void add(T item);
    T get(int index) throws ADTEmptyException;
    int size();
    String toString();
}
