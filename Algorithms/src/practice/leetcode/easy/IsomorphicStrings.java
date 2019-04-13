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
 * total number of each character is the same
 * so we create two arrays/maps to check the frequency of the characters
 * if the input is aabbb ccddc, when checking index = 4, both are 3 but they are not isomorphic
 * track the freq only does not apply
 *
 * instead we can track the last index that char appears
 * aabb ccdd -> check the index in two arrays, they must be the same
 *  aa    ab
 * [0 0] [0 0]
 * this will not work because all defaults are 0
 * we can use i + 1 as the index for the characters
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
