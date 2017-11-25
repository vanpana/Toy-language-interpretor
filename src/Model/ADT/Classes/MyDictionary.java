package Model.ADT.Classes;

import Model.ADT.Interfaces.MyIDictionary;
import Model.Exceptions.ADTEmptyException;

import java.util.*;

public class MyDictionary<K, V> implements MyIDictionary<K,V> {
    private HashMap<K, V> dict;

    public MyDictionary(HashMap<K, V> map) {
        dict = map;
    }

    @Override
    public void put(K key, V value) {
        dict.put(key, value);
    }

    @Override
    public V get(K key) throws ADTEmptyException {
        if (dict.isEmpty()) throw new ADTEmptyException("Dict is empty");
        return dict.get(key);
    }

    @Override
    public List<V> values() {
        //TODO: if (dict.isEmpty()) throw new ADTEmptyException("Dict is empty");
        return new ArrayList<>(dict.values());
    }

    @Override
    public boolean isDefined(K key) throws ADTEmptyException {
        if (dict.isEmpty()) throw new ADTEmptyException("Dict is empty");
        return dict.get(key) != null;
    }

    @Override
    public void setContent(HashMap<K, V> map) {
        dict = map;
    }

    @Override
    public void remove(K key) throws ADTEmptyException {
        if (dict.isEmpty()) throw new ADTEmptyException("Dict is empty");
        dict.remove(key);
    }

    @Override
    public MyIDictionary<K, V> cloneMap() {
        MyIDictionary<K,V> cloned = new MyDictionary<>(new HashMap<>());
        for (K key : dict.keySet())
            cloned.put(key, dict.get(key));
        return cloned;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySey() {
        return dict.entrySet();
    }

    @Override
    public HashMap<K, V> getContent() {
        return dict;
    }

    @Override
    public String toString() {
        return dict.toString();
    }
}
