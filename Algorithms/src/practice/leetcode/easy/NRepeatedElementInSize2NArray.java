package practice.leetcode.easy;

import java.util.Arrays;

/**
 * @array
 *
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 *
 * Return the element repeated N times.
 */
public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        if (n / 2 < n - 1 && A[n / 2] == A[n / 2 + 1]) {
            return A[n / 2];
        }
        return A[n / 2 - 1];
    }

    public int repeatedNTimes1(int[] A) {
        for (int i = 2; i < A.length; ++i)
            if (A[i] == A[i - 1] || A[i] == A[i - 2])
                return A[i];
        return A[0];
    }
}
