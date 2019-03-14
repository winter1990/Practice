package practice.leetcode.medium;

/**
 * @dp
 *
 * 2 4 1 5 6
 * 3 4 4 3 5
 * 5 5 3 4 1
 * 8 7 6 2 3
 * the best path is 1 3 3 2 -> 9
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) dp[0][j] = A[0][j];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j + 1]), dp[i - 1][j - 1]);
                }
                dp[i][j] += A[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = dp[m - 1][j] < min ? dp[m - 1][j] : min;
        }
        return min;
    }
}