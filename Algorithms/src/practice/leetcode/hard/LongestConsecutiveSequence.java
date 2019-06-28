package practice.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
 * for quick look up the values in the array, use set to store all values in array
 * for each value
 *   keep searching left, update count and remove element
 *   keep searching right, update count and remove element
 *   compare and update the max length
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        int max = 1;
        for (int i : nums) {
            if (set.contains(i)) {
                int count = 1;
                int left = i - 1;
                int right = i + 1;
                while (set.contains(left)) {
                    count++;
                    set.remove(left);
                    left--;
                }
                while (set.contains(right)) {
                    count++;
                    set.remove(right);
                    right++;
                }
                set.remove(i);
                max = Math.max(count, max);
            }
        }
        return max;
    }

    /**
     * optimization
     */
    public static int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i : nums) {
            if (!map.containsKey(i)) {
                int l = map.containsKey(i - 1) ? map.get(i - 1) : 0;
                int r = map.containsKey(i + 1) ? map.get(i + 1) : 0;
                int cur = l + 1 + r;
                map.put(i, cur);
                max = Math.max(max, cur);
                map.put(i - l, cur);
                map.put(i + r, cur);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] in = {3,1,2,2,2};
        System.out.println(longestConsecutive1(in));
    }
}
