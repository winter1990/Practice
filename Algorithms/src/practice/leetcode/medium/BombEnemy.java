package practice.leetcode.medium;

/**
 * @array
 * @dp
 *
 * scan from left to right and right to left
 * scan from top to bottom and bottom to top
 */
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            int cnt = 0;
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'E') {
                    cnt++;
                } else if (grid[i][j] == '0') {
                    dp[i][j] = cnt;
                } else {
                    cnt = 0;
                }
            }
            cnt = 0;
            for (int j = col - 1; j >= 0; j--) {
                if (grid[i][j] == 'E') {
                    cnt++;
                } else if (grid[i][j] == '0') {
                    dp[i][j] += cnt;
                } else {
                    cnt = 0;
                }
            }
        }

        for (int j = 0; j < col; j++) {
            int cnt = 0;
            for (int i = 0; i < row; i++) {
                if (grid[i][j] == 'E') {
                    cnt++;
                } else if (grid[i][j] == '0') {
                    dp[i][j] += cnt;
                } else {
                    cnt = 0;
                }
            }
            cnt = 0;
            for (int i = row - 1; i >= 0; i--) {
                if (grid[i][j] == 'E') {
                    cnt++;
                } else if (grid[i][j] == '0') {
                    dp[i][j] += cnt;
                    max = Math.max(max, dp[i][j]);
                } else {
                    cnt = 0;
                }
            }
        }
        return max;
    }
}
