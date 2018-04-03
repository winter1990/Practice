package practice.leetcode.medium;

import java.util.Stack;

/**
 * @math
 * @stack
 *
 * stack
 * if space, ignore
 * if number, update number
 * + or - put
 * for * or / calculate
 * at last,calculate result
 */
public class BasicCalculator_II {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        for (int i : stack) res += i;
        return res;
    }

    public static void main(String[] args) {
        BasicCalculator_II bc = new BasicCalculator_II();
        System.out.println(bc.calculate("-12"));
    }
}
