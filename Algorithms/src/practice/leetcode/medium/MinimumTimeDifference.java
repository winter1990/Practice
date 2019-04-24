package practice.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @string
 *
 * convert string to time -> minutes
 * and compare the difference -> sort the list
 * compare the last with first as well
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int diff = Integer.MAX_VALUE, n = timePoints.size();
        for (int i = 0; i < timePoints.size(); i++) {
            int t1 = getTime(timePoints.get(i % n));
            int t2 = getTime(timePoints.get((i + 1) % n));
            diff = Math.min(diff, Math.min(Math.abs(t1 - t2), t2 + 1440 - t1));
        }
        return diff;
    }

    private int getTime(String s) {
        return Integer.valueOf(s.substring(0, s.indexOf(":"))) * 60 + Integer.valueOf(s.substring(s.indexOf(":") + 1));
    }

    public static void main(String[] args) {
        MinimumTimeDifference m = new MinimumTimeDifference();
        List<String> list = Arrays.asList("23:59","00:00");
        System.out.println(m.findMinDifference(list));
    }
}
