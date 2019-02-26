package practice.leetcode.hard;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        int i = 0;
        for (; i < intervals.size(); i++) {
            Interval tmp = intervals.get(i);
            if (newInterval.end < tmp.start) {
                break;
            } else if (newInterval.start > tmp.end) {
                res.add(tmp);
            } else {
                newInterval.start = Math.min(newInterval.start, tmp.start);
                newInterval.end = Math.max(newInterval.end, tmp.end);
            }
        }
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
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