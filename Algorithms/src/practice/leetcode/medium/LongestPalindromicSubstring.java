package practice.leetcode.medium;

/**
 * @string
 *
 * palindrome: substring can be even or odd length
 * choose pivot: s.charAt(i) or (i & i+1)
 * and span to two directions
 * getPalinLength(s,i,j), return s.substring(i+1,j)
 *
 * abbac->(a)(ab),(b)(bb),(b)(ba),...
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
