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
 *
 *
 */
public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray1(int[] A) {
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray2(int[] A) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid - 1] < A[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}
