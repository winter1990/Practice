package practice.leetcode.ez;

import java.util.Stack;

/**
 * @string
 *
 * follow up: Can you solve it in O(N) time and O(1) space?
 *
 * if no extra space is required, we can only do it in place -> concatenate the substring
 * start from 0
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (true) {
            for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); i--) {
                back += S.charAt(i) == '#' ? 1 : -1;
            }
            for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); j--) {
                back += T.charAt(j) == '#' ? 1 : -1;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }
    }

    public boolean backspaceCompare(String S, String T) {
        S = getTrim(S);
        T = getTrim(T);
        return S.equals(T);
    }

    private String getTrim(String s) {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                if (i == 0) {
                    s = s.substring(1);
                } else if (i == s.length() - 1){
                    return s.substring(0, i - 1);
                } else {
                    s = s.substring(0, i - 1) + s.substring(i + 1);
                    i --;
                }
            } else {
                i++;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s1 = "bbd##c";
        String s2 = "bc#c";
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        System.out.println(backspaceStringCompare.backspaceCompare2(s1,s2));
    }

    /**
     * use two stacks and if # then pop() otherwise push in to stack
     */
    public boolean backspaceCompare1(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                stack1.push(c);
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }
        for (char c : T.toCharArray()) {
            if (c != '#') {
                stack2.push(c);
            } else {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }
        if (stack1.size() != stack2.size()) {
            return false;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (!stack1.isEmpty()) {
            sb1.append(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            sb2.append(stack2.pop());
        }
        return sb1.toString().equals(sb2.toString());
    }
}
