package practice.leetcode.medium;

import java.util.*;

public class InsertDeleteGetRandom {
}

/**
 * @design
 *
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements.
 * Each element must have the same probability of being returned.
 *
 * all operations should be O(1)
 * as we do not know the total size or how many times we want to execute the operations, use dynamic size ds - list, set
 * insert to the ds if not exists -> set, with constant lookup time, remove is ok for set as well, but not O(1) for get
 *
 * we need index based data structure
 * Insert to list is ok, just check whether contains in list
 * remove -> need another map number-index, when insert, just put into map
 * but when remove, how we can update the index in map, can we shift all the element?
 * then it would not be O(1)
 * when we call remove(), we firstly swap with the last element at last and remove the last element in list
 * also need to update the index of swapped element
 * at last, update the map -> remove entry
 */

class RandomizedSet {

    /** Initialize your data structure here. */
    List<Integer> list;
    Map<Integer, Integer> map;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        Collections.swap(list, index, list.size() - 1);
        map.put(list.get(index), index);
        map.remove(list.get(list.size() - 1));
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}