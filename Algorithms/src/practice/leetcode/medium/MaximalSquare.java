package practice.leetcode.medium;

/**
 * @dp
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * if we see 1 in the matrix, the size of sq depends on [i-1][j], [i][j-1] and [i-1][j-1] three values
 * dynamic programming, dp[i][j] value means the square side's length, [i][j] is the right bottom vertex/corner
 * next step, find the relation between current and prev status
 * the size of sq can form depends on the smallest value of prev status
 * current = min(all the three points/adjacent sq)
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j -1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] in = {{'1', '0', '1', '0', '0'},
                       {'1', '0', '1', '1', '1'},
                       {'1', '1', '1', '1', '1'},
                       {'1', '0', '0', '1', '0'}};
        MaximalSquare mq = new MaximalSquare();
        mq.maximalSquare(in);
    }
}
