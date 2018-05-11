package practice.leetcode.medium;

import java.util.*;

/**
 * @string
 * @math
 *
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits
 *
 * Input: "19:34", Output: "19:39"
 */
public class NextClosestTime {
    public String nextClosestTime3(String time) {
        // represents 4 digits
        int[] mins = {600, 60, 10, 1};
        int colon = time.indexOf(':');
        // get the total minutes of the current time
        int oldTime = Integer.valueOf(time.substring(0, colon)) * 60 + Integer.valueOf(time.substring(colon + 1));
        char[] next = new char[4];
        // i means add i minutes to current time
        int digit = 0;
        for (int i = 1; i <= 1440 && digit < 4; i++) {
            int minutes = (oldTime + i) % 1440;
            for (digit = 0; digit < 4; digit++) {
                next[digit] = (char)('0' + minutes / mins[digit]);
                minutes %= mins[digit];
                if (time.indexOf(next[digit]) == -1) {
                    break;
                }
            }
        }
        return new String(next, 0, 2) + ':' + new String(next, 2, 2);
    }

    public String nextClosestTime1(String time) {
        String[] val = time.split(":");
        Set<Integer> set = new HashSet<>();
        int hour = add(set, val[0]);
        int minu = add(set, val[1]);

        int[] times = new int[] {hour, minu};
        nxt(times);

        while (!contains(times[0], times[1], set)) {
            nxt(times);
        }
        return valid(times[0]) + ":" + valid(times[1]);
    }

    public void nxt(int[] time) {
        int hour = time[0];
        int minu = time[1];
        minu ++;
        if (minu == 60) {
            hour ++;
            minu = 0;
            if (hour == 24) hour = 0;
        }
        time[0] = hour;
        time[1] = minu;
    }

    public int add(Set<Integer> set, String timeStr) {
        int time = Integer.parseInt(timeStr);
        set.add(time / 10);
        set.add(time % 10);
        return time;
    }

    public String valid(int time) {
        if (time >= 0 && time <= 9) return "0" + time;
        else return time + "";
    }

    public boolean contains(int hour, int minu, Set<Integer> set) {
        return set.contains(hour / 10) && set.contains(hour % 10) && set.contains(minu / 10) && set.contains(minu % 10);
    }

    public String nextClosestTime(String time) {
        String[] str = time.split(":");
        int hrs = Integer.valueOf(str[0]);
        int mins = Integer.valueOf(str[1]);
        if (hrs == 0 && mins == 0) {
            return "00:00";
        }
        Set<Character> set = new HashSet<>();
        for (char c : time.toCharArray()) set.add(c);
        int hr = hrs;
        int min = mins + 1;
        if (min == 60) {
            min = 0;
            hr += 1;
            hr %= 24;
        }
        String m = "";
        String h = "";
        int i = min;
        for (; i < 60; i++) {
            m = i < 10 ? "0" + i : Integer.toString(i);
            if (set.contains(m.charAt(0)) && set.contains(m.charAt(1))) {
                min = i;
                break;
            }
        }
        if (i == 60) {
            min = 0;
            for (int ii = min; ii < 60; ii++) {
                m = ii < 10 ? "0" + ii : Integer.toString(ii);
                if (set.contains(m.charAt(0)) && set.contains(m.charAt(1))) {
                    min = ii;
                    break;
                }
            }
            hr++;
        }
        if (min > mins) {
            return str[0] + ":" + m;
        }
        while (true) {
            if (hr == 24) {
                hr = 0;
            }
            h = hr < 10 ? "0" + hr : Integer.toString(hr);
            if (set.contains(h.charAt(0)) && set.contains(h.charAt(1))) {
                break;
            }
            hr++;
        }
        return h + ":" + m;
    }



    public static void main(String[] args) {
        String s0 = "00:00"; // 0000
        String s1 = "19:34"; // 1939
        String s2 = "23:59"; // 2222
        String s3 = "01:32"; // 0133
        String s4 = "06:05"; // 0606
        String s5 = "13:55"; // 1511
        String s6 = "15:55"; // 1111
        NextClosestTime n = new NextClosestTime();
        System.out.println(n.nextClosestTime(s0));
        System.out.println(n.nextClosestTime(s1));
        System.out.println(n.nextClosestTime(s2));
        System.out.println(n.nextClosestTime(s3));
        System.out.println(n.nextClosestTime(s4));
        System.out.println(n.nextClosestTime(s5));
        System.out.println(n.nextClosestTime(s6));
    }
}
