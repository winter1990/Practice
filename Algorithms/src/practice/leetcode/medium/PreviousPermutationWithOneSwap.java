package practice.leetcode.medium;

/**
 * @array
 *
 * Given an array A of positive integers (not necessarily distinct), return the lexicographically largest
 * permutation that is smaller than A, that can be made with one swap (A swap exchanges the positions of two
 * numbers A[i] and A[j]).  If it cannot be done, then return the same array.
 *
 * reverse thinking of next permutation
 * i from [n-1,0), find the longest non increasing sub sequence
 * if i reaches the 0, then there is no solution
 * the element a[i-1] is the target to be swapped
 * then we need to find the leftmost element which is smaller than a[i-1]
 * j = [n-1, i] potentially, there might be duplicates [3 1 1 2 3]
 *   we need to skip all the larger values
 *   then skip duplicates because "lexicographically largest"
 */
public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] A) {
        int n = A.length, i = n - 1, j = n - 1;
        while (i > 0 && A[i - 1] <= A[i]) i--;
        if (i == 0) return A;
        while (A[i - 1] <= A[j]) j--;
        while (j > 0 && A[j - 1] == A[j]) j--;
        swap(A, i - 1, j);
        return A;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
