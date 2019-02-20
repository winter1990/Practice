package practice.leetcode.ez;

/**
 * @array
 *
 * you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit
 *
 * find the maximum and minimum value, max - min = max profit, so we scan the array twice
 * we can also calculate and update the profit all the time, at the same update the minimum
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int p = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            p = Math.max(p, prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return p;
    }
}
