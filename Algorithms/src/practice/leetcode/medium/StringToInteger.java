package practice.leetcode.medium;

/**
 * @string
 * @math
 *
 * all the possible input:
 * 1234
 * 0123
 * 1000
 * long string, over Integer.MAX
 * 000
 * +-
 *      123
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        int i = 0;
        int flag = 1;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            flag = -1;
            i++;
        }
        double res = 0;

        while (i < str.length() && str.charAt(i) - '0' <= 9 && str.charAt(i) - '0' >= 0) {
            res *= 10;
            res += str.charAt(i) - '0';
            i++;
        }
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        res *= flag;
        return (int)res;
    }

    public int myAtoi2(String str) {
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

    public static void main(String[] args) {
        String s = "1";
        StringToInteger sti = new StringToInteger();
        System.out.println(sti.myAtoi2(s));
    }
}
