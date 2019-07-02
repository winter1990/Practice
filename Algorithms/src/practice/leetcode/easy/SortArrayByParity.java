package practice.leetcode.easy;

/**
 * @array
 * @sort
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 *
 * two pointers:
 * start from 0 and n-1, while s < e
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        for (int i = -1, j = 0; j < A.length; j++) {
            if (A[j] % 2 == 0) {
                int tmp = A[j];
                A[j] = A[++i];
                A[i] = tmp;
            }
        }
        return A;
    }

    public int[] sortArrayByParity1(int[] A) {
        int s = 0, e = A.length - 1;
        while (s < e) {
            while (s < A.length && A[s] % 2 == 0) {
                s++;
            }
            while (e >= 0 && A[e] % 2 == 1) {
                e--;
            }
            if (s < e) {
                swap(A, s, e);
                s++;
                e--;
            }
        }
        return A;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
