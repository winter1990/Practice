package practice.leetcode.medium;

import java.util.Stack;

/**
 * @string
 *
 * Return the lexicographically smallest subsequence of text that contains all the distinct characters of text exactly once.
 *
 * Input: "cdadabcc", Output: "adbc"
 * Input: "abcd", Output: "abcd"
 * Input: "ecbacba", Output: "eacb"
 * Input: "leetcode", Output: "letcod"
 *
 * we want to start from the lowest lexical order, but we can not miss any char and all should be included in the res
 * keep track of the rightmost index of each character in the string
 * 01234567
 * cdadabcc
 *
 * csacdac
 */
public class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String text) {
        int[] count = new int[26];
        int n = text.length();
        for (int i = 0; i < n; i++) count[text.charAt(i) - 'a']++;
        boolean[] isVisited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            --count[c - 'a'];
            if (isVisited[c - 'a']) continue;
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                isVisited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            isVisited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }
}
