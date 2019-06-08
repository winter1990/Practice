package practice.leetcode.hard;

import java.util.TreeSet;

/**
 * @dp
 *
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its
 * sum is no larger than k.
 *
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
 *              and 2 is the max number no larger than k (k = 2)
 *
 * brute force
 * 2 points make up a rectangle
 *   top left
 *   bottom right
 *
 * problems to solve:
 * 1. form a rectangle
 * 2. calculate the sum in rect
 * 3. closest and smaller than k
 *
 *    0  1  2  3  4
 * 0  2  1 -3 -4  5
 * 1  0  6  3  4  1
 * 2  2 -2 -1  4 -5
 * 3 -3  3  1  0  3
 *
 * [ 2  0  2 -3]
 * [ 3  6  0  0]
 * [ 0  9 -1  1]
 * [-4 13  3  5]
 * [ 1 14 -2  3]
 *
 * start with 1d array
 *   we have seen it before
 *   track the current sum, if negative, reset to 0, otherwise get max
 *   if we have the limit of k, use tree like data structure for quick look up the pre sum
 * start with first col
 */
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix1(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, res = Integer.MIN_VALUE;
        for (int left = 0; left < n; left++) {
            int[] preSum = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    preSum[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int cur = 0;
                for (int s : preSum) {
                    cur += s;
                    Integer num = set.ceiling(cur - k); // cur - x <= k
                    if (num != null) res = Math.max(res, cur - num);
                    set.add(cur);
                }
            }
        }
        return res;
    }
}
