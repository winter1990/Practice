package practice.leetcode.medium;

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
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < w.length() && w.charAt(i) == c) i++;
            }
            if (i == w.length()) return w;
        }
        return "";
    }

    public String findLongestWord1(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
            }
            if (i == dictWord.length() && dictWord.length() >= longest.length())
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0) longest = dictWord;
        }
        return longest;
    }
}
