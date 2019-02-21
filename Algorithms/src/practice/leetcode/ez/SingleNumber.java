package practice.leetcode.ez;

/**
 * @bitwise
 *
 * bit operation
 * based on the principle: a ^ a = 0
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
