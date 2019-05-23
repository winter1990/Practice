package practice.leetcode.easy;

import java.util.Stack;

/**
 * @stack
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        if (S == null || S.length() < 2) return S;
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }

    public String removeDuplicates1(String S) {
        if (S == null || S.length() < 2) return S;
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int len = sb.length();
            if (len > 0 && c == sb.charAt(len - 1)) {
                sb.deleteCharAt(len - 1);
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
