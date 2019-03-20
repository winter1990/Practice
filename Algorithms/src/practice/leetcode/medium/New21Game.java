package practice.leetcode.medium;

/**
 * @math
 * @dp
 * @slidingwindow
 *
 * Alice starts with 0 points, and draws numbers while she has less than K points.  During each draw, she gains
 * an integer number of points randomly from the range [1, W], where W is an integer.
 * Each draw is independent and the outcomes have equal probabilities.
 * Alice stops drawing numbers when she gets K or more points.  What is the probability that she has N or less points?
 * Input: N = 10, K = 1, W = 10, Output: 1.00000
 * Input: N = 6, K = 1, W = 10, Output: 0.60000  1 2 3 4 5 6 in one draw, 6 / 10 = 0.6
 * Input: N = 21, K = 17, W = 10, Output: 0.73278
 *
 * similar question with climbing stairs
 * but for each move, we can go [1,w] steps
 *
 * start with 0, each draw [1,w], if point >= k then stop, prob to have points <= n
 * n must be bigger than k
 *
 * each draw depends on previous one(s), we want the number lands between [k,n]
 * dp[i] = possibility the land on i
 * dp[i] = sum of last w dp[] values
 * total = all possibility of last w steps -> sliding window
 *
 * n = 7 k = 5 w = 3
 *  0  1  2  3  4  5  6  7
 *  1 .3 .3 .3
 *
 */
public class New21Game {
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) return 1;
        double[] dp = new double[N + 1];
        double res = 0, total = 1;
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = total / W;
            if (i < K) {
                total += dp[i];
            } else {
                res += dp[i];
            }
            if (i - W >= 0) {
                total -= dp[i - W];
            }
        }
        return res;
    }
}