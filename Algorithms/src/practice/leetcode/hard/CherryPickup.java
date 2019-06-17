package practice.leetcode.hard;

import java.util.*;

public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        getMaxPath(grid, dp, m, n);

        int max = dp[m - 1][n - 1];
        markMaxPath(grid, dp, max, m, n);
        int res = max;
        dp = new int[m][n];
        getMaxPath(grid, dp, m, n);
        max = dp[m - 1][n - 1];
        res += max;
        return res;
    }

    private void getMaxPath(int[][] grid, int[][] dp, int m, int n) {
        int i = 1;
        for (; i < m; i++) {
            if (grid[i][0] == -1) break;
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        while (i < m) dp[i++][0] = Integer.MIN_VALUE;
        int j = 1;
        for (; j < n; j++) {
            if (grid[0][j] == -1) break;
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        while (j < n) dp[0][j++] = Integer.MIN_VALUE;
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (grid[i][j] == -1) {
                    dp[i][j] = Integer.MIN_VALUE;
                } else {
                    int tmp = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = tmp == Integer.MIN_VALUE ? Integer.MIN_VALUE : (tmp + grid[i][j]);
                }
            }
        }
    }

    private void markMaxPath(int[][] grid, int[][] dp, int max, int m, int n) {
        int[][] dirs = {{-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{m - 1, n - 1});
        Set<String> visited = new HashSet<>();
        visited.add(m - 1 + " " + (n - 1));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int a = cur[0], b = cur[1];
                if ((a > 0 && dp[a - 1][b] == max - 1) || (b > 0 && dp[a][b - 1] == max - 1)) {
                    grid[cur[0]][cur[1]] = 0;
                    --max;
                    q.clear();
                }
                for (int[] d : dirs) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x >= 0 && y >= 0 && dp[x][y] != Integer.MIN_VALUE) {
                        if (visited.add(x + " " + y) && dp[x][y] == max) {
                            q.offer(new int[]{x, y});
                            break;
                        }
                    }
                }
            }
        }
    }

    public int cherryPickup1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        int i = 1;
        for (; i < m; i++) {
            if (grid[i][0] == -1) break;
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        while (i < m) dp[i++][0] = Integer.MIN_VALUE;
        int j = 1;
        for (; j < n; j++) {
            if (grid[0][j] == -1) break;
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        while (j < n) dp[0][j++] = Integer.MIN_VALUE;
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (grid[i][j] == -1) {
                    dp[i][j] = Integer.MIN_VALUE;
                } else {
                    int tmp = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = tmp == Integer.MIN_VALUE ? Integer.MIN_VALUE : (tmp + grid[i][j]);
                }
            }
        }
        // search from bottom right to top left
        int[][] dirs = {{-1, 0}, {0, -1}};
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{m - 1, n - 1});
        Set<String> visited = new HashSet<>();
        visited.add(m - 1 + " " + (n - 1));
        boolean canReach = false;
        while (!q.isEmpty() && !canReach) {
            int size = q.size();
            int count = 0;
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                if (grid[cur[0]][cur[1]] == 1) count++;
                if (cur[0] == 0 && cur[1] == 0) {
                    canReach = true;
                }
                for (int[] d : dirs) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if (x >= 0 && y >= 0 && dp[x][y] != Integer.MIN_VALUE) {
                        if (visited.add(x + " " + y)) {
                            q.offer(new int[]{x, y});
                        }
                    }
                }
            }
            res += count >= 2 ? 2 : count;
        }
        return canReach == true ? res : 0;
    }

    public static void main(String[] args) {
        CherryPickup c = new CherryPickup();
        int[][] in = {
                {1,1,1,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,1},
                {1,0,0,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,1,1,1}};
//        int[][] in = {
//                {1, 1, 1,1,-1,-1,-1, 1, 0, 0},
//                {1, 0, 0,0, 1, 0, 0, 0, 1, 0},
//                {0, 0, 1,1, 1, 1, 0, 1, 1, 1},
//                {1, 1, 0,1, 1, 1, 0,-1, 1, 1},
//                {0, 0, 0,0, 1,-1, 0, 0, 1,-1},
//                {1, 0, 1,1, 1, 0, 0,-1, 1, 0},
//                {1, 1, 0,1, 0, 0, 1, 0, 1,-1},
//                {1,-1, 0,1, 0, 0, 0, 1,-1, 1},
//                {1, 0,-1,0,-1, 0, 0, 1, 0, 0},
//                {0, 0,-1,0, 1, 0, 1, 0, 0, 1}}; // 22
//        int[][] in = {
//                { 1, 1,-1, 1,1},
//                { 1, 1, 1,-1,1},
//                {-1,-1, 1, 1,1},
//                { 1, 1, 1, 1,1},
//                { 1, 1, 1, 1,1}}; // 13
//        int[][] in = {
//                { 1, 1, 1,1,1},
//                { 1, 1,-1,1,1},
//                {-1,-1, 1,1,1},
//                { 1, 1, 1,1,1},
//                {-1, 1, 1,1,1}}; // 13
//        int[][] in = {
//                { 1, 1, 1,1,1},
//                { 1, 1,-1,1,1},
//                {-1,-1, 1,1,1},
//                { 1, 1, 1,1,1},
//                {-1, 1, 1,1,1}}; // 13
//        int[][] in = {{1,1,-1},{1,-1,1},{-1,1,1}}; // 0
//        int[][] in = {{0,1,-1},{1,0,-1},{1,1,1}}; // 5
//        int[][] in = {{1}}; // 1
//        int[][] in = {
//                {1,1,1,1,0,0,0},
//                {0,0,0,1,0,0,0},
//                {0,0,0,1,0,0,1},
//                {1,0,0,1,0,0,0},
//                {0,0,0,1,0,0,0},
//                {0,0,0,1,0,0,0},
//                {0,0,0,1,1,1,1}}; //15

        System.out.println(c.cherryPickup(in));
    }
}
