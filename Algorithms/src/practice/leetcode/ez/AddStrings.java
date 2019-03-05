package practice.leetcode.ez;

/**
 * @string
 * @math
 *
 * align the last digit of two strings -> start from the len1-i and len2-i
 * because 999 + 1, we need to keep calculating until the leftmost digit of longer string of the two
 * out of bound case -> each time, check i < len1 and i < len2, then get the value -> convert char to integer
 * carry = 0, carry = sum / 10, value = sum % 10, add value to the head of the result string
 * at last check value of carry
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        } else if (num2 == null || num2.length() == 0) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int n1 = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int n2 = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            int val = n1 + n2 + carry;
            sb.insert(0, val % 10);
            carry = (n1 + n2 + carry) / 10;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
