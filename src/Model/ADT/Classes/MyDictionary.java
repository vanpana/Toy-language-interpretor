package Model.ADT.Classes;

import Model.ADT.Interfaces.MyIDictionary;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class MyDictionary<K, V> implements MyIDictionary<K,V> {
    private HashMap<K, V> dict;

    public MyDictionary() {
        dict = new HashMap<>();
    }

    @Override
    public void put(K key, V value) {
        dict.put(key, value);
    }

    @Override
    public V get(K key) {
        return dict.get(key);
    }

    @Override
    public List<V> values() {
        return new ArrayList<>(dict.values());
    }

    @Override
    public List<K> keys() {
        return new ArrayList<>(dict.keySet());
    }

    @Override
    public void remove(K key) {
        dict.remove(key);
    }

    @Override
    public MyIDictionary<K, V> clone() {
        MyIDictionary<K, V> newdict = new MyDictionary<>();

        for (K key: dict.keySet())
            newdict.put(key, dict.get(key));

        return newdict;
    }

    @Override
    public HashMap<K, V> getItems() {
        return dict;
    }
}
