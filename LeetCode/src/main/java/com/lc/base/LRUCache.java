package com.lc.base;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chh
 * @date 2022/3/20 19:34
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {


    private int capacity;
    
    public LRUCache(int capacity) {
        // accessOrder默认为false，若为true则会将最近读取过的元素放在链表尾部
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
