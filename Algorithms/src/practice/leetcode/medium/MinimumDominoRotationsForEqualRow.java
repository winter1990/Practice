package practice.leetcode.medium;

/**
 * @array
 *
 * translation:
 * given two integer arrays
 * do minimum swap of A[i] and B[i] so that one of the array has the same elements
 *
 * Input: A = [2,1,2,4,2,2],
 *        B = [5,2,6,2,3,2], Output: 2
 * Input: A = [3,5,1,2,3],
 *        B = [3,6,3,3,4], Output: -1
 *
 *
 * two arrays, swap the values at index i, and we get an array with all elements the same
 * for the values in two arrays
 *   if same, then no need to swap
 *   if not same, swap
 *   the total count of a value minus same must >= 6
 */
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == A[0] || B[i] == A[0]); i++) {
            if (A[i] != A[0]) a++;
            if (B[i] != A[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        for (int i = 0, a = 0, b = 0; i < n && (A[i] == B[0] || B[i] == B[0]); i++) {
            if (A[i] != B[0]) a++;
            if (B[i] != B[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }
        return -1;
    }

    // more tricky solution
    public int minDominoRotations1(int[] A, int[] B) {
        int n = A.length;
        int[] ca = new int[7], cb = new int[7], same = new int[7];
        for (int i = 0; i < n; i++) {
            ca[A[i]]++;
            cb[B[i]]++;
            if (A[i] == B[i]) same[A[i]]++;
        }
        for (int i = 1; i <= 6; i++) {
            if (ca[i] + cb[i] - same[i] == n) {
                return Math.min(n - ca[i], n - cb[i]);
            }
        }
        return -1;
    }
}
