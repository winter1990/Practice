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
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        for (; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[1] < newInterval[0]) {
                list.add(cur);
            } else if (cur[0] > newInterval[1]) {
                break;
            } else {
                newInterval[0] = Math.min(newInterval[0], cur[0]);
                newInterval[1] = Math.max(newInterval[1], cur[1]);
            }
        }
        list.add(newInterval);
        while (i < intervals.length) list.add(intervals[i++]);
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;
    }
}

