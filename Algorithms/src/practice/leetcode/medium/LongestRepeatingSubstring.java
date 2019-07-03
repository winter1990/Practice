package practice.leetcode.medium;

/**
 * @string
 *
 * Given a string S, find out the length of the longest repeating substring(s).
 * Return 0 if no repeating substring exists.
 *
 * Input: "abcd"
 * Output: 0
 *
 * Input: "abbaba"
 * Output: 2, "ab" or "ba" repeated twice
 *
 * Input: "aabcaabdaab"
 * Output: 3
 * Explanation: The longest repeating substring is "aab", which occurs 3 times.
 *
 * use dp to track the longest repeating substring
 * dp[n+1][n+1]
 * initial state - 0 length at index 0
 * dp[i][j] represents the longest substring ending with i and j
 * transition
 *   i = [1 n)
 *     j = [i+1,n]
 *       if s(i) = s(j), dp[i][j]=dp[i-1][j-1]+1
 */
public class LongestRepeatingSubstring {
    public static int longestRepeatingSubstring(String S) {
        int n = S.length();
        int[][] dp = new int[n + 1][n + 1];
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestRepeatingSubstring("ababa"));
    }
}
