package practice.leetcode.easy;

/**
 * @string
 * @stack
 *
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings,
 * and + represents string concatenation.
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B,
 * with A and B nonempty valid parentheses strings.
 * Input: "(()())(())" Output: "()()()"
 * Input: "(()())(())(()(()))" Output: "()()()()(())"
 * Input: "()()" Output: ""
 *
 * we always ignore the first left and last right
 * count the left parenthesis
 */
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder();
        int l = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && l++ > 0) res.append('(');
            if (c == ')' && l-- > 1) res.append(')');
        }
        return res.toString();
    }

    public String removeOuterParentheses1w(String S) {
        StringBuilder sb = new StringBuilder();
        for (int pre = 0, i = 0, count = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                sb.append(S.substring(pre + 1, i));
                pre = i + 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses r = new RemoveOutermostParentheses();
        String s = "(()())(())(()(()))";
        System.out.println(r.removeOuterParentheses(s));
    }
}
