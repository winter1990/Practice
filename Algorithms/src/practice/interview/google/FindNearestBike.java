package practice.interview.google;


import java.util.LinkedList;
import java.util.Queue;

/**
 * # building
 * start with E
 * B is bike
 */
public class FindNearestBike {
    int[][] dirs = {{1, 0},{-1, 0},{0, 1}, {0, -1}};
    public Pair findNearestBile(char[][] grid, Pair start) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (grid[cur.row][cur.col] == 'B') return cur;
            visited[cur.row][cur.col] = true;
            for (int[] d : dirs) {
                int x = cur.row + d[0];
                int y = cur.col + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == '#') continue;
                q.offer(new Pair(x, y));
            }
        }
        return null;
    }

    class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
