package practice.leetcode.ez;

/**
 * @string
 * @math
 *
 * start from last char, when one number = 0, keep moving index
 * always compare the index value with length
 * at last, check carry
 *  1111
 * + 101
 * 10100
 *
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        int l1 = a.length();
        int l2 = b.length();
        int carry = 0;
        String res = "";
        for (int i = 0; i < len; i++) {
            int val1 = i < l1 ? a.charAt(l1 - 1 - i) - '0' : 0;
            int val2 = i < l2 ? b.charAt(l2 - 1 - i) - '0' : 0;
            int val = val1 + val2 + carry;
            carry = val / 2;
            val %= 2;
            res = val + res;
        }
        if (carry != 0) {
            res = 1 + res;
        }
        return res;
    }
}
