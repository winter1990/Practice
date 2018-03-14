package practice.leetcode.medium;

/**
 * bbbab -> bbbb length of 4
 * if we see the different chars, we dont know which pointer to move
 * so the traditional two pointers method is not applied
 *   a c b d b a
 * a 1
 * c 1 1
 * b 1 1 1
 * d 1 1 1 1
 * b 3 3 3 1 1
 * a 5 3 3 1 1 1
 * dynamic programming thinking:
 * dp[i][j] is the longest palindrome length of the substring [i,j]
 * state transition:
 * if s[i]=s[j],
 * if s[i]!=s[j],
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i - 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[len - 1][0];
    }

}
