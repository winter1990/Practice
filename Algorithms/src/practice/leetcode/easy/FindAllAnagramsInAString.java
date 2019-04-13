package practice.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * s: "cbaebabacd" p: "abc" -> [0,6]
 *
 * get substring
 * sort
 * compare
 * time O(m*n)
 *
 * sliding window
 */

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s.length() < p.length()) {
            return res;
        }
        int[] arr = new int[256];
        for (char c : p.toCharArray()) {
            arr[c]++;
        }
        int l = 0;
        int r = 0;
        int c = p.length();
        while (r < s.length()) {
            if (arr[s.charAt(r++)]-- >= 1) {
                c--;
            }
            if (c == 0) {
                res.add(l);
            }
            if (r - l == p.length() && arr[s.charAt(l++)]++ >= 0) {
                c++;
            }
        }
        return res;
    }


    // time limit exceeded
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s.length() < p.length()) {
            return res;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (isAnagram(s.substring(i, i + p.length()), p)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isAnagram(String str, String p) {
        char[] cs1 = str.toCharArray();
        char[] cs2 = p.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        for (int i = 0; i < cs1.length; i++) {
            if (cs1[i] != cs2[i]) {
                return false;
            }
        }
        return true;
    }
}
