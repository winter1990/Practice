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
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new Interval[]{};
        }
        List<Interval> res = new ArrayList<>();
        int indexA = 0, indexB = 0;
        while (indexA < A.length && indexB < B.length) {
            Interval i1 = A[indexA];
            Interval i2 = B[indexB];

            int st = Math.max(i1.start, i2.start);
            int end = Math.min(i1.end, i2.end);
            if (st <= end) {
                res.add(new Interval(st, end));
            }
            if (end == i1.end) {
                indexA++;
            }
            if (end == i2.end) {
                indexB++;
            }
        }
        return res.toArray(new Interval[res.size()]);
    }
}
