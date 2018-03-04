package practice.leetcode.ez;

/**
 * Iterate until there is no carry (or b == 0)
 * 10101
 * 11001
 *
 * 10001 carry=a&b
 * 01100 a=a^b
 *100010 b=carry<<1
 *
 *
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
