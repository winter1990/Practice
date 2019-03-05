package practice.leetcode.ez;

import java.util.Arrays;

/**
 * @array
 *
 * sort the two arrays
 * we want to satisfy the children with the size of cookie just same and as small as possible to be content with
 * two index, all start from 0
 * if g[i] <= s[j] i++ j++
 * else j++ current cookie cannot make child happy, or any child after the current child
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || s.length == 0 || g.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }
        return count;
    }
}
