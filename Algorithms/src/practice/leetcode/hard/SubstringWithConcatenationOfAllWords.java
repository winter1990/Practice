package practice.leetcode.hard;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<Integer>();
        int lens = s.length();
        int lenWord = words[0].length();
        int numWord = words.length;
        if (numWord == 0) {
            return res;
        }
        Map<String, Integer> lmap = new HashMap<String, Integer>();
        Map<String, Integer> smap = new HashMap<String, Integer>();

        for (String str : words) {
            addToMap(lmap, str);
        }

        for (int i = 0; i <= lens - numWord * lenWord; i++) {
            smap.clear();
            int j;
            for (j = i; j < i + lenWord * numWord; j += lenWord) {
                String sub = s.substring(j, j + lenWord);
                if (lmap.containsKey(sub)) {
                    addToMap(smap, sub);
                    if (smap.get(sub) > lmap.get(sub)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j == i + lenWord * numWord) {
                res.add(i);
            }
        }
        return res;
    }

    private void addToMap(Map<String, Integer> map, String s) {
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
    }
}
