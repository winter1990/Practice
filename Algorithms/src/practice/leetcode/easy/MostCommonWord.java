package practice.leetcode.easy;

import java.util.*;

/**
 * @string
 * @hash
 *
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.
 * The answer is in lowercase.
 *
 * problems to solve:
 * 1. count the frequency of not banned words
 * 2. quick lookup for the banned words
 * 3. handle the upper/lower case
 * 4. trim the paragraph/word by removing the special characters
 *
 * pre-process the paragraph
 *   use regex to trim all the symbols -> replaceAll()
 *   get the lists of words (lower case)
 * use a set to store all the banned words
 * keep track of the highest freq
 * for each word:
 *   not banned
 *     update frequency map
 *     check and compare with current max frequency
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.length() == 0) return "";
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
