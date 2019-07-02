package practice.leetcode.hard;

/**
 * @string
 *
 * Return the result of evaluating a given boolean expression, represented as a string.
 *
 * An expression can either be:
 *
 * "t", evaluating to True;
 * "f", evaluating to False;
 * "!(expr)", evaluating to the logical NOT of the inner expression expr;
 * "&(expr1,expr2,...)", evaluating to the logical AND of 2 or more inner expressions expr1, expr2, ...;
 * "|(expr1,expr2,...)", evaluating to the logical OR of 2 or more inner expressions expr1, expr2, ...
 *
 * Input: expression = "!(f)"
 * Output: true
 *
 * Input: expression = "|(f,t)"
 * Output: true
 *
 * Input: expression = "&(t,f)"
 * Output: false
 *
 * Input: expression = "|(&(t,f,t),!(t))"
 * Output: false
 *
 *
 */
public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        return evaluate(expression, 0, expression.length());
    }

    private boolean evaluate(String exp, int start, int end) {
        if (exp.substring(start, end).equals("f")) {
            return false;
        } else if (exp.substring(start, end).equals("t")) {
            return true;
        }
        char op = exp.charAt(start);
        boolean res = op == '&';
        for (int i = start + 2, left = i, level = 0; i < end; i++) {
            char c = exp.charAt(i);
            if (level == 0 && (c == ',' || c == ')')) {
                boolean cur = evaluate(exp, left, i);
                left = i + 1;
                if (op == '&') {
                    res &= cur;
                } else if (op == '|') {
                    res |= cur;
                } else if (op == '!') {
                    res = !cur;
                }
            }
            if (c == '(') level++;
            if (c == ')') level--;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "|(&(t,f,t),!(t))";
        ParsingABooleanExpression p = new ParsingABooleanExpression();
        System.out.println(p.parseBoolExpr(s));
    }
}
