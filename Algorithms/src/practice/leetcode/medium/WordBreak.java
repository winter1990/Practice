package practice.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @dp
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words
 *
 * intuitive solution:
 * recursively check substring
 * this will fail if the string is to long
 * aaaaaaaaaaaaaaaaaaaaaaaaaa...,[a,aa,aa,aaa]
 *
 * optimization:
 * use an array - boolean[n+1]
 * dp[i] means the substring(0, i) can be segmented into one or multiple words
 * initialize start point 0 true
 * i = [1, n] - current substring [0, i)
 *   j = [0,i)
 *     if dp[j] = true and the substring [j,i) contains in the dictionary
 *     then it means the substring [0,i) can be divided into multiple
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
        if (s == null || s.length() == 0) return true;
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
