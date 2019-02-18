package practice.leetcode.medium;

/**
 * @string
 * @dp
 *
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * 12 -> 2, A+B or L
 * 226 -> 3, BBF or VF or BZ
 *
 * number of ways depends on previous char and number of decoding ways - dynamic programming
 * count[i] is # of ways of decoding
 * initialize count[0] = 0/1
 * start with index 1:
 * if [1,9] the same value as i-1
 * if previous 1 or 2 and current value <= 6 then dp[i]+=dp[i-2]
 *
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] count = new int[n];
        count[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) > '0' && s.charAt(i) <= '9') {
                count[i] = count[i - 1];
            }
            if (s.charAt(i - 1) - '0' == 1 || s.charAt(i - 1) - '0' == 2 && s.charAt(i) - '0' <= 6) {
                count[i] += i >= 2 ? count[i - 2] : 1;
            }
        }
        return count[n - 1];
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("01"));
    }
}
