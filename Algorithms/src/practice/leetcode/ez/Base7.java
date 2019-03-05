package practice.leetcode.ez;

/**
 * @math
 *
 * in term of the integer -> positive, negative and 0
 * need to deal with the negative number first
 * -10 % 7 = -3
 * -10 % -7 = -3
 */
public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean isPositive = true;
        if (num < 0) {
            isPositive = false;
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        return (isPositive ? "" : "-") + sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(-10 % -7);
        System.out.println(-10 % 7);
    }
}
