package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @string
 *
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in
 * the pattern with p(x), we get the desired word.
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb", Output: ["mee","aqq"]
 *
 * if pattern is abac, then first and third character in the string must also the same
 * mapping relation between char to char
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character, Character> charMap;
        Map<Character, ArrayList<Integer>> patternIndex = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!patternIndex.containsKey(c)) {
                patternIndex.put(c, new ArrayList<>());
            }
            patternIndex.get(c).add(i);
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (word.length() != pattern.length()) {
                continue;
            }
            charMap = new HashMap<>();
            int i = 0;
            while (i < word.length()) {
                char c = word.charAt(i);
                if (charMap.containsKey(c) && !patternIndex.get(charMap.get(c)).contains(i)) break;
                charMap.put(c, pattern.charAt(i));
                if (!patternIndex.get(charMap.get(c)).contains(i)) break;
                i++;
            }
            if (charMap.size() == patternIndex.size() && i == word.length()) res.add(word);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] ss = {"dkd","abc","deq","mee","aqq","ccc"};
        String p = "abb";
        FindAndReplacePattern f = new FindAndReplacePattern();
        System.out.println(f.findAndReplacePattern(ss, p));
    }
}
