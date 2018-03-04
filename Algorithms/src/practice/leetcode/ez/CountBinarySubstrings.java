package practice.leetcode.ez;

/**
 *  count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
 *  and all the 0's and all the 1's in these substrings are grouped consecutively
 *
 *  00110011 -> 6
 *  0011 01 1100 10 01 0011
 *
 *  brute force:
 *  time - O(nlogn)
 *
 *  optimized:
 *  grouped, consecutively
 *  cur.char compare with pre.char
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int pre = 0;
        int cur = 1;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                res++;
            }
        }

        return res;
    }
}
