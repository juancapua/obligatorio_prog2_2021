package Tads;

import java.util.ArrayList;


public class OpenHash<K extends Comparable<K>, V> implements MyHash<K, V>{

    private int size;
    private ArrayList<HashNode<K, V>>[] hash;

    public OpenHash(int size) {
        this.size = size;
        hash = new ArrayList[size];
    }

    @Override
    public void put(K key, V data) {

        int pos = hashFun(key);

        if (hash[pos] == null) {

            hash[pos] = new ArrayList<>(10);

            hash[pos].add(new HashNode<>(key, data));

        } else {

            hash[pos].add(new HashNode<>(key, data));

        }
    }


    @Override
    public V get(K key) throws KeyNotFoundException {

        for (HashNode<K, V> node : hash[hashFun(key)])
            if (node.getKey().compareTo(key) == 0) return node.getValue();

        throw new KeyNotFoundException();
    }

    @Override
    public int size() {
        return this.size;
    }


    public boolean contains(K key) {
        if (hash[hashFun(key)] != null)
            for (HashNode<K, V> node : hash[hashFun(key)])
                if (node.getKey().compareTo(key) == 0) return true;
        return false;

    }

    @Override
    public void remove(K key) {

        int pos = hashFun(key);

        int counter = 0;

        for (HashNode<K, V> node : hash[pos]) {

            if (node.getKey().compareTo(key) == 0) {

                hash[pos].remove(counter);

                break;

            }

            counter += 1;

        }
    }

    public int hashFun(K key) {
        int hashCode = 0;

        for (int i = 0; i < key.toString().length(); i++) {
            hashCode += key.toString().charAt(i);
        }

        return hashCode;
    }

    public ArrayList<HashNode<K, V>>[] getHash() {
        return this.hash;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<HashNode<K, V>> getTodos(K key) {
        return this.hash[hashFun(key)];
    }
    
    
}
