package practice.leetcode.medium;

import java.util.*;

/**
 * @string
 * @math
 *
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits
 *
 * Input: "19:34", Output: "19:39"
 *
 * problems to solve:
 * 1. get next time / next bigger value
 * 2. can only reuse the current digits
 * 3. convert minutes to hours (01:59 -> +1 = 02:00)
 * 4. 23:59 -> next day / start from 00:00
 *
 * convert the given time to minutes
 * each time add [1, 1440-1], convert back to hours and minutes
 *   each time get 1 digit -> check whether reused digit -> /600 /60 /10 1
 *   check whether exists in cur time
 *   if not exists, break
 *   if all 4 digits are filled, then return result
 */
public class NextClosestTime {
    public String nextClosestTime(String time) {
        int[] mins = {600, 60, 10, 1};
        int separator = time.indexOf(':');
        int cur = Integer.valueOf(time.substring(0, separator)) * 60 + Integer.valueOf(time.substring(separator + 1));
        char[] cs = new char[4];
        int digit = 0;
        for (int i = 1; i <= 1440 && digit < 4; i++) {
            int next = (cur + i) % 1440;
            for (digit = 0; digit < 4; digit++) {
                cs[digit] = (char)('0' + next / mins[digit]);
                next %= mins[digit];
                if (time.indexOf(cs[digit]) == -1) break;
            }
        }
        return new String(cs, 0, 2) + ':' + new String(cs, 2, 2);
    }

    public String nextClosestTime1(String time) {
        String[] str = time.split(":");
        int hrs = Integer.valueOf(str[0]);
        int mins = Integer.valueOf(str[1]);
        if (hrs == 0 && mins == 0) return "00:00";
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
        if (min > mins) return str[0] + ":" + m;
        while (true) {
            if (hr == 24) hr = 0;
            h = hr < 10 ? "0" + hr : Integer.toString(hr);
            if (set.contains(h.charAt(0)) && set.contains(h.charAt(1))) break;
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
