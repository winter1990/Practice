package practice.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * Given a matrix, and a target, return the number of non-empty submatrices that sum to target.
 *
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0, Output: 4
 * Input: matrix = [[1,-1],[-1,1]], target = 0, Output: 5
 *
 * 0 1 0
 * 1 1 1
 * 0 1 0 target = 2, output 4
 *
 * 0 0 0 0
 * 0 0 1 1
 * 0 1 3 4
 * 0 1 4 5
 *
 * 0 1 1
 * 1 2 3
 * 0 1 1
 */
public class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Map<Integer, Integer> count = new HashMap<>();
                count.put(0, 1);
                int cur = 0;
                for (int k = 0; k < m; k++) {
                    cur += matrix[k][j];
                    if (i > 0) cur -= matrix[k][i - 1];
                    res += count.getOrDefault(cur - target, 0);
                    count.put(cur, count.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}
