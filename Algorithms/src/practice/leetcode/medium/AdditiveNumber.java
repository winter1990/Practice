package practice.leetcode.medium;

/**
 * @backtracking
 *
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each
 * subsequent number in the sequence must be the sum of the preceding two.
 *
 * define three pointers:
 * a = 0, b = 1, c = 2
 * iteratively get the substring [a,b) [b,c)
 * add two strings and check if the substring [c,) start with the sum
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 2) return false;
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (i > 1 && num.charAt(0) == '0') return false;
            for (int j = 1; n - j - i >= Math.max(i, j); j++) { // 6 2 1
                if (num.charAt(i) == '0' && j > 1) break;
                if (isAdditive(num, num.substring(0, i), num.substring(i, i + j), i + j)) return true;
            }
        }
        return false;
    }

    private boolean isAdditive(String n, String a, String b, int index) {
        if (index == n.length()) return true;
        String sum = sum(a, b);
        return n.substring(index).startsWith(sum) && isAdditive(n, b, sum, index + sum.length());
    }

    private String sum(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int m = i >= a.length() ? 0 : a.charAt(a.length() - 1 - i) - '0';
            int n = i >= b.length() ? 0 : b.charAt(b.length() - 1 - i) - '0';
            int sum = m + n + carry;
            carry = sum / 10;
            sb.insert(0, sum % 10);
        }
        if (carry != 0) sb.insert(0, carry);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "991100";
        AdditiveNumber a = new AdditiveNumber();
        System.out.println(a.isAdditiveNumber(s));
    }
}
