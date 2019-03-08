package practice.leetcode.hard;

import java.util.*;

/**
 * @design
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem,
 * when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * capacity for cache
 * get: key-value pair, both are integer, keep track of the frequency -> another map key-integer/freq
 * also need to keep track of the minimum frequency -> integer min
 * quick look up frequency->values, another map integer/freq-set<Integer>
 * further more, it's ordered, so linkedhashset. we can take advantage of getting the next(), which is the first element in set
 * put: set or insert, current capacity -> map size, capacity - initialized as n.
 *
 * get: not exist, return null. if exist 1. get and return the value - map; 2. check if min need to be updated
 * also need to update frequency map, and linkedhashset based on current. check exist or not
 *
 */
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

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        lfuCache.put(3,3);
    }
}