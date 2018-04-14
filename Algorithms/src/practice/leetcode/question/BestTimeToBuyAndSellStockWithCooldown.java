package practice.leetcode.question;

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
 * 3 possible transactions - buy, sell, rest:
 * buy[i] means before day i what is the maxProfit for any sequence end with buy
 * sell[i] means before day i what is the maxProfit for any sequence end with sell
 * rest[i] means before day i what is the maxProfit for any sequence end with rest
 *
 * we need to rest before buy
 * we need to buy before sell
 *
 * rest[i]>=buy[i], rest[i]=max(rest[i-1],sell[i-1])
 * another observation: sell[i]>=rest[i] is true
 * so, rest[i] = sell[i-1]
 * buy[i] = max(sell[i-2]-price, buy[i-1])
 * sell[i] = max(buy[i-1]+price, sell[i-1])
 *
 * Since states of day i relies only on i-1 and i-2 we can reduce the O(n) space to O(1).
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int sell = 0;
        int prev_sell = 0;
        int buy = Integer.MIN_VALUE;
        int prev_buy;
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
