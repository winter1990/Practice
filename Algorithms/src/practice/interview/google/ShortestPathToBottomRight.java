package practice.interview.google;

import java.util.*;

public class ShortestPathToBottomRight {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int getPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<String> ob = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) ob.add(i + " " + j);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        Set<String> visited = new HashSet<>();
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) return step;
                visited.add(cur[0] + " " + cur[1]);
                for (int[] d : dirs) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    String s = x + " " + y;
                    if (x < 0 || x >= m || y < 0 || y >= n || ob.contains(s) || visited.contains(s)) continue;
                    q.offer(new int[]{x, y});
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] obs = {{1,1},{1,2},{1,3},{3,4},{2,1},{3,1},{4,1}};
        int[][] in = {
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,1,0,0,0},
                {0,1,0,1,1},
                {0,1,0,0,0}};

        ShortestPathToBottomRight s = new ShortestPathToBottomRight();
        System.out.println(s.getPointToFlip(in));
    }

    public int[] getPointToFlip(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<String> ob = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) ob.add(i + " " + j);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int step = 2;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                grid[cur[0]][cur[1]] = step;
                for (int[] d : dirs) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 0) continue;
                    q.offer(new int[]{x, y});
                }
            }
            step++;
        }
        int[] res = new int[]{-1, -1};
        int diff = -1;
        for (String s : ob) {
            int max = -1;
            int min = Integer.MAX_VALUE;
            String[] st = s.split(" ");
            int row = Integer.valueOf(st[0]);
            int col = Integer.valueOf(st[1]);
            for (int[] d : dirs) {
                int x = row + d[0];
                int y = col + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] < 2) continue;
                int val = grid[x][y];
                max = Math.max(max, val);
                min = Math.min(min, val);
                if (max - min > diff) {
                    res[0] = row;
                    res[1] = col;
                    diff = max - min;
                }
            }
        }
        return res;
    }
}
