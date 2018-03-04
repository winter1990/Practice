package practice.leetcode.medium;

import java.util.*;

public class ShortestWordDistance_II {
}

/**
 * the meaning of calling method repeatedly:
 * initialize and calculate onece, use forever
 *
 * use map to store all the
 */
class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                List<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(words[i], list);
            } else {
                map.get(words[i]).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i1;
        int i2;
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size();) {
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
