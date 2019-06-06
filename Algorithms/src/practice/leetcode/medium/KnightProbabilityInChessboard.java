package practice.leetcode.medium;

/**
 * @dp
 *
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves.
 * Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random
 * (even if the piece would go off the chessboard) and moves there.
 *
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard.
 * Return the probability that the knight remains on the board after it has stopped moving.
 *
 * recursively traverse 8 directions
 * if out of the board 0
 * if k = 0, return 1
 * for each direction
 *   res += 1/8 * prob(N, K, r + d[0], c + d[1])
 * return res
 */
public class KnightProbabilityInChessboard {
    int[][] dirs = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K + 1];
        return getProb(N, K, r, c, dp);
    }

    private double getProb(int n, int k, int r, int c, double[][][] dp) {
        if (r < 0 || r >= n || c < 0 || c >= n) return 0;
        if (k == 0) return 1;
        if (dp[r][c][k] != 0) return dp[r][c][k];
        double p = 0;
        for (int[] d : dirs) {
            p += 0.125 * getProb(n, k - 1, r + d[0], c + d[1], dp);
        }
        dp[r][c][k] = p;
        return p;
    }

    // lte solution
    public double knightProbability1(int N, int K, int r, int c) {
        return prob(N, K, r, c);
    }

    private double prob(int N, int K, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) return 0;
        if (K == 0) return 1;
        double res = 0;
        for (int[] d : dirs) {
            res += 0.125 * prob(N, K, r + d[0], c + d[1]);
        }
        return res;
    }
}
