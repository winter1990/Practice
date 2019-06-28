package practice.leetcode.hard;

/**
 * @array
 * @dp
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 * divide array into two parts and perform at most 1 transaction in each part
 * use two arrays to store the maximum profit
 *   left to right - max profit by day i
 *   right to left - max profit by day i
 * i=[0,n-1] find the maximum of ltr[i]+rtl[i]
 */
public class BestTimeToBuyAndSellStock_III {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[] lr = new int[n], rl = new int[n];
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
            lr[i] = profit;
        }
        int max = prices[n - 1];
        profit = 0;
        for (int i = n - 2; i >= 0; i--) {
            profit = Math.max(profit, max - prices[i]);
            max = Math.max(max, prices[i]);
            rl[i] = profit;
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, lr[i] + rl[i]);
        }
        return maxProfit;
    }

    /**
     * optimization:
     * two transaction allowed
     *   if we buy first time, the first buy = -prices[i]
     *   if we sell first time, the gain = prices[i] + fist buy
     *   if we by second time, the second buy = second sell - prices[i]
     *   if we sell second time, the gain = prices[i] + second buy
     * use variables to keep track of:
     *   buy once
     *   buy once sell once
     *   buy twice
     *   buy twice sell twice
     * as we scan through the array in sequence, so the transaction is tracked in sequence
     */
    public int maxProfit1(int[] prices) {
        int oneBuy = Integer.MIN_VALUE;
        int oneBuyOneSell = 0;
        int twoBuy = Integer.MIN_VALUE;
        int twoBuyTwoSell = 0;
        for(int i = 0; i < prices.length; i++){
            oneBuy = Math.max(oneBuy, -prices[i]);
            oneBuyOneSell = Math.max(oneBuyOneSell, prices[i] + oneBuy);
            twoBuy = Math.max(twoBuy, oneBuyOneSell - prices[i]);
            twoBuyTwoSell = Math.max(twoBuyTwoSell, twoBuy + prices[i]);
        }
        return Math.max(oneBuyOneSell, twoBuyTwoSell);
    }
}
