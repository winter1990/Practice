package practice.leetcode.ez;

import java.util.Arrays;

public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int n = A.length - 1;
        if (A[n / 2] == A[n / 2 - 1]) {
            return A[n / 2];
        }
        return A[n / 2 + 1];
    }

    public int repeatedNTimes1(int[] A) {
        for (int i = 2; i < A.length; ++i)
            if (A[i] == A[i - 1] || A[i] == A[i - 2])
                return A[i];
        return A[0];
    }
}
