package practice.leetcode.hard;

import java.util.Stack;

/**
 * use stack to store values and operators
 * if * or /,calculate
 * if ),pop until (
 * if +-,push to stack
 * if digit
 */
public class BasicCalculator_III {
    /* wrong. did not think about the diff combinations before hand
       when * or /, cannot calculate immediately 3*(1+2) */
    public int calculate(String s) {
        s = s.replace(" ","");
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        int len = s.length();
        int i = 0;
        while (i < len) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '+' || cur == '-') {
                stack.push(cur + "");
                i++;
            } else if (Character.isDigit(cur)) {
                String num = getNextInt(s, i);
                stack.push(num);
                i += num.length();
            } else if (cur == '*' || cur == '/') {
                if (!Character.isDigit(s.charAt(i + 1))) {
                    stack.push(cur + "");
                    i++;
                    continue;
                }
                int pre = Integer.valueOf(stack.pop());
                String ss = getNextInt(s, i + 1);
                int next = Integer.valueOf(ss);
                i += (1 + ss.length());
                if (cur == '*') {
                    stack.push(pre * next + "");
                }
                if (cur == '/') {
                    stack.push(pre / next + "");
                }
            } else if (cur == ')') {
                int tmp = 0;
                while (!stack.isEmpty()) {
                    int val = Integer.valueOf(stack.pop());
                    if (stack.peek().equals("(")) {
                        tmp += val;
                        stack.pop();
                        break;
                    } else if (stack.peek().equals("+")) {
                        tmp += val;
                        stack.pop();
                    } else if (stack.peek().equals("-")) {
                        tmp -= val;
                        stack.pop();
                    } else if (stack.peek().equals("*")) {
                        stack.pop();
                        stack.push(val * Integer.valueOf(stack.pop()) + "");
                    } else if (stack.peek().equals("/")) {
                        stack.pop();
                        stack.push(Integer.valueOf(stack.pop()) / val + "");
                    }
                }
                stack.push(tmp + "");
                i++;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            int val = Integer.valueOf(stack.pop());
            if (!stack.isEmpty() && stack.peek().equals("-")) {
                res -= val;
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek().equals("+")) {
                res += val;
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek().equals("*")) {
                stack.pop();
                stack.push(Integer.valueOf(stack.pop()) * val + "");
            } else if (!stack.isEmpty() && stack.peek().equals("/")) {
                stack.pop();
                stack.push(Integer.valueOf(stack.pop()) / val + "");
            }
            if (stack.isEmpty()) {
                res += val;
            }
        }
        return res;
    }

    private String getNextInt(String s, int i) {
        int num = s.charAt(i) - '0';
        while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
            num *= 10;
            num += (s.charAt(i + 1) - '0');
            i++;
        }
        return num + "";
    }

    public static void main(String[] args) {
        String s = "(  ( ( (   5 +6) * (5  +1 )   )   -   ((   5   -   8 ) +( 1*3  )  ) )*( 1 *4   )  )";// "2*(5+5*2)/3+(6/2+8)";
        BasicCalculator_III cal = new BasicCalculator_III();
        System.out.println(cal.calculate(s));
    }
}
