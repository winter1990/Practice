package practice.leetcode.medium;

/**
 * @array
 *
 * traverse the array and if see 1, then search the island
 * to avoid searching duplicate island
 *   mark the visited point as 0
 *   use another array to check if it is visited
 *
 * in recursive call
 *   base condition: if in range of the grid, mark as 0, return 1 + method() * 4 directions
 *   otherwise return 0
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) max = Math.max(max, findMax(grid, i, j, m, n));
            }
        }
        return max;
    }

    private int findMax(int[][] grid, int i, int j, int m, int n) {
        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + findMax(grid, i + 1, j, m, n) + findMax(grid, i - 1, j, m, n)
                    + findMax(grid, i, j + 1, m, n) + findMax(grid, i, j - 1, m, n);
        }
        return 0;
    }
}
