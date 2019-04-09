package practice.leetcode.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @string
 * @recursion
 *
 * Input: (add 1 2) Output: 3
 * Input: (mult 3 (add 2 3)) Output: 15
 * Input: (let x 2 (mult x 5)) Output: 10
 * Input: (let x 2 (mult x (let x 3 y 4 (add x y)))) Output: 14
 * Explanation: In the expression (add x y), when checking for the value of the variable x,
 * we check from the innermost scope to the outermost in the context of the variable we are trying to evaluate.
 * Since x = 3 is found first, the value of x is 3.
 *
 * Input: (let x 3 x 2 x) Output: 2 Explanation: Assignment in let statements is processed sequentially.
 * Input: (let x 1 y 2 x (add x y) (add x y)) Output: 5
 * Explanation: The first (add x y) evaluates as 3, and is assigned to x.
 * The second (add x y) evaluates as 3+2 = 5.
 *
 * Input: (let x 2 (add (let x 3 (let x 4 x)) x)) Output: 6
 * Explanation: Even though (let x 4 x) has a deeper scope, it is outside the context of the final x in the add-expression.
 * That final x will equal 2.
 * Input: (let a1 3 b2 (add a1 1) b2) Output 4
 * Explanation: Variable names can contain digits after the first character.
 *
 * use a map to store variable string -> integer
 * possible substring:
 * symbol -> ( or )
 * digit -> 0 - 9
 * letter -> variable name
 *        -> operator (add mult)
 */
public class ParseLispExpression {
    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }

    private int eval(String exp, Map<String, Integer> parent) {
        if (exp.charAt(0) != '(') {
            if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-') return Integer.parseInt(exp);
            return parent.get(exp);
        }
        Map<String, Integer> map = new HashMap<>();
        map.putAll(parent);
        // mult, add or let
        List<String> tokens = parse(exp.substring(exp.charAt(1) == 'm' ? 6 : 5, exp.length() - 1));
        if (exp.startsWith("(a")) { // add
            return eval(tokens.get(0), map) + eval(tokens.get(1), map);
        } else if (exp.startsWith("(m")) { // mult
            return eval(tokens.get(0), map) * eval(tokens.get(1), map);
        } else { // let
            for (int i = 0; i < tokens.size() - 2; i += 2) map.put(tokens.get(i), eval(tokens.get(i + 1), map));
            return eval(tokens.get(tokens.size() - 1), map);
        }
    }

    private List<String> parse(String str) {
        List<String> res = new ArrayList<>();
        int par = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') par++;
            if (c == ')') par--;
            if (par == 0 && c == ' ') {
                res.add(new String(sb));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) res.add(new String(sb));
        return res;
    }

    public static void main(String[] args) {
        String s = "(mult 3 (add 2 3))";
        ParseLispExpression p = new ParseLispExpression();
        System.out.println(p.evaluate(s));
    }
}
