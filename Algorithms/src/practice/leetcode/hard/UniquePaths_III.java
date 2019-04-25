package practice.leetcode.hard;

/**
 * @array
 *
 * On a 2-dimensional grid, there are 4 types of squares:
 *   1 represents the starting square.  There is exactly one starting square.
 *   2 represents the ending square.  There is exactly one ending square.
 *   0 represents empty squares we can walk over.
 *   -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square,
 * that walk over every non-obstacle square exactly once.
 *
 * Input: [[1,0,0,0],
 *         [0,0,0,0],
 *         [0,0,2,-1]]
 * Output: 2
 *
 * Input: [[1,0,0,0],
 *         [0,0,0,0],
 *         [0,0,0,2]]
 * Output: 4
 *
 *
 */
public class UniquePaths_III {
    int m, n, sx, sy, ex, ey, count = 1, res = 0;
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (m == 0 || n == 0) return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                } else if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        dfs(grid, sx, sy);
        return res;
    }

    private void dfs(int[][] grid, int x, int y) {
        if (!valid(grid, x, y)) return;
        if (x == ex && y == ey) {
            if (count == 0) res++;
            return;
        }
        grid[x][y] = -2;
        count--;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        grid[x][y] = 0;
        count++;
    }

    private boolean valid(int[][] grid, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] >= 0;
    }
}
