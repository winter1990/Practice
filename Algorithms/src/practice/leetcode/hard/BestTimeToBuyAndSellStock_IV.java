package practice.leetcode.hard;

import java.util.Arrays;

/**
 * @array
 * @dp
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again)
 * Input: [2,4,1], k = 2, Output: 2 -> buy 2, sell 4
 * Input: [3,2,6,5,0,3], k = 2, Output: 7 -> buy 2 sell 6, buy 0 sell 3
 *
 * dp[i][j] stores the maximum profit up to i transactions until prices j
 * dp[i][j] = max between
 * 1. no transaction on jth day -> dp[i][j - 1]
 * 2. have transaction on jth day -> most profit we get -> (price[j] - price[m] + dp[i - 1][m]), m = [0,j-1]
 *
 */
public class BestTimeToBuyAndSellStock_IV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) {
            int profit = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
            }
            return profit;
        }

        int[][] dp = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax); // get max between transaction with no transaction
                tmpMax =  Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }

    public int maxProfit1(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) {
            int max = 0;
            for (int i = 0; i < len - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    max += (prices[i + 1] - prices[i]);
                }
            }
            return max;
        }

        int[] maxProfit = new int[k + 1];
        int[] lowPrice = new int[k + 1];
        Arrays.fill(lowPrice, Integer.MAX_VALUE);
        for (int price : prices) {
            for (int i = k; i >= 1; i--) {
                maxProfit[i] = Math.max(maxProfit[i], price - lowPrice[i]);
                lowPrice[i] = Math.min(lowPrice[i], price - maxProfit[i - 1]);
            }
        }
        return maxProfit[k];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock_IV b = new BestTimeToBuyAndSellStock_IV();
        //6,3,7,2,9,4
        int[] input = {6,3,7,2,9,5,8};
        int t = 2;
        System.out.println(b.maxProfit(t, input));
    }
}
