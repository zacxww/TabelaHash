package hashtable;

public class HashTable2<K,V> extends HashTable<K,V> {


    public HashTable2(int capacity) {
        super(capacity);
    }

    @Override
    protected int hash(K key) {
        String keyString = key.toString();
        int hashValue = 0;
        int prime = 37;
        for (int i = 0; i < keyString.length(); i++) {
            hashValue = (prime * hashValue + keyString.charAt(i)) % capacity;
        }
        return Math.abs(hashValue);
    }
}