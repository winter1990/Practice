package practice.leetcode.easy;

/**
 * @string
 * @math
 *
 * align two strings' last character
 * start with the last digit
 * the length of two strings might be different, so when the index is out of boundary, make it 0
 * i = [0, max(len1, len2)), get char of s1 and s2, each time check i < len1 and len2
 * if in bound, then get char, otherwise 0
 * use carry in case 1+1
 * at last, in case carry = 1, check carry and add to head
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(l1, l2); i++) {
            int val1 = i < l1 ? a.charAt(l1 - 1 - i) - '0' : 0;
            int val2 = i < l2 ? b.charAt(l2 - 1 - i) - '0' : 0;
            int val = val1 + val2 + carry;
            carry = val / 2;
            val %= 2;
            sb.insert(0, val);
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
