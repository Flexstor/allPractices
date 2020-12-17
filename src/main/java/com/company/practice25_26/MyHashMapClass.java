package com.company.practice25_26;

import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMapClass<K, V> implements HashMapInterface<K, V> {
    private ArrayList<ArrayList<Item<K, V>>> hashMap;
    private final int hashMapSize = 16;

    public MyHashMapClass() {
        hashMap = new ArrayList<>();
        for (int i = 0; i < hashMapSize; i++) {
            hashMap.add(new ArrayList<>());
        }
    }

    private int hashFunction(K key) {
        return key.hashCode() % hashMapSize;
    }

    @Override
    public void add(K key, V value) {
        boolean keyRepeat = false;
        int index = hashFunction(key);
        if (hashMap.get(index).size() == 0) {
            hashMap.get(index).add(new Item<>(key, value));
        } else {
            for (int i = 0; i < hashMap.get(index).size(); i++) {
                if (hashMap.get(index).get(i).getKey().equals(key)) {
                    hashMap.get(index).set(i, new Item<>(key, value));
                    keyRepeat = true;
                    break;
                }
            }
            if (keyRepeat == false) {
                hashMap.get(index).add(new Item<>(key, value));
            }
        }
    }

    @Override
    public V get(K key) {
        int index = hashFunction(key);
        for (int i = 0; i < hashMap.get(index).size(); i++) {
            if (hashMap.get(index).get(i).getKey().equals(key)) {
                return hashMap.get(index).get(i).getValue();
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunction(key);
        for (int i = 0; i < hashMap.get(index).size(); i++) {
            if (hashMap.get(index).get(i).getKey().equals(key)) {
                Object temp = hashMap.get(index).get(i).getValue();
                hashMap.get(index).remove(hashMap.get(index).get(i));
                return (V) temp;
            }
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return new ValueIterator<V>();
    }

    private class ValueIterator<V> implements Iterator<V> {
        private int currentIndex = 0;
        private int currentArray = 0;

        @Override
        public boolean hasNext() {
            if(currentIndex == hashMap.get(currentArray).size()) {
                currentIndex = 0;
                currentArray++;
                while (currentArray < hashMapSize && hashMap.get(currentArray).size() == 0) {
                    currentArray++;
                }
            }
            return currentArray < hashMapSize;
        }

        @Override
        public V next() {
            return (V) hashMap.get(currentArray).get(currentIndex++).getValue();
        }
    }
}
