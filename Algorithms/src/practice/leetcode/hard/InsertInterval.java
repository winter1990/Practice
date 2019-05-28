package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @array
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 *
 * problems to solve:
 * 1. the new interval may overlap / no overlap with current intervals
 * 2. the new interval may have multiple overlapping
 *
 * for each interval, there might be following scenarios:
 *   before the new interval - add to result
 *   after the new interval - break (no need to continue comparing with new interval)
 *   overlap
 *     new interval.start = min(cur, newInterval)
 *     new interval.end = max(cur, newInterval)
 *   because we may break at some point, need add the rest of intervals into result set
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        for (; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (newInterval.end < cur.start) {
                break;
            } else if (newInterval.start > cur.end) {
                res.add(cur);
            } else {
                newInterval.start = Math.min(newInterval.start, cur.start);
                newInterval.end = Math.max(newInterval.end, cur.end);
            }
        }
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

