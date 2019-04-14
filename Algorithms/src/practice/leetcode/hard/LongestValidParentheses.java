package practice.leetcode.hard;

import java.util.Stack;

/**
 * @stack
 * @string
 *
 * (()()( ((()))
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] cs = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cs[i] == '(') {
                stack.push(i);
            } else { // ')'
                if (!stack.isEmpty()) {
                    int tmp = i - stack.pop() + 1;
                    if (!stack.isEmpty()) {
                        tmp = i - stack.peek();
                    } else {
                        count += tmp;
                        tmp = count;
                    }
                    max = Math.max(max, tmp);
                } else {
                    count = 0;
                }
            }
        }
        return max;
    }
}
