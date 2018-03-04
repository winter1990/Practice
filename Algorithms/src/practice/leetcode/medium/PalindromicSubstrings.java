package practice.leetcode.medium;

/**
 * palindrome:
 * abba a b b a abba bb
 * odd/even
 * check palindrome - pivot, expand to left&right.
 * palin(i,i) palin(i,i+1) start and end. keep searching until false, each time count++
 * count - global
 *
 */
public class PalindromicSubstrings {
    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            palinHelper(s, i, i);
            palinHelper(s, i, i + 1);
        }
        return count;
    }

    private void palinHelper(String s, int m, int n) {
        while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
            count++;
            m--;
            n++;
        }
        return;
    }
}
