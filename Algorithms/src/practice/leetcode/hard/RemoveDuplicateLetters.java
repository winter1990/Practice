package practice.leetcode.hard;

import java.util.Arrays;

/**
 * Given "bcabc"
 * Return "abc"
 * Given "cbacdcbc"
 * Return "acdb"
 *
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) { // count all the frequency of chars
            cnt[s.charAt(i) - 'a']++;
        }
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            if (--cnt[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        System.out.println(r.removeDuplicateLetters(s));
    }
}
