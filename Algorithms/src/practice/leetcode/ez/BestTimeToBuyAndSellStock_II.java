package practice.leetcode.ez;

public class BestTimeToBuyAndSellStock_II {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int p = 0;
        for (int i = 1; i < prices.length; i++) {
            p = prices[i] - prices[i - 1] > 0 ? p + prices[i] - prices[i - 1] : p;
        }
        return p;
    }
}
