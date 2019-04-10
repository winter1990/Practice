package practice.leetcode.medium;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar_II {
    class MyCalendarTwo {
        TreeMap<Integer,Integer> map;
        public MyCalendarTwo() {
            map = new TreeMap<Integer,Integer>();
        }

        public boolean book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int booked = 0;
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                booked += entry.getValue();
                if (booked == 3) {
                    map.put(start, map.get(start) - 1);
                    map.put(end, map.get(end) + 1);
                    return false;
                }
            }
            return true;
        }
    }
}


/* mis understand the question
class MyCalendarTwo {
    List<int[]> cal;
    public MyCalendarTwo() {
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
                if (cal.get(mid)[0] <= start && mid != cal.size() - 1 && cal.get(mid + 1)[0] < end) {
                    return false;
                } else if (cal.get(mid)[1] >= end && mid != 0 && cal.get(mid - 1)[1] > start) {
                    return false;
                } else {
                    break;
                }
            }
        }
        if (right != -1 && left != cal.size() && cal.get(left)[0] == start) {
            if (cal.get(left)[1] > end) {
                cal.add(left, new int[]{start, end});
            } else {
                cal.add(left + 1, new int[]{start, end});
            }
            return true;
        }
        cal.add(left, new int[]{start, end});
        return true;
    }
}
*/