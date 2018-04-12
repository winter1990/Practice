package practice.leetcode.medium;

import java.util.*;

/**
 * @String
 * @array
 * @map
 *
 * similarity relation is transitive [a b][b c][c d][d e] => [a e]
 * Similarity is also symmetric
 * a word is always similar with itself
 *
 * [a,b][b,c][c,d][d,e]
 * build map
 * [a,b][b,ac][c,bd][d,ce][e,d]
 *
 * [a,c][b,c][c,d]
 * [a,c][c,a b d][b,c][d c]
 *
 *
 * example: [a b] [b c] [b d] [d e] [f b], the map becomes:
 * i=0 [a a] [b b] => [a b] [b b]
 * i=1 [a b] [b b] [c c] => [a b] [b c] [c c]
 * i=2 [a b] [b c] [c c] => [a b] [b c] [c d] (although input is [b d], but here we update the entry where the key is c) [d d]
 * …
 * eventually, the may is like a chain: a->b->c->d->e->f
 * when we search word a and d for example, it keeps search until reaching the f (for both of them),
 * which means these two words are in the same “chain”
 */
public class SentenceSimilarity_II {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new HashSet<>());
            }
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new HashSet<>());
            }
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }
            if (!map.containsKey(words1[i]) || !map.containsKey(words2[i])) {
                return false;
            }
            if (!dfs(map, words1[i], words2[i], new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<String, Set<String>> map, String start, String end, Set<String> set) {
        if (map.get(start).contains(end)) {
            return true;
        }
        set.add(start);
        for (String neighbor : map.get(start)) {
            if (!set.contains(neighbor) && dfs(map, neighbor, end, set)) {
                return true;
            }
        }
        return false;
    }

    public boolean areSentencesSimilarTwo1(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, String> map = new HashMap<>();
        for (String[] pair : pairs) {
            String s1 = dfs(map, pair[0]);
            String s2 = dfs(map, pair[1]);
            if (!s1.equals(s2)) {
                map.put(s1, s2);
            }
        }

        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i]) && !dfs(map, words1[i]).equals(dfs(map, words2[i]))) {
                return false;
            }
        }
        return true;
    }

    private String dfs(Map<String, String> map, String s) {
        if (!map.containsKey(s)) {
            map.put(s, s);
        }
        return s.equals(map.get(s)) ? s : dfs(map, map.get(s));
    }
}
