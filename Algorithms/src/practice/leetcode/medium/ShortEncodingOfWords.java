package practice.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @string
 *
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
 * For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].
 * Input: words = ["time", "me", "bell"]
 * Output: 10
 * Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 *
 * # means end of word(s)
 * indexes are the start of word(s)
 *
 * problems to solve:
 * 1. determine if words can be encoded
 * 2. post-fix of words
 */
public class ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String w : words) { // use words instead of set to avoid concurrent modify exception
            for (int i = 1; i < w.length(); i++) set.remove(w.substring(i));
        }
        int res = 0;
        for (String s : set) res += s.length() + 1;
        return res;
    }
}
