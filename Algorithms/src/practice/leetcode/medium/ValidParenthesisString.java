package practice.leetcode.medium;

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
        System.out.println(vp.checkValidString(s));
    }
}
