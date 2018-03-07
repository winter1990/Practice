package practice.leetcode.medium;

/**
 *   a h b g d c
 * a t t t t t t
 * b f f t t t t
 * c f f f f f t
 *
 *   b a h b e b c
 * a f t t t t t t
 * b f f f t t t t
 * c f f f f f f t
 */
public class IsSubsequence {
    public boolean isSubsequence1(String s, String t) {
        if (s.length() == 0) {
            return true;
        } else if (t.length() < s.length()) {
            return false;
        }
        int is = 0;
        int it = 0;
        while (it < t.length()) {
            if (s.charAt(is) == t.charAt(it)) {
                is++;
            }
            if (is == s.length()) {
                return true;
            }
            it++;
        }
        return false;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        } else if (t.length() < s.length()) {
            return false;
        }
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = s.charAt(0) == t.charAt(0);
        for (int i = 1; i < n; i++) {
            if (dp[0][i - 1] || s.charAt(0) == t.charAt(i)) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j - 1] || (dp[i - 1][j - 1] && s.charAt(i) == t.charAt(j))) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        String s = "bcd";
        String t = "xxxbcd";
        IsSubsequence is = new IsSubsequence();
        System.out.println(is.isSubsequence1(s, t));
    }
}