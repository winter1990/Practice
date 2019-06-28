package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @string
 * @recursion
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * we totally have n pairs, which means n left ( and n right )
 * for a valid parentheses string, if we scan from left to right, # of right must <= left
 * each time we add a ( in the string, it means we have one more ) to be added in the next call
 *
 * recursion solution
 * base case
 *   if we have used all credits for ( and ), add to result
 * recursive call
 * (left, right, current, result set)
 * two options to be added to current string
 *   ( if we have credit for it - we add ( which means we can have 1 more credit for )
 *   ) if we have credit for it
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        generate(n, 0, "", res);
        return res;
    }

    private void generate(int left, int right, String cur, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        if (left > 0) generate(left - 1, right + 1, cur + "(", res);
        if (right > 0) generate(left, right - 1, cur + ")", res);
    }
}
