package hashtable;

public class HashTable1<K, V> extends HashTable<K, V> {


    public HashTable1(int capacity) {
        super(capacity);
    }

    @Override
    protected int hash(K key) {
        return Math.abs((key.hashCode() * 31) % capacity);
    }
}
