package practice.leetcode.easy;

import java.util.Stack;

/**
 * @stack
 * @string
 *
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) return "";
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else {
                while(!stack.isEmpty() && c == stack.peek()) stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public String removeDuplicates1(String S) {
        if (S == null || S.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (sb.length() > 0 && c == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String removeDuplicates2(String S) {
        char[] cs = S.toCharArray();
        int last = -1;
        for (char c : cs) {
            if (last >= 0 && c == cs[last]) {
                --last;
            } else {
                cs[++last] = c;
            }
        }
        return String.valueOf(cs, 0, last + 1);
    }
}
