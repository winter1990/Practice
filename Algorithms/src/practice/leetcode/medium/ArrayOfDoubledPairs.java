package practice.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @array
 * @hash
 *
 * Given an array of integers A with even length, return true if and only if it is possible to reorder it
 * such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
 *
 * an important feature: for a tree map The set's iterator returns the keys in ascending order.
 *
 * all numbers/elements in the array should be paired
 * to improve the look up time of the numbers in the array
 * use a map to store key is number, value can be indexes but freq is enough for this problem
 *
 * for each key in key set, if negative, target = value / 2 otherwise target = value * 2
 * look up the target in the map, if not exist in map or target freq < value freq, or negative % 2 != 0 then false
 * then update frequency in target key-val entry
 */
public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        for (int val : map.keySet()) {
            if (map.get(val) == 0) {
                continue;
            }
            int target = val < 0 ? val / 2 : val * 2;
            if ((val < 0 && val % 2 != 0) || (map.get(val) > map.getOrDefault(target, 0))) {
                return false;
            }
            map.put(target, map.get(target) - map.get(val));
        }
        return true;
    }
}
