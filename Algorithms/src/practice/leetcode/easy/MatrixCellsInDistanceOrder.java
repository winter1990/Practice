package practice.leetcode.easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @search
 * @bfs
 *
 * method 1
 * bfs from the point (r0,c0) to expand to all the adjacent points
 *
 * method 2
 * list all the points in the matrix/grid
 * the problem becomes: sort the points by distance to a given points
 */
public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Set<String> set = new HashSet<>();
        set.add(r0 + " " + c0);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r0, c0});
        int i = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            res[i++] = cur;
            for (int[] d : dirs) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x >= 0 && x < R && y >= 0 && y < C && set.add(x + " " + y)) {
                    q.offer(new int[]{x, y});
                }
            }
        }
        return res;
    }
}
