package practice.interview.google;

import java.util.*;

public class CheckIfStoneIsSurrounded {
    public boolean isSurrounded(int[][] board, int[] start) {
        int m = board.length, n = board[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start[0] + " " + start[1]);
        boolean l = false, r = false, t = false, b = false;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0) t = true;
                if (y < 0) l = true;
                if (x >= m) b = true;
                if (y >= n) r = true;
                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != 1 && visited.add(x + " " + y)) {
                    q.offer(new int[]{x, y});
                }
            }
        }
        return l == true && r == true && t == true && b == true;
    }

    public static void main(String[] args) {
        int[] st = {1,1};
        int[][] in = {
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,1},
                {0,0,0,1,1,0,0,0,0,1},
                {0,0,1,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,1},
                {1,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0,0}
        };
        CheckIfStoneIsSurrounded c = new CheckIfStoneIsSurrounded();
        System.out.println(c.isSurrounded(in, st));
    }
}
