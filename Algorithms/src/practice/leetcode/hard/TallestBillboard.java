package practice.leetcode.hard;

import java.util.Arrays;

/**
 * @knapsack
 *
 * the problem is translated to:
 * divide the numbers into two groups. maximize the sum
 *
 * calculate sum, and divide by 2. so we get the tallest possible height (ideally)
 * two an array to keep track of the sum
 *
 * dp[i][j] represents
 *   using i rods
 *   the difference of left and right group is j
 *   j = [-sum, +sum]
 *   so the size of dp is [n+1][2*sum+1]
 *
 * i = [1,n] - using i rods
 *
 */
public class TallestBillboard {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int sum = 0;
        for (int r : rods) sum += r;
        int[][] dp = new int[n + 1][2 * sum + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);
        dp[0][sum] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (j >= rods[i - 1] && dp[i - 1][j - rods[i - 1]] != - 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - rods[i - 1]] + rods[i - 1]);
                }
                if (j + rods[i - 1] <= 2 * sum && dp[i - 1][j + rods[i - 1]] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + rods[i - 1]]);
                }
                if (dp[i - 1][j] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
            }
        }
        return dp[n][sum];
    }
}
