package practice.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
[ ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"] ]
 */

/**
 * map<string,List<>>
 * for each string,second-first
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new LinkedList<>();
        if (strings == null || strings.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                int diff = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
                sb.append(diff);
            }
            if (map.containsKey(sb.toString())) {
                map.get(sb.toString()).add(s);
            } else {
                List<String> list = new LinkedList<>();
                list.add(s);
                map.put(sb.toString(), list);
            }
        }
        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        GroupShiftedStrings g = new GroupShiftedStrings();
        String[] ss = {"a", "b"};
        System.out.println(g.groupStrings(ss));
    }
}
