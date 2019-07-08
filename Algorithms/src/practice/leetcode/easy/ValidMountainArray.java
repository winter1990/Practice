package practice.leetcode.easy;

/**
 * @array
 *
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 *
 * it must have only one peak
 * cannot do binary search because even if it is increasing or decreasing, there might be another peak in the array
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j && A[i] < A[i + 1]) i++;
        while (i < j && A[j - 1] > A[j]) j--;
        return i > 0 && j < A.length - 1 && i == j;
    }
}
