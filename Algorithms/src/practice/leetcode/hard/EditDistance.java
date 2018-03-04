package practice.leetcode.hard;

/*
find the minimum number of steps required to convert word1 to word2
a) Insert a character
b) Delete a character
c) Replace a character
 */

/*
     a b c d
   0 1 2 3 4 <- insertion
 a 1 0 1 2 3
 e 2 1 1 2 3
 d 3 2 2 2 2
 */

/**
 * dp[m+1][n+1] row-w1 col-w2
 * dp[0][i] insertion, d[i][0] deletion, dp[i][j]
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int del = dp[i - 1][j] + 1;
                int ins = dp[i][j - 1] + 1;
                int rep = dp[i - 1][j - 1] + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(del, ins), rep);
                }
            }
        }
        return dp[m][n];
    }
}
