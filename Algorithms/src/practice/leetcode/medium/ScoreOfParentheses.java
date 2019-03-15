package practice.leetcode.medium;

import java.util.Stack;

/**
 * @stack
 * @string
 *
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 * () ()() ((())) (())()(())
 * if we see (
 * 1. current score is push current score to the stack, and it means we are entering a new block of parenthesis
 * 2. reset current to 0
 * if we see ) current score can be only two cases:
 * 1. current becomes 1
 * 2. it can be doubled
 * and we exit the current level
 * current value becomes pop() + current
 *
 */
public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        int cur = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(1, cur * 2);
            }
        }
        return cur;
    }

    public int scoreOfParentheses1(String S) {
        int res = 0, l = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                l++;
            } else {
                l--;
            }
            if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') {
                res += 1 << l;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ScoreOfParentheses so = new ScoreOfParentheses();
        String s = "((()))()()(())";
        System.out.println(so.scoreOfParentheses(s));
    }
}
