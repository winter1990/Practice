package practice.leetcode.easy;

/**
 * @string
 *
 * considering only alphanumeric characters and ignoring cases
 * we define empty string as valid palindrome
 *
 * trim
 * lower case
 * two pointers, check whether it is valid character before comparing
 *
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !isValidChar(s.charAt(start))) {
                start++;
            }
            while (start < end && !isValidChar(s.charAt(end))) {
                end--;
            }
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isValidChar(char c) {
        return Character.isLetterOrDigit(c);
    }
}
