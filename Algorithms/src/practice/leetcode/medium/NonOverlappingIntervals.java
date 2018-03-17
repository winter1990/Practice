package practice.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, find the minimum number of intervals you need to remove
 * to make the rest of the intervals non-overlapping.
 *
 * need some mechanism to sort the intervals first
 * [1,2][2,3][3,4][1,3], [1,2][1,3][2,3][3,4]
 * sort by start
 * [1,4][2,7][4,6][5,7][6,8], remove [2,7][5,7]
 * [1,4][4,6][5,7][2,7][6,8]
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        int res = 0;
        Interval pre = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];
            if (cur.start >= pre.end) {
                pre = cur;
            } else {
                res++;
            }
        }
        return res;
    }
}
