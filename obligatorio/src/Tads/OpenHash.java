package Tads;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Math.abs;

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
        for (HashNode<K,V> nodo:hash[hashFun(key)]){
            if (nodo.getKey().equals(key)){return nodo.getValue();}
        }
        throw new KeyNotFoundException();


    }

    @Override
    public int size() {
        return this.size;
    }


    public boolean contains(K key) {
        if (hash[hashFun(key)]==null){return false;}
        for (HashNode<K,V> nodo:hash[hashFun(key)]){
            if (nodo.getKey().equals(key)){return true;}
        }
        return false;

    }

    @Override
    public void remove(K key) {
        HashNode<K,V> NodoARemover = new HashNode<>(key,null);
        hash[hashFun(key)].remove(NodoARemover);
    }

    public int hashFun(K key) {

        return abs(key.hashCode() % size);
    }

    public int getSize() {
        return size;
    }

    public MyList<HashNode<K, V>> getTodos(K key) {
        return this.hash[hashFun(key)];
    }


    private class IteradorHash implements Iterator<V> {
        private int n=size;
        private int i=0;
        private MyList<HashNode<K,V>> lista;

        public IteradorHash(){
            lista=new MyLinkedListimpl<>();
        }


        @Override
        public boolean hasNext() {
            if (lista.size()>i+1){return true;}
            else if(n<=0){return false;}
            else{
                while(n>0&&hash[n-1]==null){n--;}
                return n>0;
            }
        }

        @Override
        public V next() {
            V ret;
            if (lista.size()>i+1){
                ret=lista.get(++i).getValue();
            }
            else {
                lista=hash[--n];
                i=0;
                ret=lista.get(0).getValue();
            }
            return ret;
        }

    }
    @Override
    public Iterator<V> iterator() {
        return new OpenHash.IteradorHash();
    }
}
