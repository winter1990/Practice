package practice.leetcode.medium;

import java.util.*;

/**
 * @greedy
 * @heap
 * @sort
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * sort by start:
 * -----------      1
 *    ---           2
 *        ---       3
 *           --     4
 *            --    5
 * start with 1, take a room, 2 start > end of 1, take a room, current is 3, we need to find the previous interval that
 * finishes earliest, 2 is replaced by 3, 4 the same. when see 5, we compare with the ones that smaller, 1 replaced by 5
 *
 * sort the all intervals, based on start or end
 * for two meetings:
 * start with the earliest meeting, to determine if another meeting can be scheduled in the same room, pre.end <= cur.start
 * if pre.end > cur.start, need another room
 * then we have multiple rooms and we care about the ending time of each
 * if a meeting comes in, put in the room that is available as early as possible
 *   if the meeting that finishes earliest overlaps with current meeting, then all the other must not be feasible
 *   so we need to sort the previous meeting by ending time -> min heap -> pop() and update the ending time
 * the size of heap is the meeting rooms required to fit all meetings
 */
public class MeetingRooms_II {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= pq.peek()) pq.poll();
            pq.offer(intervals[i].end);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1,5);
        Interval i2 = new Interval(8,9);
        Interval i3 = new Interval(8,9);
        Interval[] in = new Interval[]{i1, i2, i3};
        MeetingRooms_II m = new MeetingRooms_II();
        System.out.println(m.minMeetingRooms(in));
    }
}
