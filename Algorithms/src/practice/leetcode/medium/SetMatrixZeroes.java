package practice.leetcode.medium;

/**
 * @array
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * problems to solve:
 * we can not do it when scanning through the grid, then how we determine whether it should be 0?
 *
 * a 0 can impact the whole row and column
 * use arrays to store which row and column should be 0
 *
 * scan through the grid twice:
 *   1. find all 0s and store in row[] col[]
 *   2. scan again to modify the array in place
 * time O(mn), space O(m+n)
 *
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) matrix[i][j] = 0;
            }
        }
    }

    /**
     * optimization:
     * in above solution, we are using extra arrays to store 0/1 status of row and column
     * can we do better?
     * if we can use the matrix itself to store and 0/1 status
     * use the first row and column to store the status:
     *   need two boolean to store whether row 0 and col 0 exist 0
     *
     */
    public void setZeroes1(int[][] matrix) {
        boolean isRowZero = false, isColZero = false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isColZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                isRowZero = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (isColZero) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
        if (isRowZero) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
    }
}
