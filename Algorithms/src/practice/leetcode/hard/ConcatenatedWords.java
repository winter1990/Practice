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
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            set.remove(word);
            if (dfs(word, set, "")) res.add(word);
            set.add(word);
        }
        return res;
    }

    private boolean dfs(String word, Set<String> set, String pre) {
        if (!pre.equals("")) set.add(pre);
        if (set.contains(word)) return true;
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (set.contains(prefix) && dfs(word.substring(i), set, pre + prefix)) return true;
        }
        return false;
    }

    /**
     * @dp
     *
     * similar with word break
     */
    public List<String> findAllConcatenatedWordsInADict1(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, (s1, s2) -> (s1.length() - s2.length()));
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) res.add(words[i]);
            preWords.add(words[i]);
        }
        return res;
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

    public List<String> findAllConcatenatedWordsInADict2(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length <= 1) return res;
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String w : words) {
            if (!w.equals("") && canConcatenate(w, set)) res.add(w);
        }
        return res;
    }

    private boolean canConcatenate(String w, Set<String> set) {
        set.remove(w);
        int n = w.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(w.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        set.add(w);
        return dp[n];
    }

    public static void main(String[] args) {
        ConcatenatedWords c = new ConcatenatedWords();
        System.out.println(c.findAllConcatenatedWordsInADict2(new String[]{"", "cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
    }
}
