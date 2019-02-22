package practice.leetcode.medium;

/**
 * @search
 *
 * scan through the 2D array
 * if there is 1, bfs to mark all the land as visited - we can either mark it as 0 (change the island to the sea)
 * or we define a new 2D boolean array to keep track whether we have visited the element
 *
 * if no extra space is allowed, we can dfs and mark the island as '.' or some special char
 * after counting, we do another scan and change dot back to 1
 *
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
