package practice.leetcode.question;

import java.util.HashSet;
import java.util.Set;

/**
 * @graph
 * @search
 *
 * There is a box protected by a password. The password is n digits, where each letter can be one of the first k
 * digits 0, 1, ..., k-1.
 * You can keep inputting the password, the password will automatically be matched against the last n digits entered.
 * For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.
 * Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.
 * Input: n = 1, k = 2, Output: "01" Note: "10" will be accepted too.
 * Input: n = 2, k = 2, Output: "00110", Note: "01100", "10011", "11001" will be accepted too.
 *
 * password has total n digits, range from 0 to k-1
 * so the question is translated to: minimum length of string that contains all different combinations of n digits code
 * we want each permutation appears once in the string
 * 00       0
 *  01      1
 *   11     3
 *    10    2
 * need to use the previous digit(s) as much as possible
 *
 * some translation:
 * all combinations should exist in string
 * each combination appears only once
 */
public class CrackingTheSafe {
    Set<String> seen;
    StringBuilder ans;

    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1) return "0";
        seen = new HashSet();
        ans = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) sb.append("0");
        String start = sb.toString();
        dfs(start, k);
        ans.append(start);
        return new String(ans);
    }

    public void dfs(String node, int k) {
        for (int x = 0; x < k; x++) {
            String nei = node + x;
            if (!seen.contains(nei)) {
                seen.add(nei);
                dfs(nei.substring(1), k);
                ans.append(x);
            }
        }
    }

    public static void main(String[] args) {
        CrackingTheSafe c = new CrackingTheSafe();
        System.out.println(c.crackSafe(2,3));
    }
}
