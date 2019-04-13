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
        if (A.length < 3) {
            return false;
        }
        int n = A.length;
        int i = 1;
        while (i < n && A[i - 1] < A[i]) i++;
        if (i == 1 || i == n) return false;
        while (i < n && A[i - 1] > A[i]) i++;
        return i == A.length;
    }

    public boolean validMountainArray1(int[] A) {
        int n = A.length, i = 0, j = n - 1;
        while (i + 1 < n && A[i] < A[i + 1]) i++;
        while (j > 0 && A[j - 1] > A[j]) j--;
        return i > 0 && i == j && j < n - 1;
    }
}