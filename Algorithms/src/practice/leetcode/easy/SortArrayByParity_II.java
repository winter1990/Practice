package practice.leetcode.easy;

/**
 * @array
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * You may return any answer array that satisfies this condition.
 *
 *
 */
public class SortArrayByParity_II {
    public int[] sortArrayByParityII(int[] A) {
        int l = 0, r = 1, n = A.length;
        while (l < n && r < n) {
            while (l < n && l % 2 == A[l] % 2) l += 2;
            while (r < n && r % 2 == A[r] % 2) r += 2;
            if (l < n && r < n) {
                int tmp = A[l];
                A[l] = A[r];
                A[r] = tmp;
            }
        }
        return A;
    }
}
