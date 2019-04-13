package practice.leetcode.easy;

import java.util.Arrays;

/**
 * all elements are in the range [-1000, 1000]
 *
 * 3 negative, 2 negative 1 pos, 1 negative 2 pos
 * if only 3 elements, no choice {-2 8 9} {-4 -2 1} {-4 -3 -2}
 * {-10 -9 3 6} {-10 1 2 3} {-3 -2 -1 x}
 *
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }
}
