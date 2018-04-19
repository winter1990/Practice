package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @string
 * @bitwise
 *
 */
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) {
            res.add("");
            return res;
        }
        int n = word.length();
        int size = (int) Math.pow(2, n);
        for (int i = 1; i <= size; i++) {
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (((i >> j) & 1) == 1) {
                    cnt++;
                    if (j == 0) sb.append(cnt);
                } else {
                    if (cnt != 0) {
                        sb.append(cnt);
                    }
                    sb.append(word.charAt(n - 1 - j));
                    cnt = 0;
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    /* not really the problem means
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) {
            return res;
        }
        int n = word.length();
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                res.add(word.substring(0, i) + len + word.substring(i + len));
            }
        }
        return res;
    }
    */

    public static void main(String[] args) {
        GeneralizedAbbreviation g = new GeneralizedAbbreviation();
        System.out.println(g.generateAbbreviations("word"));
    }
}
