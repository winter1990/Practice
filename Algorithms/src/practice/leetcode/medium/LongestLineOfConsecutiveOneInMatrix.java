package practice.leetcode.medium;

/**
 * @array
 *
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal,
 * vertical, diagonal or anti-diagonal.
 *
 * Input:
 * [[0,1,1,0],
 *  [0,1,1,0],
 *  [0,0,0,1]]
 * Output: 3
 *
 * totally 4 scenarios
 *   row
 *   column
 *   diagonal
 *   anti-diagonal
 *
 * dp array to keep track of the longest row col dia anti-dia
 * dp[m][n][4]
 * dp[i][j][k] represents the longest line of 1s with horizontal, vertical, diagonal and anti-diagonal
 */
public class LongestLineOfConsecutiveOneInMatrix {
    public int longestLine(int[][] M) {
        int m = M.length, n = M[0].length, max = 0;
        int[][][] dp = new int[m][n][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    for (int k = 0; k < 4; k++) dp[i][j][k] = 1;
                    if (i > 0) dp[i][j][0] += dp[i - 1][j][0];
                    if (j > 0) dp[i][j][1] += dp[i][j - 1][1];
                    if (i > 0 && j > 0) dp[i][j][2] += dp[i - 1][j - 1][2];
                    if (i > 0 && j < n - 1) dp[i][j][3] += dp[i - 1][j + 1][3];
                    max = Math.max(max, Math.max(dp[i][j][0], dp[i][j][1]));
                    max = Math.max(max, Math.max(dp[i][j][2], dp[i][j][3]));
                }
            }
        }
        return max;
    }
}
