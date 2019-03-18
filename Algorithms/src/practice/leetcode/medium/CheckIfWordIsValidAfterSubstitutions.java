package practice.leetcode.medium;

import java.util.Stack;

/**
 * @string
 *
 * S = "abc"
 * examples of valid strings are: "abc", "aabcbc", "abcabc", "abcabcababcc".
 * examples of invalid strings are: "abccba", "ab", "cababc", "bac".
 *
 * method 1
 * find and replace using regex
 * if we can find abc in the string, replace it with empty string, until we replace all the abc
 * check is string is empty at last
 * keep searching in string O(N) and replace O(mn)
 *
 * method 2
 * if not using the build in method
 * aabcbc is valid -> backtracking the previous characters sequence
 * if a or b, push into stack
 * if c, previous two must be b, then a
 */
public class CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String S) {
        String a = "abc";
        while (S.contains(a)) S = S.replace("abc", "");
        return S.isEmpty();
    }

    public boolean isValid1(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') return false;
                if (stack.isEmpty() || stack.pop() != 'a') return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
