package practice.interview.google;

import java.util.Stack;

/**
 * + + 3 2 1
 * + 24 + 1 2
 * - 5 + 1 2
 *
 */
public class EvaluationStatement {
    public int evaluate(String s) throws Exception {
        String[] strs = s.split(" ");
        Stack<String> stack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        int value = 0;
        for (int i = 0; i < strs.length; i++) {
            if (Character.isDigit(strs[i].charAt(0))) {
                if (i != 0 && Character.isDigit(strs[i - 1].charAt(0))) {
                    int a = intStack.pop();
                    int b = Integer.valueOf(strs[i]);
                    String operator = stack.pop();
                    value = calculate(operator, b, a);
                    intStack.push(value);
                } else {
                    intStack.push(Integer.valueOf(strs[i]));
                }
            } else {
                stack.push(strs[i]);
            }
        }
        while (!stack.isEmpty()) {
            value = calculate(stack.pop(), intStack.pop(), intStack.pop());
            intStack.push(value);
        }
        return value;
    }

    private int calculate(String operator, int b, int a) throws Exception {
        int value = 0;
        if (operator.equals("+")) {
            value = a + b;
        } else if (operator.equals("-")) {
            value = a - b;
        } else if (operator.equals("*")) {
            value = a * b;
        } else {
            if (b != 0) {
                value = a / b;
            } else {
                throw new Exception("invalid dividant");
            }
        }
        return value;
    }
    public static void main(String[] args) throws Exception {
        String s = "* 2 + 3 - 4 2";
        EvaluationStatement e = new EvaluationStatement();
        System.out.println(e.evaluate(s));
    }
}
