package practice.leetcode.medium;

import java.util.Stack;

/**
 * @stack
 * @greedy
 *
 * start with first character in the string
 * comparing with the peek if it is empty
 * two cases:
 * if left, then push directly
 * if right, check empty and compare with peek
 */
public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }
}
