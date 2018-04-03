package practice.leetcode.hard;

import java.util.Arrays;

/**
 * flights are a N*N matrix. If there is no flight from city i to city j, flights[i][j] = 0; Otherwise, flights[i][j] = 1
 * totally K weeks (7 days) to travel. only take flights at most once per day and can only take flights on each week's Monday
 * For each city, can only have vacation days in different weeks, N*K matrix called days representing this relationship
 * For the value of days[i][j], it represents the maximum days you could take vacation in the city i in the week j
 *
 * flights = [[0,1,1],[1,0,1],[1,1,0]], days = [[1,3,1],[6,0,3],[3,3,3]]
 * c 0 1 2      d 0 1 2
 * 0 0 1 1      0 1 3 1
 * 1 1 0 1      1 6 0 3
 * 2 1 1 0      2 3 3 3
 */
public class MaximumVacationDays {
    // flights N*N from i to j, has flight k 0/1
    // days    N*K max days in city i in week j

    // DP
    // k*n dp[i][j] = max days in week i to stay at city j
    // dp[i][j] = max(dp[i-1][k]) + days[j][k]
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;
        int[][] dp = new int[K][N];
        // initialize the start city and day 1
        dp[0][0] = days[0][0];
        for (int j = 1; j < N; j++) {
            dp[0][j] = flights[0][j] == 0 ? -1 : days[j][0];
        }
        for (int i = 1; i < K; i++) { // week i
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < N; j++) { // to city j
                for (int k = 0; k < N; k++) {
                    if (dp[i - 1][k] != -1 && (k == j || flights[k][j] == 1)) {
                        dp[i][j] = Math.max(dp[i - 1][k] + days[j][i], dp[i][j]);
                    }
                }
            }
        }
        int res = 0;
        for (int[] vacations : dp) {
            for (int i : vacations) {
                res = Math.max(res, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumVacationDays m = new MaximumVacationDays();
        int[][] f = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] d = {{1,1,1},{7,7,7},{7,7,7}};
        System.out.println(m.maxVacationDays(f, d));
    }

    // TLE
    int max = 0;
    int N;
    int K;
    public int maxVacationDays1(int[][] flights, int[][] days) {
        N = flights.length;
        K = days[0].length;
        dfs(flights, days, 0, 0, 0);
        return max;
    }

    private void dfs(int[][] flights, int[][] days, int fromCity, int week, int vacation) {
        if (week == K) {
            max = Math.max(max, vacation);
            return;
        }
        for (int toCity = 0; toCity < N; toCity++) {
            if (fromCity == toCity || flights[fromCity][toCity] == 1) {
                dfs(flights, days, toCity, week + 1, vacation + days[toCity][week]);
            }
        }
    }
}
