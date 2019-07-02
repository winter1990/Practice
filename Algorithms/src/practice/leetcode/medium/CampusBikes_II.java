package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @array
 *
 * On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M.
 * Each worker and bike is a 2D coordinate on this grid.
 *
 * We assign one unique bike to each worker so that the sum of the Manhattan distances between each worker and their
 * assigned bike is minimized.
 *
 * The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
 *
 * Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.
 *
 * method 1 - dfs
 * try all the permutations of the workers and bikes
 *
 * method 2 - dp
 * the minimal distance = ith worker with jth bike + distance of i-1 workers with i-1 bikes (not include jth bike)
 * use a dp array to track the min distance with first i workers
 *   dp[i][j] represents min distance of i workers with state j
 *
 */
public class CampusBikes_II {
    int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] visitedBike = new boolean[bikes.length];
        dfs(workers, 0, bikes, 0, visitedBike);
        return min;
    }

    private void dfs(int[][] workers, int i, int[][] bikes, int distance, boolean[] visitedBike) {
        if (i == workers.length) {
            min = Math.min(min, distance);
            return;
        } else if (distance >= min) {
            return;
        }
        for (int j = 0; j < bikes.length; j++) {
            if (visitedBike[j]) continue;
            visitedBike[j] = true;
            dfs(workers, i + 1, bikes, distance + getDistance(workers[i], bikes[j]), visitedBike);
            visitedBike[j] = false;
        }

    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    public static void main(String[] args) {
        CampusBikes_II c = new CampusBikes_II();
        int[][] w = {{0,0},{1,1},{2,0}};
        int[][] b = {{1,0},{2,2},{2,1},{0,3}};
        System.out.println(c.assignBikes(w,b));
    }

    public int assignBikes1(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        int[][] dp = new int[n + 1][1 << m]; // bit to represent bike used or not
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE / 2);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) { // for all workers - 1 2 3...n
            for (int s = 1; s < (1 << m); s++) { // state of bikes - 1 10 11 100 101 110...
                for (int j = 0; j < m; j++) {
                    if ((s & (1 << j)) == 0) { // 1 10 100...
                        continue;
                    }
                    int prev = s ^ (1 << j); // exclude the bike 1 << j
                    dp[i][s] = Math.min(dp[i][s], dp[i - 1][prev] + dis(workers[i - 1], bikes[j])) ;
                    if (i == n) {
                        min = Math.min(min, dp[i][s]);
                    }
                }
            }
        }
        return min;
    }

    public int dis(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
