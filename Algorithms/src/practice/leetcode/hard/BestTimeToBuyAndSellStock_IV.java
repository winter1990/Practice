package practice.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 */
public class BestTimeToBuyAndSellStock_IV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) {
            int max = 0;
            for (int i = 0; i < len - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    max += (prices[i + 1] - prices[i]);
                }
            }
            return max;
        }

        int[] maxProfit = new int[k + 1];
        int[] lowPrice = new int[k + 1];
        Arrays.fill(lowPrice, Integer.MAX_VALUE);
        for (int price : prices) {
            for (int i = k; i >= 1; i--) {
                maxProfit[i] = Math.max(maxProfit[i], price - lowPrice[i]);
                lowPrice[i] = Math.min(lowPrice[i], price - maxProfit[i - 1]);
            }
        }
        return maxProfit[k];
    }

    // wrong
    public int maxProfit1(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            int current = prices[i];
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] =  prices[j - 1] - current < 0 ? 0 : prices[j - 1] - current;
            }
        }
        int max = 0;
        int profit = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for (int i = 1; i <= n; i++) {
            max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[j][i]);
            }
            pq.offer(max);
        }
        for (int i = 0; i < k; i++) {
            profit += pq.poll();
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock_IV b = new BestTimeToBuyAndSellStock_IV();
        //6,3,7,2,9,4
        int[] input = {6,3,7,2,9,4,8};
        int t = 2;
        System.out.println(b.maxProfit(t, input));
    }
}
