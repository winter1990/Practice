package practice.leetcode.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @string
 *
 * extract all letters in license
 * to char array and compare
 */
public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        char[] cs = sb.toString().toLowerCase().toCharArray();
        int m = cs.length;
        Arrays.sort(cs);
        String s = null;
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            if (chars.length < cs.length) continue;
            int n = chars.length;
            int i = 0, j = 0;
            while (i < m && j < n) {
                if (cs[i] == chars[j]) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            if (i == m) {
                if (s == null) {
                    s = word;
                } else {
                    s = word.length() < s.length() ? word : s;
                }
            }
        }
        return s;
    }
}
