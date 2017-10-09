package Model.ADT.Interfaces;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public interface MyIDictionary<K, V> {
    void put(K key, V value);
    V get(K key);
    List<V> values();
    List<K> keys();
    void remove(K key);
    boolean isDefined(K key);
    MyIDictionary<K, V> clone();
    HashMap<K, V> getItems();
    String toString();
}
