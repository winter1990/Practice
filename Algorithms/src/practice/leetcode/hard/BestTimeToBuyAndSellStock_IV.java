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
 * define an array to track the maximum profit with k transactions at day i
 * dp[k+1][n]
 *   dp[i][j] represents maximum profit at day i, with i transactions
 * for each transaction
 *   we need one buy + one sell
 *   sell after buy
 * on day j, two cases
 *   case 1 - do not buy or sell, dp the dp[i][j] = dp[i][j-1]
 *   case 2 - sell at day j
 *     before day j, we have bought at day k, k =[0,j-1]
 *     and the profit we get by day k is dp[i-1][k]
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
            int pre = -prices[0]; // assume we buy at first day
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
