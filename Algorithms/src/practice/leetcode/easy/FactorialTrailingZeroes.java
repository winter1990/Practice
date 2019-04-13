package practice.leetcode.easy;

/**
 * @math
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * there are always enough 2 and make 5 to become 0 in tail
 * key: numbers that end with 5 and 0 -> rethink, and actually it is the factors of 5 in the number
 * for 10, it equals to 2 * 5, for 25, it is 5 * 5 that makes the trailing one more 0
 * for 125, it will have 3
 * res += n / 5 -> # of 5s, n /= 5
 * res += n / 5 -> # of 25s, n /= 5
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
