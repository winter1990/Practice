package practice.leetcode.hard;

import java.util.Arrays;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        } else if (s1.length() != s2.length()) {
            return false;
        } else if (s1.equals(s2)) {
            return true;
        }
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        String ss1 = new String(cs1);
        String ss2 = new String(cs2);
        if (!ss1.equals(ss2)) {
            return false;
        }
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            String s31 = s2.substring(0, s2.length() - i);
            String s32 = s2.substring(s2.length() - i);
            if (isScramble(s11, s21) && isScramble(s12, s22) || isScramble(s11, s32) && isScramble(s12, s31)) {
                return true;
            }
        }
        return false;
    }
}
