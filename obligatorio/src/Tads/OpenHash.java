package Tads;

import java.util.ArrayList;


public class OpenHash<K extends Comparable<K>, V> implements MyHash<K, V>{

    private int size;
    private MyList<HashNode<K, V>>[] hash;

    public OpenHash(int size) {
        this.size = size;
        this.hash = new MyList[size];
    }

    @Override
    public void put(K key, V data) {

        int pos = hashFun(key);

        if (hash[pos] == null) {

            hash[pos] = new MyLinkedListimpl<>();

            hash[pos].add(new HashNode<>(key, data));

        } else {

            hash[pos].add(new HashNode<>(key, data));

        }
    }


    @Override
    public V get(K key) throws KeyNotFoundException{

        //Nodo<HashNode<K,V>>lista = hash[hashFun(key)].get(0);


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

        return key.hashCode() % size;
    }

    public MyList<HashNode<K, V>>[] getHash() {
        return this.hash;
    }

    public int getSize() {
        return size;
    }

    public MyList<HashNode<K, V>> getTodos(K key) {
        return this.hash[hashFun(key)];
    }
    
    
}
