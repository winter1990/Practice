package practice.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @search
 * @array
 *
 * find the shortest distance for the ball to stop at the destination
 *
 * use an array to keep track of the steps
 * can also be used for checking whether visited (0 or not)
 *
 */
public class TheMaze_II {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return 0;
        }
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(start[0], start[1], 0));
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.row;
            int y = cur.col;
            int steps = cur.steps;
            if (dp[x][y] <= steps) {
                continue;
            }
            dp[x][y] = steps;
            for (int[] dir : dirs) {
                int row = x;
                int col = y;
                int step = steps;
                while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == 0) {
                    row += dir[0];
                    col += dir[1];
                    step++;
                }
                row -= dir[0];
                col -= dir[1];
                step--;
                q.offer(new Point(row, col, step));
            }
        }
        return dp[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dp[destination[0]][destination[1]];
    }

    class Point {
        int row;
        int col;
        int steps;
        public Point(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        TheMaze_II t = new TheMaze_II();
        int[][] in = {{0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}};
        int[] s = {0, 4};
        int[] e = {4, 4};
        System.out.println(t.shortestDistance(in, s, e));
    }
}
