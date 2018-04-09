package practice.interview.other;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Wang, Zihan
 *
 * Basic Steps:
 * - sort the collection of zip code interval by start value
 * - compare the interval i1 and i2:
 *   scenario 1: i1.end + 1 < i2.start  - no overlap, add to result list
 *   scenario 2: i1.end + 1 <= i2.start - zip code overlapped, should be merged
 * - get the result list
 *
 */

public class WilliamsSonomaCodingChallenge {
    public List<ZipCodeInterval> merge(List<ZipCodeInterval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new intervalComparator());
        List<ZipCodeInterval> res = new LinkedList<>();
        ZipCodeInterval pre = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            ZipCodeInterval cur = intervals.get(i);
            if (cur.getStart() > pre.getEnd() + 1) {
                res.add(pre);
                pre = cur;
            } else {
                pre.setEnd(Math.max(pre.getEnd(), cur.getEnd()));
            }
        }
        res.add(pre);
        return res;
    }

    private class intervalComparator implements Comparator<ZipCodeInterval> {
        public int compare(ZipCodeInterval i1, ZipCodeInterval i2) {
            return i1.getStart() - i2.getStart();
        }
    }

}
