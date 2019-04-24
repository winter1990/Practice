package practice.leetcode.medium;

/**
 * @array
 * @dp
 *
 * We partition an  array A into at most K adjacent (non-empty) groups, then our score is the sum of the average of each group.
 * What is the largest score we can achieve?
 *
 * dynamic programming
 * dp[i][j] represents the largest sum of j elements in i group
 * initial status:
 *   dp[1][j] = sum of first j element, j = [1,n]
 * k = [2, K] - two groups, three... until K groups
 */
public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] dp = new double[K + 1][n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
            dp[1][i] = (double) sum[i] / i;
        }
        for (int k = 2; k <= K; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] + (double) (sum[i] - sum[j]) / (i - j));
                }
            }
        }
        return dp[K][n];
    }
}
