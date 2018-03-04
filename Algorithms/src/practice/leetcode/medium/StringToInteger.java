package practice.leetcode.medium;

/**
 * all the possible input:
 * 1234
 * 0123
 * 1000
 * long string
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
        System.out.println("res="+res);
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        res *= flag;
        return (int)res;
    }

    public static void main(String[] args) {
        String s = "9223372036854775809";
        StringToInteger sti = new StringToInteger();
        System.out.println(sti.myAtoi(s));
    }
}
