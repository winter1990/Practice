package practice.leetcode.medium;

/**
 * @array
 * @search
 * @dp
 *
 * [['0','E','0','0'],
 *  ['E','0','W','E'],
 *  ['0','E','0','0']]
 * Output: 3. place bomb at [1 2]
 *
 * intuition:
 * for each cell, if it is 0, search in 4 directions until hit the boundary or a wall
 *
 * optimization:
 * for each element in the sam row, count once is enough because before hitting a wall, the row remains the same
 * only need to store the column in a dp array
 * for each element in the grid, get number of row first
 * when reset: j = 0 or j - 1 is wall
 */
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, max = 0, row = 0;
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') continue;
                if (j == 0 || grid[i][j - 1] == 'W') row = getEnemiesInTheRow(grid, i, j, n);
                if (i == 0 || grid[i - 1][j] == 'W') col[j] = getEnemiesInTheCol(grid, i, j, m);
                if (grid[i][j] == '0') max = Math.max(max, row + col[j]);
            }
        }
        return max;
    }

    private int getEnemiesInTheCol(char[][] grid, int i, int j, int m) {
        int count = 0;
        while (i < m && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') count++;
            i++;
        }
        return count;
    }

    private int getEnemiesInTheRow(char[][] grid, int i, int j, int n) {
        int count = 0;
        while (j < n && grid[i][j] != 'W') {
            if (grid[i][j] == 'E') count++;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] cs = new char[][]{
                {'0','E','0','0','E'},
                {'E','0','W','E','W'},
                {'0','E','0','0','E'},
                {'0','E','0','E','E'}};
        BombEnemy bb = new BombEnemy();
        System.out.println(bb.maxKilledEnemies(cs));
    }

    public int maxKilledEnemies1(char[][] grid) {
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
