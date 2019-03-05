package practice.leetcode.ez;

import java.util.Stack;

/**
 * @stack
 *
 * Integer, D, +, C
 * + last two valid
 * D double last valid
 * C minus last valid
 *
 * two index not enough because of the case C
 * need new array
 */

public class BaseballGame {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a + b);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public int calPoints1(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        int[] val = new int[ops.length];
        int res = 0;
        int index = -1; // represents the last valid index
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "+":
                    res += (val[index] + val[index - 1]);
                    val[index + 1] = val[index] + val[index - 1];
                    index++;
                    break;
                case "D":
                    res += 2 * val[index];
                    index++;
                    val[index] = 2 * val[index - 1];
                    break;
                case "C":
                    res -= val[index];
                    index--;
                    break;
                default:
                    res += Integer.valueOf(ops[i]);
                    index++;
                    val[index] = Integer.valueOf(ops[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] input1 = {"5","2","C","D","+"}; // 5 5+2=7 7-2=5 5+5*2=15 15+(5+15)=30
        String[] input2 = {"5","-2","4","C","D","9","+","+"}; // 5 5-2=3 3+4=7 7-4=3 3-4=-1 -1+9=8 8+(-4+9)=13 13+(9+5)=27
        BaseballGame baseballGame = new BaseballGame();
        System.out.println(baseballGame.calPoints1(input1));
        System.out.println(baseballGame.calPoints1(input2));
    }
}
