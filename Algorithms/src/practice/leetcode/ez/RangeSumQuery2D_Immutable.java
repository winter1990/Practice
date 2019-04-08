package practice.leetcode.ez;

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
    int[][] sum;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) return;
        this.matrix = matrix;
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}