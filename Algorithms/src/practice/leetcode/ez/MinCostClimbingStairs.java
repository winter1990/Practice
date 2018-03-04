package practice.leetcode.ez;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length <= 1) {
            return 0;
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int index = 2;
        while (index <= n) {
            dp[index] = Math.min(dp[index - 1], dp[index - 2]) + (index == n ? 0 : cost[index]);
            index++;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs mc = new MinCostClimbingStairs();
        int[] ar = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(mc.minCostClimbingStairs(ar));
    }
}
