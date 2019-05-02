package practice.leetcode.medium;

/**
 * @array
 * @dp
 *
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 * Now, we may draw a straight line connecting two numbers A[i] and B[j] as long as A[i] == B[j],
 * and the line we draw does not intersect any other connecting (non-horizontal) line.
 * Return the maximum number of connecting lines we can draw in this way.
 *
 * Input: A = [1,4,2], B = [1,2,4], Output: 2
 * Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2], Output: 3
 * Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1], Output: 2
 *
 * translation:
 * find the longest common sub-sequence of two arrays
 *
 * dp solution:
 * dp[i][j] represents the longest common sub sequence with first i chars in A and j chars in B
 * two states
 *   two numbers are the same
 *   two numbers are not same
 * if A[i-1]=B[j-1] -> dp[i-1][j-1]+1
 * else max(dp[i-1][j], dp[i][j-1])
 */
public class UncrossedLines {
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
