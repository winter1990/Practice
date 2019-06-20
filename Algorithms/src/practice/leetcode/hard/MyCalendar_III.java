package practice.leetcode.hard;

import java.util.TreeMap;

/**
 *
 * A K-booking happens when K events have some non-empty intersection
 * For each call to the method MyCalendar.book, return an integer K representing the largest integer such that
 * there exists a K-booking in the calendar.
 *
 * MyCalendarThree();
 * MyCalendarThree.book(10, 20); // returns 1
 * MyCalendarThree.book(50, 60); // returns 1
 * MyCalendarThree.book(10, 40); // returns 2
 * MyCalendarThree.book(5, 15); // returns 3
 * MyCalendarThree.book(5, 10); // returns 3
 * MyCalendarThree.book(25, 55); // returns 3
 *
 * 0   10   20   30   40   50   60
 *     -------
 *                         -------
 *     -----------------
 *   ------
 *   --
 *             ----------------
 *       [10 1] [20 -1]
 *                             [50 1] [60 -1]
 *       [10 2]        [40 -1]
 * [5 1]    [15 -1]
 * [5 2] [10 1]
 *                 [25 1]         [55 -1]
 */
public class MyCalendar_III {
    class MyCalendarThree {
        TreeMap<Integer, Integer> map;
        public MyCalendarThree() {
            map = new TreeMap<>();
        }

        public int book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int max = 0, cur = 0;
            for (Integer k : map.values()) {
                cur += k;
                max = Math.max(max, cur);
            }
            return max;
        }
    }
}
