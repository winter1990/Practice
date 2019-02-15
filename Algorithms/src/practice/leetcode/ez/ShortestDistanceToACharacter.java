package practice.leetcode.ez;

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
 */
public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        if (S == null || S.length() == 0) {
            return new int[]{};
        }
        int[] res = new int[S.length()];
        int i = 0, lastNonC = 0, lastC = -1;
        while (i < S.length()) {
            if (S.charAt(i) != C) {
                res[i] = lastC == -1 ? Integer.MAX_VALUE : i - lastC;
            } else {
                while (lastNonC <= i) {
                    res[lastNonC] = Math.min(res[lastNonC], i - lastNonC);
                    lastNonC++;
                }
                lastC = i;
            }
            i++;
        }
        return res;
    }
}
