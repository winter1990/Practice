package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @string
 * @recursion
 *
 * A string S represents a list of words.
 *
 * Each letter in the word has 1 or more options.  If there is one option, the letter is represented as is.
 * If there is more than one option, then curly braces delimit the options.
 * For example, "{a,b,c}" represents options ["a", "b", "c"].
 *
 * For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].
 *
 * Return all words that can be formed in this manner, in lexicographical order.
 *
 * Input: "{a,b}c{d,e}f"
 * Output: ["acdf","acef","bcdf","bcef"]
 *
 * Input: "abcd"
 * Output: ["abcd"]
 *
 *
 */
public class BraceExpansion {
    public String[] expand(String S) {
        List<String> list = new ArrayList<>();
        dfs(S, 0, "", list);
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }

    private void dfs(String s, int start, String cur, List<String> res) {
        if (start == s.length()) {
            res.add(cur);
            return;
        }
        int left = s.indexOf('{', start);
        int right = s.indexOf('}', start);
        if (left == -1) {
            res.add(cur + s.substring(start));
            return;
        }
        String sub = s.substring(left + 1, right);
        String[] strs = sub.split(",");
        for (String str : strs) {
            dfs(s, right + 1, cur + s.substring(start, left) + str, res);
        }
    }

    public static void main(String[] args) {
        String s = "{x,y}abc{d,e}f{ij}s";
        practice.interview.google.BraceExpansion b = new practice.interview.google.BraceExpansion();
        System.out.println(b.getAllExpansion(s));
    }
}
