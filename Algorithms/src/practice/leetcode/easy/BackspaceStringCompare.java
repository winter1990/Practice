package practice.leetcode.easy;

import java.util.Stack;

/**
 * @string
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 * follow up: Can you solve it in O(N) time and O(1) space?
 *
 * method 1: stack
 * push if not #
 * pop if not empty
 *
 * method 2: substring
 * if no extra data structure is allowed, we can do it in place -> if #, concatenate two substrings (check 0 and n-1)
 *
 * method 3: two pointers
 * start from last character in each string
 * skip/delete all chars in two strings:
 *   either one is < 0, false
 *   both are < 0, true
 *   S[p1] != T[p2], false
 * need to count the number of #
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare2(String S, String T) {
        int c1 = 0, c2 = 0;
        for (int i1 = S.length() - 1, i2 = T.length() - 1; i1 >= 0 || i2 >= 0; i1--, i2--) {
            while (i1 >= 0 && (c1 > 0 || S.charAt(i1) == '#')) {
                if (S.charAt(i1) == '#') {
                    c1++;
                } else {
                    c1--;
                }
                i1--;
            }
            while (i2 >= 0 && (c2 > 0 || T.charAt(i2) == '#')) {
                if (T.charAt(i2) == '#') {
                    c2++;
                } else {
                    c2--;
                }
                i2--;
            }
            if (i1 < 0 && i2 < 0) return true;
            if (i1 < 0 || i2 < 0) return false;
            if (S.charAt(i1) != T.charAt(i2)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "bdc##";
        String s2 = "";
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        System.out.println(backspaceStringCompare.backspaceCompare2(s1,s2));
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

    /**
     * @stack
     * use two stacks and if # then check if stack is empty and pop()
     * otherwise push in to stack
     * at last, build up two strings and compare
     * time O(m+n), space O(m+n)
     */
    public boolean backspaceCompare1(String S, String T) {
        S = trim(S);
        T = trim(T);
        return S.equals(T);
    }

    private String trim(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }
}
