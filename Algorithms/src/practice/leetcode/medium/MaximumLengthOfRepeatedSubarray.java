package practice.leetcode.medium;

/**
 * @array
 * @dp
 *
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 *
 * use dp array to store the maximum common sub array
 * initial status
 *   no common/repeated sub array
 * transition function
 *   if a[i] = b[j], dp[i[j] = dp[i-1][j-1] -> the size of dp array is [m+1][n+1]
 *   -> a[i-1] = b[j-1], dp[i[j] = dp[i-1][j-1] + 1
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = -1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray m = new MaximumLengthOfRepeatedSubarray();
        int[] a = {1,2,3,2,1,4};
        int[] b = {3,2,1,4,7,3,2,1,4,5};
        System.out.println(m.findLength(a,b));
    }
}
