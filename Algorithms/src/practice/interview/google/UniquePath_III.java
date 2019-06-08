package practice.interview.google;

/**
 * 1. 从左上角走到右上角
 * 2. 要求每一步只能向正右、右上或右下走，即 →↗↘
 *
 *   0 1 2 3 4 5
 * 0 1 1 2 4 9 21
 * 1   1 2 5 12
 * 2     1 3
 * 3       1
 *
 * m = 4, n = 6
 * current status depends on dp[i-1][j-1], dp[i][j-1] and dp[i+1][j-1]
 * define dp[m+1][n+1]
 */
public class UniquePath_III {
    public int allPaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                dp[i][j] = dp[i][j - 1];
                if (i > 0) dp[i][j] += dp[i - 1][j - 1];
                if (i < m - 1) dp[i][j] += dp[i + 1][j - 1];
            }
        }
        return dp[0][n - 1];
    }

    public int allPaths1(int m, int n) {
        int[] dp = new int[m];
        dp[0] = 1;
        int pre = 0, cur = 0;
        for (int j = 1; j < n; j++) {
            pre = 0;
            cur = 0;
            for (int i = 0; i < m; i++) {
                pre = cur;
                cur = dp[i];
                if (i > 0) dp[i] += pre;
                if (i < m - 1) dp[i] += dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        UniquePath_III u = new UniquePath_III();
        System.out.println(u.allPaths(4,6));
    }
}
