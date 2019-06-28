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
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
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
 * begin with start point
 * for each direction, move until wall
 * store the visited points - 2d boolean array
 * poll() from the queue and check if it is destination
 */
public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] isVisited = new boolean[m][n];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(start[0], start[1]));
        isVisited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int row = cur.row;
            int col = cur.col;
            for (int[] dir : dirs) {
                int x = row;
                int y = col;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (isVisited[x][y]) continue;
                isVisited[x][y] = true;
                if (x == destination[0] && y == destination[1]) return true;
                q.offer(new Point(x, y));
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
