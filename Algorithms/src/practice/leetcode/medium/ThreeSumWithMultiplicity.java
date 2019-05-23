package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @search
 *
 * Given an integer array A, and an integer target, return the number of tuples i, j, k  such that i < j < k
 * and A[i] + A[j] + A[k] == target.
 * As the answer can be very large, return it modulo 10^9 + 7.
 *
 */
public class ThreeSumWithMultiplicity {
    // 592 ms
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, m = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < A.length; i++) {
            res += map.getOrDefault(target - A[i], 0);
            res %= m;
            for (int j = 0; j < i; j++) {
                int sum = A[i] + A[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return res;
    }

    public int threeSumMulti1(int[] A, int target) {
        int m = (int) Math.pow(10, 9) + 7;
        int[][] dp = new int[target + 1][4];
        dp[0][0] = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = target; j >= A[i]; j--) {
                for (int k = 3; k >= 1; k--) {
                    dp[j][k] = dp[j - A[i]][k - 1];
                    dp[j][k] %= m;
                }
            }
        }
        return dp[target][3];
    }
}
