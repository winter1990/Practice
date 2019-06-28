package practice.leetcode.hard;

/**
 * @string
 * @dp
 * @slidingwindow
 *
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such minimum-length windows, return the one with the left-most starting index.
 *
 * S = "abcdebdde", T = "bde" Output: "bcde"
 *
 * 1. find the substring in S that contains all chars in T
 * 2. minimize the window size
 * 3. the elements of T in the window must occur in order
 *
 * because elements in window in S must match the order of chars in T, so map does not handle the order
 * two pointer:
 * scan through S, s[i] = t[j] j++
 * if all chars in t are matched, need to go back:
 *   to check previous chars for both string & substring to find the min window -> until j = 0
 *   keep track of the last position in S, and start from there next
 */
public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray(), t = T.toCharArray();
        int sLen = S.length(), tLen = T.length(), i = 0, j = 0, len = Integer.MAX_VALUE;
        String res = "";
        while (i < sLen) {
            if (s[i] == t[j]) {
                j++;
                if (j == tLen) {
                    int last = i + 1;
                    --j;
                    while (j >= 0) {
                        if (s[i] == t[j]) j--;
                        i--;
                    }
                    ++i;
                    ++j;
                    res = last - i < len ? S.substring(i, last) : res;
                    len = Math.min(len, last - i);
                }
            }
            i++;
        }
        return res;
    }

    public String getMinWindow(String s, String t) {
        int m = s.length(), n = t.length();
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int len = Integer.MAX_VALUE, i = 0, j = 0;
        String res = "";
        while (i < m) {
            if (cs[i] == ct[j]) {
                j++;
                if (j == n) {
                    int last = i;
                    --j;
                    while (j >= 0) {
                        if (cs[i] == ct[j]) j--;
                        i--;
                    }
                    i++;
                    j++;
                    if (last - i + 1 < len) {
                        res = s.substring(i, last + 1);
                        len = res.length();
                    }
                }
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abadcbedcdc";
        String t = "bcd";
        MinimumWindowSubsequence m = new MinimumWindowSubsequence();
        System.out.println(m.minWindow(s, t));
        System.out.println(m.getMinWindow(s, t));
    }

}
