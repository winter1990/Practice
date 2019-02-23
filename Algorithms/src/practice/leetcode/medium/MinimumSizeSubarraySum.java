package practice.leetcode.medium;
/**
 * @array
 * @slidingwindow
 * @pointers
 *
 * given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
 *
 * window size is not fixed, but sum is given, we need to find the smallest window size that sum of all numbers inside
 *
 * two pointers: i, j and sum
 * initially, window size is MAX
 * i from 1 to n - 2
 * j slides between 0, and n - 1
 * sum += a[j]
 * if sum >= target, update the window size, and then move 1 by one step? should keep moving until sum < target
 * if not found, check min window size at alst return 0 if MAX
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
