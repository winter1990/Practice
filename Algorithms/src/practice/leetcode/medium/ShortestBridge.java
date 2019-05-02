package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @search
 *
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not
 * connected to any other 1s.)
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 *
 * for the edge on one island, bfs and find the shortest path to the other island
 * need to mark one island different with another one first
 *
 */
public class ShortestBridge {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestBridge(int[][] A) {
        int n = A.length;
        Queue<int[]> q = new LinkedList<>();
        out:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    markIslandAsTwo(A, i, j, n, q);
                    break out;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int x = cur[0] + d[0], y = cur[1] + d[1];
                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if (A[x][y] >= 2 || A[x][y] == -1) continue;
                    if (A[x][y] == 1) return A[cur[0]][cur[1]] - 2;
                    q.offer(new int[]{x, y});
                    A[x][y] = A[cur[0]][cur[1]] + 1;
                }
            }
        }
        return -1;
    }

    private void markIslandAsTwo(int[][] a, int i, int j, int n, Queue<int[]> q) {
        if (i < 0 || j < 0 || i >= n || j >= n || a[i][j] != 1) return;
        a[i][j] = -1;
        if (valid(a, i, j, n)) {
            a[i][j] = 2;
            q.offer(new int[] {i, j});
        }
        for (int[] d : dirs) markIslandAsTwo(a, i + d[0], j + d[1], n, q);
    }

    private boolean valid(int[][] a, int i, int j, int n) {
        return (i > 0 && a[i - 1][j] == 0) || (i < n - 1 && a[i + 1][j] == 0) || (j > 0 && a[i][j - 1] == 0) || (j < n - 1 && a[i][j + 1] == 0);
    }
    public static void main(String[] args) {
//        int[][] in = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
//        int[][] in = {{0,1,0},{0,0,0},{0,0,1}};
        int[][] in = {{1,0},{0,1}};
        ShortestBridge s = new ShortestBridge();
        System.out.println(s.shortestBridge(in));
    }
}
