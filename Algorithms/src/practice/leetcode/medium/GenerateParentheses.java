package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * n=3, ()()() (()()) (())() ((()))
 * valid format of parentheses: number of left >= number of right parentheses
 * recursively build the string:
 * - base case: right > left, no more left can be added
 * - helper(left, right, string, result set), (n,0,"",res)
 * - if left>0, (n-1,right+1,s+(,res)
 * - if right>0, (n,right-1,s+), res)
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
