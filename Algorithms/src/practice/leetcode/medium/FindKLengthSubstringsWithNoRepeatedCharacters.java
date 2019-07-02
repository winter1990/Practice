package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @string
 * @slidingwindow
 *
 * Given a string S, return the number of substrings of length K with no repeated characters.
 *
 * Input: S = "havefunonleetcode", K = 5, Output: 6
 * havef
 *  avefu
 *   vefun
 *    efuno
 *         etcod
 *          tcode
 */
public class FindKLengthSubstringsWithNoRepeatedCharacters {
    public static int numKLenSubstrNoRepeats(String S, int K) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; j < S.length(); j++) {
            char c = S.charAt(j);
            if (!set.add(c)) {
                while (S.charAt(i) != c) {
                    set.remove(S.charAt(i));
                    i++;
                }
                i++;
            }
            if (set.size() == K) {
                count++;
            } else if (set.size() > K) {
                set.remove(S.charAt(i));
                count++;
                i++;
            }
        }
        return count;
    }

    public static int numKLenSubstrNoRepeats1(String S, int K) {
        int count = 0, i = 0;
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < S.length(); j++) {
            while (set.contains(S.charAt(j))) {
                set.remove(S.charAt(i++));
            }
            set.add(S.charAt(j));
            count += j - i + 1 >= K ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numKLenSubstrNoRepeats("home", 5));
    }
}
