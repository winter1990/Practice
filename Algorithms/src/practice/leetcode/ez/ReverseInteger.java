package practice.leetcode.ez;

/**
 * @math
 *
 * integer - negative, 0, positive, overflow
 *
 * 123
 * - mod 10 to get 3, add to result*10, 123/10
 * - when x = 0, stop
 * - if result > MAX/10
 * - negative can be handled properly -1%10=-1
 * - use abs to check overflow problem
 */

public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
            if (Integer.MAX_VALUE / 10 < Math.abs(res)) {
                return 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = -2147483412;
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(i));
    }
}
