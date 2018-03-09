package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * what ds used to store intervals
 * List
 */
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

class MyCalendar1 {
    TreeMap<Integer, Integer> cal;
    public MyCalendar1() {
        cal = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floorKey = cal.floorKey(start);
        if (floorKey != null && cal.get(floorKey) > start) {
            return false;
        }
        Integer ceilingKey = cal.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) {
            return false;
        }
        cal.put(start, end);
        return true;
    }
}