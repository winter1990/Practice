package practice.leetcode.hard;

/**
 * @dp
 * @string
 *
 * find the minimum number of steps required to convert word1 to word2
 *   Insert a character
 *   Delete a character
 *   Replace a character
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *       a b c d
 *     0 1 2 3 4 <- insertion
 *   a 1 0 1 2 3
 *   e 2 1 1 2 3
 *   d 3 2 2 2 2
 *
 * keep track of the minimum operations from w1 to w2
 * use an array to track min ops
 *   dp[m+1][n+1]
 *   dp[i][j] represents min steps to transform from w1(0,i) to w2(0,j)
 * initial states
 *   row[0] - [0 n]
 *   col[0] - [0 m]
 * transition function
 *   if same char, dp[i][j]=dp[i-1][j-1]
 *   else get min between dp[i-1][j] dp[i][j-1] dp[i-1][j-1]
 *
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int j = 1; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    public int minDistance1(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) dp[j] = j;
        for (int i = 1; i <= m; i++) {
            int up  = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = up;
                } else {
                    dp[j] = 1 + Math.min(dp[j], Math.min(up, dp[j - 1]));
                }
                up = tmp;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        EditDistance e = new EditDistance();
        String a = "intention";
        String b = "execution";
        System.out.println(e.minDistance(a, b));
        System.out.println(e.minDistance1(a, b));
    }

}
