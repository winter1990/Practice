package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @string
 *
 * Given a string of numbers and operators, return all possible results
 * from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *
 *
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * we need all combinations regardless of the multiplication
 * recursion
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> l = diffWaysToCompute(input.substring(0, i));
                List<Integer> r = diffWaysToCompute(input.substring(i + 1));
                for (int x : l) {
                    for (int y : r) {
                        if (c == '+') {
                            list.add(x + y);
                        } else if (c == '-') {
                            list.add(x - y);
                        } else if (c == '*') {
                            list.add(x * y);
                        }
                    }
                }
            }
        }
        if (input.length() == 0) {
            list.add(0);
        }
        if (list.size() == 0) list.add(Integer.valueOf(input));
        return list;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses dw = new DifferentWaysToAddParentheses();
        String in = "-1";
        System.out.println(dw.diffWaysToCompute(in));
    }
}
