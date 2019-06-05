package practice.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @array
 *
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
 * After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).
 *
 *
 */
public class MakingALargeIsland {
    int count = 0;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int[][] grid) {
        int id = 2, m = grid.length, n = grid[0].length, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fillIsland(grid, i, j, id, m, n);
                    map.put(id, count);
                    max = Math.max(max, count);
                    count = 0;
                    id++;
                }
            }
        }
        if (max == m * n) return max;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int cur = 0;
                    Set<Integer> visited = new HashSet<>();
                    for (int[] d : dirs) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) continue;
                        if (visited.add(grid[x][y])) cur += map.get(grid[x][y]);
                    }
                    max = Math.max(max, cur + 1);
                }
            }
        }
        return max;
    }

    private void fillIsland(int[][] grid, int i, int j, int id, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
        grid[i][j] = id;
        count++;
        fillIsland(grid, i + 1, j, id, m, n);
        fillIsland(grid, i - 1, j, id, m, n);
        fillIsland(grid, i, j + 1, id, m, n);
        fillIsland(grid, i, j - 1, id, m, n);
    }

    public static void main(String[] args) {
        int[][] in = {{1,0},{0,1}};
        MakingALargeIsland m = new MakingALargeIsland();
        System.out.println(m.largestIsland(in));
    }
}
