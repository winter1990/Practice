package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @string
 *
 * A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query.
 * (We may insert each character at any position, and may insert 0 characters.)
 *
 * problem to solve:
 * 1. need to match all the char in pattern
 * 2. only lowercase
 * 3. any number of chars and any positions, but the order of pattern is same
 *
 * for each char in query:
 *   match -> j++ (index in pattern)
 *
 */
public class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            int i = 0, j = 0;
            for (; i < q.length(); i++) {
                char c = q.charAt(i);
                if (j < pattern.length() && c == pattern.charAt(j)) {
                    j++;
                } else if (!(c >= 'a' && c <= 'z')) {
                    break;
                }
            }
            if (i == q.length() && j == pattern.length()) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CamelcaseMatching c = new CamelcaseMatching();
        String[] qq = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String p = "FoBaT";
        System.out.println(c.camelMatch(qq, p));
    }
}
