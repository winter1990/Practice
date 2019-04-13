package practice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @math
 *
 *
 */
public class ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        for (int[] row : grid) {
            int countNonZero = 0;
            int rowMax = 0;
            for (int i = 0; i < row.length; i++) {
                if (row[i] != 0) {
                    countNonZero++;
                }
                rowMax = Math.max(rowMax, row[i]);
                if (!map.containsKey(i)) {
                    map.put(i, row[i]);
                } else {
                    int cur = map.get(i);
                    map.put(i, Math.max(row[i], cur));
                }
            }
            total += countNonZero;
            total += rowMax;
        }
        for (int col : map.keySet()) {
            total += map.get(col);
        }
        return total;
    }

    public int projectionArea1(int[][] grid) {
        int res = 0, n = grid.length;
        for (int i = 0; i < n; ++i) {
            int x = 0, y = 0;
            for (int j = 0; j < n; ++j) {
                x = Math.max(x, grid[i][j]);
                y = Math.max(y, grid[j][i]);
                if (grid[i][j] > 0) ++res;
            }
            res += x + y;
        }
        return res;
    }
}
