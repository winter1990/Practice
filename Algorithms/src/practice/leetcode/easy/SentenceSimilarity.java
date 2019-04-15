package practice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @string
 * @hash
 *
 * "great acting skills" and "fine drama talent" are similar,
 * if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]]
 * Note that the similarity relation is not transitive
 * similarity is symmetric
 *
 * problem to solve:
 * 1. keep track of the similar pairs ofr quick lookup - pair of words is a mapping relation
 *    the relation is key value pair, but map cannot handle the symmetric relation
 * 2. as the relation is not transitive, a pair is fixed -> find a separator, some special char
 *    [word1,word2] -> concatenate as w1+w2 separated by special char -> put in Set
 * 3. find the pair in set: w1/w2 or w2/w1
 * 4. same words can be treated as similar
 *
 * pre-process all the pairs
 * scan through two string[]
 *   check whether equal
 *   w1/w2 w2/w1, check if exists in set
 */
public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Set<String> set = new HashSet<>();
        for (String[] p : pairs) set.add(p[0] + "/" + p[1]);
        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i], w2 = words2[i];
            if (!w1.equals(w2) && !set.contains(w1 + "/" + w2) && !set.contains(w2 + "/" + w1)) return false;
        }
        return true;
    }
}
