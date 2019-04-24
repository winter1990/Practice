package practice.leetcode.medium;

/**
 * @array
 *
 * Given an array A of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous)
 * subarrays, which have lengths L and M
 *
 * Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2 Output: 20
 * Input: A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2 Output: 29
 * Input: A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3 Output: 31
 *
 * problems to solve:
 * 1. find two subarrays that maximize the sum
 * 2. non-overlapping
 *
 * if one subarray, sliding window and one pass
 * for two windows, we can fix one window and slide the other
 *
 * optimization:
 * calculate pre sum
 * L and M - M can be before or after L - get separately
 * for i = [l+m,n]
 *
 *  [2,1,5,6,0,9,5,0,3,8] l = 4, m = 3
 *         0 1 2 3  4  5  6  7  8  9 10
 * preSum: 0 2 3 8 14 14 23 28 28 31 39
 *
 */
public class MaximumSumOfTwoNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) preSum[i + 1] = preSum[i] + A[i];
        return Math.max(getMaxSum(preSum, L, M), getMaxSum(preSum, M, L));
    }

    private int getMaxSum(int[] preSum, int l, int m) {
        int res = 0;
        for (int i = l + m, lmax = 0; i < preSum.length; i++) {
            lmax = Math.max(lmax, preSum[i - m] - preSum[i - m - l]);
            res = Math.max(res, lmax + (preSum[i] - preSum[i - m]));
        }
        return res;
    }
}
