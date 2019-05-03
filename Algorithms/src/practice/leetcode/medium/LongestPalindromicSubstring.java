package practice.leetcode.medium;

/**
 * @string
 *
 * problems to solve:
 * 1. get substring and it must be palindrome
 * 2. odd or even length matters, both should be handled separately
 * 3. longest substring
 *
 * choose pivot:
 *   because the length of substring can be even or odd, the pivot to choose single char (i), two chars (i,i+1)
 * define two pointers:
 *   expand to two directions as far as we can to get longest substring
 *   as the pivot can be (i) or (i,i+1), define a method (string, i, j)
 *
 * time O(n^2)
 * space O(1)
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String a = getLongestPalindrome(s, i, i);
            res = a.length() > res.length() ? a : res;
            String b = getLongestPalindrome(s, i, i + 1);
            res = b.length() > res.length() ? b : res;
        }
        return res;
    }

    private String getLongestPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
