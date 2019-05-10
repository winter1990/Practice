package practice.leetcode.easy;

import java.util.Arrays;

/**
 * @sort
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * sort by start time
 * if there is no overlap:
 *   the start of next meeting is >= previous end time
 */
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) return true;
        Arrays.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) return false;
        }
        return true;
    }
}
