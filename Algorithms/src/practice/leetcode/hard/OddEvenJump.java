package practice.leetcode.hard;

import java.util.TreeMap;

/**
 * @map
 * @array
 * @dp
 *
 * During odd numbered jumps (ie. jumps 1, 3, 5, ...), you jump to the index j such that
 * A[i] <= A[j] and A[j] is the smallest possible value.  If there are multiple such indexes j,
 * you can only jump to the smallest such index j.
 * During even numbered jumps (ie. jumps 2, 4, 6, ...), you jump to the index j such that
 * A[i] >= A[j] and A[j] is the largest possible value.  If there are multiple such indexes j,
 * you can only jump to the smallest such index j.
 * Return the number of good starting indexes.
 *
 * when seeing the words smallest/largest possible, think about using tree map, as it provides the function floor/ceiling
 * to handle the case
 *
 * dp[n][2] start from the last index
 * dp[i][0] means whether can reach final index [n-1] with odd numbered jumps
 * dp[i][1] means whether can reach final index [n-1] with even numbered jumps
 * dp[n-1] both true
 * dp[i][0] = dp[next larger][1] as next jump will be even
 * dp[i][1] = dp[next smaller[0] as next jump will be odd
 */
public class OddEvenJump {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        boolean[][] dp = new boolean[n][2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dp[n - 1][0] = true;
        dp[n - 1][1] = true;
        map.put(A[n - 1], n - 1);
        int count = 1;
        for (int i = n - 2; i >= 0; i--) {
            Integer nextLarger = map.ceilingKey(A[i]);
            if (nextLarger != null) {
                dp[i][0] = dp[map.get(nextLarger)][1];
            }
            Integer nextSmaller = map.floorKey(A[i]);
            if (nextSmaller != null) {
                dp[i][1] = dp[map.get(nextSmaller)][0];
            }
            map.put(A[i], i);
            count += dp[i][0] ? 1 : 0;
        }
        return count;
    }
}
