package Model.ADT.Interfaces;

import Model.Exceptions.ADTEmptyException;

import java.util.ArrayList;

public interface MyIList<T> {
    void add(T item);
    T get(int index) throws ADTEmptyException;
    void remove(T el) throws ADTEmptyException;
    T remove(int index) throws ADTEmptyException;
    int size();
    ArrayList<T> getItems();
    String toString();
}
