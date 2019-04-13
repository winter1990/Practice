package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * recursion
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation1(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        return new LinkedList<>(queue);
    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new LinkedList<>();
        if (S == null || S.length() == 0) {
            res.add("");
            return res;
        }
        helper(S, 0, "", res);
        return res;
    }

    private void helper(String s, int i, String tmp, List<String> res) {
        if (i == s.length()) {
            res.add(tmp);
            return;
        }
        char c = s.charAt(i);
        if (Character.isLetter(s.charAt(i))) {
            char cc = Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
            helper(s, i + 1, tmp + cc, res);
            helper(s, i + 1, tmp + c, res);
        } else {
            helper(s, i + 1, tmp + c, res);
        }
    }

    public static void main(String[] args) {
        String s = "a1b2";
        LetterCasePermutation lc = new LetterCasePermutation();
        System.out.println(lc.letterCasePermutation(s));
    }
}
