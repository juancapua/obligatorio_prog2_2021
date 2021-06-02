package Tads;

public class CloseHashImpl<K, V> implements MyHash<K, V> {

    private static int LINEAL_COLLISION_FUNCTION = 1;

    private HashNode<K, V>[] hashTable;

    private int size;

    private int defaultCollisionFunction = CloseHashImpl.LINEAL_COLLISION_FUNCTION;

    public CloseHashImpl(int size) {
        this.hashTable = new HashNode[size];
    }

    public void put(K key, V value) {
        int attempt = 0;
        int position = internalHashcodeWithCollision(key, attempt);

        HashNode<K, V> valueToInsert = new HashNode<>(key, value);

        while (hashTable[position] != null &&
                !hashTable[position].isRemoved() &&
                !hashTable[position].getKey().equals(key) &&
                !(attempt > hashTable.length)) {

            attempt++;
            position = internalHashcodeWithCollision(key, attempt);

        }

        if (attempt > hashTable.length) {

            throw new RuntimeException("No se encontro lugar disponible");
        }

        if (hashTable[position] == null || hashTable[position].isRemoved()) {

            hashTable[position] = valueToInsert;

        } else { // Si sale por aca es porque ya existe un elemento en la clave con lo que hay que sustituir el valor

            hashTable[position].setValue(value);
        }

        size++;
    }

    public V get(K key) {
        int attempt = 0;
        int position = internalHashcodeWithCollision(key, attempt);
        V valueToReturn = null;

        while (hashTable[position] != null &&
                !hashTable[position].getKey().equals(key) &&
                !(attempt > hashTable.length)) {

            attempt++;
            position = internalHashcodeWithCollision(key, attempt);

        }

        if (hashTable[position] != null &&
                !(attempt > hashTable.length) &&
                hashTable[position].getKey().equals(key) &&
                !hashTable[position].isRemoved()) {

            valueToReturn = hashTable[position].getValue();

        }

        return valueToReturn;
    }


    public int size() {
        return this.size;
    }

    public void remove(K key) {
        int attempt = 0;
        int position = internalHashcodeWithCollision(key, attempt);

        while(hashTable[position] != null &&
                !hashTable[position].getKey().equals(key) &&
                !(attempt > hashTable.length)) {

            attempt++;
            position = internalHashcodeWithCollision(key, attempt);

        }

        if (hashTable[position] != null &&
                !(attempt > hashTable.length) &&
                hashTable[position].getKey().equals(key) &&
                !hashTable[position].isRemoved()) {

            hashTable[position].setRemoved(true);
        }

    }

    private int internalHashcodeWithCollision(K key, int attempt) {
        return (key.hashCode() + collisionFunction(attempt)) % hashTable.length;
    }

    private int collisionFunction(int i) {
        int value = 0;

        if (defaultCollisionFunction == LINEAL_COLLISION_FUNCTION) {

            value = i;

        }

        return value;
    }
}
