package practice.interview.google;

public class MinimumCostToCloseAllLights {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] lr = new int[m][2];
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (grid[i][l] != 1) l++;
            while (grid[i][r] != 1) r--;
            lr[i][0] = l;
            lr[i][1] = r;
        }
        int[][] cost = new int[m + 1][n];
        for (int i = 1; i <= m; i++) {
            cost[i][0] = Math.min(cost[i - 1][0] + 2 * (lr[i - 1][1] + 1) - 1, cost[i - 1][1] + n);
            cost[i][1] = Math.min(cost[i - 1][1] + 2 * (n - lr[i - 1][0]) - 1, cost[i - 1][0] + n);
        }
        return Math.min(cost[m][0], cost[m][1]);
    }

    public static void main(String[] args) {
        int[][] in = {
                {0,1,1,1,0,1,1},
                {0,0,0,0,0,1,0},
                {0,1,1,0,0,0,0},
                {0,0,1,1,1,1,0}
        };
        MinimumCostToCloseAllLights m = new MinimumCostToCloseAllLights();
        System.out.println(m.minCost(in));
    }
}
