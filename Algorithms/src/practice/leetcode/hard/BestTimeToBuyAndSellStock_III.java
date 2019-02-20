package practice.leetcode.hard;

/**
 * @array
 * @dp
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 * from left to right and right to left
 * create two dp array to track the maximum profit in the subarray
 */
public class BestTimeToBuyAndSellStock_III {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] lr = new int[n];
        int[] rl = new int[n];
        int min = prices[0];
        int p = 0;
        for (int i = 1; i < n; i++) {
            p = Math.max(p, prices[i] - min);
            min = Math.min(min, prices[i]);
            lr[i] = p;
        }
        int max = prices[n - 1];
        p = 0;
        for (int i = n - 2; i >= 0; i--) {
            p = Math.max(p, max - prices[i]);
            max = Math.max(max, prices[i]);
            rl[i] = p;
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, lr[i] + rl[i]);
        }
        return maxProfit;
    }
}
