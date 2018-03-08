package practice.leetcode.medium;

/**
 * 2*n: n=1 1, n=2 2(1+1), n=3 5(), n=4 11, n=5 24
 * X X X X X
 * X X X X X
 * 1 2 5 1124
 * dp[n] = dp[n-1]+dp[n-2]+2(dp[n-3]+...+dp[0])
 *       = dp[n-1]+dp[n-2]+dp[n-3]+2(dp[n-4]+...+dp[0])+dp[n-3]
 * dp[n-1]=        dp[n-2]+dp[n-3]+2(dp[n-4]+...+dp[0])
 * dp[n]-dp[n-1]=dp[n-1]+dp[n-3]
 * dp[n]=2*dp[n-1]+dp[n-3]
 *
 * tromino must be in pair
 */
public class DominoAndTrominoTiling {
    public int numTilings(int N) {
        int mod = 1000000007;
        if (N <= 0) {
            return 0;
        } else if (N <= 2) {
            return N;
        } else if (N == 3) {
            return 5;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= N; i++) {
            dp[i] = (2 * dp[i - 1] % mod + dp[i - 3] % mod) % mod;
        }
        return dp[N];
    }

    public static void main(String[] args) {
        DominoAndTrominoTiling app = new DominoAndTrominoTiling();
        int n = 30;
        System.out.println(app.numTilings(n));
    }
}
