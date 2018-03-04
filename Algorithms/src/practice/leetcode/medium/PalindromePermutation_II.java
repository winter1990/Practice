package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * scan and use map to track the freq - abbcc a1 b2 c2
 * recursively build the string
 */
public class PalindromePermutation_II {
    int count = 0;
    char single = ' ';
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        if (!isValid(map)) {
            return res;
        }
        if (single == ' ') {
            helper(s,"", map, res);
        } else {
            map.put(single, map.get(single) - 1);
            helper(s, "" + single, map, res);
        }
        return res;
    }

    private boolean isValid(Map<Character, Integer> map) {
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                single = c;
                count++;
            }
        }
        return count <= 1;
    }

    private void helper(String s, String str, Map<Character, Integer> map, List<String> res) {
        if (str.length() == s.length()) {
            res.add(str);
            return;
        }
        for (char c : map.keySet()) {
            if (map.get(c) > 0) {
                map.put(c, map.get(c) - 2);
                helper(s, c + str + c, map, res);
                map.put(c, map.get(c) + 2);
            }
        }
    }

    public static void main(String[] args) {
        PalindromePermutation_II pp = new PalindromePermutation_II();
        String s = "abc";
        System.out.println(pp.generatePalindromes(s));
    }
}
