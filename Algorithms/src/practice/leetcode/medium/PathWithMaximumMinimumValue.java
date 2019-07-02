package practice.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @search
 *
 * Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0]
 * and ending at [R-1,C-1].
 *
 * The score of a path is the minimum value in that path.
 *
 * A path moves to any neighbouring unvisited cell in one of the 4 cardinal directions.
 *
 * 1 <= R, C <= 100
 * 0 <= A[i][j] <= 10^9
 *
 * 5 4 5
 * 1 2 6
 * 7 4 6 -> 5 4 5 6 6
 *
 * 0 1 2
 * 3 4 5
 * 6 7 8
 */
public class PathWithMaximumMinimumValue {
    public static int maximumMinimumPath(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] max = new int[m][n];
        max[0][0] = A[0][0];
        for (int[] a : max) Arrays.fill(a, -1);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (b[2] - a[2]));
        q.offer(new int[]{0, 0, A[0][0]});
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && max[x][y] == -1) {
                    max[x][y] = Math.min(cur[2], A[x][y]);
                    if (x == m - 1 && y == n - 1) {
                        return max[x][y];
                    }
                    q.offer(new int[]{x, y, max[x][y]});
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
//        int[][] in = {{5,4,5},{1,2,6},{7,4,6}};
        int[][] in = {{3,4,6,3,4},{0,2,1,1,7},{8,8,3,2,7},{3,2,4,9,8},{4,1,2,0,0},{4,6,5,4,3}};
        System.out.println(maximumMinimumPath(in));
    }
}
