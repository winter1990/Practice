package practice.leetcode.easy;

/**
 * @array
 * @bianrysearch
 *
 * Given an array that is definitely a mountain, return any i such that
 * A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * method 1:
 * linear search
 *
 * method 2:
 * binary search
 * as no continuous duplicates and len >= 3
 */
public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int s = 0, e = A.length;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (A[mid] > A[mid + 1]) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}
