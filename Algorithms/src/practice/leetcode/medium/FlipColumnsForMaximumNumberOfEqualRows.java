package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @array
 *
 * Given a matrix consisting of 0s and 1s, we may choose any number of columns in the matrix and flip every cell in
 * that column.
 * Flipping a cell changes the value of that cell from 0 to 1 or from 1 to 0.
 *
 * Return the maximum number of rows that have all values equal after some number of flips.
 *
 * Input: [[0,0,0],
 *         [0,0,1],
 *         [1,1,0],
 * Output: 2
 *
 * problems to solve:
 * 1. what is the impact when flip a column
 * 2. the impact for a row and a column
 * 3. find the maximum
 * 4. if there is a tie?
 *
 * to get the largest number of rows that have all 0s or 1s
 * we need to find a row, that has the most SAME and COMPLEMENT rows
 * 1 0 0 1 and 1 0 0 1 are the same
 * 1 0 0 1 and 0 1 1 0 are complement with each other
 */
public class FlipColumnsForMaximumNumberOfEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, res  = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb1.append(matrix[i][j]);
                sb2.append(1 - matrix[i][j]);
            }
            String s1 = sb1.toString();
            String s2 = sb2.toString();
            if (map.containsKey(s1) || map.containsKey(s2)) {
                if (map.containsKey(s1)) {
                    map.put(s1, map.getOrDefault(s1, 0) + 1);
                    res = Math.max(res, map.get(s1));
                } else {
                    map.put(s2, map.getOrDefault(s2, 0) + 1);
                    res = Math.max(res, map.get(s2));
                }
            } else {
                map.put(s1, 1);
            }
        }
        return res;
    }
}
