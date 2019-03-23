package practice.leetcode.medium;

/**
 * @string
 *
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same,
 * where in each step you can delete one character in either string.
 *
 * similar with edit distance
 * dp[i][j] means the minimum number of steps to convert w1.substring(0,i) to w2.substring(0,j)
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        if (l1 == 0) return l2;
        if (l2 == 0) return l1;
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) dp[i][0] = i;
        for (int j = 1; j <= l2; j++) dp[0][j] = j;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                }
            }
        }
        return dp[l1][l2];
    }
}
