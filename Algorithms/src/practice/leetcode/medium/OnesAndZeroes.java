package practice.leetcode.medium;

/**
 * @knapsack
 *
 * m 0s and n 1s, find the maximum number of strings that you can form with given m and n
 */
public class OnesAndZeroes {
    // dfs
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1];

        int[] counter = new int[2]; // number of 0s and 1s
        for (String s : strs) {
            counter[0] = countChars(s, '0');
            counter[1] = countChars(s, '1');
            for (int i = m; i >= counter[0]; i--) {
                for (int j = n; j >= counter[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - counter[0]][j - counter[1]]);
                }
            }
        }
        return dp[m][n];
    }

    private int countChars(String str, char c) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(onesAndZeroes.findMaxForm(strs, m, n));
    }
}
