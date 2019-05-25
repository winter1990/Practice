package practice.leetcode.hard;

import java.util.Arrays;

/**
 * @array
 * @math
 *
 * Given an array of integers A, consider all non-empty subsequences of A.
 * For any sequence S, let the width of S be the difference between the maximum and minimum element of S.
 * Return the sum of the widths of all subsequences of A.
 *
 * [1 2 4]
 * [1 2][2 4][1 4][1 2 4] | [1][2][4]
 *  1    2    3    3    sum = 9
 *
 * [1 2 4 7]
 * [1 2][2 4][4 7][1 4][2 7][1 7][1 2 4][1 2 7][1 4 7][2 4 7][1 2 4 7]
 *  1    2    3    3    5    6    3      6      6      5      6
 *
 * problems to solve:
 * after sorting the array, we need to count how many times an element is used as max/min
 *
 * total number of sequence: 2^n (including empty array)
 * element is max in sequences:
 *   for each element a[i] - index based
 *     there are 2^i sequences with max value a[i]
 *     res += a[i] * 2^i
 * element is min in sequences:
 *   for each element a[i] - index based
 *     there are n-1-i elements are larger then a[i]
 *     2^(n-1-i) elements with min value a[i]
 *     res -= a[i] * 2^(n-1-i)
 */
public class SumOfSubsequenceWidths {
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        int n = A.length, M = (int) Math.pow(10, 9) + 7;
        long res = 0, k = 1;
        for (int i = 0; i < n; i++) {
            res = res + ((A[i] - A[n - 1 - i]) * k) % M;
            res %= M;
            k <<= 1;
            k %= M;
        }
        return (int) res;
    }
}
