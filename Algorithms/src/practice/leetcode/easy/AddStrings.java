package practice.leetcode.easy;

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
        int carry = 0, m = num1.length(), n = num2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(m, n); i++) {
            int v1 = i >= m ? 0 : num1.charAt(m - i - 1) - '0';
            int v2 = i >= n ? 0 : num2.charAt(n - i - 1) - '0';
            int sum = v1 + v2 + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry == 1) sb.insert(0, 1);
        return sb.toString();
    }
}
