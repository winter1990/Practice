package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @bfs
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1 instead.
 *
 * start with rotten orange, search in 4 directions
 * if 0 continue, if 1 change it to 2
 *
 * there might be multiple 'islands' in the grid, so need to search the whole array
 * put in queue and search in 4 directions
 * there might be some solo islands, so we need to track to make sure all oranges are rotting
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        int count = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                        freshCount--;
                    }
                }
            }
            count++;
        }
        return freshCount == 0 ? count - 1 : -1;
    }

    public static void main(String[] args) {
        int[][] in = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        RottingOranges ro = new RottingOranges();
        System.out.println(ro.orangesRotting(in));
    }
}
