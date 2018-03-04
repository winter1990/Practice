package practice.leetcode.medium;

/**
 * dp problem
 *
 * m*n dp grid
 * initialize row/col 0 to 1
 * go through grid
 * dp[i][j]=dp[i-1][j]+dp[i][j-1]
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        int i = 1;
        int j = 1;
        for (; i < m; i++) {
            for (; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][j - 1];
    }
}
