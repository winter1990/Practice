package practice.leetcode.easy;

/**
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 * no loop&recursion
 * 1 3 9 27 81 243
 *
 */

public class PowerOfThree {
    public boolean isPowerOfThree1(int n) {
        if (n < 1) {
            return false;
        } else if (n == 1) {
            return true;
        }
        while (n != 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public boolean isPowerOfThree2(int n) {
        return n > 0 && (Math.pow(3, 19) % n == 0);
    }
}
