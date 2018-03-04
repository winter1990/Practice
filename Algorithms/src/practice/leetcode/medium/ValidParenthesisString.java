package practice.leetcode.medium;

import java.util.Stack;

/**
 * left must be paired with right
 * star * can be left/right/empty
 *
 * use * for counter? no )* invalid
 * left-put, star-put, right-pop from q
 * count *, number>=rest in q
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
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
        System.out.println(vp.checkValidString(s));
    }
}
