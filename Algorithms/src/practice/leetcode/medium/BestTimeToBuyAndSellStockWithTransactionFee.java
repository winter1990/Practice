package practice.leetcode.medium;

/**
 * @array
 * @dp
 *
 * Return the maximum profit you can make.
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2, Output: 8
 * [1, 8] and [4, 9] -> 7-2 + 5-2 = 8
 *
 * for each day, two actions can be take:
 *   buy
 *   sell
 * buy[i] represents max profit if we can buy at day i, it depends on previous sell status
 * sell[i] represents max profit if we can sell at day i, it depends on previous buy status
 * initial status:
 *   buy at index 0, buy[0] = -price[0]
 *
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
