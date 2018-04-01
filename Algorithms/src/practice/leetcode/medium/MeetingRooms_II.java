package practice.leetcode.medium;

import java.util.*;

/**
 * minimum number of rooms required
 */
public class MeetingRooms_II {
    public int minMeetingRooms(Interval[] intervals) {
        List<Interval> list = new ArrayList<>();
        list.addAll(Arrays.asList(intervals));
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
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
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        ends.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= ends.peek()) { // no overlap, then should update smallest end.
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
