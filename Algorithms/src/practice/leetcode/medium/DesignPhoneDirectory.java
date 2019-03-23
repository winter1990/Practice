package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @design
 *
 * Design a Phone Directory which supports the following operations:
 * get: Provide a number which is not assigned to anyone.
 * check: Check if a number is available or not.
 * release: Recycle or release a number.
 *
 */
public class DesignPhoneDirectory {
}

class PhoneDirectory {

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    int max;
    Set<Integer> set;
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        set = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++) set.add(i);
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (set.isEmpty()) return -1;
        int n = set.iterator().next();
        set.remove(n);
        return n;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return set.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number < max) set.add(number);
    }
}