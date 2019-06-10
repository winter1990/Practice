package practice.leetcode.medium;

/**
 * @knapsack
 * @dp
 *
 * For now, suppose you are a dominator of m 0s and n 1s respectively.
 * On the other hand, there is an array with strings consisting of only 0s and 1s.
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s.
 * Each 0 and 1 can be used at most once.
 *
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * This are totally 4 strings can be formed by the using of 5 0s and 3 1s
 * 10 0001 1 0 -> 5 0s and 3 1s
 *
 * our target is m 0s and n 1s, and use as many strings as possible in the string list
 * use an array to keep track of number of strings we use to form 0 and 1
 *
 * define dp[m+1][n+1]
 * dp[i][j] represents # of strings we use to for i 0s and j 1s
 *
 * for each string
 *   count one and zero
 *   for i = [m zero]
 *     for j = [n one]
 *       option 1 - use current string 1+dp[i-zero][j-one]
 *       option 2 - not use current string d[i][j]
 * return dp[m][n]
 */
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int one = 0;
            int zero = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >=one; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zero][j - one]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(onesAndZeroes.findMaxForm(strs, m, n));
    }
}
