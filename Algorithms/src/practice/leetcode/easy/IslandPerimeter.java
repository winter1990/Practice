package practice.leetcode.easy;

/**
 * @dfs
 *
 * method 1 - dfs
 * scan through the array, if see 1, dfs()
 * if out of bound or grid[i][j]=0
 *   count++
 * else if grid[i][j]=2
 *   return
 * mark the cell as 2
 * continue searching 4 directions
 *
 * method 2 - count 1s and adjacent edges
 *
 *  __
 * |__|__
 * |__|__|
 * only count right and bottom edge for each cell
 * i = [0, n-1]
 *   j = [0, n-1]
 *     check right
 *     check bottom
 * res = total 1s * 4 - adjacent edges * 2
 */
public class IslandPerimeter {
    int res = 0;
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) dfs(grid, i, j);
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            res++;
            return;
        } else if (grid[i][j] == 2) {
            return;
        }
        grid[i][j] = 2;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    /**
     * total number of boards:
     * 2->2*4-2*1=6 3->3*4-2*2
     * number of sqares * 4 - neighbor * 2
     */
    public int islandPerimeter1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0, edge = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i < m - 1 && grid[i + 1][j] == 1) edge++;
                    if (j < n - 1 && grid[i][j + 1] == 1) edge++;
                    res += 4;
                }
            }
        }
        return res - 2 * edge;
    }
}
