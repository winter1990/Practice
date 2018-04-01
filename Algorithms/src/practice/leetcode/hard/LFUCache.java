package practice.leetcode.hard;

import java.util.*;

public class LFUCache {
    int capacity;
    Map<Integer, Integer> map; // key value
    Map<Integer, Integer> freq;
    Map<Integer, LinkedHashSet<Integer>> list;
    int min = -1;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freq = new HashMap<>();
        list = new HashMap<>();
        list.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int frequency = freq.get(key);
        freq.put(key, frequency + 1);
        list.get(frequency).remove(key);
        if (frequency == min && list.get(frequency).size() == 0) {
            min++;
        }
        if (!list.containsKey(frequency + 1)) {
            list.put(frequency + 1, new LinkedHashSet<>());
        }
        list.get(frequency + 1).add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (map.containsKey(key)) {
            map.put(key, value);
            get(key);
            return;
        }
        if (map.size() == capacity) {
            int evict = list.get(min).iterator().next();
            list.get(min).remove(evict);
            map.remove(evict);
        }
        map.put(key, value);
        freq.put(key, 1);
        min = 1;
        list.get(min).add(key);
    }
}