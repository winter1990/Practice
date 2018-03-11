package practice.leetcode.medium;

import java.util.Stack;

/*
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

/**
 * scan through the string
 * digit [ ] character
 * digit - keep scanning because it can multiple multiple characters
 * char  - keep scanning, use sb to track
 * [     - get the number and push in the stack 2[3[4[ab]cd]]
 * ]     - get the string
 *         2[a2[b]c]
 */
public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num *= 10;
                num += c - '0';
            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else if (c == '[') {
                intStack.push(num);
                strStack.push(sb);
                num = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder cur = sb;
                sb = strStack.pop();
                int repeat = intStack.pop();
                for (int i = 0; i < repeat; i++) {
                    sb.append(cur);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "2[a2[b]c]";
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString(s));
    }
}
