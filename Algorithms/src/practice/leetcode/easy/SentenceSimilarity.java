package practice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @string
 * @hash
 *
 * "great acting skills" and "fine drama talent" are similar,
 * if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]]
 * relation is not transitive
 * similarity is symmetric
 *
 * use some ds to track the 'similarity':
 * mapping relationship, example: [a b] [b c] [b d], does not work
 *
 * build up string, put in set
 * a/b b/c b/d
 */
public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (String[] strs : pairs) {
            set.add(strs[0] + "/" + strs[1]);
        }

        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i])
                    && !set.contains(words1[i] + "/" + words2[i])
                    && !set.contains(words2[i] + "/" + words1[i])) {
                return false;
            }
        }
        return true;
    }
}
