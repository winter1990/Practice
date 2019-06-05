package practice.leetcode.hard;

import java.util.PriorityQueue;

/**
 * @dp
 *
 * Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles
 * east of the starting position, and has station[i][1] liters of gas.
 *
 * What is the least number of refueling stops the car must make in order to reach its destination?
 * If it cannot reach the destination, return -1.
 *
 */
public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, res = 0, fuel = startFuel;
        while (true) {
            while (i < stations.length && fuel >= stations[i][0]) {
                pq.offer(-stations[i][1]);
                i++;
            }
            if (fuel >= target) return res;
            if (pq.isEmpty()) return -1;
            fuel -= pq.poll();
            res++;
        }
    }

    /**
     * dp[i][j] represents the furthest location we can reach with j fuels by i
     * initial status
     *   start fuel for all dp[i][0]
     * transition function
     *   when at station i, two options
     *     fuel at i - if dp[i-1][j-1] >= station[i][0], then dp[i][j] = max(dp[i][j], dp[i-1][j-1]+station[i][1])
     *     not fuel at i - if j != i, dp[i][j] = max(dp[i][j], dp[i-1][j])
     *
     */
    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j != i) dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
                if (dp[i][j] >= stations[i][0])
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + stations[i][1]);
            }
        }
        for (int j = 0; j <= n; j++) {
            if (dp[n][j] >= target) return j;
        }
        return -1;
    }

    // copied from forum
    // optimize 2d to 1d
    public int minRefuelStops2(int target, int startFuel, int[][] s) {
        long[] dp = new long[s.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < s.length; ++i)
            for (int j = i; j >= 0 && dp[j] >= s[i][0]; j--)
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + s[i][1]);
        for (int t = 0; t <= s.length; ++t)
            if (dp[t] >= target) return t;
        return -1;
    }
}
