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

        Nodo<HashNode<K,V>> NodoActual = getNodoInicialSegunKey(key);
        while(NodoActual!=null){
            if(NodoActual.getValue().getKey().compareTo(key) == 0){return NodoActual.getValue().getValue();}
            NodoActual=NodoActual.getSiguiente();
        }
        throw new KeyNotFoundException();


    }

    @Override
    public int size() {
        return this.size;
    }


    public boolean contains(K key) {
        Nodo<HashNode<K,V>> NodoActual = getNodoInicialSegunKey(key);
        while(NodoActual!=null){
            if(NodoActual.getValue().getKey().compareTo(key) == 0){return true;}
            NodoActual=NodoActual.getSiguiente();
        }
        return false;

    }

    @Override
    public void remove(K key) {
        HashNode<K,V> NodoARemover = new HashNode<>(key,null);
        hash[hashFun(key)].remove(NodoARemover);
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

    private Nodo<HashNode<K,V>> getNodoInicialSegunKey(K key) {
        return ((MyLinkedListimpl<HashNode<K,V>>)hash[hashFun(key)]).getPrimero();
    }
    
    
}
