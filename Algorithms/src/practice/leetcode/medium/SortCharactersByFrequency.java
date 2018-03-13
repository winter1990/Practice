package practice.leetcode.medium;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * bucket sort:
 * initialize a array of lists List<Char>[] - size is s.len
 * iterate s, user map to track freq
 * iterate from last to first, get freq and repeat
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!freq.containsKey(c)) {
                freq.put(c, 1);
            } else {
                freq.put(c, freq.get(c) + 1);
            }
        }
        List<Character>[] list = new List[s.length() + 1];
        for (char c : freq.keySet()) {
            int fre = freq.get(c);
            if (list[fre] == null) list[fre] = new LinkedList<>();
            list[fre].add(c);
        }

        StringBuilder res = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] != null) {
                for (char c : list[i]) {
                    for (int count = 0; count < i; count++) {
                        res.append(c);
                    }
                }
            }
        }
        return res.toString();
    }
}
