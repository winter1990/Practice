package practice.leetcode.medium;

/**
 * palindrome - can be even or odd
 * pivot - 1 to n-1
 * and span to two directions
 *
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String a = getPalin(s, i, i);
            res = a.length() > res.length() ? a : res;
            String b = getPalin(s, i, i + 1);
            res = b.length() > res.length() ? b : res;
        }
        return res;
    }

    private String getPalin(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
