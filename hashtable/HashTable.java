package hashtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class HashTable<K, V> {

    protected HashNode<K, V>[] tabela;
    protected int capacidade;
    protected int tamanho;

    public HashTable(int capacity) {
        this.capacidade = capacity;
        this.tabela = new HashNode[capacity];
        this.tamanho = 0;
    }

    protected abstract int hash(K key);

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> head = tabela[index];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        tamanho++;
        head = tabela[index];
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        tabela[index] = newNode;
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> head = tabela[index];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void lerTXT(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                K key = (K) line.trim();
                put(key, null);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> head = tabela[index];
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if (head == null) return null;
        tamanho--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            tabela[index] = head.next;
        }
        return head.value;
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public void display() {
        for (int i = 0; i < capacidade; i++) {
            System.out.print(i + ": ");
            HashNode<K, V> head = tabela[i];
            while (head != null) {
                System.out.print("[" + head.key + "] - ");
                head = head.next;
            }
            System.out.println();
        }
    }
}
