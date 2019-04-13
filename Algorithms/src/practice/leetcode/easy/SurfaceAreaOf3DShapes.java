package practice.leetcode.easy;

/**
 * @math
 *
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * Return the total surface area of the resulting shapes.
 * Input: [[2]] Output: 10
 * Input: [[1,2],[3,4]] Output: 34, up 4 down 4 left+right (2+4)*2 front/back (3+4)*2 -> 34
 * Input: [[1,1,1],[1,0,1],[1,1,1]] Output: 32
 *
 * whether we should count the area should depend on adjacent 4 directions
 * for each cell, if there is cube, add the full area
 * there might be duplicate area counted if i > 0 or j > 0
 */
public class SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        int n = grid.length, total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) total += (2 + grid[i][j] * 4);
                if (i > 0) total -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                if (j > 0) total -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] in = {{1,1,1},{1,0,1},{1,1,1}};
        SurfaceAreaOf3DShapes s = new SurfaceAreaOf3DShapes();
        System.out.println(s.surfaceArea(in));
    }
}
