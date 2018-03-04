package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * what is valid format:
 * ((())) ()) as long as left parenthesis is more than right
 * use one counter, ( c++ ) c--, so c>0 is valid
 * what ds:
 *
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n <= 0) {
            return res;
        }
        helper(n, 0, new String(), res);
        return res;
    }

    private void helper(int open, int close, String s, List<String> res) {
        if (open == 0 && close == 0) {
            res.add(s);
            return;
        }
        if (open > 0) {
            helper(open - 1, close + 1, s + "(", res);
        }
        if (close > 0) {
            helper(open, close - 1, s + ")", res);
        }
    }
}
