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
        int count = 0, left = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                left--;
                if (left < 0) {
                    count++;
                    left = 0;
                }
            }
        }
        return count + left;
    }

    public int minAddToMakeValid1(String S) {
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
