package practice.interview;

public class MaximumProfitWIthSmallestWindow {
    public int[] maxProfit(int[] a) {
        int n = a.length;
        int[] res = new int[2];
        int min = Integer.MAX_VALUE, day = Integer.MAX_VALUE, last = -1, profit = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= min) {
                min = a[i];
                last = i;
            }
            if (a[i] - min == profit) {
                day = Math.min(day, i - last + 1);
            } else if (a[i] - min > profit) {
                day = i - last + 1;
            }
            profit = Math.max(profit, a[i] - min);
        }
        return new int[]{profit, day};
    }

    public static void main(String[] args) {
        MaximumProfitWIthSmallestWindow m = new MaximumProfitWIthSmallestWindow();
        int[] in = {1,2,3,1,4,};
        int[] res = m.maxProfit(in);
        System.out.println(res[0] + " " + res[1]);
    }
}
