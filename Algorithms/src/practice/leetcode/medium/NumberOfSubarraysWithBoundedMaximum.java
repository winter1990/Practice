package practice.leetcode.medium;

/**
 * @array
 *
 * We are given an array A of positive integers, and two positive integers L and R (L <= R).
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that
 * subarray is at least L and at most R.
 *
 * Input: A = [2, 1, 4, 3] L = 2, R = 3, Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 *
 * two pointers:
 * i = 0, j = 0, track the sum
 * move the j 1 by 1, calculate sum, if the sum [l, r], += j-i+1
 */
public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if (A == null || A.length == 0) return 0;
        int i = 0, n = A.length, count = 0, total = 0;
        for (int j = 0; j < n; j++) {
            if (A[j] > R) {
                i = j + 1;
                count = 0;
            } else if (A[j] >= L) {
                count = j - i + 1;
            }
            total += count;
        }
        return total;
    }

    public static void main(String[] args) {
        NumberOfSubarraysWithBoundedMaximum n = new NumberOfSubarraysWithBoundedMaximum();
        int[] in = {2,1,4,3};
        System.out.println(n.numSubarrayBoundedMax(in, 3,7));
    }
}
