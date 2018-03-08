package practice.leetcode.medium;

import java.util.Stack;

/**
 * temp   [73 74 75 71 69 72 76 73],
 * output [ 1  1  4  2  1  1  0  0]
 * translate the problem to:
 * find the first bigger value in the next
 *
 *
 */
public class DailyTemperatures {
    public int[] dailyTemperatures1(int[] temperatures) {
        if (temperatures == null || temperatures.length <= 1) {
            return null;
        }
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    // optimization:
    // only increasing or decreasing
    // if increasing
    // if decreasing,push the index
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
