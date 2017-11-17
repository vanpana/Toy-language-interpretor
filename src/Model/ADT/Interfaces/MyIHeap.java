package Model.ADT.Interfaces;

import Model.Exceptions.ADTEmptyException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MyIHeap<V> {
    void put(Integer key, V value);
    Set<Integer> keys();
    V get(Integer key) throws ADTEmptyException;
    List<V> values() throws ADTEmptyException;
    void remove(Integer key) throws ADTEmptyException;
    boolean isDefined(Integer key) throws ADTEmptyException;
    void setContent(HashMap<Integer, V> map);
    Map<Integer, V> getContent();
    Set entrySet();
    Map<Integer, V> getItems();
    String toString();
}
