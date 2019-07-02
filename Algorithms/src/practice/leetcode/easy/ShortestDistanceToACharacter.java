package practice.leetcode.easy;

/**
 * @array
 * @string
 *
 * Given a string S and a character C, return an array of integers representing the
 * shortest distance from the character C in the string.
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * C is guaranteed in S
 *
 * three cases for each character
 *   c - distance is 0
 *   not c
 *     compare with left c, if exists
 *     compare with right c, if exists
 *
 */
public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        int n = S.length(), pre = -n + 1, res[] = new int[n];
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            if (c == C) pre = i;
            res[i] = i - pre;
        }
        for (int i = n - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c == C) pre = i;
            res[i] = Math.min(res[i], Math.abs(i - pre));
        }
        return res;
    }
}
