package practice.leetcode.easy;

/**
 * @hash
 * @string
 *
 * You may assume the string contain only lowercase letters.
 *
 * scan the string, from [0, n - 1]
 * if not contains key, put character and index into map
 * if contains key, then update the value to -1
 * scan one more time, if >= 0, return value/index, otherwise return -1
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
