package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandom {
}


class RandomizedSet {

    /** Initialize your data structure here. */
    Set<Integer> set;
    public RandomizedSet() {
        set = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        } else {
            set.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int n = rand.nextInt(set.size()) + 1;

        Iterator<Integer> integerIterator = set.iterator();
        int res = 0;
        while (n-- > 0) {
            res = integerIterator.next();
        }
        return res;
    }
}