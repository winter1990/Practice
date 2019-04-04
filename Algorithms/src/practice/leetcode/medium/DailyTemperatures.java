package practice.leetcode.medium;

import java.util.Stack;

/**
 * @array
 * @stack
 *
 *
 * translate the problem to: find the first bigger value in the next
 * index    0  1  2  3  4  5  6  7
 * temp   [73 74 75 71 69 72 76 73],
 * output [ 1  1  4  2  1  1  0  0]
 *
 * for each value, push to stack
 * while larger than stack.peek value, res[peek] = i - peek
 * push(0)
 */
public class DailyTemperatures {
    public int[] dailyTemperatures1(int[] T) {
        if (T == null || T.length <= 1) {
            return null;
        }
        int len = T.length;
        int[] res = new int[len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) res[stack.peek()] = i - stack.pop();
            stack.push(i);
        }
        return res;
    }
}
