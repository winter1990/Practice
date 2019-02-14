package practice.leetcode.medium;

/**
 * @string
 * @math
 *
 * all the possible input:
 * Input: "   -42" Output: -42
 * Input: "4193 with words" Output: 4193
 * Input: "words and 987" Output: 0
 * Input: "-91283472332" Output: -2147483648
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int sign = 1;
        int res = 0;
        int i = 0;
        str = str.trim();
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '+' ? 1 : - 1;
            i++;
        }
        while (i < str.length() && (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9)) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res *= 10;
            res += (str.charAt(i) - '0');
            i++;
        }
        return res * sign;
    }
}
