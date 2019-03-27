package practice.leetcode.ez;

/**
 * @array
 *
 * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 * After this process, we have some array B.
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 *
 * find the largest and smallest number in the array
 */
public class SmallestRange_I {
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int a : A) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        return K * 2 > max - min ? 0 : max - min - 2 * K;
    }
}
