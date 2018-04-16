package practice.leetcode.hard;

/**
 * @string
 * @dp
 *
 * aaa -> aaa
 * aaaaa -> 5[a]
 * aaaaaaaaaa -> 10[a], a9[a], 9[a]a are all ok
 * aabcaabcd -> 2[aabc]d
 * abbbabbbcabbbabbbc -> 2[2[abbb]c]
 *
 * dp[i][j] is the string [i,j], with encoded format
 * dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j])
 */
public class EncodeStringWithShortestLength {
    public String encode(String s) {
        if (s == null || s.length() < 4) {
            return s;
        }
        int n = s.length();
        String[][] dp = new String[n][n];
        for (int len = 0; len < n; len++) { // the length of the substring we want to store in dp
            for (int i = 0; i < n - len; i++) { // start position of substring
                int j = i + len; // end position of substring
                String substr = s.substring(i, j + 1);
                if (j - i < 4) { // aaa -> 3[a], not compressed so store and continue
                    dp[i][j] = substr;
                } else {
                    dp[i][j] = substr;
                    for (int k = 0; k < substr.length() / 2; k++) {
                        String repeatStr = substr.substring(0, k + 1);
                        if (repeatStr != null
                                && substr.length() % repeatStr.length() == 0
                                && substr.replaceAll(repeatStr, "").length() == 0) {
                            String ss = substr.length() / repeatStr.length() + "[" + dp[i][i + k] + "]";
                            if (ss.length() < dp[i][j].length()) {
                                dp[i][j] = ss;
                            }
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
        EncodeStringWithShortestLength en = new EncodeStringWithShortestLength();
        System.out.println(en.encode(s));
    }
}
