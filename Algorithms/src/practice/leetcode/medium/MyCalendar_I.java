package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @array
 * @tree
 * @binarysearch
 *
 * linear search is straightforward:
 * whether the new interval can be inserted -> cur.start >= pre.end and cur.end <= next.start
 * handle the first, and last interval in the list
 *
 * --  -----  --  ----
 *    -- - --
 * binary search:
 * find the index that we want to insert
 * left = 0, right = n-1
 * get middle interval
 *   if mid.start >= cur.end, right = mid - 1
 *   else if mid.end <= cur.start, left = mid + 1
 *   else false
 * left is the position/index that we should insert into
 */
public class MyCalendar_I {
    class MyCalendar {
        List<int[]> cal;
        public MyCalendar() {
            cal = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            int left = 0;
            int right = cal.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (cal.get(mid)[0] >= end) {
                    right = mid - 1;
                } else if (cal.get(mid)[1] <= start) {
                    left = mid + 1;
                } else {
                    return false;
                }
            }
            cal.add(left, new int[]{start, end});
            return true;
        }
    }

    /**
     * @treemap
     *
     * given a new interval, our target is to find the interval which:
     *   the start is JUST larger than cur.end
     *   the end is JUST smaller than cur.start
     *   => tree map (floor/ceiling)
     * for a tree map, the key is sorted in ascending order
     * (left, right) paris are stored in the tree
     * get floorkey(start), map.get(floor) > start, then false
     * get ceilingkey(start) map.get(ceiling) < end, then false
     * put new interval in the map
     */
    class MyCalendar1 {
        TreeMap<Integer, Integer> cal;
        public MyCalendar1() {
            cal = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer floorKey = cal.floorKey(start);
            if (floorKey != null && cal.get(floorKey) > start) return false;
            Integer ceilingKey = cal.ceilingKey(start);
            if (ceilingKey != null && ceilingKey < end) return false;
            cal.put(start, end);
            return true;
        }
    }
}
