package practice.leetcode.hard;

import java.util.*;

/**
 * @string
 *
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the
 * given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 *
 * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 *
 * array of word -> for quick look up, add into set
 * recursively get substring and check whether exists in set
 * if exist, in next recursive call, get the substring and check -> (word, set, )
 */
public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String w : words) set.add(w);
        for (String word : words) {
            set.remove(word);
            if (dfs(word, set, "")) list.add(word);
            set.add(word);
        }
        return list;
    }

    private boolean dfs(String word, Set<String> set, String previous) {
        if (!previous.equals("")) set.add(previous);
        if (set.contains(word)) return true;
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (set.contains(prefix) && dfs(word.substring(i, word.length()), set, previous + prefix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @dp
     *
     * similar with word break
     */
    public List<String> findAllConcatenatedWordsInADict1(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) result.add(words[i]);
            preWords.add(words[i]);
        }
        return result;
    }

    private boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
