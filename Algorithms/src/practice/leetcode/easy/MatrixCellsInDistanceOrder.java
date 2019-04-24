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
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] res = new int[R * C][2];
        int index = 0;
        Set<String> set = new HashSet<>();
        set.add(r0 + "/" + c0);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r0, c0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            res[index++] = cur;
            for (int[] dir : dirs) {
                int rr = cur[0] + dir[0];
                int cc = cur[1] + dir[1];
                if (rr < 0 || rr >= R || cc < 0 || cc >= C) continue;
                if (set.add(rr + "/" + cc)) q.offer(new int[]{rr, cc});
            }
        }
        return res;
    }
}
