package practice.leetcode.medium;

import com.sun.deploy.util.StringUtils;

import java.util.Stack;

/**
 * start with first string
 * if number, put in stack
 * if operation, take out
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<>();
        int val = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int n1 = Integer.valueOf(stack.pop());
                int n2 = Integer.valueOf(stack.pop());
                if (tokens[i].equals("+")) {
                    val = n1 + n2;
                } else if (tokens[i].equals("-")) {
                    val = n2 - n1;
                } else if (tokens[i].equals("*")) {
                    val = n1 * n2;
                } else {
                    val = n2 / n1;
                }
                stack.push(Integer.toString(val));
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        String[] strs = {"2", "1", "+", "3", "*"};
        System.out.println(e.evalRPN(strs));
    }
}
