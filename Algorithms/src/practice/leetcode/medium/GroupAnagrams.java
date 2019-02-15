package practice.leetcode.medium;

import java.util.*;

/**
 * @hashmap
 *
 * for each string, convert to char array and sort the array
 * use the new string as the key
 * value is a list of string
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if (strs == null | strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String t = new String(cs);
            if (!map.containsKey(t)) {
                List<String> list = new LinkedList<>();
                list.add(s);
                map.put(t, list);
            } else {
                map.get(t).add(s);
            }
        }
        res.addAll(map.values());
        return res;
    }
}
