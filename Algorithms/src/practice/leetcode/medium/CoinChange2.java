package practice.leetcode.medium;

/**
 * @knapsack
 * @dp
 *
 * You are given coins of different denominations and a total amount of money. Write a function to compute the
 * number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 *
 * dp[i][j] number of combinations that make up j using i types of coins
 * initial status
 *   0 ways to make 0
 * transition function
 *   two scenarios for ith coin
 *   1. not use ith coin - only use i-1 to make up j, number of combinations dp[i-1][j]
 *   2. use ith coin - we need to make up j-coins[i-1], dp[i][j-coins[i-1]]
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    // as it only replies on the previous loop, we can optimize it to 1d array
    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }
}
