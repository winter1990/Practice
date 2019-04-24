package practice.leetcode.medium;

/**
 * @dp
 *
 * There are two types of soup: type A and type B. Initially we have N ml of each type of soup
 * 4 operations:
 * 1 Serve 100 ml of soup A and 0 ml of soup B
 * 2 Serve 75 ml of soup A and 25 ml of soup B
 * 3 Serve 50 ml of soup A and 50 ml of soup B
 * 4 Serve 25 ml of soup A and 75 ml of soup B
 * When we serve some soup, we give it to someone and we no longer have it.
 * Each turn, we will choose from the four operations with equal probability 0.25
 * If the remaining volume of soup is not enough to complete the operation, we will serve as much as we can.
 * We stop once we no longer have some quantity of both types of soup
 * Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time
 *
 * Input: N = 50, Output: 0.625
 * if 1 and 2, A will be empty first
 * if 3, both will be empty
 *
 * problems to solve:
 * 1. A empty first
 * 2. A and B empty at the same time
 *
 * A - 4 3 2 1
 * B - 0 1 2 3
 *
 */
public class SoupServings {
    public double soupServings(int N) {
        if (N > 5000) return 1.0;
        double[][] dp = new double[N + 1][N + 1];
        return dfs(N, N, dp);
    }

    private double dfs(int a, int b, double[][] dp) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0;
        if (dp[a][b] > 0) return dp[a][b];
        dp[a][b] = 0.25 * (dfs(a - 100, b, dp)
                + dfs(a - 75, b - 25, dp)
                + dfs(a - 50, b - 50, dp)
                + dfs(a - 25, b - 75, dp));
        return dp[a][b];
    }
}
