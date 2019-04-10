package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose
 * sum equals to k.
 *
 * [1 3 2 -1 4 -2 6] target = 4, [1 3] [3 2 -1] [4] [-2 6]
 *  1 4 6  5 9 7 13
 * 1. sum up previous elements
 * 2. use a map to track sum, and frequency
 * 3. for new element lookup target-currentsum in map
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        int[] in = {0,0,0,0};
        int k = 0;
        System.out.println(s.subarraySum(in, k));
    }
}