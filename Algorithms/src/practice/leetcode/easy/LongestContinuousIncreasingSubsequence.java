package practice.leetcode.easy;

/**
 * @array
 *
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * for each element, compare with next value, if increasing, count++
 * if non-increasing, count = 1
 * for each loop, update max
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length, max = 0, count = 1;
        if (n <= 1) return n;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
