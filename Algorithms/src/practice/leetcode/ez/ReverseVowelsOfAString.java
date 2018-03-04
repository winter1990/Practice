package practice.leetcode.ez;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * hello
 * holle
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        Set<Character> set = new HashSet<>();
        char[] dict = new char[]{'a','A','e','E','i','I','o','O','u','U'};
        for (char c : dict) {
            set.add(c);
        }
        char[] cs = s.toCharArray();
        int i = 0;
        int j = cs.length - 1;
        while (i < j) {
            while (i < j) {
                if (set.contains(cs[i])) {
                    break;
                }
                i++;
            }
            while (i < j) {
                if (set.contains(cs[j])) {
                    break;
                }
                j--;
            }
            if (i < j) {
                swap(cs, i, j);
                i++;
                j--;
            }
        }
        return new String(cs);
    }

    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
