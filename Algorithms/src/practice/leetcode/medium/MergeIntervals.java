package practice.leetcode.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @sort
 * @array
 *
 * problem to solve:
 * 1. determine whether two intervals overlapped
 * 2. how to choose the pairs of intervals to merge
 *
 * for two intervals i1 i2, i1 is before i2:
 *   case 1 - no overlap -> i1.end <= i2.start
 *   case 2 - overlap -> i1.end > i2.start -> after merging, new interval (i1.start, max(i1.end, i2.end))
 *
 * sort the list of intervals by start value
 * initially, the end the first interval i0
 * for each interval in the list:
 *   compare start with current end
 *     if overlap, merge update new end value for previous interval
 *     if no overlap, add previous to result list, and update current
 * add the pre to result set at last
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start > pre.end) {
                res.add(pre);
                pre = cur;
            } else {
                pre.end = Math.max(pre.end, cur.end);
            }
        }
        res.add(pre);
        return res;
    }
}
