package practice.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same
 * shifting sequence.
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output:[["abc","bcd","xyz"], ["az","ba"], ["acef"], ["a","z"]]
 *
 * find the key to compare between strings:
 *   abc 11, xyz 11, yza 24 25 0, each time (c[i]-c[i-1]+26)%26
 * map<string,List<>>
 * for each string
 *   start with 1 to n-1, calculate the diff, diff = (c[i]-c[i-1] + 26) % 26
 *   if map contains the str, add
 *   if not contains, create new list and add
 * add all to result
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new LinkedList<>();
        if (strings == null || strings.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                int diff = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
                sb.append(diff).append(" ");
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

    public List<List<String>> groupStrings1(String[] strings) {
        return new ArrayList(Stream.of(strings).collect(Collectors.groupingBy(
                s -> s.chars().mapToObj(c -> (c - s.charAt(0) + 26) % 26)
                        .collect(Collectors.toList())
        )).values());
    }

    public static void main(String[] args) {
        GroupShiftedStrings g = new GroupShiftedStrings();
        String[] ss = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z", "ace", "aw", "bdf","za","ab"};
        System.out.println(g.groupStrings(ss));
    }
}
