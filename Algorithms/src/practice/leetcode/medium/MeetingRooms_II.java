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
 * first, need some mechanism to sort the all intervals, based on start and end
 * because we want to greedily add intervals to the same room, need to start the meeting asap
 * sort by start and compare next intervals with the end of previous interval
 * -----------      1
 *    ---           2
 *        ---       3
 *           --     4
 *            --    5
 * start with 1, take a room, 2 start > end of 1, take a room, current is 3, we need to find the previous interval that
 * finishes earliest, 2 is replaced by 3, 4 the same. when see 5, we compare with the ones that smaller, 1 replaced by 5
 *
 * how to determine two meetings can be scheduled in the same meeting room
 * keep track of all the meeting room that available earliest -> because if it does not fit, all the rooms after it
 * will not be working for sure
 *
 * it's the reason we use a heap
 * use heap to store the ending time, in ascending order
 * if current start >= heap.peek(), then pop(), otherwise start another room -> push into heap
 * at last return the size of priority queue
 */
public class MeetingRooms_II {
    public int minMeetingRooms(Interval[] intervals) {
        List<Interval> list = new ArrayList<>();
        list.addAll(Arrays.asList(intervals));
        Collections.sort(list, (i1, i2) -> i1.start - i2.start);
        int count = 0;
        while (list.size() != 0) {
            int end = list.get(0).end;
            list.remove(0);
            int i = 0;
            while (i < list.size()) {
                if (end <= list.get(i).start) {
                    end = list.get(i).end;
                    list.remove(i);
                } else {
                    i++;
                }
            }
            count++;
        }
        return count;
    }

    public int minMeetingRooms1(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        ends.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= ends.peek()) {
                ends.poll();
            }
            ends.offer(intervals[i].end);
        }
        return ends.size();
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
