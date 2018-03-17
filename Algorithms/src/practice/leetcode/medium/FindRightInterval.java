package practice.leetcode.medium;

import java.util.*;

/**
 * for each of the interval i, check if there exists an interval j whose start point is bigger than
 * or equal to the end point of the interval i, which can be called that j is on the "right" of i.
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j
 * has the minimum start point to build the "right" relationship for interval i
 * You may assume none of these intervals have the same start point.
 *
 * [1,4][2,6][4,5][5,7]
 */
public class FindRightInterval {
    // find the smallest number that is larger than some specific value
    // tree map is always an option
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            treeMap.put(intervals[i].start, i);
        }
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(intervals[i].end);
            res[i] = entry == null ? -1 : entry.getValue();
        }
        return res;
    }

    // TLE for large input size
    public int[] findRightInterval1(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j].start >= intervals[i].end) {
                    res[map.get(intervals[i].start)] = map.get(intervals[j].start);
                    break;
                }
                res[map.get(intervals[i].start)] = -1;
            }
        }
        res[map.get(intervals[intervals.length - 1].start)] = -1;
        return res;
    }
}
