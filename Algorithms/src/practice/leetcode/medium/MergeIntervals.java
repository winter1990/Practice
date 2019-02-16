package practice.leetcode.medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @sort
 * @array
 *
 * to compare two intervals and merge, need to sort it first
 * only two possible ways: sort by start or end
 *
 * get end val of first interval
 * go through list
 * when to add to result - current start > pre end
 * otherwise, update end
 *
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

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
