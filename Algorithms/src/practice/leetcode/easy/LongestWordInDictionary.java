package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * return the longest word with the smallest lexicographical order
 * words = ["w","wo","wor","worl", "world"] => "world"
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"] => "apple"
 *
 *
 */
public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String res = "";
        Set<String> set = new HashSet<>();
        for (String s : words) {
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestWordInDictionary longestWordInDictionary = new LongestWordInDictionary();
        String[] strs = {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
        System.out.println(longestWordInDictionary.longestWord(strs));
    }
}
