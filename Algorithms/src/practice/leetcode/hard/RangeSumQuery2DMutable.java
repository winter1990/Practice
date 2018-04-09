package practice.leetcode.hard;

public class RangeSumQuery2DMutable {
}

/**
 * @array
 * @math
 *
 * need array to store the sum
 */
class NumMatrix {
    int[][] matrix;
    int[][] cols;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        cols = new int[m][n];
        for (int i = 0; i < n; i++) {
            cols[0][i] = matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cols[i][j] = cols[i - 1][j] + matrix[i][j];
            }
        }
    }

    public void update(int row, int col, int val) {
        for (int i = row; i < matrix.length; i++) {
            cols[i][col] += (val - matrix[row][col]);
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = col1; i <= col2; i++) {
            if (row1 == 0) {
                res += cols[row2][i];
                continue;
            }
            res += (cols[row2][i] - cols[row1 - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] in = {{1}};
        NumMatrix n = new NumMatrix(in);
        System.out.println(n.sumRegion(0,0,0,0));
        n.update(0,0,-1);
        System.out.println(n.sumRegion(0,0,0,0));

    }
}