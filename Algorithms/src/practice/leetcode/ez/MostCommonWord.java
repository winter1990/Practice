package practice.leetcode.ez;

import java.util.*;

/**
 * @string
 * @map
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) {
            return "";
        }
        paragraph = paragraph.replaceAll("[!?',;.]", "");
        String[] words = paragraph.toLowerCase().split(" ");
        String res = "";
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        int max = 0;
        for (String word : words) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (map.get(word) > max) {
                    res = word;
                    max = map.get(word);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = ".,.ad?.s'!f;";
        s = s.replaceAll("[.?',;!]", "");
        System.out.println(s);
    }
}