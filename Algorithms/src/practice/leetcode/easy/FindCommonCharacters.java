package practice.leetcode.easy;

import java.util.*;

/**
 * @string
 *
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all
 * strings within the list (including duplicates).
 * Input: ["bella","label","roller"], Output: ["e","l","l"]
 * Input: ["cool","lock","cook"], Output: ["c","o"]
 *
 * for each character, get the frequency and compare with the previous one
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (int i = 0; i < A.length; i++) {
            char[] cs = new char[26];
            for (char c : A[i].toCharArray()) cs[c - 'a']++;
            for (int j = 0; j < 26; j++) count[j] = Math.min(count[j], cs[j]);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) res.add("" + (char) ('a' + i));
        }
        return res;
    }

    public static void main(String[] args) {
        FindCommonCharacters fc = new FindCommonCharacters();
        String[] in = {"cool","lock","cook"};
        System.out.println(fc.commonChars(in));
    }
}
