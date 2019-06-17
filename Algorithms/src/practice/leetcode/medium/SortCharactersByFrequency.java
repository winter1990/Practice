package practice.leetcode.medium;


import java.util.*;

/**
 * @sort
 * @bucketsort
 *
 * use can use a map to kee track of the frequency for each chr in str
 * create a bucket array
 *   to handle the multiple chars with same freq, use an array of list
 *   length of list - s.length + 1
 * for each character in the map, put chars in the array
 * iterate from last to first
 *   for each char in the list, append i times
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        List<Character>[] list = new List[s.length() + 1];
        for (char c : freq.keySet()) {
            int f = freq.get(c);
            if (list[f] == null) list[f] = new ArrayList<>();
            list[f].add(c);
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
