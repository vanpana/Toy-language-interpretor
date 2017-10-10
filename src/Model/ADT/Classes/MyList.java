package Model.ADT.Classes;

import Model.ADT.Interfaces.MyIList;
import Model.Exceptions.ADTEmptyException;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyList<T> implements MyIList<T> {
    ArrayList<T> list;

    public MyList(ArrayList<T> lst) { list = lst; }

    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public T get(int index) throws ADTEmptyException {
        if (list.isEmpty()) throw new ADTEmptyException("List is empty");
        return list.get(index);
    }

    @Override
    public void remove(T el) throws ADTEmptyException {
        if (list.isEmpty()) throw new ADTEmptyException("List is empty");
        list.remove(el);
    }

    @Override
    public T remove(int index) throws ADTEmptyException {
        if (list.isEmpty()) throw new ADTEmptyException("List is empty");
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

    @Override
    public String toString() {
        return list.toString();
    }
}
