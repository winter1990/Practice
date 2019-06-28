package practice.interview.google;

/**
 * 在一个数组里面挑数字，不能挑相邻的两个数字， 比如你挑了第二个，就不能挑第一个和第三个，问你能挑完的数字和最大是多少？
 *
 *     1 3 5 8  5  2  9  3
 * y 0 1 3 6 16 19
 * n 0 0 1 8 14 21
 *
 * 假设这个数组是个环，第一个和最后一个挨着，这个问题怎么解法
 */
public class PickNumbersForMaximumSum {
    public int maxSum(int[] arr) {
        if (arr == null) return 0;
        int n = arr.length;
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][1] + arr[i - 1];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[n][0], dp[n][1]);
    }
}
