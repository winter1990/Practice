package practice.leetcode.medium;

/**
 * @array
 * @dp
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process/122381
 *
 * You may complete as many transactions as you like
 * You may not engage in multiple transactions at the same time
 * After you sell your stock, you cannot buy stock on next day
 *
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 *
 * rest before buy again
 * buy again before sell
 *
 * 1. define states
 *   3 possible states - buy, sell, rest/cooldown:
 *   buy[i] means by day i, the maxProfit end with buy
 *   sell[i] means by day i, the maxProfit end with sell
 *   rest[i] means by day i, the maxProfit end with rest
 *
 * 2. define recursion
 *   buy[i] - if we want to buy at day i
 *     not buying, take a rest at i
 *     sell at or before i-2, then we can buy at i
 *   sell[i] = max(buy[i-1]+price, sell[i-1])
 *     not selling, take a rest at i
 *     buy at or before i-1, then sell at day i
 *
 * 3. conclude formula
 *   buy[i] = max(buy[i-1], sell[i-2]-prices[i])
 *   sell[i] = max(sell[i-1], buy[i-1]+prices[i])
 *
 * 4. optimization
 *   Since states of day i relies only on i-1 and i-2 we can reduce the O(n) space to O(1).
 *   b2 b1 b0 -> buy[i-2] buy[i-1] buy[i]
 *   s2 s1 s0 -> sell[i-2] sell[i-1] sell[i]
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int b0 = -prices[0], b1 = b0;
        int s2 = 0, s1 = 0, s0 = 0;
        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }

    public int maxProfit1(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] in = {1, 2, 3, 0, 2};
        BestTimeToBuyAndSellStockWithCooldown b = new BestTimeToBuyAndSellStockWithCooldown();
        b.maxProfit(in);
    }
}
