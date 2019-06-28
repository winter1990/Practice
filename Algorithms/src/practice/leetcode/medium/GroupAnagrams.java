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
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String k = new String(cs);
            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
            }
            map.get(k).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (String k : map.keySet()) {
            res.add(map.get(k));
        }
        return res;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] a = new int[26];
            for (int i = 0; i < s.length(); i++) {
                a[s.charAt(i) - 'a']++;
            }
            String k = Arrays.toString(a);
            if (!map.containsKey(k)) map.put(k, new LinkedList<>());
            map.get(k).add(s);
        }
        return new LinkedList<>(map.values());
    }
}
