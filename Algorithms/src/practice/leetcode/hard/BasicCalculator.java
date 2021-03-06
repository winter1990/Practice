package practice.leetcode.hard;

import java.util.Stack;

/**
 * @stack
 * @math
 *
 * The expression string may contain ( and ), + or -, non-negative integers and empty spaces
 * "(1+(4+5+2)-3)+(6+8)" = 23
 *
 * -1+(-1-(2+1))
 *
 * 5 cases:
 *   digit
 *   + two cases, () block is finished, or number if finished. add to result, update sign
 *   - same, sign = -1
 *   ( start to calculate a higher priority block, so push pre result and sign to stack, reset the sign
 *   ) pop the sign, pop again to get result before ()
 */
public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0, n = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                n *= 10;
                n += (c - '0');
            } else if (c == '+') {
                res += sign * n;
                n = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * n;
                n = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * n;
                n = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        if (n != 0) {
            res += sign * n;
        }
        return res;
    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        System.out.println(bc.calculate("1 + 1"));

    }
}
