package practice.leetcode.medium;

/**
 * @array
 * @dp
 *
 * Return the maximum profit you can make.
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2, Output: 8
 * [1, 8] and [4, 9] -> 7-2 + 5-2 = 8
 *
 * at each day, we can perform two operations:
 *   1. buy
 *   2. sell
 * if we want to buy at day i, we need to sell by i
 * if we want to sell at day i, we have to buy before i
 * the status of each depends on the other
 * use two array to store the maximum profit to make at day i
 * buy[i] represents the max money to get if we are in buy status
 *   bought already
 *   buy at day i
 * sell[i] represents the max money to get if we are in sell status
 *   sell at day i
 *   sold already
 *
 * initial status
 *   buy[0] = -price[0]
 * transition function
 *   sell[i] = max(sell[i - 1], buy[i - 1] + price[i] - fee)
 *   buy[i] = max(buy[i - 1], sell[i - 1] - prices[i])
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length, buy[] = new int[n], sell[] = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[n - 1];
    }
}
