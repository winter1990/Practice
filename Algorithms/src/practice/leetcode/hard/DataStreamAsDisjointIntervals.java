package practice.leetcode.hard;

import java.util.TreeMap;

/**
 * @array
 *
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far
 * as a list of disjoint intervals.
 *
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 *
 * when a new integer comes in, search the nearest left and right -> tree map
 */
public class DataStreamAsDisjointIntervals {

    static class SummaryRanges {
        TreeMap<Integer, Integer> intervals;
        public SummaryRanges() {
            intervals = new TreeMap<>();
        }

        public void addNum(int val) {
            if (intervals.containsKey(val) || intervals.containsValue(val)) return;
            Integer lo = intervals.floorKey(val);
            if (intervals.get(lo) > val) return;
            Integer hi = intervals.ceilingKey(val);
            boolean isMergedToLeft = false;
            boolean isMergedToRight = false;
            if (lo != null) {
                if (intervals.get(lo) == val - 1) {
                    intervals.put(lo, intervals.get(lo) + 1);
                    isMergedToLeft = true;
                }
            }
            if (hi != null) {
                if (hi == val + 1) {
                    if (isMergedToLeft) {
                        intervals.put(lo, intervals.get(hi));
                    } else {
                        intervals.put(val, intervals.get(hi));
                    }
                    intervals.remove(hi);
                    isMergedToRight = true;
                }
            }
            if (!isMergedToLeft && !isMergedToRight) intervals.put(val, val);
        }

        public int[][] getIntervals() {
            int[][] res = new int[intervals.size()][2];
            int i = 0;
            for (Integer k : intervals.keySet()) {
                res[i][0] = k;
                res[i][1] = intervals.get(k);
                i++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        s.addNum(1);
        s.addNum(3);
        s.addNum(4);
        s.addNum(2);
        s.getIntervals();
    }

}
