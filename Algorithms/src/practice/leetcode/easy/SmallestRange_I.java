package practice.leetcode.easy;

/**
 * @array
 *
 * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 * After this process, we have some array B.
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 *
 * we can choose any value [-k,k] and add to A[i]:
 * to handle each value, we need to:
 *   make the small value increase
 *   make the large value decrease
 * we can get the largest and smallest numbers in the array and compare the different:
 *   larger than 2K, max-min-2K
 *   smaller than 2K, 0
 */
public class SmallestRange_I {
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int a : A) {
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        return Math.max(0, max - min - 2 * K);
    }
}
