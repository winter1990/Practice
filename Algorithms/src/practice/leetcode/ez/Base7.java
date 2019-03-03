package practice.leetcode.ez;

/**
 * @math
 *
 * in term of the integer -> positive, negative and 0
 */
public class Base7 {
    public String convertToBase7(int num) {
        boolean isPositive = true;
        if (num < 0) {
            isPositive = false;
            num = -num;
        }
        int k = 7;
        while (k <= num) {
            k *= 7;
        }
        k /= 7;
        StringBuilder sb = new StringBuilder();
        while (k != 0) {
            sb.append(num / k);
            num = num % k;
            k /= 7;
        }
        return (isPositive ? "" : "-") + sb.toString();
    }

    public static void main(String[] args) {
        Base7 b = new Base7();
        System.out.println(b.convertToBase7(-7));
    }
}
