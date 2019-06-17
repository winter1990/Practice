package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @array
 *
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0) return new int[][]{};
        // Arrays.sort(A, (a, b) -> (a[0] - b[0]));
        // Arrays.sort(B, (a, b) -> (a[0] - b[0]));
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int[] a = A[i], b = B[j];
            int end = Math.min(a[1], b[1]);
            int start = Math.max(a[0], b[0]);
            if (start <= end) {
                res.add(new int[]{start, end});
            }
            if (end == a[1]) i++;
            if (end == b[1]) j++;
        }
        int[][] arr = new int[res.size()][2];
        for (int k = 0; k < res.size(); k++) arr[k] = res.get(k);
        return arr;
    }
}
