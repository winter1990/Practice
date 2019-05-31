package practice.leetcode.medium;

import java.util.*;

/**
 * @array
 * @design
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *   insert(val): Inserts an item val to the set if not already present.
 *   remove(val): Removes an item val from the set if present.
 *   getRandom: Returns a random element from current set of elements.
 *     Each element must have the same probability of being returned.
 *
 * all operations should be O(1)
 *   insert()
 *     set, or list
 *   remove()
 *     set is O(1) to remove
 *     list remove() is O(n), so for remove(), we need to have index and value stored
 *     use a map to store value and its index in the list
 *     for a list, only removing the last element is O(1).
 *     otherwise, as it's array based, so removing causes shift all elements to left by 1, which is O(N)
 *     we can swap with the element at last, and remove it (update map)
 *   getRandom
 *     get any index based object in list is O(1)
 */
public class InsertDeleteGetRandom {
    class RandomizedSet {

        /** Initialize your data structure here. */
        List<Integer> list;
        Map<Integer, Integer> map;
        Random random;
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int index = map.get(val);
            Collections.swap(list, index, list.size() - 1);
            map.put(list.get(index), index);
            map.remove(list.get(list.size() - 1));
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }
}