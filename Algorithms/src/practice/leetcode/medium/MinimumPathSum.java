package practice.leetcode.medium;

/**
 * @dp
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
 * the sum of all numbers along its path.
 *
 * intuitively think about dynamic programming:
 * dp[i][j] represents the minimum cost to the point (i,j)
 * initialize row 0 and col 0
 * scan through each point in the grid to get minimum, transition function:
 *   dp[i][j] = grid[i][j] + min(dp[i-1][j] dp[i][j-1])
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
        for (int j = 1; j < n; j++) dp[0][j] = dp[0][j - 1] + grid[0][j];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
