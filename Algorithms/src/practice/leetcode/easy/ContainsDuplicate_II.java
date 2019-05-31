package practice.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @array
 * @slidingwindow
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * method 1
 * use a hash map to store the index of last occurrence
 * for each n
 *   if exists in map, check difference
 *   if not exists, put n and index in map
 * O(N), O(N)
 *
 * method 2
 * sliding window
 * fix the window size - k+1 elements
 * keep track of the numbers within the window - set
 * move the window by 1 each time, check if new element exists in the set
 * O(N), O(K)
 */
public class ContainsDuplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
