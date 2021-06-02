package Tads;

public class HashNode<K, V> {

    private K key;

    private V value;

    private boolean removed;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.removed = false;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public boolean equals(Object obj) {
        boolean equalsToReturn = false;

        equalsToReturn = ((K) obj).equals(this.key);

        return equalsToReturn;
    }
}
