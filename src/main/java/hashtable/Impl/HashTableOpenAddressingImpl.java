package hashtable.Impl;


import hashtable.Impl.openAddressing.HashNode;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by yuehu on 7/1/19.
 */
public class HashTableOpenAddressingImpl<K,V> implements IHashTable<K,V> {
    private HashNode[] hashNodes;

    private int capacity;

    private int size;

    public HashTableOpenAddressingImpl() {
        this.capacity = 5;
        hashNodes = new HashNode[capacity];
    }

    public HashTableOpenAddressingImpl(int capacity) {
        this.capacity = capacity;
        hashNodes = new HashNode[capacity];
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    @Override
    public void put(K key, V val) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V delete(K key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {

    }
    public static void main(String[] args) {

    }

}

