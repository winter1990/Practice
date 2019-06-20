package practice.leetcode.medium;

/**
 * @array
 * @dp
 *
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate
 * between positive and negative.
 * The first difference (if one exists) may be either positive or negative.
 * A sequence with fewer than two elements is trivially a wiggle sequence.
 *
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 * A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence,
 * leaving the remaining elements in their original order.
 *
 * Input: [1,7,4,9,2,5]               Output: 6
 * Input: [1,17,5,10,13,15,10,5,16,8] Output: 7, There are several, One is [1,17,10,13,10,16,8].
 * Input: [1,2,3,4,5,6,7,8,9]         Output: 2
 *
 * we need to find the longest subsequence that inc, dec, inc... or start with dec
 * for each element in the array, there are three cases compared to previous element:
 *   larger
 *   smaller
 *   equal
 * to find the longest
 *   if increasing, then it depends on the length of decreasing in previous sub sequence
 *   if deceasing, it depends on the last increasing sub sequence
 *   so use dp array dp[n][2]
 *   as it depends only on the states in last loop, so two variables are enough
 * initial states
 *   inc = 1
 *   dec = 1
 * for i = [1,n-1]
 *   if larger, inc = dec + 1
 *   if smaller, dec = inc + 1
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, inc = 1, dec = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc = dec + 1;
            } else if (nums[i] < nums[i - 1]) {
                dec = inc + 1;
            }
        }
        return Math.max(inc, dec);
    }

    public int wiggleMaxLength1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[][] dp = new int[n][2]; // 0 inc, 1 dec
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i][0] = 1 + dp[i - 1][1];
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i] < nums[i - 1]) {
                dp[i][1] = 1 + dp[i - 1][0];
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
