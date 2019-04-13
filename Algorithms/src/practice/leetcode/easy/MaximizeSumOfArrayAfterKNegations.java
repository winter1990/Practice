package practice.leetcode.easy;

import java.util.Arrays;

/**
 * @array
 *
 * Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i]
 * with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)
 * Return the largest possible sum of the array after modifying it in this way.
 *
 * K even or odd
 * flip as many negative numbers as possible
 * [2 3 4 5 -1 -2 -3 -4], k = 3
 * sort first, to make sure flip the smallest negative number
 * k > number of neg, choose the smallest abs() value
 */
public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int minAbs = Integer.MAX_VALUE, n = A.length, i = 0, total = 0;
        while (i < n) {
            while (i < n && A[i] < 0 && K > 0) {
                minAbs = Math.min(minAbs, Math.abs(A[i]));
                total += -A[i++];
                K--;
            }
            minAbs = Math.min(minAbs, Math.abs(A[i]));
            total += A[i++];
        }
        if (K > 0) K %= 2;
        total += K == 1 ? -2 * minAbs : 0;
        return total;
    }

    public static void main(String[] args) {
        MaximizeSumOfArrayAfterKNegations m = new MaximizeSumOfArrayAfterKNegations();
        int[] in = {4, -1, -2,3};
        System.out.println(m.largestSumAfterKNegations(in, 2));
    }
}
