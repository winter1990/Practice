package practice.leetcode.ez;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, findMax(grid, i, j));
                }
            }
        }
        return max;
    }

    private int findMax(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + findMax(grid, i + 1, j) + findMax(grid, i - 1, j) + findMax(grid, i, j + 1) + findMax(grid, i, j - 1);
        }
        return 0;
    }
}
