package practice.leetcode.medium;

/**
 * @search
 *
 * dfs
 *
 * problems to solve:
 * 1. dfs the whole component
 * 2. mark the edge of the components as new color
 * 3. inner components not changed
 */
public class ColoringABorder {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length, n = grid[0].length, oldColor = grid[r0][c0];
        boolean[][] visited = new boolean[m][n];
        dfs(grid, r0, c0, m, n, oldColor, color, visited);
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (visited[i][j] && visited[i - 1][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i][j - 1]) {
                    grid[i][j] = oldColor;
                }
            }
        }
        return grid;
    }

    private void dfs(int[][] grid, int i, int j, int m, int n, int oldColor, int color, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] != oldColor) return;
        visited[i][j] = true;
        grid[i][j] = color;
        dfs(grid, i + 1, j, m, n, oldColor, color, visited);
        dfs(grid, i - 1, j, m, n, oldColor, color, visited);
        dfs(grid, i, j + 1, m, n, oldColor, color, visited);
        dfs(grid, i, j - 1, m, n, oldColor, color, visited);
    }
}