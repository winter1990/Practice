package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @string
 * @recursion
 * @backtracking
 *
 * return all possible IP
 * "25525511135"->["255.255.11.135", "255.255.111.35"]
 *
 * conditions: 1. range of value 0-255, 2. only one 0 3. dot between numbers 4. last number does not follow with dot
 * there might be multiple solutions
 * base case:
 *  index = len & total fields is 4
 *  remaining length > fields * 3
 *  remaining length < fields
 *  val > 255
 *  val = 0, cannot continue
 *
 *  recursive call: s, res, index, cur, level
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() < 4) {
            return res;
        }
        dfs(s, 0, 1, "", res);
        return res;
    }

    private void dfs(String s, int index, int level, String cur, List<String> res) {
        if (s.length() - index < 5 - level) {
            return;
        } else if (s.length() - index > 3 * (5 - level)) {
            return;
        } else if (level == 5) {
            res.add(cur.substring(0, cur.length() - 1));
        }
        int val = 0;
        for (int i = index; i < Math.min(s.length(), index + 3); i++) {
            val *= 10;
            val += (s.charAt(i) - '0');
            if (val <= 255) {
                dfs(s, i + 1, level + 1, cur + val + ".", res);
            }
            if (val == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses ra = new RestoreIPAddresses();
        System.out.println(ra.restoreIpAddresses("11011"));
    }
}
