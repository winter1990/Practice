package practice.leetcode.easy;

/**
 * @string
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Input: s = "egg", t = "add", Output: true
 * Input: s = "foo", t = "bar", Output: false
 * Input: s = "paper", t = "title", Output: true
 *
 * use two arrays/maps to check the frequency of the characters
 * aabba, aabbb
 * index[0,n-1] compare frequency only is not enough
 *
 * problem to solve:
 * for each character in a and b, track the position that the char last appears
 *   use i+1 to handle the 0 index
 * for each char in two strings:
 *   if cs[s[i]-'0'] != ct[t[i]], then false
 *   then update the index
 */

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] cs = new int[256];
        int[] ct = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (cs[s.charAt(i)] != ct[t.charAt(i)]) {
                return false;
            }
            cs[s.charAt(i)] = i + 1;
            ct[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
