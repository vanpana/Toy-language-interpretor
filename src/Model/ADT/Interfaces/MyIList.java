package Model.ADT.Interfaces;

import java.util.ArrayList;

public interface MyIList<T> {
    void add(T item);
    T get(int index);
    void remove(T el);
    T remove(int index);
    int size();
    ArrayList<T> getItems();
    //override toString
}
