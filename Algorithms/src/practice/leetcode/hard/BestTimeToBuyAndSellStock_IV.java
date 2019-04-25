package practice.leetcode.hard;

/**
 * @array
 * @dp
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again)
 * Input: [3,2,6,5,0,3], k = 2, Output: 7 -> buy 2 sell 6, buy 0 sell 3
 *
 * problems to solve:
 * 1. sell before buy again
 * 2. at most k transactions
 * 3. maximize the total profit
 *
 * use a dp array to track the max profit
 * dp[k+1][len], dp[i][j] represents at most i transaction(s), before j in prices[] array
 *
 * initial status:
 *   dp[i][0], only one data point, so can not make any profit
 *   dp[0][j], 0 transaction so 0 profit
 *
 * for dp[i][j] there are two cases:
 *   no transaction on jth day -> dp[i][j - 1]
 *   have transaction on jth day -> most profit we get -> (price[j] - price[m] + dp[i - 1][m]), m = [0,j-1]
 */
public class BestTimeToBuyAndSellStock_IV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {
            int p = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) p += prices[i] - prices[i - 1];
            }
            return p;
        }
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int pre = dp[i - 1][0] - prices[0]; // assume we buy at first day
            for (int j = 1; j < n; j++) {
                // 1. not use the current price to sell
                // 2. use the current new price, and execute one transaction
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + pre);
                // need to decide if we want to use current price as buying price, for next iteration
                // 1. do not buy new stock
                // 2. buy new stock
                pre =  Math.max(pre, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock_IV b = new BestTimeToBuyAndSellStock_IV();
        //6,3,7,2,9,4
        int[] input = {6,3,7,2,9,5,8};
        int t = 2;
        System.out.println(b.maxProfit(t, input));
    }
}
