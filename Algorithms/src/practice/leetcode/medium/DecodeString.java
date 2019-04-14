package practice.leetcode.medium;

import java.util.Stack;

/*
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

/**
 * @string
 * @stack
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 * types of characters in the string:
 * [ ] digit letter
 *
 * problem to solve:
 * 1. repeat the substring in bracket[...]
 * 2. nested brackets 3[2[ab]5[c]]
 *    so when scan the string, store the number and backtrack later
 *    use two stacks
 *      one for track the number of repeated substring
 *      one for storing the substring
 *
 * scan through the string:
 * if digit, update value and continue
 * if char, push into the stack
 * if [, the end of number, push number into count stack
 * if ], get the whole substring
 * if no [], just add to string builder
 *
 * 2[abc]3[cd2[a]]ef -> 2 push append*3
 */
public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
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
                for (int i = 0; i < repeat; i++) sb.append(cur);
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
