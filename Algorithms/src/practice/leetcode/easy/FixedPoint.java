package practice.leetcode.easy;

/**
 * @array
 *
 * Given an array A of distinct integers sorted in ascending order, return the smallest index i that satisfies A[i] == i.
 * Return -1 if no such i exists.
 *
 * method 1 - linear search
 * i = [0, n-1], compare i and A[i]
 *
 * method 2 - binary search
 * two pointers 0, n-1
 *   0 1 2 3 4 5 6
 * [-1 0 2 3 5 7 9]
 */
public class FixedPoint {
    public static int fixedPoint(int[] A) {
        int start = 0, end = A.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > mid) {
                end = mid - 1;
            } else if (A[mid] < mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start == A[start] ? start : -1;
    }

    public static void main(String[] args) {
        int[] in = {-1, 0, 1, 2, 3, 4, 7};
        System.out.println(fixedPoint(in));
    }
}
