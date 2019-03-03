package practice.leetcode.ez;

import java.util.*;

/**
 * @string
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * conditions:
 * exactly once
 * not appear in other sentence
 *
 * two maps method is trivial
 * if they combined, we only need one map
 * for the strings that frequency is 1, add to result
 */
public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : (A + " " + B).split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                list.add(word);
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
