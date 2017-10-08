package Model.ADT.Classes;

import Model.ADT.Interfaces.MyIList;

import java.util.ArrayList;

public class MyList<T> implements MyIList<T> {
    ArrayList<T> list;

    public MyList() { list = new ArrayList<>(); }

    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public void remove(T el) {
        list.remove(el);
    }

    @Override
    public T remove(int index) {
        return list.remove(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public ArrayList<T> getItems() {
        return list;
    }
}
