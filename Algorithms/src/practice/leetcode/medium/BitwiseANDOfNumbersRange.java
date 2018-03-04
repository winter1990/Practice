package practice.leetcode.medium;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 *
 * 5,6,7 101,110,111->100
 * 3,4 11,100->0000
 * find the common header
 */
public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int i = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i <<= 1;
        }
        return i * m;
    }
}
