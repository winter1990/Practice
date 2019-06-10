package practice.interview.google;

import java.util.Stack;

/**
 * assaaaaaassaa
 */
public class RemoveThreeConsecutiveCharsInString {
    public String removeDup(String s) {
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 || stack.isEmpty() || c != (char)('a' + stack.peek()[0])) {
                stack.push(new int[]{c - 'a', 1});
            } else if (c == (char) (stack.peek()[0] + 'a')) {
                stack.peek()[1]++;
                if (i != s.length() - 1 && s.charAt(i) != s.charAt(i + 1) && stack.peek()[1] >= 3) {
                    stack.pop();
                }
            }
        }
        if (stack.peek()[1] >= 3) stack.pop();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            for (int i = 0; i < cur[1]; i++) {
                sb.insert(0, (char) ('a' + cur[0]));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveThreeConsecutiveCharsInString r = new RemoveThreeConsecutiveCharsInString();
        System.out.println(r.removeDup("abbssaaaasssbbbbdea"));
    }
}
