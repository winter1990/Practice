package practice.leetcode.medium;

import java.util.Stack;

/**
 * @math
 * @stack
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 *
 * all cases
 *   digit
 *   +
 *   -
 *   *
 *   /
 *
 * priority
 *   * and / higher than + and -
 *
 * stack
 * if space, ignore
 * if number, update number
 * + or - put
 * for * or / calculate
 * at last,calculate result
 *
 * -1+12-3*4/2-1
 * initially, need a sign = +
 */
public class BasicCalculator_II {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == len - 1) {
                if (op == '-') {
                    stack.push(-num);
                }
                if (op == '+') {
                    stack.push(num);
                }
                if (op == '*') {
                    stack.push(stack.pop() * num);
                }
                if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                op = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        for (int i : stack) res += i;
        return res;
    }

    public static void main(String[] args) {
        BasicCalculator_II bc = new BasicCalculator_II();
        System.out.println(bc.calculate1("1+1+3*5 / 1 *4/2+22"));
    }

    public int calculate1(String s) {
        int pre = 0, curr = 0, sign = 1, op = 0, num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                    curr = (op == 0 ? num : (op == 1 ? curr * num : curr / num));
                }
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                op = (s.charAt(i) == '*' ? 1 : -1);
                num = 0;

            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                pre += sign * curr;
                sign = (s.charAt(i) == '+' ? 1 : -1);
                op = 0;
                num = 0;
            }
        }

        return pre + sign * curr;
    }

}
