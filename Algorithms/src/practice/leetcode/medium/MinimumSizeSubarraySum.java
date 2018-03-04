package practice.leetcode.medium;
/*
given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
 */

/**
 * sliding window thinking
 * two pointers:i,j and sum
 * j[0,len-1]
 *  sum+=a[j]
 *  if sum>=target,getmin(min,j-i+1), while should be used
 * if not found,return 0
 *  define window size MAX
 *  check size MAX
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = 0, sum = 0, window = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= s) {
                window = Math.min(window, j - i + 1);
                sum -= nums[i++];
            }
            j++;
        }
        return window == Integer.MAX_VALUE ? 0 : window;
    }
}
