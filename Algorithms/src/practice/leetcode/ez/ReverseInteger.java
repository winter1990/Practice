package practice.leetcode.ez;

/*
 * always think about overflow issue for number related problem
 */

public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (Integer.MAX_VALUE / 10 < Math.abs(res)) {
                return 0;
            }
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
