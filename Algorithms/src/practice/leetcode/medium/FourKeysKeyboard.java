package practice.leetcode.medium;

/**
 * @dp
 *
 * A, CtrlA, CtrlC CtrlV
 * N=3, 3(AAA)
 * N=7, 9(AAA CtrlA+C+V+V)
 *
 * options:
 * A - current + 1
 * CtrlA+C buffer=current
 * CtrlV   current+=buffer
 * totally 3 steps needed
 *
 * 0 1 2 3 4 5 6 7
 *   i = 4
 *
 */
public class FourKeysKeyboard {
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j <= i - 3; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        return dp[N];
    }

    public int maxA1(int n) {
        int max = n;
        for (int i = 1; i <= n - 3; i++)
            max = Math.max(max, maxA1(i) * (n - i - 1));
        return max;
    }
}
