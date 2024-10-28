package hashtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public abstract class HashTable<K, V> {

    protected HashNode<K, V>[] table;
    protected int capacity;
    protected int size;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new HashNode[capacity];
        this.size = 0;
    }

    protected abstract int hash(K key);

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> head = table[index];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = table[index];
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        table[index] = newNode;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> head = table[index];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void loadFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                K key = (K) line.trim();
                put(key, null);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> head = table[index];
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if (head == null) return null;
        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            table[index] = head.next;
        }
        return head.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Índice " + i + ": ");
            HashNode<K, V> head = table[i];
            while (head != null) {
                System.out.print("[" + head.key + "] - ");
                head = head.next;
            }
            System.out.println();
        }
    }
}
