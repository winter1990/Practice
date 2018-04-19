package practice.interview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * pipe game, 水从左上进，判断如果leak和out of bound就return false, 然后如果能从右下角出来就return true
 */
public class PipeGame {
    int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    boolean canGoThrough(Point[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        isVisited[0][0] = true;
        Queue<Point> q = new LinkedList<>();
        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.row;
            int y = cur.col;
            isVisited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                if (cur.dirs[i] == 1) {
                    int row = x;
                    int col = y;
                    row += dirs[i][0];
                    col += dirs[i][1];
                    if (row < 0 || col < 0 || (row == m - 1 && col != n - 1) || (row != m - 1 && col == n)) {
                        return false;
                    } else if (isVisited[row][col] || countOnes(grid[row][col].dirs) != 2) {
                        return false;
                    }
                    q.offer(grid[row][col]);
                }
            }
        }
        return false;
    }

    private int countOnes(int[] dirs) {
        int cnt = 0;
        for (int i = 0; i < dirs.length; i++) {
            cnt++;
        }
        return cnt;
    }

    class Point {
        int row;
        int col;
        int[] dirs;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
            dirs = new int[4];
        }
    }
}
