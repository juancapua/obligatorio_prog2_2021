package Tads;

public interface MyHash<K, V> {

    void put(K key, V value);

    V get(K key) throws KeyNotFoundException;

    int size();

    void remove(K key);
}