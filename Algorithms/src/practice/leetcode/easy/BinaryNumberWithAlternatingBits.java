package practice.leetcode.easy;

/**
 * @bitwise
 *
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will
 * always have different values.
 *
 * n = 1010 -> 10
 * n >>1 = 101
 * n ^ (n >> 1) should be all 1s
 */
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits1(int n) {
        n ^= (n >> 1);
        return ((n + 1) & n) == 0;
    }
}
