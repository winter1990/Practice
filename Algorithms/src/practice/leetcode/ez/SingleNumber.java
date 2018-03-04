package practice.leetcode.ez;

/**
 * bit operation
 * a^a = 0
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return Integer.MIN_VALUE;
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res ^= A[i];
        }
        return res;
    }
}
