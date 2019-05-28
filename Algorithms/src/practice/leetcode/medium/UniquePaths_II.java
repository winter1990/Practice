package practice.leetcode.medium;

/**
 * @dp
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * the impact of obstacle - cannot step on it, so the path to the obstacle is 0
 *
 * use dp[m][n] to track number of paths to the cell
 * dp[i][j] represents total number of paths to the cell (i,j)
 * initial status
 *   row 0 and column 0, if obstacle, then value = 0, next value = previous
 * transition function
 *   dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */
public class UniquePaths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 0) dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                continue;
            }
            dp[i][0] = dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
                continue;
            }
            dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
