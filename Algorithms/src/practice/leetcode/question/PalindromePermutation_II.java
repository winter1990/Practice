package practice.leetcode.question;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].
 */

/**
 * recursion:
 * count the characters first using map
 */
public class PalindromePermutation_II {
    // wrong answer
    public List<String> generatePalindromes(String s) {
        List<String> res = new LinkedList<>();
        if (s == null || s.length() <= 1) {
            return res;
        }
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        if (isValidPalinString(cs)) {
            helper(cs, 0, new StringBuilder(), res);
        }
        return res;
    }

    private void helper(char[] cs, int index, StringBuilder sb, List<String> res) {
        if (index >= cs.length) {
            return;
        }
        if (sb.length() == cs.length) {
            res.add(new String(sb.toString()));
            return;
        }
        for (int i = index; i < cs.length;) {
            if (i < cs.length - 1 && cs[i] == cs[i + 1]) {
                for (int j = 0; j <= sb.length() / 2; j++) {
                    sb.insert(j, cs[i]);
                    sb.insert(sb.length() - j, cs[i]);
                    helper(cs, i + 2, sb, res);
                    sb.deleteCharAt(sb.length() - 1 - j);
                    sb.deleteCharAt(j);
                }
                i += 2;
            } else {
                sb.insert(sb.length() / 2, cs[i]);
                helper(cs, i + 1, sb, res);
                i += 1;
            }
        }
    }

    private boolean isValidPalinString(char[] cs) {
        int odd = 0;
        int index = 0;
        while (index < cs.length - 1) {
            int count = 1;
            while (index < cs.length - 1 && cs[index] == cs[index + 1]) {
                count++;
                index++;
            }
            if (count % 2 == 1) {
                odd++;
            }
            index++;
        }
        return odd <= 1;
    }

    public static void main(String[] args) {
        PalindromePermutation_II p = new PalindromePermutation_II();
        String s = "aabbb";
        System.out.println(p.generatePalindromes(s));
    }
}
