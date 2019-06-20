package practice.leetcode.medium;

import java.util.Stack;

/**
 * @string
 *
 * left must be paired with right
 * star * can be left/right/empty
 * (*)
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0;
        int right = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                left++;
                right++;
            } else if (c == ')') {
                if (left > 0) left--;
                right--;
            } else {
                if (left > 0) left--;
                right++;
            }
            if (right < 0) return false;
        }
        return left == 0;
    }

    public static void main(String[] args) {
        ValidParenthesisString vp = new ValidParenthesisString();
        String s = "**(";
        System.out.println(vp.checkValidString2(s));
    }

    public boolean checkValidString1(String s) {
        return isValid(s, 0, 0);
    }

    private boolean isValid(String s, int start, int count) {
        if (start == s.length()) {
            if (count != 0) return false;
            return true;
        }
        if (count < 0) return false;
        if (s.charAt(start) == '(') {
            return isValid(s, start + 1, count + 1);
        } else if (s.charAt(start) == ')') {
            return isValid(s, start + 1, count - 1);
        } else {
            return isValid(s, start + 1, count + 1)
                    || isValid(s, start + 1, count)
                    || isValid(s, start + 1, count - 1);
        }
    }

    // ((*)
    // (*))
    // ()(*)
    public boolean checkValidString2(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == '*') {
                star.push(i);
            } else {
                if (left.isEmpty() && star.isEmpty()) {
                    return false;
                }
                if (!left.isEmpty()) {
                    left.pop();
                } else {
                    star.pop();
                }
            }
        }
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop()) return false;
        }
        return left.isEmpty();
    }
}
