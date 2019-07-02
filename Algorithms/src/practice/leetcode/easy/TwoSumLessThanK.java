package practice.leetcode.easy;

import java.util.Arrays;

/**
 * @array
 *
 * Given an array A of integers and integer K, return the maximum S such that there exists i < j with A[i] + A[j] = S
 * and S < K. If no i, j exist satisfying this equation, return -1.
 *
 * sort
 * two pointer from head and tail
 * get the maximum of the sum
 */
public class TwoSumLessThanK {
    public static int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int res = -1;
        int i = 0, j = A.length - 1;
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum < K) {
                res = Math.max(res, sum);
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = {34,23,1,24,75,33,54,8};
        System.out.println(twoSumLessThanK(in, 60));
    }
}
