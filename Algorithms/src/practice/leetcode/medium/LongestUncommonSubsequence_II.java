package practice.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * for string a and b, if a.len > b.len, then a must not be the subsequence of b
 * sort the array from largest length to smallest length
 * iterate the sorted string array:
 * - check if it is unique
 * - check if it is the subsequence of longer strings
 * to check if the string is unique, use two sets OR sort the array by length and Alphabetical as second criteria
 *
 */
public class LongestUncommonSubsequence_II {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() != s2.length() ? s2.length() - s1.length() : s2.compareTo(s1);
            }
        });
        for (int i = 0; i < strs.length; i++) {
            if ((i != strs.length - 1 && !strs[i].equals(strs[i + 1])) || i == strs.length - 1) {
                if (i == 0) {
                    return strs[0].length();
                }
                for (int j = 0; j < i; j++) {
                    if (isSubsequence(strs[j], strs[i])) {
                        break;
                    }
                    if (j == i - 1) {
                        return strs[i].length();
                    }
                }
            }
        }
        return -1;
    }

    private boolean isSubsequence(String s1, String s2) { // s1 is longer than s2
        if (s1.equals(s2)) {
            return true;
        }
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.length() && i2 < s2.length()) {
            if (s1.charAt(i1) == s2.charAt(i2)) {
                i2++;
            }
            i1++;
        }
        return i2 == s2.length();
    }

    public static void main(String[] args) {
        LongestUncommonSubsequence_II l = new LongestUncommonSubsequence_II();
        String[] str = {"aabbcc", "aabbcc","c","e","aabbcd"};
        System.out.println(l.findLUSlength(str));
    }
}
