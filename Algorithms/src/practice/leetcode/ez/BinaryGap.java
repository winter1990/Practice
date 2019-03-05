package practice.leetcode.ez;

/**
 * @bitwise
 *
 * 22 -> 10110, output 2
 * keep shifting to right and & 1
 * if N & 1 == 1
 * two cases: it is the first 1 or we need to calculate the distance
 */
public class BinaryGap {
    public int binaryGap(int N) {
        int count = -32, max = 0;
        while (N != 0) {
            if ((N & 1) == 1) {
                max = Math.max(max, count);
                count = 0;
            }
            count++;
            N >>= 1;
        }
        return max;
    }
}
