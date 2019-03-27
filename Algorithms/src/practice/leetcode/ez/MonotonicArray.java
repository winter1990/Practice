package practice.leetcode.ez;

/**
 * @array
 *
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].
 * An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 *
 * the array is either non-increasing or non-decreasing
 *
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length <= 1) return true;
        int n = A.length, inc = 0, dec = 0;
        for (int i = 1; i < n; i++) {
            if (A[i - 1] <= A[i]) inc++;
            if (A[i - 1] >= A[i]) dec++;
        }
        return (inc == n - 1) || (dec == n - 1);
    }

    public boolean isMonotonic1(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; ++i) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
    }
}
