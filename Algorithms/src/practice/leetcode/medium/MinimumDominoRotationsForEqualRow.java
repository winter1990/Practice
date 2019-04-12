package practice.leetcode.medium;

/**
 * @array
 *
 * Input: A = [2,1,2,4,2,2],
 *        B = [5,2,6,2,3,2], Output: 2
 * Input: A = [3,5,1,2,3],
 *        B = [3,6,3,3,4], Output: -1
 * two arrays, swap the values at index i, and we get an array with all elements the same
 * for the values in two arrays
 *   if same, then no need to swap
 *   if not same, swap
 *   the total count of a value minus same must >= 6
 */
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int[] ca = new int[7], cb = new int[7], same = new int[7];
        for (int i = 0; i < n; i++) {
            ca[A[i]]++;
            cb[B[i]]++;
            if (A[i] == B[i]) same[A[i]]++;
        }
        for (int i = 1; i <= 6; i++) {
            if (ca[i] + cb[i] - same[i] >= n) return Math.min(cb[i] - same[i], ca[i] - same[i]);
        }
        return -1;
    }
}
