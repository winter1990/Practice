package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @array
 * @binarysearch
 *
 * A triple booking happens when three events have some non-empty intersection
 * (ie., there is some time that is common to all 3 events.)
 *
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(50, 60); // returns true
 * MyCalendar.book(10, 40); // returns true
 * MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true
 * MyCalendar.book(25, 55); // returns true
 *
 * cannot have triple overlap area
 * so, if there are two intervals overlap, it is ok
 * so we need to keep track of the existing overlapped intervals, and all the intervals
 * if we have a list of intervals:
 *   case 1: |----------|
 *             |-----|
 *   case 2: |----------|
 *                  |-----|
 *   case 3: |----------|
 *                        |--|
 *
 */
public class MyCalendar_II {

    /**
     * use two list to store the intervals and overlaps
     */
    class MyCalendarTwo1 {
        List<int[]> cal;
        List<int[]> overlaps;
        public MyCalendarTwo1() {
            cal = new ArrayList<>();
            overlaps = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] i : overlaps) {
                if (Math.max(start, i[0]) < Math.min(end, i[1])) return false;
            }
            for (int[] i : cal) {
                int s = Math.max(i[0], start);
                int e = Math.min(i[1], end);
                if (s < e) {
                    overlaps.add(new int[]{s, e});
                }
            }
            cal.add(new int[]{start, end});
            return true;
        }
    }

    /**
     * @treemap
     *
     * the whole calendar/list should be balanced
     * start means +1 on all previous schedule
     * end means -1 on all previous schedule
     * when we put new interval in the timeline, it should keep the same balance
     */
    class MyCalendarTwo {
        TreeMap<Integer,Integer> map;
        public MyCalendarTwo() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int count = 0;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                count += e.getValue();
                if (count == 3) {
                    map.put(start, map.get(start) - 1);
                    map.put(end, map.get(end) + 1);
                    return false;
                }
            }
            return true;
        }
    }
}