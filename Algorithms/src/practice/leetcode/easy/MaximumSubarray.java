package practice.leetcode.easy;

/**
 * @array
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the
 * largest sum and return its sum.
 *
 * [-2,1,-3,4,-1,2,1,-5,4] => 6 ([4,-1,2,1])
 *
 * problems to solve:
 * 1. if all positive, then trivial. what is the effect of negative values?
 * 2. corner case - what if all negative
 *
 * use two variables to track current sum and max sum
 * cur = 0, max = MIN_VALUE
 * for each number
 *   cur += num
 *   update max(max, cur)
 *   if cur < 0, reset it to 0
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int n : nums) {
            cur += n;
            max = Math.max(max, cur);
            if (cur < 0) cur = 0;
        }
        return max;
    }

    public int maxSubArr(int[] a) {
        int cur = a[0], max = a[0];
        for (int i = 1; i < a.length; i++) {
            cur = Math.max(cur + a[i], a[i]);
            max = Math.max(max, cur);
        }
        return max;
    }
}
