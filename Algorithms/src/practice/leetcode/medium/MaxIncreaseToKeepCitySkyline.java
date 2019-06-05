package practice.leetcode.medium;

/**
 * @array
 *
 * In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there.
 * We are allowed to increase the height of any number of buildings, by any amount.
 * Height 0 is considered to be a building as well.
 *
 * At the end, the "skyline" when viewed from all four directions of the grid, must be the same as the skyline
 * of the original grid.
 * A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance.
 *
 * Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * Output: 35
 * Explanation:
 * The grid is:
 * [ [3, 0, 8, 4],
 *   [2, 4, 5, 7],
 *   [9, 2, 6, 3],
 *   [0, 3, 1, 0] ]
 *
 * The skyline viewed from top or bottom is: [9, 4, 8, 7]
 * The skyline viewed from left or right is: [8, 7, 9, 3]
 *
 * gridNew = [ [8, 4, 8, 7],
 *             [7, 4, 7, 7],
 *             [9, 4, 8, 7],
 *             [3, 3, 3, 3] ]
 */
public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 0 || n == 0 || (m == 1 && n == 1)) return 0;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > row[i]) row[i] = grid[i][j];
                if (grid[i][j] > col[j]) col[j] = grid[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.max(Math.min(row[i], col[j]) - grid[i][j], 0);
            }
        }
        return res;
    }
}
