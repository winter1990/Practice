package practice.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @array
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 *
 * for each number in the given array, to form a consecutive sequence:
 *   the target values in rest of array: a[i]+1 or a[i]-1
 * for quick look up the values in the array, use set to store
 * for each value
 *   keep searching left
 *   keep searching right
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int res = 1;
        for (int n : nums) {
            if (!set.contains(n)) continue;
            int count = 1, l = n - 1, r = n + 1;
            while (set.contains(l)) {
                set.remove(l);
                count++;
                l--;
            }
            while (set.contains(r)) {
                set.remove(r);
                count++;
                r++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
