package practice.leetcode.easy;

/**
 * @bitwise
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * 0 ≤ x, y < 231.
 *
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int c = 0;
        while (diff != 0) {
            c += diff & 1;
            diff >>= 1;
        }
        return c;
    }

    public int hammingDistance1(int x, int y) {
        int count = 0;
        while (x > 0 || y > 0) {
            int i = x & 1;
            int j = y & 1;
            if ((i ^ j) == 1) {
                count++;
            }
            x >>= 1;
            y >>= 1;
        }
        return count;
    }
}
