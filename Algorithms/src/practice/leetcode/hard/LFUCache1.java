package practice.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache1 {
    int min = -1;
    int capacity;
    Map<Integer, Integer> map;
    Map<Integer, Integer> freq;
    Map<Integer, LinkedHashSet<Integer>> list;
    public LFUCache1(int capacity) {
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
        int f = freq.get(key);
        freq.put(key, freq.get(key) + 1);
        list.get(f).remove(key);
        if (f == min && list.get(f).size() == 0) {
            min++;
        }
        if (!list.containsKey(f + 1)) {
            list.put(f + 1, new LinkedHashSet<>());
        }
        list.get(f + 1).add(key);
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
            int elementToRemove = list.get(min).iterator().next();
            list.get(min).remove(elementToRemove);
            map.remove(elementToRemove);
            freq.remove(elementToRemove);
        }
        min = 1;
        map.put(key,value);
        freq.put(key, 1);
        list.get(min).add(key);
    }

    public static void main(String[] args) {
        LFUCache1 l = new LFUCache1(2);
        l.put(1,1);
        l.put(2,2);
        System.out.println(l.get(1));
        l.put(3,3);
        System.out.println(l.get(2));
        System.out.println(l.get(3));
    }
}
