package practice.leetcode.ez;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * factor: end with 5 and 0
 *
 * 10,  0*2
 * 20,  0*4
 * 100, 0*2*10 => n/5 !!!MISSING VALUE - 25!!!
 *
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n/5;
            n /= 5;
        }
        return res;
    }
}
