package practice.leetcode.medium;

/**
 * @dp
 * @minimax
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess
 * the number I picked.
 *
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 *
 * we are given lower bound and upper bound of the range, and the target is unknown
 * for each guess, it can be:
 *   same as target
 *   smaller than target
 *   higher than target
 *   if not hit
 *     we pay the amount of guess number and continue the next guess
 *     we are told whether higher of lower, which means we  can narrow down the lower/upper bound
 *
 * for each guess
 *   the money we pay is based on the status of previous one, total money needed and the boundary
 *   so think about using dp to store the previous statuses
 * what status / value we need to track
 *   the money we need if the bound is [lo hi]
 *
 * dp[n+1][n+1]
 * dp[i][j] represents the money we need if the lo = i and hi = j
 * based case
 *   if i >= j, then we hit the target and no need to pay
 *   if dpi][j] != 0, we have calculated the money we need to pay, return the value
 * transition function
 *   i = [lo hi]
 *     i is the number we guess
 *     i divides the array into [lo, i) and (i, hi]
 *     the target can be in either part, to make sure we have ENOUGH money for the next guess, get max between them
 *     get the min between the current and the maximum of left and right part
 */
public class GuessNumberHigherOrLower_II {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return getAmount(1, n, dp);
    }

    private int getAmount(int lo, int hi, int[][] dp) {
        if (lo >= hi) return 0;
        if (dp[lo][hi] != 0) return dp[lo][hi];
        int res = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            res = Math.min(res, i + Math.max(getAmount(lo, i - 1, dp), getAmount(i + 1, hi, dp)));
        }
        dp[lo][hi] = res;
        return res;
    }
}
