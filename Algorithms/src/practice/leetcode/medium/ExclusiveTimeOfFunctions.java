package practice.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @string
 * @stack
 *
 * n = 2 logs = ["0:start:0", "1:start:2", "1:end:5", "0:end:6"], Output:[3, 4]
 *
 * information in the string: thread id - start/end - timestamp
 * when new task starts, the previous one ends immediately
 * when a task ends, the previous continues, that's why we need to keep track of the time when the time stops for the last task
 * use a stack to store task id - for the last one
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        Stack<Integer> stack = new Stack<>();
        int last = 0;
        for (String log : logs) {
            String[] s = log.split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    time[stack.peek()] += Integer.valueOf(s[2]) - last;
                }
                stack.push(Integer.valueOf(s[0]));
                last = Integer.valueOf(s[2]);
            } else {
                time[stack.pop()] += Integer.valueOf(s[2]) - last + 1;
                last = Integer.valueOf(s[2]) + 1;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        ExclusiveTimeOfFunctions et = new ExclusiveTimeOfFunctions();
        String[] str = new String[]{"0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6"};
        List<String> in = Arrays.asList(str);
        int n = 2;
        et.exclusiveTime(2, in);
    }
    public int[] exclusiveTime1(int n, List<String> logs) {
        int[] time = new int[n];
        Stack<Integer> stack = new Stack<>();
        int last = 0;
        for (String log : logs) {
            String[] str = log.split(":");
            if (!stack.isEmpty()) {
                time[stack.peek()] += Integer.valueOf(str[2]) - last;
            }
            last = Integer.valueOf(str[2]);
            if (str[1].equals("start")) {
                stack.push(Integer.valueOf(str[0]));
            } else {
                time[stack.pop()]++;
                last++;
            }
        }
        return time;
    }
}
