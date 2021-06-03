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
        int intentos = 0;
        int position = internalHashcodeWithCollision(key, intentos);

        HashNode<K, V> valueToInsert = new HashNode<>(key, value);

        while (hashTable[position] != null &&
                !hashTable[position].isRemoved() &&
                !hashTable[position].getKey().equals(key) &&
                !(intentos > hashTable.length)) {

            intentos++;
            position = internalHashcodeWithCollision(key, intentos);

        }

        if (intentos > hashTable.length) {

            throw new RuntimeException("No se encontro lugar disponible");
        }

        if (hashTable[position] == null || hashTable[position].isRemoved()) {

            hashTable[position] = valueToInsert;

        } else {

            hashTable[position].setValue(value);
        }

        size++;
    }

    public V get(K key) {
        int intentos = 0;
        int position = internalHashcodeWithCollision(key, intentos);
        V valueToReturn = null;

        while (hashTable[position] != null &&
                !hashTable[position].getKey().equals(key) &&
                !(intentos > hashTable.length)) {

            intentos++;
            position = internalHashcodeWithCollision(key, intentos);

        }

        if (hashTable[position] != null &&
                !(intentos > hashTable.length) &&
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
        int intentos = 0;
        int position = internalHashcodeWithCollision(key, intentos);

        while(hashTable[position] != null &&
                !hashTable[position].getKey().equals(key) &&
                !(intentos > hashTable.length)) {

            intentos++;
            position = internalHashcodeWithCollision(key, intentos);

        }

        if (hashTable[position] != null &&
                !(intentos > hashTable.length) &&
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
