package practice.interview.google;

import java.util.Stack;

/**
 * method 1:
 * stack
 * scan the string [0,n-1]
 * if left push into stack
 * if right
 *   empty stack, false
 *   paired, pop() the stack
 * two scenarios:
 *   (() left over, false
 *   empty, true
 *
 * method 2:
 * count left and right parenthesis
 * if (, left++
 * if )
 *   left = 0, false
 *   left--
 */
public class BalancedParenthesisString {
    public boolean isValidPerenthesis1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidPerenthesis2(String s) {
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                if (left == 0) return false;
                left--;
            }
        }
        return left == 0;
    }

    public static void main(String[] args) {
        BalancedParenthesisString b = new BalancedParenthesisString();
        String s = "())";
        System.out.println(b.isValidPerenthesis1(s));
        System.out.println(b.isValidPerenthesis2(s));
    }
}
