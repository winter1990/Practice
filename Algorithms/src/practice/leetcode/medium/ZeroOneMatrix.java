package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @array
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 *
 * layer by layer
 * treat 1s as an island, the edge is 1 and search into inner side
 * initially, mark all 1s as MAX, put 0s into queue
 */
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= 1 + matrix[cur[0]][cur[1]]) continue;
                matrix[x][y] = 1 + matrix[cur[0]][cur[1]];
                q.offer(new int[]{x, y});
            }
        }
        return matrix;
    }
}
