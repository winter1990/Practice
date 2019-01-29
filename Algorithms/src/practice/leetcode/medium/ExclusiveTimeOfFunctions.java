package practice.leetcode.medium;

import java.util.List;
import java.util.Stack;

/**
 * @string
 * @stack
 *
 * order: thread id - start/end - time
 * need to track back - stack
 * stack is used to store the thread id
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
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
