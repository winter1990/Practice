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
 * n - length of the pwd
 * k - numbers in pwd [0 1 2...k-1]
 *
 * n = 2, k = 2, 001
 */
public class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("0");
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        int allCombo = (int) Math.pow(k, n);
        dfs(sb, n, k, visited, allCombo);
        return sb.toString();
    }

    private boolean dfs(StringBuilder pwd, int n, int k, Set<String> visited, int allCombo) {
        if (visited.size() == allCombo) {
            return true;
        }
        String pre = pwd.substring(pwd.length() - n + 1);
        for (int i = 0; i < k; i++) {
            String next = pre + i;
            if (visited.add(next)) {
                pwd.append(i);
                if (dfs(pwd, n, k, visited, allCombo)) return true;
                pwd.deleteCharAt(pwd.length() - 1);
                visited.remove(next);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CrackingTheSafe c = new CrackingTheSafe();
        System.out.println(c.crackSafe(2,2));
    }
}
