package practice.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @string
 *
 * Given a list of words, each word consists of English lowercase letters.
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make
 * it equal to word2.  For example, "abc" is a predecessor of "abac".
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 *
 * Input: ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: one of the longest word chain is "a","ba","bda","bdca".
 *
 * problems to solve:
 * 1. check the predecessor
 * 2. longest string chain
 *
 * sort the array based on length
 * for each word in list, delete each char and check if it exists
 * there might be multiple paths, so need to keep track each of them, using map, string,integer
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) return 0;
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (w1, w2) -> (w1.length() - w2.length()));
        int max = -1;
        for (String w : words) {
            if (map.containsKey(w)) continue;
            map.put(w, 1);
            StringBuilder sb = new StringBuilder(w);
            for (int i = 0; i < w.length(); i++) {
                sb.deleteCharAt(i);
                String pre = sb.toString();
                if (map.containsKey(pre)) map.put(w, map.get(pre) + 1);
                sb.insert(i, w.charAt(i));
            }
            max = Math.max(max, map.get(w));
        }
        return max;
    }

    public static void main(String[] args) {
        String[] s = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj",
                "ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        LongestStringChain l = new LongestStringChain();
        System.out.println(l.longestStrChain(s));
    }
}
