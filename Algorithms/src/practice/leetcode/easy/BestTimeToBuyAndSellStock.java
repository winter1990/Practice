package practice.leetcode.easy;

/**
 * @array
 *
 * you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit
 *
 * we scan the array twice to find the maximum and minimum value in the array
 *   profit = max - min
 * we can also calculate and update the profit along the scan, at the same update the minimum
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return profit;
    }
}
