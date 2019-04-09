package practice.leetcode.hard;

/**
 * @math
 * @search
 * @recursion
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 *
 * 1. find pairs: [0 0] [1 1] [6 9] [9 6] [8 8]
 * 2. the new number n, low <= n <= high, given in string format.
 *    low and high might have different lengths
 *    to compare, make sure they have the same length
 * 3. search - dfs / bfs -> dfs and recursively build the string and check if it is valid
 *    base case:
 *      left > right
 *        check value, low <= n <= high
 *        add to result
 *    recursive call: (char[] low high left right)
 *    for each pair values, skip leading 0, skip pair[0] != pair[1] if left = right
 */
public class StrobogrammaticNumber_III {
    char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    public int strobogrammaticInRange(String low, String high) {
        int[] count = {0};
        for (int len = low.length(); len <= high.length(); len++) {
            char[] c = new char[len];
            dfs(low, high, c, 0, len - 1, count);
        }
        return count[0];
    }

    public void dfs(String low, String high , char[] c, int left, int right, int[] count) {
        if (left > right) {
            String s = new String(c);
            if ((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0)) {
                return;
            }
            count[0]++;
            return;
        }
        for (char[] p : pairs) {
            c[left] = p[0];
            c[right] = p[1];
            if (c.length != 1 && c[0] == '0') continue;
            if (left == right && p[0] != p[1]) continue;
            dfs(low, high, c, left + 1, right - 1, count);
        }
    }
}
