package practice.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @search
 *
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Input: "()())()", Output: ["()()()", "(())()"]
 * Input: "(a)())()", Output: ["(a)()()", "(a())()"]
 * Input: ")(", Output: [""]
 *
 * problems to solve:
 * 1. determine whether we can remove the current char
 * 2. how many we can remove
 * 3. make sure the final string and substring is balanced
 *
 * two cases that may break the balance of the string
 * 1. (
 * 2. )
 * if we count left and right:
 * counter increases when (, decrease when ). if counter negative, then we know ) is breaking the balance
 * to make it balanced, we need to remove a ), and any one in prefix will work EXCEPT the consecutive ones (()))
 *
 * recursively check and remove the ) in substring
 * we also need to keep track of the last removal position, otherwise, duplicates will be generated
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        Set<String> set = new HashSet<>();
        dfs(s, 0, new StringBuilder(), l, r, 0, set);
        return new ArrayList<>(set);
    }

    private void dfs(String s, int index, StringBuilder sb, int l, int r, int countLeft, Set<String> set) {
        if (l < 0 || r < 0 || countLeft < 0) return;
        if (index == s.length()) {
            if (l == 0 && r == 0 && countLeft == 0) set.add(sb.toString());
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            dfs(s, index + 1, sb, l - 1, r, countLeft, set);
            dfs(s, index + 1, sb.append(c), l, r, countLeft + 1, set);
        } else if (c == ')') {
            dfs(s, index + 1, sb, l, r - 1, countLeft, set);
            dfs(s, index + 1, sb.append(c), l, r, countLeft - 1, set);
        } else {
            dfs(s, index + 1, sb.append(c), l, r, countLeft, set);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        String s = "()())()";
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        System.out.println(r.removeInvalidParentheses(s));
    }
}
