package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @string
 * @backtracking
 * @recursion
 *
 * aab
 * aa,b
 * a,a,b
 *
 * recursively get substring and check whether the substring is a palindrome
 * if true, put in a sublist
 * check whether it's palindrome
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        helper(s, 0, new LinkedList<String>(), res);
        return res;
    }

    private void helper(String s, int index, LinkedList<String> list, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(index, i))) {
                list.add(s.substring(index, i));
                helper(s, i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
