package Model.ADT.Interfaces;

import Model.Exceptions.ADTEmptyException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MyIDictionary<K, V> {
    void put(K key, V value);
    V get(K key) throws ADTEmptyException;
    List<V> values() throws ADTEmptyException;
//    List<K> keys() throws ADTEmptyException;
    void remove(K key) throws ADTEmptyException;
    boolean isDefined(K key) throws ADTEmptyException;
//    MyIDictionary<K, V> clone();
//    HashMap<K, V> getItems();
    void setContent(HashMap<K, V> map);
    HashMap<K, V> getContent();
    Set<Map.Entry<K,V>> entrySey();
    MyIDictionary<K,V> cloneMap();
    String toString();
}
