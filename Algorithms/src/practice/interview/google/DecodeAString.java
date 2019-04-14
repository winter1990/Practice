package practice.interview.google;

import java.util.Stack;

/**
 * xy[cd]2e -> xycdcd2e
 * xy[cd[i]4]2e -> xycdiiiicdiiiie
 */
public class DecodeAString {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        Stack<StringBuilder> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count *= 10;
                count += c - '0';
            } else {
                if (count != 0) {
                    StringBuilder cur = sb;
                    sb = stack.pop();
                    for (int i = 0; i < count; i++) sb.append(cur);
                    count = 0;
                }
                if (c == '[') {
                    stack.push(sb);
                    sb = new StringBuilder();
                } else if (c == ']') {
                    continue;
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public String decodeString1(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(c);
            } else if (Character.isDigit(c)) {
                count *= 10;
                count += c - '0';
                if (i == n - 1 || (i != n - 1 && !Character.isDigit(s.charAt(i + 1)))) {
                    StringBuilder tmp = new StringBuilder();
                    for (int k = 0; k < count; k++) {
                        tmp.append(stack.peek());
                    }
                    stack.pop();
                    stack.push(tmp.toString());
                }
            } else if (c == '[') {
                stack.push(sb.toString());
                stack.push("[");
                sb = new StringBuilder();
            } else if (c == ']') {
                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                stack.push(sb.toString());
                sb = new StringBuilder();
                count = 0;
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.append(sb).toString();
    }

    public static void main(String[] args) {
        String s = "aa[bc[i]4a]2rr";
        DecodeAString sf = new DecodeAString();
        System.out.println(sf.decodeString1(s));
        System.out.println(sf.decodeString(s));
    }
}
