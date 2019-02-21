package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @dp
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words
 *
 * recursively check substring
 * this will fail if the string is to long
 * aaaaaaaaaaaaaaaaaaaaaaaaaa...,[a,aa,aa,aaa]
 *
 * optimized:
 * use a boolean array, size = n + 1
 * i = [1, n] - current substring (0,i)
 * j=[0,i-1] - (0,j) can be segmented, check (i,j) if contains, [i] true
 * initialize start point 0 true
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }


    /**
     * recursively check substring
     * this will fail if the string is to long
     * aaaaaaaaaaaaaaaaaaaaaaaaaa...,[a,aa,aa,aaa]
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return helper(s, 0, wordDict);
    }

    private boolean helper(String s, int index, List<String> dict) {
        if (index == s.length()) {
            return true;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(index, i))) {
                if(helper(s, i, dict)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcodee";
        List<String> list = new LinkedList<>();
        list.add("leet");
        list.add("code");
        list.add("de");
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak(s, list));
    }
}
