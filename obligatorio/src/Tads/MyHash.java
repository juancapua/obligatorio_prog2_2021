package Tads;

public interface MyHash<K, V> {

    void put(K key, V value);

    V get(K key);

    int size();

    void remove(K key);
}