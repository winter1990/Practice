package practice.leetcode.easy;

/**
 * positive, 0, negative
 *
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n % 2 != 0) {
            return false;
        } else if (n < 5) {
            return n % 2 == 0;
        }
        return isPowerOfTwo(n / 2);
    }

    /**
     * in bit, only one '1' => 0...1...
     * n-1 must be 0...0111\
     * n&(n-1) must be 0
     *
     */
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
