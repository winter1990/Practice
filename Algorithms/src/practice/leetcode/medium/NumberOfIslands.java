package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @search
 * @dfs
 *
 * problems to solve:
 * 1. count the number of disjoint block of 1s
 * 2. when scan the matrix, do not re-count the same island
 *
 * scan through the 2D array
 * if there is 1, dfs to mark all the land as visited - we can either mark it as 0
 * or we define a new 2D boolean array to keep track whether we have visited the element
 *
 * if no extra space is allowed:
 * we can dfs and mark the island as '.' or some special char
 * after counting, we do another scan and change all the special chars back to 1
 *
 * followup:
 * 1. if cannot modify the grid
 *    use another 2D array to keep track of whether the point is visited or not
 * 2. if we need to keep the original array as it is
 *    mark the 1 as some char other than 0 or 1
 *    at the end, scan again to change the special char back to 1
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
    }

    // bfs
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    fill(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private void fill(char[][] grid, int i, int j, int m, int n) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        grid[i][j] = '0';
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            grid[cur[0]][cur[1]] = 0;
            for (int[] d : dirs) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                    grid[x][y] = '0';
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
}
