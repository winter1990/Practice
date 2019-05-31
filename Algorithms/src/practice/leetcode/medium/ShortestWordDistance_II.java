package practice.leetcode.medium;

import java.util.*;

public class ShortestWordDistance_II {
}

/**
 * @array
 *
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words
 * word1 and word2 and return the shortest distance between these two words in the list.
 * Your method will be called repeatedly many times with different parameters.
 *
 * the meaning of calling method repeatedly:
 * initialize and calculate once, reuse the data
 *
 * we call shortest(w1, w2) repeatedly with different strings
 * use a map to store string and list of indices (sorted)
 * when calling the method, we get two lists, start with 0 for both, move the smaller and get the difference
 */
class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.computeIfAbsent(words[i], l -> new ArrayList<>()).add(i);
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i1, i2;
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            i1 = list1.get(i);
            i2 = list2.get(j);
            if (i1 < i2) {
                res = Math.min(res, i2 - i1);
                i++;
            } else {
                res = Math.min(res, i1 - i2);
                j++;
            }
        }
        return res;
    }
}
