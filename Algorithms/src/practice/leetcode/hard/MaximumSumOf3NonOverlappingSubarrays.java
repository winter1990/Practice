package practice.leetcode.hard;

/**
 * @array
 * @dp
 *
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
 * Return the result as a list of indices representing the starting position of each interval (0-indexed).
 * If there are multiple answers, return the lexicographically smallest one.
 *
 * calculate preSum[n+1], preSum[i] represents the sum of first i elements
 * use a dp[][] to track the maximum sum
 * dp[i][j] represents the maximum sum of i subarrays by j, exclusive
 *   i = [1, k]
 *     j = [i * k, n] - k elements
 *       get sum = dp[i - 1][j - k] + pre[j] - pre[j-k]
 *       if the current sum is bigger than dp[i][j-1] - update dp[i][j] and update start
 *       else dp[i][j] = dp[i][j-1], position array pos[i][j] = pos[i][j-1]
 *
 */
public class MaximumSumOf3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < k * 3) return new int[]{};
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) preSum[i] = preSum[i - 1] + nums[i - 1];
        int[][] dp = new int[4][n + 1], pos = new int[4][n + 1];
        for (int i = 1; i <= 3; i++) {
            for (int j = i * k; j <= n; j++) {
                int curSum = preSum[j] - preSum[j - k] + dp[i - 1][j - k];
                if (curSum > dp[i][j - 1]) {
                    dp[i][j] = curSum;
                    pos[i][j] = j - k;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    pos[i][j] = pos[i][j - 1];
                }
            }
        }
        int[] res = new int[3];
        int index = n;
        for (int i = 2; i >= 0; i--) {
            res[i] = pos[i + 1][index];
            index = res[i];
        }
        return res;
    }
}
