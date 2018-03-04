package practice.leetcode.ez;

/**
 * [-2,1,-3,4,-1,2,1,-5,4] => 6 ([4,-1,2,1])
 *
 * dp works. but rethink
 *
 * can it be neg?
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            max = Math.max(max, cur);
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;
    }

    // divide and conquer solution?
}
