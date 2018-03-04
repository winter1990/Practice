package practice.leetcode.medium;

import java.util.*;

/**
 * hashmap
 * for each string, tochararray and sort
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
                List<String> list = new LinkedList<String>();
                list.add(s);
                map.put(t, list);
            } else {
                map.get(t).add(s);
            }
        }
        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] in = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(ga.groupAnagrams(in));
    }
}
