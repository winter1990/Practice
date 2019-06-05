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
 * for each jump, whether it is feasible depends on the status of previous step -> dp
 * when seeing the word "next smallest/largest", think about using tree map, as it provides the floor/ceiling method
 * boolean dp[i][j] represents whether can reach the destination
 * dp[i][0] -> whether can reach final index with odd numbered jumps
 * dp[i][1] -> whether can reach final index with even numbered jumps
 * initial: if start at last index
 * for each step, add a[i], i in the map
 * we are looking for good START index, the start must be 1, which is odd
 * start from n-2 to 0, for current status:
 *   dp[i][0] -> next step is odd -> dp[next largest][1]
 *   dp[i][1] -> next step is even -> dp[next smallest[0]
 * if dp[i][0] = true, then count++ otherwise no, because we can only start from 1 -> odd
 */
public class OddEvenJump {
    public int oddEvenJumps(int[] A) {
        int n = A.length, res = 1;
        boolean[][] dp = new boolean[n][2]; // dp[i][0] odd, dp[i][1] even
        dp[n - 1][0] = true;
        dp[n - 1][1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            Integer nextLarger = map.ceilingKey(A[i]);
            if (nextLarger != null) dp[i][0] = dp[map.get(nextLarger)][1];
            Integer nextSmaller = map.floorKey(A[i]);
            if (nextSmaller != null) dp[i][1] = dp[map.get(nextSmaller)][0];
            map.put(A[i], i);
            if (dp[i][0]) res++;
        }
        return res;
    }
}
