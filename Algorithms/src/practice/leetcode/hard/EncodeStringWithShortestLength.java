package practice.leetcode.hard;

/**
 * @string
 * @dp
 *
 * https://leetcode.com/problems/encode-string-with-shortest-length/discuss/95599/Accepted-Solution-in-Java
 *
 * aaa -> aaa, 3[a] not getting shorter
 * aaaaa -> 5[a]
 * aaaaaaaaaa -> 10[a], a9[a], 9[a]a are all ok
 * aabcaabcd -> 2[aabc]d
 * abbbabbbcabbbabbbc -> 2[2[abbb]c]
 *
 * problem to solve:
 * 1. determine if a substring can be encoded
 * 2. find the previous same substring
 * 3. nested encoded string deabcccccabccccc -> de2[ab5[c]]
 *
 * deabcccccabccccc
 *
 * dp array - String[][]
 * dp[i][j] represents the substring [i,j]
 * substring = s.substring(i,j+1)
 * if sub len < 4, dp[i][j] = sub
 * else
 *
 *
 * dp[i][j] is the string [i,j], with encoded format
 * dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j])
 */
public class EncodeStringWithShortestLength {
    public String encode(String s) {
        if (s == null || s.length() < 4) return s;
        int n = s.length();
        String[][] dp = new String[n][n];
        for (int len = 0; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                String sub = s.substring(i, j + 1);
                if (j - i < 4) {
                    dp[i][j] = sub;
                } else {
                    dp[i][j] = sub;
                    for (int k = 0; k < sub.length() / 2; k++) {
                        String repeatStr = sub.substring(0, k + 1);
                        if (repeatStr != null && sub.replaceAll(repeatStr, "").length() == 0) {
                            String ss = sub.length() / repeatStr.length() + "[" + dp[i][i + k] + "]";
                            if (ss.length() < dp[i][j].length()) dp[i][j] = ss;
                        }
                    }
                    for (int k = i; k < j; k++) {
                        if ((dp[i][k] + dp[k + 1][j]).length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "abbbabbbcabbbabbbc";
//        String s = "aaaaaa";
        EncodeStringWithShortestLength en = new EncodeStringWithShortestLength();
        System.out.println(en.encode(s));
    }
}
