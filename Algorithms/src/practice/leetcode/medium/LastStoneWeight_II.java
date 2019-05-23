package practice.leetcode.medium;

/**
 * @array
 *
 * Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.
 * The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0
 * if there are no stones left.)
 *
 * [31,26,33,21,40]
 * if we use the method of I, [40 33 31 26 21] 9. actual result 5
 *
 * question is translated to:
 * partition the array into two parts
 * minimize the difference of the sum of two parts
 *
 * total = p1 + p2
 * diff = p1 - p2
 * -> diff = total - 2 * p2
 * we want to minimize total / 2 - p2
 * dp[i][j] represents if the subset of the array [1,j] can sum up to i
 */
public class LastStoneWeight_II {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int s : stones) total += s;
        int sum = 0, n = stones.length;
        boolean[][] dp = new boolean[total + 1][n + 1];
        for (int j = 0; j <= n; j++) dp[0][j] = true;
        for (int i = 1; i <= total / 2; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j - 1] || (stones[j - 1] <= i && dp[i - stones[j - 1]][j - 1])) {
                    dp[i][j] = true;
                    sum = Math.max(sum, i);
                }
            }
        }
        return total - 2 * sum;
    }
}
