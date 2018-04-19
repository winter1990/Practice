package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @search
 * @array
 *
 * The ball can go through empty spaces by rolling up, down, left or right,
 * but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space
 *
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * start [0,4], end [4,4]
 * output true
 * left-down-left-down-right-down-right
 *
 * bfs
 * begin with start point, track all the points that it can reach
 */
public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] isVisited = new boolean[m][n];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(start[0], start[1]));
        isVisited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.row;
            int y = cur.col;
            for (int[] dir : dirs) {
                int row = x;
                int col = y;
                while (row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == 0) {
                    row += dir[0];
                    col += dir[1];
                }
                row -= dir[0];
                col -= dir[1];
                if (isVisited[row][col]) continue;
                isVisited[row][col] = true;
                if (row == destination[0] && col == destination[1]) {
                    return true;
                }
                q.offer(new Point(row, col));
            }
        }
        return false;
    }

    class Point {
        int row;
        int col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        TheMaze t = new TheMaze();
        int[][] in = {{0,0,1,0,0},
                      {0,0,0,0,0},
                      {0,0,0,1,0},
                      {1,1,0,1,1},
                      {0,0,0,0,0}};
        int[] s = {0, 4};
        int[] e = {4, 4};
        System.out.println(t.hasPath(in, s, e));
    }
}
