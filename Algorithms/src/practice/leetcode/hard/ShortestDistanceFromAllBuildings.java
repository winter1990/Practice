package practice.leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @array
 * @search
 *
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance
 *
 * problem to solve:
 * 1. find the land (0) for house
 * 2. the house can reach all buildings -> find path from 0 to 1
 * 3. total distance is smallest
 *
 * for distance related issue -> BFS
 * for each empty space bfs all the possible path, and also need to count the reached buildings - O(mn^mn)
 * or
 * the reverse way: start with each building, bfs and record the length to each possible steps
 * distance[i][j] = the distance to all buildings, each time +level
 * if can not be reached, then distance = 0
 * also need to track at the point in grid, how many buildings can be reached - count[][], each time visited +1
 * scan through distance[][] and get smallest non-zero value, at the same time, count[i][j] must = total buildings
 * -> count buildings is needed
 */
public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] reachCount = new int[m][n];
        int totalCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) totalCount++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!bfs(grid, distance, reachCount, totalCount, m, n, i, j)) return -1;
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reachCount[i][j] == totalCount) {
                    minDistance = Math.min(minDistance, distance[i][j]);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;

    }

    final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private boolean bfs(int[][] grid, int[][] distance, int[][] reachCount, int houseCount, int m, int n, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        int level = 0, count = 0;
        boolean[][] visited = new boolean[m][n];
        while (!q.isEmpty()) {
            int size = q.size();
            ++level;
            while (size-- > 0) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int xx = curr[0] + dir[0];
                    int yy = curr[1] + dir[1];
                    if (xx >= 0 && xx < m && yy >= 0 && yy < n && !visited[xx][yy]) {
                        if (grid[xx][yy] == 0) {
                            distance[xx][yy] += level;
                            visited[xx][yy] = true;
                            reachCount[xx][yy]++;
                            q.offer(new int[]{xx, yy});
                        } else if (grid[xx][yy] == 1) {
                            count++;
                            visited[xx][yy] = true;
                        }
                    }
                }
            }
        }
        return count == houseCount;
    }

    public static void main(String[] args) {
        int[][] in = new int[][]{
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,1}
        };
        ShortestDistanceFromAllBuildings s = new ShortestDistanceFromAllBuildings();
        System.out.println(s.shortestDistance(in));
    }
}
