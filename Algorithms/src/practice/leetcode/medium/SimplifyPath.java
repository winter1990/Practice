package practice.leetcode.medium;

import java.util.Stack;

/**
 * @string
 * @stack
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * single dot - ignore
 * double dpt - back to upper level
 * multiple slash - ignore
 * start with /
 * end with folder name
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : strs) {
            if (s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (s.length() > 0) {
                stack.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("/");
        }
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath("/home"));
    }
}
