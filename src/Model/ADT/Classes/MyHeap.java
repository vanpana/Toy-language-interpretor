package Model.ADT.Classes;

import Model.ADT.Interfaces.MyIHeap;
import Model.Exceptions.ADTEmptyException;

import java.util.*;

public class MyHeap<V> implements MyIHeap<V>{
    private Map<Integer, V> dict;

    public MyHeap(HashMap<Integer, V> map) {
        dict = map;
    }

    @Override
    public void put(Integer key, V value) {
        dict.put(key, value);
    }

    @Override
    public V get(Integer key) throws ADTEmptyException {
        if (dict.isEmpty()) throw new ADTEmptyException("Dict is empty");
        return dict.get(key);
    }

    @Override
    public Set<Integer> keys() {
        return dict.keySet();
    }

    @Override
    public List<V> values() throws ADTEmptyException {
        //TODO: if (dict.isEmpty()) throw new ADTEmptyException("Dict is empty");
        return new ArrayList<>(dict.values());
    }

    @Override
    public Map<Integer, V> getItems() {
        return dict;
    }

    @Override
    public boolean isDefined(Integer key) throws ADTEmptyException {
        if (dict.isEmpty()) throw new ADTEmptyException("Dict is empty");
        return dict.get(key) != null;
    }

    @Override
    public void setContent(HashMap<Integer, V> map) {
        dict = map;
    }

    @Override
    public void remove(Integer key) throws ADTEmptyException {
        if (dict.isEmpty()) throw new ADTEmptyException("Dict is empty");
        dict.remove(key);
    }

    @Override
    public Set entrySet() {
        return dict.entrySet();
    }

    @Override
    public Map<Integer, V> getContent() {
        return dict;
    }

    @Override
    public String toString() {
        return dict.toString();
    }
}
