package practice.leetcode.medium;

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
    public static void main(String[] args) {
        TheMaze_II t = new TheMaze_II();
        int[][] in = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,1},
                {1,1,0,1,1},
                {0,0,0,0,0}};

        int[] s = {0, 4};
        int[] e = {4, 4};
        System.out.println(t.shortestDistance(in, s, e));
    }

    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        boolean[][] isVisited = new boolean[m][n];
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == destination[0] && cur[1] == destination[1]) {
                    return step;
                }
                for (int[] d : dirs) {
                    int x = cur[0];
                    int y = cur[1];
                    while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                        x += d[0];
                        y += d[1];
                    }
                    x -= d[0];
                    y -= d[1];
                    if (isVisited[x][y]) continue;
                    isVisited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
            ++step;
        }
        return -1;
    }
}
