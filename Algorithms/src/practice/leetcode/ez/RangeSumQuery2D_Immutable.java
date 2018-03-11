package practice.leetcode.ez;

public class RangeSumQuery2D_Immutable {
}

class NumMatrix {
    int[][] matrix;
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int m = matrix.length;
        int n = matrix[0].length;
        if ((row1 < 0 && row2 < 0) || (row1 >= m && row2 >= m) || (col1 < 0 && col2 < 0) || (col1 >= n && col2 >= n)) {
            return 0;
        }
        row1 = Math.max(row1, 0);
        col1 = Math.max(col1, 0);
        row2 = Math.min(row2, m - 1);
        col2 = Math.min(col2, n - 1);
        return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row1][col2] - dp[row2][col1];
    }
}