package practice.leetcode.easy;

/**
 * @math
 *
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * Return the total area of all three projections.
 *
 *
 */
public class ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    count++;
                }
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        int res = 0;
        res += count;
        for (int i = 0; i < m; i++) res += row[i];
        for (int j = 0; j < n; j++) res += col[j];
        return res;
    }

    public int projectionArea1(int[][] grid) {
        int res = 0, n = grid.length;
        for (int i = 0; i < n; ++i) {
            int x = 0, y = 0;
            for (int j = 0; j < n; ++j) {
                x = Math.max(x, grid[i][j]);
                y = Math.max(y, grid[j][i]);
                if (grid[i][j] > 0) res++;
            }
            res += x + y;
        }
        return res;
    }
}
