package practice.leetcode.ez;

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
