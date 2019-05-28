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

    /**
     * follow up:
     * what if we want to find the minimum window for maximum profit
     * return [profit days]
     *
     * profit, min price & index, days
     * min = price[0], days = MAX, index = 0, profit = 0
     * scan through element from [1, n)
     *
     * keep track of the smallest price
     * when current price is larger, calculate profit
     *   new pro > profit, update days
     *   new pro = profit, compare and update days
     * [1 2 3 1 3 5]
     */
    public int[] getProfitAndDays(int[] a) {
        int profit = 0, min = a[0], pre = 0, days = Integer.MAX_VALUE;
        for (int i = 1; i < a.length; i++) {
            if (a[i] <= min) {
                min = a[i];
                pre = i;
            } else {
                int p = a[i] - min;
                if (p == profit) {
                    days = Math.min(days, i - pre);
                }
                if (p > profit) {
                    profit = p;
                    days = i - pre;
                }
            }
        }
        return new int[]{profit, days};
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        int[] in = {1,2,3,1,3,5};
        int[] res = b.getProfitAndDays(in);
        System.out.println(res[0] + " " + res[1]);
    }

}
