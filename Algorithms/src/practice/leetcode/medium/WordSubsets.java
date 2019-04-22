package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @string
 *
 * say that word b is a subset of word a if every letter in b occurs in a
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 * Return a list of all universal words in A.  You can return the words in any order.
 *
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * Output: ["facebook","google"]
 *
 * think about the complexity at the beginning
 *
 *
 */
public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        int[] total = new int[26], tmp;
        for (String b : B) {
            tmp = count(b);
            for (int i = 0; i < 26; i++) total[i] = Math.max(total[i], tmp[i]);
        }
        int i;
        for (String a : A) {
            tmp = count(a);
            i = 0;
            for (; i < 26; i++) {
                if (total[i] > tmp[i]) break;
            }
            if (i == 26) res.add(a);
        }
        return res;
    }

    private int[] count(String s) {
        int[] res = new int[26];
        for (char c : s.toCharArray()) res[c - 'a']++;
        return res;
    }

    // time waste a lot doing the copy
    public List<String> wordSubsets1(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        for (String a : A) {
            int[] cs = new int[26];
            for (char c : a.toCharArray()) cs[c - 'a']++;
            int i = 0;
            for (; i < B.length; i++) {
                int[] checker = Arrays.copyOf(cs, cs.length);
                int j = 0;
                for (; j < B[i].length(); j++) {
                    char b = B[i].charAt(j);
                    checker[b - 'a']--;
                    if (checker[b - 'a'] < 0) break;
                }
                if (j != B[i].length()) break;
            }
            if (i == B.length) res.add(a);
        }
        return res;
    }

    public static void main(String[] args) {
        WordSubsets w = new WordSubsets();
        String[] A = {"amazon","apple","facebook","google","leetcode"};
        String[] B = {"lo","eo"};
        System.out.println(w.wordSubsets(A, B));
    }
}
