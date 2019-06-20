package practice.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @string
 *
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some
 * characters of the given string. If there are more than one possible results, return the longest word with the smallest
 * lexicographical order. If there is no possible result, return the empty string.
 * Example 1:
 * Input: s = "abpcplea", d = ["ale","apple","monkey","plea"] Output: "apple"
 *
 * for two strings (s, word):
 *   the order of chars in word, must be the same in s
 *   for each char in s, if same with word(i), i++ check if i == word.len
 * for string[]:
 *   longest & lexicographical -> sort by length, if same length, a.compareTo(b)
 *
 * Space O(m)
 * time O(mnk+nlogn)
 */
public class LongestWordInDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        for (String w : d) {
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == w.charAt(j)) j++;
                if (j == w.length()) return w;
            }
        }
        return "";
    }

    public String findLongestWord1(String s, List<String> d) {
        String res = "";
        for (String word : d) {
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                if (j < word.length() && s.charAt(i) == word.charAt(j)) j++;
                if (j == word.length()) break;
            }
            if (j == word.length()) {
                if (word.length() > res.length()) {
                    res = word;
                } else if (word.length() == res.length()) {
                    res = res.compareTo(word) < 0 ? res : word;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestWordInDictionarythroughDeleting l = new LongestWordInDictionarythroughDeleting();
        String s = "abpcplea";
        List<String> list = Arrays.asList("a", "b", "c");
        System.out.println(l.findLongestWord1(s, list));
    }
}
