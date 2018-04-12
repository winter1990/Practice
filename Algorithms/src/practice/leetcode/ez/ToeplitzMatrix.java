package practice.leetcode.ez;

/**
 * @array
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 1234
 * 5123
 * 9512
 *
 * row and col not same
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
