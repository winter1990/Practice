package practice.leetcode.hard;

import java.util.*;

/**
 * @array
 *
 * Design a data structure that supports all following operations in average O(1) time.
 * Note: Duplicate elements are allowed.
 *   insert(val): Inserts an item val to the collection.
 *   remove(val): Removes an item val from the collection if present.
 *   getRandom: Returns a random element from current collection of elements.
 *     The probability of each element being returned is linearly related to the number of same value the
 *     collection contains.
 *
 * problems to solve:
 * 1. O(1) to insert, remove, and get random
 * 2. randomization
 *
 * insert()
 *   list O(1)
 * remove
 *   map - value, list of indices
 *   swap with the last element and update index
 * getRandom()
 *   get list
 */
public class InsertDeleteGetRandomDuplicatesAllowed {

    public static void main(String[] args) {
        RandomizedCollection r = new RandomizedCollection();
        r.insert(0);
        r.remove(0);
        r.insert(-1);
        r.remove(0);
    }
    static class RandomizedCollection {
        Random rand;
        List<Integer> list;
        Map<Integer, Set<Integer>> map;
        public RandomizedCollection() {
            rand = new Random();
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            list.add(val);
            boolean isExist = map.containsKey(val);
            if (!isExist) map.put(val, new HashSet<>());
            map.get(val).add(list.size() - 1);
            return !isExist;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            if (map.get(val).size() == 0) return false;
            int index = map.get(val).iterator().next();
            map.get(val).remove(index);
            if (index != list.size() - 1) {
                int last = list.get(list.size() - 1);
                list.set(index, last);
                map.get(last).remove(list.size() - 1);
                map.get(last).add(index);
            }
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int i = rand.nextInt(list.size());
            return list.get(i);
        }
    }
}
