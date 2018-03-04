package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * return all possible IP
 * "25525511135"->["255.255.11.135", "255.255.111.35"]
 *
 * recursion:
 * condition
 *  0-255
 *  single 0
 *  dot between numbers
 *  last number no dot
 * base case:
 *  index=len & total fields is 4
 *  remaining length>fields*3
 *  remaining length<fields
 *  val>255
 *  val=0, cannot continue
 *
 *  recursion
 *  need two index - charAt,fields(1-4)
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() < 4) {
            return res;
        }
        helper(s, 0, 1, new String(), res);
        return res;
    }

    private void helper(String s, int index, int level, String st, List<String> res) {
        if (s.length() - 1 - index < 4 - level) {
            return;
        } else if ( s.length() - index > 3 * (5 - level)) {
            return;
        } else if (level == 5) {
            res.add(st.substring(0, st.length() - 1));
        }
        int val = 0;
        for (int i = index; i < Math.min(s.length(), index + 3); i++) {
            val *= 10;
            val += (s.charAt(i) - '0');
            if (val <= 255) {
                helper(s, i + 1, level + 1, st + val + '.', res);
            }
            if (val == 0) {
                break;
            }
        }
    }
}
