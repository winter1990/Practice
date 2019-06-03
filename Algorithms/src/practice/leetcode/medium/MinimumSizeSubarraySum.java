package practice.leetcode.medium;
/**
 * @array
 * @slidingwindow
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous
 * subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 * translation:
 * find the minimum window size that the sum within the window is >= target value
 *
 * two pointers: i = 0, j = 0
 * keep track of the current sum
 * move right pointer j and add a[j] to sum until curSum >= s, update window
 * while (sum >= s) update window size and move left pointer i until sum < s
 *
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
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
