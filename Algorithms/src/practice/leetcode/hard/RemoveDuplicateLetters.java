package practice.leetcode.hard;

import java.util.Stack;

/**
 * @string
 *
 * Given a string which contains lowercase letters, remove duplicate letters so that every letter appear only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Given "bcabc" Return "abc"
 * Given "cbacdcbc" Return "acdb"
 *
 * problems to solve:
 * 1. remove duplicates
 * 2. result is in smallest lexicographical order
 *
 * #1 is straightforward, use count[] for frequency for each character
 * cbeacdbac -> beacd
 * #2 lexicographical order
 * need to track back the previous characters one by one
 *   if current char is smaller, and there are more in the later chars, remove it
 *   it is the reason to think about using stack for 'backtracking'
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        boolean[] isVisited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (isVisited[c - 'a']) continue;
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                isVisited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            isVisited[c - 'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "cbeacdbac";
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        System.out.println(r.removeDuplicateLetters(s));
    }
}
