package practice.leetcode.hard;

/**
 * @string
 *
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.
 * (The occurrences may overlap.)
 *
 * Return any duplicated substring that has the longest possible length.
 * (If S does not have a duplicated substring, the answer is "".)
 *
 * Input: "banana"
 * Output: "ana"
 *
 * brute force
 * i = [0, n-1]         start position
 *   j = [i+1, n-1)     substring
 *     k = [i+1, n-(j-i)) start of next same substring
 * O(N^3) TLE
 *
 *
 */
public class LongestDuplicateSubstring {

    public String longestDupSubstring1(String S) {
        int n = S.length();
        String res = "";
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                String sub = S.substring(i, j);
                for (int k = i + 1; k < n - j + i; k++) {
                    if (S.indexOf(sub, k) >= 0) {
                        if (sub.length() > res.length()) res = sub;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestDuplicateSubstring l = new LongestDuplicateSubstring();
        System.out.println(l.longestDupSubstring1("banana"));
    }
}
