package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results
 * from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *
 *
 * numbers separate by operators
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String a = input.substring(0, i);
                String b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a);
                List<Integer> bl = diffWaysToCompute(b);
                for (int x : al) {
                    for (int y : bl) {
                        if (c == '-') {
                            res.add(x - y);
                        } else if (c == '+') {
                            res.add(x + y);
                        } else if (c == '*') {
                            res.add(x * y);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses dw = new DifferentWaysToAddParentheses();
        String in = "2*3-1";
        System.out.println(dw.diffWaysToCompute(in));
    }
}
