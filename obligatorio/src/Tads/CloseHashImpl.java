package Tads;

import java.util.Iterator;

public class CloseHashImpl<K extends Comparable<K>, V> implements MyHash<K, V> {

    private int size;
    private HashNode<K, V>[] hash;
    private int mod;
    private ColissionManagement config;

    public CloseHashImpl(int size, int mod, ColissionManagement config) {
        this.size = size;
        hash = new HashNode[size];
        this.mod = mod;
        this.config = config;
    }

    public void put(K key, V data) {

        int pos = hashFun(key);

        int counter = 0;

        boolean isFull = false;

        if (hash[pos] == null) {

            hash[pos] = new HashNode<K, V>(key, data, false);

        } else if (hash[pos].isRemoved() == true) {

            hash[pos].setKey(key);
            hash[pos].setValue(data);
            hash[pos].setRemoved(false);

        } else {

            int j = 0;

            while (hash[pos] != null && hash[pos].isRemoved() == false && !isFull) {


                counter++;

                if (counter == size) isFull = true;

                pos = nuevaColision(pos, j);
            }

            if (hash[pos] == null) {

                hash[pos] = new HashNode<K, V>(key, data, false);

            } else {

                hash[pos].setKey(key);
                hash[pos].setValue(data);
                hash[pos].setRemoved(false);

            }
        }
    }

    public V get(K key) throws KeyNotFoundException {

        int posIni = hashFun(key);

        int pos = hashFun(key);

        int j = 0;

        if (hash[pos] == null) throw new KeyNotFoundException();

        else if (hash[pos].getKey().compareTo(key) == 0) return hash[pos].getValue();

        else {

            pos = nuevaColision(pos, j);

            while (hash[pos] != null && pos != posIni && hash[pos].getKey().compareTo(key) != 0) {

                pos = nuevaColision(pos, j);

            }

            if (hash[pos] == null || pos == posIni) throw new KeyNotFoundException();

            return hash[pos].getValue();

        }
    }

    @Override
    public int size() {
        return this.size;
    }

    public int nuevaColision(int pos, int j) {

        switch (config) {
            case LINEAR:
                pos = funcionLineal(pos) % size;
                break;

            case QUAD:
                j++;
                pos = funcionCuadratica(pos, j) % size;
                break;

            case CUBIC:
                j++;
                pos = funcionCubica(pos, j) % size;
                break;

        }

        return pos;

    }

    private int funcionLineal(int pos) {
        return pos + 1;
    }

    private int funcionCuadratica(int pos, int j) {
        return pos + (int) Math.pow(j, 2);
    }

    private int funcionCubica(int pos, int j) {
        return pos + (int) Math.pow(j, 3);
    }

    public boolean contains(K key) {

        int posIni = hashFun(key);

        int pos = hashFun(key);

        int j = 0;

        if (hash[pos] != null && hash[pos].getKey().compareTo(key) != 0) {

            pos = nuevaColision(pos, j);

        } else return hash[pos] != null;

        do {

            pos = nuevaColision(pos, j);

        } while (hash[pos] != null && pos != posIni && hash[pos].getKey().compareTo(key) != 0);

        return hash[pos] != null && pos != posIni;


    }

    private HashNode<K, V> get2(K key) throws KeyNotFoundException {

        int posIni = hashFun(key);

        int pos = hashFun(key);

        int j = 0;

        if (hash[pos] == null) throw new KeyNotFoundException();

        else if (hash[pos].getKey().compareTo(key) == 0) return hash[pos];

        else {

            pos = nuevaColision(pos, j);

            while (hash[pos] != null && pos != posIni && hash[pos].getKey().compareTo(key) != 0) {

                pos = nuevaColision(pos, j);

            }

            if (hash[pos] == null || pos == posIni) throw new KeyNotFoundException();

            return hash[pos];

        }
    }

    public void remove(K key) throws KeyNotFoundException {

        get2(key).setRemoved(true);

    }

    public int hashFun(K key) {
        return key.hashCode() % mod;
    }

    public HashNode<K, V>[] getHash() {
        return hash;
    }

    @Override
    public Iterator<V> iterator() {
        return null;
    }
}
