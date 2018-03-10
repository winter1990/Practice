package practice.leetcode.hard;

import java.util.Arrays;

public class RemoveDuplicateLetters {
    /**
     * O(n), O(n)
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (i == cs.length - 1 || cs[i] != cs[i + 1]) {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        System.out.println(r.removeDuplicateLetters(s));
    }
}
