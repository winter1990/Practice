package practice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums,
 * that has the same degree as nums.
 *
 * problems to solve:
 * 1. find the maximum frequency number(s) in the array
 * 2. find the minimum window that contains at least on maximum frequency number
 *
 * use a map to track the leftmost element and its index
 * use a map to track the frequency for each element
 * keep track of the max frequency
 * scan through the array
 *   put the element and its leftmost index
 *   update frequency
 *   if frequency is larger than max frequency, update the max frequency and length of array
 *   if same frequency as max, then get the shorter length of sub array
 */

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length, res = n, maxFreq = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!left.containsKey(nums[i])) left.put(nums[i], i);
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            if (freq.get(nums[i]) > maxFreq) {
                maxFreq = freq.get(nums[i]);
                res = i + 1 - left.get(nums[i]);
            } else if (maxFreq == freq.get(nums[i])) {
                res = Math.min(res, i - left.get(nums[i]) + 1);
            }
        }
        return res;
    }
}
