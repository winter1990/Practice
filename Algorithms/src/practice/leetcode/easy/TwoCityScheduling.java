package practice.leetcode.easy;

import java.util.Arrays;

/**
 * @array
 *
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
 * and the cost of flying the i-th person to city B is costs[i][1].
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 * translation:
 * in 2d array, pick n numbers from arr[i][0] and n numbers from arr[i][1]
 * minimum the sum
 *
 * problems to solve:
 * 1. pick exactly n from index 0 and n from index 1
 * 2. minimum the sum of total
 *
 * Input: [[10,20],[30,200],[400,50],[30,20]] Output: 110
 * which one to consider first: the one that has biggest difference
 * intuition: sort by difference cost[1]-cost[0]
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> ((a[0] - a[1]) - (b[0] - b[1])));
        int res = 0;
        for (int i = 0 ; i < costs.length / 2; i++) res += (costs[i][0] + costs[costs.length - 1 - i][1]);
        return res;
    }

    /**
     * @dp
     * use dp array to store the cost
     * dp[i][j] represents i people to city A and j people to city B, final status should be n to A and n to B
     * initial status:
     * i = [1,n] dp[i][0] = cost[i][0]
     * j = [1,n] dp[0][j] = cost[j][1]
     * for both, we consider first n people for now
     *
     * for (i+j)th person, we can either choose A or B as destination
     *   if A, dp[i][j] = cost[i+j-1][0] + dp[i-1][j]
     *   if B, dp[i][j] = cost[i+j-1][1] + dp[i][j-1]
     * return dp[n][n]
     * n = cost.len/2
     */
    public int twoCitySchedCost1(int[][] costs) {
        int n = costs.length / 2;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        for (int j = 1; j <= n; j++) dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return dp[n][n];
    }
}
