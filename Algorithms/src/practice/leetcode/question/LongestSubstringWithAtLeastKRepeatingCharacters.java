package practice.leetcode.question;

import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    //Java Strict O(N) Two-Pointer Solution
    // For each h, apply two pointer technique to find the longest substring with at least K repeating characters
    // and the number of unique characters in substring is h
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int h, i, j, idx, max = 0, unique, noLessThanK;

        for (h = 1; h <= 26; h++) {
            Arrays.fill(counts, 0);
            i = 0;
            j = 0;
            unique = 0;
            noLessThanK = 0;
            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0) unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                } else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)
                    max = Math.max(j - i, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "ababbc";
        LongestSubstringWithAtLeastKRepeatingCharacters l = new LongestSubstringWithAtLeastKRepeatingCharacters();
        System.out.println(l.longestSubstring(s, 2));
    }
}
