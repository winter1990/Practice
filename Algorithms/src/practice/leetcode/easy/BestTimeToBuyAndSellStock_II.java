package practice.leetcode.easy;

/**
 * @array
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 *
 * find all the increasing two elements in the array
 * as long as a[i] > a[i-1], we can add a[i]-a[i-1] to total profit, i=[1,n)
 */
public class BestTimeToBuyAndSellStock_II {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int p = 0;
        for (int i = 1; i < prices.length; i++) {
            p += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return p;
    }
}
