package practice.leetcode.easy;

/**
 * @dfs
 *
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time
 * has elapsed since midnight.
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 * Input: [1,2,3,4], Output: "23:41"
 * Input: [5,5,5,5], Output: ""
 *
 * permutations
 * total -> 4 * 3 * 2 * 1 = 24
 * divided into two parts - hour and minutes, range of hours [00,23], range of minutes [00,59]
 *
 */
public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] A) {
        String res = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || i == k || j == k) continue;
                    String h = A[i] + "" + A[j];
                    String m = A[k] + "" + A[6 - i - j - k];
                    String t = h + ":" + m;
                    if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && res.compareTo(t) < 0) res = t;
                }
            }
        }
        return res;
    }
}
