package practice.leetcode.easy;

public class RangeSumQuery2D_Immutable {
}

/**
 * @array
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper
 * left corner (row1, col1) and lower right corner (row2, col2).
 * You may assume that the matrix does not change.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.

 * many calls to the function
 * use a two dimension array to store the total sum:
 * sum[i][j] = all the elements from matrix[0][0] to matrix[i][j]
 *
 * the sum in the rectangle (r1,c1) (r2,c2) = sum[r2][c2] - sum[r1-1][c2] - sum[r2][c1-1] + sum[r1-1][c1-1]
 */
class NumMatrix {
    int m, n;
    int[][] preSum;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int col = 0;
            for (int j = 1; j <= n; j++) {
                col += matrix[i - 1][j - 1];
                preSum[i][j] += preSum[i - 1][j] + col;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
    }
}