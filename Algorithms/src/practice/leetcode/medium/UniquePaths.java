package practice.leetcode.medium;

/**
 * @dp
 *
 * for each cell in the grid, the number of ways to reach the current cell depends on left and up cells
 * use a dp array [n][n] to track the number of ways to reach the cell (i, j)
 * dp[i][j] represents number of ways to get the cell (i,j)
 *
 * initial status of the grid:
 * for row and column 0, there is only one way
 *
 * transition function:
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1], i=[1,m-1] and j=[1,n-1]
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
        return dp[m - 1][n - 1];
    }
}
