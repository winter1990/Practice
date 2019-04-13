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
        for (int p1 = S.length() -1, p2 = T.length() - 1; p1 >= 0 || p2 >= 0; p1--, p2--) {
            while (p1 >= 0 && (c1 != 0 || S.charAt(p1) == '#')) {
                if (S.charAt(p1) == '#') {
                    c1++;
                } else {
                    c1--;
                }
                p1--;
            }
            while (p2 >= 0 && (c2 != 0 || T.charAt(p2) == '#')) {
                if (T.charAt(p2) == '#') {
                    c2++;
                } else {
                    c2--;
                }
                p2--;
            }
            if (p1 < 0 && p2 < 0) return true;
            if (p1 < 0 || p2 < 0) return false;
            if (S.charAt(p1) != T.charAt(p2)) return false;
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
