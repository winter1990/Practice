package practice.leetcode.medium;

import java.util.Arrays;

/**
 * @array
 *
 * Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K,
 * and add x to A[i] (only once).
 * After this process, we have some array B.
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 *
 * Input: A = [0,10], K = 2
 * Output: 6
 * Explanation: B = [2,8]
 *
 * after sorting the array, the array should be divided into two parts:
 *   left part - all elements + k - smallest value a[0]-k
 *   right part - all elements - k - largest value a[n-1]+k
 *   OR
 *   all element +k, so the result is a[n-1]-a[0]
 */
public class SmallestRange_II {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length, res = A[n - 1] - A[0], l = A[0] + K, r = A[n - 1] - K;
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(A[i] + K, r);
            int min = Math.min(A[i + 1] - K, l);
            res = Math.min(max - min, res);
        }
        return res;
    }
}