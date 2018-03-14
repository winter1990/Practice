package practice.leetcode.hard;

/*
A subsequence of a string is a new string which is formed from the original string by deleting some
(can be none) of the characters without disturbing the relative positions of the remaining characters.
example: S = "rabbbit", T = "rabbit"
Return 3
 */

/**
 * example:
 * initial state, DELETE all the chars in S to form the empty string
 *      r a b b b i t => s
 * '' 1 1 1 1 1 1 1 1
 *  r 0 1 . . . . . .
 *  a 0 0 1 . . . . .
 *  b 0 0 0 1 2 . . .
 *  b 0 0 0 0 1 3 . .
 *  i 0 0 0 0 0 0 3 .
 *  t 0 0 0 0 0 0 0 3
 *  dp[i][j] represents the distinct sebseq between s[0,j-1] and t[0,i-1]
 *  dp[i][j]=dp[i][j-1]
 *  change function:
 *  t[i]=s[j], then
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i][j - 1];
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
