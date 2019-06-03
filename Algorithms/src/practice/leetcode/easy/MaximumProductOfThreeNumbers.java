package practice.leetcode.easy;

import java.util.Arrays;

/**
 * @array
 *
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * all scenarios:
 *   3 positive                 3 largest (+)
 *   2 positive + 1 negative    1 largest (+) 2 smallest (-)
 *   1 positive + 2 negative    1 largest (+) 2 smallest (-)
 *   3 negative                 3 largest (-)
 * we sort the array
 * get the maximum between a[n-1] * a[n-2] * a[n-3] and a[n-1] * a[0] * a[1]
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }
}
