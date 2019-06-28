package practice.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @search
 *
 * Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving
 * the shortest distance.
 *
 * Output the moving directions by using 'u', 'd', 'l' and 'r'. Since there could be several different shortest ways,
 * you should output the lexicographically smallest way. If the ball cannot reach the hole, output "impossible".
 *
 * 1 0 0 1 0
 * 0 0 0 0 1
 * 1 1 0 0 0
 * 0 1 1 0 0
 */
public class TheMaze_III {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}}; // d l r u
        String[] ds = {"d", "l", "r", "u"};
        int m = maze.length, n = maze[0].length;
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.d == b.d ? a.path.compareTo(b.path) : a.d - b.d);
        pq.offer(new Point(ball[0], ball[1], 0, ""));
        int[][] distances = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(distances[i], Integer.MAX_VALUE);
        String res = "";
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.d > distances[cur.row][cur.col]) continue;
            distances[cur.row][cur.col] = cur.d;
            for (int i = 0; i < 4; i++) {
                int[] dir = dirs[i];
                int x = cur.row, y = cur.col, d = cur.d;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    d++;
                    if (x == hole[0] && y == hole[1]) {
                        if (d < distances[x][y]) {
                            distances[x][y] = d;
                            res = cur.path + ds[i];
                        } else if (d == distances[x][y]) {
                            res = cur.path.compareTo(res) < 0 ? cur.path + ds[i] : res;
                        }
                        break;
                    }
                }
                if (x != hole[0] || y != hole[1]) {
                    x -= dir[0];
                    y -= dir[1];
                    d--;
                }
                if (x != cur.row || y != cur.col) pq.offer(new Point(x, y, d, cur.path + ds[i]));
            }
        }
        return res.equals("") ? "impossible" : res;
    }

    class Point {
        int row, col, d;
        String path;
        public Point(int row, int col, int distance, String path) {
            this.row = row;
            this.col = col;
            this.d = distance;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        TheMaze_III t = new TheMaze_III();
        int[][] in = {
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0}
        };
        int[] s = {4,3};
        int[] e = {0,1};
        System.out.println(t.findShortestWay(in,s,e));
    }
}
