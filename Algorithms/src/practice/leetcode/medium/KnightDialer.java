package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @math
 *
 * translation:
 * how paths can have to hop N times
 * build the graph for all the potential steps
 * from [0,9], hop N-1 times
 *
 *
 */
public class KnightDialer {
    final int M = (int) Math.pow(10, 9) + 7;
    public int knightDialer(int N) {
        if (N == 1) return 10;
        int[][] next = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        for (int n = 1; n < N; n++) {
            int[] tmp = new int[10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < next[i].length; j++) {
                    int nextPos = next[i][j];
                    tmp[nextPos] += dp[i];
                    tmp[nextPos] %= M;
                }
            }
            dp = tmp;
        }
        int res = 0;
        for (int n : dp) res = (res + n) % M;
        return res;
    }
}
