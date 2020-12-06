package com.company.practice25_26;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMapClass<K, V> implements HashMapInterface<K, V>, Iterator<V> {
    private LinkedList<Item<K, V>> map = new LinkedList<>();
    int currentIndex = 0;

    @Override
    public void add(K key, V value) {
        Item<K, V> item = new Item<>(key, value);
        boolean keyRepeat = false;
        if (map.size() == 0) {
            map.addFirst(item);
        }
        else {
            for (Item<K, V> i : map) {
                if (i.getKey().equals(key)) {
                    i.setValue(value);
                    keyRepeat = true;
                    break;
                }
            }
            if (keyRepeat == false) {
                map.add(item);
            }
        }
    }

    @Override
    public V get(K key) {
        for (Item<K, V> i : map) {
            if (i.getKey().equals(key))
                return i.getValue();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        map.removeIf(i -> (i.getKey().equals(key)));
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < map.size();
    }

    @Override
    public V next() {
        return map.get(currentIndex++).getValue();
    }
}
