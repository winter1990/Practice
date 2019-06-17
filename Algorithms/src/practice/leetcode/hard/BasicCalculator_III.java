package practice.leetcode.hard;

import java.util.Stack;

/**
 * @stack
 *
 * The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses )
 * and empty spaces . The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of
 * [-2147483648, 2147483647].
 *
 * need to keep track of:
 *   sign + -
 *   current number 12
 *   previous result
 *   operand * /
 *
 * priority
 *   () has the highest, 1+(-1+(2-3)) inner one
 *   multi and division
 *   + - lowest priority
 *
 * -1+2*(-1+(2+3*4))
 */
public class BasicCalculator_III {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for(int i = 0 ; i < s.length();) {
            char c = s.charAt(i);
            if (c == '(') {
                // find the block and use the recursive to solve
                int l = 1;
                int j = i + 1;
                while (j < s.length() && l > 0) {
                    if(s.charAt(j) == '(') l ++;
                    else if(s.charAt(j) == ')') l --;
                    j++;
                }
                int blockValue = calculate(s.substring(i + 1, j-1));
                i = j;
                if (sign == '+') {
                    stack.push(blockValue);
                } else if (sign == '-') {
                    stack.push(-blockValue);
                } else if (sign == '*') {
                    stack.push(stack.pop() * blockValue);
                } else if (sign == '/') {
                    stack.push(stack.pop() / blockValue);
                }
            } else if (Character.isDigit(c)) {
                int j = i;
                int value = 0;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    value = 10 * value + (s.charAt(j) - '0');
                    j++;
                }
                i = j;
                if (sign == '+') {
                    stack.push(value);
                } else if (sign == '-') {
                    stack.push(-value);
                } else if (sign == '*') {
                    stack.push(stack.pop() * value);
                } else if (sign == '/') {
                    stack.push(stack.pop() / value);
                }
            } else {
                sign = c;
                i++;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "(  ( ( (   5 +6) * (5  +1 )   )   -   ((   5   -   8 ) +( 1*3  )  ) )*( 1 *4   )  )";// "2*(5+5*2)/3+(6/2+8)";
        BasicCalculator_III cal = new BasicCalculator_III();
        System.out.println(cal.calculate(s));
    }
}
