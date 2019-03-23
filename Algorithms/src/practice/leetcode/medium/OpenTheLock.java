package practice.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @search
 *
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock
 * will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of
 * turns required to open the lock, or -1 if it is impossible.
 *
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202", Output: 6
 * Explanation: A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * 0101 0102 0201 1212 2001, target 0202
 *
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        start.add("0000");
        end.add(target);
        int level = 0;
        while (!start.isEmpty() && !end.isEmpty()) {
            Set<String> tmp = new HashSet<>();
            for (String s : start) {
                if (dead.contains(s)) continue;
                if (end.contains(s)) return level;
                dead.add(s);
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    String s1 = s.substring(0, i) + (c == '9' ? '0' : (char) (c + 1)) + s.substring(i + 1);
                    String s2 = s.substring(0, i) + (c == '0' ? '9' : (char) (c - 1)) + s.substring(i + 1);
                    if (!dead.contains(s1)) tmp.add(s1);
                    if (!dead.contains(s2)) tmp.add(s2);
                }
            }
            level++;
            start = end;
            end = tmp;
        }
        return -1;
    }

    public static void main(String[] args) {
        OpenTheLock openTheLock = new OpenTheLock();
        System.out.println(openTheLock.openLock(new String[]{"8888"}, "0009"));
    }
}
