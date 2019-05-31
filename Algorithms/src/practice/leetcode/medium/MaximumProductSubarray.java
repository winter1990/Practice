package practice.leetcode.medium;


/**
 * @array
 * @math
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 * which has the largest product
 * [2, 3, -2, 4] -> 6
 * [-1 1 -2 2] -> 4
 * [-2 2 4 0 3] -> 24
 *
 * positive, zero, negative
 * the target is contiguous subarray
 * we want as many positive numbers as possible and even number of negatives
 * all positive is trivial, need to handle the negatives
 * keep track both max and min of the product, because:
 *   the max may become smaller by multiplying (-)
 *   the min may become largest by multiplying (-)
 *
 * how to determine the start point of subarray [-2 2 3 -1 0 13]
 *   when getting the max and min, also compare with the current element
 *   we have min and max, both = a[0]
 *   for each element, get current max and current min
 *     max = max(cur max, cur min) and a[i]
 *     min = min(cur max, cur min) and a[i]
 *
 * the thinking is really similar to the dynamic programming
 * current status (in this problem - value) is depending on the previous two status (min and max)
 * the transition function is:
 *   if current value is positive, then the previous smallest becomes smaller
 *   if current value is negative, then the previous smallest becomes largest
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curMax = max * nums[i];
            int curMin = min * nums[i];
            max = Math.max(Math.max(curMax, curMin), nums[i]);
            min = Math.min(Math.min(curMax, curMin), nums[i]);
            if (max > res) res = max;
        }
        return res;
    }
}
