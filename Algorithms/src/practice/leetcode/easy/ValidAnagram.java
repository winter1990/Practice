package practice.leetcode.easy;

/**
 * method 1:
 * for two strings, convert toCharArray()
 * sort()
 * compare
 *
 * method 2:
 * use a checker to track the frequency of each char in the array
 * scan through s first, checker[c -'a']++
 * scan through t, and check if --checker[c-'a'] < 0
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] checker = new int[26];
        for (char c : s.toCharArray()) checker[c - 'a']++;
        for (char c : t.toCharArray()) {
            if (--checker[c - 'a'] < 0) return false;
        }
        return true;
    }
}
